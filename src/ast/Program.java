package ast;

import java.util.List;

import environment.Environment;
import emitter.Emitter;

public class Program extends Statement {
	List<String> vars;
	List<ProcedureDeclaration> procedures;
	Statement stmt;
	
	public Program(List<String> vars, List<ProcedureDeclaration> procedures, Statement stmt) {
		this.vars = vars;
		this.procedures = procedures;
		this.stmt = stmt;
	}


	public void exec(Environment env) {
		for(String var: vars)
			env.declareVariable(var, 0);
		for(ProcedureDeclaration dec: procedures)
			dec.exec(env);
		stmt.exec(env);
	}
	
	public void compile(Emitter e)
	{
		e.emit(".data");
		e.emit("varNewLine:");
		e.emit("\t.asciiz \"\\n\"");
		for(String var: vars)
		{
			e.emit("var" + var + ":");
			e.emit("\t.word 0");
		}
		e.emit(".text");
		e.emit(".globl main");
		e.emit("main:");
		stmt.compile(e);
		e.emit("# future code will go here");
		e.emit("li $v0, 10");
		e.emit("syscall\t# halt");
		e.close();
	}
}
