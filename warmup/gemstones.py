"""John has discovered various rocks. Each rock is composed of various elements, and each element is represented by a lowercase latin letter from 'a' to 'z'. An element can be present multiple times in a rock. An element is called a 'gem-element' if it occurs at least once in each of the rocks.

Given the list of N rocks with their compositions, display the number of gem-elements that exist in those rocks.

Input Format 
The first line consists of N, the number of rocks. 
Each of the next N lines contain rocks' composition. Each composition consists of lowercase letters of English alphabet.

Output Format 
Print the number of gem-elements that are common in these rocks. If there are none, print 0.

Constraints 
1 <= N <= 100 
Each composition consists of only small latin letters ('a'-'z'). 
1 <= Length of each composition <= 100

Sample Input

3
abcdde
baccd
eeabg
Sample Output

2
Explanation 
Only "a", "b" are the two kind of gem-elements, since these are the only characters that occur in each of the rocks' composition.
"""
nstrings = int(raw_input())
strings = []
for i in range(0,nstrings):
    strings.append(raw_input())
# find min_length
min_len = 101
min_len_index = 0
string_to_search = strings[min_len_index]
for string in strings:
    for char in string_to_search:
        if not char in string:
            string_to_search = string_to_search.replace(char,'')
print len(set(string_to_search))
