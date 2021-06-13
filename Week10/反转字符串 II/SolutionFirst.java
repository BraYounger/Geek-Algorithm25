package easy.leetcode541;

/**
 * @ClassName: SolutionFirst
 * @Description: 反转字符串 II - 暴力求解
 * @Author: Liu Yong
 * @Date: 2021/6/3 8:54 上午
 */
public class SolutionFirst {

    public String reverseStr(String s, int k) {
        if (s == null) return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2*k) {
            int m = i, n = Math.min(m + k - 1, s.length() - 1);
            while (m < n) {
                char tmp = chars[m];
                chars[m++] = chars[n];
                chars[n--] = tmp;
            }
        }
        return new String(chars);
    }

}
