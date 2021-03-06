public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int row = obstacleGrid.length;
    	int col = obstacleGrid[0].length;
    	if (obstacleGrid == null) return 0;
    	if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) return 0;

    	int totalPath[][] = new int[row][col];
    	totalPath[0][0] = obstacleGrid[0][0] ==  1 ? 0 : 1;
    	
    	for (int i = 1; i < row; i++) {
    		if (obstacleGrid[i][0] == 1) 
    			totalPath[i][0] = 0;
    		else
    			totalPath[i][0] = totalPath[i - 1][0];
    	}
    	for (int i = 1; i < col; i++) {
    		if (obstacleGrid[0][i] == 1)
    			totalPath[0][i] = 0;
    		else
    			totalPath[0][i] = totalPath[0][i - 1];
    	}
    	
    	for (int i = 1; i < row; i++)
    		for (int j = 1; j < col; j++) {
    			if (obstacleGrid[i][j] == 1)
    				totalPath[i][j] = 0;
    			else totalPath[i][j] = totalPath[i][j - 1] + totalPath[i - 1][j];
    		}
    	return totalPath[row - 1][col - 1];
    }

    public static void main(String[] args) {
    	int A[][] = {{0,0,0,0,0},
    				 {0,0,0,0,1},
    				 {0,0,0,1,0},
    				 {0,0,1,0,0}};
    	System.out.println(new Solution().uniquePathsWithObstacles(A));
	}
}
