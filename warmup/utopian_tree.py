"""
The Utopian tree goes through 2 cycles of growth every year. The first growth cycle of the tree occurs during the monsoon, when it doubles in height. The second growth cycle of the tree occurs during the summer, when its height increases by 1 meter. 
Now, a new Utopian tree sapling is planted at the onset of the monsoon. Its height is 1 meter. Can you find the height of the tree after N growth cycles?

Input Format 
The first line contains an integer, T, the number of test cases. 
T lines follow. Each line contains an integer, N, that denotes the number of cycles for that test case.

Constraints 
1 <= T <= 10 
0 <= N <= 60

Output Format 
For each test case, print the height of the Utopian tree after N cycles.

Sample Input: #01:

2
3
4
Sample Output: #01:

6
7
Explanation: #01: 
There are 2 testcases. 
N = 3: 
the height of the tree at the end of the 1st cycle = 2 
the height of the tree at the end of the 2nd cycle = 3 
the height of the tree at the end of the 3rd cycle = 6

N = 4: 
the height of the tree at the end of the 4th cycle = 7
"""
ntests = int(raw_input())
tests = []
for i in range(0,ntests):
    tests.append(int(raw_input()))
for i in tests:
    height = 1
    for j in range(1,i+1):
        if j%2 == 1:
            height*=2
        else:
            height+=1
    print height
