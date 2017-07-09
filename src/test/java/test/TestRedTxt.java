package test;

import java.io.File;

public class TestRedTxt {
	public static void main(String[] args) {
		String path="/Volumes/Untitled/百度云/小说/";
		  File file=new File(path);
		  File[] tempList = file.listFiles();
		  System.out.println("该目录下对象个数："+tempList.length);
		  for (int i = 0; i < tempList.length; i++) {
		   if (tempList[i].isFile()) {
		    System.out.println("文件："+tempList[i]);
		   }
		   if (tempList[i].isDirectory()) {
		    System.out.println("文件夹："+tempList[i]);
		   }
		  }
		 
	}
}
