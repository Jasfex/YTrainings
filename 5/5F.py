n = int(input())
requirements = [int(x) for x in input().split()]
m = int(input())
catalog = [tuple(map(int, input().split())) for _ in range(m)]

sorted_powers = sorted(set([power for power, price in catalog]))
power_price = dict()
for power, price in catalog:
    if power not in power_price:
        power_price[power] = price
    if price < power_price[power]:
        power_price[power] = price

z = len(sorted_powers)
for i in range(1, z):
    bigger_power = sorted_powers[z-i]
    power = sorted_powers[z-i-1]
    power_price[power] = min(power_price[bigger_power], power_price[power])

total_price = 0

for class_power in requirements:
    for power in sorted_powers:
        if power >= class_power:
            total_price += power_price[power]
            break

print(total_price)
