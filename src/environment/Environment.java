package environment;

import java.util.HashMap;
import java.util.Map;
import ast.*;

/**
 * The environment class is used to keep track of all the variables and their respective values
 * @author Michael Tran
 * @version 10/8/19
 */
public class Environment {
	private Map<String, Integer> vars;
	private Map<String, ProcedureDeclaration> procedures;
	private Environment parent;
	
	/**
	 * instantiates the environment, creates the map that will store all the variables
	 */
	public Environment()
	{
		vars = new HashMap<String, Integer>();
		procedures = new HashMap<String, ProcedureDeclaration>();
		parent = null;
	}
	
	public Environment(Environment parentEnv)
	{
		vars = new HashMap<String, Integer>();
		procedures = new HashMap<String, ProcedureDeclaration>();
		parent = parentEnv;
	}
	
	/**
	 * associates the given variable name with the given value
	 * @param variable is the name of the variable that takes on value
	 * @param value is the value to be assigned to variable
	 */
	public void setVariable(String variable, int value)
	{
		vars.put(variable, value);
	}
	
	/**
	 * return the value associated with the given variable name
	 * @param variable is the name of the variable whose value is to be retrieved
	 * @return the value of variable
	 */
	public int getVariable(String variable)
	{
		return vars.get(variable);
	}
	
	public void setProcedure(String procedure, ProcedureDeclaration declaration)
	{
		procedures.put(procedure, declaration);
	}
	
	public ProcedureDeclaration getProcedure(String procedure)
	{
		return procedures.get(procedure);
	}
}
