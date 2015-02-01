import Queue
class graph:
    """
        Class denoting an undirected Graph
        Uses adjacency list notation
    """
    nodes_count = 0
    edges_count = 0
    adj_list = {}
    nodes = []
    hops = 0 # To keep track of the no. of hops in bfs/dfs
    level = 0
    def __init__(self,nodes_count=0,edges_count=0):
        self.nodes_count = nodes_count
        self.edges_count = edges_count
    def get_input(self):
        i=0
        while i<self.edges_count:
            connected_nodes = [int(x) for x in raw_input().split(" ")]
            if self.adj_list.get(connected_nodes[0]):
                self.adj_list[connected_nodes[0]].append(connected_nodes[1])
            else:
                self.adj_list[connected_nodes[0]] = [connected_nodes[1]]
            if self.adj_list.get(connected_nodes[1]):
                self.adj_list[connected_nodes[1]].append(connected_nodes[0])
            else:
                self.adj_list[connected_nodes[1]] = [connected_nodes[0]]
            i+=1
        # Assign the nodes list as well, in sorted order
        for k,v in self.adj_list.iteritems():
            self.nodes.append(k)
        self.nodes.sort()
    def bfs(self, start_node, end_node):
        """
            Computes BFS path for given start node
            Returns the number of hops required to reach end_node from start_node
            Warning : Do not call before calling get_input
        """
        level = [-1]*(self.nodes_count+1)
        reached = False
        if not start_node:
            start_node = self.nodes[0]
        visited = [-1]*(self.nodes_count+1)
        q = Queue.Queue()
        q.put(start_node)
        level[start_node]=0
        visited[start_node]=1
        while not q.empty():
            temp_node = q.get()
            if self.adj_list.get(temp_node):
                for neighbour in self.adj_list[temp_node]:
                    if visited[neighbour] == -1:
                        q.put(neighbour)
                        visited[neighbour]=1
                        if level[neighbour]==-1:
                            level[neighbour]=level[temp_node]+1
        return level[end_node] if level[end_node]!= -1 else 0
## Main
ncount, ecount = [int(x) for x in raw_input().split()]
g = graph(ncount, ecount)
g.get_input()
start_node, end_node = [int(x) for x in raw_input().split()]
print g.bfs(start_node,end_node)
