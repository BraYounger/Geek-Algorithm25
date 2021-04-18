package medium.leetcode105;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SolutionSecond
 * @Description: 从前序与中序遍历序列构造二叉树 - 递归（分治）
 * @Author: Liu Yong
 * @Date: 2021/4/17 3:30 下午
 * @解题思路: 采用递归的方式分别初始化左子树与右子树，递归过程成不生成新的前序、中序数组，采用数组下标的方式代替
 */
public class SolutionSecond {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length, inMap);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart == preEnd) {
            return null;
        }
        // 获取根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inMap.get(root.val);
        int leftCount = rootIndex - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftCount + 1, inorder, inStart, rootIndex, inMap);
        root.right = build(preorder, preStart + leftCount + 1, preEnd, inorder, rootIndex + 1, inEnd, inMap);
        return root;
    }

}
