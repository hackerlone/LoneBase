package com.mpqi.homewrokday07.cfg;

import java.util.HashMap;
import java.util.List;

import com.mpqi.homewrokday07.R;

public class Users {
	private static HashMap users;

	public static HashMap getUsers() {
		if (users == null) {
			initUsers();
		}
		return users;
	}

	/**
	 * 初始化用户集合
	 */
	private static void initUsers() {
		users = new HashMap();

		User user = new User("ylc","叶良辰", "yeliangchen",
				"我叶良辰有一百种方式，让你在这个城市混不下去，而你，无可奈何", R.drawable.bierde_75);
		users.put(user.getUsername(), user);
	}
	
	public boolean getUsersData(User user){
		
		return false;
	}
	
	public User addUser(){
		
		return null;
	}
}
