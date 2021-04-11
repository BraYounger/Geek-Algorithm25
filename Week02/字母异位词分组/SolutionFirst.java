package medium.leetcode49;

import java.util.*;

/**
 * @ClassName: SolutionFirst
 * @Description: 字母异位词分组
 * @Author: Liu Yong
 * @Date: 2021/4/10 11:07 上午
 */
public class SolutionFirst {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        List<String> loopList = null;
        char[] loopChars = null;
        String loopString = null;
        for (String str : strs) {
            loopChars = str.toCharArray();
            Arrays.sort(loopChars);
            loopString = new String(loopChars);
            loopList = map.getOrDefault(loopString, new ArrayList<>());
            loopList.add(str);
            map.put(loopString, loopList);
        }
        return new ArrayList<>(map.values());
    }

}
