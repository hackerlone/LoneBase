package com.mpqi.homewrokday07.cfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mpqi.homewrokday07.R;

public class Users {
	private static HashMap<String, User> users;

	public static HashMap<String, User> getUsers() {
		if (users == null) {
			initUsers();
		}
		return users;
	}

	/**
	 * 初始化用户集合
	 */
	private static void initUsers() {
		users = new HashMap<String, User>();

		User user = new User("ylc", "叶良辰", "yeliangchen",
				"我叶良辰有一百种方式，让你在这个城市混不下去，而你，无可奈何", R.drawable.bierde_75);
		users.put(user.getUsername(), user);
	}

	/**
	 * 登录
	 * 
	 * @param username
	 *            用户名
	 * @param pwd
	 *            密码
	 * @return 当用户名对应的数据源中的用户密码 适配的时候 为true 则登录成功 否则 false 失败
	 */
	public static boolean login(String username, String pwd) {
		boolean flag = false;

		User user = getUsers().get(username);
		flag = user.getPwd().equals(pwd);
		return flag;
	}

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	public static void addUser(User user) {
		getUsers().put(user.getUsername(), user);
	}

	/**
	 * 检查用户名是否已经存在
	 * 
	 * @param username
	 * @return true 存在 false 不存在
	 */
	public static boolean isUser(String username) {
		return getUsers().get(username) != null;
	}

	/**
	 * 获取所有注册用户的集合
	 * 
	 * @return 用户集合对象 用于BaseAdapter
	 */
	public static List<User> getAllUsers() {
		return new ArrayList<User>(users.values());
	}

	/**
	 * 获取所有注册用户的集合
	 * 
	 * @return 用户Map集合对象 用于SimpleApater
	 */
	public static List<Map<String, Object>> getAllUsersMaps() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (User user : users.values()) {
			Map map = new HashMap<String, Object>();
			map.put(User.USERNAME, user.getUsername());
			map.put(User.NAME, user.getName());
			map.put(User.PWD, user.getPwd());
			map.put(User.HEAD, user.getHead());
			list.add(map);
		}

		return list;
	}
	
	/**
	 * 通过用户名 获取用户
	 * @param username
	 * @return 用户对象
	 */
	public static User getUserByUserName(String username){
		return getUsers().get(username);
	}
}
