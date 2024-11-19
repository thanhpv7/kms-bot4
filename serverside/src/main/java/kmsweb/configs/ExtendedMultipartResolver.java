/*
 * @bot-written
 *
 * WARNING AND NOTICE
 * Any access, download, storage, and/or use of this source code is subject to the terms and conditions of the
 * Full Software Licence as accepted by you before being granted access to this source code and other materials,
 * the terms of which can be accessed on the Codebots website at https://codebots.com/full-software-licence. Any
 * commercial use in contravention of the terms of the Full Software Licence may be pursued by Codebots through
 * licence termination and further legal action, and be required to indemnify Codebots for any loss or damage,
 * including interest and costs. You are deemed to have accepted the terms of the Full Software Licence on any
 * access, download, storage, and/or use of this source code.
 *
 * BOT WARNING
 * This file is bot-written.
 * Any changes out side of "protected regions" will be lost next time the bot makes any changes.
 */

package kmsweb.configs;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ExtendedMultipartResolver extends CommonsMultipartResolver {

	public ExtendedMultipartResolver() {
		super();
	}

	/**
	 * This function overrides the default resolveMultipart function so that the MaxUploadSizeExceededException can be handled appropriately.
	 * By Default, this exception will be thrown and cause an internal server error before any endpoint method is executed.  The method this is overwriting
	 * does not return a response, so we can't return to the client from here.  Therefore we need to build a request which will is then passed as an input to the endpoint.
	 * From the endpoint we can then determine if the request it has received is a valid input or is the result of an error, and then return an appropriate response
	 *
	 * @param request the API request prior to processing the Multipart file
	 * @return A modified request which either contains the file to be uploaded, or an error which can be handled by the endpoint
	 * @throws MultipartException
	 */
	@NotNull
	@Override
	public MultipartHttpServletRequest resolveMultipart(@NotNull final HttpServletRequest request) throws MultipartException {
		Assert.notNull(request, "Request must not be null");
		try {
		   return super.resolveMultipart(request);
		} catch (MaxUploadSizeExceededException e) {
			 /*
				When executing normally, parsing the file creates all of the parameters which are passed to the new request.
				When the upload size error is encountered, these parameters do not exist, so they need to be created.

				We will create the parameters hashmap to contain the error which needs to be returned to the client.
				The endpoint will check the hashmap for the object which we have added, and if it exists the endpoint will
				return BAD_REQUEST and exit
			 */
			HashMap<String, String[]> params = new HashMap<>();

			// The message for the error thrown when parsing has multiple levels of nesting, so it needs to be split so that it is easily readable on the clientside
			// Also need to handle nullPointerException.  While unlikely in this situation, NullPointerException is possible when using split(), so we need to handle it
			if (e.getMessage() == null){
				params.put("fileSizeExceededError", new String[]{"Uploaded file exceeded maximum file size limit"});
			} else {
				params.put("fileSizeExceededError", new String[]{e.getMessage().split(";")[0]});
			}

			HashMap<String, String> contentTypes = new HashMap<>();
			MultiValueMap<String, MultipartFile> files = new LinkedMultiValueMap<>();

			 /*
				A file needs to be passed into the endpoint, or attempting to execute the endpoint will fail due to not being able to find it.
				To solve this we create an empty file which can be passed in.  It will not be used for anything in the endpoint itself, as the endpoint will return
				A BAD_REQUEST response before the file would be accessed
			 */
			final File placeholderFile = new File("src/test/resources/placeholder.csv");
			final DiskFileItem diskFileItem = new DiskFileItem("file", "text/csv", true, placeholderFile.getName(), 100000000, placeholderFile.getParentFile());
			try {
				// Due to internal logic of the DiskFileItem object, the output stream needs to be called before the file can be created
				// getOutputStream sets the size of the file, and if size does not exist creating the file will fail with a nullPointerException
				diskFileItem.getOutputStream();
			} catch (IOException ioException) {
				throw new MultipartException(ioException.getMessage());
			}
			files.add("file", new CommonsMultipartFile(diskFileItem));

			return new DefaultMultipartHttpServletRequest(request, files, params, contentTypes);
		}
	}
}
