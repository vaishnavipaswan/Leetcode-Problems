class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double>list=new ArrayList<>();
        for(int c:cards) list.add((double)c);
        return calculate(list);
    }
    public boolean calculate(List<Double>list){
        if(list.size()==1){
            return Math.abs(list.get(0)-24.0)<1e-6;
        }
        int n=list.size();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                List<Double> next=new ArrayList<>();
                for(int k=0;k<n;k++){
                    if(k!=i && k!=j) next.add(list.get(k));
                }
                double a=list.get(i);
                double b=list.get(j);
                List<Double>res=new ArrayList<>();
                res.add(a+b);
                res.add(a*b);
                res.add(a-b);
                res.add(b-a);
                if(Math.abs(b)>1e-6) res.add(a/b);
                if(Math.abs(a)>1e-6) res.add(b/a);
                for(double r:res){
                    next.add(r);
                    if(calculate(next)) return true;
                    next.remove(next.size()-1);
                }
            }
        }
        return false;
    }
}