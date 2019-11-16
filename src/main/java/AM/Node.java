package AM;

public class Node implements Comparable<Node> {

	public String name;
	public int exp; //out of 100
	public int pos; //where time is in minutes
	public String time;

	public Node(String name, int exp, int pos) {
		this.name = name;
		this.exp = exp;
		this.pos = pos;
	}

	@Override
	public int compareTo(Node compareNode) {
		int comparePos=((Node)compareNode).pos;
		/* For Ascending order*/
		return this.pos-comparePos;

		/* For Descending order do like this */
		//return compareage-this.studentage;
	}

	public String getName() { return name; }
	public String getTime() {return time; }
	public int getExp() { return exp; }
	public int getPos() { return pos; }
}
