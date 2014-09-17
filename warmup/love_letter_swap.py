ntests = int(raw_input())
orig_strs = []
for i in range(0,ntests):
    orig_strs.append(raw_input())
for string in orig_strs:
    nops = 0
    left_index = 0
    right_index = len(string)-1
    while (right_index-left_index)>1:
        left_chr = ord(left_index)
        right_char = ord(right_index)
