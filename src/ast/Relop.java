package ast;

import environment.Environment;

public class Relop extends Expression {
	private String op;
	
	public Relop(String op)
	{
		this.op = op;
	}
	
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

}
