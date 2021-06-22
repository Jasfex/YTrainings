w, h, n = list(map(int, input().split()))

# Find minimum side, that satisfies capacity
left, right = 0, max(w, h) * n
while left < right:
    side = (left + right) // 2

    capacity = (side // w) * (side // h)
    if capacity >= n:
        right = side
    else:
        left = side + 1

print(left)
