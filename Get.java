// this class takes the code and guesses from the users and compares each to conclude a score
public class Get{
	private String code;
	// takes in the variable entered in by the codemaster
	public Get(String n){

		code = n;
		code = code.toUpperCase();

	}
	// takes in the string variable guessed by the codebreaker
	public int[] check(String s){
		int spotOn = 0;
		int in = 0;
		int[] result = new int[2];  // holds spot on value and in value in 0 and 1 respectively
		String guess = s;
		guess = guess.toUpperCase();  //converts guess to upper case
		int g = guess.length();  // checks the length of guess
		char[] code2;  // array to hold the conversion code string to an array

		code2 = code.toCharArray();  // converts code string to a char array called code2

		char[] guess2 = guess.toCharArray();


		//compares player 2's guess with player 1's code
		//loops to check for guesses being exact
		for(int i = 0; i < g; i++){
		
			if(code2[i]==guess2[i])
			{
				spotOn++;
				code2[i]='0';
				guess2[i]='1';
			}


		}
		//loops through for guesses being partially correct
		for(int i = 0; i < g; i++){
			for(int b=0;b<g;b++)
			{
				
				boolean found=false;
				if(!found)
				{
					if(code2[i]==guess2[b])
					{
						in++;
						found=true;
						code2[i]='0';
						guess2[b]='1';
					}
				}
			}

		}





		result[0]=spotOn; // array spot 0 holds the spot on score
		result[1]=in;	// array spot 1 holds the in the puzzle score
		return result;  //returns the array results[] to main
	}
}




