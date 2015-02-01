import sys
n = input()
k = input()
candies = [input() for _ in range(0,n)]
candies.sort()
i=0
min_diff = sys.maxint
while ((i+k-1)<n):
    temp_min = candies[i]
    temp_max = candies[i+k-1]
    temp_min_diff = temp_max - temp_min
    if temp_min_diff < min_diff:
        min_diff = temp_min_diff
    i+=1    

print min_diff
