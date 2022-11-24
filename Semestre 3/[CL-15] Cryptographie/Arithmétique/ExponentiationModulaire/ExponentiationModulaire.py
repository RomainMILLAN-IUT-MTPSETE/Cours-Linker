def ExponentielModulaire(a, b, n):
    d = 1
    beta = bin(b)[2:]

    for i in range(len(beta), 0, -1):
        d = (d * d) % n

        if (beta[i - 1] == '1'):
            d = (d * a) % n

    return d

if __name__ == '__main__':
    print(ExponentielModulaire(7, 45, 13));