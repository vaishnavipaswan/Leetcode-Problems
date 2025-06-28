class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> min=new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        int res[]=new int[k];
        for(int i=0;i<nums.length;i++){
            min.offer(new int[]{nums[i],i});
        if(min.size()>k) min.poll();
        }
        int topK[][]=min.toArray(new int[0][0]);
        Arrays.sort(topK,Comparator.comparingInt(a->a[1]));
        for(int i=0;i<k;i++) res[i]=topK[i][0];
        return res;
    }
}