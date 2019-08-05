import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> saw_tooths;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        saw_tooths = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> saw_tooth = new ArrayList<>();
            String value = scan.next();
            for (int j = 0; j < 8; j++) {
                char c = value.charAt(j);
                saw_tooth.add((int) c - '0');
            }
            saw_tooths.add(saw_tooth);
        }
        int K = scan.nextInt();
        int[][] rotate = new int[K][2];
        for (int i = 0; i < K; i++) {
            rotate[i][0] = scan.nextInt();
            rotate[i][1] = scan.nextInt();

        }
        //1 은 시계 , -1은 반시계
        for (int i = 0; i < K; i++) {
            int[] direction = new int[4];
            direction[rotate[i][0] - 1] = rotate[i][1];
            switch (rotate[i][0]) {
                case 1:
                    if (saw_tooths.get(rotate[i][0] - 1).get(2) != saw_tooths.get(rotate[i][0]).get(6)) {
                        if (saw_tooths.get(rotate[i][0]).get(2) != saw_tooths.get(rotate[i][0] + 1).get(6)) {
                            if (saw_tooths.get(rotate[i][0] + 1).get(2) != saw_tooths.get(rotate[i][0] + 2).get(6)) {
                                direction[rotate[i][0] + 2] = (-1) * rotate[i][1];
                            }
                            direction[rotate[i][0] + 1] = rotate[i][1];
                        }
                        direction[rotate[i][0]] = (-1) * rotate[i][1];
                    }
                    break;
                case 2:
                    if (saw_tooths.get(rotate[i][0] - 1).get(2) != saw_tooths.get(rotate[i][0]).get(6)) {
                        if (saw_tooths.get(rotate[i][0]).get(2) != saw_tooths.get(rotate[i][0] + 1).get(6)) {
                            direction[rotate[i][0] + 1] = rotate[i][1];
                        }
                        direction[rotate[i][0]] = (-1) * rotate[i][1];
                    }
                    if (saw_tooths.get(rotate[i][0] - 2).get(2) != saw_tooths.get(rotate[i][0] - 1).get(6)) {
                        direction[rotate[i][0] - 2] = (-1) * rotate[i][1];
                    }
                    break;
                case 3:
                    if (saw_tooths.get(rotate[i][0] - 1).get(2) != saw_tooths.get(rotate[i][0]).get(6)) {
                        direction[rotate[i][0]] = (-1) * rotate[i][1];
                    }
                    if (saw_tooths.get(rotate[i][0] - 2).get(2) != saw_tooths.get(rotate[i][0] - 1).get(6)) {
                        if (saw_tooths.get(rotate[i][0] - 3).get(2) != saw_tooths.get(rotate[i][0] - 2).get(6)) {
                            direction[rotate[i][0] - 3] = rotate[i][1];
                        }
                        direction[rotate[i][0] - 2] = (-1) * rotate[i][1];
                    }
                    break;
                case 4:
                    if (saw_tooths.get(rotate[i][0] - 2).get(2) != saw_tooths.get(rotate[i][0] - 1).get(6)) {
                        if (saw_tooths.get(rotate[i][0] - 3).get(2) != saw_tooths.get(rotate[i][0] - 2).get(6)) {
                            if (saw_tooths.get(rotate[i][0] - 4).get(2) != saw_tooths.get(rotate[i][0] - 3).get(6)) {
                                direction[rotate[i][0] - 4] = (-1) * rotate[i][1];
                            }
                            direction[rotate[i][0] - 3] = rotate[i][1];
                        }
                        direction[rotate[i][0] - 2] = (-1) * rotate[i][1];
                    }
                    break;
            }
            for (int j = 0; j < direction.length; j++) {
                if (direction[j] == 1) {
                    clockWise(j);
                } else if (direction[j] == -1) {
                    Counterclockwise(j);
                }
            }
        }

        int total = 0;
        if (saw_tooths.get(0).get(0) == 1) {
            total += 1;
        }
        if (saw_tooths.get(1).get(0) == 1) {
            total += 2;
        }
        if (saw_tooths.get(2).get(0) == 1) {
            total += 4;
        }
        if (saw_tooths.get(3).get(0) == 1) {
            total += 8;
        }
        System.out.print(total);


    }

    static void clockWise(int index) {
        saw_tooths.get(index).add(0, saw_tooths.get(index).get(7));
        saw_tooths.get(index).remove(8);
    }

    static void Counterclockwise(int index) {
        saw_tooths.get(index).add(saw_tooths.get(index).get(0));
        saw_tooths.get(index).remove(0);

    }
}
