n = int(input())
resistance = {i+1: int(value) for i, value in enumerate(input().split())}
k = int(input())
keys = [int(x) for x in input().split()]
for key in keys:
    resistance[key] = resistance[key] - 1
for key in range(1, n+1):
    if (resistance[key] >= 0):
        print("NO")
    else:
        print("YES")
