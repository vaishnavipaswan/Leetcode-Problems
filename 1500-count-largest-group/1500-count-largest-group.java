class Solution {
    public int countLargestGroup(int n) {
        int pairs[]=new int[37];
        for(int i=1;i<=n;i++) pairs[sum(i)]++;
        int count=0;
        int max=0;
        for(int i:pairs){
            if(i>max){
                max=i;
                count=1;
                }
            else if(i==max) ++count;
        }
        return count;
    }
    public int sum(int i){
        int sum=0;
        while(i!=0){
            sum+=i%10;
            i/=10;
        }
        return sum;
    }
}