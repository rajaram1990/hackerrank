"""
Problem Statement 
You are given a number N, you need to print the number of positions where digits exactly divides N.

Input format

The first line contains T (number of test cases followed by T lines each containing N).

Constraints 
1 <=T <= 15 
0 < N < 1010

Output Format 
Number of positions in N where digits in that number exactly divides the number N.

Input

1  
12
Output

2
Explanation 
2 digits in the number 12 divide the number exactly. Digits at ten's place, 1, divides 12 exactly in 12 parts, and digit at one's place, 2 divides 12 equally in 6 parts.
"""
ntests = int(raw_input())
tests = []
for i in range(0,ntests):
    tests.append(int(raw_input()))
for test in tests:
    str_digits = str(test)
    count=0
    for digit in str_digits:
        if digit != '0' and test%int(digit)==0:
            count+=1
    print count
