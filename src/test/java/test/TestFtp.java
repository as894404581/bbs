package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
public class TestFtp {
	FTPClient ftp;
	@Test
	public  void TestMakeDirectory() {
		ftp=new FTPClient();
		try {
			ftp.connect("45.78.14.158",21);
			ftp.setControlEncoding("UTF-8");
			
			if(ftp.login("admin", "as77889900")){
				System.out.println("登录成功");
			}else{
				System.out.println("登录失败");
			}
			
			if(changeCreateWork("a/b/c/d/e/f/g/h/i/j/k/l/m/n")){
				System.out.println("更改文件夹成功");
			}else{
				System.out.println("更改文件夹失败");
			}
				
			
			if(uploadFile(new File("/Users/zheng/Downloads/2017/02/19/401a467b-593c-41bd-862e-f7d75ce2354d.PNG"))){
				System.out.println("上传成功");
			}else{
				System.out.println("上传失败");
			}
			
			
		} catch (SocketException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * ftp创建文件夹
	 * @param file 更改远程服务器路径
	 * @return 是否更改成功
	 * @throws IOException
	 */
	public boolean changeCreateWork(String file) throws IOException{
		String[] files=file.split("/");
		for (String string : files) {
			ftp.makeDirectory(string);
			if(!ftp.changeWorkingDirectory(string)){
				return false;
			}
		}
		return true;
	}
	/**
	 * 上传文件
	 * @param FileUrl 文件路径
	 * @return 是否上传成功
	 * @throws IOException
	 */
	public boolean uploadFile(File FileUrl) throws IOException{
		InputStream is=new FileInputStream(FileUrl);
		boolean flag=false;
		if(ftp.storeFile(FileUrl.getName(), is)){
			flag=true;
		}
		is.close();
		return flag;	
	}
}
