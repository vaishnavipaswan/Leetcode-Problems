class Solution {
    public long minimumDifference(int[] nums) {
        int n=nums.length/3;
        long left[]=new long[n+1];
        long right[]=new long[n+1];
        PriorityQueue<Integer> max=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> min=new PriorityQueue<>();
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            max.add(nums[i]);
        }
        left[0]=sum;
        for(int i=n;i<2*n;i++){
            max.add(nums[i]);
            sum+=nums[i]-max.poll();
            left[i-n+1]=sum;
        }
        sum=0;
        for(int i=nums.length-1;i>=2*n;i--){
            sum+=nums[i];
            min.add(nums[i]);
        }
        right[n]=sum;
        for(int i=2*n-1;i>=n;i--){
            min.add(nums[i]);
            sum+=nums[i]-min.poll();
            right[i-n]=sum;
        }
        long res=Long.MAX_VALUE;
        for(int i=0;i<=n;i++){
            res=Math.min(res,left[i]-right[i]);
        }
        return res;
    }
}