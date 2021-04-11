package medium.leetcode347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName: SolutionFirst
 * @Description: 前K个高频元素 - 大顶堆
 * @Author: Liu Yong
 * @Date: 2021/4/11 4:51 下午
 */
public class SolutionFirst {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return nums;
        }
        int[] result = new int[k];
        Map<Integer, Integer> elements = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) -> (elements.get(o2) - elements.get(o1))));
        for (int i : nums) {
            elements.put(i, elements.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : elements.entrySet()) {
            heap.add(entry.getKey());
        }
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

}
