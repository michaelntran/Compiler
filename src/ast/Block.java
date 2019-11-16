package ast;

import java.util.List;
import emitter.Emitter;
import environment.*;

/**
 * The Block class is used for a list of statements
 * @author Michael Tran
 * @version 10/8/19
 */
public class Block extends Statement{
	private List<Statement> stmts;

	/**
	 * instantiates the Block object with a given list of statements
	 * @param stmts is the given list of statements
	 */
	public Block(List<Statement> stmts) {
		this.stmts = stmts;
	}
	
	/**
	 * executes all the statements in the list that was passed into the constructor
	 * @param env is the environment to be used to execute all of the statements
	 */
	public void exec(Environment env)
	{
		for(Statement stmt: stmts)
		{
			stmt.exec(env);
		}
	}
	
	@Override
	public void compile(Emitter e)
	{
		for(Statement stmt: stmts)
		{
			stmt.compile(e);
		}
	}
}
