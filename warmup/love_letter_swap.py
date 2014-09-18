ntests = int(raw_input())
orig_strs = []
for i in range(0,ntests):
    orig_strs.append(raw_input())
for string in orig_strs:
    nops = 0
    left_index = 0
    right_index = len(string)-1
    while (right_index-left_index)>1:
        left_char = ord(string[left_index])
        right_char = ord(string[right_index])
        if left_char > right_char:
            nops = left_char - right_char
            string[left_index] = chr(ord(left_char)+(left_char - right_char))
        elif right_char > left_char:
            nops = right_char - left_char
            string[right_index] = chr(ord(right_char)+(right_char - left_char))



            
