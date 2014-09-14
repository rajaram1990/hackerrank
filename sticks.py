given_list = []
num_sticks = int(raw_input())
given_list = raw_input().split()
given_list = [int(x) for x in given_list]
print len(given_list)
while len(given_list) > 1: 
    to_split = min(given_list)
#    print given_list
#    print to_split
    i=0
    while (i<num_sticks):
        if given_list[i] == to_split:
            given_list[i] = 0
        else:
            given_list[i] = given_list[i]-to_split
        if given_list[i]==0:
            given_list.remove(0)
            num_sticks-=1
        else:
            i+=1
    if len(given_list) > 0:
        print len(given_list)
