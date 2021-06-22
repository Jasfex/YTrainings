with open("input.txt", "r") as f:
    words = f.read().split()
counter = dict()
for word in words:
    if word not in counter:
        counter[word] = 0
    counter[word] = counter[word] + 1

maximum = None
maximumWord = None
for word in sorted(counter.keys()):
    if maximum is None or maximum < counter[word]:
        maximum = counter[word]
        maximumWord = word
print(maximumWord)
