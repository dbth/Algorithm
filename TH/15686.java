import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int board[][] = new int[N][N];
        int answer = Integer.MAX_VALUE;
        ArrayList<point> chickenList = new ArrayList<>();
        ArrayList<point> houseList = new ArrayList<>();

        for(int y = 0;y<N;y++)
        {
            for(int x = 0; x<N;x++)
            {
                board[x][y] = sc.nextInt();
                if(board[x][y] == 1)
                    houseList.add(new point(x,y));
                else if(board[x][y] == 2)
                    chickenList.add(new point(x,y));
            }
        }


        System.out.print(answer);

    }
    public static int chooseChicken()
    {

        return 0;
    }
    public static class point{
        int X;
        int Y;
        public point(int x, int y)
        {
            this.X = x;
            this.Y = y;
        }
    }
}
