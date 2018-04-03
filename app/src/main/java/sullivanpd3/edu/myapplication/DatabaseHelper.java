package sullivanpd3.edu.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Patrick Sullivan on 4/2/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SynAnt.db";
    private static final String TABLE_NAME = "SynAnt";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_MATCH = "match";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table "+ TABLE_NAME +
            " (id integer primary key, " +
            "word text not null, match text not null);";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertMatchedPair(MatchedWords m){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from SynAnt";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_WORD, m.getWord());
        values.put(COLUMN_MATCH, m.getMatch());

        db.insert(TABLE_NAME, null, values);
        db.close();
        cursor.close();
    }

    public String searchMatch(String word){
        db = this.getReadableDatabase();
        String query = "select word, match from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if (a.equals(word)){
                    b = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        cursor.close();
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
