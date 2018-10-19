package com.phon.elibrary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbBook extends SQLiteOpenHelper {

    public DbBook(Context context) {
        super(context, "myBook",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create table
        String sql = "create table tblBook(id integer primary key autoincrement, " +
                "imageUrl text, title text, author text, size text)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Data Manipulation
    public Book[] getAllBooks(){
        //Get DB object
        SQLiteDatabase db = getReadableDatabase();

        //Select Data
        Cursor cursor = db.query("tblBook",null,null,null,null,null,"id desc");

     // Cursor cursor1 = db.rawQuery("select * from tblBook order by id desc", null);

        Book[] books = new Book[cursor.getCount()];
        int index = 0;
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String imageUrl = cursor.getString(1);
            String title = cursor.getString(2);
            String author = cursor.getString(3);
            String size = cursor.getString(4);

            Book book = new Book(id, imageUrl, title, author, size, "");
            books[index] = book;
            index++;
        }
        cursor.close();

        return books;
    }

    public void insertData(){

        SQLiteDatabase db = getWritableDatabase();
        for(int i=0; i<10; i++){
            db.execSQL("insert into tblBook(imageUrl, title, author, size) values " +
                "('Book " + i + "','','" + i + "Java Programming','2MB')");
        }
    }
}
