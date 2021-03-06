package Misc;

/*
 * The best 'brute force' prime determining algorithm takes O(N sqrt(N) ) time. Is there a way to improve?
 * 
 * 	
 * Sieve of Eraosthenes is an algorithm to find prime numbers up to specified n. It was invented around 200BC meaning it is around 2200 years old
 * 
 * It works by first having a boolean to mark the eliminated number first. THen we will start looping from 2 up to n.
 * If the i is already eliminated as shown in the eliminated array, simply continue.
 * Else, it is a prime number! Therefore, we put that into our results.
 * Now, since the multiples of this prime number is not prime, we need to eliminate them, up until n.
 * 
 * An optimization would be start eliminating from the square of this number, which is i * i. Every loop we'll increment by i
 * Why is this available?
 * 	
 * Consider finding out is 5 prime? Yes it is prime. But do we start eliminating from 5x2, 5x3, 5x4...?
 * No because up until 5, we had already iterated 2,3 and 4. This means previously, we had marked off 2x5, 3x5, 4x5 which
 * is the exact same thing!
 */

public class Sieve_of_Eratosthenes {
	
	//	The optimized 'brute' prime determination algorithm
	private static boolean isPrime(int n) {
		if (n < 2) return false;
		if (n == 2 || n == 3) return true;
		if (n % 2 == 0 || n % 3 == 0) return false;
		
		long sqrtN = (long)(Math.sqrt(n) + 1);
		for (long tester = 6; tester <= sqrtN; tester += 6) {
			if (n % (tester - 1) == 0 || n % (tester + 1) == 0 ) return false;
		}
		
		return true;
	}
	
	static void printPrimes(int limit) {
		boolean[] eliminate = new boolean[limit + 1];
		
		for (int i = 2; i <= limit; i ++ ) {
			if (i % 100 == 0) System.out.println("");
			if (eliminate[i]) continue;
			
			System.out.print(i + " ");
			
			for (long e = 1L * i * i; e <= limit; e += i) {
				eliminate[(int)e] = true;
			}
			
		}
	}
	
	public static void main(String[]args) {
		long time = System.currentTimeMillis();
		printPrimes(99999999);
		System.out.println(System.currentTimeMillis() - time);
	}
	
}
