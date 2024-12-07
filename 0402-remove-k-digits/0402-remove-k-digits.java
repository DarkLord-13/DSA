class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // Remove remaining digits if k > 0
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        // Construct the result from the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        // Remove leading zeros
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        // If the result is empty, return "0"
        return result.length() == 0 ? "0" : result.toString();
    }
}
