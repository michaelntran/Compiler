package environment;

import java.util.HashMap;
import java.util.Map;

/**
 * The environment class is used to keep track of all the variables and their respective values
 * @author Michael Tran
 * @version 10/8/19
 */
public class Environment {
	Map<String, Integer> vars;
	
	/**
	 * instantiates the environment, creates the map that will store all the variables
	 */
	public Environment()
	{
		vars = new HashMap<String, Integer>();
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
}
