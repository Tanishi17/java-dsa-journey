
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deque = new ArrayDeque<>();

        long ans = 0;
        long operations = 0;

        int left = 0;

        for (int right = 0; right < n; right++) {

            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            deque.offerLast(right);

            if (!deque.isEmpty()) {
                operations += (long) nums[deque.peekFirst()] - nums[right];
            }

            while (operations > k) {

                if (deque.peekFirst() == left) {
                    deque.pollFirst();
                }

                left++;

                operations = 0;

                int maxVal = 0;
                for (int i = left; i <= right; i++) {
                    maxVal = Math.max(maxVal, nums[i]);
                    operations += maxVal - nums[i];
                }
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
