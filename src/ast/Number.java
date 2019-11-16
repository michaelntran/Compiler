package ast;
import emitter.Emitter;
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
	
	/**
	 * emits the assembly code for assigning the value of the number to $v0
	 * to the given emitter
	 * @param e is the given emitter
	 */
	public void compile(Emitter e)
	{
		e.emit("li $v0 " + value);
	}
}
