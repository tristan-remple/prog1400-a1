package assign;

public class Main {
	
	// needs commenting and error handling throughout
	public static void main(String[] args) {
		Team [] league = new Team[3];
		
		System.out.println("FANTASY HOCKEY APPLICATION");
		System.out.println("TEAM ENTRY");
		System.out.println("================================");
		
		for (int count = 1; count < 4; count++) {
			league[count - 1] = new Team(count);
		}
		
		System.out.println("PLAYER ENTRY");
		System.out.println("================================");
		
		for (Team current : league) {
			current.assignPlayers();
		}
		
		System.out.println("REPORT: Stats per Team");
		System.out.println("================================");
		
		for (Team current : league) {
			current.printReport();
		}
		
		System.out.println("REPORT: Stats per Player");
		System.out.println("================================");
		
		for (Team current : league) {
			for (Player guy : current.getPlayers()) {
				guy.printReport();
			}
		}
	}

}
