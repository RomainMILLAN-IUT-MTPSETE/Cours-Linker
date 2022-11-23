def euclideEtendue(a, b):
    if a == 0:
        return b, 0, 1
    else:
        gcd, x, y = euclideEtendue(b % a, a)
        return gcd, y - (b // a) * x, x
 
 
if __name__ == '__main__':
 
    gcd, x, y = euclideEtendue(365, 127)
    print('Resultat: ', gcd)
    print(f'x = {x}, y = {y}')