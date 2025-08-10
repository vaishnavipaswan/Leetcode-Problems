import java.util.*;
class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n==1) return true;
        int res[]=freq(n);
        for(int i=0;i<=30;i++){
            int power=(int)Math.pow(2,i);
            if(equalfreq(res,freq(power))) return true;
        }
        return false;
    }
    public int[] freq(int n){
        int f[]=new int[10];
        while(n>0){
            int rem=n%10;
           f[rem]++;
            n/=10;
        }
        return f;
    }
    public boolean equalfreq(int a[],int b[]){
        for(int i=0;i<10;i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}