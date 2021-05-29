package easy.leetcode190;

/**
 * @ClassName: SolutionFirst
 * @Description: 颠倒二进制位
 * @Author: Liu Yong
 * @Date: 2021/5/29 4:15 下午
 * @解题思路: 位运算，初始化res为0，通过表达式 "n & 1"取出n的最后一位，然后将其或上res左移后的结果以达到拼接到res最后一位的效果
 */
public class SolutionFirst {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }

}
