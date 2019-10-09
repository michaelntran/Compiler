package ast;
import environment.*;

/**
 * The Assignment class is used as a statement to signify the
 * modification or creation of a variable
 * @author Michael Tran
 * @version 10/8/19
 */
public class Assignment extends Statement{
	private String var;
	private Expression exp;
	
	/**
	 * instantiates the assignment
	 * @param var is the name of the variable to be modified
	 * @param exp is the expression that will be the value of var
	 */
	public Assignment(String var, Expression exp) {
		this.var = var;
		this.exp = exp;
	}
	
	/**
	 * update the value of var to the calculated value of exp using a given environment
	 * @param env is the environment that will have the updated var
	 */
	public void exec(Environment env)
	{
		env.setVariable(var, exp.eval(env));
	}
}
