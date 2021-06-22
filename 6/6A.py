n, k = map(int, input().split())
source = sorted(map(int, input().split()))
targets = list(map(int, input().split()))
for target in targets:
    left, right = 0, n - 1
    while left < right:
        m = (left + right) // 2
        if source[m] >= target:
            right = m
        else:
            left = m + 1
    if left == n:
        print("NO")
    elif source[left] != target:
        print("NO")
    else:
        print("YES")
