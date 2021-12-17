# async-example
This is demo project using @Async concept 
An important element of the async implementation is whether the result is a “wait for”, or a “fire and forget action”.

## 1. Enable Async Support
Let's start by enabling asynchronous processing with Java configuration.
We'll do this by adding the @EnableAsync to a configuration class/Main Class:
```
@SpringBootApplication
@EnableAsync   //Enable Asynchronous processes
public class AsyncExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(AsyncExampleApplication.class, args);
	}
}
 ```
 
## 2.The @Async Annotation
When use @Async then follow below two rules otherwise its don't work
a).method should public
b).Caller and @Async method should not be in same class.

```
@Component
public class SendNotification {
    //Send notification to all employee
    @Async   
    public void sendNotificationSMS(List<Employee> emp) {
             for (Employee e1 : emp){
             try {
	
                System.err.println("SMS Notification send to :" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(20);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //trying to create manual exception which is throw  exception msg
            System.out.println(10/0);
        }
    }
}
 ```
## 3.Exception Handler
  
  We have created a custom async exception handler by implementing AsyncUncaughtExceptionHandler interface.
  The handleUncaughtException() method is invoked when there are any uncaught asynchronous exceptions:
  
  ```
 @Component
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    /**
     * Handle the given uncaught exception thrown from an asynchronous method.
     *
     * @param ex     the exception thrown from the asynchronous method
     * @param method the asynchronous method
     * @param params the parameters used to invoked the method
     */
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {

        System.out.println(" Method name :"+method.getName()+"  ---"+
                Arrays.toString(params) +"  ---"+
        "Error Msg :"+ex.getMessage()

        );

    }


}
```
