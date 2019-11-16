package parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import scanner.*;
import environment.*;
import emitter.Emitter;
import ast.*;

import scanner.ScanErrorException;

/**
 * ParserTester class is used to test the functionality of the Parser class
 * @author Michael Tran
 * @version 10/1/2019
 */
public class ParserTester {
	public static void main(String[] args) throws FileNotFoundException, ScanErrorException
	{
		String path = "/Users/michael/eclipse-workspace/Compiler/src/emitterTest.txt";
		FileInputStream inStream = new FileInputStream(new File(path));
		Scanner sc = new Scanner(inStream);
		Parser pa = new Parser(sc);
		Environment env = new Environment();
		Emitter e = new Emitter("output.txt");
		while(sc.hasNext())
		{
			Statement s = pa.parseProgram();
			s.exec(env);
			//System.out.println(s);
			s.compile(e);
		}
	}
}
