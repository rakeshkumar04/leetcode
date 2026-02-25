class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        String num = Integer.toString(x);
        String rev = new String();

        for(int i=num.length()-1; i>=0 ; i--){
            char c = num.charAt(i);
            rev = rev + c;
        }

        if(rev.equals(num)) return true;
        return false;
    }
}