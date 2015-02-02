import Queue
import sys
class graph:
    adj_list = {}
    nodes_count = 0
    edges_count = 0
    def __init__(self, nodes_count, edges_count):
        self.nodes_count = nodes_count
        self.edges_count = edges_count
        i=1
        while i<(self.nodes_count+1):
            self.adj_list[i]=[]
            i+=1
    def build_graph(self):
        i=0
        while i<self.edges_count:
            n1, n2, w = [int(x) for x in raw_input().split(',')]
            self.adj_list[n1].append((n2,w))
            self.adj_list[n2].append((n1,w))
            i+=1
    def dijkstras(self, start_node):
        visited = [0]*(self.nodes_count+1)
        min_dist = [sys.maxint]*(self.nodes_count+1)
        min_dist[start_node]=0
        for i in range(1,self.nodes_count+1):
            # find u which is unvisited and has min cost
            j=1
            temp_min_dist = sys.maxint
            temp_min_node = None
            while j<(self.nodes_count+1):
                if not visited[j] and min_dist[j]<temp_min_dist:
                    temp_min_dist = min_dist[j]
                    temp_min_node = j
                j+=1
            visited[temp_min_node]=True
            for to_node,weight in self.adj_list[temp_min_node]:
                if min_dist[temp_min_node] + weight < min_dist[to_node]:
                    min_dist[to_node]=min_dist[temp_min_node] + weight
        print min_dist
## Main ##
node_count, edge_count = [int(x) for x in raw_input().split(',')]
g = graph(node_count, edge_count)
g.build_graph()
g.dijkstras(1)
