package AM;
public class Node {
	
	public final String name;
	public final int exp; //out of 100
	public final int pos; //where time is in minutes

	public Node(String name, int exp, int pos) {
		this.name = name;
		this.exp = exp;
		this.pos = pos;
	}
}
