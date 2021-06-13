package easy.leetcode680;

/**
 * @ClassName: SolutionFirst
 * @Description: 验证回文字符串 Ⅱ
 * @Author: Liu Yong
 * @Date: 2021/6/5 1:56 下午
 * @解题思路: 双指针 + 递归（分治）
 */
public class SolutionFirst {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 2) return true;
        return valid(s.toCharArray(), 0, s.length() - 1, 0);
    }

    private boolean valid(char[] sc, int start, int end, int count) {
        for (; start < end; start++, end--) {
            if (sc[start] == sc[end]) continue;
            if (count == 0) {
                return valid(sc, start + 1, end, 1) || valid(sc, start, end - 1, 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionFirst().validPalindrome("lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul"));
    }

}
