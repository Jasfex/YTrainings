def findLeftmost(sorted_array, check):
    left, right = 0, len(sorted_array)
    while left < right:
        m = (left + right) // 2
        if check(sorted_array[m]):
            right = m
        else:
            left = m + 1
    return left


fin = open("input.txt", "r")

n, k = map(int, fin.readline().split())
xs = [int(x) for x in fin.readline().split()]

fin.close()

xs_sorted = sorted(set(xs))

counter = {}
for x in xs:
    if x not in counter:
        counter[x] = 0
    counter[x] += 1

xs_sorted_plural = [x for x in xs_sorted if counter[x] > 1]

answer = 0

# a:a:a
answer += sum([1 for a in xs_sorted if counter[a] >= 3])

# a:b:b [a < b]
for a in xs_sorted:
    left_b = findLeftmost(xs_sorted_plural, lambda x: x > a)
    right_b = findLeftmost(xs_sorted_plural, lambda x: x > k * a)
    answer += 3 * (right_b - left_b)

# a:a:b [a < b]
for a in xs_sorted_plural:
    left_b = findLeftmost(xs_sorted, lambda x: x > a)
    right_b = findLeftmost(xs_sorted, lambda x: x > k * a)
    answer += 3 * (right_b - left_b)

# a:b:c [a < b < c]
for a in xs_sorted:
    left = findLeftmost(xs_sorted, lambda x: x > a)
    right = findLeftmost(xs_sorted, lambda x: x > k * a)
    length = right - left
    answer += 6 * (length * (length - 1)) // 2

print(answer)
