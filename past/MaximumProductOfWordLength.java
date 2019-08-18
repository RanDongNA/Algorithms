public class Solution {
    public int maxProduct(String[] words) {
 		int max = 0;

 		if(words == null || words.length <= 1) {
 			return max;
 		}

 		for(int i = 0; i < words.length - 1; i++) {
 			
 			Set<Character> set = new HashSet<>();

 			String word = words[i];
 			int iLen = word.length();

 			for(int c = 0; c < iLen; c++) {
 				set.add(word.charAt(c));
 			}
 			
 			for(int j = i + 1; j < words.length; j++) {
 				
 				String wordj = words[j];
 				int jLen = wordj.length();
                
                
 				if(iLen * jLen <= max) {
 					continue;
 				}

 				boolean hasDuplicate = false;
 				
 				for(int cj = 0; cj < jLen; cj++) {
 					
 					Boolean result = set.add(wordj.charAt(cj));
 					
 					// if duplicate happends
 					if(result == false) {
 						hasDuplicate = true;
 						break;
 					}

 					set.remove(wordj.charAt(cj));

 				}

 				if(hasDuplicate) {
 				    
 					continue;
 				} else {
 				    
 					max = iLen * jLen;	
 					
 				}

 			}
 		}

 		return max;
    }
}