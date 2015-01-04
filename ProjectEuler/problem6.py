# Difference between square of sums and sum of squares
# Take all variable, multiply two at a time
sum = 0
for i in range(1,101):
    for j in range(1,101):
        if i!=j:
            sum = sum+ i*j
print sum            
