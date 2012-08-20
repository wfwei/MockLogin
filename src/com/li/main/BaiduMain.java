package com.li.main;

/**
 *  主方法
 * @author Legend、
 * http://topic.csdn.net/u/20110829/17/3650098a-8a43-4e7d-92e6-406a384e646a.html
 */
public class BaiduMain {

	
public static void main(String[] args) throws Exception {
        
	//验证账号并获取cookie
		String cookie  =  BaiduTieBaNDWS.testAccount("lp312160599", "13110420122");
		
		System.out.println(cookie);
		//发帖
		String info = BaiduTieBaNDWS.reply("这个贴狠牛B啊！！", "http://tieba.baidu.com/p/1210817094?pn=1&v=0", cookie);
		//打印返回信心
		System.out.println(info);
	}
}
