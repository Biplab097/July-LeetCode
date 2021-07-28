class Solution {
    public int[] beautifulArray(int n) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        
        while(arr.size()<n){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int ele:arr){
                if(2*ele-1<=n)
                    temp.add(2*ele-1);
            }
            for(int ele:arr){
                if(2*ele<=n)
                        temp.add(2*ele);
            }
            arr = temp;
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = arr.get(i);
        }
        
        return res;
        
    }
}
