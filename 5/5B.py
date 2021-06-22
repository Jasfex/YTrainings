n, k = map(int, input().split())
numbers = [int(x) for x in input().split()]
prefixsum = [0] * (n + 1)
for i in range(1, n + 1):
    prefixsum[i] = prefixsum[i-1] + numbers[i-1]

counter = 0

saved_right = 0
for left in range(n):
    for right in range(saved_right, n):
        saved_right = right
        cum = prefixsum[right + 1] - prefixsum[left]
        if cum == k:
            counter += 1
        elif cum > k:
            break

print(counter)
