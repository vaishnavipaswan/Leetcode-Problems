class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[]=version1.split("\\.");
        String v2[]=version2.split("\\.");
        int a=0;
        int b=0;
        int len =Math.max(v1.length,v2.length);
        for(int i=0;i<len;i++){
        if(v1.length>i) a=Integer.parseInt(v1[i]);
        else a=0;
        if(v2.length>i) b=Integer.parseInt(v2[i]);
        else b=0;
        if(a<b) return -1;
        if(a>b) return 1;
        }
        return 0;
    }
}