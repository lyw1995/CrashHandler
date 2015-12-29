package com.track.carshhandler;

import android.app.Application;
import android.content.Intent;

/**
 * Created by track on 2015/12/28.
 */
public class CarshApplication extends Application implements Thread.UncaughtExceptionHandler {
    @Override
    public void onCreate() {
        super.onCreate();
        // setAppend是否为追加模式, setSimple是否是简单的log信息,
        CarshHandler.init(this, "CarshHandler").setAppend(true).setSimple(false);

        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        // 重启app ..上传日志等...
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
