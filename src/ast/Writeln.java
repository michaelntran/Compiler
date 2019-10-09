package ast;
import environment.*;

/**
 * The Writeln class is used for printing/outputting to the console
 * @author Michael Tran
 * @version 10/8/19
 */
public class Writeln extends Statement{
	private Expression exp;

	/**
	 * instantiates the Writeln object used to print expressions
	 * @param exp is the expression to be printed
	 */
	public Writeln(Expression exp) {
		this.exp = exp;
	}
	
	/**
	 * executes exp by printing the value of exp
	 * @param env is the Environment used for evaluating
	 */
	public void exec(Environment env)
	{
		System.out.println(exp.eval(env));
	}
}
