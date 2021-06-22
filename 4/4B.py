with open("input.txt", "r") as file:
	text = file.read()
counter = dict()
for word in text.split():
	if word not in counter:
		counter[word] = 0
	print(counter[word], end=" ")
	counter[word] = counter[word] + 1
