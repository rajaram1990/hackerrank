class graph:
    nodes_count = 0
    edges_count = 0
    visited = []
    parents = []
    start_times = []
    end_times = []
    adj_mat = {}
    counter = 0
    nodes_under = []
    def __init__(self, nodes_count, edges_count):
        """
            Constructor. Initializes all lists and counters
        """
        self.nodes_count = nodes_count
        self.edges_count = edges_count
        self.visited = [0]*(nodes_count+1)
        self.parents = [0]*(nodes_count+1)
        self.start_times = [0]*(nodes_count+1)
        self.end_times = [0]*(nodes_count+1)
        self.nodes_under = [0]*(nodes_count+1)
        for node in xrange(1,nodes_count+1):
            self.adj_mat[node]=[]
    def populate_graph(self):
        """
            Builds the graph based on user given edges
        """
        i=0
        while (i<self.edges_count):
            edges = [int(x) for x in raw_input().split(' ')]
            self.adj_mat[edges[0]].append(edges[1])
            self.adj_mat[edges[1]].append(edges[0])
            i+=1
    def dfs(self, start_node):
        """
            Performs a DFS traversal starting from given start_node
        """
        self.visited[start_node]=1
        self.counter+=1
        for neighbour in self.adj_mat[start_node]:
            if self.visited[neighbour]==0:
                self.parents[neighbour]=start_node
                self.start_times[neighbour]=self.counter
                self.dfs(neighbour)
                self.end_times[neighbour]=self.counter
        self.end_times[start_node]=self.counter

    def count_nodes_under(self):
        """
            To be run after dfs. Counts the number of nodes under each nodes
        """
        if max(self.visited) == 0:
            self.dfs(1)
        i=1
        while (i<=self.nodes_count):
            self.nodes_under[i] = self.end_times[i]-self.start_times[i] # nodes_under count includes the head node
            i+=1

    def cut_nodes(self):
        """
            To be run after count_nodes_under
        """
        nodes_cut = 0
        if max(self.nodes_under) == 0:
            self.count_nodes_under()
        # start with non head (1 is considered the head)
        i=2
        while (i<=self.nodes_count):
            if (self.nodes_under[i] %2 == 0):
                for neighbour in self.adj_mat[i]:
                    if neighbour < i: # cut off from all parents
                        self.adj_mat[i].remove(neighbour)
                        self.adj_mat[neighbour].remove(i)
                        nodes_cut+=1
            i+=1
        print nodes_cut

### MAIN ###
nodes_count, edges_count = [int(x) for x in raw_input().split()]
g = graph(nodes_count,edges_count)
g.populate_graph()
g.count_nodes_under()
g.cut_nodes()
