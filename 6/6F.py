n, x, y = list(map(int, input().split()))
x, y = min(x, y), max(x, y)

result = x
n = n - 1

left, right = 0, n * y
while left < right:
    seconds = (left + right) // 2
    if seconds // x + seconds // y >= n:
        right = seconds
    else:
        left = seconds + 1

result += left

print(result)
