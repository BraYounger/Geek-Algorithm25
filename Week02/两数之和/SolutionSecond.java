package easy.leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SolutionSecond
 * @Description: 两数之和 - 哈希映射
 * @Author: Liu Yong
 * @Date: 2021/4/2 8:06 下午
 */
public class SolutionSecond {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

}
