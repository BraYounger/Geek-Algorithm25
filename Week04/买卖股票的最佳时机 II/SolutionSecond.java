package easy.leetcode122;

/**
 * @ClassName: SolutionSecond
 * @Description: 买卖股票的最佳时机 II - 动态规划
 * @Author: Liu Yong
 * @Date: 2021/4/24 7:03 下午
 * @解题思路
 * 1.采用动态规划的思想
 * 2.用两个滚动变量来存放每一天买、卖两种行为对应的利润
 * 3.按天迭代，每次迭代中分别利用前一天的买卖两种行为对应的利润计算出当天的两种行为对应的最大利润
 * 4.迭代至最后一天后，取卖行为对应的利润即为最大利润
 */
public class SolutionSecond {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int cash = 0;
        int hold = 0 - prices[0];
        int i = 1;
        do {
            int preCash = cash;
            int preHold = hold;
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);
        } while (i < prices.length);
        return cash;
    }

}
