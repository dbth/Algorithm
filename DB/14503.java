import java.util.Scanner;

public class Main {
    static int count = 0;
    static int N;
    static int M;
    static boolean running = true;
    static int[][] board;
    static Robot robot;
    static int allclean = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        robot = new Robot(scan.nextInt(), scan.nextInt(), scan.nextInt());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = scan.nextInt();
            }
        }
        cleaning();


        while (running) {
            search();
        }
        System.out.println(count);

    }


    static void cleaning() {
        board[robot.getX()][robot.getY()] = -1;
        count++;
    }

    static void search() {
        if (allclean == 4) {
            switch (robot.getDirection()) {
                case 0:
                    if (board[robot.getX() + 1][robot.getY()] == 1) {
                        running = false;
                    } else {
                        robot.setX(robot.getX() + 1);
                        allclean = 0;
                        search();
                    }
                    break;
                case 1:
                    if (board[robot.getX()][robot.getY() - 1] == 1) {
                        running = false;
                    } else {
                        robot.setY(robot.getY() - 1);
                        allclean = 0;
                        search();
                    }
                    break;
                case 2:
                    if (board[robot.getX() - 1][robot.getY()] == 1) {
                        running = false;
                    } else {
                        robot.setX(robot.getX() - 1);
                        allclean = 0;
                        search();
                    }
                    break;
                case 3:
                    if (board[robot.getX()][robot.getY() + 1] == 1) {
                        running = false;
                    } else {
                        robot.setY(robot.getY() + 1);
                        allclean = 0;
                        search();
                    }
                    break;
            }
        } else {
            int temp = (robot.getDirection() + 3) % 4;
            int x = robot.getX();
            int y = robot.getY();
            switch (temp) {
                case 0:
                    x--;
                    break;
                case 1:
                    y++;
                    break;
                case 2:
                    x++;
                    break;
                case 3:
                    y--;
                    break;
            }
            if (board[x][y] == 0) {
                robot.setDirection(temp);
                robot.setX(x);
                robot.setY(y);
                cleaning();
                allclean = 0;
                search();

            } else {
                robot.setDirection(temp);
                allclean++;
                search();
            }

        }

    }


}

class Robot {
    private int x;
    private int y;
    // 0 :북 1: 동 2: 남 3: 서
    private int direction;

    public Robot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
