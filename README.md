# JavaPrimes
Simple Benchmark using Java for prime numbers
-------------------------------------------------
1. This simple benchmark merely tests only allocation and simple operations and since nature of test is such that dynamic random and short lived/tenured objects are created in loop it is best to use simple flag -XX:NewRatio=1 on java command line to run.
2. Above flag is nothing unusual and it is perfectly ok to add it given the nature of test and it improves runtime irrespective of any code change to original file.
3. For revised code:
Have uploaded 2 files here which are improved versions of original java source file "primes.java" for java 8 .
They would be significantly faster esp use less resources than original "primes.java" for java.


