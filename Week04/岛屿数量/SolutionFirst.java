package medium.leetcode200;

/**
 * @ClassName: SolutionFirst
 * @Description: 岛屿数量 - 递归(DFS)
 * @Author: Liu Yong
 * @Date: 2021/4/21 8:47 上午
 * @解题思路:
 * 1.嵌套循环遍历二维数组
 * 2.遇到'1'时，count++，并执行DFS递归
 * 3.每次递归中都将当前位置的上下左右位置都置为0
 */
public class SolutionFirst {

    int count = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return count;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsMarking(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfsMarking(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j>= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfsMarking(i - 1, j, grid);
        dfsMarking(i + 1, j, grid);
        dfsMarking(i, j + 1, grid);
        dfsMarking(i, j - 1, grid);
    }

}
