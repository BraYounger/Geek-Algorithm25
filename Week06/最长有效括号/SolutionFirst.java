package hard.leetcode32;

/**
 * @ClassName: SolutionFirst
 * @Description: 最长有效括号
 * @Author: Liu Yong
 * @Date: 2021/5/16 10:05 上午
 * @解题思路:
 * 1.采用动态规划的思想，初始化动态规划数组dp[s.length()],dp[i]表示以s.charAt(i)字符结尾的最长有效字符串长度
 * 2.动态规划方程:
 *      if(s.charAt(i) == '(') -> dp[i] = 0
 *      if (s.charAt(i) == ')')
 *          if (s.charAt(i - 1) == '(') -> dp[i] = dp[i - 2] + 2
 *          if (s.charAt(i - 1) == ')' && dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') -> dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
 * 3.每次迭代都将大于max的dp[i]覆盖到max上，最终返回max
 */
public class SolutionFirst {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) dp[i] += dp[i - 2];
                } else if (dp[i - 1] > 0) {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] += dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
