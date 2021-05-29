package easy.leetcode231;

/**
 * @ClassName: SolutionFirst
 * @Description: 2的幂
 * @Author: Liu Yong
 * @Date: 2021/5/24 6:31 下午
 * @解题思路: 采用位运算，假设2的整数次幂为n，那一定有 n & (n - 1) = 0
 *      - 举例 : 1000 & 0111 = 0
 */
public class SolutionFirst {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
