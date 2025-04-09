class Solution {
    public int minOperations(int[] nums, int k) {
        boolean allK=true;
        for(int n: nums){
            if(n!=k){
                allK=false;
                break;
            }
        }
        if(allK) return 0;
        Set<Integer> s=new HashSet<>();
        for(int i: nums){
            if(i>k){
            s.add(i);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int n: nums){
            if(n<min){
                min=n;
            }
        }
        if(!s.isEmpty() && min>=k) return s.size();
        return -1;
    }
}