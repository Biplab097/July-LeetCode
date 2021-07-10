class Solution {
    public int numDecodings(String s) {
        
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0)=='0') return 0;
        dp[1] = (s.charAt(0)=='*')?9:1;
        
        for(int i=2;i<=s.length();i++){
            
            char f = s.charAt(i-2);
            char sec = s.charAt(i-1);
            
            //for dp[i-1]
            if(sec=='*'){
                dp[i]+=9*dp[i-1];
            }
            else if(sec>'0'){
                dp[i]+=dp[i-1];
            }
            
            //for dp[i-2]
            if(f=='*'){
                if(sec=='*'){
                    dp[i] += 15*dp[i-2];
                }
                else if(sec<='6'){
                    dp[i] += 2*dp[i-2];
                }
                else{
                    dp[i] += dp[i-2];
                }
            }
            else if(f=='1'||f=='2'){
                if(sec=='*'){
                    if(f=='1'){
                        dp[i] += 9*dp[i-2];
                    }
                    else{
                        dp[i] += 6*dp[i-2];
                    }
                }
                else if(((f-'0')*10+(sec-'0'))<=26){
                    dp[i] +=dp[i-2];
                }
            }
            dp[i] %=1000000007;
        }
        return (int)dp[s.length()];
    }
}
