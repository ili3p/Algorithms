package com.arvers.algo.greedy;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Auditorium {

	static class Request {

		protected int s;
		protected int t;
		protected int l;
		protected int c;

		public Request(int s, int t) {
			this.s = s;
			this.t = t;
			this.l = t - s;
			if (l <= 0) {
				System.err.println("Len is " + l);
			}
		}

		public boolean isInConfilct(Request r) {
			return (s >= r.s && s <= r.t) || (r.s >= s && r.s <= t);
		}

		@Override
		public String toString() {
			return "[s:" + s + ", t:" + t + ", l:" + l + "]";
		}
	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("resource/audit.txt"));
			int numRequest = sc.nextInt();
			List<Request> requests = new ArrayList<Request>(2000 + numRequest);

			while (sc.hasNext()) {
				requests.add(new Request(sc.nextInt(), sc.nextInt()));
			}
			sc.close();

			boolean debug = true;

			if (debug) {
				for (int i = 0; i < 30000; ++i) {
					int start = (int) (Math.random() * 5000000);
					int end = start + (int) (Math.random() * 5000) + 1;
					requests.add(new Request(start, end));
				}
			}

			Comparator<Request> len = new Comparator<Request>() {
				@Override
				public int compare(Request o1, Request o2) {
					return o1.l - o2.l;
				}
			};

			Comparator<Request> start = new Comparator<Request>() {
				@Override
				public int compare(Request o1, Request o2) {
					return o1.s - o2.s;
				}
			};

			Comparator<Request> end = new Comparator<Request>() {
				@Override
				public int compare(Request o1, Request o2) {
					return o1.t - o2.t;
				}
			};
			
			Collections.sort(requests, len);
			if (!debug)
				for (Request request : requests) {
					System.out.println(request);
				}

			List<Request> taken = getTaken(requests, !debug);
			System.out.println("Len: "+taken.size());

			Collections.sort(requests, end);
			if (!debug)
				for (Request request : requests) {
					System.out.println(request);
				}

			 taken = getTaken(requests, !debug);
			System.out.println("End: "+taken.size());

		

			
			Collections.sort(requests, start);
			if (!debug)
				for (Request request : requests) {
					System.out.println(request);
				}

			taken = getTaken(requests, !debug);
			System.out.println("Sta: " +taken.size());

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<Request> getTaken(List<Request> requests, boolean print) {
		List<Request> taken = new ArrayList<Request>(requests.size());
		taken.add(requests.get(0));

		if (print)
			System.out.println(taken);

		for (Request request : requests) {

			if (!taken.contains(request)) {
				boolean f = false;
				for (Request t : taken) {
					f = request.isInConfilct(t) || t.isInConfilct(request);
					if (f) {
						break;
					}
				}
				if (!f) {
					taken.add(request);
				}
			}
			if (print)
				System.out.println(taken);
		}

		return taken;
	}
}
