// this class needs the scanner, some math, and decimal formatting imported
package assign;
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class Team {
	
	// the class starts with instance variables, all of which are private
	private String name;
	private Player [] players;
	private int goals;
	private int assists;
	private int total;
	private double budget;
	private String rating;
	private String printBudget;
	private int id;
	
	// we set the format for the budget and initiate the scanner
	private DecimalFormat cash = new DecimalFormat("#.##");
	Scanner newscan = new Scanner(System.in);
	
	// the constructor takes a numeric id from the Main class
	public Team(int id) {
		
		// the id is set to the object
		this.id = id;
		
		// a request to the user is made for the team name
		System.out.print("Enter name for team # ");
		System.out.print(this.id);
		System.out.println(":");
		String name = newscan.nextLine();
		
		// if the user enters a short name, print an error as many times as necessary
		while (name.length() < 3) {
			System.out.println("The team's name must be longer than 3 characters.");
			System.out.println("Enter a team name:");
			name = newscan.nextLine();
		}
		
		// upon receiving a valid name, assign it to the object
		this.name = name;
		
		// the budget is randomly generated using the math utility
		this.budget = Math.random() * 100000;
		
		// it is then formatted
		this.printBudget = cash.format(budget);
		
	}
	
	// the Team class has a function that generates Players
	public void assignPlayers() {
		
		// all of the Team's performance stats are set to 0
		this.goals = 0;
		this.assists = 0;
		this.total = 0;
		
		// an array of Player objects is created and assigned to the Team object
		Player[] players = new Player[3];
		this.players = players;
		
		// a loop creates 3 Players and adds the Player's performance to the Team's performance
		for (int i = 0; i < 3; i++) {
			this.players[i] = new Player(name, i);
			this.goals += this.players[i].getGoals();
			this.assists += this.players[i].getAssists();
			this.total += this.players[i].getAssists() + this.players[i].getGoals();
		}
		
		// the Team is then evaluated
		if (this.total > 20) {
			this.rating = "*** stars";
		} else if (this.total >= 10) {
			this.rating = "** stars";
		} else if (this.total > 0) {
			this.rating = "* star";
		} else {
			this.rating = "0 star";
		}
	}
	
	// this method returns a report
	public void printReport() {
		System.out.printf("%24s", this.name + ": G - " + this.goals);
		System.out.printf("%10s", " A - " + this.assists);
		System.out.printf("%15s", " Total - " + this.total);
		System.out.printf("%30s %n", " Budget - $" + this.printBudget);
		System.out.println("Rating: " + this.rating);
		System.out.println("");
	}
	
	// we need a getter for the Players in order to call the nested loop in Main
	public Player[] getPlayers() {
		return players;
	}
	
}
