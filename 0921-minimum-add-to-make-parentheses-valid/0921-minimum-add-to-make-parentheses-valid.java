class Solution {
    public int minAddToMakeValid(String s) {
        int openingBrackets = 0, closingBrackets = 0;

        for (char bracket: s.toCharArray()) {
            if (bracket == '(') {
                openingBrackets++;
            } else if (bracket == ')') {
                if (openingBrackets > 0) {
                    openingBrackets--;
                } else {
                    closingBrackets++;
                }
            }
        }

        return Math.abs(openingBrackets + closingBrackets);
    }
}