class Solution{
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(String a, String b) {
        int i = 0, j = a.length() - 1;
        // match a's left with b's right as far as possible
        while (i < j && a.charAt(i) == b.charAt(j)) {
            i++; j--;
        }
        // if we've crossed or met, it's already ok
        if (i >= j) return true;

        // otherwise the remaining middle of either a or b must be a palindrome
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

}