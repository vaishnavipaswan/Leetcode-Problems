class Solution {
    public char kthCharacter(long k,int[] operations){
        int shift=0;
        List<Long> l=new ArrayList<>();
        long len=1;
        for(int op:operations){
            len*=2;
            l.add(len);
            if(len>=k) break;
        }
        for(int i=l.size()-1;i>=0;i--){
            long half=l.get(i)/2;
            int op=operations[i];
            if(k>half){
                k-=half;
                if(op==1) shift++;
            }
        }
        return (char)(((shift)%26)+'a');
    }
}