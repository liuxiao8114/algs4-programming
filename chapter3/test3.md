See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED
API:          PASSED

Findbugs:     FAILED (7 warnings)
PMD:          PASSED
Checkstyle:   FAILED (0 errors, 51 warnings)

Correctness:  34/41 tests passed
Memory:       1/1 tests passed
Timing:       25/41 tests passed

Aggregate score: 81.95%
[Compilation: 5%, API: 5%, Findbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
2.3K Oct  3 16:08 BruteCollinearPoints.java
3.0K Oct  3 16:08 FastCollinearPoints.java
1.8K Oct  3 16:08 Point.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Point.java
*-----------------------------------------------------------

% javac BruteCollinearPoints.java
*-----------------------------------------------------------

% javac FastCollinearPoints.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Point:

BruteCollinearPoints:

FastCollinearPoints:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% findbugs *.class
*-----------------------------------------------------------
M D DMI_HARDCODED_ABSOLUTE_FILENAME DMI: Contains a hard-coded reference to an absolute pathname.  At BruteCollinearPoints.java:[line 68]
M V EI_EXPOSE_REP EI: Returns a reference to the mutable object stored in the instance variable 'lines', which exposes the internal representation of the class 'BruteCollinearPoints'. Instead, create a defensive copy of the object referenced by 'lines' and return the copy.  At BruteCollinearPoints.java:[line 64]
M V EI_EXPOSE_REP2 EI2: Stores a reference to an externally mutable object in the instance variable 'points', exposing the internal representation of the class 'BruteCollinearPoints'. Instead, create a defensive copy of the object referenced by the parameter variable 'points' and store that copy in the instance variable 'points'.   At BruteCollinearPoints.java:[line 25]
L D FE_FLOATING_POINT_EQUALITY FE: Tests for exact floating-point equality. Because floating-point calculations may involve rounding, the calculated values may be imprecise.  At BruteCollinearPoints.java:[line 44]
M D IM_BAD_CHECK_FOR_ODD IM: Uses an expression like 'x % 2 == 1' to check whether an integer is odd, but this won't work for negative integers. Instead, use an expression like 'x % 2 != 0'.  At BruteCollinearPoints.java:[line 72]
M V EI_EXPOSE_REP EI: Returns a reference to the mutable object stored in the instance variable 'lines', which exposes the internal representation of the class 'FastCollinearPoints'. Instead, create a defensive copy of the object referenced by 'lines' and return the copy.  At FastCollinearPoints.java:[line 86]
M V EI_EXPOSE_REP2 EI2: Stores a reference to an externally mutable object in the instance variable 'points', exposing the internal representation of the class 'FastCollinearPoints'. Instead, create a defensive copy of the object referenced by the parameter variable 'points' and store that copy in the instance variable 'points'.   At FastCollinearPoints.java:[line 15]
Warnings generated: 7


================================================================


% pmd .
*-----------------------------------------------------------
BruteCollinearPoints.java:9: The private instance (or static) variable 'points' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
BruteCollinearPoints.java:10: Can you replace the instance (or static) variable 'lines' with a local variable? [SingularField]
BruteCollinearPoints.java:64: Returning 'lines' may expose an internal array. If so, return a defensive copy. [MethodReturnsInternalArray]
FastCollinearPoints.java:9: The private instance (or static) variable 'points' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
FastCollinearPoints.java:10: Can you replace the instance (or static) variable 'lines' with a local variable? [SingularField]
FastCollinearPoints.java:86: Returning 'lines' may expose an internal array. If so, return a defensive copy. [MethodReturnsInternalArray]
PMD ends with 6 warnings.


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] BruteCollinearPoints.java:2:8: Unused import statement for 'java.util.Comparator'. [UnusedImports]
[WARN] BruteCollinearPoints.java:9:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] BruteCollinearPoints.java:15:11: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:17:12: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:18:15: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:19:16: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:20:19: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:37:12: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:38:16: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:39:20: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:40:24: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:40:29: Do not use the letter 'l' as a variable name (or other identifier). It is hard to distinguish from the number '1'. [IllegalTokenText]
[WARN] BruteCollinearPoints.java:40:40: Do not use the letter 'l' as a variable name (or other identifier). It is hard to distinguish from the number '1'. [IllegalTokenText]
[WARN] BruteCollinearPoints.java:40:49: Do not use the letter 'l' as a variable name (or other identifier). It is hard to distinguish from the number '1'. [IllegalTokenText]
[WARN] BruteCollinearPoints.java:43:67: Do not use the letter 'l' as a variable name (or other identifier). It is hard to distinguish from the number '1'. [IllegalTokenText]
[WARN] BruteCollinearPoints.java:44:27: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:49:45: Do not use the letter 'l' as a variable name (or other identifier). It is hard to distinguish from the number '1'. [IllegalTokenText]
[WARN] BruteCollinearPoints.java:60:12: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:71:12: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:72:15: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:78:12: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:78:25: Do not use the letter 'l' as a variable name (or other identifier). It is hard to distinguish from the number '1'. [IllegalTokenText]
[WARN] BruteCollinearPoints.java:79:26: Do not use the letter 'l' as a variable name (or other identifier). It is hard to distinguish from the number '1'. [IllegalTokenText]
[WARN] FastCollinearPoints.java:2:8: Unused import statement for 'java.util.Comparator'. [UnusedImports]
[WARN] FastCollinearPoints.java:9:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] FastCollinearPoints.java:28:12: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] FastCollinearPoints.java:33:18: 'while' is not followed by whitespace. [WhitespaceAround]
[WARN] FastCollinearPoints.java:34:19: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] FastCollinearPoints.java:36:23: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] FastCollinearPoints.java:41:27: '//' or '/*' is not followed by whitespace. [IllegalTokenText]
[WARN] FastCollinearPoints.java:43:27: '//' or '/*' is not followed by whitespace. [IllegalTokenText]
[WARN] FastCollinearPoints.java:45:28: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] FastCollinearPoints.java:50:27: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] FastCollinearPoints.java:62:15: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] FastCollinearPoints.java:68:20: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] FastCollinearPoints.java:71:19: '//' or '/*' is not followed by whitespace. [IllegalTokenText]
[WARN] FastCollinearPoints.java:73:19: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] FastCollinearPoints.java:82:12: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] Point.java:4:8: Unused import statement for 'edu.princeton.cs.algs4.StdRandom'. [UnusedImports]
...
Checkstyle ends with 0 errors and 51 warnings.

% custom checkstyle checks for Point.java
*-----------------------------------------------------------

% custom checkstyle checks for BruteCollinearPoints.java
*-----------------------------------------------------------

% custom checkstyle checks for FastCollinearPoints.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Point
*-----------------------------------------------------------
Running 3 total tests.

Test 1: p.slopeTo(q)
  * positive infinite slope, where p and q have coordinates in [0, 500)
  * positive infinite slope, where p and q have coordinates in [0, 32768)
  * negative infinite slope, where p and q have coordinates in [0, 500)
  * negative infinite slope, where p and q have coordinates in [0, 32768)
  * positive zero     slope, where p and q have coordinates in [0, 500)
  * positive zero     slope, where p and q have coordinates in [0, 32768)
  * symmetric for random points p and q with coordinates in [0, 500)
  * symmetric for random points p and q with coordinates in [0, 32768)
  * transitive for random points p, q, and r with coordinates in [0, 500)
  * transitive for random points p, q, and r with coordinates in [0, 32768)
  * slopeTo(), where p and q have coordinates in [0, 500)
  * slopeTo(), where p and q have coordinates in [0, 32768)
  * slopeTo(), where p and q have coordinates in [0, 10)
  * throw a java.lang.NullPointerException if argument is null
==> passed

Test 2: p.compareTo(q)
  * reflexive, where p and q have coordinates in [0, 500)
  * reflexive, where p and q have coordinates in [0, 32768)
  * antisymmetric, where p and q have coordinates in [0, 500)
  * antisymmetric, where p and q have coordinates in [0, 32768)
  * transitive, where p, q, and r have coordinates in [0, 500)
  * transitive, where p, q, and r have coordinates in [0, 32768)
  * sign of compareTo(), where p and q have coordinates in [0, 500)
  * sign of compareTo(), where p and q have coordinates in [0, 32768)
  * sign of compareTo(), where p and q have coordinates in [0, 10)
  * throw java.lang.NullPointerException exception if argument is null
==> passed

Test 3: p.slopeOrder().compare(q, r)
  * reflexive, where p and q have coordinates in [0, 500)
  * reflexive, where p and q have coordinates in [0, 32768)
  * antisymmetric, where p, q, and r have coordinates in [0, 500)
  * antisymmetric, where p, q, and r have coordinates in [0, 32768)
  * transitive, where p, q, r, and s have coordinates in [0, 500)
  * transitive, where p, q, r, and s have coordinates in [0, 32768)
  * sign of compare(), where p, q, and r have coordinates in [0, 500)
  * sign of compare(), where p, q, and r have coordinates in [0, 32768)
  * sign of compare(), where p, q, and r have coordinates in [0, 10)
  * throw java.lang.NullPointerException if either argument is null
==> passed


Total: 3/3 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference Point and LineSegment)
********************************************************************************

Testing correctness of BruteCollinearPoints
*-----------------------------------------------------------
Running 17 total tests.

The inputs satisfy the following conditions:
  - no duplicate points
  - no 5 (or more) points are collinear
  - all x- and y-coordinates between 0 and 32,767

Test 1: points from a file
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 2a: points from a file with horizontal line segments
  * filename = horizontal5.txt
  * filename = horizontal25.txt
==> passed

Test 2b: random horizontal line segments
  *  1 random horizontal line segment
  *  5 random horizontal line segments
  * 10 random horizontal line segments
  * 15 random horizontal line segments
==> passed

Test 3a: points from a file with vertical line segments
  * filename = vertical5.txt
  * filename = vertical25.txt
==> passed

Test 3b: random vertical line segments
  *  1 random vertical line segment
  *  5 random vertical line segments
  * 10 random vertical line segments
  * 15 random vertical line segments
==> passed

Test 4a: points from a file with no line segments
  * filename = random23.txt
  * filename = random38.txt
==> passed

Test 4b: random points with no line segments
  *  5 random points
  * 10 random points
  * 20 random points
  * 50 random points
==> passed

Test 5: points from a file with fewer than 4 points
  * filename = input1.txt
  * filename = input2.txt
  * filename = input3.txt
==> passed

Test 6: check for dependence on either compareTo() or compare()
        returning { -1, +1, 0 } instead of { negative integer,
        positive integer, zero }
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 7: check for fragile dependence on return value of toString()
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 8: random line segments, none vertical or horizontal
  *  1 random line segment
  *  5 random line segments
  * 10 random line segments
  * 15 random line segments
==> passed

Test 9: random line segments
  *  1 random line segment
  *  5 random line segments
  * 10 random line segments
  * 15 random line segments
==> passed

Test 10: check that data type is immutable by testing whether each method
         returns the same value, regardless of any intervening operations
  * input8.txt
    java.lang.NullPointerException

    BruteCollinearPoints.segments(BruteCollinearPoints.java:41)
    TestBruteCollinearPoints.testImmutable(TestBruteCollinearPoints.java:458)
    TestBruteCollinearPoints.testImmutable(TestBruteCollinearPoints.java:516)
    TestBruteCollinearPoints.test10(TestBruteCollinearPoints.java:531)
    TestBruteCollinearPoints.main(TestBruteCollinearPoints.java:753)

    - sequence of operations was:
          BruteCollinearPoints collinear = new BruteCollinearPoints(points);
          collinear.segments()
          mutate points[] array that was passed to constructor
          collinear.numberOfSegments() -> 2
          mutate array returned by last call to segments()
          collinear.segments()

    - failed on trial 1 of 100

  * equidistant.txt
    java.lang.NullPointerException

    BruteCollinearPoints.segments(BruteCollinearPoints.java:41)
    TestBruteCollinearPoints.testImmutable(TestBruteCollinearPoints.java:458)
    TestBruteCollinearPoints.testImmutable(TestBruteCollinearPoints.java:516)
    TestBruteCollinearPoints.test10(TestBruteCollinearPoints.java:532)
    TestBruteCollinearPoints.main(TestBruteCollinearPoints.java:753)

    - sequence of operations was:
          BruteCollinearPoints collinear = new BruteCollinearPoints(points);
          collinear.numberOfSegments() -> 0
          mutate points[] array that was passed to constructor
          collinear.segments()

    - failed on trial 1 of 100

==> FAILED

Test 11: check that data type does not mutate the constructor argument
  * input8.txt
  * equidistant.txt
==> passed

Test 12: numberOfSegments() is consistent with segments()
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = horizontal5.txt
  * filename = vertical5.txt
  * filename = random23.txt
==> passed

Test 13: throws an exception if either the constructor argument is null
         or any entry in array is null
  * argument is null
  * Point[] of length 10, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     10
      9041  2933
     null
     27741 28556
     29039 22039
     19552 22408
     22152  1954
      1553 23149
     25131 13663
     27576   294
     22774 27474

  * Point[] of length 10, number of null entries = 10
  * Point[] of length 4, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     4
     30174    31
     null
     28163 13083
     13387 27792

  * Point[] of length 3, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     3
     27758 11482
      2937  9087
     null

  * Point[] of length 2, number of null entries = 1
  * Point[] of length 1, number of null entries = 1
==> FAILED

Test 14: check that the constructor throws an exception if duplicate points
  * 50 points
  * 25 points
  * 5 points
  * 4 points
  * 3 points
  * 2 points
==> passed


Total: 15/17 tests passed!


================================================================
Testing correctness of FastCollinearPoints
*-----------------------------------------------------------
Running 21 total tests.

The inputs satisfy the following conditions:
  - no duplicate points
  - all x- and y-coordinates between 0 and 32,767

Test 1: points from a file
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = input299.txt
==> passed

Test 2a: points from a file with horizontal line segments
  * filename = horizontal5.txt
  * filename = horizontal25.txt
  * filename = horizontal50.txt
  * filename = horizontal75.txt
  * filename = horizontal100.txt
==> passed

Test 2b: random horizontal line segments
  *  1 random horizontal line segment
  *  5 random horizontal line segments
  * 10 random horizontal line segments
  * 15 random horizontal line segments
==> passed

Test 3a: points from a file with vertical line segments
  * filename = vertical5.txt
  * filename = vertical25.txt
  * filename = vertical50.txt
  * filename = vertical75.txt
  * filename = vertical100.txt
==> passed

Test 3b: random vertical line segments
  *  1 random vertical line segment
  *  5 random vertical line segments
  * 10 random vertical line segments
  * 15 random vertical line segments
==> passed

Test 4a: points from a file with no line segments
  * filename = random23.txt
  * filename = random38.txt
  * filename = random91.txt
  * filename = random152.txt
==> passed

Test 4b: random points with no line segments
  *  5 random points
  * 10 random points
  * 20 random points
  * 50 random points
==> passed

Test 5a: points from a file with 5 or more on some line segments
  * filename = input9.txt
  * filename = input10.txt
  * filename = input20.txt
  * filename = input50.txt
  * filename = input80.txt
  * filename = input300.txt
  * filename = inarow.txt
==> passed

Test 5b: points from a file with 5 or more on some line segments
  * filename = kw1260.txt
  * filename = rs1423.txt
==> passed

Test 6: points from a file with fewer than 4 points
  * filename = input1.txt
  * filename = input2.txt
  * filename = input3.txt
==> passed

Test 7: check for dependence on either compareTo() or compare()
        returning { -1, +1, 0 } instead of { negative integer,
        positive integer, zero }
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = input299.txt
==> passed

Test 8: check for fragile dependence on return value of toString()
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 9: random line segments, none vertical or horizontal
  *  1 random line segment
  *  5 random line segments
  * 25 random line segments
  * 50 random line segments
  * 100 random line segments
==> passed

Test 10: random line segments
  *  1 random line segment
  *  5 random line segments
  * 25 random line segments
  * 50 random line segments
  * 100 random line segments
==> passed

Test 11: random distinct points in a given range
  * 5 random points in a 10-by-10 grid
  * 10 random points in a 10-by-10 grid
  * 50 random points in a 10-by-10 grid
    java.lang.ArrayIndexOutOfBoundsException: 50

    FastCollinearPoints.segments(FastCollinearPoints.java:52)
    TestFastCollinearPoints.testSegments(TestFastCollinearPoints.java:109)
    TestFastCollinearPoints.randomPointsInRange(TestFastCollinearPoints.java:428)
    TestFastCollinearPoints.test11(TestFastCollinearPoints.java:448)
    TestFastCollinearPoints.main(TestFastCollinearPoints.java:821)

    - failed on trial 55 of 100

  * 90 random points in a 10-by-10 grid
    java.lang.ArrayIndexOutOfBoundsException: 90

    FastCollinearPoints.segments(FastCollinearPoints.java:52)
    TestFastCollinearPoints.testSegments(TestFastCollinearPoints.java:109)
    TestFastCollinearPoints.randomPointsInRange(TestFastCollinearPoints.java:428)
    TestFastCollinearPoints.test11(TestFastCollinearPoints.java:449)
    TestFastCollinearPoints.main(TestFastCollinearPoints.java:821)

    - failed on trial 1 of 50

  * 200 random points in a 50-by-50 grid
    java.lang.ArrayIndexOutOfBoundsException: 200

    FastCollinearPoints.segments(FastCollinearPoints.java:52)
    TestFastCollinearPoints.testSegments(TestFastCollinearPoints.java:109)
    TestFastCollinearPoints.randomPointsInRange(TestFastCollinearPoints.java:428)
    TestFastCollinearPoints.test11(TestFastCollinearPoints.java:450)
    TestFastCollinearPoints.main(TestFastCollinearPoints.java:821)

    - failed on trial 1 of 10

==> FAILED

Test 12: m*n points on an m-by-n grid
  * 3-by-3 grid
  * 4-by-4 grid
  * 5-by-5 grid
  * 10-by-10 grid
    java.lang.ArrayIndexOutOfBoundsException: 100

    FastCollinearPoints.segments(FastCollinearPoints.java:52)
    TestFastCollinearPoints.testSegments(TestFastCollinearPoints.java:109)
    TestFastCollinearPoints.grid(TestFastCollinearPoints.java:457)
    TestFastCollinearPoints.test12(TestFastCollinearPoints.java:465)
    TestFastCollinearPoints.main(TestFastCollinearPoints.java:824)

  * 20-by-20 grid
    java.lang.ArrayIndexOutOfBoundsException: 400

    FastCollinearPoints.segments(FastCollinearPoints.java:52)
    TestFastCollinearPoints.testSegments(TestFastCollinearPoints.java:109)
    TestFastCollinearPoints.grid(TestFastCollinearPoints.java:457)
    TestFastCollinearPoints.test12(TestFastCollinearPoints.java:466)
    TestFastCollinearPoints.main(TestFastCollinearPoints.java:824)

  * 5-by-4 grid
  * 6-by-4 grid
  * 10-by-4 grid
  * 15-by-4 grid
    java.lang.ArrayIndexOutOfBoundsException: 60

    FastCollinearPoints.segments(FastCollinearPoints.java:75)
    TestFastCollinearPoints.testSegments(TestFastCollinearPoints.java:109)
    TestFastCollinearPoints.grid(TestFastCollinearPoints.java:457)
    TestFastCollinearPoints.test12(TestFastCollinearPoints.java:470)
    TestFastCollinearPoints.main(TestFastCollinearPoints.java:824)

  * 25-by-4 grid
    java.lang.ArrayIndexOutOfBoundsException: 100

    FastCollinearPoints.segments(FastCollinearPoints.java:75)
    TestFastCollinearPoints.testSegments(TestFastCollinearPoints.java:109)
    TestFastCollinearPoints.grid(TestFastCollinearPoints.java:457)
    TestFastCollinearPoints.test12(TestFastCollinearPoints.java:471)
    TestFastCollinearPoints.main(TestFastCollinearPoints.java:824)

==> FAILED

Test 13: check that data type is immutable by testing whether each method
         returns the same value, regardless of any intervening operations
  * input8.txt
    java.lang.NullPointerException

    java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
    java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
    java.util.Arrays.sort(Arrays.java:1246)
    FastCollinearPoints.segments(FastCollinearPoints.java:27)
    TestFastCollinearPoints.testImmutable(TestFastCollinearPoints.java:523)
    TestFastCollinearPoints.testImmutable(TestFastCollinearPoints.java:579)
    TestFastCollinearPoints.test13(TestFastCollinearPoints.java:594)
    TestFastCollinearPoints.main(TestFastCollinearPoints.java:827)

    - sequence of operations was:
          FastCollinearPoints collinear = new FastCollinearPoints(points);
          mutate points[] array that was passed to constructor
          collinear.segments()
    - failed on trial 1 of 100

  * equidistant.txt
    - failed after 3 operations involving FastCollinearPoints
    - first and last call to segments() returned different arrays
    - sequence of operations was:
          FastCollinearPoints collinear = new FastCollinearPoints(points);
          collinear.segments()
          collinear.segments()
    - failed on trial 1 of 100

==> FAILED

Test 14: check that data type does not mutate the constructor argument
  * input8.txt
  * equidistant.txt
==> passed

Test 15: numberOfSegments() is consistent with segments()
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = horizontal5.txt
  * filename = vertical5.txt
  * filename = random23.txt
==> passed

Test 16: throws an exception if either constructor argument is null
         or any entry in array is null
  * argument is null
    - constructor fails to throw an exception
     0

  * Point[] of length 10, number of null entries = 1
    - constructor fails to throw an exception
     10
     26155 15610
        10 13964
     10422  5616
      2582 15213
     25790 28393
     null
      3398  5240
      6524 16588
     26500 15450
     16807  7886

  * Point[] of length 10, number of null entries = 10
    - constructor fails to throw an exception
     10
     null
     null
     null
     null
     null
     null
     null
     null
     null
     null

  * Point[] of length 4, number of null entries = 1
    - constructor fails to throw an exception
     4
     21872   897
      5813 14036
      8352  1281
     null

  * Point[] of length 3, number of null entries = 1
    - constructor fails to throw an exception
     3
     19548 15355
     null
      8907 31381

  * Point[] of length 2, number of null entries = 1
    - constructor fails to throw an exception
     2
     null
      3944 22937

  * Point[] of length 1, number of null entries = 1
    - constructor fails to throw an exception
     1
     null

==> FAILED

Test 17: check that the constructor throws an exception if duplicate points
  * 50 points
    - failed on trial 1 of 5
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points


  * 25 points
    - failed on trial 1 of 10
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points


  * 5 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

     5
     10613  2322
      6267  7915
     20245 15958
     10613  2322
       838   212

  * 4 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

     4
     27877 20033
      3527  4985
     27877 20033
     26221 23264

  * 3 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

     3
     13600  1041
     25986 31326
     25986 31326

  * 2 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

     2
     30692 14466
     30692 14466

==> FAILED


Total: 16/21 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Point
*-----------------------------------------------------------
Running 1 total tests.

The maximum amount of memory per Point object is 32 bytes.

Student memory = 24 bytes (passed)

Total: 1/1 tests passed!

================================================================



********************************************************************************
*  TIMING                                                                  
********************************************************************************

Timing BruteCollinearPoints
*-----------------------------------------------------------
Running 10 total tests.

Test 1a-1e: Find collinear points among n random distinct points


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    16   0.00        5460           0           5460                  120         
=> passed    32   0.01      107880           0         107880                  496         
=> passed    64   0.02     1906128           0        1906128                 2016         
=> passed   128   0.04    32004000           0       32004000                 8128         
=> passed   256   0.52   524377920           0      524377920                32640         
==> 5/5 tests passed

Test 2a-2e: Find collinear points among n/4 arbitrary line segments


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    16   0.00        5460           0           5460                  143         
=> passed    32   0.01      107880           0         107880                  542         
=> passed    64   0.03     1906128           0        1906128                 2097         
=> passed   128   0.14    32004000           0       32004000                 8305         
=> passed   256   2.44   524377920           0      524377920                32982         
==> 5/5 tests passed

Total: 10/10 tests passed!


================================================================



Timing FastCollinearPoints
*-----------------------------------------------------------
Running 31 total tests.

Test 1a-1g: Find collinear points among n random distinct points


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.01        7936       18631          45198                  302         
=> passed   128   0.01       32256       88525         209306                  737         
=> passed   256   0.03      130048      415737         961522                 1722         
=> passed   512   0.15      522240     1895995        4314230                 3966         
=> passed  1024   0.33     2093056     8549290       19191636                 8960         
=> passed  2048   0.93     8380416    38050762       84481940                19989         
==> 6/6 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (84481940 / 19191636) = 2.14
=> passed

==> 7/7 tests passed

Test 2a-2g: Find collinear points among the n points on an n-by-1 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00        7936        4764          17464                 7049         
=> passed   128   0.00       32256       17796          67848                22968         
=> passed   256   0.01      130048       68717         267482                79811         
=> passed   512   0.02      522240      269399        1061038               292564         
=> passed  1024   0.07     2093056     1065026        4223108              1112882         
=> passed  2048   0.12     8380416     4231214       16842844              4329524         
=> passed  4096   0.46    33538048    16859163       67256374             17060366         
==> 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (67256374 / 16842844) = 2.00
=> passed

==> 8/8 tests passed

Test 3a-3g: Find collinear points among the n points on an n/4-by-4 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
    java.lang.ArrayIndexOutOfBoundsException: 64

    FastCollinearPoints.segments(FastCollinearPoints.java:75)
    TimeFastCollinearPoints.timingTest(TimeFastCollinearPoints.java:94)
    TimeFastCollinearPoints.time(TimeFastCollinearPoints.java:221)
    TimeFastCollinearPoints.timeGrid4(TimeFastCollinearPoints.java:178)
    TimeFastCollinearPoints.main(TimeFastCollinearPoints.java:279)

Test 4a-4g: Find collinear points among the n points on an n/8-by-8 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
    java.lang.ArrayIndexOutOfBoundsException: 64

    FastCollinearPoints.segments(FastCollinearPoints.java:52)
    TimeFastCollinearPoints.timingTest(TimeFastCollinearPoints.java:94)
    TimeFastCollinearPoints.time(TimeFastCollinearPoints.java:221)
    TimeFastCollinearPoints.timeGrid8(TimeFastCollinearPoints.java:203)
    TimeFastCollinearPoints.main(TimeFastCollinearPoints.java:283)

Total: 15/31 tests passed!


================================================================



