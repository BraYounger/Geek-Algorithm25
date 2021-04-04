package easy.leetcode283;

/**
 * @ClassName: Solution
 * @Description: 移动零 - 双指针法
 * @Author: Liu Yong
 * @Date: 2021/3/31 10:28 下午
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int firstPoint = 0;
        for (int secondPoint = 0; secondPoint < nums.length; secondPoint++) {
            if (nums[secondPoint] != 0) {
                nums[firstPoint] = nums[secondPoint];
                if (firstPoint != secondPoint) {
                    nums[secondPoint] = 0;
                }
                firstPoint++;
            }
        }
    }
}