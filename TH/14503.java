import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //init
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        robot A = new robot(sc.nextInt(),sc.nextInt(),sc.nextInt());
        int[][] board = new int[M][N];

        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                board[j][i] = sc.nextInt();
            }
        }
        board[A.x][A.y] = 2;
        int flag = 0;
        move(A,board,flag);
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j <N ; j++) {
                if(board[i][j]==2)
                    count++;
            }
        }
        System.out.print(count);

    }
    public static void move(robot A,int[][] board, int flag){
        switch(A.d)
        {

            case 0:
                if(board[A.x-1][A.y]==0){
                    A.x--;
                    A.d = 3;
                    board[A.x][A.y] = 2;
                    flag = 0;
                    move(A,board,flag);
                }
                else if(flag == 4)
                {
                    if(board[A.x][A.y+1]==1)
                        break;
                    A.y++;
                    flag = 0;
                    move(A,board,flag);
                }
                else{
                    A.d = 3;
                    flag++;
                    move(A,board,flag);
                }
                break;
            case 1:
                if(board[A.x][A.y-1]==0){
                    A.y--;
                    A.d = 0;
                    board[A.x][A.y] = 2;
                    flag = 0;
                    move(A,board,flag);
                }
                else if(flag == 4)
                {
                    if(board[A.x-1][A.y]==1)
                        break;
                    A.x--;
                    flag = 0;
                    move(A,board,flag);
                }
                else{
                    A.d = 0;
                    flag++;
                    move(A,board,flag);
                }
                break;
            case 2:
                if(board[A.x+1][A.y]==0){
                    A.x++;
                    A.d = 1;
                    board[A.x][A.y] = 2;
                    flag = 0;
                    move(A,board,flag);
                }
                else if(flag == 4)
                {
                    if(board[A.x][A.y-1]==1)
                        break;
                    A.y--;
                    flag = 0;
                    move(A,board,flag);
                }
                else{
                    A.d = 1;
                    flag++;
                    move(A,board,flag);
                }
                break;
            case 3:
                if(board[A.x][A.y+1]==0){
                    A.y++;
                    A.d = 2;
                    board[A.x][A.y] = 2;
                    flag = 0;
                    move(A,board,flag);
                }
                else if(flag == 4)
                {
                    if(board[A.x+1][A.y]==1)
                        break;
                    A.x++;
                    flag = 0;
                    move(A,board,flag);
                }
                else{
                    A.d = 2;
                    flag++;
                    move(A,board,flag);
                }
                break;

        }
    }
    public static class robot{
        int x;
        int y;
        int d;
        public robot(int y,int x, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
