class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count += 1;
                nums[i] = 51;
            }
        }
        Arrays.sort(nums);
        int idx = nums.length - count;
        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
        return idx;
    }
}