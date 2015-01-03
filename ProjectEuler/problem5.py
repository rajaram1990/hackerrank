import math
primes_until = []
prime_factors = {}
def is_prime(number):
    prime_flag = True
    for i in range(2,int(math.sqrt(number))+1):
        print "Checking if %d is a factor of %d"%(i,number)
        if number%i == 0:
            print "%d is a factor"%(i)
            prime_flag = False
    return prime_flag
def populate_primes_until(number):
    """
    ## Populates the primes availabel until the given number
    ## in a public list
    """
    for i in range(2,number+1):
        if is_prime(i) == True:
            print "is_prime(%d) returned %s"%(i,is_prime(i))
            primes_until.append(i)
    print "Inside primes_until"

def update_dict(dictionary, key, value):
    if dictionary.get(key):
        dictionary[key] = dictionary[key] + value
    else:
        dictionary[key] = value

def prime_factorize(number):
    """ Given a number, the fn. will prime factorize the number
        and return a dict with key as the prime factor
        and value as the power to which it is to be raised
    """
    print "calling prime factorize for %d"%(number)
    temp_number = number
    if len(primes_until) ==0:
        populate_primes_until(20)
    prime_factors = {}
    while temp_number > 1:
        for prime in primes_until:
            if temp_number < prime:
                break;
            elif temp_number%prime == 0:
                temp_number = temp_number / prime
                update_dict(prime_factors,prime,1) 
    return prime_factors

### Start of Main
until = 20 
minimum_number = 1
populate_primes_until(until)
print "Primes until %d is %s:"%(until,primes_until)
factors = {} # This is the dict containing all factors
for i in primes_until:
    factors[i] = 1
composite_numbers = list(set(range(2,until))-set(primes_until))
for composite_number in composite_numbers:
    temp_dict = {}
    prime_factors = prime_factorize(composite_number)
    print "prime_factorize of %d returned %s"%(composite_number, prime_factors)
    for key,value in prime_factors.iteritems():
        print "Key %d"%(key)
        if value > factors[key]:
            factors[key] = value
for key,value in factors.iteritems():
    for i in xrange(1,value+1):
        minimum_number = minimum_number * key
print minimum_number        
