class Solution {
    int[] counts;
    int[] index;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts = new int[n];
        index = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeSort(nums, 0, n - 1);
        List<Integer> result = new ArrayList<>();
        for (int count : counts) {
            result.add(count);
        }
        return result;
    }
    void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int[] tempIndex = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int smaller = 0;
        while (i <= mid && j <= right) {
            if (nums[j] < nums[i]) {
                temp[k] = nums[j];
                tempIndex[k] = index[j];
                smaller++;
                j++;
            } else {
                counts[index[i]] += smaller;
                temp[k] = nums[i];
                tempIndex[k] = index[i];
                i++;
            }
            k++;
        }
        while (i <= mid) {
            counts[index[i]] += smaller;
            temp[k] = nums[i];
            tempIndex[k] = index[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = nums[j];
            tempIndex[k] = index[j];
            j++;
            k++;
        }
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
            index[left + p] = tempIndex[p];
        }
    }
}