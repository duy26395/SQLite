package com.example.duy.sqlitte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by duy on 23/05/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "QL_team";
    private static final String TABLE_NAME = "team";
    private static final String KEY_ID="id";
    private static final String KEY_NAME ="name";
    private static final String KEY_TV = "ten_tv";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String script = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_TV + " TEXT" + ")";
        db.execSQL(script);
    }

    /*  @Override
        public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE " + TABLE_NAME + "("+KEY_ID+"INTEGER PRIMARY KEY"+KEY_NAME+"TEXT,"+KEY_TV+"TEXT,"+")";
            db.execSQL(table);
        } */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public long addTEAM(Data data){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,data.getId());
        values.put(KEY_NAME,data.getTen());
        values.put(KEY_TV,data.getThanh_vien());
        long result = db.insert(TABLE_NAME,null,values);
        db.close();
        return result;
    }
    public Data getData(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{KEY_ID,KEY_TV,KEY_TV},KEY_ID +"=?", new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null) cursor.moveToFirst();
        else return new Data(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
        return null;
    }
    public List<Data> getallteam(){
        List<Data> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuerry = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuerry, null);
        if (cursor.moveToFirst()) {//chuyển dữ liệu các columns khác nhau,chuyển dữ liệu từ Data vào SQL
            do {
                data.add(new Data(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
            }
        while (cursor.moveToNext());
    }
        return data;
    }
    public void update(Data data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,data.getTen());
        values.put(KEY_TV,data.getThanh_vien());
        db.update(TABLE_NAME,values,KEY_NAME +"=?",new String[]{String.valueOf(data.getTen())});
        db.close();
    }
    public void delete(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME,KEY_ID +"=?", new String[]{String.valueOf(id)});
        db.close();

    }
    public int getCount(){//đếm số phần tử của Data đã ghi
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
   /* public void createDefaultStudentsIfNeed()  {
        if(this.getCount() == 0 ) {
            Data data1 = new Data(1,"KT", "DEff");
            Data data2 = new Data(2,"NOKIA N21", "Feader");
            this.addTEAM(data1);
            this.addTEAM(data2);
        };
    }*/

}
