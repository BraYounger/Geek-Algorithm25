package easy.leetcode70;

/**
 * @ClassName: SolutionFifth
 * @Description: 爬楼梯
 * @Author: Liu Yong
 * @Date: 2021/5/24 10:00 下午
 * @解题思路: 采用动态规划的思想，DP方程：dp[i] = dp[i - 1] + dp[i - 2]，此处可以使用滚动变量s1和s2来优化空间复杂度为O(1)
 */
public class SolutionFifth {

    public int climbStairs(int n) {
        if (n < 4) return n;
        int s1 = 2, s2 = 3;
        for (int i = 4; i <= n; i++) {
            s2 = s1 + s2;
            s1 = s2 - s1;
        }
        return s2;
    }

}
