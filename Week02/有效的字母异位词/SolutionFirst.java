package easy.leetcode242;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SolutionFirst
 * @Description: 有效的字母异位词 - 哈希映射
 * @Author: Liu Yong
 * @Date: 2021/4/10 10:52 上午
 */
public class SolutionFirst {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s == "" || t == "" || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

}
