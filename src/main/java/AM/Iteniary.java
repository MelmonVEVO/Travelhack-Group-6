package AM;
import AM.Attmap;
import AM.Node;
import java.util.ArrayList;

public class Iteniary {
	private static ArrayList<Node> itn = new ArrayList<Node>();
	
	/**public static void generateIteniary() { // where maxTime is the maximum available time
		ArrayList<int> unchecked = new ArrayList<int>();
		for (i = 0; i < AM.Attmap.attractions.length; i++) unchecked.add(i);
	}**/
	
	public static void getIteniary() {
		for (int i = 0; i < itn.size(); i++) {
			System.out.printf("%s [+%d Exp.] @ pos %dm", itn.get(i).name, itn.get(i).exp, itn.get(i).pos);
		}
	}
	
	public static void addToIteniary(String nameOfAttraction) {
		itn.add(AM.Attmap.getAttraction(nameOfAttraction));
	}
}
