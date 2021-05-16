package medium.leetcode64;

/**
 * @ClassName: SolutionThird
 * @Description: 最小路径和
 * @Author: Liu Yong
 * @Date: 2021/5/16 9:52 上午
 * @解题思路:
 * 1.采用动态规划的的思想
 * 2.复用参数二维数组grid[m][n]为动态规划数组，初始化grid[0][i]以及grid[i][0]
 *      grid[0][i] += grid[0][i - 1]
 *      grid[i][0] += grid[i - 1][0]
 * 3.动态规划方程:
 *      grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1])
 */
public class SolutionThird {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < n; i++) grid[0][i] += grid[0][i - 1];
        for (int i = 1; i < m; i++) grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

}
