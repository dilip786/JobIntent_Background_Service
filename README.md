### Background Service

A simple android project that demonstrates how to implement background service.


### Android Services

- A service is a android application component that executes the task in the background without effecting the users current activity.
- No user interface is required 
- By Default service runs on Main UI thread (Does not run separate  thread or process)
- ContextWrapper class is super class of Service, Context is super class of ContextWrapper

### Output

![ezgif com-video-to-gif (3)](https://user-images.githubusercontent.com/10658016/67355350-b39e0580-f574-11e9-8fec-ecf791e44749.gif)


### Main UI Thread:

- When we create an android application, the android system will create a default process, i’e default thread is created, This default thread is called as Main Thread or UI thread.
- All the components (Activities, Services, Broadcast Receivers & Services) runs on the same thread that is Main UI thread.
- Apart from the Main thread if we create any thread that we can call it as Background thread or Worker Thread.
- On Main UI thread we can only perform small operations like UI operations, Small Animations, Mathematical or Logical operations.
- Worker thread or Background thread are used to perform long running operations like Upload or Download File, Playing music, Heavy database queries & Network operations.   

### Service Types:

* Started Service ( 1. Foreground Service, 2. Background Service)
* Bound Service
* Intent Service

### Started Service:

- Started service basically can started by android components like Activity, Broadcast  Receiver, Content Provider, Services
- When service started can run in background indefinitely, Even the component that started is also destroyed
- There is always one way communication in case of started service
- 'startservice()' is used to start service & stopservice() or stopself() are used to stop service.
- Runs on Main Ui thread

### Bound Service

- A bound service allows the components (Activities, Services & Content providers) to bind to the service.
- This service exists as long as the there is at least one component bound to it.
- When all the calling components destroyed then the service also destroyed.
- By default it has two communication.
- bindservice() is used to start service & unbindservice() or stopself() are used to stop service.
- Runs on Main Ui thread

### Foreground Service

- This service is always uses the notification to notify the user that some background operation is going on (Such as Play Music, Download files)
- Foreground service is always noticeable to user, That is the user aware of foreground service.
Runs on Main UI thread.

### Background Service

- This Service is not noticeable to the user & this is used to perform some background operations such as Sending email, Receiving whatsapp messages.
- Runs on Main UI thread.

### Intent Service

- This service is advanced form of background service.
- This is Subclass of Service.
- It uses Worker Thread or Background thread by default to perform long running operations, So it runs 
- Use startService() to start service and it stops automatically when task is done.
- It executes one task at a time, If you assign multiple tasks to the same intent service, Then the task will be arranged in - the queue. It handles multi threading internally and saves memory
- onHandleIntent() is default override method in case of Intent Service.
- onStartCommand() method implemented internally & onCreate(), onDestroy(), onBind() are optional

### Service Lifecycle

![adad](https://user-images.githubusercontent.com/10658016/67318530-3d27e600-f529-11e9-87b8-0768c8c27b1f.png)



### How to stop Intent Service:

- Incase of intent service it does not stop or accept new requests through the same intent until it completes its onHandleIntent() competes the previous request.
- If we try to start again same intent-service with same other actions, onHandleIntent() will only called only after when previous request finished.
-Also stopService() or stopSelf() won’t work until onHandleIntent() finishes its task.
- Declare the service as a separate process in the manifest & And when you want to stop its execution, just kill that process. 

### How to send Data to services

- We can send data to service using intent
- There is no default mechanism to return results back from the background service.
- We can use Broadcast receiver to communicate with the service or Intent Service

### Security concerns

- Your service should always be accessible within your own application, Use the following attribute to access only from your 'app- android:exported:”false"'
- Use explicit intent to start service.
- Use LoacalBroadcastReciever to communicate with service ('LocalBroadcastManager.getInstance(this).registerReceiver()')

### Limitations

- Background app cannot use the Intent Service, Only foreground app can only use intent service from Oreo version
- Why such restrictions: Background services consumes more memory, which leads to battery drains. 

### JobIntent Service 

- Modern way to run background service
- It works in all devices (Api > 14)
- It internally uses Job scheduler api.
- It requires WAKE_LOCK & BIND_JOB_SERVICE permissions
- onHandleWork() is default override method.
-It Runs on worker Thread or Background thread.

