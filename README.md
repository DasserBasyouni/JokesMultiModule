# JokesMultiModule
An app with multiple flavors that uses multiple libraries and Google Cloud Endpoints to show jokes.
- [x] Passed thought [Udacity's PROJECT SPECIFICATION: Build It Bigger rubric](https://review.udacity.com/#!/rubrics/61/view)

## Screenshots
<p align="center"><img src="/pictures/screenshot1.png" width="200"> <img src="/pictures/screenshot2.png" width="200"> <img src="/pictures/screenshot3.png" width="200"> <img src="/pictures/screenshot4.png" width="200"></p>

## What I have learnt from?
- Add free and paid flavors to an app, and set up your build to share code between them
- Factor reusable functionality into a Java library
- Factor reusable Android functionality into an Android library
- Configure a multi project build to compile your libraries and app
- Use the Gradle App Engine plugin to deploy a backend
- Configure an integration test suite that runs against the local App Engine development server

## How does it work?
> Test it on emultors or you will have to change the emulator IP in EndpointsAsyncTask.class line 36

1. [Install the Cloud SDK](https://cloud.google.com/sdk/docs/)
2. [Follow the instructions in the Setup Cloud SDK section](https://cloud.google.com/endpoints/docs/frameworks/java/migrating-android)  
Note: You do not need to follow the rest of steps in the migration guide, only the Setup Cloud SDK.
3. Start or stop your local server by using the gradle tasks as shown in the following screenshot
<p align="center"><img src="/pictures/devappserver-endpoints.png"></p>
4. Once your local GCE server is started you should see the following at [localhost:8080](http://localhost:8080/)
