n = int(input())
colors1 = [int(x) for x in input().split()]
m = int(input())
colors2 = [int(x) for x in input().split()]

best_diff = 20_000_000
best_left = 0
best_right = 0

right = 0
for left in range(n):
    prev_diff = None
    right = max(0, min(right - 1, m - 2))
    while right < m:
        diff = abs(colors1[left] - colors2[right])
        if prev_diff is None:
            prev_diff = diff
            if diff < best_diff:
                best_diff = diff
                best_left = left
                best_right = right
            right += 1
        elif prev_diff is not None and prev_diff > diff:
            prev_diff = diff
            if diff < best_diff:
                best_diff = diff
                best_left = left
                best_right = right
            right += 1
        else:
            break

print(colors1[best_left], colors2[best_right])
