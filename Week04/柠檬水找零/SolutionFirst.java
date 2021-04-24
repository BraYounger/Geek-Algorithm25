package easy.leetcode860;

/**
 * @ClassName: SolutionFirst
 * @Description: 柠檬水找零 - 贪心算法
 * @Author: Liu Yong
 * @Date: 2021/4/24 8:16 下午
 * @解题思路: 采用贪心的思想，每次找钱优先使用最大面值的
 */
public class SolutionFirst {

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                five--;
            } else {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0) {
                return false;
            }
        }
        return true;
    }

}
