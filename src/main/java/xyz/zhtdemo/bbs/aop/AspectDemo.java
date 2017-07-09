package xyz.zhtdemo.bbs.aop;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.PrintWriter;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//import javax.annotation.PostConstruct;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


//Aspect切面,横截面
/*
 * 切面组件如果需要使用必须配置使用,必须在Spring配置文件配置
 */
@Component
@Aspect
public  class AspectDemo {
	
	

//	private BlockingQueue<String> queue = new LinkedBlockingQueue<String>(500);
	public AspectDemo() {
		System.out.println("AspectDemo");
	}
	@Around("bean(*Servlet)")
	public Object test(ProceedingJoinPoint joinPoint) throws Throwable {
		long t1 = System.currentTimeMillis();
		// 调用业务层方法
		Object obj = joinPoint.proceed();
		long t2 = System.currentTimeMillis();
		// 计算业务层方法消耗的时间
		// 获取当前线程
		Signature s = joinPoint.getSignature();
		// 将需要保存的数据添加到队列中
		String str = s + "," + (t2 - t1);
		System.out.println(str);
		// 将需要保存的数据添加到队列
		//queue.offer(str);

		return obj;
	}

	//private File file=new File(Config.LogFile);
//	private File file=new File("");

	// 从配置文件config中获取logfile属性
	// 添加配置文件config.properties
	// 配置文件中包含属性logfile
	// spring中读取配置文件为Bean config
//	public void setFilename() {
//		file = new File("");
//	}

	// 创建bean组件以后立即执行的方法
//	@PostConstruct
//	public void start() {
//		// Bean组件TimerAspect以后立即启动线程
//		t.start();
//	}
//
//	private Thread t = new Thread() {
//		public void run() {
//			
//			try {
//				while (true) {
//					//take从队列中取出一个数据
//					//如果没有数据,则等到有数据为止
//					String s = queue.take();
//					// 打开文件(追加方式)
//					PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
//					pw.println(s);
//					while (!queue.isEmpty()) {
//						// 写数据
//						s=queue.take();
//						System.out.println(s);
//						pw.print(s);
//					}
//					// 关闭文件
//					pw.close();
//				}
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			} catch (FileNotFoundException e) {
//				
//				e.printStackTrace();
//			}
//		}
//	};
}
