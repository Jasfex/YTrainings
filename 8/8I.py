n = int(input())

getchildren = {}
getparent = {}

for i in range(n-1):
    child, parent = input().split()
    getparent[child] = parent
    if parent not in getchildren:
        getchildren[parent] = []
    getchildren[parent].append(child)

creator = list(set(getchildren.keys()) - set(getparent.keys()))[0]

ordered_siblings = []
queue = [creator]
while len(queue) > 0:
    name = queue.pop(0)
    ordered_siblings.append(name)
    if name in getchildren:
        queue.extend(getchildren[name])

numancestors = {name: 0 for name in ordered_siblings}
for name in reversed(ordered_siblings):
    if name in getchildren:
        children = getchildren[name]
        for child in children:
            numancestors[name] += 1 + numancestors[child]

for name in sorted(ordered_siblings):
    print(name, numancestors[name])
