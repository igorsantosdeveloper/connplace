package com.clinus.connplace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class CCplaceTest extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 10;
    private static final String DATABASE_NAME = "CCPLACE_TEST";
    private static final String TABLE_CCP_USER = "CCP_USER";
    private static final String CCP_USER_ID = "USER_ID";
    private static final String CCP_USER_NAME = "USER_NAME";
    private static final String CCP_USER_PASSWORD = "USER_PASSWORD";
    private static final String CCP_USER_AGE = "USER_AGE";
    private static final String CCP_USER_DATEOFBIRTH = "USER_DATEOFBIRTH";
    private static final String CCP_USER_SEX = "USER_SEX";
    private static final String TABLE_CCP_LOCATION = "CCP_LOCATION";
    private static final String CCP_LOCATION_ID = "LOCATION_ID";
    private static final String CCP_LOCATION_LATITUDE = "LOCATION_LATITUDE";
    private static final String CCP_LOCATION_LONGITUDE = "LOCATION_LONGITUDE";
    private static final String CCP_LOCATION_USER_ID = "LOCATION_USER_ID";
    private static final String CCP_LOCATION_USER_FOREIGNKEY =
            "FOREIGN KEY"+"(" + CCP_LOCATION_USER_ID + ")" +  " REFERENCES " + TABLE_CCP_USER + "(" + CCP_USER_ID + ")";

    public CCplaceTest(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =
                        "CREATE TABLE " + TABLE_CCP_USER + "(" +
                        CCP_USER_ID + " INTEGER PRIMARY KEY," +
                        CCP_USER_NAME + " TEXT," +
                        CCP_USER_PASSWORD + " TEXT," +
                        CCP_USER_AGE + " TEXT," +
                        CCP_USER_SEX + " TEXT," +
                        CCP_USER_DATEOFBIRTH + " TEXT " +
                        ");" +
                        " CREATE TABLE " + TABLE_CCP_LOCATION + "(" +
                        CCP_LOCATION_ID + " INTEGER PRIMARY KEY," +
                        CCP_LOCATION_LATITUDE + " REAL," +
                        CCP_LOCATION_LONGITUDE + " REAL," +
                        CCP_LOCATION_USER_ID + "INTEGER," +
                        CCP_LOCATION_USER_FOREIGNKEY +
                        ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        String sql = "DROP TABLE " + TABLE_CCP_USER;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    //DAO...

    public void newUser(ModelUser user){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CCP_USER_NAME,user.getName().toUpperCase());
        values.put(CCP_USER_PASSWORD,user.getPassword());
        values.put(CCP_USER_AGE,user.getAge().toUpperCase());
        values.put(CCP_USER_DATEOFBIRTH,user.getDateOfBirth().toUpperCase());
        values.put(CCP_USER_SEX,user.getSex().toUpperCase());
        db.insert(TABLE_CCP_USER,null,values);
        db.close();
    }

    public int authenticateUser(String name, String password){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(    "SELECT " +
                                        CCP_USER_ID +
                                        " FROM " + TABLE_CCP_USER +
                                        " WHERE " + CCP_USER_NAME + "=" + "'" + name + "'" +
                                        " AND " + CCP_USER_PASSWORD + "=" + "'" + password + "'", null);

        while(cursor.moveToNext()){

            int id = cursor.getInt(0);
            db.close();
            cursor.close();
            if(id > -1)
                return id;
        }

        return -1;
    }

    public int checkNameUser(String name){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(    "SELECT " +
                                        CCP_USER_ID +
                                        " FROM " + TABLE_CCP_USER +
                                        " WHERE " + CCP_USER_NAME + "=" + "'" + name + "'",null);

        while(cursor.moveToNext()){

            int id = cursor.getInt(0);
            db.close();
            cursor.close();
            if(id > -1)
                return id;
        }

        return -1;

    }

    //Teste de listagem de usuário
    public ArrayList<String> getUsers(){

        String coluns[] = {

                CCP_USER_ID,
                CCP_USER_NAME,
                CCP_USER_PASSWORD,
                CCP_USER_AGE,
                CCP_USER_DATEOFBIRTH,
                CCP_USER_SEX
        };
        Cursor cursor = getWritableDatabase().query(TABLE_CCP_USER,coluns,null,null,null,null,null,null);
        ArrayList<ModelUser> users = new ArrayList<>();
        while(cursor.moveToNext()){

            users.add(new ModelUser(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            ));
        }
        ArrayList<String>namesUsers = new ArrayList<String>();
        for(int i = 0;i < users.size();i++){

            namesUsers.add(users.get(i).getName());
        }
        cursor.close();
        return namesUsers;
    }
}


















