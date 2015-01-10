import math
def is_prime(number):
    for i in range(2,int(math.sqrt(number)+1)):
        if number%i == 0:
            return False
    return True

primes = [2]
primes_length = 1
odd_flag = True
to_check = 3
while primes_length <= 10001:
    if odd_flag:
        if is_prime(to_check):
            primes.append(to_check)
            primes_length +=1
        to_check+=1
        odd_flag = False
    else:
        to_check+=1
        odd_flag = True
print primes[10000]
