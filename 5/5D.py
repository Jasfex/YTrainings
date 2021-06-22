n, r = map(int, input().split())
distances_str = input().split()

saved_right = 1

result = 0

for left in range(n):
    for right in range(saved_right, n):
        saved_right = right
        distance = int(distances_str[right]) - int(distances_str[left])
        if distance > r:
            positions = n - right
            result += positions
            break

print(result)
