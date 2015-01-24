# Main
nodes_edges = raw_input().split(" ")
nodes_count = int(nodes_edges[0])
edges_count = int(nodes_edges[1])
i=0
node_edges={} # Dict storing list in value part. The list being the list of nodes the given node (in key) is connected to
def count_nodes(start_node,count=0,traversed_path=[]):
    """
        Given a sub tree, counts the number od nodes in that tree
    """
    last_stored_count = count
    for node in node_edges[start_node]:
        if node not in traversed_path:
            count+=1
            traversed_path.append(node)
            print "Calling count_nodes with %s %d %s"%(node,count,traversed_path)
            last_stored_count = count
            count_nodes(node,count,traversed_path)
    return last_stored_count

while i<edges_count:
    edge_parts = [int(__x) for __x in raw_input().split(" ")]
    if node_edges.get(edge_parts[0]):
        node_edges[edge_parts[0]].append(edge_parts[1])
    else:
        node_edges[edge_parts[0]] = [edge_parts[1]]
    if node_edges.get(edge_parts[1]):
        node_edges[edge_parts[1]].append(edge_parts[0])
    else:
        node_edges[edge_parts[1]] = [edge_parts[0]]
    i+=1
print node_edges
print "==========="
print "Counting Nodes Under 2"
print count_nodes(2,0,[1])
print "Counting Nodes Under 1"
print count_nodes(1)
