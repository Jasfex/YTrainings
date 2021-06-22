n, k = map(int, input().split())
source = list(map(int, input().split()))
targets = list(map(int, input().split()))

for target in targets:
    left, right = 0, n - 1
    while left < right:
        m = (left + right) // 2
        if source[m] >= target:
            right = m
        else:
            left = m + 1

    found = left
    if found == n:
        print(source[n-1])
    elif found == 0:
        print(source[0])
    else:
        # source[found-1] < target <= source[found]
        if target - source[found-1] <= source[found] - target:
            print(source[found-1])
        else:
            print(source[found])
