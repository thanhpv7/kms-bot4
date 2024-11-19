<!-- @bot-written -->
<!-- % protected region % [Configure readme here] off begin -->
# kmsweb

You have complete ownership of the source code the bots write, which means it is customisable and ready to use for any commercial or non-commercial purposes. Below is an overview of the code to help you get started.
This readme is intended to help get you get started, and can be edited to suit your needs at any time.

**Bot version:** 2.5.0.0 ([Release notes can be found here](https://forum.codebots.com/t/springbot-release-2-5-0-0))

## Running your app

We use Docker to enable you to easily run your app locally. To get it running, make sure you have Docker installed on your computer and have the code pulled down from Git. To start the app, use your OS start command script in the [_shortcuts](_shortcuts) folder. Once running, it will be available at [localhost:4200](localhost:4200).

For more detailed instructions on setting up and running with Docker, [go here](https://codebots.com/docs/134)

For instructions on getting it running *without* Docker, have a look at the following articles.  These setup instructions are separated based on your operating system, so have a look at the article best suited to your setup:
* [Windows](https://codebots.com/docs/200)
* [Linux](https://codebots.com/docs/194)
* [Mac](https://codebots.com/docs/199)

Once these instructions have been completed, [you can use these instructions to run your web application](https://codebots.com/docs/192)
This is the recommended method of running your application when writing new code.


## Customising bot written code

The bots work like another member of your team, committing their work to the repo so that you can pull it down. It is important that if you want to keep building with the bots, **you commit and push your code before you build**.  Once the bots have rewritten your code and committed it to the repository, you can pull at any time to get the bot's changes.

### Protected Regions

Wondering how the bots know how to leave your code alone? They use a thing called protected regions. They are areas where you can write code that the bots won't touch. They are scattered just about everywhere throughout the bot-written files, and look something like this:

```
// % protected region % [Add any additional imports here] off begin

// % protected region % [Add any additional imports here] end
```

To use a protected region, change the first comment to say `on` instead of `off`, and the bots will stay away. If you don't turn it on, the bots will keep updating the code inside anytime you build.

For more info on protected regions, [read this article](https://codebots.com/docs/158)

#### Missing a protected region?

Got some code you want to write but no protected region to hold it? You can request new protected regions from our support desk. [Go here for instructions on how to do this](https://codebots.com/docs/157)

### Extensions

Your app is using:
[User](https://codebots.com/docs/113), [Data Table](https://codebots.com/docs/80)
You aren't using:
[Forms](https://codebots.com/docs/98), [Workflow](https://codebots.com/docs/117)

Extensions are how you can add in pre-built functionality into your app. There are a whole range of behaviours you can use. Add them into either the Entity or User Interface diagram and get the bots to build to see how they work.

To find out more about the behaviours your bot offers or how to work with a behaviour you have, have a search for the behaviour's name in the library, or click on one of the links above.

### Components

Components are visual elements which you can reuse throughout your app to make the building process easier. You can use small components like buttons, or large ones like modals, to save yourself some time. A large majority of the components were also designed with accessibility in mind, so if used properly you can help ensure that your app is as accessible as possible.

For a breakdown of the components which are available, as well as instructions on how to reuse them in Springbot, [take a look at this article](https://codebots.com/docs/220).

For more information on the architecture of Springbot, [you can read this article](https://codebots.com/docs/208).

## Server-side

The Server-side is the back end framework which handles data processing and various tasks handled by the server to manage users, data submitted from the client-side and be configured to integrate with external APIs, and ensure application security.

[You can also read this article](https://codebots.com/docs/231) to see the technologies used in the springbot serverside, as well as some information about them, and lessons for how to use them.


## Client-side

Client-side is the interface visitors to your application connect to with their browsers, It is responsible for displaying information to end users and for sending any information they submit to the server for processing.

SpringBot uses `Angular` which is an app-design framework and development platform for creating efficient and sophisticated single-page apps.

For additional information on the technologies used in the springbot clientside, as well as resources for learning how to use them, [you can read this article](https://codebots.com/docs/214).

A simple maintenance task required by developers to perform when first installing the site or when adding a new client-side library is to install the required dependencies or libraries, this can be achieved by running the following command from a terminal in the `clientside` directory

```
yarn
```

## Running tests

The Test target is required to verify the application is running as intended. It consists of a combination of Unit, Integration and end to end tests which cover functionality in both the client and server-side. For more information on the testing technologies used by Springbot, [take a look here](https://codebots.com/docs/254).

### Clientside Tests
To run the client-side tests, navigate to the `clientside` folder and run the following command in your terminal.

```
yarn test
```

### Serverside Tests
To run the Server-side Unit and Integration tests, you can navigate to the `serverside` folder, and run the following command if you are using a mac or linux machine:

```
./gradlew clean build
```

If you are using a windows machine, use this command instead:

```
./gradlew.bat clean build
```

### TestTarget Tests
The testtarget folder contains the end to end tests for your application. In order to run these tests, you first need to ensure that the web application is running, as these tests interact with the website in order to test functionality. Once you have done this, you can navigate to the `testtarget` directory and run the following command on Mac or Linux:

```
./gradlew test
```

If you are using a windows machine, use this command instead:

```
./gradlew.bat test
```

## Support

If you ever get stuck or want to suggest a change, our support team is here to help! To get in contact with our support team (and our greater development community), [join the discussion on our community forum](https://forum.codebots.com/t/195).
<!-- % protected region % [Configure readme here] end -->
