class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // Count characters in s1
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            // Add right character
            windowCount[s2.charAt(right) - 'a']++;

            // Shrink if window is too large
            if (right - left + 1 > s1.length()) {
                windowCount[s2.charAt(left) - 'a']--;
                left++;
            }

            // Compare only when window has correct size
            if (right - left + 1 == s1.length()) {
                if (java.util.Arrays.equals(s1Count, windowCount)) {
                    return true;
                }
            }
        }

        return false;
    }
}