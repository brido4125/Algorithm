class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int x = 0;
        int y = 0;

        for (int i = m ; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }

        Arrays.sort(nums1);
    }
}