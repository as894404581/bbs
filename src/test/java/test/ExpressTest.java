package test;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException; 
public class ExpressTest {
	 
	      
	    public static void main(String[] args) throws ScriptException  {  
	    		ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
	        String str = "(100-1)+(100+1)/2";
	        double d = (Double) se.eval(str);
	        System.out.println(d);
	    }  
}
