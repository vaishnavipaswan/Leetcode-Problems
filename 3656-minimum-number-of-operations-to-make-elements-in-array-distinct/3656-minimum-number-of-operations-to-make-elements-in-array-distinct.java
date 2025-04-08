class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i+=3,count++){
            if(unique(nums,i)) return count;
        }
        return count;
    }
    boolean unique(int [] nums,int i){
        Set<Integer>m=new HashSet<>();
        for(int j=i;j<nums.length;j++){
            if(m.contains(nums[j])){
                return false;
            }
            m.add(nums[j]);
        }
        return true;
    }
}