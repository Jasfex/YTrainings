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
            print(depth, end=' ')
        elif node.value == elem:
            inserted = True
        elif elem < node.value:
            depth += 1
            if node.left is None:
                node.left = Node(elem, None, None)
                inserted = True
                print(depth, end=' ')
            else:
                node = node.left
        elif node.value < elem:
            depth += 1
            if node.right is None:
                node.right = Node(elem, None, None)
                inserted = True
                print(depth, end=' ')
            else:
                node = node.right
