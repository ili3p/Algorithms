package my.codefu.y10.online1;


import java.util.ArrayList;


public class Minesweeper {
	
	public static String solve(String minefield, int n) {

		minefield = minefield.replace('.', '0');
		char[] cells = minefield.toCharArray();
		int lastIndex = 0;
		int[] pos = new int[8];

		
		while (lastIndex >= 0) {

			lastIndex = minefield.indexOf("x", lastIndex);
			System.out.println(lastIndex);
			if (lastIndex == -1)
				break;
			int i=lastIndex%n;
			int j= lastIndex/n;
			
			int l = i-1;
			int r = i+1;
			int d = j+1;
			int u = j-1;
			for (int w=0;w<pos.length;++w){
				pos[w] = -1;
			}
			if(l > -1  && l < n)
			{
				pos[0] = i-1+j*n;
				if(d > -1 && d< n)
					pos[5] = i-1+(j+1)*n;
			}
			if(d > -1 && d < n)
				pos[3] = i + (j+1)*n;	
			if(u > -1 && u < n)
			{	
				pos[2] = i + (j-1)*n;
			
				if(r > -1 &&r <n)
					pos[7] = i+1+(j-1)*n;	
			}
			if(r > -1 && r <n)
			pos[1] = i+1 + j*n;
			
					if(l>-1&&l<n && u>-1&&u<n)
			pos[4] = i-1+(j-1)*n;
			if(r>-1&&r<n&&d>-1&&d<n)
			pos[6] = i+1+(j+1)*n;
			
			ArrayList<Integer> m = new ArrayList<Integer>();
			for (int position : pos) {

				if (!(m.contains(position)) && position > -1 && position < minefield.length()) {
m.add(position);
					String s = minefield.substring(position, position + 1);
					if (!(s.contains("x"))) {
						int v = Integer.parseInt(s);
						++v;
						cells[position] = String.valueOf(v).charAt(0);
						minefield = new String(cells);
					}
				}
			}

			++lastIndex;
		}

		return minefield;
	}

	public static void main(String[] args) {
		System.out.println(solve("x.......x", 3));
	}
}
