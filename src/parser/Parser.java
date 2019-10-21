package parser;

import java.util.ArrayList;
import java.util.List;

import scanner.*;
import ast.*;
import ast.Number;

/**
 * This parser class acts as the parser component of the compiler built in the compilers class
 * @author Michael Tran
 * @version 10/1/2019 
 */
public class Parser {
	
	Scanner sc;
	String currentToken;
	
	public Parser(Scanner scanner)
	{
		sc = scanner;
		currentToken = sc.nextToken();
	}
	
	/**
	 * Eats the next token using the scanner's next method
	 * @param expected is the expected token
	 * @throws IllegalArgumentException if expected does not match currentToken
	 */
	private void eat(String expected)
	{
		if(expected.equals(currentToken))
		{
			currentToken = sc.nextToken();
		}
		else
		{
			throw new IllegalArgumentException("expected: " + currentToken + " but found: " + expected);
		}
	}
	
	/**
	 * This method parses a number using the eat method
	 * @precondition current token is an integer
	 * @postcondition number token has been eaten 
	 * @return the value of the parsed integer
	 */
	private int parseNumber()
	{
		int num = Integer.parseInt(currentToken);
		eat(currentToken);
		return num;
	}
	
	/**
	 * This method parses a statement using the eat method
	 * @precondition current token is a statement
	 * @postcondition statement token has been eaten
	 */
	public Statement parseStatement()
	{
		if(currentToken.equals("WRITELN"))
		{
			eat("WRITELN");
			eat("(");
			Expression exp = parseExpression();
			eat(")");
			eat(";");
			return new Writeln(exp);
		}
		else if(currentToken.equals("BEGIN")){
			eat("BEGIN");
			List<Statement> stmts = new ArrayList<Statement>();
			while(!currentToken.equals("END"))
			{
				stmts.add(parseStatement());
			}
			eat("END");
			eat(";");
			return new Block(stmts);
		}
		else if (currentToken.equals("IF"))
		{
			eat("IF");
			Expression exp1 = parseExpression();
			Relop op = new Relop(currentToken);
			eat(currentToken);
			Expression exp2 = parseExpression();
			Condition cond = new Condition(op, exp1, exp2);
			eat("THEN");
			return new If(cond, parseStatement());
		}
		else if (currentToken.equals("WHILE"))
		{
			eat("WHILE");
			Expression exp1 = parseExpression();
			Relop op = new Relop(currentToken);
			eat(currentToken);
			Expression exp2 = parseExpression();
			Condition cond = new Condition(op, exp1, exp2);
			eat("DO");
			return new While(cond, parseStatement());
		}
		else {
			String var = currentToken;
			eat(currentToken);
			eat(":=");
			Expression varValue = parseExpression();
			Assignment assignment = new Assignment(var, varValue);
			eat(";");
			return assignment;
		}
	}
	
	/**
	 * parses a factor using the eat method
	 * @precondition current token is a factor
	 * @postcondition factor token has been eaten
	 * @return the evaluated factor
	 */
	public Expression parseFactor()
	{
		Expression factor;
		if(currentToken.equals("-"))
		{
			eat(currentToken);
			factor = new BinOp("*", new Number(-1), parseFactor());
		}
		else if(currentToken.equals("("))
		{
			eat("(");
			factor = parseExpression();
			eat(")");
		}
		else if(sc.isDigit(currentToken.charAt(0)))
		{
			factor = new Number(parseNumber());
		}
		else {
			factor = new Variable(currentToken);
			eat(currentToken);
			if(currentToken.equals("("))
			{
				
			}
		}
		return factor;
	}
	
	/**
	 * parses a term using the eat method
	 * @precondition current token is a term
	 * @postcondition term token has been eaten
	 * @return the evaluated term
	 */
	public Expression parseTerm()
	{
		Expression term = parseFactor();
		while(currentToken.equals("*") || currentToken.equals("/"))
		{
			if(currentToken.equals("*"))
			{
				eat("*");
				term = new BinOp("*", term, parseTerm());
			}
			if(currentToken.equals("/"))
			{
				eat("/");
				term = new BinOp("/", term, parseTerm());
			}
		}
		return term;
	}
	
	/**
	 * parses an expression using the eat method
	 * @precondition current token is an expression
	 * @postcondition expression token has been eaten
	 * @return the evaluated expression
	 */
	public Expression parseExpression()
	{
		Expression exp = parseTerm();
		while(currentToken.equals("+") || currentToken.equals("-"))
		{
			if(currentToken.equals("+"))
			{
				eat("+");
				exp = new BinOp("+", exp, parseTerm());
			}
			if(currentToken.equals("-"))
			{
				eat("-");
				exp = new BinOp("-", exp, parseTerm());
			}
		}
		return exp;
	}
}
