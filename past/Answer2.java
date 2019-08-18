public class Answer2 {   
    public static int[][] answer(int[][] population, int x, int y, int strength) { 

        // Your code goes here.
    	int [][] result = new int[population.length][population[0].length];
    	for(int i=0;i<population.length;i++) {
    		for(int j=0;j<population[0].length;j++) {
    			result[i][j] = population[i][j];
    		}
    	}
    	result[y][x]=0;
    	dfs(result,x,y,strength);

    	return result;
    } 

    public static void dfs(int[][] population, int x,int y,int strength) {
    	if(y>=population.length || y<0 ||x>=population[0].length||x<0) return;
    	if(population[y][x]<0) return;
    	if(population[y][x]<=strength) {
    		population[y][x]=-1;
    		dfs(population,x+1,y,strength)
    		dfs(population,x-1,y,strength);
    		dfs(population,x,y+1,strength);
    		dfs(population,x,y-1,strength);
    	}
    }
}
