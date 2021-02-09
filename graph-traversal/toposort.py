def toposort(graph):
    visited = list()

    def topo(node):
        for neigh in graph.get(node, []):
            if neigh not in visited:
                topo(neigh)

        if node not in visited:
            # append only after visiting all neighbours
            visited.append(node)

    for node in graph:
        topo(node)

    return visited[::-1]