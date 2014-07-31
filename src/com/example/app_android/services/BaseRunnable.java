package com.example.app_android.services;

import com.example.app_android.util.Logger;

import android.content.Intent;

public abstract class BaseRunnable implements Runnable  {
	
	protected static final String TAG = "Services";
	protected String mClassName;

	protected Intent mIntent;
	protected MyService mService;

	protected int mBroadcastID;
	
	protected String mStartBroadcast;
	protected String mUpdateBroadcast;
	protected String mStopBroadcast;
	
	public BaseRunnable(MyService service, Intent intent) {
    	mIntent = intent;	 
    	mService = service;
    	mClassName = getClass().getSimpleName();
    	mBroadcastID = intent.getIntExtra("id", -1);
    	
    	mStartBroadcast 	= mIntent.getStringExtra("startBroadcast");
    	mUpdateBroadcast 	= mIntent.getStringExtra("updateBroadcast");
    	mStopBroadcast 		= mIntent.getStringExtra("stopBroadcast");
    }	
	
	// Add threadcount
    protected void informStart() {
		Logger.VerboseLog(TAG, mClassName + "::entered informStart()");
    	mService.informWorkerStart();
    }
	
	// Remove thread from service
    protected void informStop() {
		Logger.VerboseLog(TAG, mClassName + "::entered informStop()");
    	mService.informWorkerStop(mBroadcastID);

    }
    
    protected Intent prepareDefaultIntent(String broadCastString) {
		Logger.VerboseLog(TAG, mClassName + "::entered prepareDefaultIntent()");
		Intent intent = new Intent(broadCastString);
		intent.putExtra("id", mBroadcastID);
		return intent;
    }

	@Override 
	abstract public void run();

}