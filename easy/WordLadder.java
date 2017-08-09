package easy;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/*
 * 题目描述

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,
Given:
start ="hit"
end ="cog"
dict =["hot","dot","dog","lot","log"]
As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length5.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
	//以类似于树的层次遍历来进行计算
	public int ladderLength(String start, String end, HashSet<String> dict) {
        HashSet<String> finished = new HashSet<String>();//存储已经遍历过的节点
        Queue<String> queue = new ArrayDeque<String>();//使用队列存储每层节点
        queue.add(start);
        finished.add(start);
        int level = 0;
        boolean finishflag = false;
        boolean hasRoute = false;
        while (queue.size()!=0 && !finishflag) {
        	int levelSize = queue.size();//一层有多少个节点
        	hasRoute = false;
        	for (int ith = 0; ith < levelSize; ith++) {
        		String outString = queue.poll();
    			if (outString.equals(end)) {//走到目标单词
    				hasRoute = true;
    				finishflag = true;
    				break;				
    			}
    			
    			for (int i = 0; i < outString.length(); i++) {//对每一位进行替换
    				for (int j = 0; j < 26; j++) {//使用26个英文字母进行替换
    					char[] arr = outString.toCharArray();
    					arr[i] =(char) ('a'+j);
    					String newString = new String(arr);
    					if ((dict.contains(newString)||newString.equals(end)) && !finished.contains(newString)) {//词典中有且未访问过
    						hasRoute = true;//若该层一个节点都没添加则证明后面没通向终点的路了
    						queue.add(newString);
    						finished.add(newString);//防止在下面层再加入
    					}
    				}
    			}	
			}
        	level++;//遍历完一层加1
		
		}
        level = hasRoute?level:0;
        return level;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		int level = new WordLadder().ladderLength("hit", "cog", dict);
		System.out.println(level);
		//System.out.println(""+dict);
	}

}
   