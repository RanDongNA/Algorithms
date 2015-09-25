import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
class SkyLine3
{

    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length<1) return null;
        
        List<int[]> result = new ArrayList<int[]>();
        PriorityQueue<int[]> hiInHand = new PriorityQueue<int[]>(3,new HiComparator());
        PriorityQueue<int[]> riInHand = new PriorityQueue<int[]>(3,new RiComparator());
        PriorityQueue<int[]> onTheWay   = new PriorityQueue<int[]>(3,new LiComparator());
        
        int[] newBuilding = buildings[0];
        result.add(new int[] {newBuilding[0],newBuilding[2]});

        hiInHand.add(newBuilding);
        riInHand.add(newBuilding);
        //int maxRi = 0;
        //for(int[] b : buildings) maxRi=b[1]>maxRi?b[1]:maxRi;        

        for(int i=1;i<buildings.length;i++) {
            
            newBuilding = buildings[i];
            int[] nextEnd = riInHand.peek();
            
            while(nextEnd!=null && newBuilding[0] > nextEnd[1]) {
                // there exists building that will reach its end before new building show up
                // cause riQ size == hiQ size, so need not to check
                //System.out.println("while");
                int hiBeforeRemove = hiInHand.peek()[2];
                
                int[] temp = riInHand.poll();
                hiInHand.remove(temp);
                
                int[] topBuilding = hiInHand.peek();
                int hiAfterRemove = topBuilding==null?0:topBuilding[2];
                if(hiBeforeRemove != hiAfterRemove) {
                    result.add(new int[]{temp[1],hiAfterRemove});
                }

                nextEnd = riInHand.peek();
            }

            riInHand.add(newBuilding);
            hiInHand.add(newBuilding);

            int[] topBuilding = hiInHand.peek();
            //int hiBeforeAdd = topBuilding==null?0:topBuilding[2];
            //if(newBuilding[2] >= hiBeforeAdd) {
            result.add(new int[]{newBuilding[0],hiInHand.peek()[2]});
            //}
        }

        while(riInHand.size()>0) {
                int hiBeforeRemove = hiInHand.peek()[2];
                int[] temp = riInHand.poll();
                hiInHand.remove(temp);
                
                int[] topBuilding = hiInHand.peek();
                int hiAfterRemove = topBuilding==null?0:topBuilding[2];
                if(hiBeforeRemove != hiAfterRemove) {
                    result.add(new int[]{temp[1],hiAfterRemove});
                }
        }
        int cur=0;
        int next=1;
        while(cur < result.size()-1) {
            int[] a = result.get(cur);
            int[] b = result.get(next);
            
            if(a[1]==b[1]) {
                result.remove(next);
            } else if(a[0]==b[0]) {
                result.remove(cur);
            } else {
                cur++;
                next++;
            }
        }
        return result;    
    }// end of getSkyLine()

    public static void main(String[] args) {
        //                                   0->3,2->0,3->5,6->4,7->0,8->1,9->0
        int[][][] buildings = new int[][][] {{{1,3,2},{3,5,2},{7,8,1}},
                                             {{1,3,2},{4,5,2},{7,8,1}},
                                             {{1,3,2},{3,5,3},{7,8,1}},
                                             {{1,3,2},{3,5,1},{7,8,1}},
                                             {{1,3,2},{2,4,3},{7,8,1}},
                                             {{1,3,2},{2,4,1},{7,8,1}},
                                             {{1,3,2},{2,4,2},{7,8,1}},
                                             {{1,3,2},{2,3,2},{7,8,1}},
                                             {{1,3,2},{2,3,1},{7,8,1}},
                                             {{1,3,2},{2,3,3},{7,8,1}},
                                             {{1,3,2},{1,3,1},{2,3,1},{7,8,1}},
                                             {{1,4,2},{2,3,1},{7,8,1}},
                                             {{1,4,2},{2,3,3},{7,8,1}},
                                             {{1,4,2},{2,3,2},{7,8,1}}};
        SkyLine3 sl = new SkyLine3();
        for(int i=0;i<buildings.length;i++) {
            System.out.println("\n------"+(i+1)+"--------");
            for(int[] array:buildings[i])
                   System.out.println(array[0]+"-"+array[1]+","+array[2]);
            System.out.println("---------------");
            List<int[]> result = sl.getSkyline(buildings[i]);
            for(int[] array:result) {
                System.out.println(array[0]+"->"+array[1]);
            }
        }
       
    }
}



class RiComparator implements Comparator<int[]> {
    public int compare(int[] data1,int[] data2) {
        return data1[1]-data2[1];
    }
}
class HiComparator implements Comparator<int[]> {
    public int compare(int[] data1,int[] data2) {
        if(data2[2]==data1[2])
            // so if two building has same height, the one end first will be the first.
            return data1[1]-data2[1];
        else
            return data2[2]-data1[2];
    }
}
class LiComparator implements Comparator<int[]> {
    public int compare(int[] data1,int[] data2) {
        return data1[0]-data2[0];
    }
}