# CarshHandler
## 用于Android 异常捕捉记录

### 方法介绍:
```java 
 void  setAppend(boolean) instance method 是否为日志追加模式(不覆盖)
 void  setSimple(boolean) instance metohd 精简输出 (不包含exception堆栈信息)
 String  getLogFilePath()   static method   获取日志路径
 String  getLogContent()  static method    获取日志内容
 ```

### 如何使用:
* 1. 可以用于 全局Application中捕捉并记录写入日志, 当前Activity等.
```java 

 CarshHandler.init(this, "CarshHandler").setAppend(true).setSimple(false);
 
 ```
* 2. 与Application中的实现Thread.UncaughtExceptionHandler 不冲突, 可以在哪里进行日志提交,app重启等处理
```java
   @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        // 重启app ..上传日志等...
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
```
![image](img/carshlog.jpg)
