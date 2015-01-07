t = int(raw_input())
answers = []
for i in xrange(1,t+1):
    b,w = raw_input().split()
    b = int(b)
    w = int(w)
    x,y,z = raw_input().split()
    x = int(x)
    y = int(y)
    z = int(z)
    if x == y:
        answers.append(b*x+w*y)
    elif x < y:
        if z < y-x:
            answers.append((b+w)*x + z*w)
        else:
            answers.append(b*x + w*y)
    else: # y<x
        if z < x-y:
            answers.append((b+w)*y + z*b)
        else:
            answers.append(b*x + w*y)
for answer in answers:
    print answer            
        
