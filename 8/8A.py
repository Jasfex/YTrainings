class Node:
    def __init__(self, value, left, right):
        self.value = value
        self.left = left
        self.right = right


elems = list(map(int, input().split()))[:-1]

binary_tree = Node(None, None, None)

max_depth = 0
for elem in elems:
    depth = 1
    node = binary_tree
    inserted = False
    while not inserted:
        if node.value is None:
            node.value = elem
            inserted = True
        elif node.value == elem:
            inserted = True
        elif elem < node.value:
            if node.left is None:
                node.left = Node(elem, None, None)
                inserted = True
            else:
                node = node.left
            depth += 1
        elif node.value < elem:
            if node.right is None:
                node.right = Node(elem, None, None)
                inserted = True
            else:
                node = node.right
            depth += 1
    max_depth = max(depth, max_depth)

print(max_depth)
