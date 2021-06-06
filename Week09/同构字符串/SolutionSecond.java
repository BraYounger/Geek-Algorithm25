package easy.leetcode205;

/**
 * @ClassName: SolutionSecond
 * @Description: 同构字符串
 * @Author: Liu Yong
 * @Date: 2021/6/4 3:39 下午
 * @解题思路:
 * 1.采用哈希映射的思想，这里引用数组来简化数据结构
 * 2.将两个参数字符串同时按字符前后顺序转化成数字的形式，例如：egg -> 122 <- foo，如两个字符串最终转化出的数字字符串相等，则为同构
 */
public class SolutionSecond {

    public boolean isIsomorphic(String s, String t) {
        int[] mappingS = new int[128];
        int[] mappingT = new int[128];
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (mappingS[sa[i]] == 0) mappingS[sa[i]] = i + 1;
            if (mappingT[ta[i]] == 0) mappingT[ta[i]] = i + 1;
            sa[i] = (char) mappingS[sa[i]];
            ta[i] = (char) mappingT[ta[i]];
        }
        return new String(sa).equals(new String(ta));
    }

    public static void main(String[] args) {
        int i = 'z';
        System.out.println(i);
    }

}
