# Name Scoring
It takes the input file from command line and score it based on the entered computational logic method. 
It has two modules namely App and JMH

# App
This calculates the final score using 3 computational logic methods from a file of names
Using JDK sort, Standard Trie and Burstsort.
After building the project using maven, run app jar
java  -jar app-1.0-SNAPSHOT-jar-with-dependencies.jar
the pass the path of the file and computational method number after the subsequent command promts.
Link for Burstsort library [Burstsort4j](https://github.com/nlfiedler/burstsort4j)

# JMH
for Benchmark tool, we are using [JMH](https://github.com/openjdk/jmh)
to compare the performance of the 3 mothods.

To get the JMH stats, run the BenchMarkRunner.java as Java application from JMH module
Here is output from 4 core machine. Output vary based on the number of cores of the machine.
![output from JMH](https://github.com/satyadasam/OCC/blob/master/jmhfinal.PNG)

