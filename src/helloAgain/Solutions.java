package helloAgain;

import javafx.scene.layout.Priority;

import java.lang.reflect.Array;
import java.util.*;



public class Solutions {
    static int min = Integer.MAX_VALUE;
    public static int minPathSumRecursive(int[][] grid) {
        return helper(grid, grid.length - 1, grid[0].length - 1);

    }

    public static int helper(int[][] grid, int i, int j){
        if(i<0 || j<0)
            return Integer.MAX_VALUE;
        if(i==0 && j==0)
            return grid[i][j];
        int left = helper(grid, i-1, j);
        int right = helper(grid, i, j-1);
        return grid[i][j] + Math.min(left, right);


    }

    public static int minPathSum(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i  = 1;i<grid[0].length;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1;i<grid.length;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }







    public static void main(String[] args){
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));

    }

}
