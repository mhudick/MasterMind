/*
 * @author Jack Stanesa, Mike Hudick, Emily Owen
 * @date 10/9/13
 * @program allows two players to play the game Mastermind, wherein one player
 * is the code maker, and the other is the code breaker.
 * */
import java.util.*;

public class Main {
	public static void main(String[] args){
		//read in inputs
		Scanner in = new Scanner(System.in);

		String code="a";
		int codeLength=1;
		String guess="a";
		int guesses = 0;
		int[] temp = null; 
		int tries=-1;  // sets the number of guesses allowed
		boolean check=false;  // checks the validity of the codemasters code
		boolean check2=false;  // checks the validity of the codebreakers guess
		boolean win = false;  // if the codebreaker wins this turns true
		boolean loss = false;  // if the codebreaker loses this turns true

		//determine the length of the game
		System.out.println("Enter how many guesses you would like to make:");
		//input validation
		while(tries<=0){
			try {
				tries=in.nextInt();
				while(tries == 0){
					System.out.println("zero doesn't work");
					tries = in.nextInt();
				}
			}

			catch(InputMismatchException e){
				System.out.println("Please enter a non zero integer.");
				in.next();
			}
		}
		System.out.println("How many characters is your code? (Between 2 and 26)");
		System.out.println("If you choose 2, you will be able to use A and/or B, "
				+ "if you choose 5, you will be able to use any combination of A-E.");
		//input validation
		while(codeLength<=1){
			try{
				codeLength=in.nextInt();  // takes the length the users decide - denotes how many letters will be available for guessing

			}
			catch(InputMismatchException e){
				System.out.println("Please enter an integer.");
				in.next();
			}
		}
		//initializes our board by the length of the game and the length of the code
		Board b= new Board(tries, codeLength);
		//sets the code by player 1
		while(check==false){
			check=true;
			System.out.println("Enter your code:");
			code = in.next().toUpperCase(); //takes in code and sets to upper case
			//input validation
			for(int i=0; i<code.length(); i++){
				char character=code.charAt(i);  // checks the location of each character
				int ascii=(int)character;  
				if(ascii>65+codeLength||codeLength!=code.length()){
					check=false;
				}
			}
		}

		//makes space between the original code input and the person guessing so they don't see the answer
		for(int i=0; i<10;i++){
			System.out.println("");
		}

		//player two guesses until a win condition or a lose condition is reached
		while(win != true || loss != true){
			while(check2==false){
				check2=true;
				System.out.println("Enter in your guess; make sure you only use the first "+ codeLength +" letters of the alphabet.");
				guess = in.next().toUpperCase(); //takes in guess and sets to upper

				for(int i=0; i<guess.length(); i++){
					char character=guess.charAt(i);
					int ascii=(int)character;
					if(ascii>65+codeLength||codeLength!=guess.length()){
						check2=false;
					}
				}
			}
			Get g = new Get(code);
			temp = g.check(guess);
			b.passInfo(guess, temp[0], temp[1]);
			b.display();
			guesses++;
			if(temp[0] == codeLength){
				System.out.println("You guessed the code! You win!");
				win = true;
				break;
			}
			else if(tries == guesses){
				System.out.println("You ran out of guesses! You lose!");
				loss = true;
				break;
			}
			check2=false;
		}
		in.close();
	}
}
