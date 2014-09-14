"""
Shashank likes strings in which consecutive characters are different. For example, he likes ABABA, while he doesn't like ABAA. Given a string containing characters A and B only, he wants to change it into a string he likes. To do this, he is allowed to delete the characters in the string.

Your task is to find the minimum number of required deletions.

Input Format 
The first line contains an integer T i.e. the number of test cases. 
Next T lines contain a string each.

Output Format 
Print minimum number of required steps for each test case.

Constraints

1<=T<=10 
1<=lengthofString<=10^5 

Sample Input

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB

Sample Output

3
4
0
0
4
"""
def delete_process(str_list):
    i=0
    delete_flag = 0
    while i < len(str_list):
        if i+1 < len(str_list) and str_list[i] == str_list[i+1]:
            del str_list[i]
            delete_flag += 1
        i+=1
    return str_list, delete_flag       
ntests = int(raw_input())
strings = []
for i in range(0,ntests):
    strings.append(raw_input())
for string in strings:
    str_list = list(string)
    delete_count = 0
    delete_flag = 1
    while delete_flag > 0:
        str_list, delete_flag = delete_process(str_list)
        delete_count += delete_flag
    print delete_count
