
![screenshot_20170420-202535](https://user-images.githubusercontent.com/41565823/47961086-08fba280-e004-11e8-8faa-ffa8b5eeec43.png)
![screenshot_20170420-203130](https://user-images.githubusercontent.com/41565823/47961087-08fba280-e004-11e8-81f0-4e9262f593c7.png)
![screenshot_20170420-203201](https://user-images.githubusercontent.com/41565823/47961088-09943900-e004-11e8-979c-0d239cf27658.png)

This is how the app would look something like, after finsishing. You can improve UI and add more things, this is just a simple, demo implementation of Firebase, for making a real time chat app. 

# Chatting Demo App

This is a demo app requested by people on stack overflow, to show how to create a real time chatting app using Firebase, with source code and necessary starting information below:


**Setting Up Firebase**

First of all, create a firebase account. Follow following steps:

1. Go to Firebase Website firebase.google.com and create a firebase account to start with. Go to Firebase console and Create a New Project by clicking on the “Create New Project” Button as shown below.

![firebase1-2](https://user-images.githubusercontent.com/41565823/47960988-13696c80-e003-11e8-9bc1-5518045a1acb.png)
       
2. Give the Project name and country you are currently in, Once you are done click on “Create Project” button.

![android-chat-application-2](https://user-images.githubusercontent.com/41565823/47960985-13696c80-e003-11e8-8e80-504098bad12b.png)
  

3. In the next screen choose “Add Firebase to your Android app” and then add the package details and Debug signing certificate SHA-1 key( This is required if you want to enable certain features like Dynamic Links, Invites, and Google Sign-In etc. otherwise it is an optional field).

![android-chat-application-3](https://user-images.githubusercontent.com/41565823/47960984-13696c80-e003-11e8-8f2c-1615cf8b3671.png)

This will download the google-services.json file. Download it to your computer. We will add it to our android app later.



4. In the project’s dashboard. Click on Auth Menu, then in the SIGN-IN METHOD click on Email/Password and enable it.

![firebase7](https://user-images.githubusercontent.com/41565823/47960990-14020300-e003-11e8-810e-491c5462dd78.png)

  
This is required because the default security rules for the Android Firebase allows only authenticated users to read and write.

Then click on the Database tab in the Firebase Menu.

It shows the root of the JSON tree, we would be adding a child node called listItems and then will add each item under it. When we add data to the JSON tree, it becomes a new node in the existing JSON structure with an associated key.

Also copy the URL of database.

You can check the Rules tab to see or change the security rules for reading and writing on Android Firebase Database. Below figure shows the default settings.

![5](https://user-images.githubusercontent.com/41565823/47960983-13696c80-e003-11e8-8014-010933ccff69.png)
      
      
You can change these to true, if you want free unauthenticated access to your Firebase. Once you are done with this, Let’s create our Android chat Application that will connect to Firebase Database we have just created and uses Firebase Authentication that we have enabled in the console.


**Creating a new project**

1. Go to File → New → New Project and enter your Application Name.
2. Enter company domain, this is used to uniquely identify your App’s package worldwide. Remember to use the same package name as used in the firebase console.
3. Choose project location and minimum SDK and on the next screen choose Empty Activity, since we would be adding most of the code Ourselves. Then Click on Next.
4. Choose an Activity Name. Make sure Generate Layout File check box is selected, Otherwise we have to generate it ourselves.Then click on Finish.


**Adding permissions and dependencies**

After Gradle syncs the project, add the google-services.json file to your project’s app folder as shown below.

![firebase5](https://user-images.githubusercontent.com/41565823/47960991-14020300-e003-11e8-9077-d45821630baa.png)
  
Since we need to connect to the Network add the Internet permission in AndroidManifest.xml file.

```
<uses-permission android:name="android.permission.INTERNET"/>
```


Next, open your app’s build.gradle and add the following dependencies in the dependencies section:
```
compile 'com.firebase:firebase-client-android:2.5.2+'
compile 'com.android.volley:volley:1.0.0'
```
