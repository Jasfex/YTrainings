def extend(rect, val):
    return (rect[0] - val, rect[1] + val, rect[2] - val, rect[3] + val)


def intersect(rectA, rectB):
    minXminusY = max(rectA[0], rectB[0])
    maxXminusY = min(rectA[1], rectB[1])
    minXplusY = max(rectA[2], rectB[2])
    maxXplusY = min(rectA[3], rectB[3])
    return (minXminusY, maxXminusY, minXplusY, maxXplusY)


fin = open('input.txt', 'r')
t, d, n = map(int, fin.readline().strip().split())
points = []
for _ in range(n):
    x, y = map(int, fin.readline().strip().split())
    points.append((x, y))
fin.close()

# (minXminusY, maxXminusY, minXplusY, maxXplusY)
current = (0, 0, 0, 0)

for (x, y) in points:
    current = extend(current, t)
    gps = extend((x - y, x - y, x + y, x + y), d)
    current = intersect(current, gps)

answer = []
for XminusY in range(current[0], current[1] + 1):
    for XplusY in range(current[2], current[3] + 1):
        if (XminusY + XplusY) % 2 == 0:
            x = (XplusY + XminusY) // 2
            y = XplusY - x
            answer.append((x, y))
print(len(answer))
for (x, y) in answer:
    print(x, y)
