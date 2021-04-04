package easy.leetcode26;

/**
 * @ClassName: Solution
 * @Description: 删除有序数组中的重复项 - 双指针法
 * @Author: Liu Yong
 * @Date: 2021/3/31 9:56 下午
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int firstPoint = 0;
        for (int secondPoint = 1; secondPoint < nums.length; secondPoint++) {
            if (nums[secondPoint] > nums[firstPoint]) {
                nums[++firstPoint] = nums[secondPoint];
            }
        }
        return ++firstPoint;
    }

}
