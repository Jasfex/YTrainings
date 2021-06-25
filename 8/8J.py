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

getlevel = {}
queue = [(creator, 0)]
while len(queue) > 0:
    name, level = queue.pop(0)
    getlevel[name] = level
    if name in getchildren:
        for child in getchildren[name]:
            queue.append((child, level + 1))

for name in sorted(getlevel.keys()):
    print(name, getlevel[name])
