package easy;
/*
 * ��Ŀ����

Given an array of integers, every element appears three times except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {

	public static int singleNumber(int[] A) {
		/*//д��һ��
	     int one=0,two=0;//Ϊ1��λ�ֱ��ʾ��Ӧλ������1�Σ�2��
	     int three=0;//������3��0
	     for (int i = 0; i < A.length; i++) {
			int cur = A[i];//�����ֵ����
			three = two & cur;//�������ε�λ
			two &= ~three; //�������ε�λ��0
			cur &= ~three; //�������ε�λ�÷�ֹ��Ϊ����һ��(one�ֲ�����û���ֹ����ǳ�����2��)
			two |= one & cur;//���³������ε�
			one ^=cur;//���³���һ�ε�
		 }
	     return one;*/
		//д������
		/*
		 * Single Number�ı��ʣ�������һ������¼ÿ��bit���ֵĴ��������һ��bit�������ξ͹�0��
		 * ����������ö����Ƶ��µ�λ����^�Ǻ���Ȼ�ġ�Single Number II�У�����ܶ��������Ƶ��µ�ĳ��λ������
		 * Ҳ���Դﵽ��ͬ��Ч����Single Number II����Ҫ��¼ÿ��bit���ֵĴ�����һ�����㲻���ͼ���������
		 * ��ones����¼ֻ���ֹ�һ�ε�bits����twos����¼ֻ���ֹ����ε�bits��ones&twosʵ���Ͼͼ�¼�˳��ֹ����ε�bits��
		 * ��ʱ��������ģ����г���3�ξ͵���Ϊ0�Ĳ�����Ĩȥones��twos�ж�Ϊ1��bits��
		 */
		int one=0,two=0;//Ϊ1��λ�ֱ��ʾ��Ӧλ������1�Σ�2��
	    int three=0;//������3��0
	    for (int i = 0; i < A.length; i++) {
			int cur = A[i];//�����ֵ����
			two |= one & cur;//(1)ԭ��������һ�Σ������ֳ���һ��(2)ԭ����������
			one ^= cur;//ԭ��û�г��ֹ������ǳ��ֹ����Σ�cur�б��γ���һ��[�����ζ���Ϊ0]
			three = two & one;//���ֹ�������
			two &= ~three;
			one &= ~three;//��ճ������ε�λ
	    }
	    return one;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,5,2,3,5,5,3};
		System.out.println(singleNumber(A));
	}

}
