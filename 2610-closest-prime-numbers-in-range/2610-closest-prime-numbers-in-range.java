class Solution {
    public int[] closestPrimes(int left, int right) {
        int sieve[]=new int[right+1];
        Arrays.fill(sieve,1);
        sieve[0]=0;
        sieve[1]=0;
        for(int i=2;i*i<=right;i++){
            if(sieve[i]==1){
                for(int multiple=i*i;multiple<=right;multiple+=i){
                    sieve[multiple]=0;
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int k=left;k<=right;k++){
            if(sieve[k]==1){
                res.add(k);
            }
        }
        if(res.size()<2){
            return new int []{-1,-1};
        }
        int mindiff=Integer.MAX_VALUE;
        int cp[]=new int[2];
        for(int j=1;j<res.size();j++){
            if(res.get(j)-res.get(j-1)<mindiff){
                mindiff=res.get(j)-res.get(j-1);
                cp=new int []{res.get(j-1),res.get(j)};
            }
        }
        return cp;

    }
}