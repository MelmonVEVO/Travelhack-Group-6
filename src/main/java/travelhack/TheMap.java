package travelhack;
import java.util.*;
import java.util.ArrayList;
import java.util.Random;
public class TheMap {
	ArrayList<Node> Nodes= new ArrayList<Node>();
	ArrayList<Node> Route= new ArrayList<Node>();

	public TheMap() {
		Nodes.add(new Node("London Bridge", 50, 10));
		Nodes.add(new Node("London Eye", 50, 11));
		Nodes.add(new Node("Tower Bridge", 50, 14));
		Nodes.add(new Node("Madame Toussauds", 50, 19));
		Nodes.add(new Node("Big Ben", 50, 13));
		Nodes.add(new Node("Westfield White City", 20, 47));
		Nodes.add(new Node("Westfield Stratford", 20, 30));
		Nodes.add(new Node("Canary Wharf", 80, 33));
		Nodes.add(new Node("Camden Town", 20, 24));
		Nodes.add(new Node("National Gallery", 150, 15));
		Nodes.add(new Node("British Museum", 120, 16));

	}

	
	public int getExpOf(String name) throws Exception {
		for(Node x:this.Nodes) {
			if ((x.name).equalsIgnoreCase(name)){
				return x.exp;
			}
		}
		throw new Exception("Attraction not found");
	}
	
	public int getPosOf(String name) throws Exception {
		for(Node x:this.Nodes) {
			if ((x.name).equalsIgnoreCase("name")){
				return x.pos;
			}
		}
		throw new Exception("Attraction not found");
	}
	

	public Node getAttr(String name) throws Exception { // attraction is the name of the attraction to get
		for(Node x:this.Nodes) {
		if ((x.name).equalsIgnoreCase(name)) {
			return x;
			}
		}
		throw new Exception("Attraction not found");
	}
	
	public void initRoute(int size) {
		Random rand= new Random();
		for (int i=0; i<size; i++) {
			int choice= rand.nextInt(this.Nodes.size());
			boolean exists=false;
			System.out.println(choice);
			for(Node x: Route) {
				if((x.equals(Nodes.get(choice)))) {
					System.out.println("Found similar.");
					exists=true;
					
				}
				}
			if(exists==false)this.Route.add(this.Nodes.get(choice));
			else i--;
			}
		}
	
}