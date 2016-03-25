package com.mpqi.leanclouddemo.app;

import java.util.Arrays;
import java.util.List;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.CountCallback;
import com.avos.avoscloud.DeleteCallback;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.GetCallback;
import com.avos.avoscloud.SaveCallback;

import android.app.Application;
import android.util.Log;

public class myApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		// 如果使用美国节点，请加上这行代码 AVOSCloud.useAVCloudUS();
		AVOSCloud.initialize(this, "1NqhM5FLPGaoKoISURt3grfW",
				"NsolKxc1VRcMTyow7vCTpkyC");

		// avObjectSave();// 同步 保存
		// avObjectQuery();// 同步 查询 需要自己新开一个线程

		// saveInbackground();//异步 保存
		// queryInbackground();// 异步 查询

		// update();// 更新
		// updateWithOutData();// 更新
		// updateNew();

		// remove();
		// deleteInbackground();

		// pointerSave();
		// pointerSvaveStay();

		// selectInbackground();//条件查询
//		selectLike();
//		countInbackground();
		
		selectEqualTo();
	}

	// ==========================day24============================================
	
	private void selectEqualTo(){//使用条件匹配  进行关系查询
		AVObject myPost = AVObject.createWithoutData("Post", "564949b200b0d1db33734b33");
		
		AVQuery<AVObject> query = AVQuery.getQuery("Comment");
		query.whereEqualTo("post", myPost);
		query.findInBackground(new FindCallback<AVObject>() {
		  public void done(List<AVObject> commentList, AVException e) {
		    // myPost 关联的所有评论都在 commentList 里了。
			  for (AVObject avObject : commentList) {
				Log.i("test", avObject.getString("content"));
			}
		  }
		});
	}
	
	private void countInbackground(){//查询记录条数
		AVQuery<AVObject> query = AVQuery.getQuery("Post");
		query.whereEqualTo("pubUser", "LeanCloud官方客服");
		query.countInBackground(new CountCallback() {
		  public void done(int count, AVException e) {
		    if (e == null) {
		      // The count request succeeded. Log the count
		      Log.i("succeeded", "LeanCloud官方客服 发布了 " + count + " 条微博");
		    } else {
		      // The request failed
		    }
		  }
		});
	}
	
	private void selectLike() {// 模糊查询 类似于 Mysql的 Like
		// 查找出所有 username 以 LeanCloud 开头的用户
		AVQuery<AVObject> query = AVQuery.getQuery("_User");
		query.whereStartsWith("username", "LeanCloud");

		query.findInBackground(new FindCallback<AVObject>() {

			@Override
			public void done(List<AVObject> avObjects, AVException e) {
				if (e == null) {// 查询成功
					Log.i("test", "模糊查询成功");
					for (AVObject avObject : avObjects) {
						String userName = avObject.getString("username");
						String pwd = avObject.getString("password");
						Log.i("test", userName + "\t  " + pwd);
					}
				} else {// 查询失败
					e.printStackTrace();
					Log.i("test", "模糊查询失败");
				}
			}
		});
	}

	private void selectInbackground() {// 条件查询
		AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
		// query.whereEqualTo("pubUser", "LeanCloud官方客服");

		// String[] names = {"LeanCloud官方客服", "LeanCloud江宏", "滚滚艾买提"};
		// query.whereContainedIn("pubUser", Arrays.asList(names));

		String[] names = { "LeanCloud官方客服", "LeanCloud江宏", "滚滚艾买提" };
		query.whereNotContainedIn("pubUser", Arrays.asList(names));

		query.findInBackground(new FindCallback<AVObject>() {// 查询之后的回调函数

			@Override
			public void done(List<AVObject> avObjects, AVException e) {
				if (e == null) {// 查询成功
					Log.i("test", "条件查询成功");
					for (AVObject avObject : avObjects) {
						String content = avObject.getString("content");
						String userName = avObject.getString("pubUser");
						int userVerified = avObject
								.getInt("pubUserCertificate");
						Log.i("test", content + "\t  " + userName + "\t  "
								+ userVerified);
					}
				} else {// 查询失败
					Log.i("test", "条件查询失败");
				}

			}
		});
	}

	private void select() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// 使用普通 增删查改

			}
		}).start();
	}

	// ==========================day23============================================

	private void pointerSvaveStay() {// 为已经有的微博添加评论

		// 创建评论信息
		AVObject myComment = new AVObject("Comment");
		myComment.put("content", "我是一条测试的新评论，诶嘿嘿！");

		// 把评论关联到 objectId 为 5590cdfde4b00f7adb5860c8 的这条微博上
		myComment.put("post",
				AVObject.createWithoutData("Post", "564949b200b0d1db33734b33"));
		myComment.saveInBackground();
	}

	private void pointerSave() {// 两个AVObject 之间的关系
		// 创建微博信息
		AVObject myWeibo = new AVObject("Post");
		myWeibo.put("content", "作为一个程序员，你认为回家以后要不要继续写代码？");

		// 创建评论信息
		AVObject myComment = new AVObject("Comment");
		myComment.put("content", "我若是写代码，进入状态之后最好不要停。下不下班已经不重要了，那种感觉最重要。");

		// 添加一个关联的微博对象
		// 如果需要预先建表，可以在 Comment 表中建立一个 Pointer 属性的 post 列；一般情况下不需要这么做。
		myComment.put("post", myWeibo);

		// 这将保存两条数据，分别为微博信息和评论信息
		myComment.saveInBackground();
	}

	private void remove() {// 删除某字段的值
		AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
		query.getInBackground("56494a3260b20fc970b97ff4",
				new GetCallback<AVObject>() {

					@Override
					public void done(AVObject post, AVException arg1) {
						post.remove("content");
						post.saveInBackground();
					}

				});
	}

	private void deleteInbackground() {// 删除一整条数据
		AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
		query.getInBackground("5649795160b294bc126b769d",
				new GetCallback<AVObject>() {

					@Override
					public void done(AVObject arg0, AVException arg1) {
						if (arg0 != null) {
							arg0.deleteInBackground(new DeleteCallback() {

								@Override
								public void done(AVException e) {
									if (e == null) {
										// 删除成功
										Log.i("test", "删除成功");
									} else {
										// 更新失败
										Log.i("test", "删除失败");
									}

								}
							});
						}

					}
				});
	}

	private void update() {// 跟新数据 首先查询一个avobject对象 包含有ID 与 所有字段的值
		AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
		// 通过id 查找到制定的 数据
		query.getInBackground("56494a3260b20fc970b97ff4",
				new GetCallback<AVObject>() {

					@Override
					public void done(AVObject post, AVException e) {
						if (e == null) {// 查询成功
							if (post != null) {
								post.put(
										"content",
										"3333333每个Java程序员必备的8个开发工具 —— http://itindex.net/detail/52950-java-%E5%BC%80%E5%8F%91-%E5%B7%A5%E5%85%B7");
								post.saveInBackground(new SaveCallback() {

									@Override
									public void done(AVException e) {
										if (e == null) {
											Log.i("test", "更新成功");
										} else {
											// 更新失败
											Log.i("test", "更新失败");
										}

									}
								});
							}
						} else {
							// 查询失败
						}

					}
				});
	}

	private void updateWithOutData() {// 更新数据 只关心ID 和 需要更新的字段与该字段的新内容
		// 知道 objectId，创建 AVObject
		AVObject post = AVObject.createWithoutData("Post",
				"564975d000b0bf37d846c42d");
		// 更新属性
		post.put(
				"content",
				"44444444每个Java程序员必备的8个开发工具 —— http://itindex.net/detail/52950-java-%E5%BC%80%E5%8F%91-%E5%B7%A5%E5%85%B7");
		// 保存
		post.saveInBackground();
	}

	private void updateNew() {// 更新数据 只关心ID 和 需要更新的字段与该字段的新内容
		// 知道 objectId，创建 AVObject
		AVObject post = new AVObject("Post");
		post.put("objectId", "564975d000b0bf37d846c42d");
		// 更新属性
		post.put(
				"content",
				"55555544444444每个Java程序员必备的8个开发工具 —— http://itindex.net/detail/52950-java-%E5%BC%80%E5%8F%91-%E5%B7%A5%E5%85%B7");
		// 保存
		post.saveInBackground();
	}

	private void saveInbackground() {// 异步 保存
		AVObject post = new AVObject("Post");
		post.put("content", "1111111居有良田，食有黍稷；躬耕山間，優游人世；生之所往，不過良風年年。");
		post.put("pubUser", "LeanCloud官方客服22222");
		post.put("pubUserAvatar",
				"http://tp1.sinaimg.cn/3652761852/50/5730347813/0");
		post.put("pubUserCertificate", 6); // 4 表示微博机构认证，假设的。
		post.put("pubTimestamp", 1435540999);
		post.saveInBackground(new SaveCallback() {// 保存之后的结果回掉函数

			@Override
			public void done(AVException e) {
				if (e == null) {
					// 保存成功了
					Log.i("test", "保存成功");
				} else {
					// 保存失败
				}

			}
		});
	}

	private void queryInbackground() {// 异步 查询
		// 表名 类名 Post
		AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
		AVObject post;
		// 通过id 查找到制定的 数据
		query.getInBackground("56494a3260b20fc970b97ff4",
				new GetCallback<AVObject>() {

					@Override
					public void done(AVObject post, AVException e) {
						if (e == null) {// 查询成功
							// 查询到记录后，获取内容
							if (post != null) {
								String content = post.getString("content");
								String userName = post.getString("pubUser");
								int userVerified = post
										.getInt("pubUserCertificate");
								Log.i("test", content + "\t" + userName + "\t"
										+ userVerified);
								String tmp = post.toString();
								try {
									AVObject myPost = AVObject
											.parseAVObject(tmp);
									Log.i("test", "反序列化之后的结果:" + content + "\t"
											+ userName + "\t" + userVerified);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						} else {
							// 查询失败
						}

					}
				});
	}

	private void avObjectQuery() {// 查询
		new Thread(new Runnable() {

			@Override
			public void run() {
				// 表名 类名 Post
				AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
				AVObject post;
				// 通过id 查找到制定的 数据
				try {
					post = query.get("56494a3260b20fc970b97ff4");

					// 查询到记录后，获取内容
					if (post != null) {
						String content = post.getString("content");
						String userName = post.getString("pubUser");
						int userVerified = post.getInt("pubUserCertificate");
						Log.i("test", content + "\t" + userName + "\t"
								+ userVerified);
					}
				} catch (AVException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();

	}

	private void avObjectSave() {// 保存
		new Thread(new Runnable() {

			@Override
			public void run() {
				AVObject post = new AVObject("Post");
				post.put("content", "居有良田，食有黍稷；躬耕山間，優游人世；生之所往，不過良風年年。");
				post.put("pubUser", "LeanCloud官方客服");
				post.put("pubUserAvatar",
						"http://tp1.sinaimg.cn/3652761852/50/5730347813/0");
				post.put("pubUserCertificate", 4); // 4 表示微博机构认证，假设的。
				post.put("pubTimestamp", 1435540999);
				try {
					post.save();
				} catch (AVException e) {
					// e.getMessage() 捕获的异常信息
				}

			}
		}).start();
	}
}
