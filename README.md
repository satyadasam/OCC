# Name Scoring
It takes the input file from command line and score it based on the entered computational logic method. 
It has two modules namely App and JMH

# App
This calculates the final score using 3 computational logic methods from a file of names
Using JDK sort, Standard Trie and Burstsort.

Link for Burstsort library [Burstsort4j](https://github.com/nlfiedler/burstsort4j)

# JMH
for Benchmark tool, we are using [JMH](https://github.com/openjdk/jmh)
to compare the performance of the 3 mothods

![output from JMH](https://github.com/satyadasam/OCC/blob/master/jmhfinal.PNG)

