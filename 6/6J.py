def getLeftMedian(seq1, seq2, L):
    left1 = 0
    left2 = 0
    median = None
    while left1 + left2 < L:
        if seq1[left1] <= seq2[left2]:
            median = seq1[left1]
            left1 += 1
        else:
            median = seq2[left2]
            left2 += 1
    return median


numSequences, seqLen = map(int, input().split())
sequences = [list(map(int, input().split())) for _ in range(numSequences)]

# maximum operations = (100 * 99) / 2 * 300 = 1_485_000

for i in range(numSequences):
    for j in range(i+1, numSequences):
        seq1, seq2 = sequences[i], sequences[j]
        median = getLeftMedian(seq1, seq2, seqLen)
        print(median)
