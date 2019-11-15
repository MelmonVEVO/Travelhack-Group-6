package AM;
import AM.Node;


public class Attmap {
	private final Node[] attractions = {new Node("London Eye", 80, 60), new Node("London Bridge", 70, 30),
			new Node("National Gallery", 50, 45), new Node("Tower Bridge", 40, 30),
			new Node("Elizabeth Tower", 65, 30), new Node("Hyde Park", 45, 90)};
	
	public int getValueOfAttraction(String attraction) { // attraction is the name of the attraction to get
		for (int i = 0; i < attractions.length; i++) { // searching through all attractions
			if (attractions[i].name == attraction) {
				return attractions[i].rating; // returning the attraction's rating
			}
		}
		return 0;
	}
	
	
}
