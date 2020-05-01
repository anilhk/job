package com.problems.leetcode.dp;

/**
 * 
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * Input: "12" Output: 2
 * 
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * Input: "226" Output: 3
 * 
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 *
 */
public class DecodeWays_91 {

	public int numDecodings(String s) {
	      
        int[] dp = new int[s.length()+1];
        
        // dp is an array which will tell us how many ways a string of length i can be decoded.
        
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 :1;
        
        //226
        for(int i=2;i<=s.length();i++) {
            
            //i-1 to i .. u will be able to read 2
            Integer oneDigit = Integer.valueOf(s.substring(i-1,i)); 
            //i-2 to i .. u will be able to read 22.
            Integer twoDigit = Integer.valueOf(s.substring(i-2,i));
            
            //dp[i] is initially 0 .. 
            //new array we created so if the digit is 1 digit the number of ways it can be decoded is dp[1] which is 1.
            if (oneDigit>=1){
                dp[i]=dp[i]+dp[i-1];
            }
            
            if (twoDigit>=10 && twoDigit<=26) {
                dp[i]=dp[i]+dp[i-2];
            }
        }
        
        return dp[s.length()];
}
}
