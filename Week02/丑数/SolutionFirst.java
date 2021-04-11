package medium.leetcodeoffer49;

/**
 * @ClassName: SolutionFirst
 * @Description: 丑数 - 动态规划
 * @Author: Liu Yong
 * @Date: 2021/4/11 4:11 下午
 */
public class SolutionFirst {

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int a = 0, b = 0, c = 0;
        int xa = 0, xb = 0, xc = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            xa = dp[a] * 2;
            xb = dp[b] * 3;
            xc = dp[c] * 5;
            dp[i] = Math.min(Math.min(xa, xb), xc);
            if (dp[i] == xa) a++;
            if (dp[i] == xb) b++;
            if (dp[i] == xc) c++;
        }
        return dp[n - 1];
    }

}
