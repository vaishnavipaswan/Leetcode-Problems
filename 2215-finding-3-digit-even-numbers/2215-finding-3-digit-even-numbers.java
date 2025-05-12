class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> numbers=new HashSet<>();
        int n=digits.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(i==j || i==k || j==k){
                        continue;
                    }
                    int num=digits[i]*100+digits[j]*10+digits[k];
                    if(num%2==0 && digits[i]!=0){
                        numbers.add(num);
                    }
                }
            }
        }
        ArrayList<Integer> l=new ArrayList<>(numbers);
        Collections.sort(l);
        int res[]=new int[l.size()];
        for(int i=0;i<res.length;i++){
            res[i]=l.get(i);
        }
        return res;
    }
}