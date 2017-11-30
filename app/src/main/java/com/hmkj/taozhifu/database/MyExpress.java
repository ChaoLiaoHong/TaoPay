package com.hmkj.taozhifu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.hmkj.taozhifu.bean.HistoryEntity;
import com.hmkj.taozhifu.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/5/31
 */

public class MyExpress {
    SQLiteDatabase db;
    Context context;
    HistoryEntity historyBean;

    public MyExpress(Context context) {
        this.context = context;
        MyDb myDb = new MyDb(context);
        db = myDb.getReadableDatabase();
    }

    //添加操作
    public void addTitle(String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", name);
        LogUtil.LogLong("添加记录：" + name);
        db.insert("history_record", null, contentValues);
    }

    //删除一条
    public void deleteOne(String title) {
        db.delete("history_record", "title=?", new String[]{title});
    }

    //删除所有
    public void deleteAll() {
        db.delete("history_record", null, null);
    }

    //查询操作
    public List<HistoryEntity> getTitleOne(String name) {
        Cursor cursor = db.rawQuery("select * from history_record where title Like ?",
                new String[]{'%' + name + '%'});
        List<HistoryEntity> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            String mName = cursor.getString(cursor.getColumnIndex("title"));
            historyBean = new HistoryEntity(mName);
            list.add(historyBean);
        }
        return list;
    }

    public List<HistoryEntity> getAllData() {
        Cursor cursor = db.rawQuery("select * from history_record", null);
        List<HistoryEntity> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("title"));
            historyBean = new HistoryEntity(name);
            list.add(historyBean);
        }
        cursor.close();
        return list;
    }
}
