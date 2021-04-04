package easy.leetcode66;

/**
 * @ClassName: Solution
 * @Description: 加一
 * @Author: Liu Yong
 * @Date: 2021/4/2 7:57 下午
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int modulus = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            modulus = (digits[i] + 1) % 10;
            digits[i] = modulus;
            if (modulus != 0) {
                return digits;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
