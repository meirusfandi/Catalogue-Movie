package com.example.root.movieuiux.database;import android.content.ContentValues;import android.content.Context;import android.database.SQLException;import android.database.sqlite.SQLiteDatabase;import static android.provider.BaseColumns._ID;import static com.example.root.movieuiux.database.DatabaseContract.FavoriteColumns.BACKDROP;import static com.example.root.movieuiux.database.DatabaseContract.FavoriteColumns.OVERVIEW;import static com.example.root.movieuiux.database.DatabaseContract.FavoriteColumns.POPULARITY;import static com.example.root.movieuiux.database.DatabaseContract.FavoriteColumns.POSTER;import static com.example.root.movieuiux.database.DatabaseContract.FavoriteColumns.RATE;import static com.example.root.movieuiux.database.DatabaseContract.FavoriteColumns.RATE_AVG;import static com.example.root.movieuiux.database.DatabaseContract.FavoriteColumns.RELEASE;import static com.example.root.movieuiux.database.DatabaseContract.FavoriteColumns.TITLE;import static com.example.root.movieuiux.database.DatabaseContract.TABLE_FAVORITE;public class MovieHelper {    private static String DATABASE_TABLE    = TABLE_FAVORITE;    private Context context;    private DatabaseHelper helper;    private SQLiteDatabase database;    public MovieHelper(Context context) {        this.context = context;    }    //open connection    public MovieHelper open() throws SQLException {        helper  = new DatabaseHelper(context);        database= helper.getWritableDatabase();        return this;    }    //close connection    public void close(){        helper.close();    }    //select DB query    //insert query    public long insert(Movie movie){        ContentValues values = new ContentValues();        values.put(TITLE, movie.getTitle());        values.put(RELEASE, movie.getRelease());        values.put(OVERVIEW, movie.getOverview());        values.put(POSTER, movie.getPoster());        values.put(BACKDROP, movie.getBackdrop());        values.put(RATE, movie.getRate());        values.put(RATE_AVG, movie.getRate_avg());        values.put(POPULARITY, movie.getPopularity());        return database.insert(DATABASE_TABLE, null, values);    }    //update query    public int update(Movie movie){        ContentValues values = new ContentValues();        values.put(TITLE, movie.getTitle());        values.put(RELEASE, movie.getRelease());        values.put(OVERVIEW, movie.getOverview());        values.put(POSTER, movie.getPoster());        values.put(BACKDROP, movie.getBackdrop());        values.put(RATE, movie.getRate());        values.put(RATE_AVG, movie.getRate_avg());        values.put(POPULARITY, movie.getPopularity());        return database.update(TABLE_FAVORITE, values, _ID+" = '"+movie.getId()+"'", null);    }    //delete query    public int delete(int id){        return database.delete(TABLE_FAVORITE, _ID+" = '"+id+"'", null);    }}