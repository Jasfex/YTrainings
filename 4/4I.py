n = int(input())
words = set([input() for i in range(n)])
words_ignore_case = set([word.lower() for word in words])
sentense = input().split()
counter = 0
for word in sentense:
    if word.lower() in words_ignore_case:
        if word not in words:
            counter += 1
    else:
        if len([letter for letter in word if ord("A") <= ord(letter) and ord(letter) <= ord("Z")]) != 1:
            counter += 1
print(counter)
