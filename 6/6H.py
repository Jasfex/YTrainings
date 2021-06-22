n, k = map(int, input().split())
lengths = [int(input()) for _ in range(n)]

left, right = 1, max(lengths)
while left < right:
    length = (left + right + 1) // 2
    if sum([x // length for x in lengths]) >= k:
        left = length
    else:
        right = length - 1

length = left
if sum([x // length for x in lengths]) >= k:
    print(length)
else:
    print(0)
