k = int(input())
s = input()
n = len(s)

left = 0
right = k

result = 0
acc = 0
while right < n:
    pointer = left + (right - left) % k
    if s[pointer] == s[right]:
        acc += 1
        right += 1
    else:
        result += acc * (acc + 1) // 2
        acc = 0
        right += 1
        left = right - k
    if right == n:
        result += acc * (acc + 1) // 2

print(result)
