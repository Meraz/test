package com.example.app_android.database;

import java.util.ArrayList;

import com.example.app_android.database.interfaces.ICourseTable;
import com.example.app_android.ui.courses_and_schedule.CourseBean;
import com.example.app_android.util.Utilities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CoursesTable extends BaseTable implements ICourseTable{

	private static final String TABLE_NAME = "courses";
	
	private static final String COLUMN_COURSE_CODE 			= "courseCode";
	private static final String COLUMN_COURSE_NAME 			= "courseName";
	private static final String COLUMN_COURSE_RESPONSIBLE 	= "courseResponsible";
	private static final String COLUMN_COURSE_START_DATE 	= "startDate";
	private static final String COLUMN_COURSE_END_DATE 		= "endDate";
	private static final String COLUMN_COURSE_LITERATURE 	= "courseLiterature";
	private static final String COLUMN_COURSE_NEXT_EXAM_DATE = "nextExamDate";
	private static final String COLUMN_COURSE_DESCRIPTION 	= "courseDescription";
    
    private static final String COLUMN_COURSE_CODE_TYPE 		= "VARCHAR(8) PRIMARY KEY";
    private static final String COLUMN_COURSE_NAME_TYPE 		= "VARCHAR(255)";
    private static final String COLUMN_COURSE_RESPONSIBLE_TYPE 	= "VARCHAR(50)";
    private static final String COLUMN_COURSE_START_DATE_TYPE 	= "VARCHAR(10)";
    private static final String COLUMN_COURSE_END_DATE_TYPE 	= "VARCHAR(10)";
    private static final String COLUMN_COURSE_LITERATURE_TYPE 	= "VARCHAR(255)";
    private static final String COLUMN_COURSE_NEXT_EXAM_DATE_TYPE = "VARCHAR(10)";
    private static final String COLUMN_COURSE_DESCRIPTION_TYPE 	= "TEXT";
    
	private static final String LOCAL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " " +
			"("+
				COLUMN_COURSE_CODE	 			+ " " + 	COLUMN_COURSE_CODE_TYPE 		+", " 	+
				COLUMN_COURSE_NAME 				+ " " + 	COLUMN_COURSE_NAME_TYPE  		+", " 	+
				COLUMN_COURSE_RESPONSIBLE		+ " " + 	COLUMN_COURSE_RESPONSIBLE_TYPE 	+", " 	+
				COLUMN_COURSE_START_DATE 		+ " " + 	COLUMN_COURSE_START_DATE_TYPE 	+", " 	+
				COLUMN_COURSE_END_DATE 			+ " " + 	COLUMN_COURSE_END_DATE_TYPE 	+", " 	+
				COLUMN_COURSE_LITERATURE 		+ " " + 	COLUMN_COURSE_LITERATURE_TYPE 	+", " 	+
				COLUMN_COURSE_NEXT_EXAM_DATE 	+ " " + 	COLUMN_COURSE_NEXT_EXAM_DATE_TYPE +", " +
				COLUMN_COURSE_DESCRIPTION 		+ " " + 	COLUMN_COURSE_DESCRIPTION_TYPE 	+
			")";
	
	private static final String RETRIEVE_COURSE = "select * from " + TABLE_NAME + " where " + COLUMN_COURSE_CODE + " = ?";
	
	public CoursesTable(SQLiteOpenHelper SQLiteOpenHelper) {
		super(SQLiteOpenHelper);
		SQL_CREATE_TABLE = LOCAL_CREATE_TABLE;
		SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
	}
	
	@Override
	public void fillTableWithDefaultData(SQLiteDatabase db) throws SQLException, DBException {
		super.fillTableWithDefaultData(db);
		int defaultValueCount = 2;
		
		ContentValues[] values = new ContentValues[defaultValueCount];
		for (int i = 0; i < defaultValueCount; ++i) {
			values[i] = new ContentValues();
		}
		
		//	TODO - remove test data
		values[0].put(COLUMN_COURSE_CODE, "DV1415");
		values[0].put(COLUMN_COURSE_NAME, "3D-Programmering II");
		values[0].put(COLUMN_COURSE_RESPONSIBLE, "Stefan Peterson");
		values[0].put(COLUMN_COURSE_START_DATE, "2014-03-01");
		values[0].put(COLUMN_COURSE_END_DATE, "2014-05-30");
		values[0].put(COLUMN_COURSE_LITERATURE, "DirectX Frank D Luna");
		values[0].put(COLUMN_COURSE_NEXT_EXAM_DATE, "2014-09-01");
		values[0].put(COLUMN_COURSE_DESCRIPTION, "THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!THISDESCRIPTIONISSOLONGWEHAVETOSCROLL!");
		
		/*values[1].put(COLUMN_COURSE_CODE, "PA1001");
		values[1].put(COLUMN_COURSE_NAME, "Alpackameditation");
		values[1].put(COLUMN_COURSE_RESPONSIBLE, "Baron & Otto");
		values[1].put(COLUMN_COURSE_START_DATE, "2015-07-01");
		values[1].put(COLUMN_COURSE_END_DATE, "2015-08-30");
		values[1].put(COLUMN_COURSE_LITERATURE, "Free your fluffy mind - Utgåva 3");
		values[1].put(COLUMN_COURSE_NEXT_EXAM_DATE, "2014-08-30");
		values[1].put(COLUMN_COURSE_DESCRIPTION, "It's so fluffy I'm gonna die!!!");*/
		
		values[1].put(COLUMN_COURSE_CODE, "DV1456");
		values[1].put(COLUMN_COURSE_NAME, "Programmering och algoritmer i C++");
		values[1].put(COLUMN_COURSE_RESPONSIBLE, "Betty Berqvist");
		values[1].put(COLUMN_COURSE_START_DATE, "2014-09-01");
		values[1].put(COLUMN_COURSE_END_DATE, "2015-03-30");
		values[1].put(COLUMN_COURSE_LITERATURE, "Stackoverflow");
		values[1].put(COLUMN_COURSE_NEXT_EXAM_DATE, "2014-10-25");
		values[1].put(COLUMN_COURSE_DESCRIPTION, "22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n22.5hp och annan vettig information som jag upprepar för att visa att denna vyn kan scrolla!\n");
		
		db.beginTransaction();
		
		try {
			int result = -1;
			for (int i = 0; i < defaultValueCount; ++i) {
				result = (int)db.insert(TABLE_NAME, null, values[i]);
				if(result == -1) {
					throw new DBException("Database error");
				}
			}
			db.setTransactionSuccessful();
			
		}catch(NullPointerException e) {
			if(Utilities.error) {Log.v(TAG, mClass + ":remove()::db.delete();");}
			throw new DBException("NullPointerException. Message: " + e.getMessage());
		}
		catch(IllegalStateException e) {
			if(Utilities.error) {Log.v(TAG, mClass + ":remove()::db.setTransactionSuccessful();");}
			throw new DBException("IllegalStateException. Message: " + e.getMessage());
		}
		finally{
			db.endTransaction();
		}		
	}
	
	@Override
	public boolean add(CourseBean course) throws DBException, NoRowsAffectedDBException {
		if(Utilities.verbose) {Log.v(TAG, mClass + ":add()");}
		
		SQLiteDatabase db = mHelper.getWritableDatabase();
		db.beginTransaction();		
		ContentValues contentValues = new ContentValues();
		contentValues.put(COLUMN_COURSE_CODE, course.getCourseCode());
		contentValues.put(COLUMN_COURSE_NAME, course.getCourseName());
		contentValues.put(COLUMN_COURSE_RESPONSIBLE, course.getCourseResponsible());
		contentValues.put(COLUMN_COURSE_START_DATE, course.getStartDate());
		contentValues.put(COLUMN_COURSE_END_DATE, course.getEndDate());
		contentValues.put(COLUMN_COURSE_LITERATURE, course.getCourseLiterature());
		contentValues.put(COLUMN_COURSE_NEXT_EXAM_DATE, course.getNextExamDate());
		contentValues.put(COLUMN_COURSE_DESCRIPTION, course.getCourseDescription());
		
		int result = -1;
		try {
			result = (int) db.insert(TABLE_NAME, null, contentValues);
			db.setTransactionSuccessful();
		}catch(NullPointerException e) {
			if(Utilities.error) {Log.e(TAG, mClass + ":add()::db.insert();");}
			throw new DBException("NullPointerException. Message: " + e.getMessage());
		}
		catch(IllegalStateException e) {
			if(Utilities.error) {Log.e(TAG, mClass + ":add()::db.setTransactionSuccessful();");}
			throw new DBException("IllegalStateException. Message: " + e.getMessage());
		}
		catch(SQLException e) {
			if(Utilities.error) {Log.e(TAG, mClass + ":add(). SQLException: something went wrong.");}
			throw new DBException("SQLException. Message: " + e.getMessage());
		}
		finally{
			db.endTransaction();
		}
		
		if(result == -1) {
		    if(Utilities.error) {Log.v(TAG, mClass + ":add(); No entry was added to the database");}
		    throw new NoRowsAffectedDBException(mClass + ":add(); No entry was added to the database");
		}
		return true;
	}
	
	@Override
	public ArrayList<String> getAllCourseCodes() throws DBException, NoResultFoundDBException{
		if(Utilities.verbose) {Log.v(TAG, mClass + ":getAllCourseCodes()");}
		SQLiteDatabase db = mHelper.getReadableDatabase();		
		db.beginTransaction();
		ArrayList<String> courseCodes = new ArrayList<String>();
		String[] columns = {COLUMN_COURSE_CODE};
		
		try {
			Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
			int index;
			while(cursor.moveToNext()) {
				index = cursor.getColumnIndex(COLUMN_COURSE_CODE);
				String courseCode = cursor.getString(index);
				courseCodes.add(courseCode);
			}
			db.setTransactionSuccessful();
		}catch(NullPointerException e) {
			if(Utilities.error) {Log.e(TAG, mClass + ":getAllCourseCodes()::db.insert();");}
			throw new DBException("NullPointerException. Message: " + e.getMessage());
		}
		catch(IllegalStateException e) {
			if(Utilities.error) {Log.e(TAG, mClass + ":getAllCourseCodes();");}
			throw new DBException("IllegalStateException. Message: " + e.getMessage());
		}
		catch(SQLException e) {
			if(Utilities.error) {Log.e(TAG, mClass + ":getAllCourseCodes(); SQLException, something went wrong.");}
			throw new DBException("SQLException. Message: " + e.getMessage());
		}
		finally {
			db.endTransaction();
		}
		
		if(courseCodes.size() == 0) {
			if(Utilities.error) {Log.e(TAG, mClass + ":getAllCourseCodes(); No result was found in database");}
			throw new NoResultFoundDBException(mClass + ":getAllCourseCodes(); No result was found in database");
		}
		return courseCodes;
	}
	
	@Override
	public ArrayList<String> getAllCourseNames() throws DBException, NoResultFoundDBException {
		if(Utilities.verbose) {Log.v(TAG, mClass + ":getAllCourseNames()");}
		ArrayList<String> courseNames = new ArrayList<String>();
		
		SQLiteDatabase db = mHelper.getReadableDatabase();	
		db.beginTransaction();
		String[] columns = {COLUMN_COURSE_NAME};
		
		try {
			Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
			int index;
			while(cursor.moveToNext()) {
				index = cursor.getColumnIndex(COLUMN_COURSE_NAME);
				String courseCode = cursor.getString(index);
				courseNames.add(courseCode);
			}
			db.setTransactionSuccessful();
		}catch(NullPointerException e) {
			if(Utilities.error) {Log.e(TAG, mClass + ":getAllCourseNames()::db.insert();");}
			throw new DBException("NullPointerException. Message: " + e.getMessage());
		}
		catch(IllegalStateException e) {
			if(Utilities.error) {Log.e(TAG, mClass + ":getAllCourseNames();");}
			throw new DBException("IllegalStateException. Message: " + e.getMessage());
		}
		catch(SQLException e) {
			if(Utilities.error) {Log.e(TAG, mClass + ":getAllCourseNames(); SQLException, something went wrong.");}
			throw new DBException("SQLException. Message: " + e.getMessage());
		}
		
		finally {
			db.endTransaction();
		}
		
		if(courseNames.size() == 0) {
			if(Utilities.error) {Log.e(TAG, mClass + ":getAllCourseNames(); No result was found in database");}
			throw new NoResultFoundDBException(mClass + ":getAllCourseNames(); No result was found in database");
		}
		return courseNames;
	}
	
	@Override
	public CourseBean getCourse(String courseCode) throws DBException, NoResultFoundDBException {
		if(Utilities.verbose) {Log.v(TAG, mClass + ":getCourse()");}
		
		SQLiteDatabase db = mHelper.getReadableDatabase();
		db.beginTransaction();
		CourseBean fetchedCourse = null;		
		try {
			
			Cursor cursor = db.rawQuery(RETRIEVE_COURSE, new String[] { courseCode });
			if (cursor.moveToFirst()) {
				fetchedCourse = new CourseBean(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
						cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7));
			}
			db.setTransactionSuccessful();
		}catch(NullPointerException e) {
			if(Utilities.error) {Log.e(TAG, mClass + ":getCourse()::db.insert();");}
			throw new DBException("NullPointerException. Message: " + e.getMessage());
		}
		catch(IllegalStateException e) {
			if(Utilities.error) {Log.e(TAG, mClass + ":getCourse();");}
			throw new DBException("IllegalStateException. Message: " + e.getMessage());
		}
		catch(SQLException e) {
			if(Utilities.error) {Log.e(TAG, mClass + ":getCourse(); SQLException, something went wrong.");}
			throw new DBException("SQLException. Message: " + e.getMessage());
		}
		
		finally {
			db.endTransaction();
		}
		
		if(fetchedCourse == null) {
			if(Utilities.error) {Log.e(TAG, mClass + ":getCourse(); No result was found in database for courseCode:= " + courseCode);}
			throw new NoResultFoundDBException(mClass + ":getCourse(); No result was found in database for courseCode= " + courseCode);
		}
		return fetchedCourse;
	}
}