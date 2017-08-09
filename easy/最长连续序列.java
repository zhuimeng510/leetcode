package easy;

import java.util.Arrays;
import java.util.HashSet;

/*
 * ��Ŀ����

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given[100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
Your algorithm should run in O(n) complexity.
 */
public class ��������� {
	//����һ�����Ӷ�o(nlogn)	
	/*public int longestConsecutive(int[] num) {
		if (num==null || num.length==0) {
			return 0;
		}
        Arrays.sort(num);
        int maxLength = 1;
        int count = 1;
        for (int i = 1; i < num.length; i++) {
			if (num[i]==num[i-1]+1) {
				count++;
			}else if (num[i]==num[i-1]) {
				continue;
			}else{				
				count = 1;
			}
			maxLength = count>maxLength?count:maxLength;
		}
        return maxLength;
    }*/
	//��������ʹ��HashSet�����Ӷ���Ҫ���ڱ���������Ԫ��
	public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        //����Ԫ�أ�ͬʱ����ȥ��,o(n)
        for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}
        //��ÿһ��Ԫ���������ߣ������Ķ�ȥ����������������һ�������Ԫ�ؾͶ�ɾ���ˣ����Ӷ�o(n)
        int maxLength = 1;
        for (int i = 0; i < num.length; i++) {
        	int count = 1;
			if (!set.isEmpty() && set.remove(num[i])) {//������Ƴ���Ԫ�أ�֤����������set��
				int down = num[i]-1;
				int up = num[i]+1;
				while (set.remove(down)) {
					count++;
					down--;
				}
				while (set.remove(up)) {
					count++;		
					up++;
				}
				maxLength = count>maxLength?count:maxLength;
			}
		}
        return maxLength;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] num = {1,0,1,2};
		int[] num = {100, 4, 200, 1, 3, 2};
		System.out.println(new ���������().longestConsecutive(num));
	}

}
