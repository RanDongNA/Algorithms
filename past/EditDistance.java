public class EditDistance
{
  public int minDistance(String word1, String word2) {
    if(word1 == null || word2 == null) {
      return - 1;
    }

    int word1Len = word1.length();
    int word2Len = word2.length();

    int[][] f = new int[word1Len + 1][word2Len + 1];
    f[0][0] = 0;
    for(int i = 1; i < word1Len + 1; i++) {
      f[i][0] = i;
    }
    for(int j = 1; j < word2Len + 1; j++) {
      f[0][j] = j;
    }

    for(int i = 1; i < word1Len + 1; i++) {
      for(int j = 1; j < word2Len + 1; j++) {
        if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
          f[i][j] = f[i - 1][j - 1];
        } else {
          f[i][j] = 1 + Math.min(
                          Math.min(
                            f[i - 1][j], 
                            f[i][j - 1]
                          ), 
                          f[i - 1][j - 1]
                        );
        }
      } // end for j
    } // end for i

    return f[word1Len][word2Len];
  }
}
