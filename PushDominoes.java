class Solution {
    public String pushDominoes(String dominos) {
        
        char[] dom = dominos.toCharArray();
        int n = dominos.length();
        
        int[] forces = new int[n];
        
        StringBuilder sb = new StringBuilder();
        
        int force = 0;
        
        for(int i=0;i<n;i++){
            if(dom[i]=='R'){
                force = n;
            }
            else if(dom[i]=='L'){
                force = 0;
            }
            else{
                force = Math.max(force-1,0);
            }
            forces[i]+=force;
        }
        
        for(int i=n-1;i>=0;i--){
            if(dom[i]=='L'){
                force = n;
            }
            else if(dom[i]=='R'){
                force = 0;
            }
            else{
                force = Math.max(force-1,0);
            }
            forces[i]-=force;
        }
        for(int f :forces){
            if(f>0){
                sb.append('R');
            }
            else if(f<0){
                sb.append('L');
            }
            else{
                sb.append('.');
            }
        }
        return sb.toString();
        
    }
}
