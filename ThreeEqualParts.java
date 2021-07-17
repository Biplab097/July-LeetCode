class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int[] res = new int[]{-1,-1};
        
        int ones = 0;
        for(int ele:arr){
            ones+=ele;
        }
        if(ones==0){
            return new int[]{0,2};
        }
        if(ones%3!=0){
            return res;
        }
        
        int onesInEachPart = ones/3;
        int part1Idx = -1;
        int part2Idx = -1;
        int part3Idx = -1;
        ones = 0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                ones++;
                if(ones==1){
                    part1Idx = i;
                }
                else if(ones == onesInEachPart+1){
                    part2Idx = i;
                }
                else if(ones == 2*onesInEachPart+1){
                    part3Idx = i;
                }
            }
        }
        while(part3Idx<arr.length){
            if(arr[part1Idx]==arr[part2Idx] && arr[part3Idx]==arr[part1Idx]){
                part1Idx++;
                part2Idx++;
                part3Idx++;
            }
            else{
                return res;
            }
        }
        return new int[]{part1Idx-1,part2Idx};
        
    }
}
