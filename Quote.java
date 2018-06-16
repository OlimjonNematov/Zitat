import java.awt.Button;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
@SuppressWarnings("unused")
public class Quote
{
	
	public static int total=0;
	
	public String catagory;
	public String text;
	public String author;
	public String Year;
	public String info;
	public Quote(String Cat,String txt,String a,String d8)
	{
		total++;
		catagory=Cat;
		text=txt;
		author=a;
		Year=d8;		
	/*
		Scanner fin;
		try {
			fin = new Scanner(new File("Quotes.txt"));
			while(fin.hasNextLine())
			{
				String review = fin.nextLine();
				String[] entryParts = review.split(" \t ");
				String category = entryParts[0];
				String say = entryParts[1];
				String author = entryParts[2];
				String date = entryParts [3];
				info = category+" '"+say+"' "+"--"+author+"("+ date+")";
				
			
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//*/
		
	}
}