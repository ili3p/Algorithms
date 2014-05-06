/**
 * 
 */
package my.codefu.y10.online1;

/**
 * @author Ilija Ilievski
 * 
 */
public class Whoohoo {
	public static int getCount(String[] map, int maxTime) {

		int X = map[0].length(), Y = map.length;

		int[][][] spaceTime = new int[X][Y][maxTime+1];
		char[][] cMap = new char[X][Y];

		for (int i = 0; i < X; ++i) {
			cMap[i] = map[i].toCharArray();
		}

		for (int i = 0; i < X; ++i)
			for (int j = 0; j < Y; ++j)
				for (int k = 0; k <= maxTime; ++k)
					spaceTime[i][j][k] = -1;

		spaceTime[0][0][0] = 0; // startPosition

		for (int t = 1; t <= maxTime; ++t) {
			for (int x = 0; x < X; ++x) {
				for (int y = 0; y < Y; ++y) {

					int prevCell = spaceTime[x][y][t - 1];
					
					System.out.println("PrevCell:"+prevCell+"  x:"+x+" y:"+y+"  t:"+t		
							);
					
					if (prevCell > -1) // in the prev. step we have been there
					{
						char cellType = cMap[x][y]; System.out.println("CellType: "+cellType);
						
						int dx = 0, dy = 0;

						switch (cellType) {
						case 'R':
							System.out.println("must go Right");
							++dy;
							break;
						case 'L':
							System.out.println("must go Left");
							--dy;
							break;
						case 'D':
							System.out.println("must go Down");
							++dx;
							break;
						case 'U':
							System.out.println("must go Up");
							--dx;
							break;
						}
						if (dx != 0 || dy != 0) {
							int newValue = Math.max(
									spaceTime[x + dx][y + dy][t], prevCell + 1);							
							spaceTime[x + dx][y + dy][t] = newValue;
							System.out.println("NewValue: "+newValue);
							for (int h = 0; h < X; ++h) {
								for (int g = 0; g < Y; ++g) {
									System.out.print(spaceTime[h][g][t] + ",");
								}
								System.out.println();
							}
							
						}

						if (cellType == '.') {
							int right = y + 1;
							if (right < X) {
								System.out.println("Go Right");
								char nextCell = cMap[x][right]; System.out.println("NextCell: "+nextCell);
								if ((nextCell == '.' || nextCell == 'L')
										|| (nextCell == 'R' && right + 1 < X)
										|| (nextCell == 'D' && x + 1 < Y)
										|| (nextCell == 'U' && x - 1 > -1)) {

									int newValue = Math.max(
											spaceTime[x][right][t], prevCell);
									spaceTime[x][right][t] = newValue;
									System.out.println("NewValue: "+newValue);
									for (int h = 0; h < X; ++h) {
										for (int g = 0; g < Y; ++g) {
											System.out.print(spaceTime[h][g][t] + ",");
										}
										System.out.println();
									}
								}
							}

							int left = y - 1;
							if (left > -1) {
								System.out.println("Go Left");
								char nextCell = cMap[x][left];System.out.println("NextCell: "+nextCell);
								if ((nextCell == '.' || nextCell == 'R')
										|| (nextCell == 'L' && left - 1 > -1)
										|| (nextCell == 'D' && x + 1 < Y)
										|| (nextCell == 'U' && x - 1 > -1)) {

									int newValue = Math.max(
											spaceTime[x][left][t], prevCell);
									spaceTime[x][left][t] = newValue;
									System.out.println("NewValue: "+newValue);
									for (int h = 0; h < X; ++h) {
										for (int g = 0; g < Y; ++g) {
											System.out.print(spaceTime[h][g][t] + ",");
										}
										System.out.println();
									}
								}
							}

							int down = x + 1;
							if (down < Y) {
								System.out.println("Go Down");
								char nextCell = cMap[down][y];System.out.println("NextCell: "+nextCell);
								if ((nextCell == '.' || nextCell == 'U')
										|| (nextCell == 'R' && y + 1 < X)
										|| (nextCell == 'D' && down + 1 < Y)
										|| (nextCell == 'L' && y - 1 > -1)) {

									int newValue = Math.max(
											spaceTime[down][y][t], prevCell);
									spaceTime[down][y][t] = newValue;
									System.out.println("NewValue: "+newValue);
									for (int h = 0; h < X; ++h) {
										for (int g = 0; g < Y; ++g) {
											System.out.print(spaceTime[h][g][t] + ",");
										}
										System.out.println();
									}
								}
							}

							int up = x - 1;
							if (up > -1) {
								System.out.println("Go Up");
								char nextCell = cMap[up][y];System.out.println("NextCell: "+nextCell);
								if ((nextCell == '.' || nextCell == 'D')
										|| (nextCell == 'R' && y + 1 < X)
										|| (nextCell == 'U' && up - 1 > -1)
										|| (nextCell == 'L' && y - 1 > -1)) {

									int newValue = Math.max(
											spaceTime[up][y][t], prevCell);
									spaceTime[up][y][t] = newValue;
									System.out.println("NewValue: "+newValue);
									for (int h = 0; h < X; ++h) {
										for (int g = 0; g < Y; ++g) {
											System.out.print(spaceTime[h][g][t] + ",");
										}
										System.out.println();
									}
								}
							}
						}
					}
				}
			}
		}

		for (int t = 0; t < maxTime; ++t) {
			System.out.println("TimeStep "+(t+1)+":");
			for (int x = 0; x < X; ++x) {
				for (int y = 0; y < Y; ++y) {
					System.out.print(spaceTime[x][y][t] + ",");
				}
				System.out.println();
			}
			System.out.println("\n");
			
		}
		return spaceTime[X - 1][Y - 1][maxTime-1];
	}

	public static void main(String[] args) {
		String[] map = {".R.","..D","..."};
		int maxTime = 4;
		System.out.println(getCount(map, maxTime));
	}
}
