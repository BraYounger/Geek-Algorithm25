package medium.leetcode433;

import java.util.*;

/**
 * @ClassName: SolutionFirst
 * @Description: 最小基因变化
 * @Author: Liu Yong
 * @Date: 2021/5/20 7:19 下午
 * @解题思路: 使用辅助队列进行BFS，匹配到bank中的字符串后，将bank中该字符串删除以避免死循环
 */
public class SolutionFirst {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) return -1;
        Deque<String> queue = new LinkedList<>();
        queue.addLast(start);
        set.remove(start);
        int step = 0;
        char[] dir = new char[]{'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            step++;
            for (int i = queue.size(); i > 0; i--) {
                String curStr = queue.removeFirst();
                char[] curCharArray = curStr.toCharArray();
                for (int j = 0; j < curCharArray.length; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (dir[k] == curCharArray[j]) continue;
                        curCharArray[j] = dir[k];
                        String newStr = new String(curCharArray);
                        if (end.equals(newStr)) {
                            return step;
                        } else if (set.contains(newStr)) {
                            queue.addLast(newStr);
                            set.remove(newStr);
                        }
                    }
                    curCharArray = curStr.toCharArray();
                }
            }
        }
        return -1;
    }

}
