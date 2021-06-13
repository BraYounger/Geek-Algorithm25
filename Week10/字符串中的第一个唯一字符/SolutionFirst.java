package easy.leetcode387;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SolutionFirst
 * @Description: 字符串中的第一个唯一字符 - 哈希映射
 * @Author: Liu Yong
 * @Date: 2021/6/8 8:38 上午
 */
public class SolutionFirst {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

}
