package ast;

import java.util.List;

import environment.Environment;


public class ProcedureCall extends Expression {
	private String name;
	private List<Expression> params;
	
	
	
	public ProcedureCall(String name, List<Expression> params) {
		this.name = name;
		this.params = params;
	}



	public int eval(Environment env) {
		List<String> par = env.getProcedure(name).getParams();
		Environment childEnv = new Environment(env);
		for(int i = 0; i < par.size(); i++)
		{
			childEnv.declareVariable(par.get(i), params.get(i).eval(env));
		}
		childEnv.declareVariable(name, 0);
		env.getProcedure(name).getProcedure().exec(childEnv);
		return childEnv.getVariable(name);
	}

}
