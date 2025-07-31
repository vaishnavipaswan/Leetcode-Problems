class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n=arr.length;
        if(n==1) return 1;
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> prev=new HashSet<>();
        for(int i:arr){
            HashSet<Integer> curr=new HashSet<>();
            curr.add(i);
            for(int j:prev){
                curr.add(j|i);
            }
                set.addAll(curr);
                prev=curr;
        }
        return set.size();
    }
}