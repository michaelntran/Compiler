package ast;

import emitter.Emitter;
import environment.Environment;

/**
 * The While class represents while statements for the Compiler
 * @author Michael Tran
 * @version 10/8/19
 */
public class While extends Statement {
	private Condition cond;
	private Statement stmt;
	
	/**
	 * instantiates the While object with a given condition and statement
	 * @param cond is the condition used for the while loop
	 * @param stmt is the statement to be executed as long as cond is true
	 */
	public While(Condition cond, Statement stmt) {
		this.cond = cond;
		this.stmt = stmt;
	}
	
	/**
	 * executes the While by executing stmt as long as cond is true
	 * @param env is the Environment used for execution and evaluation
	 */
	public void exec(Environment env)
	{
		while(cond.eval(env) == 1)
			stmt.exec(env);
	}

	public void compile(Emitter e)
	{
		String whileLabel = "while" + e.nextLabelID();
		String endLabel = "endif" + e.nextLabelID();
		e.emit(whileLabel + ":");
		cond.compile(e, endLabel);
		stmt.compile(e);
		e.emit("j " + whileLabel);
		e.emit(endLabel + ":");
	}
}
