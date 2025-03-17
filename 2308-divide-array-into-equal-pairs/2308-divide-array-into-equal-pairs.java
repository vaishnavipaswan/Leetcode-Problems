class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> res=new HashMap<>();
        for(int n: nums){
            res.put(n,res.getOrDefault(n,0)+1);
        }
        for(int i: res.values()){
            if(i%2==1) return false;
        }
        return true;
    }
}