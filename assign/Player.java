// this class needs to import the scanner
package assign;
import java.util.Scanner;

public class Player {

	// various private instance variables are assigned to the Player class
	private String name;
	private int goals;
	private int assists;
	private String team;
	private int total;
	private int id;
	
	// the constructor takes the Team the Player belongs to and a numeric id
	public Player(String team, int id) {
		
		// the scanner is initiated and the team is assigned to the new object
		Scanner newscan = new Scanner(System.in);
		this.team = team;
		
		// the id is 1 higher than the array index
		this.id = id + 1;
		
		// a Player name is requested
		System.out.print("Enter name for player # ");
		System.out.print(this.id);
		System.out.println(" on Team " + this.team + ":");
		String name = newscan.nextLine();
		
		// if the name is not long enough, the request is made more specific and repeated indefinitely
		while (name.length() < 3) {
			System.out.println("The player's name must be longer than 3 characters.");
			System.out.println("Enter a player name:");
			name = newscan.nextLine();
		}
		
		// the valid name is assigned to its variable
		this.name = name;
		
		// goals is initialized at -1 in order to make it easy to tell when it's not working correctly
		int goals = -1;
		
		// the goals request is in a do...while loop that ensures we get a valid number
		do {
			System.out.println("Enter number of goals for " + this.name + ":");
			
			// try to get a number
			try {
				goals = newscan.nextInt();
				
			// if an exception is thrown, set the goals back to 0 and push the scanner forward
			} catch (Exception err) {
				goals = -1;
				newscan.next();
			}
			
		} while (goals < 0);
		this.goals = goals;
		
		// assists uses the same ideas as goals
		int assists = -1;
		do {
			System.out.println("Enter number of assists for " + this.name + ":");
			try {
				assists = newscan.nextInt();
			} catch (Exception err) {
				assists = -1;
				newscan.next();
			}
		} while (assists < 0);
		this.assists = assists;
		
		// total is calculated afterwards
		this.total = goals + assists;
		
	}
	
	// a method to print a report, formatted using printf
	public void printReport() {
		System.out.println(this.team);
		System.out.printf("%24s", this.name + ": G - " + this.goals);
		System.out.printf("%10s", " A - " + this.assists);
		System.out.printf("%15s %n", " Total - " + this.total);
		System.out.println("");
	}
	
	// getters for the goals and assists, in order to use them in the Team's stats
	public int getGoals() {
		return this.goals;
	}
	
	public int getAssists() {
		return this.assists;
	}
}
