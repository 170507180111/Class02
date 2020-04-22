package cn.edu.sdwu.android.class02.sn170507180111;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static cn.edu.sdwu.android.class02.sn170507180111.R.id.text;

public class Ch10Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch10_2);
    }
    public  void send_broadcast(View view){
        //发送广播
        Intent intent=new Intent("com.inspur.broadcast");
        intent.putExtra("key1","message");
        sendBroadcast(intent);//发送
    }
    public void ch10Activity(View view){
        Intent intent=new Intent(this,Ch10Activity1.class);
        EditText editText= (EditText) findViewById(R.id.ch10_2_et);
        intent.putExtra("text",editText.getText().toString());//设置c传递的数据
        startActivity(intent);

    }

    public void startSubActivity(View view){
        //1.一Sub—Activity的方式启动Activity
        Intent intent=new Intent(this,Ch10Activity3.class);
        startActivityForResult(intent,101);


        
        Protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent date){
            //3.在父Activity中获取返回值
            //requestCode用来区分从哪一个子activity返回的结果
            if(requestCode==101){
                if(resultCode==RESULT_OK){
                    //用户点击的确认，进一步获取数据
                    String name=date.getStringExtra(name:"name");
                }else {
                    Toast.makeText(context:this,text:"cancel",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}

