package ast;
import environment.*;

/**
 * The Condition class respresents a condition used for if and while statements
 * @author Michael Tran
 * @version 10/8/19
 */
public class Condition extends Expression{
	private Relop op;
	private Expression exp1;
	private Expression exp2;
	
	/**
	 * instantiates the condition using two expressions connected by a relational operator
	 * @param op is the relational operator joining the two expressions
	 * @param exp1 is the first expression
	 * @param exp2 is the second expression
	 */
	public Condition(Relop op, Expression exp1, Expression exp2) {
		this.op = op;
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	/**
	 * evaluates the condition using exp1 op exp2
	 * @param env is the environment used to evaluate the relop and the expressions
	 * @return 0 if condition is false, 1 if condition is true
	 */
	public int eval(Environment env)
	{
		/*
		 * 0 is false
		 * 1 is true
		 */
		if(op.eval(env) == 0)
		{
			if(exp1.eval(env) == exp2.eval(env))
				return 1;
			return 0;
		}
		else if(op.eval(env) == 1)
		{
			if(exp1.eval(env) != exp2.eval(env))
				return 1;
			return 0;
		}
		else if(op.eval(env) == 2)
		{
			if(exp1.eval(env) < exp2.eval(env))
				return 1;
			return 0;
		}
		else if(op.eval(env) == 3)
		{
			if(exp1.eval(env) > exp2.eval(env))
				return 1;
			return 0;
		}
		else if(op.eval(env) == 4)
		{
			if(exp1.eval(env) <= exp2.eval(env))
				return 1;
			return 0;
		}
		else
		{
			if(exp1.eval(env) >= exp2.eval(env))
				return 1;
			return 0;
		}
	}
}
