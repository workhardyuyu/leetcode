
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //for grid g(i,j), it ways are g(i-1,j)+g(i,j-1)
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        if(obstacleGrid[0].length == 0) return 0;
        
        int x = obstacleGrid.length; 
        int y = obstacleGrid[0].length;
        int[][] array = new int[x][y];
        
        //initiate x and y separately
        for(int i=0; i<x; i++){
            if(obstacleGrid[i][0] == 1) break;
            array[i][0] = 1;
        }
        
        for(int i=0; i<y; i++){
            if(obstacleGrid[0][i] == 1) break;
            array[0][i] = 1;
        }
        
        //dynamic programming
        for(int i=1; i<x; i++){
            for(int j=1; j<y; j++){
                if(obstacleGrid[i][j] == 1) continue;
                array[i][j] = array[i-1][j] + array[i][j-1];
                
            }
        }
       
       return array[x-1][y-1]; 
    }
}
