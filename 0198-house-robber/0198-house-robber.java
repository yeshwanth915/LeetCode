class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int inc=nums[0];
        int exc=0;

        for(int i=1;i<n;i++){
            int cinc=nums[i]+exc;
            int cexc=Math.max(inc,exc);
            inc=cinc;
            exc=cexc;
        }
        return Math.max(inc,exc);
    }
}