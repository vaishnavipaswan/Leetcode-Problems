class Solution {
    public int findMaxLength(int[] nums) {
        int sum=0;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)sum+=-1;
            else sum+=1;
            if(sum==0) count=i+1;
            else if(map.containsKey(sum)){
                count=Math.max(count,i-map.get(sum));
            }
            else map.put(sum,i);
        }
        return count;
    }
}