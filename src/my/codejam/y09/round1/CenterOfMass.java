package my.codejam.y09.round1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CenterOfMass {
	static void runIt() throws IOException {

		String inFName = "B-small-attempt0.in";
		String outFName = "B-small-attempt0.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));
		int testCases = Integer.parseInt(in.readLine());
		for (int i = 0; i < testCases; ++i) {
			int numFlies = Integer.parseInt(in.readLine());
			List<res> result = new ArrayList<res>();
			List<flie> f = new ArrayList<flie>();
			for (int k = 0; k < numFlies; ++k) {
				String[] sp = in.readLine().split(" ");
				flie e = new flie(sp);
				f.add(e);
			}

			for (int time = 1; time < 1000; ++time) {
				double mx = 0, my = 0, mz = 0;
				for (flie e : f) {
					e.go();
					mx += e.x;
					my += e.y;
					mz += e.z;
				}

				mx /= numFlies;
				my /= numFlies;
				mz /= numFlies;
				Double dist = Math.sqrt(mx * mx + my * my + mz * mz);
				result.add(new res(dist, time));
			}
			Collections.sort(result, new Comparator<res>() {
				public int compare(res n1, res n2) {
					int m = (int) (n1.dist - n2.dist);

					return m;
				}
			});

			out.println("Case #" + i + ": " + result.get(0).dist + " "
					+ (double) (result.get(0).time));
		}
		in.close();
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		try {
			CenterOfMass.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

	static class res {
		public res(double dist, int time) {
			super();
			this.dist = dist;
			this.time = time;
		}

		public double dist;
		public int time;

	}

	static class flie {
		public double x;
		public double y;
		public double z;

		public double vx;
		public double vy;
		public double vz;

		public flie(String[] sp) {
			x = Double.parseDouble(sp[0]);
			y = Double.parseDouble(sp[1]);
			z = Double.parseDouble(sp[2]);
			vx = Double.parseDouble(sp[3]);
			vy = Double.parseDouble(sp[4]);
			vz = Double.parseDouble(sp[5]);
		}

		public flie(int p, int v, int m) {
			x = p;
			y = v;
			z = m;

		}

		public void go() {
			x += vx;
			y += vy;
			z += vz;
		}

	}

	/*
	 * Collections.sort(nums, new Comparator<pom>() { public int compare(pom n1,
	 * pom n2) { int m = n1.value - n2.value;
	 * 
	 * return m; } });
	 */
}
