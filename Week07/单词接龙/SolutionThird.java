package hard.leetcode127;


import java.util.*;

/**
 * @ClassName: SolutionSecond
 * @Description: 单词接龙
 * @Author: Liu Yong
 * @Date: 2021/5/25 5:13 下午
 * @解题思路: 双向BFS
 */
public class SolutionThird {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        int step = 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
            }
            step++;
            Set<String> tempBeginSet = new HashSet<>();
            for (String word : beginSet) {
                char[] curCArray = word.toCharArray();
                for (int k = 0; k < curCArray.length; k++) {
                    char curChar = curCArray[k];
                    for (char i = 'a'; i <= 'z'; i++) {
                        if (i == curCArray[k]) continue;
                        curCArray[k] = i;
                        String tempStr = new String(curCArray);
                        if (endSet.contains(tempStr)) return ++step;
                        if (wordSet.contains(tempStr) && !visited.contains(tempStr)) {
                            tempBeginSet.add(tempStr);
                            visited.add(tempStr);
                        }
                    }
                    curCArray[k] = curChar;
                }
            }
            beginSet = tempBeginSet;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionThird().ladderLength("hit", "dog", Arrays.asList("hit","hot","git","tog","hog","dot","dog")));
    }

}
