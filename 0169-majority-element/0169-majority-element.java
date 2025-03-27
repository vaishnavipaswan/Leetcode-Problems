class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> a=new HashMap<>();
        for(int n: nums){
            a.put(n,a.getOrDefault(n,0)+1);
        }
        int max=0;
        int ele=nums[0];
        for(int i: a.keySet()){
            if(a.get(i)>max){
                max=a.get(i);
                ele=i;
            }
        }
        return ele;
    }
}