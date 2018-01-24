package com.redare.dbmultprocess.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Robert on 2017/5/25.
 */

class SqliteHelper extends SQLiteOpenHelper {

    private static final String TAG = "SqliteHelper";

    private static final String DATABASE_NAME="my_db";
    public static final String TABLE_NAME_TASK="table_task";

    private static final int VERSION=1;
    private String sql1="create table "+TABLE_NAME_TASK+
            " (id integer primary key autoincrement," +
            " tid integer," +
            " endstr varchar(60) default '')";

    //varchar(1) 类型的变量，可以自动边长在，指定尺寸不够的情况下，
    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
        super(context, name, factory, version);
    }

    public SqliteHelper(Context context) {
        this(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //当数据库被首次创建时执行该方法(数据库文件不存在的时候调用)
        sqLiteDatabase.execSQL(sql1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //当打开数据库时传入的版本号与当前的版本号不同时会调用该方法（数据库已经存在的情况下调用）
        //onCreate 和onUpgrade 不会都执行，只执行其中一个
    }
}