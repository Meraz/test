package com.example.app_android;

import android.util.Log;

public final class Logger {

	private final static boolean verbose = true;
	
	private Logger() {
		
	}
	
	public static void VerboseLog(String tag, String message)
	{
		if(verbose)
			Log.v(tag, message);
	}
}
