class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> min=new PriorityQueue<>();
        for(int n: nums) min.add(n);
        for(int i: nums){
            if(min.size()>k) min.poll();
        }
        return min.peek();
    }
}