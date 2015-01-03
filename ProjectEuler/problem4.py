#Palindrome numer with 3 digit products
def is_palindrome(some_integer):
    temp_str = str(some_integer)
    if temp_str == temp_str[::-1]:
        return True
    return False
num1 = 999
num2 = 999
num_maps = {}
range1 = range(100,num1)
range1.reverse()
for i in  range1:
    for j in range1:
        temp_int = i*j;
        if is_palindrome(temp_int):
            num_maps[i]=j
max_product = 0
keys = []
for key,value in num_maps.iteritems():
    prod = key*value
    keys.append(key)
    if prod > max_product:
        max_product = prod
print max_product
