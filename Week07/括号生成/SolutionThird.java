package medium.leetcode22;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SolutionThird
 * @Description: 括号生成
 * @Author: Liu Yong
 * @Date: 2021/5/24 6:17 下午
 * @解题思路:
 * 1.采用DFS的思想进行分层递归
 * 2.每一次递归都根据条件判断对字符串添加左括号和右括号
 * 3.递归到最后一层时将字符串放入结果集合
 */
public class SolutionThird {

    private List<String> result = new ArrayList<>();
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        generate(0, 0, "");
        return result;
    }

    private void generate(int leftCount, int rightCount, String str) {
        if (leftCount + rightCount == 2 * n) {
            result.add(str);
            return;
        }
        if (leftCount < n) generate(leftCount + 1, rightCount, str + "(");
        if (rightCount < leftCount) generate(leftCount, rightCount + 1, str + ")");
    }

    public static void main(String[] args) {
        System.out.println(new SolutionThird().generateParenthesis(3));
    }

}
