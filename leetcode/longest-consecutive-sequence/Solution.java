import java.util.*;

/**
 * @author jashgopani
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> s = new HashSet<>();

        for (int n : nums)
            s.add(n);

        int len = 0;
        int max = len;
        for (int n : nums) {
            if (!s.contains(n - 1)) {
                // start of sequence
                len = 1;
                int next = n + 1;
                while (s.contains(next)) {
                    len++;
                    next++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int bruteForce(int[] nums) {
        if (nums.length == 0)
            return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
        }

        int len = 1;
        int max = len;
        int prev = minHeap.poll();
        while (!minHeap.isEmpty()) {
            int val = minHeap.poll();
            if (val == prev + 1) {
                len++;
            } else if (val != prev) {
                max = Math.max(max, len);
                len = 1;
            }
            prev = val;
        }
        max = Math.max(max, len);
        return max;
    }
}