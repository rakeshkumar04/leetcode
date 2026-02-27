class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) return "";

        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startInd = 0;

        while (right < m) {
            char rChar = s.charAt(right);

            if (map.containsKey(rChar)) {
                map.put(rChar, map.get(rChar) - 1);
                if (map.get(rChar) >= 0) {
                    count++;
                }
            }

            while (count == n) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startInd = left;
                }

                char lChar = s.charAt(left);

                if (map.containsKey(lChar)) {
                    map.put(lChar, map.get(lChar) + 1);
                    if (map.get(lChar) > 0) {
                        count--;
                    }
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE 
            ? "" 
            : s.substring(startInd, startInd + minLen);
    }
}