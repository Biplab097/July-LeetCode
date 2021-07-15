class Solution {
    public int triangleNumber(int[] nums) {
        
        int count = 0;
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for(int i=n-1;i>=0;i--){
            int right = i-1;
            int left = 0;
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum>nums[i]){
                    count += right-left;
                    right--;
                }
                else left++;
                
            }
        }
        return count;
        
    }
}
