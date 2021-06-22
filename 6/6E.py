a = int(input())  # num of "2" marks
b = int(input())  # num of "3" marks
c = int(input())  # num of "4" marks

left, right = 0, a + b + c
while left < right:
    d = (left + right) // 2  # num of "5" marks
    average_mark = (a * 2 + b * 3 + c * 4 + d * 5)
    if average_mark * 2 >= 7 * (a + b + c + d):
        right = d
    else:
        left = d + 1

print(left)
