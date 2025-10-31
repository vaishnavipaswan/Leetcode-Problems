class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int res[]=new int[2];
        int j=0;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue()==2){
                res[j]=e.getKey();
                j++;
            }
        }
        return res;
    }
}