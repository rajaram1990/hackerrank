term1 = 1
term2 = 2
sum =0
while term1 <= 4000000 and term2 <= 4000000:
    temp_term2 = term1+term2;
    term1 = term2
    term2 = temp_term2
    if term2 % 2 == 0:
        sum = sum+term2
    print term2
print sum+2
