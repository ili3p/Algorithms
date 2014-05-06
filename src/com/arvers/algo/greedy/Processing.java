package com.arvers.algo.greedy;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Processing {

	static class Job {
		protected int p;
		protected int d;

		public Job(int p1, int d1) {
			p = p1;
			d = d1;
		}

		@Override
		public String toString() {
			return "[p:" + p + ", d:" + d + "]";
		}
	}

	public static void main(String[] args) {
		try {

			boolean test = true;

			Scanner sc = new Scanner(new File("resource/process.txt"));

			int jobSize = sc.nextInt();
			List<Job> jobs = new ArrayList<Job>(jobSize + 50000);

			while (sc.hasNext()) {
				jobs.add(new Job(sc.nextInt(), sc.nextInt()));
			}
			sc.close();

			if (test) {
				for (int i = 0; i < 5000; i++) {
					jobs.add(new Job((int) (Math.random() * 100000), (int) (Math.random() * 100)));
				}
			}

			Comparator<Job> dp = new Comparator<Processing.Job>() {

				@Override
				public int compare(Job o1, Job o2) {
					return (o1.d * o1.p) - (o2.d * o2.p);
				}
			};

			Comparator<Job> d = new Comparator<Processing.Job>() {

				@Override
				public int compare(Job o1, Job o2) {
					return o1.d - o2.d;
				}
			};

			Comparator<Job> p = new Comparator<Processing.Job>() {

				@Override
				public int compare(Job o1, Job o2) {
					return o1.p - o2.p;
				}
			};
			
			long l;
			
			
			Collections.sort(jobs, d);
			if (!test) {
				System.out.println(jobs);
			}
			l = getL(jobs, test);
			System.err.println(" D max(L): " + l);


			Collections.sort(jobs, dp);
			if (!test) {
				System.out.println(jobs);
			}
			l = getL(jobs, test);
			System.err.println("DP max(L): " + l);
			
			Collections.sort(jobs, p);
			if (!test) {
				System.out.println(jobs);
			}
			l = getL(jobs, test);
			System.err.println(" P max(L): " + l);

			


		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static long getL(List<Job> jobs, boolean test) {

		long time = 0;

		long l = Long.MIN_VALUE;

		for (Job job : jobs) {
			time += job.p;
			
			long tmpL = time <= job.d ? 0 : time - job.d;
			if (!test) {
				System.out.println("Job: " + job);
				System.out.println("At time: " + time);
				System.out.println("Late: " + tmpL);
			}

			l = Math.max(l, tmpL);
			
		}

		return l;
	}
}
