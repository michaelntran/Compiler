package ast;
import environment.Environment;
import emitter.Emitter;

/**
 * The Statement abstract class is used to represent any form of statements used by the parser
 * @author Michael Tran
 * @version 10/8/19
 */
public abstract class Statement {
	/**
	 * executes the Statement
	 * @param env is the Environment used for execution
	 */
	public abstract void exec(Environment env);
	
	public void compile(Emitter e)
	{
		throw new RuntimeException("Implement me!");
	}
}
