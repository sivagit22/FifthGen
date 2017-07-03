package testing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Testcases {
	static int pass=0;
	static int fail=0;

	public static void testing(String inp) throws Exception
	{
		FileSorting fileSorting = new FileSorting();
		FileInputStream inputStream = new FileInputStream(inp);

		/*
		 * stocks.txt you can find the file inside the project
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		try
		{

		fileSorting.lineCount(br); // count the number of lines in the text file

		inputStream.getChannel().position(0); // reset to beginning of the file

		fileSorting.separate(br); // main operation

		fileSorting.print(); // print the values
		System.out.println("pass");
		pass++;
		}
		catch(Exception e)
		{
			System.out.println("fail");
			fail++;
		}

		finally
		{
		br.close();
		inputStream.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		String input1 = "stocks.txt";
		String input2 = "stocks2.txt";
		String input3 = "stocks3.txt";
		String input4 = "stocks4.txt";
		testing(input1);
		System.out.println();
		testing(input2);
		System.out.println();
		testing(input3);
		System.out.println();
		testing(input4);
		System.out.println();
		System.out.println("Number of testcases passed: "+pass);
		System.out.println("Number of testcases failed: "+fail);
		
	}

}
