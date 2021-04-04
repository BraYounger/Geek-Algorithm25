package medium.leetcode189;

/**
 * @ClassName: Solution
 * @Description: 旋转数组 - 翻转数组
 * @Author: Liu Yong
 * @Date: 2021/3/31 10:03 下午
 */
public class Solution {

    public void rotate(int nums[], int k) {
        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int nums[], int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = nums[endIndex];
            nums[endIndex] = nums[startIndex];
            nums[startIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

}
