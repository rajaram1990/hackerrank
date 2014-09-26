ntests = int(raw_input())
orig_strs = []
for i in range(0,ntests):
    orig_strs.append(raw_input())
for string in orig_strs:
    nops = 0
    left_index = 0
    right_index = len(string)-1
    letters = []
    for letter in string:
        letters.append(letter)
    while (right_index-left_index)>=1:
        left_char = ord(letters[left_index])
        right_char = ord(letters[right_index])
        if left_char > right_char:
            #print 'nops %d'%nops
            #print 'right_char %d'%right_char
            nops += left_char - right_char
            letters[right_index] = chr(right_char+nops)
            #print 'Letter %s'%(letters[right_index])
        elif right_char > left_char:
            nops += right_char - left_char
            #print 'nops %d'%nops
            #print 'left_char %d'%left_char
            letters[left_index] = chr(left_char+nops)
        #print 'String %s'%(letters)            
        left_index+=1
        right_index-=1
    print nops            
