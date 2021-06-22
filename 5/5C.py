n = int(input())

heights = []
for _ in range(n):
    _, y = map(int, input().split())
    heights.append(y)

m = int(input())

tracks = []
for _ in range(m):
    s, f = map(int, input().split())
    tracks.append((s, f))

prefixsum = [0] * n
for i in range(1, n):
    prefixsum[i] = prefixsum[i-1] + max(0, heights[i] - heights[i-1])


def getHeight(start, finish):
    return prefixsum[finish-1] - prefixsum[start-1]


downsum = [0] * n
for i in range(1, n):
    downsum[n-1-i] = downsum[n-i] + max(0, heights[n-1-i] - heights[n-i])


def getDown(start, finish):
    return downsum[finish-1] - downsum[start-1]


for (start, finish) in tracks:
    if start <= finish:
        print(getHeight(start, finish))
    else:
        print(getDown(start, finish))
