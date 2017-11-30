package com.hmkj.taozhifu.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LiaoDuanHong  on 2017/5/31
 */

public class MyDb extends SQLiteOpenHelper {
    public MyDb(Context context) {
        super(context, "history.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table history_record(title name)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
