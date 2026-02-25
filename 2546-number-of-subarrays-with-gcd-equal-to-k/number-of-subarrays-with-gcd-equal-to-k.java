class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        
        for(int i=0; i<n; i++){
            int currGCD = 0;
            for(int j=i; j<n; j++){
                currGCD = gcd(currGCD, nums[j]);
                if(currGCD == k) count++;
                if(currGCD < k) break;
                
            }
        }
        return count;
    }

    public int gcd(int a, int b){

        if(a==0) return b;

        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}