import java.util.*;

import java.lang.Math;

class PrimeNumbersGenerator {

    /* Create the arraylist variable s just once outside the method get_primes7 as partof
     * class variable,it can be cleared each time inside loop */

    static ArrayList<Integer> s = new ArrayList<Integer>();

    ArrayList<Integer> get_primes7(ArrayList<Integer> res, int n) {
        if (n < 2)
            return res;
        if (n == 2) {
            res.add(2);
            return res;
        }

        // Clear the arraylist s before each time it is used in loop
        s.clear();
        for (int i = 3; i < n + 1; i += 2) {
            s.add(i);
        }
        int mroot = (int)Math.sqrt(n);
        int half = s.size();
        int i = 0;
        int m = 3;
        while (m <= mroot) {
            if (s.get(i) != 0) {
                int j = (int)((m * m - 3) / 2);
                s.set(j, 0);
                while (j < half) {
                    s.set(j, 0);
                    j += m;
                }
            }
            i = i + 1;
           m = 2 * i + 3;
        }
        res.add(2);
        for (int it = 0; it < s.size(); ++it) {
            if (s.get(it) != 0) {
                res.add(s.get(it));
            }
        }

        return res;
    }
}



class PrimeNumbersBenchmarkApp {

    // Create the arraylist to hold the resulting primes only once & pass to calling method
    static ArrayList<Integer> resArr = new ArrayList<Integer>();

    // Same way Create the calling class object only once instead of creating in loop
    static PrimeNumbersGenerator primeGen = new PrimeNumbersGenerator();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long periodTime = Long.parseLong(System.getenv("RUN_TIME"), 10) * 1000;
        while ((System.currentTimeMillis() - startTime) < periodTime) {

            //     Clear the result arraylist each time before calling get_primes7 method
            resArr.clear();
            resArr = primeGen.get_primes7(resArr, 10000000);
            System.out.format("Found %d prime numbers.\n", resArr.size());
        }
    }
}

