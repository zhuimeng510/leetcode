package hard;

import sun.tools.jar.resources.jar;

/*
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class 两个排序数组中值 {
	/*//方法一：空间复杂度o(m+n),时间复杂度o(m+n)
	public double findMedianSortedArrays(int A[], int B[]) {
		if (A==null && B==null) return -1;
		if (A==null || A.length==0) {
			if (B.length==1) {
				return B[0];
			}
			if (B.length%2==1) {
				return B[B.length/2];
			}
	        return (B[B.length/2]+B[(B.length-1)/2]+0.0)/2;
		}
		if (B==null  || B.length==0) {
			if (A.length==1) {
				return A[0];
			}
			if (A.length%2==1) {
				return A[A.length/2];
			}
	        return (A[A.length/2]+A[(A.length-1)/2]+0.0)/2;
		}
        int[] C = new int[A.length+B.length];
        int i = 0;
        int j = 0;
        int p = 0;
        while (i<A.length && j<B.length) {
			if (A[i]<=B[j]) {
				C[p++] = A[i++];
			}else {
				C[p++] = B[j++];
			}			
		}
        while (i<A.length) {			
				C[p++] = A[i++];			
		}
        while (j<B.length) {			
			C[p++] = B[j++];			
        }
        if (C.length%2==1) {
			return C[C.length/2];
		}
        return (C[C.length/2]+C[(C.length-1)/2]+0.0)/2;
    }*/
	//两个排序数组找第k大数,假定A,B不全为空
	public int findKth(int[] A,int[] B,int k){
		if (A==null || A.length==0) {
			return B[k-1];
		}
		if (B==null || B.length==0) {
			return A[k-1];
		}
		//保证A是短的数组，复杂度为o(log(min{m,n}))
		if (A.length>B.length) {
			return findKth(B, A, k);
		}
		int m = A.length;
		int n = B.length;
		int left = 0,right = m;
		while (left<right) {
			int mid = left+(right-left)/2;//找中间元素
			int j = k-1-mid;//对应B中的元素
			if (j>=n || A[mid]<B[j]) {//i太小了
				left = mid+1;
			}else {
				right = mid;
			}
		}
		int aVal = left>0?A[left-1]:Integer.MIN_VALUE;
		int bVal = k-1-left>=0?B[k-1-left]:Integer.MIN_VALUE;
		return aVal>bVal?aVal:bVal;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] A = {1,2,3,4};
		int[] B = {2,3,5};*/
		int[] A = {1,5,6,9,11};
		int[] B = {1,4,5,7};
		//System.out.println(new 两个排序数组中值().findMedianSortedArrays(A, B));
		System.out.println(new 两个排序数组中值().findKth(A,B,6));
	}

}
