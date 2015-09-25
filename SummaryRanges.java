import java.util.*;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums==null || nums.length<1) return result;        

        int last=nums[0];
        boolean hasSecond = false;
        boolean isFirst = false;
        String temp=""+last;
        for(int i=1;i<nums.length;i++) {
            //System.out.println(nums[i]+" "+last);
            if(isFirst) {
               temp+=""+nums[i]; 
               isFirst=false;
            } else if(nums[i]-1==last) {
                if(hasSecond==false) {
                    temp+="->";
                    hasSecond=true;
                }
                last++;
            } else {
          //      System.out.println("else");
                if(hasSecond)
                    temp+=""+last;
                result.add(temp);
                temp=new String("");
                last = nums[i];
                temp+=""+last;
                hasSecond=false;
                isFirst=false;
            }
        }
        if(hasSecond)
            temp+=""+last;
        result.add(temp);
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        new SummaryRanges().summaryRanges(new int[]{0,1,2,4,7});
    }
}