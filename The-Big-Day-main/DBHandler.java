package com.myfirstapplication.mobileproject;
import static com.myfirstapplication.mobileproject.GuestHomepage.pos;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.
    public static String tempId;
    public static String tempGuestName;
    public static Guest guest5 = new Guest();
    public static ArrayList<String> a = new ArrayList<>();
    private static final String DB_NAME = "THEBIGDAY";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "owner";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    private static final String NAME_COL = "name";

    private static final String SURNAME_COL = "surname";

    private static final String EMAIL_COL = "email";

    private static final String PASSWORD_COL = "password";

    // below variable is for our table name.
    private static final String WEDDING_TABLE_NAME = "wedding";

    // below variable is for our id column.
    private static final String WEDDING_ID_COL = "id";

    private static final String WEDDING_NAME_COL = "name";

    private static final String WEDDING_PARTNERNAME_COL = "partnerName";

    private static final String WEDDING_PLACE_COL = "place";

    private static final String WEDDING_DATE_COL = "date";

    private static final String WEDDING_HOUR_COL =  "hour";

    private static final String WEDDING_OWNERID_COL =  "ownerID";

    // below variable is for our table name.
    private static final String GUEST_TABLE_NAME = "guest";

    // below variable is for our id column.
    private static final String GUEST_ID_COL = "id";

    private static final String GUEST_NAME_COL = "name";

    private static final String GUEST_SURNAME_COL = "surname";

    private static final String GUEST_EMAIL_COL = "email";

    private static final String GUEST_PHONE_COL = "phone";

    private static final String GUEST_NUM_COL = "num";

    private static final String GUEST_AVAILABILITY_COL ="availability";

    private static final String GUEST_WEDID_COL ="guestWeddingID";




    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + SURNAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";
        String query2 = "CREATE TABLE " + WEDDING_TABLE_NAME + " ("
                + WEDDING_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WEDDING_OWNERID_COL + " TEXT,"
                + WEDDING_NAME_COL + " TEXT,"
                + WEDDING_PARTNERNAME_COL + " TEXT,"
                + WEDDING_PLACE_COL + " TEXT,"
                + WEDDING_DATE_COL + " TEXT,"
                + WEDDING_HOUR_COL+ " TEXT)";

        String query3 = "CREATE TABLE " + GUEST_TABLE_NAME + " ("
                + GUEST_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + GUEST_NAME_COL + " TEXT,"
                + GUEST_SURNAME_COL + " TEXT,"
                + GUEST_EMAIL_COL + " TEXT,"
                + GUEST_PHONE_COL + " TEXT,"
                + GUEST_NUM_COL + " TEXT,"
                + GUEST_AVAILABILITY_COL + " TEXT,"
                +  GUEST_WEDID_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
        db.execSQL(query2);
        db.execSQL(query3);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String name, String surname, String email, String psw) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, name);
        values.put(SURNAME_COL, surname);
        values.put(EMAIL_COL, email);
        values.put(PASSWORD_COL, psw);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }
    public void createWedding(String name, String partnerName, String place, String date,String hour, String ownerId) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(WEDDING_OWNERID_COL, ownerId);
        values.put(WEDDING_NAME_COL, name);
        values.put(WEDDING_PARTNERNAME_COL, partnerName);
        values.put(WEDDING_PLACE_COL, place);
        values.put(WEDDING_DATE_COL, date);
        values.put(WEDDING_HOUR_COL, hour);



        // after adding all values we are passing
        // content values to our table.
        db.insert(WEDDING_TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
}

    public void addGuest(String name, String surname, String email, String phone,String num,String availability, String weddingId) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(GUEST_NAME_COL, name);
        values.put(GUEST_SURNAME_COL, surname);
        values.put(GUEST_EMAIL_COL, email);
        values.put(GUEST_PHONE_COL, phone);
        values.put(GUEST_NUM_COL, num);
        values.put(GUEST_AVAILABILITY_COL, availability);
        values.put(GUEST_WEDID_COL, weddingId);



        // after adding all values we are passing
        // content values to our table.
        db.insert(GUEST_TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
}
    //---retrieves a all contacts---
    public ArrayList<Guest> getGuestsInfos(String wedId)
    {

        ArrayList<Guest> guestList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor=db.rawQuery("SELECT * from guest WHERE guestWeddingID = ?",new String[]{wedId});



        for(mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()){
            Guest guest = new Guest();
            int name = mCursor.getColumnIndex(GUEST_NAME_COL);
            int surname = mCursor.getColumnIndex(GUEST_SURNAME_COL);
            int mail = mCursor.getColumnIndex(GUEST_EMAIL_COL);
            int phone = mCursor.getColumnIndex(GUEST_PHONE_COL);
            int num = mCursor.getColumnIndex(GUEST_NUM_COL);
            int availability = mCursor.getColumnIndex(GUEST_AVAILABILITY_COL);

            guest.setName(mCursor.getString(name));
            guest.setSurname(mCursor.getString(surname));
            guest.setEmail(mCursor.getString(mail));
            guest.setPhoneNum(mCursor.getString(phone));
            guest.setGuestNum(Integer.parseInt(mCursor.getString(num)));
            guest.setStatus(Boolean.valueOf(mCursor.getString(availability)));

            guestList.add(guest);
        }
        return guestList;

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + WEDDING_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + GUEST_TABLE_NAME);
        onCreate(db);
    }

    public Boolean check(String email,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM owner WHERE email = ? AND password = ? ",new String[]{email,password});

        if(mCursor.getCount() > 0){

            ArrayList<Integer> mArrayList = new ArrayList<Integer>();
            int columnIndex=mCursor.getColumnIndex(DBHandler.ID_COL);
            while(mCursor.moveToNext()) {
                mArrayList.add(Integer.valueOf(mCursor.getString(columnIndex))); //add the item
            }
            tempId = mArrayList.get(0).toString();
            return true;
        }

        else
            return false;
    }
    public Boolean hasWedding(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM wedding WHERE ownerID = ? ",new String[]{id});

        if(mCursor.getCount() > 0){
            return true;
        }
        else
            return false;
    }

    //---retrieves a particular contact---
    public Wedding getWeddingInfo(String id) throws SQLException
    {
        Wedding wedding = new Wedding();
        SQLiteDatabase db = this.getWritableDatabase();
        String coupleName = "";
        Cursor mCursor=db.rawQuery("SELECT * from wedding WHERE ownerID = ?",new String[]{id});
        int iName = mCursor.getColumnIndex(WEDDING_NAME_COL);
        int iPartnerName = mCursor.getColumnIndex(WEDDING_PARTNERNAME_COL);
        int iPlace = mCursor.getColumnIndex(WEDDING_PLACE_COL);
        int iDate = mCursor.getColumnIndex(WEDDING_DATE_COL);
        int iHour = mCursor.getColumnIndex(WEDDING_HOUR_COL);


        for(mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()){

            //coupleName=  mCursor.getString(iName) + "&" + mCursor.getString(iPartnerName);
            wedding.setCoupleName(mCursor.getString(iName) + " & " + mCursor.getString(iPartnerName));
            wedding.setLocation(mCursor.getString(iPlace));
            wedding.setDate(mCursor.getString(iDate));
            wedding.setHour(mCursor.getString(iHour));

        }
        return wedding;

    }

    public Boolean hasGuest(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM guest WHERE phone = ? ",new String[]{id});
        int iWedId = mCursor.getColumnIndex(GUEST_WEDID_COL);
        int iGuestId = mCursor.getColumnIndex(GUEST_NAME_COL);




        for(mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()){
            tempGuestName = mCursor.getString(iGuestId);
            guest5.setWedId(mCursor.getString(iWedId));
            a.add(guest5.getWedId());
        }

        if(mCursor.getCount() > 0){
            return true;
        }
        else
            return false;
    }

    public Boolean updateWeddingInfo(String place, String date,String hour,String tempId) throws SQLException
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WEDDING_PLACE_COL, place);
        values.put(WEDDING_DATE_COL, date);
        values.put(WEDDING_HOUR_COL, hour);
        return db.update(WEDDING_TABLE_NAME, values, "ownerID = ?", new String[]{tempId}) > 0;
    }
    public Boolean updateGuestInfo(String status,String num, String tempGuestName) throws SQLException
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GUEST_AVAILABILITY_COL, status);
        values.put(GUEST_NUM_COL, num);
        return db.update(GUEST_TABLE_NAME, values, "guestWeddingID = ? AND name = ?", new String[]{a.get(pos),tempGuestName}) > 0;
    }

    //---retrieves all the contacts---
    public Cursor getAllContacts(String key)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM guest WHERE guestweddingID = ? ",new String[]{key});
        return mCursor;
    }
    //---retrieves all the contacts---
    public Cursor getAllWeddings(String key)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM wedding WHERE ownerID = ? ",new String[]{key});
        return mCursor;
    }
}
