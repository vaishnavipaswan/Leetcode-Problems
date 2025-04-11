class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res=0;
        for(int i=low;i<=high;i++){
            String str=Integer.toString(i);
            if(str.length()%2!=0)continue;
            int mid=str.length()/2;
            int left=0,right=0;
            for(int n=0;n<mid;n++) left+=str.charAt(n)-'0';
            for(int n=mid;n<str.length();n++) right+=str.charAt(n)-'0';
            if(left==right) res++;
        }
        return res;
    }
}