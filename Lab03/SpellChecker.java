import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.lang.StringBuilder;

public class SpellChecker
{
	private static final String DICT_FILE = "Lab03\\\\dictionary.txt";

	private StringSet words;
	
	public SpellChecker()
	{
		words = new StringSet();
		File f = new File(DICT_FILE);
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(f);

			while (scanner.hasNext())
			{
				String word = scanner.next();
				words.insert(word);
			}

			scanner.close();
			System.out.println("Loaded " + DICT_FILE);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not open file " + DICT_FILE);
			e.printStackTrace();
		}
	}

	public ArrayList<String> getSuggestions(String input)
	{
		ArrayList<String> suggestions = new ArrayList<>();
		// TODO: Add all words from the set with only one character difference.
		//Check input against its hash
		if (words.find(input))
		{
			//imput is in list already
		}
		else
		{
	
			//loop through each character of the string, maintaining the original seperately
			for (int i = 0; i < input.length(); i++)
			{
				//set up stringbuilder
				StringBuilder sb = new StringBuilder(input);
				//	loop through each letter of the alphabet, and hash it to find a match, 
				//		if a match is found, put it in suggestions
				for (char j = 'a'; j <= 'z'; j++)
				{
					//append j to empty string to make this work
					sb.setCharAt(i, j);
					if (words.find(sb.toString()))
					{
						suggestions.add(sb.toString());
					}
				}

			}
			
		}
	
		return suggestions;
	}

	public static void main(String[] args)
	{
		SpellChecker checker = new SpellChecker();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter word: ");
		String word = scanner.next();
		scanner.close();

		if (checker.words.find(word))
			System.out.println(word + " is a valid word.");
		else
		{
			System.out.println("Could not find " + word);
			System.out.println("Consider the following alternatives...");
			for (String candidate : checker.getSuggestions(word))
				System.out.println(candidate);
		}
	}
}