class Solution {
    public int findIntegers(int n) {
        
        int[] f = new int[31];
        f[0] = 1;
        f[1] = 2;
        for(int i=2;i<31;i++){
            f[i] = f[i-1]+f[i-2];
        }
        int ans = 0, k = 30,pre_bit=0;
        
        while(k>=0){
            if((n&(1<<k))!=0){
                ans += f[k];
                if(pre_bit==1) return ans;
                pre_bit = 1;
            }
            else pre_bit = 0;
            k--;
        }
        return ans+1;
        
    }
}
