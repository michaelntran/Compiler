package scanner;
import java.io.*;

/**
 * ScannerTester class is used to test the functionality of the Scanner class
 * @author Michael Tran
 * @version 9/20/2019
 */
public class ScannerTester {
	public static void main(String[] args) throws FileNotFoundException, ScanErrorException
	{
		FileInputStream inStream = new FileInputStream(new File("/Users/michael/eclipse-workspace/Compiler/src/ScannerTest.txt"));
		Scanner sc = new Scanner(inStream);
		while(sc.hasNext())
		{
			sc.nextToken();
		}
	}
}
