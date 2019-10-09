package ast;
import environment.*;

/**
 * The BinOp class is used as an expression that is a combination of two expressions
 * @author Michael Tran
 * @version 10/8/19
 */
public class BinOp extends Expression{
	private String op;
	private Expression exp1;
	private Expression exp2;
	
	/**
	 * instantiates the BinOp object with the two expressions
	 * and the operator that connects them (exp1 op exp2)
	 * @param op is the operator that goes between exp1 and exp2 to join them
	 * @param exp1 is the first expression
	 * @param exp2 is the second expression
	 */
	public BinOp(String op, Expression exp1, Expression exp2) {
		this.op = op;
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	/**
	 * evaluates the value of the BinOp (exp1 op exp2)
	 * @param env is the environment that is passed to the eval methods of exp1 and exp2
	 * @return the value of exp1 op exp2
	 */
	public int eval(Environment env)
	{
		if(op.equals("+"))
			return exp1.eval(env) + exp2.eval(env);
		else if(op.equals("-"))
			return exp1.eval(env) - exp2.eval(env);
		else if(op.equals("*"))
			return exp1.eval(env) * exp2.eval(env);
		else if(op.equals("/"))
			return exp1.eval(env) / exp2.eval(env);
		else
			return exp1.eval(env) % exp2.eval(env);
	}
}
