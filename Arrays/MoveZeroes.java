class Solution {
    public void moveZeroes(int[] nums) { 
        int j = -1;

        for (int i = 0; i < nums.length; i++) { 
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) return;

        for (int i = j+1; i < nums.length; i++) {
            if (nums[i] != 0) {

                int temp = nums[i];
                nums[i] = nums[j];
                nums [j] = temp;
                j++;
            }
        }
        
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums);

        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }
}
