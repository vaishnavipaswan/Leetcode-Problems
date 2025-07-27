class Solution {
    public int countHillValley(int[] nums) {
        int count=0;
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]) list.add(nums[i]);
        }
        for(int i=1;i<list.size()-1;i++){
            if(list.get(i)>list.get(i-1) && list.get(i)>list.get(i+1)) count++;
            if(list.get(i)<list.get(i-1) && list.get(i)<list.get(i+1)) count++;
            else continue;
        }
        return count;
    }
}