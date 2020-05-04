package cn.edu.sdwu.android.class02.sn170507180111;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by admin on 2020/4/29.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    private static final String STUDENT_TB_SQL="create table student(id integer primary key autoinncrement,stuname text,stutel text)";
    public MyOpenHelper(Context context) {
        super(context, "stud.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //当打开数据库，发现数据库并不存在，此时会自动创建数据库，然后调用onCreate方法
        //在本方法中完成数据库对象（表，视图，索引等）的创建

        //通过SQLiteDatabase对象，完成sql的执行
        sqLiteDatabase.execSQL(STUDENT_TB_SQL);
        Log.i(MyOpenHelper.class.toString(),"onCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
