def ensureAccount(name, bank):
    if name not in bank:
        bank[name] = 0


with open("input.txt", "r") as f:
    lines = f.read().split('\n')
    lines = list(filter(lambda line: len(line) > 0, lines))

bank = dict()

for line in lines:
    tokens = line.split()
    operation = tokens[0]
    if operation == "DEPOSIT":
        name = tokens[1]
        value = int(tokens[2])
        ensureAccount(name, bank)
        bank[name] = bank[name] + value
    if operation == "WITHDRAW":
        name = tokens[1]
        value = int(tokens[2])
        ensureAccount(name, bank)
        bank[name] = bank[name] - value
    if operation == "BALANCE":
        name = tokens[1]
        if name not in bank:
            print("ERROR")
        else:
            print(bank[name])
    if operation == "TRANSFER":
        name1 = tokens[1]
        name2 = tokens[2]
        value = int(tokens[3])
        ensureAccount(name1, bank)
        ensureAccount(name2, bank)
        bank[name1] = bank[name1] - value
        bank[name2] = bank[name2] + value
    if operation == "INCOME":
        percent = int(tokens[1])
        for name in bank:
            value = bank[name]
            if value > 0:
                bank[name] = value + (value * percent) // 100
