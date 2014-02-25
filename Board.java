import java.util.ArrayList;

public class Board {

	//variable declarations
	private int length; //The total number of guesses available; the vertical size of the board
	private int current; //The number of the row that the board is currently taking a guess for
	private ArrayList<String> guesses = new ArrayList<String>(); //List of all guesses taken
	private int[] exactNumber; //array of all "exact" scores for all guesses
	private int[] correctNumber; //array of all "partially correct" scores for all guesses
	private char[] blank; //blank placeholder for unused board rows

	//default constructor
	public Board()
	{
		length=0;
		current=0;
		exactNumber=new int[0];
		correctNumber=new int[0];
	}

	//constructor, takes in number of guesses available and length of code
	public Board(int l,int g)
	{
		length=l;
		current=0;
		exactNumber=new int[l];
		correctNumber=new int[l];
		
		blank=new char[g];//set blank to the length of the code and fill it with dashes
		for(int x=0;x<g;x++)
		{
			blank[x]='-';
		}
	}

	//displays the board
	public void display()
	{
		for (int x=0;x<length;x++)
		{
			if(x<current) //print previous guesses
				System.out.println("|"+guesses.get(x)+"| Number of letters exactly right: " + exactNumber[x] +" Number of letters partially correct: "+ correctNumber[x]);
			else //print blank board row
			{
				System.out.print("|");
				System.out.print(blank);
				System.out.println("|");
			}

		}


	}
	
	//takes in the current guess, with it's number of exact and partially correct letters
	public void passInfo(String guess,int exact,int correct)
	{
		guesses.add(guess);
		exactNumber[current]=exact;
		correctNumber[current]=correct;
		current++; //increment the row
	}

}
