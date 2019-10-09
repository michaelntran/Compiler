package ast;
import environment.*;

/**
 * The Number class represents an int used in expressions
 * @author Michael Tran
 * @version 10/8/19
 */
public class Number extends Expression{
	private int value;
	
	/**
	 * instantiates Number with an int value
	 * @param value is the value assigned to this Number
	 */
	public Number(int value)
	{
		this.value = value;
	}
	
	/**
	 * evaluate the value of this Number
	 * @param env is the Environment used for evaluating
	 * @return the value of the Number
	 */
	public int eval(Environment env)
	{
		return value;
	}
}
