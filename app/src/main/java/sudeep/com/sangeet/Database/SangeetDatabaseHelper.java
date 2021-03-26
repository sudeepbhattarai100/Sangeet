package sudeep.com.sangeet.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;



public class sangeetDatabaseHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "sangeetdatabase.db";
    public final static int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    public final String TABLE_NAME = "ALLHISTORY";
    public final String COLUMN_ID = "ID";
    public final String HISTORY = "SONG_NAME";
    public  String[] colums = new String[]{COLUMN_ID,HISTORY};
    private  final String CREATE_TABLE = "create table "+TABLE_NAME +" ( " + COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," + HISTORY +" VARCHAR );";
    private final String DROP_TABLE = "drop table if exists "+ TABLE_NAME;

    public sangeetDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);

    }



    public void addHistory(String name)
    {
        db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HISTORY,name);
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }

    public void deleteHistory(String name)
    {
        String whereClause = HISTORY+"=?";
        String[] whereArgs = new String[] { name };
        db.delete(TABLE_NAME, whereClause, whereArgs);
    }


    public List<String> getHistoryList()
    {
        db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,colums,null,null,null,null,null);

        int length = cursor.getCount();
        List<String> allHistory = new ArrayList<String>();

        for(int i =0;i<length;i++)
        {
            cursor.moveToNext();
            cursor.getString(1);
            String history =  cursor.getString(cursor.getColumnIndex(HISTORY));
            allHistory.add(history);
        }

        return allHistory;
    }
}
