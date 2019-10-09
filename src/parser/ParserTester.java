package parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import scanner.*;
import environment.*;

import scanner.ScanErrorException;

/**
 * ParserTester class is used to test the functionality of the Parser class
 * @author Michael Tran
 * @version 10/1/2019
 */
public class ParserTester {
	public static void main(String[] args) throws FileNotFoundException, ScanErrorException
	{
		FileInputStream inStream = new FileInputStream(new File("/Users/michael/eclipse-workspace/Compiler/src/ParserTest6.txt"));
		Scanner sc = new Scanner(inStream);
		Parser pa = new Parser(sc);
		Environment env = new Environment();
		while(sc.hasNext())
		{
			pa.parseStatement().exec(env);
		}
	}
}
