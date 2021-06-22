with open("input.txt", "r") as f:
    lines = f.read().split('\n')

meta = dict()

for line in lines:
    if len(line) == 0:
        continue
    customer, product, quantity = line.split()
    quantity = int(quantity)

    if customer not in meta:
        meta[customer] = dict()

    if product not in meta[customer]:
        meta[customer][product] = 0

    meta[customer][product] = meta[customer][product] + quantity

for customer in sorted(meta.keys()):
    print(customer + ":")
    for product in sorted(meta[customer].keys()):
        print(product, ' ', meta[customer][product])
