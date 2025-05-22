class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer>avl=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer>assign=new PriorityQueue<>();
        int count=0;
        for(int i=0,k=0;i<nums.length;i++){
            while(!assign.isEmpty() && assign.peek()<i) assign.poll();
            while(k<queries.length && queries[k][0]<=i) avl.add(queries[k++][1]);
            while(assign.size()<nums[i] && !avl.isEmpty() && avl.peek()>=i){
                assign.add(avl.poll());
                count++;
            }
            if(assign.size()<nums[i]) return -1;
        }
        return queries.length-count;
    }
}