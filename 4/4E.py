n = int(input())
blocks = dict()
for i in range(n):
    w, h = [int(x) for x in input().split()]
    if w not in blocks or blocks[w] < h:
        blocks[w] = h
print(sum(blocks.values()))
