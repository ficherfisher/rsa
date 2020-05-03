import random


def fast_power(base, power, n):
    result = 1
    tmp = base
    while power > 0:
        if power & 1 == 1:
            result = (result * tmp) % n
        tmp = (tmp * tmp) % n
        power = power >> 1
    return result


def Miller_Rabin(n, iter_num=5):
    if n == 2:
        return True
    if n & 1 == 0 or n < 2:
        return False
    m, s = n - 1, 0
    while m & 1 == 0:
        m = m >> 1
        s += 1
    for _ in range(iter_num):
        b = fast_power(random.randint(2, n - 1), m, n)
        if b == 1 or b == n - 1:
            continue
        for __ in range(s - 1):
            b = fast_power(b, 2, n)
            if b == n - 1:
                break
        else:
            return False
    return True


if __name__ == "__main__":
    # example
    """
    a = '800251142659642435182926709953165139044805415345232118' \
        '535074684530627758585667389804874041343944235686063076' \
        '5545600353049345324913056448174487017235828857'
    print(len(a))
    b = eval(a)
    print(Miller_Rabin(b, 5))
    """
    c = '697449109479522090952006944106834563500512083314863222' \
        '678629095839927321001878164189010029313076305369465661' \
        '6415918535903426563733919421100882641217793957'
    print(Miller_Rabin(eval(c)))


