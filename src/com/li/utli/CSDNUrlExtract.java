//package com.li.utli;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.http.util.EntityUtils;
//
//import com.li.bean.Result;
//import com.li.main.CSDN;
//
//public class CSDNUrlExtract {
//    
//	public static void cSDNShuFen(String cookie) throws Exception{
//		
//		long startt = System.currentTimeMillis();
//		
//		Result result = SendRequest.sendGet("http://download.csdn.net/", null, null,"utf-8" );
//		
//		String sort = EntityUtils.toString(result.getHttpEntity(),"utf-8");
//		
//		List<String> sortList = HtmlParse.prase(sort, "/sort/class/\\d{5}");
//		
//		
//		for (int i = 0; i < sortList.size(); i++) {
//			try{
//				Result classResult = SendRequest.sendGet("http://download.csdn.net"+sortList.get(i)+"/1", null, null, "utf-8");
//				String classsAll = EntityUtils.toString(classResult.getHttpEntity(),"utf-8");
//				String page = HtmlParse.prase(classsAll,"<a href=\"http://download.csdn.net/sort/class/\\d+/\\d+\">末页</a>" , 1).get(0);
//				page = page.split("\"")[1];
//				page = page.substring(page.lastIndexOf("/")+1);
//				
//				for (int j = 1; j <=Integer.parseInt(page); j++) {
//					classResult = SendRequest.sendGet("http://download.csdn.net"+sortList.get(i)+"/"+j, null, null, "utf-8");
//					classsAll = EntityUtils.toString(classResult.getHttpEntity(),"utf-8");
//					List<String> sorce = HtmlParse.prase(classsAll, "http://download.csdn.net/source/\\d+");
//					for (String string : sorce) {
//						String addressHtml = null;
//						String address = null;
//						String acommentLink =null;
//						Result downResult = null;
//						String down = null;
//						Result addressResult = null;
//						try {
//							downResult = SendRequest.sendGet(string, null, null, "utf-8");
//							down =EntityUtils.toString(downResult.getHttpEntity(),"utf-8");
//							down = HtmlParse.prase(down, "http://d.download.csdn.net/down/\\d+/.{3,21}>",1).get(0);
//							down = down.substring(0,down.length()-2);
//							addressResult = SendRequest.sendGet(down, null, null, "utf-8");
//							addressHtml= EntityUtils.toString(addressResult.getHttpEntity(),"utf-8");
//							address = HtmlParse.prase(addressHtml, "http://d.download.csdn.net/index.php/new/download/dodownload/\\d+/.{3,21}/\\w+",1).get(0);
//							acommentLink = HtmlParse.prase(addressHtml, "http://download.csdn.net/source/\\d+",1).get(0);
//							CSDN.downLoadAndAcomment(cookie,address,acommentLink);
//						} catch (Exception e) {
//						    continue;
//						}
//					}
//				}
//			}catch (Exception e) {
//				 continue;
//			}
//			
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("耗时"+(end-startt));
//	}
//	
//	public static void  download(String cookie) throws Exception{
//		int page = 220;
//
//		for (int i = 62; i < page; i++) {
//			
//			String html  = EntityUtils.toString(SendRequest.sendGet("http://search.download.csdn.net/search/java+%E8%AE%BA%E6%96%87%5Efield%3D*/"+i, null, null, "utf-8").getHttpEntity());
//			List<String> sorce = HtmlParse.prase(html, "http://download.csdn.net/source/\\d+");
//			sorce = new ArrayList<String>(sorce.subList(0, 6));
//			
//			for (String string : sorce) {
//				String addressHtml = null;
//				String address = null;
//				String acommentLink =null;
//				Result downResult = null;
//				String down = null;
//				Result addressResult = null;
//				try {
//					downResult = SendRequest.sendGet(string, null, null, "utf-8");
//					down =EntityUtils.toString(downResult.getHttpEntity(),"utf-8");
//					down = HtmlParse.prase(down, "http://d.download.csdn.net/down/\\d+/.{3,21}>",1).get(0);
//					down = down.substring(0,down.length()-2);
//					addressResult = SendRequest.sendGet(down, null, null, "utf-8");
//					addressHtml= EntityUtils.toString(addressResult.getHttpEntity(),"utf-8");
//					address = HtmlParse.prase(addressHtml, "http://d.download.csdn.net/index.php/new/download/dodownload/\\d+/.{3,21}/\\w+",1).get(0);
//					acommentLink = HtmlParse.prase(addressHtml, "http://download.csdn.net/source/\\d+",1).get(0);
//					CSDN.downLoadAndAcomment(cookie,address,acommentLink);
//				} catch (Exception e) {
//				    continue;
//				}
//			}
//		}
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
