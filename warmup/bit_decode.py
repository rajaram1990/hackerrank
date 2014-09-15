"""
    See problem file bit_decode.txt for details
"""
def xor (elem_list=None):
    """
        given a list of operands, returns the xor value of all operands:w
    """
    ones_count=0
    for elem in elem_list:
        if elem:
            ones_count+=1
    if ones_count > 0 and ones_count%2!=0:
        return 1
    else:
        return 0
def reverse_xor(xor_val,elem_list):
    """
        Given a final xor value and a list of elements, it tell which missing 
        element in the list will give this xor value
    """
    base_val = xor(elem_list)
    return xor([base_val,xor_val])
   
if __name__ == '__main__':
    N,K = (int(elem) for elem in (raw_input().split(' ')))
    xor_str = [int(elem) for elem in raw_input()]
    base_str=[]
    base_str.append(xor_str[0]) # First bit matches exactly
    i=1
    while (i<N):
        temp_list = xor
        lower_bound = max(i-K+1,0)
        upper_bound = i if i<=K else lower_bound+K
#        print 'Iteration %(i)d: xor[%(i)d] = SUM(%(list)s'%{'i':i,'list':base_str[lower_bound:upper_bound]}
        tmp_val = reverse_xor(xor_str[i],base_str[lower_bound:upper_bound])
        base_str.append(tmp_val)
        i+=1
    print ''.join(str(x) for x in base_str)
