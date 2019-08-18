import java.util.*;

public class Answer4 {   
	private static String result;
	
	public static void recurRemove(String str, String word) {

    	String afterRemove = str;   	
		int index = afterRemove.indexOf(word);

		if(index==-1) {			
			addCandidate(afterRemove);
			return;
		}

		while(index!=-1) {	
	    	afterRemove = str.substring(0,index) 
	    		+ str.substring(index+word.length());		

			recurRemove(afterRemove,word);
			
			index = str.indexOf(word,index+1);
		} 

	}

	public static void addCandidate(String candidate) {
		if(candidate.length()<result.length()) {
			result = candidate;
		} else if(candidate.length()>result.length()){
			return;
		} else if(candidate.compareTo(result)<0) {
			result = candidate;
		}
	}

    public static String answer(String chunk, String word) { 
		result = chunk;
		recurRemove(preRemove(chunk,word),word);	
		return result;
    }

    public static String preRemove(String chunk, String word) {
    	List<Integer> indexList = new ArrayList<Integer>();
    	int index = chunk.indexOf(word);
    	while(index!=-1) {
    		indexList.add(index);
    		index = chunk.indexOf(word,index+1);
    	}
    	String str = chunk;
    	boolean [] chart= new boolean[indexList.size()];
    	for(int i=0;i<chart.length;i++) {
    		Integer num = indexList.get(i);
   			chart[i] = (i>0?(indexList.get(i-1)+word.length()-1<num):true) 
   											&& 
   		(i<indexList.size()-1?(num+word.length()-1<indexList.get(i+1)):true);
    	}

    	for(int i=indexList.size()-1;i>=0;i--) {
    		if(chart[i])
    			str = str.substring(0,indexList.get(i))
    					+str.substring(indexList.get(i)+word.length());
    	}
        return str;
    }


    public static void main(String [] args) {
    	//System.out.println("pre: "+preRemove("abawabahababaaabaoabasaababaababaababaaay","aba"));
        System.out.println("original msg: "
    		+Answer4.answer(
    			"abawabahababaaabaoabasaababaababaababaaay",//abaabababaaaourdaddy",
    			"aba"));
    }

}