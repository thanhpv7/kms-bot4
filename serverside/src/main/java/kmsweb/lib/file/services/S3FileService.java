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
package kmsweb.lib.file.services;

import kmsweb.configs.properties.AwsProperties;
import kmsweb.lib.file.exceptions.FileStorageProviderException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import kmsweb.lib.file.models.FileEntity;
import kmsweb.lib.file.repositories.FileRepository;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import lombok.NonNull;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * File service that specialises in AWS S3 operations. Extending {@link AbstractFileService}, this service provides
 * CRUD operations against files that are stored on AWS S3 buckets.
 */
@Service
@ConditionalOnBean({Region.class, AWSCredentialsProvider.class})
@ConditionalOnProperty(
		value="application.file-service-provider",
		havingValue="s3",
		matchIfMissing = true
)
public class S3FileService extends AbstractFileService<FileEntity> {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end

	private final AwsProperties awsProperties;

	private AmazonS3 s3Client;

	@Autowired
	public S3FileService(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			AwsProperties awsProperties,
			Region awsRegion,
			AWSCredentialsProvider awsCredentialsProvider,
			FileRepository fileRepository
	) {
		super(
				// % protected region % [Add any additional constructor arguments here] off begin
				// % protected region % [Add any additional constructor arguments here] end
				fileRepository
		);

		this.awsProperties = awsProperties;

		// Build S3 Client Interface
		this.s3Client = AmazonS3ClientBuilder
				.standard()
				.withRegion(awsRegion.getName())
				.withCredentials(awsCredentialsProvider)
				.build();

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FileEntity upload(@NonNull FileEntity file) {
		try {
			File tmpFile = File.createTempFile(file.getName(), "");
			String fullContent = file.getContent();
			byte[] content = DatatypeConverter.parseBase64Binary(fullContent.substring(fullContent.indexOf(",") + 1));
			FileUtils.writeByteArrayToFile(tmpFile, content);

			// % protected region % [Add any additional logic for upload before uploading the file here] off begin
			// % protected region % [Add any additional logic for upload before uploading the file here] end

			s3Client.putObject(awsProperties.getS3AudioBucket(), file.getName(), tmpFile);
			file.setUrl(s3Client.getUrl(awsProperties.getS3AudioBucket(), file.getName()).toExternalForm());

			// % protected region % [Add any additional logic for upload before returning the uploaded file here] off begin
			// % protected region % [Add any additional logic for upload before returning the uploaded file here] end

			return fileRepository.save(file);
		} catch (SdkClientException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public FileEntity download(@NonNull UUID id) {
		try {
			// First get the metadata from the database, then fetch the actual content of the file from S3, then return
			// the object with its content.
			FileEntity fileToDownload = fileRepository.findById(id).orElseThrow();
			byte[] content = this.s3Client.getObject(awsProperties.getS3AudioBucket(), fileToDownload.getName()).getObjectContent().readAllBytes();
			fileToDownload.setContent(new String(content));

			// % protected region % [Add any additional logic for download before returning the file here] off begin
			// % protected region % [Add any additional logic for download before returning the file here] end

			return fileToDownload;
		} catch (IOException e) {
			throw new RuntimeException("Unable to read bytes from the file in the bucket");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(@NonNull UUID id) {
		// % protected region % [Replace the defaul delete logic here] off begin
		var entityOpt = this.fileRepository.findById(id);
		if (entityOpt.isPresent()) {
			var fileEntity = entityOpt.get();
			this.s3Client.deleteObject(awsProperties.getS3AudioBucket(), fileEntity.getName());
		} else {
			throw new FileStorageProviderException("File to delete not found");
		}
		// % protected region % [Replace the defaul delete logic here] end
	}

	/**
	 * Generate the URL so that the client can download the file.
	 */
	public String generateUrl(@NonNull UUID id) {
		var url = "";

		// % protected region % [Add any additional logic for generateUrl before the main body here] off begin
		// % protected region % [Add any additional logic for generateUrl before the main body here] end
		var entityOpt = this.fileRepository.findById(id);
		if (entityOpt.isPresent()) {
			var fileEntity = entityOpt.get();
			url = s3Client.generatePresignedUrl(awsProperties.getS3AudioBucket(), fileEntity.getName(), Date.from(OffsetDateTime.now().plus(7, ChronoUnit.DAYS).toInstant())).toExternalForm();
		} else {
			throw new FileStorageProviderException("File not found");
		}
		// % protected region % [Add any additional logic for generateUrl before returning the url here] off begin
		// % protected region % [Add any additional logic for generateUrl before returning the url here] end

		return url;
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}

