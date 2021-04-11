package easy.leetcode589;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: SolutionSecond
 * @Description: N叉树的前序遍历 - 迭代（栈）
 * @Author: Liu Yong
 * @Date: 2021/4/11 1:40 下午
 */
public class SolutionSecond {

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

    public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        Node curr = null;
        List<Node> children = null;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            resultList.add(curr.val);
            children = curr.children;
            if (children == null || children.isEmpty()) {
                continue;
            }
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }
        return resultList;
    }

}
