import Queue
class Graph:
    no_of_nodes = 0
    nodes = []
    adj_matrix = [[]]
    adj_list = {}
    representation_method = None
    
    def build_graph(self,no_of_nodes):
        """
            Warning : To be used the first time only.
                      Erases all nodes, if the graph contains any already!
        """
        print "Building Graph"
        self.no_of_nodes = no_of_nodes
        for node in xrange(0,no_of_nodes):
            print "Enter data represented by node %d"%(node)
            print "Enter all nodes that Node %d is connected to"%(node)
            self.nodes.append(node)
            connection_string = raw_input()
            connections = connection_string.split(" ")
            self.adj_list[node] = [int(conn) for conn in connections]

    def find_via_dfs(self, start_node, visited=[]):
        if start_node not in visited:
            visited.append(start_node)
            for node in self.adj_list[start_node]:
                self.find_via_dfs(start_node = node, visited=visited)
        print visited

    def bfs(self):
        q = Queue.Queue()
        start_node = self.nodes[0]
        q.put(start_node)
        return self.find_via_bfs(q)

    def find_via_bfs(self,q):
        visited = []
        while not q.empty():
            node = q.get()
            visited.append(node)
            for temp_node in self.adj_list[node]:
                if temp_node not in visited:
                    print visited
                    print temp_node
                    q.put(temp_node)

        
graph = Graph()
graph.build_graph(5)
#graph.find_via_dfs(graph.nodes[0])
graph.bfs()

