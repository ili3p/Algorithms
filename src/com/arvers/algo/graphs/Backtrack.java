package com.arvers.algo.graphs;

import java.io.*;
import java.util.*;

public class Backtrack {
	static class SubProblem {
		HashSet<Integer> clauses;
		HashSet<Integer> vars;

		public SubProblem(HashSet<Integer> c, HashSet<Integer> v) {
			clauses = c;
			vars = v;
		}

		@Override
		public String toString() {
			return "Clauses:" + clauses + "\nVars:" + vars;
		}
	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("resource/2sat_test.txt"));
			int N = sc.nextInt();

			int[][] clauses = new int[N][];
			byte[] pass = new byte[N];
			int q = 0;
			while (sc.hasNext()) {
				clauses[q] = new int[] { sc.nextInt(), sc.nextInt() };
				pass[q] = -1;
				++q;
			}
			sc.close();

			boolean satisfiable = true;

			int i = 0;
			pass[i] = 0;
			while (i < pass.length) {

				satisfiable = true;

				for (int[] clause : clauses) {

					int lVar = Math.abs(clause[0]) - 1;
					int rVar = Math.abs(clause[1]) - 1;
					if (pass[lVar] == -1 || pass[rVar] == -1) {
						satisfiable = false;
						continue;
					}
					boolean l = clause[0] > -1 && pass[lVar] == 1 || clause[0] < -1 && pass[lVar] == 0;
					boolean r = clause[1] > -1 && pass[rVar] == 1 || clause[1] < -1 && pass[rVar] == 0;
					if (!l && !r) {
						satisfiable = false;
						break;
					}
				}

				if (satisfiable) {
					System.out.println("Satisfiable!");
				} else {
					if (pass[i] == 0) {
						pass[i] = 1;
					} else if (pass[i] == 1) {
						++i;
						if (i < pass.length) {
							pass[i] = 0;
						} else {
							break;
						}
					} else {
						System.out.println("ERROR");
					}
				}
			}

			if (!satisfiable) {
				System.out.println("Unsatisfiable :(");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// old solution

/**
 * public static void main(String[] args) { try { Scanner sc = new Scanner(new
 * File("resource/2sat_test.txt")); int N = sc.nextInt();
 * 
 * int[][] clauses = new int[N][]; Stack<SubProblem> subProblems = new
 * Stack<SubProblem>(); HashSet<Integer> problemClau = new HashSet<Integer>();
 * int q = 0; while (sc.hasNext()) { clauses[q] = new int[] { sc.nextInt(),
 * sc.nextInt() }; problemClau.add(q); ++q; } sc.close();
 * 
 * subProblems.add(new SubProblem(problemClau, new HashSet<Integer>())); boolean
 * satisfiable = false; while (!subProblems.empty()) {
 * 
 * SubProblem p = subProblems.pop(); if (p.vars.size() % 1000 == 0) {
 * System.out.println(p.vars.size()); } int var = Integer.MAX_VALUE;
 * 
 * for (int index : p.clauses) { if (var == Integer.MAX_VALUE) { // var not set,
 * set to first variable in clause if // doesn't already contain it if
 * (!p.vars.contains(clauses[index][0])) { var = clauses[index][0]; } else if
 * (!p.vars.contains(clauses[index][1])) { var = clauses[index][1]; } } // check
 * for better choice for var if (!p.vars.contains(clauses[index][0]) &&
 * p.vars.contains(-clauses[index][1])) { var = clauses[index][0]; // next var
 * to be consider; break; } if (p.vars.contains(-clauses[index][0]) &&
 * !p.vars.contains(clauses[index][1])) { var = clauses[index][1]; // next var
 * to be consider; break; }
 * 
 * } var = Math.abs(var); // we have var
 * 
 * for (int i = 0; i < 2; ++i) { HashSet<Integer> nextSet = new
 * HashSet<Integer>(); boolean hasSolution = true; var = i == 1 ? var : -var;
 * for (int index : p.clauses) {
 * 
 * int[] clause = clauses[index];
 * 
 * if (hasSolution) { if ((p.vars.contains(-clause[0]) && -clause[1] == var) ||
 * (p.vars.contains(-clause[1]) && -clause[0] == var)) { hasSolution = false;
 * nextSet = null; } else if (!(clause[0] == var || clause[1] == var)) {
 * nextSet.add(index); } }
 * 
 * if (!hasSolution) { break; } }
 * 
 * if (hasSolution) { if (nextSet.isEmpty()) { satisfiable = true; break; } else
 * { HashSet<Integer> set = new HashSet<Integer>(p.vars); set.add(var);
 * subProblems.push(new SubProblem(nextSet, set)); } } } } if (!satisfiable) {
 * System.out.println("Unsatisfiable :("); } else {
 * System.out.println("Satisfiable!"); } } catch (Exception e) {
 * e.printStackTrace(); } }
 */
