package medium.leetcode46;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: SolutionFirst
 * @Description: 全排列 - 递归（回溯）
 * @Author: Liu Yong
 * @Date: 2021/4/18 2:41 下午
 * @解题思路: 使用回溯的思想按层对参数nums数组递归，当层数到达最后一层+1时添加结果并返回。
 */
public class SolutionFirst {

    List<List<Integer>> result;
    boolean[] curStates;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        curStates = new boolean[nums.length];
        dfs(nums, new LinkedList<>(), 0);
        return result;
    }

    private void dfs(int[] nums, Deque<Integer> stack, int level) {
        if (level == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (curStates[i]) continue;
            stack.push(nums[i]);
            curStates[i] = true;
            dfs(nums, stack, level + 1);
            stack.pop();
            curStates[i] = false;
        }
    }

}
