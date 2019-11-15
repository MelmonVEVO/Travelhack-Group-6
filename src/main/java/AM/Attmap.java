package AM;
import AM.Node;


public class Attmap {
	public static final Node[] attractions = {new Node("London Eye", 80, 66), new Node("London Bridge", 70, 6),
			new Node("National Gallery", 50, 45), new Node("Tower Bridge", 40, 24),
			new Node("Elizabeth Tower", 65, 30), new Node("Hyde Park", 45, 90),
			new Node("Stratford", 20, 57), new Node("Canary Wharf", 50, 77)};
	
	public static int getValueOfAttraction(String attraction) { // attraction is the name of the attraction to get
		for (int i = 0; i < attractions.length; i++) { // searching through all attractions
			if (attractions[i].name == attraction) {
				return attractions[i].exp; // returning the attraction's rating
			}
		}
		return 0;
	}
	public static Node getAttraction(String attraction) { // attraction is the name of the attraction to get
		for (int i = 0; i < attractions.length; i++) {
			if (attractions[i].name == attraction) {
				return attractions[i];
			}
		}
		throw new IndexOutOfBoundsException("boi");
	}
	
	
}
