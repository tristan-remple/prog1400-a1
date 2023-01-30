package assign;

public class Main {
	
	// main method
	public static void main(String[] args) {
		
		// the league is an array of team objects
		Team [] league = new Team[3];
		
		// start the program with a title
		System.out.println("FANTASY HOCKEY APPLICATION");
		System.out.println("TEAM ENTRY");
		System.out.println("================================");
		
		// create new teams, numbered 1-3
		for (int count = 1; count < 4; count++) {
			league[count - 1] = new Team(count);
		}
		
		// space and then the next heading
		System.out.println("");
		System.out.println("PLAYER ENTRY");
		System.out.println("================================");
		
		// use a foreach loop to assign players to teams
		for (Team current : league) {
			current.assignPlayers();
		}
		
		// space and then start the reports
		System.out.println("");
		System.out.println("REPORT: Stats per Team");
		System.out.println("================================");
		
		// print the team stats with a foreach loop
		for (Team current : league) {
			current.printReport();
		}
		
		// space and heading
		System.out.println("");
		System.out.println("REPORT: Stats per Player");
		System.out.println("================================");
		
		// nested foreach loop to print the player stats
		for (Team current : league) {
			for (Player guy : current.getPlayers()) {
				guy.printReport();
			}
		}
	}

}
