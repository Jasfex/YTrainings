fin = open('input.txt', 'r')
nKeywords, caseSensitive, leadingDigit = fin.readline().strip().split()
nKeywords = int(nKeywords)
caseSensitive = caseSensitive == 'yes'
leadingDigit = leadingDigit == 'yes'

keywords = {fin.readline().strip() for _ in range(nKeywords)}
if not caseSensitive:
    keywords = {keyword.lower() for keyword in keywords}

lines = fin.read().strip().split('\n')
fin.close()

counter = dict()
accumulator = 0
answer = ('', 0, 0)

for line in lines:
    line = ''.join([c if c.isalnum() or c == '_' else ' ' for c in line])
    words = line.split()
    if not caseSensitive:
        words = [word.lower() for word in words]
    # filter keywords
    words = [word for word in words if word not in keywords]
    # filter numbers
    words = [word for word in words if not all([c.isdigit() for c in word])]
    # filter identifiers with leading digit
    if not leadingDigit:
        words = [word for word in words if not word[0].isdigit()]

    # count identifiers
    for identifier in words:
        if identifier not in counter:
            counter[identifier] = [0, accumulator]
            accumulator += 1
        counter[identifier][0] += 1

        current = (identifier, counter[identifier][0], counter[identifier][1])
        if current[1] > answer[1] or current[1] == answer[1] and current[2] < answer[2]:
            answer = current

print(answer[0])
