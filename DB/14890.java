import java.util.Scanner;

public class Main {
    static int count = 0;
    static int N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        int L = scan.nextInt();
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            if(check(board[i],L)){
                count++;
            }
        }
        for (int j = 0; j <N ; j++) {
            int[] column = new int[N];
            for (int i = 0; i <N ; i++) {
                column[i] = board[i][j];
            }
            if(check(column,L)){
                count++;
            }
        }
        System.out.println(count);

    }

    static boolean check(int[] board, int L) {
        boolean[] isrunway = new boolean[N];

        for (int i = 0; i < board.length - 1; i++) {
            if (board[i] == board[i + 1]) {
            } else if (board[i] - 1 == board[i + 1]) {
                for (int j = 0; j < L; j++) {
                    if (i + 1 + j < N && board[i + 1 + j] == board[i + 1]) {
                        if (isrunway[i + 1 + j] == false) {
                            isrunway[i + 1 + j] = true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            } else if (board[i] + 1 == board[i + 1]) {
                for (int j = 0; j < L; j++) {
                    if (i - j >= 0 && board[i - j] == board[i]) {
                        if (isrunway[i - j] == false) {
                            isrunway[i - j] = true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
