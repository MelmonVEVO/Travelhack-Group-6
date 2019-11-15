package AM;
public class Node {
	
	public final String name;
	public final int rating; //out of 100
	public final int time; //where time is in minutes

	public Node(String name, int rating, int time) {
		//this.time = 0;
		this.name = name;
		this.rating = rating;
		this.time = time;
	}
}
