from random import randint
import miller_rabin


def produce_p_q(w):  # 生成p,q
    while 1:
        temp = [1]
        for i in range(w - 2):
            c = randint(0, 1)
            temp.append(c)
        temp.append(1)
        ls2 = [str(j) for j in temp]
        ls3 = ''.join(ls2)
        b = int(ls3[0])
        for i2 in range(len(ls3) - 1):
            b = b << 1
            b = b + int(ls3[i2 + 1])
        if miller_rabin.Miller_Rabin(b):
            return b


def euler(e, n1):
    temp1 = e
    temp2 = n1
    temp = [(e, n1)]
    try:
        while temp1 != 1:
            temp2 = temp2 % temp1
            temp.append((temp1, temp2))
            temp1 = temp1 % temp2
            temp.append((temp1, temp2))
        k = 0
        d = 0
        for j, i in enumerate(temp[::-1], 1):
            if j % 2 == 1:
                d = int((i[1] * k + 1) / i[0])
            else:
                k = int((1 - i[0] * d) / (-i[1]))
        return d
    except:
        return 0


def produce_key():
    p = produce_p_q(350)
    q = produce_p_q(350)
    with open('G:/RSA.txt', 'w') as file:
        file.write(str(p))
        file.write('\n')
        file.write(str(q))


if __name__ == '__main__':
    produce_key()




