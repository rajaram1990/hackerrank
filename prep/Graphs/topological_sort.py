import Queue
class graph:
    adj_list = {}
    nodes_count = 0
    edges_count = 0
    indegree_count = []
    removed_nodes = []
    zero_indegree_queue = Queue.Queue()
    def __init__(self, nodes_count, edges_count):
        self.nodes_count = nodes_count
        self.edges_count = edges_count
        i=1
        while i<(self.nodes_count+1):
            self.adj_list[i]=[]
            i+=1
        self.indegree_count = [0]*(self.nodes_count+1)
    def build_graph(self):
        i=0
        while i<self.edges_count:
            n1, n2 = [int(x) for x in raw_input().split(',')]
            self.adj_list[n1].append(n2)
            self.indegree_count[n2]+=1
            i+=1
    def remove_node(self, node):
        for elem in self.adj_list[node]:
            self.indegree_count[elem]-=1
            if self.indegree_count[elem]==0:
                self.zero_indegree_queue.put(elem)
        self.adj_list[node]=[]
        self.removed_nodes.append(node)
    def topological_sort(self):
        i=1
        while i<len(self.indegree_count):
            if self.indegree_count[i]==0:
                self.zero_indegree_queue.put(i)
            i+=1
        if self.zero_indegree_queue.empty():
            print "Not a DAG. Topological Sorting not possible"
        else:
            while not self.zero_indegree_queue.empty():
                temp_node = self.zero_indegree_queue.get()
                self.remove_node(temp_node)
## Main
node_count, edge_count = [int(x) for x in raw_input().split(',')]
g = graph(node_count, edge_count)
g.build_graph()
g.topological_sort()
print g.removed_nodes
