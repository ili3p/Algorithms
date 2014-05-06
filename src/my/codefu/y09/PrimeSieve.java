package my.codefu.y09;
public class PrimeSieve {
    public static void main(String[] args) { 
        int end = 5000;
        int start = 1;
        boolean[] isPrime = new boolean[end + 1];
        
        for (int i = 2; i <= end; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i*i <= end; i++) {

            if (isPrime[i]) {
                for (int j = i; i*j <= end; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime[i]) {System.out.println(i); primes++;}
        }
        System.out.println("The number of primes <= " + end + " is " + primes);
        
    }
}


