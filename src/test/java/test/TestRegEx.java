package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestRegEx {
	@Test
	public void test(){
		// 要验证的字符串
	    String str = "<br><br><br><br><br><br><br><div style='text-align: center;'>[img]99[/img]</div>";
	    // 邮箱验证规则
	    String regEx = "\\[img\\]\\d*\\[/img\\]";
	    // 编译正则表达式
	    //Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pat.matcher(str);
	    // 字符串是否与正则表达式相匹配
	   while (matcher.find()) {
		System.out.println(matcher.group(0));
	   }
	   
	   
	}
	@Test
	public void test1(){
		if(System.getProperty("os.name").toUpperCase().startsWith("MAC OS X")){
			System.out.println("MAC OS X");
		}else if(System.getProperty("os.name").toUpperCase().startsWith("Linux")){
			System.out.println("Linux");
		}else{
			System.out.println("Windows");
		}
		System.out.println(System.getProperty("line.separator").equals("\r"));
		System.out.println("1\r2");
		System.out.println("3\n4");
	}
}
