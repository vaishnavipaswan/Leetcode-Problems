class Solution {
    public void reverseString(char[] s) {
        int slow=0,fast=s.length-1;
        while(slow<fast){
                char temp=s[fast];
                s[fast]=s[slow];
                s[slow]=temp;
                slow++;
                fast--;
        }
        System.out.println(s);
    }
}