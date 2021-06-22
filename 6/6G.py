width = int(input())
height = int(input())
bricks = int(input())

left, right = 0, min(width, height) // 2
while left < right:
    span = (left + right + 1) // 2
    if bricks >= span * width * 2 + span * height * 2 - 4 * span * span:
        left = span
    else:
        right = span - 1

span = left
print(span)
