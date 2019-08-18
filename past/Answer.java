public class Answer {   
    public static int answer(int[] numbers) { 

        // Your code goes here.
        int max=0;
        
        for(int i=0;i<numbers.length;i++) {
            for(int x:numbers) System.out.print(x+" ");
            
            //System.out.println("\nin the for loop for: i= "+i);
            int a = part(numbers,i);
            max = a>max?a:max;
            numbers[i]=-1;
        }
        
        return max;
        
        
    }
    
    public static int part(int[] numbers,int start) {
        if(numbers[start]==-1) return -1;
        int index1= start,index2=start;
        do{
            //System.out.println("index1: "+index1+"; index2= "+index2+"; next= "+numbers[index1]);
            index1 = numbers[index1];
            index2 = numbers[index2];
                if(index2==-1) return -1;
            index2 = numbers[index2];
                if(index2==-1) return -1;
        } while (index1!=index2);
        

        int result =0;
        int temp;
        do{
            temp=index1;
            index1 = numbers[index1];
            numbers[temp] = -1;
            result++;
        } while (numbers[index1]!=-1);
        
        return result;
    }

    public static void main(String [] args) {
        int[] data = new int[]{1,3,0,5,0,1};
        System.out.println("result= "+answer(data));
    }
}