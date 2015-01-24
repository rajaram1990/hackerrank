import sys
class temp_largest:
    start_index = None
    end_index = None
    tsum = None
class solution:
    max_sum = -sys.maxint
    nelems = None
    elems = []
    all_negative = True
    def __init__(self, n):
        self.nelems = n        
    def append_element(self,elem):
        self.elems.append(elem)
    def compute_non_contiguous_max_sum(self):
        """
            Given an array, gives the sum of all positive elements
            in the array. If no positive elements
            retuns the min element
            Warning : Use only after calling compute_max_subarray
        """
        if self.all_negative:
            return max(self.elems)
        max_sum = 0
        for elem in self.elems:
            if elem > 0:
                max_sum+=elem
        return max_sum

    def compute_max_subarray(self):
        """
            Computes the max sub array in the given object's elems list
            Warning : Do not use without elems being populated with 
            append_element method
        """
        temp_max_sum = -sys.maxint
        start = 0
        end = 0
        larges = [] # List storing objs of temp_largest
        cur_sum = 0
        i=0
        self.all_negative = True
        while (i<self.nelems and self.all_negative):
            if self.elems[i] > 0:
                self.all_negative = False
            i+=1
        if self.all_negative: # If all negative, return just the min most number
            self.max_sum = max(self.elems)
            return
        # Proceed only if not all are negatives
        while (end < self.nelems):
            if self.elems[end] < 0:
                temp_largest_obj = temp_largest()
                temp_largest_obj.start_index = start
                temp_largest_obj.end_index = end-1 #until prev element
                temp_largest_obj.tsum = cur_sum 
                larges.append(temp_largest_obj)
            if cur_sum < 0:
                start = end #reset start_index to start from this point
                cur_sum = 0
            cur_sum += self.elems[end]
            if cur_sum > self.max_sum:
                self.max_sum = cur_sum
            end+=1
        for obj in larges:
            if obj.tsum > self.max_sum:
                self.max_sum = obj.tsum
## Main ##
solution_objs=[]        
ntest_cases = int(raw_input())
for case in xrange(0,ntest_cases):
    nelems = int(raw_input())
    i=0
    solution_obj = solution(nelems)
    temp_nums = raw_input().split(' ')
    solution_obj.elems = [int(num) for num in temp_nums]
    solution_obj.compute_max_subarray() 
    solution_objs.append(solution_obj)
i = 0
while i < ntest_cases:
    print str(solution_objs[i].max_sum) + ' '+str(solution_objs[i].compute_non_contiguous_max_sum())
    i+=1
