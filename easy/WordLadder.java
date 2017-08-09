package easy;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/*
 * ��Ŀ����

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
	//�����������Ĳ�α��������м���
	public int ladderLength(String start, String end, HashSet<String> dict) {
        HashSet<String> finished = new HashSet<String>();//�洢�Ѿ��������Ľڵ�
        Queue<String> queue = new ArrayDeque<String>();//ʹ�ö��д洢ÿ��ڵ�
        queue.add(start);
        finished.add(start);
        int level = 0;
        boolean finishflag = false;
        boolean hasRoute = false;
        while (queue.size()!=0 && !finishflag) {
        	int levelSize = queue.size();//һ���ж��ٸ��ڵ�
        	hasRoute = false;
        	for (int ith = 0; ith < levelSize; ith++) {
        		String outString = queue.poll();
    			if (outString.equals(end)) {//�ߵ�Ŀ�굥��
    				hasRoute = true;
    				finishflag = true;
    				break;				
    			}
    			
    			for (int i = 0; i < outString.length(); i++) {//��ÿһλ�����滻
    				for (int j = 0; j < 26; j++) {//ʹ��26��Ӣ����ĸ�����滻
    					char[] arr = outString.toCharArray();
    					arr[i] =(char) ('a'+j);
    					String newString = new String(arr);
    					if ((dict.contains(newString)||newString.equals(end)) && !finished.contains(newString)) {//�ʵ�������δ���ʹ�
    						hasRoute = true;//���ò�һ���ڵ㶼û�����֤������ûͨ���յ��·��
    						queue.add(newString);
    						finished.add(newString);//��ֹ��������ټ���
    					}
    				}
    			}	
			}
        	level++;//������һ���1
		
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
   