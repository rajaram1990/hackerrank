class Solution:
    ntowns = None
    routes = []
    def __init__(self,ntowns):
        self.ntowns = ntowns
    def get_routes(self):
        self.routes = [int(x) for x in raw_input().split(' ')]
    def return_n_routes(self):
        product = 1
        for elem in self.routes:
            product = (product * elem) % 1234567
        return product
## MAIN ##
tests = int(raw_input())
i=0
sol_objs=[]
while (i<tests):
    ntowns = int(raw_input())
    sol_objs.append(Solution(ntowns))
    sol_objs[i].get_routes()
    i+=1
i=0    
while (i<tests):
    print sol_objs[i].return_n_routes()
    i+=1
