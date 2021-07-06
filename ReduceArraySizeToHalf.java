public int minSetSize(int[] arr) {
        
        Map<Integer,Integer> map = new HashMap();
        ArrayList<Integer>[] list = new ArrayList[arr.length+1];
        
        for(int num :arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(int num:map.keySet()){
            int count = map.get(num);
            if(list[count]==null){
                list[count] = new ArrayList<Integer>();
            }
            list[count].add(num);
        }
        int res = 0, val=0;
        //System.out.println(map);
        for(int i=arr.length;i>0;i--){
            ArrayList<Integer> curr = list[i];
            if(curr==null || curr.size()==0) continue;
            for(int ele:curr){
                val+=i;
                res+=1;
                if(val>=arr.length/2) return res;
            }
            
        }
        return arr.length;
    }
// Count the numbers' frequency
// Create an array of lists, with the frequency being the key, the numbers with that frequency in the list.
// Count backwards, return once half size is reached.
// Time: O(N)
// Space: O(N)
