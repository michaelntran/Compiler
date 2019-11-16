package ast;
import emitter.Emitter;
import environment.*;

/**
 * The If class represents if statements for the compiler
 * @author Michael Tran
 * @version 10/8/19
 */
public class If extends Statement{
	private Condition cond;
	private Statement stmt;
	
	/**
	 * instantiates the If class using a condition and a statement
	 * @param cond is the condition to determine whether stmt should be executed
	 * @param stmt to be possibly executed depending on cond
	 */
	public If(Condition cond, Statement stmt) {
		this.cond = cond;
		this.stmt = stmt;
	}
	
	/**
	 * if cond is true(value = 1), then execute stmt
	 * @param env is used to execute and evaluate stmt and cond respectively
	 */
	public void exec(Environment env)
	{
		if(cond.eval(env) == 1)
			stmt.exec(env);
	}
	
	public void compile(Emitter e)
	{
		String label = "endif" + e.nextLabelID();
		cond.compile(e, label);
		stmt.compile(e);
		e.emit(label + ":");
	}
}
