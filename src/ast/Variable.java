package ast;
import environment.*;

/**
 * The Variable class represents a variable for the ast
 * @author Michael Tran
 * @version 10/8/19
 */
public class Variable extends Expression{
	private String name;
	
	/**
	 * instantiates the Variable object with the name of the variable in String form
	 * @param name is the name of the Variable as a String
	 */
	public Variable(String name)
	{
		this.name = name;
	}
	
	/**
	 * evaluates the Variable by returning the value of that variable in the given Environment
	 * @param env is the Environment used for evaluation
	 * @return the value of the variable with the name name in env
	 */
	public int eval(Environment env)
	{
		return env.getVariable(name);
	}
}
