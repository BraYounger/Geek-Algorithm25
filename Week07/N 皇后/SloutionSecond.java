package hard.leetcode51;

import java.util.*;

public class SloutionSecond {

    private int n;
    private List<List<String>> result;
    private Set<Integer> cols;
    private Set<Integer> main;
    private Set<Integer> sub;
    private Deque<Integer> path;
    private char[] tempChars;

    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        this.n = n;
        this.cols = new HashSet<>();
        this.main = new HashSet<>();
        this.sub = new HashSet<>();
        this.path = new LinkedList<>();
        this.tempChars = new char[n];
        for (int i = 0; i < n; i++) {
            this.tempChars[i] = '.';
        }
        dfs(0);
        return result;
    }

    private void dfs(int row) {
        if (row == n) {
            addToResult();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!cols.contains(i) && !main.contains(row - i) && !sub.contains(row + i)) {
                cols.add(i);
                main.add(row - i);
                sub.add(row + i);
                path.push(i);
                dfs(row + 1);
                cols.remove(i);
                main.remove(row - i);
                sub.remove(row + i);
                path.pop();
            }
        }
    }

    private void addToResult() {
        List<String> rowStrList = new ArrayList<>();
        for (Integer place : path) {
            tempChars[place] = 'Q';
            rowStrList.add(new String(tempChars));
            tempChars[place] = '.';
        }
        result.add(rowStrList);
    }


}
