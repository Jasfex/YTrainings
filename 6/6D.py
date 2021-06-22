def foundMaxDefence(numBlocks, blockWidth, blockHeight, fieldWidth, fieldHeight):
    left, right = 0, fieldWidth
    while left < right:
        d = (left + right + 1) // 2
        widthCapacity = fieldWidth // (blockWidth + 2 * d)
        heightCapacity = fieldHeight // (blockHeight + 2 * d)
        capacity = widthCapacity * heightCapacity
        if capacity >= numBlocks:
            left = d
        else:
            right = d - 1
    return left


n, a, b, w, h = list(map(int, input().split()))
d1 = foundMaxDefence(n, a, b, w, h)
d2 = foundMaxDefence(n, b, a, w, h)
print(max(d1, d2))
