package medium.leetcode36;

import java.util.*;

/**
 * @ClassName: SolutionFirst
 * @Description: 有效的数独
 * @Author: Liu Yong
 * @Date: 2021/5/24 10:14 下午
 * @解题思路: 初始化三个二维数组分别用来表示行、列以及各个九宫格中1～9是否已经出现过，然后依次遍历参数board二维数组来判断是否合法
 */
public class SolutionFirst {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] grids = new boolean[9][9];
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                int gridsRow = (i / 3) * 3 + j / 3;
                int curNumIdx = board[i][j] - '1';
                if (grids[gridsRow][curNumIdx]) return false;
                if (rows[i][curNumIdx]) return false;
                if (cols[j][curNumIdx]) return false;
                grids[gridsRow][curNumIdx] = true;
                rows[i][curNumIdx] = true;
                cols[j][curNumIdx] = true;
            }
        }
        return true;
    }

}
