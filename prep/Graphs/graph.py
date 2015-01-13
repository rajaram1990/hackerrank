class Graph:
    nodes = None
    adj_matrix = [[]]
    adj_list = {}
    representation_method = None
    def __init__(representation_method=adj_list):
        self.representation_method = representation_method
    def build_graph():
        print "Building Graph"
        for node in self.nodes:
            print "Enter all nodes that Node %d is connected to"%(node)
            connection_string = raw_input()
            connections = connection_string.split(" ")
            adj_list[node] = int()
    def build_minimum_spanning_tree():
        # Using Kruskal's algorithm
        built_nodes = []
        unbuilt_nodes = self.nodes
        for node in unbuilt_nodes:



