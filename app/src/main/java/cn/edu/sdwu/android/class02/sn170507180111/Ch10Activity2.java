package cn.edu.sdwu.android.class02.sn170507180111;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



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
                    String name=date.getStringExtra("name");
                }else {
                    Toast.makeText(this,"cancel",Toast.LENGTH_SHORT).show();
                }
            }else if (requestCode==102){
                //从联系人列表返回结果
                if(requestCode==RESULT_OK){
                    //得到联系人的信息（联系人编号，lookup uri）
                    String content=date.getDataString();
                    Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"cancel",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    public void web(View view){
        //用隐式启动方式，打开网页
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://baidu.com"));

    }
    public void contactsList(View view){
        //查看联系人列表
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/"));
        startActivity(intent);
    }
    public void contactsDetail(View view){
        //查看联系人明细
        Intent intent=new Intent(Intent.ACTION_EDIT);
        intent.setData(Uri.parse("content://contacts/people/1"));
        startActivity(intent);
    }
    public void showMap(View view){
        //查看地图
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:50.123,7.1434"));
        startActivity(intent);

    }
    public void showPhoto(View view){
        //查看照片
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("content:/media/external/images/media/"));
        startActivity(intent);
    }
    public void pickContact(View view){
        //以子activity的形式，打开联系人列表，让用户选择一个联系人后，返回结果
        Intent intent=new Intent(Intent.ACTION_PICK);//隐式启动
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent,102);
    }
    public void implicitStart(View view){
        Intent intent=new Intent("com.inspur.action2");
        intent.setData(Uri.parse("abc://inspur.com"));
        startActivity(intent);
    }
}

