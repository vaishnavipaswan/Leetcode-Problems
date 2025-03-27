class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer,Integer> a=new HashMap<>();
        for(int n:nums){
            a.put(n,a.getOrDefault(n,0)+1);
        }
        int x=-1,f=0;
        for(int i:a.keySet()){
            if(a.get(i)>f){
                x=i;
                f=a.get(i);
            }
        }
        Map<Integer,Integer> b=new HashMap<>(); 
        for(int i=0;i<nums.size()-1;i++){
            b.put(nums.get(i),b.getOrDefault(nums.get(i),0)+1);
            a.put(nums.get(i),a.get(nums.get(i))-1);
            int left=b.getOrDefault(x,0);
            int right=a.getOrDefault(x,0);
            if(left*2>(i+1) && right*2>(nums.size()-i-1)){
                return i;
            }
        }
        return -1;
    }
}