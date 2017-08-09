package hard;

import java.util.HashSet;
import java.util.Set;

/*
 * 题目描述
Given a string s and a dictionary of words dict, determine if s can be segmented into 
a space-separated sequence of one or more dictionary words.
For example, given
s ="leetcode",
dict =["leet", "code"].
Return true because"leetcode"can be segmented as"leet code".

 */
public class WordBreak {

	public static boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean dp[] = new boolean[len+1];
        dp[0]=true;
        for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				//从0~j可分割，词典包括j到i的串则dp[i]=true
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i]=true;
					break;
				}
			}
		}
        return dp[len];
    }
	public static void main(String[] args) {
		String s="leetcodejava";
		Set<String> set = new HashSet<String>() ;		
		set.add("let");
		set.add("code");
		set.add("lee");
		set.add("java");
		System.out.println(wordBreak(s, set));
	}

}
