package ast;
import environment.*;

public class Writeln extends Statement{
	private Expression exp;

	public Writeln(Expression exp) {
		this.exp = exp;
	}
	
	public void exec(Environment env)
	{
		System.out.println(exp.eval(env));
	}
}
