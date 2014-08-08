package com.example.app_android.database;

import com.example.app_android.R;
import com.example.app_android.database.interfaces.IMapPlaceTable;
import com.example.app_android.util.Utilities;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MapPlaceTable extends BaseTable implements IMapPlaceTable {
	
	private static final String TABLE_NAME = "coordinateTable";
	
	private static final String COLUMN_NAME 				= "name";
	private static final String COLUMN_DESCRIPTION 			= "description";
	private static final String COLUMN_COORDINATE_LATITUDE 	= "latitude";
	private static final String COLUMN_COORDINATE_LONGITUDE = "longitude";
	private static final String COLUMN_TOGGLE_ID			= "toggleId";
	private static final String COLUMN_ICON_ID				= "iconId";
	
	private static final String COLUMN_NAME_TYPE 				= "VARCHAR(50) PRIMARY KEY";
	private static final String COLUMN_DESCRIPTION_TYPE 		= "TEXT";
	private static final String COLUMN_COORDINATE_LATITUDE_TYPE = "REAL";
	private static final String COLUMN_COORDINATE_LONGITUDE_TYPE = "REAL";
	private static final String COLUMN_TOGGLE_ID_TYPE			= "INTEGER";
	private static final String COLUMN_ICON_ID_TYPE				= "INTEGER";
	
	private static final String LOCAL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " " +
	"("+
		COLUMN_NAME					+ " " + COLUMN_NAME_TYPE 				+ ", " +
		COLUMN_DESCRIPTION 			+ " " + COLUMN_DESCRIPTION_TYPE 		+ ", " +
		COLUMN_COORDINATE_LATITUDE 	+ " " + COLUMN_COORDINATE_LATITUDE_TYPE + ", " +
		COLUMN_COORDINATE_LONGITUDE + " " + COLUMN_COORDINATE_LONGITUDE_TYPE + ", " +
		COLUMN_TOGGLE_ID			+ " " + COLUMN_TOGGLE_ID_TYPE			+ ", " +
		COLUMN_ICON_ID				+ " " + COLUMN_ICON_ID_TYPE				+
	")";
	
	private static final int TOGGLE_ID_NO_TOGGLE		= -1;
	private static final int TOGGLE_ID_CAMPUS_HOUSES	= 0;
	private static final int TOGGLE_ID_STUDENT_UNION	= 1;
	private static final int TOGGLE_ID_STUDENT_PUBS		= 2;
	
	private static final int MARKER_ICON_ID_HOUSE_A 	= 0;
	private static final int MARKER_ICON_ID_HOUSE_B 	= 1;
	private static final int MARKER_ICON_ID_HOUSE_C 	= 2;
	private static final int MARKER_ICON_ID_HOUSE_D 	= 3;
	private static final int MARKER_ICON_ID_HOUSE_G 	= 4;
	private static final int MARKER_ICON_ID_HOUSE_H 	= 5;
	private static final int MARKER_ICON_ID_HOUSE_J 	= 6;
	private static final int MARKER_ICON_ID_ROTUNDAN 	= 7;
	private static final int MARKER_ÌCON_ID_BSK_OFFICE 	= 8;
	
	private static final String RETRIEVE_MARKER_INFO 	= "select * from " + TABLE_NAME + " where " + COLUMN_NAME + " = ?";
	private static final String RETRIEVE_ON_TOGGLE_ID 	= "select * from " + TABLE_NAME + " where " + COLUMN_TOGGLE_ID + " = ?";
	
	public MapPlaceTable(SQLiteOpenHelper SQLiteOpenHelper) {
		super(SQLiteOpenHelper);
		SQL_CREATE_TABLE = LOCAL_CREATE_TABLE;
		SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
	}
	
	public void fillTableWithDefaultData(SQLiteDatabase db) throws SQLException, DBException{ //TODO save the names in an enum to avoid inline string comparisons
		super.fillTableWithDefaultData(db);
		final int defaultValueCount = 13; //TODO remove test values
		
		ContentValues values[] = new ContentValues[defaultValueCount];
		for (int i = 0; i < defaultValueCount; ++i) {
			values[i] = new ContentValues();
		}
		
		values[0].put(COLUMN_NAME, "HOUSE_A");
		values[0].put(COLUMN_DESCRIPTION, "Description missing");
		values[0].put(COLUMN_COORDINATE_LATITUDE, 56.182016);
		values[0].put(COLUMN_COORDINATE_LONGITUDE, 15.590502);
		values[0].put(COLUMN_ICON_ID, MARKER_ICON_ID_HOUSE_A);
		values[0].put(COLUMN_TOGGLE_ID, TOGGLE_ID_CAMPUS_HOUSES);
		
		values[1].put(COLUMN_NAME, "HOUSE_B");
		values[1].put(COLUMN_DESCRIPTION, "Description missing");
		values[1].put(COLUMN_COORDINATE_LATITUDE, 56.180673);
		values[1].put(COLUMN_COORDINATE_LONGITUDE, 15.590691);
		values[1].put(COLUMN_ICON_ID, MARKER_ICON_ID_HOUSE_B);
		values[1].put(COLUMN_TOGGLE_ID, TOGGLE_ID_CAMPUS_HOUSES);
		
		values[2].put(COLUMN_NAME, "HOUSE_C");
		values[2].put(COLUMN_DESCRIPTION, "Description missing");
		values[2].put(COLUMN_COORDINATE_LATITUDE, 56.181189);
		values[2].put(COLUMN_COORDINATE_LONGITUDE, 15.592303);
		values[2].put(COLUMN_ICON_ID, MARKER_ICON_ID_HOUSE_C);
		values[2].put(COLUMN_TOGGLE_ID, TOGGLE_ID_CAMPUS_HOUSES);
		
		values[3].put(COLUMN_NAME, "HOUSE_D");
		values[3].put(COLUMN_DESCRIPTION, "Description missing");
		values[3].put(COLUMN_COORDINATE_LATITUDE, 56.181670);
		values[3].put(COLUMN_COORDINATE_LONGITUDE, 15.592375);
		values[3].put(COLUMN_ICON_ID, MARKER_ICON_ID_HOUSE_D);
		values[3].put(COLUMN_TOGGLE_ID, TOGGLE_ID_CAMPUS_HOUSES);
		
		values[4].put(COLUMN_NAME, "HOUSE_G");
		values[4].put(COLUMN_DESCRIPTION, "Description missing");
		values[4].put(COLUMN_COORDINATE_LATITUDE, 56.181891);
		values[4].put(COLUMN_COORDINATE_LONGITUDE, 15.591308);
		values[4].put(COLUMN_ICON_ID, MARKER_ICON_ID_HOUSE_G);
		values[4].put(COLUMN_TOGGLE_ID, TOGGLE_ID_CAMPUS_HOUSES);
		
		values[5].put(COLUMN_NAME, "HOUSE_H");
		values[5].put(COLUMN_DESCRIPTION, "Description missing");
		values[5].put(COLUMN_COORDINATE_LATITUDE, 56.182348);
		values[5].put(COLUMN_COORDINATE_LONGITUDE, 15.590819);
		values[5].put(COLUMN_ICON_ID, MARKER_ICON_ID_HOUSE_H);
		values[5].put(COLUMN_TOGGLE_ID, TOGGLE_ID_CAMPUS_HOUSES);
		
		values[6].put(COLUMN_NAME, "HOUSE_J");
		values[6].put(COLUMN_DESCRIPTION, "Description missing");
		values[6].put(COLUMN_COORDINATE_LATITUDE, 56.182933);
		values[6].put(COLUMN_COORDINATE_LONGITUDE, 15.590401);
		values[6].put(COLUMN_ICON_ID, MARKER_ICON_ID_HOUSE_J);
		values[6].put(COLUMN_TOGGLE_ID, TOGGLE_ID_CAMPUS_HOUSES);
		
		values[7].put(COLUMN_NAME, "HOUSE_K");
		values[7].put(COLUMN_DESCRIPTION, "Description missing");
		values[7].put(COLUMN_COORDINATE_LATITUDE, 56.181711);
		values[7].put(COLUMN_COORDINATE_LONGITUDE, 15.589841);
		values[7].put(COLUMN_ICON_ID, MARKER_ICON_ID_ROTUNDAN);
		values[7].put(COLUMN_TOGGLE_ID, TOGGLE_ID_STUDENT_PUBS);
		
		values[8].put(COLUMN_NAME, "KARLSHAMN_HOUSE_A");
		values[8].put(COLUMN_DESCRIPTION, "Description missing");
		values[8].put(COLUMN_COORDINATE_LATITUDE, 56.163626);
		values[8].put(COLUMN_COORDINATE_LONGITUDE, 14.866623);
		values[8].put(COLUMN_ICON_ID, MARKER_ICON_ID_HOUSE_A);
		values[8].put(COLUMN_TOGGLE_ID, TOGGLE_ID_CAMPUS_HOUSES );
		
		values[9].put(COLUMN_NAME, "KARLSHAMN_HOUSE_B");
		values[9].put(COLUMN_DESCRIPTION, "Description missing");
		values[9].put(COLUMN_COORDINATE_LATITUDE, 56.164464);
		values[9].put(COLUMN_COORDINATE_LONGITUDE, 14.866012);
		values[9].put(COLUMN_ICON_ID, MARKER_ICON_ID_HOUSE_B);
		values[9].put(COLUMN_TOGGLE_ID, TOGGLE_ID_CAMPUS_HOUSES);
		
		values[10].put(COLUMN_NAME, "BSK_OFFICE");
		values[10].put(COLUMN_DESCRIPTION, "Description missing");
		values[10].put(COLUMN_COORDINATE_LATITUDE, 56.181975);
		values[10].put(COLUMN_COORDINATE_LONGITUDE, 15.589975);
		values[10].put(COLUMN_ICON_ID, MARKER_ÌCON_ID_BSK_OFFICE);
		values[10].put(COLUMN_TOGGLE_ID, TOGGLE_ID_STUDENT_UNION);
		
		values[11].put(COLUMN_NAME, "Alpackahage");
		values[11].put(COLUMN_DESCRIPTION, "Description missing");
		values[11].put(COLUMN_COORDINATE_LATITUDE, 56.181375);
		values[11].put(COLUMN_COORDINATE_LONGITUDE, 15.585975);
		values[11].put(COLUMN_ICON_ID, MARKER_ÌCON_ID_BSK_OFFICE);
		values[11].put(COLUMN_TOGGLE_ID, TOGGLE_ID_NO_TOGGLE);
		
		values[12].put(COLUMN_NAME, "Alpackahage2");
		values[12].put(COLUMN_DESCRIPTION, "Description missing");
		values[12].put(COLUMN_COORDINATE_LATITUDE, 56.184375);
		values[12].put(COLUMN_COORDINATE_LONGITUDE, 15.535975);
		values[12].put(COLUMN_ICON_ID, MARKER_ÌCON_ID_BSK_OFFICE);
		values[12].put(COLUMN_TOGGLE_ID, TOGGLE_ID_NO_TOGGLE);
		
		db.beginTransaction();
		
		for(int i = 0; i < defaultValueCount; ++i) {
			db.insert(TABLE_NAME, null, values[i]);
		}
		
		db.setTransactionSuccessful();
		db.endTransaction();
	}
	
	@Override
	public boolean add(String name, String description, float latitude, float longitude, int iconId, int toggleId) throws DBException {
		if(Utilities.verbose) {Log.v(TAG, mClass + ":add()");}
		
		SQLiteDatabase db = mHelper.getWritableDatabase();
		db.beginTransaction();		
		ContentValues contentValues = new ContentValues();
		contentValues.put(COLUMN_NAME, name);
		contentValues.put(COLUMN_DESCRIPTION, description);
		contentValues.put(COLUMN_COORDINATE_LATITUDE, latitude);
		contentValues.put(COLUMN_COORDINATE_LONGITUDE, longitude);
		contentValues.put(COLUMN_ICON_ID, iconId);
		contentValues.put(COLUMN_TOGGLE_ID, toggleId);
		
		int result = -1;
		try {
			result = (int) db.insert(TABLE_NAME, null, contentValues);
			db.setTransactionSuccessful();
		}catch(NullPointerException e) {
			if(Utilities.error) {Log.v(TAG, mClass + ":add()::db.insert();");}
			throw new DBException("NullPointerException. Message: " + e.getMessage());
		}
		catch(IllegalStateException e) {
			if(Utilities.error) {Log.v(TAG, mClass + ":add()::db.setTransactionSuccessful();");}
			throw new DBException("IllegalStateException. Message: " + e.getMessage());
		}
		finally{
			db.endTransaction();
			db.close();
		}
		
		if(result == -1) {
			throw new DBException("Database error");
		}
		return true;
	}
	
	@Override
	public LatLng getMapCoordinate(String name) {
		if(Utilities.verbose) {Log.v(TAG, mClass + ":getMapCoordinate()");}
		LatLng coordinates = null;
		
		SQLiteDatabase db = mHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(RETRIEVE_MARKER_INFO, new String[] { name });
		
		if(cursor.moveToFirst()) {
			coordinates = new LatLng(cursor.getFloat(2), cursor.getFloat(3));
		}
		return coordinates;
	}
	
	@Override
	public MarkerOptions getMapMarkerOptions(String name) {
		if(Utilities.verbose) {Log.v(TAG, mClass + ":getMapMarkerOptions()");}
		MarkerOptions options = null;
		
		SQLiteDatabase db = mHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(RETRIEVE_MARKER_INFO, new String[] { name });
		
		if(cursor.moveToFirst()) {
			options = new MarkerOptions();
			options.title("");	//The title is expected to be included in the snippet since the snippet is being formatted as HMTL
			options.snippet(cursor.getString(1));
			options.position(new LatLng(cursor.getFloat(2), cursor.getFloat(3)));
			options.icon(getIconFromId(cursor.getInt(5)));
		}
		
		db.close();
		return options;
	}
	
	public String[] getAllSearchableNames() {
		if(Utilities.verbose) {Log.v(TAG, mClass + ":getAllSearchableNames");}
		
		SQLiteDatabase db = mHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(RETRIEVE_ON_TOGGLE_ID, new String[] { Integer.toString(TOGGLE_ID_NO_TOGGLE)});
		
		int rowCount = cursor.getCount();
		String[] searchableNames = new String[rowCount];
		for(int i = 0; i < rowCount; ++i) {
			cursor.moveToNext();
			searchableNames[i] = cursor.getString(0);
		}
		
		db.close();
		return searchableNames;
	}
	
	private BitmapDescriptor getIconFromId(int iconId) {
		if(Utilities.verbose) {Log.v(TAG, mClass + ":BitmapDescriptor()");}
		BitmapDescriptor icon = null;
		
		switch (iconId) {
		case MARKER_ICON_ID_HOUSE_A:
			icon = BitmapDescriptorFactory.fromResource(R.drawable.marker_a);
			break;
			
		case MARKER_ICON_ID_HOUSE_B:
			icon = BitmapDescriptorFactory.fromResource(R.drawable.marker_b);
			break;
			
		case MARKER_ICON_ID_HOUSE_C:
			icon = BitmapDescriptorFactory.fromResource(R.drawable.marker_c);
			break;
			
		case MARKER_ICON_ID_HOUSE_D:
			icon = BitmapDescriptorFactory.fromResource(R.drawable.marker_d);
			break;
			
		case MARKER_ICON_ID_HOUSE_G:
			icon = BitmapDescriptorFactory.fromResource(R.drawable.marker_g);
			break;
			
		case MARKER_ICON_ID_HOUSE_H:
			icon = BitmapDescriptorFactory.fromResource(R.drawable.marker_h);
			break;
			
		case MARKER_ICON_ID_HOUSE_J:
			icon = BitmapDescriptorFactory.fromResource(R.drawable.marker_j);
			break;
			
		case MARKER_ICON_ID_ROTUNDAN:
			icon = BitmapDescriptorFactory.fromResource(R.drawable.marker_rotundan);
			break;
			
		case MARKER_ÌCON_ID_BSK_OFFICE:
			icon = BitmapDescriptorFactory.fromResource(R.drawable.marker_bsk);
			break;
		}
		return icon;
	}
}