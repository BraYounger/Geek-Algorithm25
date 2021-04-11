package medium.leetcode429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: SolutionSecond
 * @Description: N 叉树的层序遍历 - 递归
 * @Author: Liu Yong
 * @Date: 2021/4/11 6:07 下午
 */
public class SolutionSecond {

    private List<List<Integer>> resultList = new ArrayList<>();

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) {
            traverse(root, 0);
        }
        return resultList;
    }

    private void traverse(Node root, int level) {
        if (resultList.size() <= level) {
            resultList.add(new ArrayList<>());
        }
        resultList.get(level).add(root.val);
        for (Node child : root.children) {
            traverse(child, level + 1);
        }
    }

}
