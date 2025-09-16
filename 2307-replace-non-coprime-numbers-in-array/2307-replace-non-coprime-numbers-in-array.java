class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty()){
                int tos=st.get(st.size()-1);
                int gcd=gcd(nums[i],tos);
                if(gcd==1){
                    break;
                }
                st.remove(st.size()-1);
                nums[i]=(tos/gcd)*nums[i];
            }
            st.add(nums[i]);
        }
        return st;
    }
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}