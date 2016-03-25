package com.mpqi.myjiujiujintu.util;

import android.util.Log;

public class JLog {
	private static boolean infoFLAG = true;
	public final static String LogTest ="test";

	public static void i(String tag, String msg) {
		if (infoFLAG) {
			Log.i(tag, msg);
		}
	}
	
	public static void iTest(String msg) {
		i(LogTest, msg);
	}
}
