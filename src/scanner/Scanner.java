package scanner;

import java.io.*;

/**
 * Scanner is a simple scanner for Compilers and Interpreters (2014-2015) lab exercise 1
 * @author Michael Tran
 * @version 9/20/2019
 *  
 * Usage:
 * This scanner will be used as the lexical analysis component of a compiler
 *
 */
public class Scanner
{
    private BufferedReader in;
    private char currentChar;
    private boolean eof;
    /**
     * Scanner constructor for construction of a scanner that 
     * uses an InputStream object for input.  
     * Usage: 
     * FileInputStream inStream = new FileInputStream(new File(<file name>);
     * Scanner lex = new Scanner(inStream);
     * @param inStream the input stream to use
     */
    public Scanner(InputStream inStream)
    {
        in = new BufferedReader(new InputStreamReader(inStream));
        eof = false;
        getNextChar();
    }
    /**
     * Scanner constructor for constructing a scanner that 
     * scans a given input string.  It sets the end-of-file flag an then reads
     * the first character of the input string into the instance field currentChar.
     * Usage: Scanner lex = new Scanner(input_string);
     * @param inString the string to scan
     */
    public Scanner(String inString)
    {
        in = new BufferedReader(new StringReader(inString));
        eof = false;
        getNextChar();
    }
    /**
     * Method: getNextChar
     * sets the next character to currentChar, determines whether at end of file
     */
    private void getNextChar()
    {
    	try {
    		int character = in.read();
    		currentChar = (char) character;
    		if(character == -1 || currentChar == '.')
    			eof = true;
    	}
    	catch(IOException e)
    	{
    		System.out.println("Invalid character");
    	}
    }
    
    /**
     * Method: eat
     * if the current character matches the input character,
     * "eats" another character of the input string
     * 
     * @param expected is the expected character - it should be the same as currentChar
     * @throws ScanErrorException if expected does not equal currentChar
     */
    private void eat(char expected)
    {
        try
        {
        	if(expected == currentChar)
            {
            	getNextChar();
            }
        	else {
        		throw new ScanErrorException("Illegal character -  expected " + currentChar + " and found " + expected);
        	}
        }
        catch(ScanErrorException e)
        {
        }
    }
    /**
     * Method: hasNext
     * @return true if scanner is not at end of file, false otherwise
     */
    public boolean hasNext()
    {
    	return !eof;
    }
    /**
     * Method: nextToken
     * @return
     */
    public String nextToken()
    {
    	if(!hasNext())
    		return "END";
    	while(isWhiteSpace(currentChar))
    	{
    		eat(currentChar);
    	}
    	if(!hasNext())
    		return "END";
    	if(isDigit(currentChar))
    		return scanNumber(currentChar);
    	else if(isCharacter(currentChar))
    		return scanIdentifier(currentChar);
    	else
    	{
    		return scanOperand(currentChar);
    	}
    } 
    
    /**
     * isDigit determines whether the given char is a digit from 0-9
     * @param character is the given char
     * @return whether character is a digit from 0-9
     */
    public static boolean isDigit(char character)
    {
    	return character >= 48 && character <= 57;
    }
    
    /**
     * isCharacter determines whether the given char is a letter (capital or lowercase)
     * @param character is the given char
     * @return whether character is a letter
     */
    public static boolean isCharacter(char character)
    {
    	if(String.valueOf(character).compareTo(String.valueOf('a')) >= 0
    			&& String.valueOf(character).compareTo(String.valueOf('z')) <= 0)
    		return true;
    	if(String.valueOf(character).compareTo(String.valueOf('A')) >= 0
    			&& String.valueOf(character).compareTo(String.valueOf('Z')) <= 0)
    		return true;
    	return false;
    }
    
    /**
     * isWhiteSpace determines whether the given char is whitespace (a space, a tab, a new line) 
     * @param character is the given char
     * @return whether character is whitespace
     */
    public static boolean isWhiteSpace(char character)
    {
    	char[] whitespace = new char[4];
    	whitespace[0] = ' ';
    	whitespace[1] = '\t';
    	whitespace[2] = '\r';
    	whitespace[3] = '\n';
    	for(int i = 0; i < whitespace.length; i++)
    	{
    		if(character == whitespace[i])
    			return true;
    	}
    	return false;
    }
    
    /**
     * isOperand determines whether the given char is an operand
     * an operand is given by parentheses, equals, and math operators (+, -, *, /, %)
     * @param character is the given char
     * @return whether character is an operand
     */
    public static boolean isOperand(char character)
    {
    	char[] operands = new char[15];
    	operands[0] = '=';
    	operands[1] = '+';
    	operands[2] = '-';
    	operands[3] = '*';
    	operands[4] = '/';
    	operands[5] = '%';
    	operands[6] = '(';
    	operands[7] = ')';
    	operands[8] = ':';
    	operands[9] = '.';
    	operands[10] = '<';
    	operands[11] = '>';
    	operands[12] = '$';
    	operands[13] = '^';
    	operands[14] = '@';
    	for(int i = 0; i < operands.length; i++)
    	{
    		if(character == operands[i])
    			return true;
    	}
    	return false;
    }
    
    /**
     * scanNumber scans the input to see whether the input is a number
     * a number is represented by the regular expression digit(digit)*
     * stop adding to the lexeme after encountering a non-digit character
     * @param character is the expected character
     * @return the lexeme (in String format) of the number in the input
     * @throws ScanErrorException if the eat method throws a ScanErrorException
     * 		because the input character does not match currentChar
     */
    private String scanNumber(char character)
    {
    	try
    	{
    		if(!isDigit(character))
    			throw new ScanErrorException("The input character: " + currentChar + " is not of the expected type: digit");
    	}
    	catch(ScanErrorException e)
    	{
    	}
    	eat(character);
    	String lexeme = String.valueOf(character);
    	while(isDigit(currentChar))
    	{
    		lexeme += String.valueOf(currentChar);
    		eat(currentChar);
    	}
    	//System.out.println(lexeme);
    	return lexeme;
    }
    
    /**
     * scanIdentifier scans the input to see whether the input is an identifier
     * an identifier is represented by the regular expression letter(letter | digit)*
     * stop adding to the lexeme after encountering a non-letter or non-digit character
     * @param character is the expected character
     * @return the lexeme (in String format) of the identifier in the input
     * @throws ScanErrorException if the eat method throws a ScanErrorException
     * 		because the input character does not match currentChar
     */
    private String scanIdentifier(char character) 
    {
    	try
    	{
    		if(!isCharacter(character))
    			throw new ScanErrorException("The input character: " + currentChar + " is not of the expected type: letter");
    	}
    	catch(ScanErrorException e)
    	{
    	}
    	eat(character);
    	String lexeme = String.valueOf(character);
    	while(isCharacter(currentChar) || isDigit(currentChar))
    	{
    		lexeme += String.valueOf(currentChar);
    		eat(currentChar);
    	}
    	//System.out.println(lexeme);
    	return lexeme;
    }
    
    /**
     * scanOperand scans the input to see whether the input is an operand
     * an operand is represented by '=', '+', '-', '*', '/', '%', '(', ')'
     * stop adding to the lexeme after encountering a non-operand character
     * @param character is the expected character
     * @return the lexeme (in String format) of the operand in the input
     * @throws ScanErrorException if the eat method throws a ScanErrorException
     * 		because the input character does not match currentChar
     */
    private String scanOperand(char character)
    {
    	try
    	{
    		if(!isOperand(character))
    			throw new ScanErrorException("The input character: " + currentChar + " is not of the expected type: operand");
    	}
    	catch(ScanErrorException e)
    	{
    	}
    	eat(character);
    	String lexeme = String.valueOf(character);
    	if(lexeme.equals("."))
    	{
    		eof = true;
    	}
    	else
    	{
    		if(((character == '<' || character == '>' || character == ':') && currentChar == '=') || (character == '<' && currentChar == '>'))
    		{
    			lexeme += String.valueOf(currentChar);
    			eat(currentChar);
    		}
    	}
    	//System.out.println(lexeme);
    	return lexeme;
    }
}
