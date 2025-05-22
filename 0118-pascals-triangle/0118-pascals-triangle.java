class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0) return new ArrayList<>();
        if(numRows==1){
            List<List<Integer>> res=new ArrayList<>();
            res.add(Arrays.asList(1));
            return res;
        } 
        List<List<Integer>>prev=generate(numRows-1);
        List<Integer>newRow=new ArrayList<>();
        for(int i=0;i<numRows;i++)newRow.add(1);
        for(int i=1;i<numRows-1;i++) newRow.set(i,prev.get(numRows-2).get(i-1)+prev.get(numRows-2).get(i));
        prev.add(newRow);
        return prev;
    } 
}