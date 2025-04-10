public class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return calculate(Long.toString(finish),s,limit)-calculate(Long.toString(start-1),s,limit);
    }
    public long calculate(String x,String s,int limit){
        if(x.length()<s.length())return 0;
        if(x.length()==s.length()){
            int result;
            if (x.compareTo(s)>=0) {
                return result=1;
                } else {
                return result=0;
            }
        }
        String suf=x.substring(x.length()-s.length());
        long count=0;
        int pre=x.length()-s.length();
        for(int i=0;i<pre;i++){
            int digit=x.charAt(i)-'0';
            if(limit<digit){
                count+=(long) Math.pow(limit+1,pre-i);
                return count;
            }
            count+=(long)(digit)*(long)Math.pow(limit+1,pre-1-i);
        }
        if(suf.compareTo(s)>=0) count++;
        return count;
    }
}