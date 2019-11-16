package ast;

import environment.Environment;

/**
 * The Relop class is used to represent relational operators for the compiler
 * @author Michael Tran
 * @version 10/8/19
 */
public class Relop extends Expression {
	private String op;
	
	/**
	 * instantiates the Relop object with the relational operator in string form
	 * @param op is the relational operator in string form
	 */
	public Relop(String op)
	{
		this.op = op;
	}
	
	/**
	 * returns the type of relational operator based on its int value
	 * 0 is =
	 * 1 is <>
	 * 2 is <
	 * 3 is >
	 * 4 is <=
	 * 5 is >=
	 * @param env is the Environment used for evaluation
	 * @return the int value of the relational operator
	 */
	public int eval(Environment env) {
		/*
		 * 0 is =
		 * 1 is <>
		 * 2 is <
		 * 3 is >
		 * 4 is <=
		 * 5 is >=
		 */
		if(op.equals("="))
		{
			return 0;
		}
		else if(op.equals("<>"))
		{
			return 1;
		}
		else if(op.equals("<"))
		{
			return 2;
		}
		else if(op.equals(">"))
		{
			return 3;
		}
		else if(op.equals("<="))
		{
			return 4;
		}
		else
		{
			return 5;
		}
	}
	
	public String getOp()
	{
		return op;
	}
}
