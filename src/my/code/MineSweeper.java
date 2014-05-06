package my.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MineSweeper {
	public static void main(String[] args) throws IOException {

		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		String line;

		int i = 1;

		while ((line = reader.readLine()) != null) {

			int lines = Integer.parseInt(line.split(" ")[0]);
			if (lines == 0)
				break;
			String[] field = new String[lines];

			for (int k = 0; k < lines; ++k) {
				field[k] = reader.readLine();
			}

			Solver solve = new Solver();

			field = solve.getResult(field);

			StringBuilder sb = new StringBuilder();

			sb.append("Field #" + String.valueOf(i) + "\n");
			for (int k = 0; k < lines; ++k) {
				sb.append(field[k] + "\n");
			}
			System.out.println(sb);
			++i;
		}
	}

	public static class Solver {

		public String[] getResult(String[] field) {

			char[][] boxes = new char[field[0].length()][field.length];
			int n = field.length;
			int m = field[0].length();
			for (int j = 0; j < n; ++j) {
				boxes[j] = field[j].toCharArray();
			}
			for (int j = 0; j < n; ++j) {
				for (int k = 0; k < m; ++k) {

					if (boxes[j][k] == '*') {
						updateBox(boxes, n, m, j, k);
					} else if (boxes[j][k] == '.') {
						boxes[j][k] = '0';
					}

				}
			}
			String[] result = toCharArray(boxes);

			return result;
		}

		private String[] toCharArray(char[][] boxes) {

			String[] result = new String[boxes.length];

			for (int j = 0; j < boxes.length; ++j) {
				result[j] = new String(boxes[j]);
			}

			return result;
		}

		private void updateBox(char[][] boxes, int n, int m, int j, int k) {
			int x, y;
			for (int r = -1; r <= 1; ++r) {
				for (int t = -1; t <= 1; ++t) {
					x = j + r;
					y = k + t;
					if (x < n && y < m && x >= 0 && y >= 0) {

						int z = getX(boxes[x][y]);
						if (z == -1)
							continue;
						++z;
						boxes[x][y] = String.valueOf(z).toCharArray()[0];

					}
				}
			}
			boxes[j][k] = '*';
		}

		private int getX(char c) {

			if (c == '*')
				return -1;
			int x;
			try {
				x = Integer.parseInt(Character.toString(c));
			} catch (Exception e) {
				x = 0;
			}

			return x;
		}
	}
}
