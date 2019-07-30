import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class chickenDelivery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Matrix matrix = new Matrix();
		matrix.execute();
	}

}
class Matrix {

	int[][] matrix;
	ArrayList<int[]> chickens = new ArrayList<>();
	ArrayList<int[]> houses = new ArrayList<>();
	int N, M;

	void makeMatrix() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();

		int matrix[][] = new int[N][N];
		for (int i = 0; i < N; ++i) {

			for (int j = 0; j < N; ++j) {
				matrix[i][j] = scan.nextInt();// 입력하는 곳
			}
			this.matrix = matrix;
		}
	}

	void setChickenHouse() {
		for (int row = 0; row < this.matrix.length; row++) {
			for (int column = 0; column < matrix.length; column++) {
				if (matrix[row][column] == 2) {
					this.chickens.add(new int[] { row, column });
				}
			}
		}

	}

	void setHouse() {
		for (int row = 0; row < this.matrix.length; row++) {
			for (int column = 0; column < matrix.length; column++) {
				if (matrix[row][column] == 1) {
					houses.add(new int[] { row, column });
				}
			}
		}

	}

	int distanceChickens(ArrayList<int[]> chickens) {

		ArrayList<Integer> chickens_distance = new ArrayList<>();

		for (int house = 0; house < houses.size(); house++) {
			ArrayList<Integer> chicken_distance = new ArrayList<>();
			for (int chickensindex = 0; chickensindex < chickens.size(); chickensindex++) {
				chicken_distance.add(distance(houses.get(house)[0], houses.get(house)[1],
						chickens.get(chickensindex)[0], chickens.get(chickensindex)[1]));
			}
			chickens_distance.add(Collections.min(chicken_distance));

		}
		int sum = 0;
		for (int d : chickens_distance)
			sum += d;

		return sum;

	}

	int distance(int x, int y, int x1, int y1) {
		return Math.abs(x - x1) + Math.abs(y - y1);
	}

	List<int[]> Combi(int n, int r) {
		List<int[]> combinations = new ArrayList<>();
		int[] combination = new int[r];

		for (int i = 0; i < r; i++) {
			combination[i] = i;
		}

		while (combination[r - 1] < n) {
			combinations.add(combination.clone());

			int a = r - 1;
			while (a != 0 && combination[a] == n - r + a) {
				a--;
			}
			combination[a]++;
			for (int i = a + 1; i < r; i++) {
				combination[i] = combination[i - 1] + 1;
			}
		}

		return combinations;
	}

	void execute() {
		makeMatrix();
		setChickenHouse();
		setHouse();
		List<int[]> nCr = new ArrayList<>();
		List<Integer> distances = new ArrayList<>();

		
		if (chickens.size() > M) {
			nCr = Combi(chickens.size(), M);

			for (int i = 0; i < nCr.size(); i++) {
				ArrayList<int[]> new_chickens = new ArrayList<>();
				for (int j = 0; j < M; j++) {
					new_chickens.add(chickens.get(nCr.get(i)[j]));

				}
				distances.add(distanceChickens(new_chickens));
			}
			System.out.println(Collections.min(distances));
		} else {
			System.out.println(distanceChickens(chickens));

		}

	}

}
