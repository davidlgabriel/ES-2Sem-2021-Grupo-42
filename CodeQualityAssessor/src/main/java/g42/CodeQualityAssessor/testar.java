package g42.CodeQualityAssessor;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class testar {

	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager sem = new ScriptEngineManager();
		System.out.println(sem.getEngineFactories().size());
		ScriptEngine se = sem.getEngineByName("nashorn");
		
		int num = 5;
		
		se.put("num", num);
		se.put("dfghj", 0);
		se.put("num2", 2);
		
		String expression = "num > 3 && num2 < 5";
		
		String result = se.eval(expression).toString();
		  if (result.equals("true")) {
		      System.out.print("The expression " + expression + " is true.");
		  } else {
		       System.out.print("The expression " + expression + " is not true.");
		  }
	}
}