package com.clinus.connplace;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CCplaceTest extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 9;
    private static final String DATABASE_NAME = "CCPLACE_TEST";
    private static final String TABLE_CCP_USER = "CCP_USER";
    private static final String CCP_USER_ID = "USER_ID";
    private static final String CCP_USER_NAME = "USER_NAME";
    private static final String CCP_USER_PASSWORD = "USER_PASSWORD";
    private static final String CCP_USER_LOCATION = "USER_LOCATION";
    private static final String CCP_USER_AGE = "USER_AGE";
    private static final String CCP_USER_DATEOFBIRTH = "USER_DATEOFBIRTH";
    private static final String CCP_USER_SEX = "USER_SEX";

    public CCplaceTest(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =  "CREATE TABLE "     +       TABLE_CCP_USER               +
                        "("                                                      +
                        CCP_USER_ID          +       " INTEGER PRIMARY KEY,"     +
                        CCP_USER_NAME        +       " TEXT,"                    +
                        CCP_USER_PASSWORD    +       " TEXT,"                    +
                        CCP_USER_LOCATION    +       " TEXT,"                    +
                        CCP_USER_AGE         +       " TEXT,"                    +
                        CCP_USER_SEX         +       " TEXT,"                    +
                        CCP_USER_DATEOFBIRTH +       " TEXT "                    +
                        ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        String sql = "DROP TABLE " + TABLE_CCP_USER;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void newUser(ModelUser user){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CCP_USER_NAME,user.getName().toUpperCase());
        values.put(CCP_USER_PASSWORD,user.getPassword());
        values.put(CCP_USER_LOCATION,user.getLocation().toUpperCase());
        values.put(CCP_USER_AGE,user.getAge().toUpperCase());
        values.put(CCP_USER_DATEOFBIRTH,user.getDateOfBirth().toUpperCase());
        values.put(CCP_USER_SEX,user.getSex().toUpperCase());
        db.insert(TABLE_CCP_USER,null,values);
        db.close();
    }
}


















