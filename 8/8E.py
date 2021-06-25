class Node:
    def __init__(self, value, left, right):
        self.value = value
        self.left = left
        self.right = right


def inorder(btree, path):
    if btree.left is not None:
        inorder(btree.left, path)
    path.append(btree.value)
    if btree.left is None and btree.right is None:
        print(btree.value)
    if btree.right is not None:
        inorder(btree.right, path)


elems = list(map(int, input().split()))[:-1]

binary_tree = Node(None, None, None)

for elem in elems:
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
        elif node.value < elem:
            if node.right is None:
                node.right = Node(elem, None, None)
                inserted = True
            else:
                node = node.right

path = []
inorder(binary_tree, path)
