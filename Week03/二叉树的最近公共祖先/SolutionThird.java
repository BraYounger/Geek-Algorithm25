package easy.leetcodeoffer68II;

/**
 * @ClassName: SolutionThird
 * @Description: 二叉树的最近公共祖先 - 递归（分治）
 * @Author: Liu Yong
 * @Date: 2021/4/18 2:04 下午
 * @解题思路:
 * 1.采用类似二叉树后续遍历的递归思路由上至下递归，查找与参数节点值相同的节点
 * 2.递归过程中，如果当前节点的子节点不为空且不等于任一参数值，则继续向下递归直至找到与参数值相等的节点并返回该节点，否则直接返回当前节点
 * 3.如果递归至叶子节点仍未找到与参数值相等的节点则返回空，如果递归的当前节点的两个子递归结果分别不为空则表示两个参数值均已找到，
 *   即当前节点为最近公共祖先，返回当前节点
 */
public class SolutionThird {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

}
