package my.codejam.y09.round2;

/**
 * 
 * 
 * 
 *This class contains:
 * 
 * 
 * 
 * 
 * methods to solve Ly = b and Ux = y where L is a full rank lower triangular
 * matrix and U is a full rank upper triangular matrix.
 * 
 * methods to invert upper and lower triangular full rank matrices.
 * 
 * 
 * 
 * 
 * 
 *This class was written by a statistician rather than a numerical analyst.
 * When public domain Java numerical analysis routines become available from
 * numerical analysts (e.g., the people who produce LAPACK), then the code
 * produced by the numerical analysts should be used.
 * 
 * 
 * 
 * 
 *Meanwhile, if you have suggestions for improving this code, please contact
 * Steve Verrill at .
 * 
 *@author Steve Verrill
 *@version .5 --- November 30, 1996
 * 
 */

public class Triangular extends Object {

	/**
	 * 
	 * 
	 * 
	 * 
	 *This method obtains the solution, y, of the equation Ly = b where L is a
	 * known full rank lower triangular n by n matrix, and b is a known vector
	 * of length n.
	 * 
	 *@param l
	 *            [ ][ ] The lower triangular matrix.
	 *@param y
	 *            The solution vector.
	 *@param b
	 *            The right hand side of the equation.
	 *@param n
	 *            The order of l, y, and b.
	 *@throws NotFullRankException
	 *             if one or more of the diagonal elements of l[ ][ ] is zero.
	 * 
	 */

	public void solveLower(double l[][], double y[], double b[], int n)
			throws Exception {

		double sum;

		int i, j;
		int err;

		err = 0;

		for (i = 0; i < n; i++) {

			if (l[i][i] == 0.0) {

				System.out.println("\nTriangular.solveLower error:"
						+ "  Diagonal element " + i
						+ " of the L matrix is zero.\n");
				err = 1;

			}

		}

		if (err == 1) {

			throw new Exception();

		}

		for (i = 0; i < n; i++) {

			sum = 0.0;

			for (j = 0; j < i; j++) {

				sum += l[i][j] * y[j];

			}

			y[i] = (b[i] - sum) / l[i][i];

		}

		return;

	}

	/**
	 * 
	 *This method obtains the solution, x, of the equation Ux = y where U is a
	 * known full rank upper triangular n by n matrix, and y is a known vector
	 * of length n.
	 * 
	 *@param u
	 *            [ ][ ] The upper triangular matrix.
	 *@param x
	 *            The solution vector.
	 *@param y
	 *            The right hand side of the equation.
	 *@param n
	 *            The order of u, x, and y.
	 *@throws NotFullRankException
	 *             if one or more of the diagonal elements of u[ ][ ] is zero.
	 * 
	 */

	public void solveUpper(double u[][], double x[], double y[], int n)
			throws Exception {

		double sum;

		int i, j;
		int err;

		err = 0;

		for (i = 0; i < n; i++) {

			if (u[i][i] == 0.0) {

				System.out.println("\nTriangular.solveUpper error:"
						+ "  Diagonal element " + i
						+ " of the U matrix is zero.\n");
				err = 1;

			}

		}

		if (err == 1) {

			throw new Exception();

		}

		for (i = n - 1; i > -1; i--) {

			sum = 0.0;

			for (j = i + 1; j < n; j++) {

				sum += u[i][j] * x[j];

			}

			x[i] = (y[i] - sum) / u[i][i];

		}

		return;

	}

	/**
	 * 
	 *This method obtains the inverse of a lower triangular n by n matrix L. L
	 * must have non-zero diagonal elements. On exit L is replaced by its
	 * inverse.
	 * 
	 *@param l
	 *            [ ][ ] The lower triangular matrix.
	 *@param n
	 *            The order of l.
	 *@throws NotFullRankException
	 *             if one or more of the diagonal elements of l[ ][ ] is zero.
	 * 
	 */

	public void invertLower(double l[][], int n) throws Exception {

		double sum;

		int i, j, k;
		int err;

		err = 0;

		for (i = 0; i < n; i++) {

			if (l[i][i] == 0.0) {

				System.out.println("\nTriangular.invertLower error:"
						+ "  Diagonal element " + i
						+ " of the L matrix is zero.\n");
				err = 1;

			}

		}

		if (err == 1) {

			throw new Exception();

		}

		for (j = 0; j < n; j++) {

			l[j][j] = 1.0 / l[j][j];

			for (i = j + 1; i < n; i++) {

				sum = 0.0;

				for (k = j; k < i; k++) {

					sum -= l[i][k] * l[k][j];

				}

				l[i][j] = sum / l[i][i];

			}

		}

		return;

	}

	/**
	 * 
	 *This method obtains the inverse of an upper triangular n by n matrix U. U
	 * must have non-zero diagonal elements. On exit U is replaced by its
	 * inverse.
	 * 
	 *@param u
	 *            [ ][ ] The upper triangular matrix.
	 *@param n
	 *            The order of u.
	 *@throws NotFullRankException
	 *             if one or more of the diagonal elements of u[ ][ ] is zero.
	 * 
	 */

	public void invertUpper(double u[][], int n) throws Exception {

		double sum;

		int i, j, k;
		int err;

		err = 0;

		for (i = 0; i < n; i++) {

			if (u[i][i] == 0.0) {

				System.out.println("\nTriangular.invertUpper error:"
						+ "  Diagonal element " + i
						+ " of the U matrix is zero.\n");
				err = 1;

			}

		}

		if (err == 1) {

			throw new Exception();

		}

		for (j = n - 1; j > -1; j--) {

			u[j][j] = 1.0 / u[j][j];

			for (i = j - 1; i > -1; i--) {

				sum = 0.0;

				for (k = j; k > i; k--) {

					sum -= u[i][k] * u[k][j];

				}

				u[i][j] = sum / u[i][i];

			}

		}

		return;

	}

}