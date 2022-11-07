import java.util.Scanner;

class guessNum
{
	int lowRange=1; 
	int highRange= 10; 
	
	boolean  validateRange(int num, int lowRange, int highRange)
	{
	//	System.out.println("Validating the number "+num );
		if ((num>=lowRange) && (num<=highRange))
		{
		//	System.out.println("Number is validated");
			return true; 
		}
		else 
		{
		//System.out.println("Number is not  validated");
			return false ; 
		}
	}
	
	int guessNum(String role)
	{
		Scanner sc= new Scanner(System.in); 
		System.out.println(role + " , please guess the number in range  :  "+lowRange+" "+highRange);
		int gnum=  sc.nextInt();
		boolean validateFlag=validateRange(gnum, lowRange,highRange ); 
		
		if  (validateFlag)
		{			return  gnum ; 
		}
		else
		{
			System.out.println(); 
			System.out.println(" Make sure  guess the number in range  :  "+lowRange+" "+highRange);
			gnum=  sc.nextInt();
			 validateFlag=validateRange(gnum, lowRange,highRange ); 
			if  (validateFlag)
			{			return  gnum ; 
			}
			else 
			{
				System.out.println("Not guessing number in range .. Hnece exiting the Game ");
				return -1 ; 
			}	
		} 	
	}
}

class Guesser{
	int gnum ;
	String role ="Guesser"; 
	}

	class player
	{
		int gnum ; 
		String role ="Player"; 
		boolean match = false; 
		
		public player(int i) {
			role = role +"__"+i; 	
		}
	}
	
	class Umpire
	{
		Guesser g = new Guesser(); 
		guessNum gn = new guessNum(); 
		boolean winnerFound = false ; 
		 
		boolean  collectNumFromGuesser()
		{
			g.gnum = gn.guessNum(g.role);
			System.out.println("Number  collected from guesser is : "+g.gnum);
			if (g.gnum==-1)
			{	return false ; 
			}
			else 
			{
				return true ; 
			}
		}
		
		void compareGdata(player p[], int n)
		{
			for  (int i=0; i<n;i++ )
			{
				if (p[i].gnum==g.gnum)
				{	p[i].match = true; 
					if(winnerFound==false)
					{
						winnerFound= true; 
					}
				}
			}
			declareResult (p, n);
		}
		
		void declareResult(player p[], int n )
		{
			if (winnerFound == true )
			{
				System.out.println(" Player  won the game  is / are ");
				for  (int i=0; i<n;i++ )
				 {
					 if(p[i].match==true)
						 System.out.println(p[i].role);
				 }
			}
			else 
			{
				System.out.println("No player is won the game");
			}
		}
	}
	
	class game 
	{

		int  numPlayers=3; 
		boolean  c = false ; 
	 	Umpire u = new Umpire(); 
	 	player p[] = new player[10]; 
						
		boolean startGame = false; 

		 void startGame()
		 {
					 
				System.out.println("Guesser Game is started .. for numPlayers ");
				
				
				startGame=u.collectNumFromGuesser(); 

				if(startGame)
				{	
					System.out.println("Start collecting data from player , player count "+numPlayers);
					
				//	System.out.println("Length of p "+p.length); 
					
					for (int i=0; i<numPlayers; i++)
						p[i]= new player(i); 	
						
						for (int i=0; i<numPlayers; i++ )
						{
							p[i].gnum = u.gn.guessNum(p[i].role) ; 
							if(p[i].gnum==-1)
							{	
								startGame = false; 
								break; 
							}; 
		
						} 
				
					// Number guessed by players 
					for (int i = 0; i>=numPlayers ; i++)
					{
						//	System.out.println(i+ " " +p1.gnum );
						System.out.println(i+ " " +p[i].role );
	
					}
				
					if (startGame)
						{	
							u.compareGdata(p,numPlayers); 
						}
					else 
					{
						System.exit(0); ; 
					}
		 }
		 }
		 
		 void decideNumPlayers()
		 {
			 System.out.println("Please decide Number of playes upto 10  :  ");
			 Scanner sc= new Scanner(System.in); 
			 numPlayers=  sc.nextInt(); 

		 }
	}
	

public class GuesserGame {

		public static void main(String[] args) {
			game g= new game(); 
			g.decideNumPlayers(); 
 ac
			 if (g.numPlayers > 0  && g.numPlayers <11)
			 {
				 g.startGame(); 
			 }
			 else 
			 {
				 System.out.println("Number of playes are not greater than 0 to 10 , hence existing");
			 }
				 
	}

}
