"""
    See Problem Statement in service-lane.pdf
"""
way_length, ntests = [int(var) for var in raw_input().split(' ')]
way_width = [int(var) for var in raw_input().split(' ')]
test_cases = [] # List of lists. Each sub list contains two elements i and j
# Clavin Enters by i and exits by j
for i in range(0,ntests):
    test_cases.append([int(var) for var in raw_input().split(' ')])
## The processsing
#print 'WIDTH %s'%(way_width)
for case in test_cases:
    i,j = case
#   print 'Processing Array %s'%(way_width[i:j])
    print min(way_width[i:j+1])
