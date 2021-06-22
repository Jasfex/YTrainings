n = int(input())
dictionary = dict()
for i in range(n):
	a, b = input().split()
	dictionary[a] = b
	dictionary[b] = a
word = input()
print(dictionary[word])
