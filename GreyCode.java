// An n-bit gray code sequence is a sequence of 2n integers where:

// Every integer is in the inclusive range [0, 2n - 1],
// The first integer is 0,
// An integer appears no more than once in the sequence,
// The binary representation of every pair of adjacent integers differs by exactly one bit, and
// The binary representation of the first and last integers differs by exactly one bit.
// Given an integer n, return any valid n-bit gray code sequence.

// method- 1
class GreyCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
}
// Adding one to a number results in flipping all the bits from the rightmost zero bit to the end, e.g. 110011 + 1 = 110100

// In the general form, i = ...?01...1, i+1 = ...?10...0, ? represents the left bit of the rightmost zero bit, 
// the length of tailing one bits of i is the same as the length of tailing 0 bits of i+1, and the bits from the beginning to the ? are the same.
// Then i^(i>>1) = xxx(?^0)10...0, (i+1)^((i+1)>>1) = xxx(?^1)10...0. Since the bits from the beginning to the ? are the same, 
// xxx part of both results must be same, it's obvious the tailing parts of 10...0 must be same, and its length is the same as the length of tailing one bits of i, 
// so there is only one bit difference comes from (?^0) and (?^1).

// method - 2
// 1ms Java DP solution. Just reverse traverse n-1 answer and add 2^(n-1). E.g. If n = 1, list = {0,1}, then n = 2 will be{0,1, (1+2),(0+2)} which is {0,1,3,2},
// the size of list will be doubled as before.
class GreyCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);                                //n=0 {0}
        if(n == 0) return list;
        int increase = 1;
        for(int i = 0;i<n;i++){                     //              n=2
            int len = list.size();                  //              len = 2
            for(int j = len-1;j>=0;j--){            //              {0,1,3,2}
                list.add(list.get(j)+increase);     //n=1 {0,1}
            }
            increase *= 2;
        }
        return list;
    }
}


