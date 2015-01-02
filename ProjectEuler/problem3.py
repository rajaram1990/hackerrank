import math
def is_prime(x):
    i=2
    if x < 2:
        return False;
    temp_sqrt = int(math.sqrt(x))
    print "SQRT : %d"%(temp_sqrt)
    for i in xrange(i,temp_sqrt):
        if x%i == 0:
            print "%d is a factor"%(i)
            return False
    return True

var = 600851475143
prime_factors = []
i = 1
while var >1 :
    print "Testing Prime for %d"%(i)
    if var % i == 0:
        prime_factors.append(i)
        var = var/i
    i = i+1
        #if is_prime(i):
        #    prime_factors.append(i)
print prime_factors            
print "Testing Primes"
for var in prime_factors:
    if is_prime(var):
        print var
