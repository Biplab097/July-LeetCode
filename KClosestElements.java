class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Two pointer approach
        int lo = 0;
        int hi = arr.length-1;
        
        // This while facilates only k elements to be added in the result       
        while(hi-lo>=k){ // important condition
            if(Math.abs(arr[lo]-x)>Math.abs(arr[hi]-x)){  // main codition given in the question for an element to be closest.
                lo++;
            }
            else{
                hi--;          
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=lo;i<=hi;i++){
            res.add(arr[i]);
        }
        return res;
    }
}
