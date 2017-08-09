package easy;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * 题目描述

Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
Return all such possible sentences.
For example, given
s ="catsanddog",
dict =["cat", "cats", "and", "sand", "dog"].
A solution is["cats and dog", "cat sand dog"].
 */
public class Wordbreakii {
	
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> arrayList = new ArrayList<String>();
		if (s==null || s.length()==0) {//为空时证明已经找到最前面了
			arrayList.add("");//添加个长度为0的串，以使长度不为0，区分不可分割情况
		}
		for (int i = s.length()-1; i >= 0; i--) {
			if (dict.contains(s.substring(i))) {//右边有单词在词典中				
				ArrayList<String> left = wordBreak(s.substring(0,i),dict);
				if (left.size()!=0) {//左边可分割
					for (String string : left) {
						StringBuilder sbBuilder = new StringBuilder();						
						sbBuilder.append(string);
						sbBuilder.append(" ");
						sbBuilder.append(s.substring(i));
						arrayList.add(sbBuilder.toString().trim());
					}
				}
			}
		}
		return arrayList;
	        
	}
	public static void main(String[] args) {
		String s ="catsanddog";
		Set<String> dict =new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(new Wordbreakii().wordBreak(s, dict));
	}

}
