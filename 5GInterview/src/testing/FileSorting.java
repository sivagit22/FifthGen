package testing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class FileSorting {

	int count = 0;
	String line;

	/*
	 * Treemap stores value ascending order 
	 * reverseOrder() -> to reverse the map based on the key
	 */
	TreeMap<Integer, String> tm = new TreeMap<Integer, String>(
			Collections.reverseOrder());

	public void lineCount(BufferedReader br) throws Exception {

		while ((line = br.readLine()) != null) {
			count++;
		}

		// System.out.println(count);

	}

	public void separate(BufferedReader br1) throws Exception {

		int[] key = new int[count];
		String[] value = new String[count];
		int j = 0;
		int sum;

		while ((line = br1.readLine()) != null) {

			sum = 0;
			String[] words = line.split(",");

			for (String w : words) {

				// extract numbers only in the given string
				//String num = w.replaceAll("\\D+", "");
				
				String[] num1 = w.split(" - ");
				String ss=num1[1];
				
				// convert numbers stored in string to integer
				int convNum = Integer.parseInt(ss);

				sum = convNum + sum;
			}

			key[j] = sum; // stores the added value
			value[j] = line; // stores the corresponding line
			tm.put(key[j], value[j]);

			/*
			 * System.out.println(store[j]);
			 * System.out.println("aaaaaaaaaaaaaaaaaa="+sum[j]);
			 */

			j++;
		}

	}

	public void print() {

		for (Map.Entry m : tm.entrySet()) {

			System.out.println(m.getValue());
		}
	}

	public static void main(String[] args) throws Exception {

		FileSorting fileSorting = new FileSorting();
		FileInputStream inputStream = new FileInputStream(args[0]);

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
		}
		catch(Exception e)
		{
			System.out.println("fail");
		}

		finally
		{
		br.close();
		inputStream.close();
		}

	}

}