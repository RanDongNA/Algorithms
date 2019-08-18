public class Answer3 {   
    public static int answer(int[][] meetings) { 

        // Your code goes here.
        int result = 0;
        int min = findMinEnd(meetings,0);
        while(min!=1000001) {
            result++;
            min = findMinEnd(meetings,min);
        }
        return result;

    } 

    public static int findMinEnd(int[][] meetings, int lastEnd) {
        int min= 1000001;
        for(int i=0;i<meetings.length;i++) {
            if(meetings[i][0]<lastEnd)
                continue;
            else if(meetings[i][1]<min)
                min = meetings[i][1];
        }
        return min;
    }

    public static void main(String [] args) {
        int[][] a = new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 5}, {4, 5}};
        System.out.println("result= "+ answer(a));

    }
}


