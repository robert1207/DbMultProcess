package com.redare.dbmultprocess.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2017/5/25.
 */

public class SQLite_db {

    private static SQLite_db sqlite;
    private SqliteHelper sqliteHelper;

    private Context mContext;
    private static final String TAG = "SQLite_db";

    private SQLite_db(Context context) {
        this.sqliteHelper = new SqliteHelper(context);
        mContext = context;
    }

    public static synchronized SQLite_db getInstance(Context context) {
        if (sqlite == null )
            sqlite = new SQLite_db(context);
        return sqlite;
    }

    private synchronized void  exeDO(String sql) {
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.close();
        //   sqliteHelper.close();
    }
    public void insertNewTask(int tid, String endstr) {
        //String sql = "insert into table_task (tid,endstr) values(tid,endstr)";
        StringBuilder sql = new StringBuilder(200);
        sql.append("insert into ");
        sql.append(SqliteHelper.TABLE_NAME_TASK);
        sql.append(" (tid,endstr) values(");
        sql.append(tid);
        sql.append(",'");
        sql.append(endstr);
        sql.append("')");
        exeDO(sql.toString());
    }
}
