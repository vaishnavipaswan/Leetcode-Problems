class Solution {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD=1000000007;
        List<Integer>powers=new ArrayList<>();
        while(n>0){
            int low=n & -n;
            powers.add(low);
            n^=low;
        }
        int len=powers.size();
        int table[][]=new int[len][len];
        for(int i=0;i<len;i++){
            table[i][i]=powers.get(i);
            for(int j=i+1;j<len;j++){
                table[i][j]=(int)((long)table[i][j-1]*powers.get(j)%MOD);
            }
        }
        int res[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
        int p=queries[i][0];
        int q=queries[i][1];
        res[i]=table[p][q];
        }
        return res;
    }

}