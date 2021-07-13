class Solution {
    public int peak(int[] nums,int lo,int hi){
        int mid = lo + (hi-lo)/2;
        if((mid==0 || nums[mid-1]<=nums[mid]) && 
          (mid==nums.length-1 || nums[mid+1]<=nums[mid]))
            return mid;
        else if(mid>0 && nums[mid-1]>nums[mid])
            return peak(nums,lo,mid-1);
        else return peak(nums,mid+1,hi);
    }
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        return peak(nums,0,n-1);
    }
}
