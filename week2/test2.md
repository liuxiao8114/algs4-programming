See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED (0 errors, 3 warnings)
API:          PASSED

Findbugs:     FAILED (3 warnings)
PMD:          PASSED
Checkstyle:   FAILED (0 errors, 31 warnings)

Correctness:  36/43 tests passed
Memory:       51/53 tests passed
Timing:       124/136 tests passed

Aggregate score: 88.09%
[Compilation: 5%, API: 5%, Findbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
2.9K Sep 22 08:29 Deque.java
 727 Sep 22 08:29 Permutation.java
3.7K Sep 22 08:29 RandomizedQueue.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Deque.java
*-----------------------------------------------------------

% javac RandomizedQueue.java
*-----------------------------------------------------------
RandomizedQueue.java:14: warning: [unchecked] unchecked cast
    items = (Item[])new Object[2];
                    ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
RandomizedQueue.java:24: warning: [unchecked] unchecked cast
      randomItems = (Item[])new Object[n];
                            ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
RandomizedQueue.java:79: warning: [unchecked] unchecked cast
    Item[] temp = (Item[])new Object[newSize];
                          ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
3 warnings

% javac Permutation.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Deque:

RandomizedQueue:

Permutation:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% findbugs *.class
*-----------------------------------------------------------
M D DMI_HARDCODED_ABSOLUTE_FILENAME DMI: Contains a hard-coded reference to an absolute pathname.  At RandomizedQueue.java:[line 108]
H D DLS_DEAD_LOCAL_STORE DLS: Assigns a value to the local variable 'q' but that value is never used.  At Deque.java:[line 129]
L D UC_USELESS_VOID_METHOD UC: The void method 'main()' appears to serve no purpose.  At Deque.java:[line 131]
Warnings generated: 3


================================================================


% pmd .
*-----------------------------------------------------------
Deque.java:129: Avoid unused local variables, such as 'q'. [UnusedLocalVariable]
RandomizedQueue.java:20: The private instance (or static) variable 'randomItems' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
PMD ends with 2 warnings.


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] Deque.java:5:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] Deque.java:32:10: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] Deque.java:33:10: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] Deque.java:50:10: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] Deque.java:51:10: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] Deque.java:65:10: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] Deque.java:70:10: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] Deque.java:82:10: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] Deque.java:87:10: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] Deque.java:97:57: '>' is followed by an illegal character. [GenericWhitespace]
[WARN] Deque.java:97:57: '{' is not preceded with whitespace. [WhitespaceAround]
[WARN] Deque.java:108:14: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] Permutation.java:3:8: Unused import statement for 'edu.princeton.cs.algs4.In'. [UnusedImports]
[WARN] Permutation.java:8:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] Permutation.java:19:15: 'assert' is not followed by whitespace. [WhitespaceAround]
[WARN] Permutation.java:23:12: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] RandomizedQueue.java:9:1: File contains tab characters (this is the first occurrence). Configure your editor to replace tabs with spaces. [FileTabCharacter]
[WARN] RandomizedQueue.java:14:25: Typecast is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:24:35: Typecast is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:25:16: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] RandomizedQueue.java:41:15: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] RandomizedQueue.java:69:11: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] RandomizedQueue.java:70:11: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] RandomizedQueue.java:79:31: Typecast is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:81:12: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] RandomizedQueue.java:90:11: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] RandomizedQueue.java:94:11: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] RandomizedQueue.java:102:11: 'if' is not followed by whitespace. [WhitespaceAround]
[WARN] RandomizedQueue.java:112:12: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] RandomizedQueue.java:121:14: 'while' is not followed by whitespace. [WhitespaceAround]
[WARN] RandomizedQueue.java:127:14: 'while' is not followed by whitespace. [WhitespaceAround]
Checkstyle ends with 0 errors and 31 warnings.

% custom checkstyle checks for Deque.java
*-----------------------------------------------------------

% custom checkstyle checks for RandomizedQueue.java
*-----------------------------------------------------------

% custom checkstyle checks for Permutation.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Deque
*-----------------------------------------------------------
Running 16 total tests.

Tests 1-6 make random calls to addFirst(), addLast(), removeFirst(),
removeLast(), isEmpty(), and size(). The probabilities of each
operation are (p1, p2, p3, p4, p5, p6), respectively.

Test 1: check random calls to addFirst(), addLast(), and size()
  *    5 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2)
    - student   size() returned 4
    - reference size() returned 3
    - sequence of dequeue operations was:
         deque.size()
         deque.addLast(1)
         deque.addLast(2)
         deque.addFirst(3)
         deque.size()

  *   50 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2)
    - student   size() returned 3
    - reference size() returned 2
    - sequence of dequeue operations was:
         deque.size()
         deque.size()
         deque.addLast(2)
         deque.addLast(3)
         deque.size()

  *  500 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2)
  * 1000 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2)
    - student   size() returned 3
    - reference size() returned 2
    - sequence of dequeue operations was:
         deque.addLast(0)
         deque.addLast(1)
         deque.size()

==> FAILED

Test 2: check random calls to addFirst(), removeFirst(), and isEmpty()
  *    5 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0)
  *   50 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0)
  *  500 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0)
  * 1000 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0)
  *    5 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0)
  *   50 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0)
  *  500 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0)
  * 1000 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0)
==> passed

Test 3: check random calls to addFirst(), removeLast(), and isEmpty()
  *    5 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0)
  *   50 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0)
  *  500 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0)
  * 1000 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0)
  *    5 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0)
  *   50 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0)
  *  500 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0)
  * 1000 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0)
==> passed

Test 4: check random calls to addLast(), removeLast(), and isEmpty()
  *    5 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0)
  *   50 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0)
  *  500 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0)
  * 1000 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0)
  *    5 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0)
  *   50 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0)
  *  500 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0)
  * 1000 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0)
==> passed

Test 5: check random calls to addLast(), removeFirst(), and isEmpty()
  *    5 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0)
  *   50 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0)
    - failed on operation 17 of 50
    - student   removeFirst() returned 16
    - reference removeFirst() returned 1

  *  500 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0)
    - student   isEmpty() returned true
    - reference isEmpty() returned false
    - sequence of dequeue operations was:
         deque.addLast(0)
         deque.isEmpty()
         deque.addLast(2)
         deque.removeFirst()     ==> 0
         deque.isEmpty()

  * 1000 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0)
    java.util.NoSuchElementException: cannot find first item because of empty

    Deque.removeFirst(Deque.java:66)
    TestDeque.random(TestDeque.java:69)
    TestDeque.test5(TestDeque.java:216)
    TestDeque.main(TestDeque.java:770)

    - sequence of dequeue operations was:
         deque.addLast(0)
         deque.addLast(1)
         deque.addLast(2)
         deque.addLast(3)
         deque.addLast(4)
         deque.addLast(5)
         deque.isEmpty()
         deque.addLast(7)
         deque.isEmpty()
         deque.removeFirst()     ==> 0
         deque.removeFirst()

  *    5 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0)
  *   50 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0)
    java.util.NoSuchElementException: cannot find first item because of empty

    Deque.removeFirst(Deque.java:66)
    TestDeque.random(TestDeque.java:69)
    TestDeque.test5(TestDeque.java:218)
    TestDeque.main(TestDeque.java:770)

  *  500 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0)
    java.util.NoSuchElementException: cannot find first item because of empty

    Deque.removeFirst(Deque.java:66)
    TestDeque.random(TestDeque.java:69)
    TestDeque.test5(TestDeque.java:219)
    TestDeque.main(TestDeque.java:770)

    - sequence of dequeue operations was:
         deque.addLast(0)
         deque.removeFirst()     ==> 0
         deque.addLast(2)
         deque.removeFirst()     ==> 2
         deque.isEmpty()
         deque.isEmpty()
         deque.addLast(6)
         deque.removeFirst()     ==> 6
         deque.addLast(8)
         deque.addLast(9)
         deque.removeFirst()     ==> 8
         deque.removeFirst()

  * 1000 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0)
    java.util.NoSuchElementException: cannot find first item because of empty

    Deque.removeFirst(Deque.java:66)
    TestDeque.random(TestDeque.java:69)
    TestDeque.test5(TestDeque.java:220)
    TestDeque.main(TestDeque.java:770)

    - sequence of dequeue operations was:
         deque.isEmpty()
         deque.addLast(1)
         deque.addLast(2)
         deque.removeFirst()     ==> 1
         deque.removeFirst()

==> FAILED

Test 6: check random calls to addFirst(), addLast(), removeFirst(),
        removeLast(), isEmpty(), and size()
  *    5 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
  *   50 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
  *  500 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
    - failed on operation 23 of 500
    - student   removeLast() returned 15
    - reference removeLast() returned 13

  * 1000 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
    - student   size() returned 2
    - reference size() returned 1
    - sequence of dequeue operations was:
         deque.addFirst(0)
         deque.removeLast()      ==> 0
         deque.isEmpty()
         deque.addLast(3)
         deque.size()

  *    5 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1)
    - student   size() returned 3
    - reference size() returned 1
    - sequence of dequeue operations was:
         deque.addLast(0)
         deque.removeLast()      ==> 0
         deque.isEmpty()
         deque.addLast(3)
         deque.size()

  *   50 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1)
    - student   size() returned 2
    - reference size() returned 0
    - sequence of dequeue operations was:
         deque.addLast(0)
         deque.removeLast()      ==> 0
         deque.addLast(2)
         deque.removeLast()      ==> 2
         deque.addFirst(4)
         deque.addLast(5)
         deque.removeLast()      ==> 5
         deque.addFirst(7)
         deque.removeFirst()     ==> 7
         deque.removeFirst()     ==> 4
         deque.isEmpty()
         deque.size()

  *  500 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1)
    - student   size() returned 1
    - reference size() returned 0
    - sequence of dequeue operations was:
         deque.size()
         deque.size()
         deque.addLast(2)
         deque.removeLast()      ==> 2
         deque.size()

  * 1000 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1)
    - student   size() returned 3
    - reference size() returned 2
    - sequence of dequeue operations was:
         deque.isEmpty()
         deque.addFirst(1)
         deque.size()
         deque.removeFirst()     ==> 1
         deque.isEmpty()
         deque.addLast(5)
         deque.addFirst(6)
         deque.size()

==> FAILED

Test 7: check removeFirst() and removeLast() from an empty deque
  * removeFirst()
  * removeLast()
==> passed

Test 8: check where two Deque objects can be created at the same time
==> passed

Test 9: check iterator() after calls only to addFirst()
==> passed

Test 10: check iterator() after intermixed calls to addFirst(), addLast(),
         removeFirst(), and removeLast()
    - number of student   entries = 1
    - number of reference entries = 2
    - iterator failed after applying operation 2

    - sequence of dequeue operations was:
          deque.addLast(1)
          deque.addLast(2)


==> FAILED

Test 11: create two nested iterators to same deque
  * n = 10
  size() returns wrong result
    - student   = 2
    - reference = 1
    - failed on 0th addFirst() operation in deque
  * n = 1000
  size() returns wrong result
    - student   = 2
    - reference = 1
    - failed on 0th addFirst() operation in deque
==> FAILED

Test 12: create two parallel iterators to same deque
  * n = 10
  size() returns wrong result
    - student   = 2
    - reference = 1
    - failed on 0th addFirst() operation in deque
  * n = 1000
  size() returns wrong result
    - student   = 2
    - reference = 1
    - failed on 0th addFirst() operation in deque
==> FAILED

Test 13: create Deque objects of different parameterized types
==> passed

Test 14: call addFirst() and addLast() with null argument
==> passed

Test 15: check that remove() and next() throw the specified exceptions in iterator()
==> passed

Test 16: check iterator() when Deque is empty
==> passed


Total: 10/16 tests passed!


================================================================
Testing correctness of RandomizedQueue
*-----------------------------------------------------------
Running 18 total tests.

Tests 1-4 make random calls to enqueue(), dequeue(), sample(),
isEmpty(), and size(). The probabilities of each operation are
(p1, p2, p3, p4, p5), respectively.

Test 1: check random calls to enqueue() and size()
  *    5 random calls (0.8, 0.0, 0.0, 0.0, 0.2)
  *   50 random calls (0.8, 0.0, 0.0, 0.0, 0.2)
  *  500 random calls (0.8, 0.0, 0.0, 0.0, 0.2)
  * 1000 random calls (0.8, 0.0, 0.0, 0.0, 0.2)
==> passed

Test 2: check random calls to enqueue() and dequeue()
  *    5 random calls (0.7, 0.1, 0.0, 0.1, 0.1)
  *   50 random calls (0.7, 0.1, 0.0, 0.1, 0.1)
  *  500 random calls (0.7, 0.1, 0.0, 0.1, 0.1)
  * 1000 random calls (0.7, 0.1, 0.0, 0.1, 0.1)
  *    5 random calls (0.1, 0.7, 0.0, 0.1, 0.1)
  *   50 random calls (0.1, 0.7, 0.0, 0.1, 0.1)
  *  500 random calls (0.1, 0.7, 0.0, 0.1, 0.1)
  * 1000 random calls (0.1, 0.7, 0.0, 0.1, 0.1)
==> passed

Test 3: check random calls to enqueue(), sample(), and size()
  *    5 random calls (0.8, 0.0, 0.1, 0.0, 0.1)
  *   50 random calls (0.8, 0.0, 0.1, 0.0, 0.1)
  *  500 random calls (0.8, 0.0, 0.1, 0.0, 0.1)
  * 1000 random calls (0.8, 0.0, 0.1, 0.0, 0.1)
  *    5 random calls (0.1, 0.0, 0.8, 0.0, 0.1)
  *   50 random calls (0.1, 0.0, 0.8, 0.0, 0.1)
  *  500 random calls (0.1, 0.0, 0.8, 0.0, 0.1)
  * 1000 random calls (0.1, 0.0, 0.8, 0.0, 0.1)
==> passed

Test 4: check random calls to enqueue(), dequeue(), sample(), isEmpty(), and size()
  *    5 random calls (0.6, 0.1, 0.1, 0.1, 0.1)
  *   50 random calls (0.6, 0.1, 0.1, 0.1, 0.1)
  *  500 random calls (0.6, 0.1, 0.1, 0.1, 0.1)
  * 1000 random calls (0.6, 0.1, 0.1, 0.1, 0.1)
  *    5 random calls (0.1, 0.1, 0.6, 0.1, 0.1)
  *   50 random calls (0.1, 0.1, 0.6, 0.1, 0.1)
  *  500 random calls (0.1, 0.1, 0.6, 0.1, 0.1)
  * 1000 random calls (0.1, 0.1, 0.6, 0.1, 0.1)
==> passed

Test 5: call dequeue() and sample() from an empty randomized queue
  * dequeue()
  * sample()
==> passed

Test 6: create multiple randomized queue objects at the same time
==> passed

Test 7: check that iterator() returns correct items after a sequence of
        enqueue() operations
==> passed

Test 8: check that iterator() returns correct items after sequence of enqueue()
        and dequeue() operations
==> passed

Test 9: create two nested iterators over the same randomized queue
  * n = 10
  * n = 1000
==> passed

Test 10: create two parallel iterators over the same randomized queue
  * n = 10
  * n = 1000
==> passed

Test 11: create two iterators over different randomized queues
==> passed

Test 12: create RandomizedQueue objects of different parameterized types
==> passed

Test 13: check randomness of sample() by enqueueing n items, repeatedly calling
         sample(), and counting the frequency of each item
  * n = 3, trials = 12000
  * n = 5, trials = 12000
  * n = 8, trials = 12000
  * n = 10, trials = 12000
==> passed

Test 14: check randomness of dequeue() by enqueueing n items, dequeueing n items,
         and seeing whether each of the n! permutations is equally likely
  * n = 2, trials = 12000

            value  observed  expected   2*O*ln(O/E)
        -------------------------------------------
               AB         0    6000.0          0.00
               BA     12000    6000.0      16635.53
        -------------------------------------------
                      12000   12000.0      16635.53
    
    G-statistic = 16635.53 (p-value = 0.000000, reject if p-value <= 0.0001)
    Note: a correct solution will fail this test by bad luck 1 time in 10,000.

  * n = 3, trials = 12000

            value  observed  expected   2*O*ln(O/E)
        -------------------------------------------
              ABC         0    2000.0          0.00
              ACB         0    2000.0          0.00
              BAC         0    2000.0          0.00
              BCA         0    2000.0          0.00
              CAB         0    2000.0          0.00
              CBA     12000    2000.0      43002.23
        -------------------------------------------
                      12000   12000.0      43002.23
    
    G-statistic = 43002.23 (p-value = 0.000000, reject if p-value <= 0.0001)
    Note: a correct solution will fail this test by bad luck 1 time in 10,000.

  * n = 4, trials = 12000

            value  observed  expected   2*O*ln(O/E)
        -------------------------------------------
             ABCD         0     500.0          0.00
             ABDC         0     500.0          0.00
             ACBD         0     500.0          0.00
             ACDB         0     500.0          0.00
             ADBC         0     500.0          0.00
             ADCB         0     500.0          0.00
             BACD         0     500.0          0.00
             BADC         0     500.0          0.00
             BCAD         0     500.0          0.00
             BCDA         0     500.0          0.00
             BDAC         0     500.0          0.00
             BDCA         0     500.0          0.00
             CABD         0     500.0          0.00
             CADB         0     500.0          0.00
             CBAD         0     500.0          0.00
             CBDA         0     500.0          0.00
             CDAB         0     500.0          0.00
             CDBA         0     500.0          0.00
             DABC         0     500.0          0.00
             DACB         0     500.0          0.00
             DBAC         0     500.0          0.00
             DBCA         0     500.0          0.00
             DCAB         0     500.0          0.00
             DCBA     12000     500.0      76273.29
        -------------------------------------------
                      12000   12000.0      76273.29
    
    G-statistic = 76273.29 (p-value = 0.000000, reject if p-value <= 0.0001)
    Note: a correct solution will fail this test by bad luck 1 time in 10,000.

  * n = 5, trials = 12000

==> FAILED

Test 15: check randomness of iterator() by enqueueing n items, iterating over those
         n items, and seeing whether each of the n! permutations is equally likely
  * n = 2, trials = 12000
  * n = 3, trials = 12000
  * n = 4, trials = 12000
  * n = 5, trials = 12000
==> passed

Test 16: call enqueue() with a null argument
==> passed

Test 17: check that remove() and next() throw the specified exceptions in iterator()
==> passed

Test 18: check iterator() when RandomizedQueue is empty
==> passed


Total: 17/18 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference RandomizedQueue and Deque)
********************************************************************************

Testing correctness of Permutation
*-----------------------------------------------------------
Tests 1-5 call the main() function directly, resetting standard input
before each call.

Running 9 total tests.

Test 1a: check formatting for sample inputs from assignment specification
  % java Permutation 3 < distinct.txt
  E 
  F 
  H 

  % java Permutation 3 < distinct.txt
  D 
  G 
  A 

  % java Permutation 8 < duplicates.txt
  BB 
  CC 
  BB 
  BB 
  BB 
  AA 
  BB 
  CC 

==> passed

Test 1b: check formatting for other inputs
  % java Permutation 8 < mediumTale.txt
  times 
  wisdom 
  of 
  it 
  was 
  of 
  times 
  the 

  % java Permutation 0 < distinct.txt
  [no output]

==> passed

Test 2: check that main() reads all data from standard input
  * filename = distinct.txt, k = 3
  * filename = distinct.txt, k = 3
  * filename = duplicates.txt, k = 8
  * filename = mediumTale.txt, k = 8
==> passed

Test 3a: check that main() prints each item from the sequence at most once
         (for inputs with no duplicate strings)
  * filename = distinct.txt, k = 3
  * filename = distinct.txt, k = 1
  * filename = distinct.txt, k = 9
  * filename = permutation6.txt, k = 6
  * filename = permutation10.txt, k = 10
==> passed

Test 3b: check that main() prints each item from the sequence at most once
         (for inputs with duplicate strings)
  * filename = duplicates.txt, k = 8
  * filename = duplicates.txt, k = 3
  * filename = permutation8.txt, k = 6
  * filename = permutation8.txt, k = 2
  * filename = tinyTale.txt, k = 10
==> passed

Test 3c: check that main() prints each item from the sequence at most once
         (for inputs with newlines)
  * filename = mediumTale.txt, k = 10
  * filename = mediumTale.txt, k = 20
  * filename = tale.txt, k = 10
  * filename = tale.txt, k = 50
==> passed

Test 4: check main() when k = 0
  * filename = distinct.txt, k = 0
  * filename = distinct.txt, k = 0
==> passed

Test 5a: check that permutations are uniformly random
         (for inputs with no duplicate strings)
  * filename = permutation4.txt, k = 1
  * filename = permutation4.txt, k = 2
  * filename = permutation4.txt, k = 3
  * filename = permutation4.txt, k = 4
  * filename = permutation6.txt, k = 2
==> passed

Test 5b: check that permutations are uniformly random
         (for inputs with duplicate strings)
  * filename = permutation5.txt, k = 1
  * filename = permutation5.txt, k = 2
  * filename = permutation5.txt, k = 3
  * filename = duplicates.txt, k = 3
  * filename = permutation8.txt, k = 2
==> passed

Total: 9/9 tests passed!


================================================================
********************************************************************************
*  TIMING (substituting reference RandomizedQueue and Deque)                                                                  
********************************************************************************

Timing Permutation
*-----------------------------------------------------------
Running 23 total tests.

Test 1: count calls to methods in StdIn
  * java Permutation 5 < distinct.txt
  * java Permutation 10 < permutation10.txt
  * java Permutation 1 < mediumTale.txt
  * java Permutation 20 < tale.txt
  * java Permutation 100 < tale.txt
  * java Permutation 16412 < tale.txt
==> passed

Test 2: count calls to methods in Deque and RandomizedQueue
  * java Permutation 5 < distinct.txt
  * java Permutation 10 < permutation10.txt
  * java Permutation 1 < mediumTale.txt
  * java Permutation 20 < tale.txt
  * java Permutation 100 < tale.txt
  * java Permutation 16412 < tale.txt
==> passed

Test 3: count calls to methods in StdRandom
  * java Permutation 5 < distinct.txt
  * java Permutation 10 < permutation10.txt
  * java Permutation 1 < mediumTale.txt
  * java Permutation 20 < tale.txt
  * java Permutation 100 < tale.txt
  * java Permutation 16412 < tale.txt
==> passed

Test 4: Time main() with k = 5, for inputs containing n random strings

                    n  seconds
------------------------------
=> passed        1000     0.00
=> passed        2000     0.00
=> passed        4000     0.00
=> passed        8000     0.01
=> passed       16000     0.01
=> passed       32000     0.01
=> passed       64000     0.03
=> passed      128000     0.05
=> passed      256000     0.19
=> passed      512000     0.24
==> 10/10 tests passed


Test 5: Time main() with k = 1000, for inputs containing n random strings

                    n  seconds
------------------------------
=> passed        1000     0.00
=> passed        2000     0.00
=> passed        4000     0.00
=> passed        8000     0.01
=> passed       16000     0.01
=> passed       32000     0.01
=> passed       64000     0.02
=> passed      128000     0.05
=> passed      256000     0.09
=> passed      512000     0.19
==> 10/10 tests passed


Total: 23/23 tests passed!


================================================================



********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Permutation
*-----------------------------------------------------------
Running 2 total tests.

Test 1: Check that only one Deque or RandomizedQueue object is created
  * filename = distinct.txt, n = 9, k = 1
  * filename = distinct.txt, n = 9, k = 2
  * filename = distinct.txt, n = 9, k = 4
  * filename = tinyTale.txt, n = 12, k = 10
  * filename = tale.txt, n = 138653, k = 50
==> passed

Test 2: Check that the maximum size of any Deque or RandomizedQueue object
        created is between k and n
  * filename = distinct.txt, n = 9, k = 1
  * filename = distinct.txt, n = 9, k = 2
  * filename = distinct.txt, n = 9, k = 4
  * filename = tinyTale.txt, n = 12, k = 10
  * filename = tale.txt, n = 138653, k = 5
  * filename = tale.txt, n = 138653, k = 50
  * filename = tale.txt, n = 138653, k = 500
  * filename = tale.txt, n = 138653, k = 5000
  * filename = tale.txt, n = 138653, k = 50000
==> passed

Test 3 (bonus): Check that maximum size of any or Deque or RandomizedQueue object
                created is equal to k
  * filename = tale.txt, n = 138653, k = 5
    - max size of RandomizedQueue object = 138653

  * filename = tale.txt, n = 138653, k = 50
    - max size of RandomizedQueue object = 138653

  * filename = tale.txt, n = 138653, k = 500
    - max size of RandomizedQueue object = 138653

  * filename = tale.txt, n = 138653, k = 5000
    - max size of RandomizedQueue object = 138653

  * filename = tale.txt, n = 138653, k = 50000
    - max size of RandomizedQueue object = 138653

==> FAILED

Total: 2/2 tests passed!

================================================================



********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Deque
*-----------------------------------------------------------
For tests 1-4, the maximum amount of memory allowed for a Deque
containing n items is 48n + 192.

Running 28 total tests.

Test 1a-1e: Total memory usage after inserting n items,
            where n is a power of 2.

                 n        bytes
----------------------------------------------------------
=> passed        8          424         
=> passed       64         3112         
=> passed      256        12328         
=> passed     1024        49192         
=> passed     4096       196648         
==> 5/5 tests passed

Memory: 48.00 n + 40.00   (R^2 = 1.000)



Test 2a-2e: Total memory usage after inserting n+1 items,
            where n is a power of 2.

                 n        bytes
----------------------------------------------------------
=> passed        8          472         
=> passed       64         3160         
=> passed      256        12376         
=> passed     1024        49240         
=> passed     4096       196696         
==> 5/5 tests passed

Memory after adding n = 2^i + 1 items: 48.00 n + 40.00   (R^2 = 1.000)



Test 3a-3e: Total memory usage after inserting 2n+1 items
            and deleting n items, where n is a power of 2.

                 n        bytes
----------------------------------------------------------
=> passed        8          472         
=> passed       64         3160         
=> passed      256        12376         
=> passed     1024        49240         
=> passed     4096       196696         
==> 5/5 tests passed

Memory: 48.00 n + 40.00   (R^2 = 1.000)



Test 4a-4e: Total memory usage after inserting n items and then
            deleting all but one item, where n is a power of 2.
            (should not grow with n or be too large of a constant)

                 n        bytes
----------------------------------------------------------
=> passed        8           88         
=> passed       64           88         
=> passed      256           88         
=> passed     1024           88         
=> passed     4096           88         
==> 5/5 tests passed

Memory after adding n = 2^i items: 88.00   (R^2 = 1.000)



Test 5a-5e: Total memory usage of iterator after inserting n items.
            (should not grow with n or be too large of a constant)

                 n        bytes
----------------------------------------------------------
=> passed        8           32         
=> passed       64           32         
=> passed      256           32         
=> passed     1024           32         
=> passed     4096           32         
==> 5/5 tests passed

Memory of iterator after adding n = 2^i items: 32.00   (R^2 = 1.000)



Test 6a: Insert n strings; delete them one at a time, checking for
         loitering after each deletion. The probabilities of addFirst()
         and addLast() are (p1, p2), respectively. The probabilities of
         removeFirst() and removeLast() are (q1, q2), respectively
  * 100 random insertions (1.0, 0.0) and 100 random deletions (1.0, 0.0)
  * 100 random insertions (1.0, 0.0) and 100 random deletions (0.0, 1.0)
  * 100 random insertions (0.0, 1.0) and 100 random deletions (1.0, 0.0)
    java.util.NoSuchElementException: cannot find first item because of empty

    Deque.removeFirst(Deque.java:66)
    MemoryOfDeque.loiterInsertionsBeforeDeletions(MemoryOfDeque.java:448)
    MemoryOfDeque.test6a(MemoryOfDeque.java:500)
    MemoryOfDeque.main(MemoryOfDeque.java:744)

  * 100 random insertions (0.0, 1.0) and 100 random deletions (0.0, 1.0)
  * 100 random insertions (0.5, 0.5) and 100 random deletions (0.5, 0.5)
==> FAILED

Test 6b: Perform random operations, checking for loitering after
         each operation. The probabilities of addFirst(), addLast(),
         removeFirst(), and removeLast() are (p1, p2, p3, p4),
         respectively.
  * 100 random operations (0.8, 0.0, 0.2, 0.0)
  * 100 random operations (0.8, 0.0, 0.0, 0.2)
  * 100 random operations (0.0, 0.8, 0.2, 0.0)
    java.util.NoSuchElementException: cannot find first item because of empty

    Deque.removeFirst(Deque.java:66)
    MemoryOfDeque.loiter(MemoryOfDeque.java:544)
    MemoryOfDeque.test6b(MemoryOfDeque.java:626)
    MemoryOfDeque.main(MemoryOfDeque.java:745)

  * 100 random operations (0.0, 0.8, 0.0, 0.2)
  * 100 random operations (0.4, 0.4, 0.1, 0.1)
  * 100 random operations (0.2, 0.2, 0.3, 0.3)
    java.util.NoSuchElementException: cannot find first item because of empty

    Deque.removeFirst(Deque.java:66)
    MemoryOfDeque.loiter(MemoryOfDeque.java:544)
    MemoryOfDeque.test6b(MemoryOfDeque.java:629)
    MemoryOfDeque.main(MemoryOfDeque.java:745)

==> FAILED

Test 7: Worst-case constant memory allocated or deallocated
        per deque operation?
  * 128 random operations
  * 256 random operations
  * 512 random operations
==> passed

Total: 26/28 tests passed!

================================================================



Analyzing memory of RandomizedQueue
*-----------------------------------------------------------
For tests 1-4, the maximum amount of memory allowed for
a RandomizedQueue containing n items is 48n + 192.

Running 23 total tests.

Test 1a-1d: Total memory usage after inserting n integers.

                 n        bytes
----------------------------------------------------------
=> passed       64          568         
=> passed      256         2104         
=> passed     1024         8248         
=> passed     4096        32824         
==> 4/4 tests passed


Memory: 8.00 n + 56.00   (R^2 = 1.000)



Test 2a-2d: Total memory usage after inserting n+1 items.

                 n        bytes
----------------------------------------------------------
=> passed       64         1080         
=> passed      256         4152         
=> passed     1024        16440         
=> passed     4096        65592         
==> 4/4 tests passed


Memory: 16.00 n + 56.00   (R^2 = 1.000)



Test 3a-3d: Total memory usage after inserting 2n+1 items, and
            then deleting n items.

                 n        bytes
----------------------------------------------------------
=> passed       64         2104         
=> passed      256         8248         
=> passed     1024        32824         
=> passed     4096       131128         
==> 4/4 tests passed


Memory: 32.00 n + 56.00   (R^2 = 1.000)



Test 4a-4d: Total memory usage after inserting n items, and
            then deleting all but one item.

                 n        bytes
----------------------------------------------------------
=> passed       64           72         
=> passed      256           72         
=> passed     1024           72         
=> passed     4096           72         
==> 4/4 tests passed


Memory: 72.00   (R^2 = 1.000)



Test 5a-5d: Total memory usage of iterator after inserting n items.

                 n        bytes
----------------------------------------------------------
=> passed       64          576         
=> passed      256         2112         
=> passed     1024         8256         
=> passed     4096        32832         
==> 4/4 tests passed


Memory: 8.00 n + 64.00   (R^2 = 1.000)



Test 6a: Insert 100 strings; delete them one at a time, checking
         for loitering after each deletion.
==> passed

Test 6b: Perform random operations, checking for loitering after
         each operation. The probabilities of enqueue(), dequeue(),
         and sample() are (p1, p2, p3), respectively.
  * 200 random operations (0.8, 0.2, 0.0)
  * 200 random operations (0.2, 0.8, 0.0)
  * 200 random operations (0.6, 0.2, 0.2)
  * 200 random operations (0.2, 0.4, 0.4)
==> passed

Test 7: Insert T items into queue; then iterate over queue and check
        that worst-case constant memory is allocated or deallocated
        per iterator operation.
  * T = 64
  * T = 128
  * T = 256
==> passed

Total: 23/23 tests passed!

================================================================



********************************************************************************
*  TIMING                                                                  
********************************************************************************

Timing Deque
*-----------------------------------------------------------
Running 55 total tests.

Test 1a-1g: make n random calls to addFirst(), removeFirst(), isEmpty(), and size()
            with probabilities (0.7, 0.1, 0.1, 0.1)

                    n  seconds
------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.00
=> passed       65536     0.01
=> passed      128000     0.01
=> passed      256000     0.02
=> passed      512000     0.04
=> passed     1024000     0.07
=> passed     2048000     0.11
==> 12/12 tests passed


Test 2a-2g: make n random calls to addFirst(), removeFirst(), isEmpty(), and size(),
            with probabilities (0.7, 0.1, 0.1, 0.1)

                    n  seconds
------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.00
=> passed       65536     0.00
=> passed      128000     0.00
=> passed      256000     0.01
=> passed      512000     0.02
=> passed     1024000     0.04
=> passed     2048000     0.07
==> 12/12 tests passed


Test 3a-3g: make n random calls to addFirst(), addLast(), removeFirst(), removeLast(),
            isEmpty(), and size() with probabilities (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)

                    n  seconds
------------------------------
    java.util.NoSuchElementException: cannot find first item because of empty

    Deque.removeFirst(Deque.java:66)
    TimeDeque.timeRandomOperations(TimeDeque.java:35)
    TimeDeque.timeRandomOperations(TimeDeque.java:126)
    TimeDeque.test3(TimeDeque.java:180)
    TimeDeque.main(TimeDeque.java:259)

=> FAILED        1024     0.00
   [ Most likely one of your operations is not constant time. ]
==> 0/12 tests passed


Test 4a-4g: create a deque of n objects, then iterate over the n objects
            by calling next() and hasNext().

                    n  seconds
------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.00
=> passed       65536     0.00
=> passed      128000     0.00
=> passed      256000     0.00
=> passed      512000     0.01
=> passed     1024000     0.04
=> passed     2048000     0.12
==> 12/12 tests passed


Test 5a-5g: create a deque of n objects, then interleave n calls each to
            removeFirst()/removeLast() and addFirst()/addLast().

                    n  seconds
----------------------------------
=> passed        1025     0.00
=> passed        2049     0.00
=> passed        4097     0.00
=> passed       16385     0.00
=> passed       32767     0.00
=> passed       32768     0.00
=> passed       32769     0.00
==> 7/7 tests passed

Total: 43/55 tests passed!


================================================================



Timing RandomizedQueue
*-----------------------------------------------------------
Running 58 total tests.

Test 1: call enqueue() and dequeue() n times each; count calls to StdRandom
  * n = 10
  * n = 100
  * n = 1000
==> passed

Test 2: call sample() n times and count calls to StdRandom
  * n = 10
  * n = 100
  * n = 1000
==> passed

Test 3: iterate over queue of size n and count calls to StdRandom
  * n = 10
  * n = 100
  * n = 1000
==> passed

Test 4a-g: make n random calls to enqueue(), sample(), dequeue(), isEmpty(),
           and size() with probabilities (0.2, 0.2, 0.2, 0.2, 0.2)

                    n  seconds
----------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.00
=> passed       65536     0.00
=> passed      128000     0.01
=> passed      256000     0.01
=> passed      512000     0.02
=> passed     1024000     0.04
=> passed     2048000     0.08
==> 12/12 tests passed


Test 5a-g: make n random calls to enqueue(), sample(), dequeue(), isEmpty(),
           and size() with probabilities (0.6, 0.1, 0.1, 0.1, 0.1)

                    n  seconds
----------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.00
=> passed       65536     0.00
=> passed      128000     0.01
=> passed      256000     0.01
=> passed      512000     0.03
=> passed     1024000     0.06
=> passed     2048000     0.11
==> 12/12 tests passed


Test 6a-g: make n random calls to enqueue(), sample(), dequeue(), isEmpty(),
           and size() with probabilities (0.1, 0.1, 0.6, 0.1, 0.1)

                    n  seconds
----------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.00
=> passed       65536     0.00
=> passed      128000     0.01
=> passed      256000     0.01
=> passed      512000     0.02
=> passed     1024000     0.04
=> passed     2048000     0.08
==> 12/12 tests passed


Test 7a-g: create randomized queue of n objects, then iterate
           over the n objects by calling next() and hasNext().

                    n  seconds
----------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.01
=> passed       32768     0.00
=> passed       65536     0.01
=> passed      128000     0.01
=> passed      256000     0.02
=> passed      512000     0.03
=> passed     1024000     0.05
=> passed     2048000     0.10
==> 12/12 tests passed


Test 8a-g: create randomized queue of n objects, then interleave
           n calls each to dequeue() and enqueue().

                    n  seconds
----------------------------------
=> passed        1025     0.00
=> passed        2049     0.00
=> passed        4097     0.00
=> passed       16385     0.00
=> passed       32767     0.00
=> passed       32768     0.00
=> passed       32769     0.00
==> 7/7 tests passed

Total: 58/58 tests passed!


================================================================

