import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
class SkyLine 
{

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(3,new MyComparator());

        int maxRi = 0;
        for(int[] b : buildings) maxRi=b[1]>maxRi?b[1]:maxRi;
        pq.add(new int[]{0,maxRi,0});
        for(int i=0;i<=maxRi;i++) {
            for(int[] aBuilding: buildings) {
                if(aBuilding[0]==i) {
                    if(pq.peek()[2]<aBuilding[2]) {
                        result.add(new int[] {i,aBuilding[2]});
                    }
                    pq.add(aBuilding);
                    
                    System.out.println("add---");
                    for(int[] array:pq) {
                        System.out.println(array[0]+"-"+array[1]+","+array[2]);
                    }
                }
                if(aBuilding[1]==i) {
                    int prevTop=pq.peek()[2];
                    pq.remove(aBuilding);
                    System.out.println("remove---");
                    for(int[] array:pq) {
                        System.out.println(array[0]+"-"+array[1]+","+array[2]);
                    }
                    if(prevTop>pq.peek()[2]) {
                        result.add(new int[]{i,pq.peek()[2]});
                    }
                }
            }
        }

        /*
        pq.add(buildings[0]);
        pq.add(buildings[1]);
        pq.add(buildings[2]);
        
        for(int[] array:pq) {
            System.out.print("\n"+array[0]+"-"+array[1]+":"+array[2]);
        }

        pq.poll();
        for(int[] array:pq) {
            System.out.print("\n"+array[0]+"-"+array[1]+":"+array[2]);
        }*/
        
        return result;
    }
    public static void main(String[] args) {
        int[][] buildings = new int[][] { {2,9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        SkyLine sl = new SkyLine();
        List<int[]> result = sl.getSkyline(buildings);
        System.out.println("result------");
        for(int[] array:result) {
            System.out.println(array[0]+"->"+array[1]);
        }
       
    }
}
