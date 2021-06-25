class Node:
    def __init__(self, value, left, right, parent, height):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent
        self.height = height


elems = list(map(int, input().split()))[:-1]

binary_tree = Node(None, None, None, None, 0)

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
                node.left = Node(elem, None, None, node, 1)
                inserted = True
            else:
                node = node.left
        elif node.value < elem:
            if node.right is None:
                node.right = Node(elem, None, None, node, 1)
                inserted = True
            else:
                node = node.right

queue = [binary_tree]
ordered_relatives = []
while len(queue) > 0:
    node = queue.pop(0)
    ordered_relatives.append(node)
    if node.left is not None:
        queue.append(node.left)
    if node.right is not None:
        queue.append(node.right)

for node in reversed(ordered_relatives):
    if node.parent is not None:
        node.parent.height = max(node.parent.height, 1 + node.height)

queue = [binary_tree]
result = []
while len(queue) > 0:
    node = queue.pop(0)
    leftheight, rightheight = 0, 0
    if node.left is not None:
        leftheight = node.left.height
        queue.append(node.left)
    if node.right is not None:
        rightheight = node.right.height
        queue.append(node.right)
    print(node.value, node.height, leftheight, rightheight)
    result.append(abs(leftheight-rightheight) <= 1)

if all(result):
    print('YES')
else:
    print('NO')
