package easy;
/*
 * 题目描述
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
click to show spoilers.
Have you thought about this?
Here are some good questions to ask before coding. 
Bonus points for you if you have already thought through this!
If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, 
then the reverse of 1000000003 overflows. How should you handle such cases?
Throw an exception? Good, but what if throwing an exception is not an option? 
You would then have to re-design the function (ie, add an extra parameter).
 */
public class 反转整数 {
	public int stringToInt(char[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			res = res*10+arr[i]-'0';
		}
		return res;
	}
	public int reverse(int x) {
        if (x<0) {
			String string = Integer.toString(-x);
			char[] arr = string.toCharArray();
			for (int i = 0; i < arr.length/2; i++) {
				char tmp = arr[i];
				arr[i] = arr[arr.length-1-i];
				arr[arr.length-1-i] = tmp;
			}			
			return -stringToInt(arr);
		}else {
			String string = Integer.toString(x);
			char[] arr = string.toCharArray();
			for (int i = 0; i < arr.length/2; i++) {
				char tmp = arr[i];
				arr[i] = arr[arr.length-1-i];
				arr[arr.length-1-i] = tmp;
			}			
			return stringToInt(arr);
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new 反转整数().reverse(-100));
	}

}
