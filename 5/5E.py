n, k = map(int, input().split())
colors_counter = [0] * (k + 1)
trees = [int(x) for x in input().split()]

left = 0
right = -1

uniqueTreesInPack = 0

shortest = n + 1
result = None

while left < n:
    if uniqueTreesInPack == k:
        if right - left < shortest:
            shortest = right - left
            result = (left + 1, right + 1)

        colors_counter[trees[left]] -= 1
        if colors_counter[trees[left]] == 0:
            uniqueTreesInPack -= 1

        left += 1
    else:
        right += 1
        if right >= n:
            break
        colors_counter[trees[right]] += 1
        if colors_counter[trees[right]] == 1:
            uniqueTreesInPack += 1

print(result[0], result[1])
