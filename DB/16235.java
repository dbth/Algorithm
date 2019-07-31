import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;

    static int[][] food;
    static int[][] board;
    static List<Integer>[][] trees;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        board = new int[N + 1][N + 1];
        food = new int[N + 1][N + 1];
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                board[i][j] = 5;
            }
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                food[i][j] = scan.nextInt();
            }
        }
        trees = new List[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                trees[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int age = scan.nextInt();
            List<Integer> ages = new ArrayList<>();
            ages.add(age);
            trees[x][y] = ages;
        }

        for (int i = 0; i < K; i++) {
            execute();
        }
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                count += trees[i][j].size();
            }
        }
        System.out.println(count);

    }

    static void execute() {
        int[][] addFood = new int[N + 1][N + 1];
        // spring
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (trees[i][j].size() > 0) {
                    Collections.sort(trees[i][j]);
                    for (int k = 0; k < trees[i][j].size(); k++) {
//                        System.out.print(trees[i][j].get(k) + " ");
                        if (trees[i][j].get(k) > board[i][j]) {
                            addFood[i][j] += trees[i][j].get(k) / 2;
                            trees[i][j].remove(k--);
                        } else {
                            board[i][j] = board[i][j] - trees[i][j].get(k);
                            trees[i][j].set(k, trees[i][j].get(k) + 1);
                        }
                    }
//                    System.out.println();
                }
            }
        }
        // summer
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                board[i][j] += addFood[i][j];
            }
        }
        // fall
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 0; k < trees[i][j].size(); k++) {
                    if (trees[i][j].get(k) % 5 == 0) {
                        breeding(i, j, trees);
                    }
                }
            }
        }
        // winter
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                board[i][j] += food[i][j];
            }
        }
    }

    static void breeding(int i, int j, List<Integer>[][] trees) {
        if (i > 1) {
            trees[i - 1][j].add(1);
            if (j > 1) {
                trees[i - 1][j - 1].add(1);
            }
            if (j < N) {
                trees[i - 1][j + 1].add(1);
            }
        }
        if (i < N) {
            trees[i + 1][j].add(1);
            if (j > 1) {
                trees[i + 1][j - 1].add(1);
            }
            if (j < N) {
                trees[i + 1][j + 1].add(1);
            }

        }
        if (j > 1) {
            trees[i][j - 1].add(1);

        }
        if (j < N) {
            trees[i][j + 1].add(1);

        }
    }
}



