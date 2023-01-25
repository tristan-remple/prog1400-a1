package assign;
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class Team {
	
	private String name;
	private Player [] players;
	private int goals;
	private int assists;
	private int total;
	private double budget;
	private String rating;
	private String printBudget;
	private int id;
	
	private DecimalFormat cash = new DecimalFormat("#.##");
	
	// needs error handling
	public Team(int id) {
		
		this.id = id;
		Scanner newscan = new Scanner(System.in);
		
		System.out.print("Enter name for team # ");
		System.out.print(id);
		System.out.println(":");
		String name = newscan.nextLine();
		this.name = name;
		
		this.budget = Math.random() * 100000;
		this.printBudget = cash.format(budget);
	}
	
	public void assignPlayers() {
		this.goals = 0;
		this.assists = 0;
		this.total = 0;
		
		for (int i = 0; i < 3; i++) {
			players[i] = new Player(name, i);
			this.goals += this.players[i].getGoals();
			this.assists += this.players[i].getAssists();
			this.total += this.players[i].getAssists() + this.players[i].getGoals();
		}
		
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
	
	public void printReport() {
		System.out.print(name + ": G - ");
		System.out.print(this.goals);
		System.out.print(" A - ");
		System.out.print(this.assists);
		System.out.print(" Total - ");
		System.out.print(this.total);
		System.out.println(" Budget - $" + this.printBudget);
		System.out.println("Rating: " + this.rating);
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
}
