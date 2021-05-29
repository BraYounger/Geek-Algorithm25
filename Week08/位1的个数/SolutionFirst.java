package easy.leetcode191;

/**
 * @ClassName: SolutionFirst
 * @Description: 位1的个数
 * @Author: Liu Yong
 * @Date: 2021/5/29 4:29 下午
 * @解题思路: 通过表达式 "n &= n - 1" 以去除n二进制中最后一位1，直到n为0时则表示1全部去除完成，此时返回count
 */
public class SolutionFirst {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

}
