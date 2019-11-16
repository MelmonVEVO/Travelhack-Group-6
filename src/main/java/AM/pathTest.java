package AM;

public class pathTest {
	public static void main(String[]p) throws Exception {
		/*
		TheMap MyMap= new TheMap();
		System.out.println(MyMap.getExpOf("Tower bridge"));
		MyMap.initRoute(5);
		System.out.println(MyMap.Route.size());
		for(Node x: MyMap.Route) {
			System.out.print(x.pos+"=>");
		}
		System.out.println();
		Collections.sort(MyMap.Route);
		for(Node x: MyMap.Route) {
			System.out.print(x.name+x.pos+"=>");
		}
		*/
		Schedule scTest = new Schedule("16/11/2019");
		scTest.GenerateSchedule(5, 8);
		scTest.printEntireSchedule();
		
	}
	
	 
}