package easy.leetcode455;

import java.util.Arrays;

/**
 * @ClassName: SolutionFirst
 * @Description: 分发饼干 - 贪心算法
 * @Author: Liu Yong
 * @Date: 2021/4/22 9:11 下午
 */
public class SolutionFirst {

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, result = 0;
        while (i < g.length && j < s.length) {
            if (s[i] <= g[j]) {
                result++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return result;
    }

}
