class Solution {
    public String decodeString(String s) {
       // Stack to store the repeat counts for nested patterns
        Deque<Integer> countStack = new ArrayDeque<>();
        // Stack to store the accumulated strings before entering a bracket
        Deque<String> stringStack = new ArrayDeque<>();
      
        int currentCount = 0;
        String currentString = "";
      
        // Process each character in the input string
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the number (handle multi-digit numbers)
                currentCount = currentCount * 10 + (ch - '0');
            } else if (ch == '[') {
                // Opening bracket: push current state to stacks and reset
                countStack.push(currentCount);
                stringStack.push(currentString);
                currentCount = 0;
                currentString = "";
            } else if (ch == ']') {
                // Closing bracket: pop from stacks and construct repeated string
                int repeatTimes = countStack.pop();
                StringBuilder repeatedString = new StringBuilder();
              
                // Repeat the current string based on the count
                for (int i = 0; i < repeatTimes; i++) {
                    repeatedString.append(currentString);
                }
              
                // Combine with the previous string from the stack
                currentString = stringStack.pop() + repeatedString.toString();
            } else {
                // Regular character: append to current string
                currentString += ch;
            }
        }
      
        return currentString;
    }
}