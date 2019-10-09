package ast;
import environment.*;

public class Variable extends Expression{
	private String name;
	
	public Variable(String name)
	{
		this.name = name;
	}
	
	public int eval(Environment env)
	{
		return env.getVariable(name);
	}
}
