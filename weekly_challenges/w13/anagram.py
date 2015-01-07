t = int(raw_input())
answers = []
for i in range(0,t):
    anagram_pairs = [] # list of lists. Of structure [[[start, end],[anagram_start, anagram_end]],<second anagram_pair>]
    test_string = raw_input()
    # build character dictionary
    char_dict = {}
    length = len(test_string)
    i=0
    while i<length:
        if char_dict.get(test_string[i]):
            char_dict[test_string[i]].append(i)
        else:
            char_dict[test_string[i]]=[i]
        i+=1
    # Building the anagram list
    start_index=0
    second_index=0
    while start_index<length:
        start = start_index
        end = start_index
        anagram_start = None
        anagram_end = None
        if len(char_dict[test_string[start_index]])>1:
            # replace with while for checking with each char
            if char_dict[test_string[start_index]][1] > start_index: # any char before start_index would have been travelled before
                anagram_start = char_dict[test_string[start_index]][1]
                anagram_end = anagram_start
                anagram_pairs.append([[start, end],[anagram_start, anagram_end]])
        start_index+=1
print anagram_pairs            
