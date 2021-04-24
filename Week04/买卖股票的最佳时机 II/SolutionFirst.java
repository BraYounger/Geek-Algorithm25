package easy.leetcode122;

/**
 * @ClassName: SolutionFirst
 * @Description: 买卖股票的最佳时机 II - 贪心算法
 * @Author: Liu Yong
 * @Date: 2021/4/24 6:57 下午
 * @解题思路
 * 1.采用贪心算法的思想
 * 2.循环计算价格表中前后两天的价格差，并且只将正数相加，最后的和即为最大利润
 */
public class SolutionFirst {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;
        int diff = 0;
        for (int i = 1; i < prices.length; i++) {
            diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                max += diff;
            }
        }
        return max;
    }

}
