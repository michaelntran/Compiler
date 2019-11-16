package ast;
import environment.Environment;
import emitter.Emitter;

/**
 * The Expression abstract class is used to represent any form of expressions used by the parser
 * @author Michael Tran
 * @version 10/8/19
 */
public abstract class Expression {
	/**
	 * evaluates the value of the expression
	 * @param env is the environment used for evaluating
	 * @return the int value of the expression
	 */
	public abstract int eval(Environment env);
	
	public void compile(Emitter e)
	{
		throw new RuntimeException("Implement me!");
	}
}
