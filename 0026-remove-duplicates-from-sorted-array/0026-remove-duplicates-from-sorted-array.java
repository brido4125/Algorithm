class Solution {
    public int removeDuplicates(int[] nums) {
        // Set<Integer> set = new LinkedHashSet<>();
        // for (Integer i : nums) {
        //     set.add(i);
        // }
        // int idx = 0;
        // for (Integer i : set) {
        //     nums[idx] = i;
        //     idx += 1; 
        // }
        // return set.size();
        // idea : when encouter unique value incr value.
        int count = 1;
        for (int i = 1 ; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count += 1;
            }
        }
        return count;
    }
}