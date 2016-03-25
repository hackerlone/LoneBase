package gxa.util;

import java.lang.reflect.Field;

import sun.reflect.LangReflectAccess;

import com.sun.org.apache.bcel.internal.classfile.JavaClass;

public class ProcessSql {
	public static String processInsert(Object obj) {
		String sql = "insert into";

		// 通过类名获取表名
		String tablename = obj.getClass().getName().substring(7);
		sql = sql + " [" + tablename + "](";
		// 通过对象的值和成员变量名获取，字段名和字段值
		Field[] fds = obj.getClass().getDeclaredFields();
		String fdlist = "";
		String vallist = "";
		for (int i = 0; i < fds.length; i++) {
			Field fd = fds[i];// 通过遍历字段定义数组，逐一获取字段
			// System.out.println(fd.getName());
			try {
				fd.setAccessible(true);// 默认为private的字段，设置为允许访问
				Object fdval = fd.get(obj);// 获取字段的值
				if (fdval == null || fdval.equals("")) {// 如果本次循环为空值，则本字段不插入
					continue;
				}
				fdlist = ProcessSql.processComma(fdlist,
						String.valueOf(fd.getName()), i);
				// 获得字段名称
				String typename = fd.getType().getName();// 获得字段的类型名称
				System.out.println(fd.getName() + "  " + typename);
				if (typename.equals("java.lang.Integer")
						|| typename.equals("java.lang.Float")
						|| typename.equals("java.lang.Double")) {
					vallist = ProcessSql.processComma(vallist,
							String.valueOf(fd.get(obj)), i);
				} else {
					vallist = ProcessSql.processComma(vallist,
							String.valueOf("'" + fd.get(obj) + "'"), i);
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		sql = sql + fdlist + ") values(" + vallist + ")";
		// System.out.println(sql);
		return sql;
	}

	public static String processUpdate(Object obj) {
		String sql = "update";

		// 通过类名获取表名
		String tablename = obj.getClass().getName().substring(7);
		sql = sql + " [" + tablename + "]";
		// 通过对象的值和成员变量名获取，字段名和字段值
		Field[] fds = obj.getClass().getDeclaredFields();
		fds[0].setAccessible(true);
		String wherestr = "";
		try {
			wherestr = " where " + fds[0].getName() + " = " + fds[0].get(obj);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String updatelist = " set ";
		for (int i = 1; i < fds.length; i++) {
			Field fd = fds[i];// 通过遍历字段定义数组，逐一获取字段
			// System.out.println(fd.getName());
			try {
				fd.setAccessible(true);// 默认为private的字段，设置为允许访问
				Object fdval = fd.get(obj);// 获取字段的值
				// if(fdval==null||fdval.equals("")){//如果本次循环为空值，则本字段不插入
				// continue;
				// }
				// 获得字段名称
				String typename = fd.getType().getName();// 获得字段的类型名称
				// System.out.println(fd.getName()+"  "+typename);
				if (typename.equals("java.lang.Integer")
						|| typename.equals("java.lang.Float")
						|| typename.equals("java.lang.Double")) {
					updatelist = ProcessSql.processComma(updatelist,
							fd.getName(), String.valueOf(fd.get(obj)), i);
				} else {
					updatelist = ProcessSql.processComma(updatelist,
							fd.getName(),
							String.valueOf("'" + fd.get(obj) + "'"), i);
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		sql = sql + updatelist + wherestr;
		System.out.println(sql);
		return sql;
	}

	public static String processComma(String strlist, String name, String val,
			int i) {
		if (i == 1) {
			strlist += name + "=" + val;
		} else {
			strlist += "," + name + "=" + val;
		}
		return strlist;
	}

	public static String processComma(String strlist, String str, int i) {
		if (i == 0) {
			strlist += str;
		} else {
			strlist += "," + str;
		}
		return strlist;
	}

	public static String processPk(String oldPk) {
		String str = "";
		for (int i = 0; i < oldPk.length(); i++) {
			char c = oldPk.charAt(i);
			if (c != '0') {
				str = oldPk.substring(i);

				break; // 退出循环
			}

		}
		
		int a=Integer.parseInt(str)+1;
	     
		 str=String.valueOf(a);
	     int len=oldPk.length()-str.length();
		for(int i=0;i<len;i++){
			str="0"+str;
			
		}
		
		
    return str;
    
	}
	
	public static void main(String[] args) {
		
		System.out.println(processPk("0010101020"));
	}
}
