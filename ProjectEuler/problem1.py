t = int(raw_input())
sols = []
for i in range(0,t):
    count = 0
    n = int(raw_input())
    div1 = n/3
    if n%3==0:
        div1-=1
    div2 = n/5
    if n%5==0:
        div2-=1
    div3 = n/15
    if n%15==0:
        div3-=1
    count1 = div1*(div1+1)/2*3
    count2 = div2*(div2+1)/2*5
    count3 = div3*(div3+1)/2*15
    count = count1+count2-count3
    sols.append(count)
for i in range(0,t):
    print sols[i]
