package AM;

public class Node implements Comparable<Node> {
	
	public final String name;
	public final int exp; //out of 100
	public final int pos; //where time is in minutes

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
}
