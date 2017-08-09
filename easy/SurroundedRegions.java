package easy;

import java.util.Scanner;

/*
 * ��Ŀ����

Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
A region is captured by flipping all'O's into'X's in that surrounded region .
For example,
X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
 */
public class SurroundedRegions {
	public void visit(int row,int col,char[][] board,boolean[][] flags,boolean[][] visited){
		if (board[row][col]=='O' && visited[row][col]==false) {//���Խ�������
			visited[row][col] = true;//���ʹ�֮���ñ�־
			flags[row][col] = true;//��߽�������־
			//���
			if (col-1>=0) {
				visit(row,col-1,board,flags,visited);
			}
			//�ϱ�
			if (row-1>=0) {
				visit(row-1,col,board,flags,visited);
			}
			//�ұ�
			if (col+1<=board[0].length-1) {
				visit(row,col+1,board,flags,visited);
			}
			//�±�
			if (row+1<=board.length-1) {
				visit(row+1,col,board,flags,visited);
			}
		}
	}
	
	public void solve(char[][] board) {
		if (board==null || board.length==0) {
			return;
		}
		int rows = board.length;
		int cols = board[0].length;
        boolean[][] flags = new boolean[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        //��������,��һ�������һ��
        for (int i = 0; i < cols; i++) {
			visit(0,i,board,flags,visited);
			visit(rows-1,i,board,flags,visited);
		}
      //��������,��һ�������һ��
        for (int i = 0; i < rows; i++) {
			visit(i,0,board,flags,visited);
			visit(i,cols-1,board,flags,visited);
		}
        for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (flags[i][j]) {
					board[i][j]='O';
				}else {
					board[i][j]='X';
				}
				
			}
		}
    }
	public static void main(String[] args) {
		char[][] board ={{'X','X','X','X','X','X','X','X'},
				{'O','O','X','X','O','O','O','X'},
				{'O','X','X','X','O','X','O','X'},
				{'O','O','O','X','O','O','O','X'},
				{'X','X','X','X','X','X','X','X'}};
		/*char[][] board ={{'X','O','X','O','X','O'},
				{'O','X','O','X','O','X'},
				{'X','O','X','O','X','O'},
				{'O','X','O','X','O','X'}};*/
		new SurroundedRegions().solve(board);
		int rows = board.length;
		int cols = board[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

}
