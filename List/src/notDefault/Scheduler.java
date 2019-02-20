package notDefault;
import java.util.Scanner;

public class Scheduler {
	private DoubleList<String> l;
	private Scanner s;
	public void scheduler() {
		String choice = getChoice();
		while(choice.charAt(0) != 'X') {
			if (choice.charAt(0) == 'A') {
				addEvent();
			}
			else if (choice.charAt(0) == 'R') {
				removeEvent();
			}
			choice = getChoice();
		}
	}

	public String getChoice() {
		System.out.println("Select from the following options:");
		System.out.println("	A: Add an event");
		System.out.println("	R: Remove an event");
		System.out.println("	X: Exit");
		String choice = s.nextLine();
		if (choice.length() == 0) {
			choice = s.nextLine();
		}
		while(choice.length() == 0) {
			System.out.println("Please input (A), (R), or (X)");
			choice = s.nextLine();
		}
		return choice;
	}

	public void removeEvent() {
		if (l.getLength() == 0) {
			System.out.println("No events in schedule");
			return;
		}
		System.out.println("Please input which event to remove:");
		int choice = s.nextInt();
		while (!(choice > 0) && (choice < l.getLength())) {
			System.out.println("Please a valid event to remove:");
			choice = s.nextInt();
		}
		l.pointIterator();
		for (int i = 1; i < choice; i++) {
			l.advanceIterator();
		}
		l.removeIterator();
		displaySchedule();
		return;

	}
	
	public void move(int val) {
		String event = l.getFirst();
		l.removeFirst();
		l.pointIterator();
		for (int i = 1; i < val; i++) {
			l.advanceIterator();
		}
		l.addIterator(event);
		displaySchedule();

	}

	public void offerToMove() {
		System.out.println("Would you like to move this event up in your schedule (Y/N):");
		String answer = s.nextLine();
		if (answer.length() > 0) {
			while (answer.length() == 0 || answer.charAt(0) != 'Y' && answer.charAt(0) != 'N') {
				System.out.println("Please input yes or no (Y/N):");
				answer = s.nextLine();
			}
			if (answer.charAt(0) == 'Y') {
				System.out.println("Enter the number of places: ");
				int val = s.nextInt();
				while (val + 1 > l.getLength()) {
					System.out.println("Please enter a valid number of places: ");
					val = s.nextInt();
				}
				move(val);
			}
		}
	}

	public void addEvent() {
		System.out.println("Please enter an event:");
		String event = getEvent();
	
		l.addFirst(event);
		System.out.println("You just added the following event: " + event);
		displaySchedule();
		if (l.getLength() > 1) {
			offerToMove();
		}
		return;
	}
	
	public String getEvent() {
		String event = s.nextLine();
		while(event.length() == 0) {
			System.out.println("Please enter an event:");
			event = s.nextLine();
		}
		return event;
	}

	public void displaySchedule() {
		System.out.println("Your current schedule:");
		l.printNumberedList();
	}

	public void init() {
		l = new DoubleList<String>();
		s = new Scanner(System.in);
		System.out.println("welcome to scheduler");
		System.out.println("You have no upcoming events");
	}
	
	public void finish() {
		s.close();
	}
	
    public static void main(String[] args) {
    	Scheduler s = new Scheduler();
    	s.init();
    	s.scheduler();
    }
}
