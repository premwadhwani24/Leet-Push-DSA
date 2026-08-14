class Solution {
    public void rotate(int[] nums, int k) {
       int n=nums.length;
       k=k % n;
       rotate(nums,0,n-1);
       rotate(nums,0,k-1);
       rotate(nums,k,n-1);
    }
       public static void rotate(int []nums,int Start,int end){
       while(Start<end){
       int temp=nums[Start];
       nums[Start]=nums[end];
       nums[end]=temp;
       Start ++;
       end--;
       
    }
}
}
