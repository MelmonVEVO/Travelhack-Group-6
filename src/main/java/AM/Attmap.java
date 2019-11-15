package attmap;
import attmap.Node;

public class Attmap {
	private final Node[] attractions = {new Node("London Eye", 80), new Node("London Bridge", 70),
			new Node("National Gallery", 50), new Node("Tower Bridge", 40),
			new Node("Elizabeth Tower", 65), new Node("Hyde Park", 45)};
	
	public int getValueOfAttraction(String attraction) {
		for (int i = 0; i < attractions.length; i++) {
			if (attractions[i].name == attraction) {
				return attractions[i].rating;
			}
		}
		return 0;
	}
	
	
}
