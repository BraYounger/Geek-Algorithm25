package hard.leetcode212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SolutionFirst
 * @Description: 单词搜索 II - 前缀树 + 回溯
 * @Author: Liu Yong
 * @Date: 2021/5/19 5:08 下午
 */
public class SolutionFirst {

    private char[][] board;
    private List<String> resultList = new ArrayList<>();

    class Trie {
        Map<Character, Trie> children = new HashMap<>();
        String word;
        public Trie() {};
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        Trie root = new Trie();
        for (String word : words) {
            Trie node = root;
            for (Character c : word.toCharArray()) {
                if (!node.children.containsKey(c)) node.children.put(c, new Trie());
                node = node.children.get(c);
            }
            node.word = word;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) backTracking(i, j, root);
            }
        }
        return resultList;
    }

    private void backTracking(int row, int col, Trie parent) {
        char curChar = board[row][col];
        Trie curNode = parent.children.get(curChar);
        if (curNode.word != null) {
            // 找到一次后将该单词在前缀树中的单词标记消除
            resultList.add(curNode.word);
            curNode.word = null;
        }
        // 向下递归前先将当前位置的字符替换为特殊符号，避免形成回路
        board[row][col] = '#';
        int[] dirRow = {-1, 0, 1, 0};
        int[] dirCol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) continue;
            if (curNode.children.containsKey(board[newRow][newCol])) backTracking(newRow, newCol, curNode);
        }
        // 向下递归结束后回溯到当前层时，恢复当前位置的字符
        board[row][col] = curChar;
        // 剪枝，如果当前节点为前缀树的叶子节点，则表示成功匹配到一个单词，则该叶子节点可以被删除
        if (curNode.children.isEmpty()) {
            parent.children.remove(curChar);
        }
    }

}
