import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/** declaring a class named SentimentDB and initializing a map
 * 
 * @author Olimjon Nematov
 *
 */

@SuppressWarnings("unused")
public class QuoteDB {

	public  ArrayList<Quote> AllQuotes= new ArrayList<>();

	public QuoteDB()
	{
	
		
		try 
		{
			Scanner fin= new Scanner(new File("Quotes.txt"));		
			while(fin.hasNextLine())
				{
									
					//*
					String review = fin.nextLine();
					String[] entryParts = review.split("\\t");
					String catagory = entryParts[0];
					String say = entryParts[1];
					String author = entryParts[2];
					String date = entryParts [3];
					//*/
					AllQuotes.add(new Quote(catagory,say,author,date));	    
				}	    
			fin.close();	
		}
		catch (FileNotFoundException e)
			{
				System.out.println("Error: could not load database.");
			}
	}
	
	public void add(String c, String q, String a, String d) 
	{
		AllQuotes.add(new Quote(c,q,a,d));
		//*
		try {
			PrintWriter fout = new PrintWriter("Quotes.txt");
			
			for(Quote q2 :AllQuotes) {
				fout.print(q2.catagory+"\t"+q2.text+"\t"+"--"+q2.author+"\t"+q2.Year+"\t"+"\n");
			}
			fout.flush();
			fout.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//*/
		
	}
	public String find(String c) 
	{
		String returningS = "";
		for(Quote q:AllQuotes)
		{
			if(q.catagory.equalsIgnoreCase(c)) 
			{
				returningS+="'"+q.text+"'"+"\t"+"--"+q.author+"\t"+"("+q.Year+")"+"\n"+"\n";
			}
		}
		if(returningS.equals("")){
			returningS= "Quote u was lukin 4 wasnt found :(";
		}
		return returningS;
		
	}
	public String finda(String c) 
	{
		String returningS = "";
		for(Quote q:AllQuotes)
		{
			if(q.author.equalsIgnoreCase(c)) 
			{
				returningS+=q.catagory+"\t"+"'"+q.text+"'"+"\t"+"("+q.Year+")"+"\n"+"\n";
			}			
		}
		if(returningS.equals("")){
			returningS= "Quote u was lukin 4 wasnt found :(";
		}
		return returningS;
	}
	public String findy(String y) 
	{
		String returningS = "";
		for(Quote q:AllQuotes)
		{
			if(q.Year.equals(y)) 
			{
				returningS+=q.catagory+"\t"+"'"+q.text+"'"+"\t"+"--"+q.author+"\n"+"\n";
			}			
		}
		if(returningS.equals("")){
			returningS= "Quote u was lukin 4 wasnt found :(";
		}
		return returningS;
		
	}
}
