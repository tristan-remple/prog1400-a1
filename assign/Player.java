package assign;
import java.util.Scanner;

public class Player {

	private String name;
	private int goals;
	private int assists;
	private String team;
	private int total;
	private int id;
	
	// needs error handling
	public Player(String team, int id) {
		Scanner newscan = new Scanner(System.in);
		
		this.id = id;
		
		System.out.print("Enter name for player # ");
		System.out.print(id);
		System.out.println(":");
		String name = newscan.nextLine();
		this.name = name;
		
		System.out.println("Enter number of goals for " + this.name + ":");
		int goals = newscan.nextInt();
		this.goals = goals;
		
		System.out.println("Enter number of assists for " + this.name + ":");
		int assists = newscan.nextInt();
		this.assists = assists;
		
		this.team = team;
		
		this.total = goals + assists;
	}
	
	public void printReport() {
		System.out.println(this.team);
		System.out.print(this.name + ": G - ");
		System.out.print(this.goals);
		System.out.print(" A - ");
		System.out.print(this.assists);
		System.out.print(" Total - ");
		System.out.println(this.total);
	}
	
	public int getGoals() {
		return this.goals;
	}
	
	public int getAssists() {
		return this.assists;
	}
}
