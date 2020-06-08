CSCI-2467 Lab 9 – Java File I/O
Background
You will write Java code to process data using a file from the 2010 U.S. Census. The file which is called Surnames_2010Census.csv contains data as a set of comma-separated values. Each line contains the following data (separated by commas):
1.	A surname (last name) taken from the 2010 census
2.	An integer indicating the rank order of the surname (1st – most common, second, third, etc.)
3.	A count of the number of people in the U.S. with that surname
4.	A proportion of people with that surname for every 100,000 people in the U.S.
5.	A cumulative proportion of people with that surname
The file contains 162,254 different surnames.
Assignment
You will write a Java program to generate a report based on this file. Be careful and test your code well. You will re-use some of this code in a later lab.
Download the starter file Lab9.zip from Blackboard. Use 7zip to unzip the file using “Extract Here”. Then open the unzipped Lab9 project with IntelliJ.  The project will contain four files:
•	Surnames_2010Census.csv – the census data project
•	Main.java – the Main class containing a pre-written Main method
•	Census.java – a class that contains a partially-written loadCensusData() method that you will complete to read and process the census data file
•	Surname.java – a class that holds one surname and its related metadata
For the Surname class you will need to add the constructor, and accessors and mutators.
The Census class contains a loadCensusData() method you will complete that will read and process the census data file. The filename of the census data file is passed in as a parameter. Make sure that you skip the line of the file that only contains column headings.
Read the first one hundred surnames in the file. Read each line containing a surname as a single String. Use the String method split(“,”) to split each String into a array of Strings split at the comma delimiter. See the documentation on the Java String class for details of the split() method:
https://docs.oracle.com/javase/10/docs/api/java/lang/String.html#split(java.lang.String) 
Note: you can ignore the cumulative proportion field.
Use the Integer.parseInt() and Double.parseDouble() methods to convert Strings to int and double respectively.
Be sure and catch FileNotFoundException and NumberFormatException. Output an appropriate error message and have the method return a null.
Once the method has processed the file, it will return an array of 100 Surname objects.

Example Output
Rank	Name
1		SMITH
2		JOHNSON
3		WILLIAMS
4		BROWN
5		JONES

. . . many more lines of the report . . .

95		PATEL
96		MYERS
97		LONG
98		ROSS
99		FOSTER
100		JIMENEZ

