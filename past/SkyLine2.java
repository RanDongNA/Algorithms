import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
class SkyLine2 
{

    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length<1) return null;
        List<int[]> result = new ArrayList<int[]>();
        PriorityQueue<int[]> buildingInHand = new PriorityQueue<int[]>(3,new MyComparator());
        //List<int[]> buildingInHand = new ArrayList<int[]>();
        /*
        int[][] buildingIn = new int[buildings.length][2];
        int[][] buildingOut = new int[buildings.length][2];
        for(int i=0;i<buildings.length;i++) {
            buildingIn[i][0]=buildings[i][0];
            buildingOut[i][0]=buildings[i][1];
            buildingIn[i][1]=buildings[i][2];
            buildingOut[i][1]=buildings[i][2];
        }*/

                
        int maxRi = 0;
        for(int[] b : buildings) maxRi=b[1]>maxRi?b[1]:maxRi;
        //buildingInHand.add(new int[]{0,maxRi,0});

        for(int i=0;i<buildings.length;i++) {
            
            // When concerning a new building
            //System.out.println("\n"+i+" round:\n------------------");
            
            // store the building
            int[] aBuilding = buildings[i];
            
            // nowX stands for the start x coordinate of the new building
            int nowX = aBuilding[0];//3
            
            // lastX stands for the end x coordinate of the highest building [before take the new building]
                
            // if lastX >= nowX, then this building are
            int[] buildingUnder = buildingInHand.peek();
            int lastX = buildingUnder==null?0:buildingUnder[1];
            int lastH = buildingUnder==null?0:buildingUnder[2];

            //System.out.println("lastX= "+lastX);
            
            // this while loop means to clear all the buildings that reached their ends.
            // this lastX is the Ri of next the building to be removed
            // why starts from the peek()? cause priority queue only has peek()
            // so if the top cover all others, lastX will be updated so
            // so that candidateRemoveB[1]>=lastX return false, -> won't be in result
            while(lastX<=nowX) {
                
                // remove the highest building that reached its end
                int[] candidateRemoveB = buildingInHand.poll();

                // if there is no building in hand
                if(candidateRemoveB==null) {
                    break;
                }

                // for debug
                


                //lastX = buildingInHand.peek()[1];
                
                // this block should be able to figure out 
                // if that remove will end up with a new point in the result
                // - if the Ri of the removed building is 
                //   greater than a known result's Ri
                //   and less than new building's Li, it should be added in the result
                // Excetpions: another one with same Ri and same Height
                if(candidateRemoveB[1]>=lastX) {                    
                    
                    for(int[] aPoint:result) {
                        if(aPoint[0]==candidateRemoveB[1]) {
                            //System.out.println("\nresult removed: "+aPoint[0]+","+aPoint[1]);
                            result.remove(aPoint);
                            break;
                        }
                    }

                    // for debug
                    /*
                    System.out.println(" - result------");
                    for(int[] array:result) {
                        System.out.println(array[0]+"->"+array[1]);
                    }
                    System.out.println("buildingInHand---");
                    for(int[] array:buildingInHand) {
                        System.out.println(array[0]+"-"+array[1]+","+array[2]);
                    }
                    */
                    int[] nextBuilding = buildingInHand.peek();
                    result.add(new int[]{candidateRemoveB[1],nextBuilding==null?0:nextBuilding[2]});
                    lastX = candidateRemoveB[1];
                   
                } else {
                    
                }
                /*
                System.out.println("remove-"+candidateRemoveB[0]+"-"+candidateRemoveB[1]+","+candidateRemoveB[2]);
                System.out.println(" - result------");
                for(int[] array:result) {
                    System.out.println(array[0]+"->"+array[1]);
                }*/
                /*
                System.out.println("remove---");
                for(int[] array:buildingInHand) {
                   System.out.println(array[0]+"-"+array[1]+","+array[2]);
                }*/
                // if there are some decreases                
            }
            //System.out.println("\n lastH:"+lastH+" - "+aBuilding[2]);
            buildingUnder = buildingInHand.peek();
            lastH=buildingUnder==null?0:buildingUnder[2];
            
            if(lastH < aBuilding[2]) {
                for(int[] aPoint:result) {
                    if(aPoint[0]==aBuilding[0]) {
                        result.remove(aPoint);
                        break;
                    }
                }
                result.add(new int[] {aBuilding[0],aBuilding[2]});
            }
            /*
             System.out.println("\n add result------");
                    for(int[] array:result) {
                        System.out.println(array[0]+"->"+array[1]);
            }*/
            buildingInHand.add(aBuilding);            
            
            // for debug
            /*
            System.out.println("add---"+aBuilding[0]+"-"+aBuilding[1]+","+aBuilding[2]);
            System.out.println(" - result------");
            for(int[] array:result) {
                System.out.println(array[0]+"->"+array[1]);
            }*/
            
            /*
            for(int[] array:buildingInHand) {
                System.out.println(array[0]+"-"+array[1]+","+array[2]);
            }*/

        }// end for gneral loop
        
        // for debug
        /*
        System.out.println("result before final------");
        for(int[] array:result) {
            System.out.println(array[0]+"->"+array[1]);
        }
        System.out.println("buildingInHand---");
                for(int[] array:buildingInHand) {
                   System.out.println(array[0]+"-"+array[1]+","+array[2]);
                }
        System.out.println("result------");
        for(int[] array:result) {
            System.out.println(array[0]+"->"+array[1]);
        }
        */
        int lastX = buildingInHand.peek()[1];
        
        // for debug
        //System.out.println("lastX= "+lastX);

        // for the last round
        while(lastX<maxRi) {
                

                // for debug
                /*
                System.out.println("***buildingInHand---");
                for(int[] array:buildingInHand) {
                   System.out.println(array[0]+"-"+array[1]+","+array[2]);
                }
                */

                int[] candidateRemoveB = buildingInHand.poll();
                if(candidateRemoveB[1]>lastX) {
                    result.add(new int[]{candidateRemoveB[1],buildingInHand.peek()[2]});
                    lastX = candidateRemoveB[1];
                }

                // for debug
                /*System.out.println("***result------");
                for(int[] array:result) {
                    System.out.println(array[0]+"->"+array[1]);
                }*/
        }
        result.add(new int[]{maxRi,0});

        // for debug
        /*
        System.out.println("buildingInHand---");
                for(int[] array:buildingInHand) {
                   System.out.println(array[0]+"-"+array[1]+","+array[2]);
        }
        System.out.println("result------");
        for(int[] array:result) {
            System.out.println(array[0]+"->"+array[1]);
        }
        */
        return result;
    }
    public static void main(String[] args) {
        //                                   0->3,2->0,3->5,6->4,7->0,8->1,9->0
        int[][][] buildings = new int[][][] {{{1,3,2},{3,5,2},{7,8,1}},
                                             {{1,3,2},{4,5,2},{7,8,1}},
                                             {{1,3,2},{3,5,3},{7,8,1}},
                                             {{1,3,2},{3,5,1},{7,8,1}},
                                             {{1,3,2},{2,4,3},{7,8,1}},/*
                                             {{1,3,2},{2,4,1},{7,8,1}},
                                             {{1,3,2},{2,4,2},{7,8,1}},
                                             {{1,3,2},{2,3,2},{7,8,1}},
                                             {{1,3,2},{2,3,1},{7,8,1}},
                                             {{1,3,2},{2,3,3},{7,8,1}},
                                             {{1,3,2},{1,3,1},{2,3,1},{7,8,1}},
                                             {{1,4,2},{2,3,1},{7,8,1}},
                                             {{1,4,2},{2,3,3},{7,8,1}},
                                             {{1,4,2},{2,3,2},{7,8,1}}*/};
        SkyLine2 sl = new SkyLine2();
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


/*
class MyComparator implements Comparator<int[]> {
    public int compare(int[] data1,int[] data2) {
        return data2[2]-data1[2];
    }
}*/
