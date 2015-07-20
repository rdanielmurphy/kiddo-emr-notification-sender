# kiddo-emr-notification-sender

Desktop Java Swing application that sends push notifications to the Android app (kiddo-emr-notification-client).

Here are the steps to use the notification sender application and the notificaion client application:

1.  Set up GCM (Google cloud messaging).  You need a gmail account for this:
  * a. https://console.developers.google.com/project
  * b. Create a new project
  * c. Go to APIs & Auth->APIs->Cloud Messaging Android and Enable it

2.  Replace GCMConstants.PROJECT_API_KEY with your API key found at APIs & Auth->APIs->Credentials

3.  Replace GCMConstants.PROJECT_NUMBER with your Project Number found in the Overview tab (at the top right)

4.  Run the Android app and register the phone to GCM
  a. Click Register For Tips
  b. Click Get RegId.  Copy the key you get in the box and save it for later (email to it yourself is what I would do)

5.  Run the Java Swing app.  
  a. Click Add Phone
  b. Paste code you got from the phone and then click 'Add Phone'

6.  Go back to the Send Message Tab and send a tip!
