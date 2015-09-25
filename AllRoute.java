import java.util.*;

public class AllRoute {


	private List<String> result;
	private ArrayList<String> item;

    public void getAnswer() {
        result = new ArrayList<String>();
		item = new ArrayList<String>();

        int segementSize = 7;
		String start= "SFO";
		String end="MSP";
		Route[] routeList = new Route[segementSize];
		String[] segementList = new String[] 
			{"LAX SFO 338",
			 "SFO SEA 679",
			 "SEA MSP 1339",
			 "SFO LAX 338",
			 "PHX SEA 1107",
			 "LAX PHX 370",
			 "PHX MSP 1276"};

		for(int i=0;i<segementSize;i++) {
			routeList[i]=(new Route(segementList[i]));
		}

		//item.add(start);
        recurFind(start,end,routeList);
		System.out.println(result);



    }
	public static void main(String[] args) {
		AllRoute ar = new AllRoute();
        ar.getAnswer();
		// Scanner scan = new Scanner(System.in);
		// int segementSize = scan.nextInt();
		// String start = scan.next();
		// String end = scan.next();

		// Route[] routeList = new Route[segementSize]();

		// for(int i=0;i<segementSize;i++) {
		// 	String segement = scan.nextLine();
		// 	routeList.add(new Route(segement));
		// }



		// for test
		
	}


	public void recurFind(String start,String end, Route[] routes) {
		//System.out.println("considering: "+start);
		if(item.size()>1 && item.contains(start)) return;
		
		if(end.equals(start)) {
			//
			item.add(end);
			String str = item.get(0);
			for(int i=1;i<item.size();i++) {
				str = str+"->"+item.get(i);
			}
			//
			result.add(str);
			item.remove(item.size()-1);
			return;
		}
		
		//System.out.println("adding: "+start);
		
		
		
		for(int i=0;i<routes.length;i++) {
			if(routes[i].start.equals(start)) {
				// find a match
				item.add(start);
				//System.out.println("item: "+item);
				recurFind(routes[i].end,end,routes);
				item.remove(item.size()-1);
				
			}
		}
		
	}
}
	
class Route {
	public String start;
	public String end;
	public int cost;
	public Route(String str) {
		start = str.substring(0,3);
		end = str.substring(4,7);
		cost = Integer.parseInt(str.substring(8));
	} 
}
