package com.arvers.algo.greedy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Scheduler {

	static class Job implements Comparable<Job> {

		protected int w;
		protected int l;

		public Job(int w, int l) {
			this.w = w;
			this.l = l;
		}

		public int getDif() {
			return w - l;
		}

		public double getRatio() {
			return 1.0 * w / l;
		}

		@Override
		public int compareTo(Job o) {

			int res = o.getDif() - getDif();
			if (res == 0) {
				res = o.w - w;
			}
			return res;
		}

		@Override
		public String toString() {
			return "[w:" + w + ", l:" + l + ", d:" + getDif() + ", r:" + getRatio() + "]";
		}
	}

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(new File("resource/jobs.txt"));
			int size = scan.nextInt();
			Job[] jobs = new Job[size];
			int i = 0;
			long t = System.nanoTime();
			while (scan.hasNext()) {
				jobs[i++] = new Job(scan.nextInt(), scan.nextInt());
			}
			System.out.println("Reading input: " + (System.nanoTime() - t) / 1e6 + "ms");
			scan.close();

			t = System.nanoTime();
			Arrays.sort(jobs);
			System.out.println("Sorting: " + (System.nanoTime() - t) / 1e6 + "ms");

			t = System.nanoTime();
			long sum = getSum(jobs);
			System.out.println("Summing up: " + (System.nanoTime() - t) / 1e6 + "ms");
			System.out.println("Weighted sum: " + sum+"\n");
			

			t = System.nanoTime();
			Arrays.sort(jobs, new Comparator<Scheduler.Job>() {

				@Override
				public int compare(Job o1, Job o2) {
					return Double.compare(o2.getRatio(), o1.getRatio());
				}
			});
			System.out.println("Sorting: " + (System.nanoTime() - t) / 1e6 + "ms");

			t = System.nanoTime();
			sum = getSum(jobs);
			System.out.println("Summing up: " + (System.nanoTime() - t) / 1e6 + "ms");
			System.out.println("Weighted sum: " + sum);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static long getSum(Job[] jobs) {

		long result = 0;
		long time = 0;

		for (int i = 0; i < jobs.length; i++) {
			time += jobs[i].l;
			result += jobs[i].w * time;
		}

		return result;

	}

	private static void test() {
		Job[] jobs = new Job[3];
		jobs[0] = new Job(3, 4);
		jobs[1] = new Job(5, 2);
		jobs[2] = new Job(4, 5);
		Arrays.sort(jobs, new Comparator<Scheduler.Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				return Double.compare(o2.getRatio(), o1.getRatio());
			}
		});
		System.out.println(Arrays.toString(jobs));

	}
}
