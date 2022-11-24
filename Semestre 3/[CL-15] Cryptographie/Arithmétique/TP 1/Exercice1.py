#1°) f(143) => 11 * 13
#    f(6557) => 79 * 83

#2°) Si p n'est pas inférieur à la racine alors on peut toujours rediviser p avec un autre nombre premier. Pour conclure on peut dire que si p est supérier à la racine(x) alors il existe un autre nombre qui permets de le diviser.

#3°)

#4°)Tous les nb sont premiers sauf 2

#5°)
import math
def estPremier(n):
    a = 0
    sqrtn = math.sqrt(n)+1

    for i in range(1, sqrtn):
        if n%i == 0:
            a = i

    return a==1 or a==n

def f(n):
    sqrtn = math.sqrt(n)+1

    for i in range(1, sqrtn):
        if estPremier(i) and n%i==0:
            return i

