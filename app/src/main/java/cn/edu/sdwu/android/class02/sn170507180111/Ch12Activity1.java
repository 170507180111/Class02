package cn.edu.sdwu.android.class02.sn170507180111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ch12Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch12_1);
    }
    public void start_service (View view){
        //使用intent启动服务
        Intent intent=new Intent(this,MyService.class);
        //使用startService以启动方式使用服务
        startService(intent);

    }
    public void stop_service (View view) {
        //停止服务
        Intent intent=new Intent(this,MyService.class);
        stopService(intent);

    }
}
