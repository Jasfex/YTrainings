def getCounter(word):
    ans = [0] * 128
    for letter in word:
        ans[ord(letter)] += 1
    return ans


wordLen, sentenceLen = [int(x) for x in input().split()]
word = input()
sentence = input()
counter = 0

word_feature = getCounter(word)
member_feature = getCounter(sentence[:wordLen])

if (word_feature == member_feature):
    counter = counter + 1

common = 0
for letter in set(word):
    common += min(member_feature[ord(letter)], word_feature[ord(letter)])

for i in range(wordLen, sentenceLen):
    dead_letter = sentence[i-wordLen]
    new_letter = sentence[i]

    a1 = min(member_feature[ord(dead_letter)], word_feature[ord(dead_letter)])
    a2 = min(member_feature[ord(new_letter)], word_feature[ord(new_letter)])

    member_feature[ord(dead_letter)] -= 1
    member_feature[ord(new_letter)] += 1

    a3 = min(member_feature[ord(dead_letter)], word_feature[ord(dead_letter)])
    a4 = min(member_feature[ord(new_letter)], word_feature[ord(new_letter)])

    common += a3 - a1
    common += a4 - a2

    if common == wordLen:
        counter += 1

print(counter)
