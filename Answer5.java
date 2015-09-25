import java.util.*;

public class Answer5 {   
    public static int[] answer(int[][] minions) { 
    	PriorityQueue<MyUnit> pq = new PriorityQueue<MyUnit>(minions.length, new MyComparator());
    	for(int i=0;i<minions.length;i++) {    		
    		MyUnit mu = new MyUnit(minions[i][0],minions[i][1],minions[i][2],i);
    		pq.add(mu);
    	}

        int[] result = new int[minions.length];
        for(int i=0;i<result.length;i++) {
        	result[i] = pq.poll().index;
        }
        return result;

    } 

    public static void main(String[] args) {
    	int[][] minions = {{390, 185, 624}, {686, 351, 947}, {276, 1023, 1024}, {199, 148, 250}};	
    	int[] result = answer(minions);
    	for(int i=0;i<result.length;i++) {
    		System.out.println(result[i]);
    	}
    }
}

class MyComparator implements Comparator<MyUnit> {
	@Override
	public int compare(MyUnit a, MyUnit b) {
        
        if(a.result>b.result)
            return 1;
        else if(a.result<b.result)
            return -1;
        else if(a.numerator!=b.numerator)
        	return a.numerator-b.numerator;
        else if(a.denominator!=b.denominator)
        	return a.denominator-b.denominator;
        else if(a.index!=b.index)
            return a.index-b.index;
        else
            return 0;
	}
}

class MyUnit {
	public int index;
	public int time;
	public int numerator;
	public int denominator;
	
	public double result;
	
	public MyUnit(int time, int numerator, int denominator, int index) {
		this.index = index;
		this.time = time;
		this.numerator = numerator;
		this.denominator = denominator;
		this.result = (double)(time*denominator/numerator);
	} 
}