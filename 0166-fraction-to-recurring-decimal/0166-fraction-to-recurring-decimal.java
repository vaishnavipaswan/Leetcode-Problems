class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuilder fraction=new StringBuilder();
        if(numerator<0 ^ denominator<0) fraction.append("-");
        long dividend=Math.abs(Long.valueOf(numerator));
        long divisor=Math.abs(Long.valueOf(denominator));
        fraction.append(dividend/divisor);
        long rem=dividend%divisor;
        if(rem==0) return fraction.toString();
        fraction.append(".");
        Map<Long,Integer> map=new HashMap<>();
        while(rem!=0){
            if(map.containsKey(rem)){
                fraction.insert(map.get(rem),"(");
                fraction.append(")");
                break;
            }
            map.put(rem,fraction.length());
            rem*=10;
            fraction.append(rem/divisor);
            rem%=divisor;
        }
        return fraction.toString();
    }
}