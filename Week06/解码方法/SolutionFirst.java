package medium.leetcode91;

/**
 * @ClassName: SolutionFirst
 * @Description: 解码方法
 * @Author: Liu Yong
 * @Date: 2021/5/16 1:52 下午
 * @解题思路:
 * 1.采用动态规划的思想，设置两个滚动字段pre，cur，初始值均为1
 * 2.迭代中，未经处理的pre表示截止到上上个字符的最多解码结果数，cur表示截止到上个字符的最多解码结果数
 * 3.动态规划方程：
 *      if (s.charAt(i) == '0') -> cur = pre
 *      else -> return 0
 *      if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) -> cur += pre;
 * 4.最后返回cur
 */
public class SolutionFirst {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int pre = 1, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = cur;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) > '0' && s.charAt(i - 1) <= '2') cur = pre;
                else return 0;
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                cur += pre;
            }
            pre = temp;
        }
        return cur;
    }

}
