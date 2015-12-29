package com.track.carshhandler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id
                .main_btn);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Log.d("CarshHandler", "onClick: " + CarshHandler.getLogFilePath()+"-- 获取LogPath路径"+CarshHandler.getLogContent());
                //测试异常...
               int i = 1/0;
            }
        });
    }


}
