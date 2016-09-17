import java.util.ArrayList;

class PrimeNumbersGenerator {
    int[] get_primes7(int n) {

        int[] res;
        if (n < 2) {
            res = new int[1];
            return res;
        }
        if (n == 2) {
            res = new int[1];
            res[0] = 2;
            return res;
        }
        int[] s = new int[(int) (n - 2) / 2];

        for (int i = 3; i < n + 1; i += 2) {
            s[(i - 3) / 2] = i;
        }

        int mroot = (int) Math.sqrt(n);

        int half = s.length;
        int i = 0;
        int m = 3;
        while (m <= mroot) {

            if (s[i] != 0) {
                int j;
                j = ((m * m - 3) / 2);

                s[j] = 0;
                while (j < half) {

                    s[j] = 0;
                   j += m;
                }
            }
            i = i + 1;
            m = 2 * i + 3;
        }
        // 2 is the only even prime and the first prime always
        int pcount = 1;
        for (int it = 0; it < s.length; ++it) {
            if (s[it] != 0) {
                pcount++;
            }
        }
        res = new int[pcount];
        pcount = 1;
        res[0] = 2;

        for (int it = 0; it < s.length; ++it) {

            if (s[it] != 0) {

                res[pcount] = s[it];
                pcount++;
            }
        }

        return res;
    }
}



class PrimeNumbersBenchmarkApp {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long periodTime = Long.parseLong(System.getenv("RUN_TIME"), 10) * 1000;

        int[] res;
        while ((System.currentTimeMillis() - startTime) < periodTime) {

            res = (new PrimeNumbersGenerator()).get_primes7(10000000);
            System.out.format("Found %d prime numbers.\n", res.length);


        }

    }
}


