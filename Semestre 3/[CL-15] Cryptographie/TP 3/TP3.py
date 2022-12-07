import math
from random import *
# TP1BIS
# EXERCICE 1
# Question n°1/ f(143) => 11 * 13 f(6557) => 79 * 83
#
# Question n°2/ Si p n'est pas inférieur à la racine alors on peut toujours rediviser
# p avec un autre nombre premier. Pour conclure on peut dire que si p est supérier à la racine(x) alors il existe un
# autre nombre qui permets de le diviser.
#
# Question n°3/ Si P le plus petit diviseur d'un nombre, alors N a forcément un
# diviseur premier G tel que i+G=N
#
# Question n°4/ Tous les nb sont premiers sauf 2
#
# Question n°5/


def estPremier(n):
    for i in range(2, int(math.sqrt(n) + 1)):
        if n % i == 0:
            return False

    return True


def f(n):
    i = 2
    while i <= math.sqrt(n):
        if estPremier(i) and n % i == 0:
            return i
        i = i + 1

    return n

print("TP1 | Exercice n°1 - Question n°6:")
print(f(2 ** 11 - 1))
print(f(2 ** 21 - 1))
print(f(2 ** 31 - 1))
print(f(2 ** 41 - 1))
print(f(2 ** 51 - 1))

#EXERCICE 2
# Question n°1/
# f(n) renvoie p1
#
# Question n°2/
#   a/ 2^B-1 <= P1 <= (2^B)-1
#   b/ racine(2^(B-1)) <= racine(P1) <= racine((2^B)-1)
#   c/ racine(2^(B-1)) fois
#
# Question n°3/ A partir de racine((2^B)-1)

#EXERCICE 3
def g(n):
    resultat = []
    while n > 1:
        tmp = f(n)
        resultat.append(tmp)
        n = n // tmp
    return resultat

print("\nTP1 | Exercice n°3:")
print(g(48))
print(g(900))
print(g(2356))
print(g(1))





#TP2
def euclide(a,b):
    if(b==0):
        return a
    else:
        r = a%b
        return euclide(b, r)

print("\n\n\nTP2 | Exercice n°1:")
#Aucun terme en commun donc 1
print(euclide(3 ** 1000,2 ** 1000))
#La valeur en commun est 2 et il faut prendre le plus petit exponentielle donc 2^10
print(euclide(((3 ** 1000) * (2 ** 10)), (2 ** 1000)))
#Vus qu'il y a 2 d'écart alors c'est égale à 1
print(euclide((2 ** 1000 + 1), (2 ** 1000 - 1)))


print("\nTP2 | Exercice n°2:")
#1)
def euclideEtendue(a, b):
    if b == 0:
        return a, 1, 0
    else:
        dp, up, vp = euclideEtendue(b, a % b)
        return dp, vp, up - (a // b) * vp
#2)
d, u, v = euclideEtendue(127, 239)
print('L\'inverse de 127 dans Z/239Z est',u,'=> d:',d,'u:',u,'v:',v)
d1, u1, v1 = euclideEtendue((2 ** 10 - 1), (2 ** 10+1))
# 3)
# 2^10-1 = -2[2^10+1]
#2^9(2^10-1) = -2^10[2^10+1]
#2^9(2^10-1) = 1[2^10+1]
#Donc l'unverse est 2^9
print('L\'inverse de 2^10-1 dans Z/2^10+1Z est',u1,'=> d:',d1,'u:',u1,'v:',v1)
#4)
#2^500 = 2^500[2^1000-1]
#2^500*2^500 = -1[2^1000-1]
#(2^500)^4 = 1[2^1000-1]
#2^500*(2^500)^3
#U = (2^500)^3
d2, u2, v2 = euclideEtendue((2 ** 500), (2 ** 1000 - 1))
print('L\'inverse de 2^500 dans Z/2^1000-1Z est',u2,'=> d:',d2,'u:',u2,'v:',v2)


print("\n\n\nTP2 | Exercice n°3")
#1)
def ExponentielModulaire(a, b, n):
    d = 1
    beta = bin(b)[2:]

    i=0
    while(i<len(beta)):
        d=(d * d) % n

        if(beta[i] == '1'):
            d = (d * a) % n

        i=i+1
    return d
#2)
print('739,8247,1023:', ExponentielModulaire(739, 8247, 1023))
#print('28,920,11:', ExponentielModulaire(28, 920, 11))
#print('3,3,5:', ExponentielModulaire(3, 3, 5))
#3A)
def nbBits(b):
    beta = bin(b)[2:]
    return len(beta)

print('Nombre de Bits 2^1000-17', nbBits((2 ** 1000) - 17))
print('Nombre de Bits 2^1000+1', nbBits((2 ** 1000) + 1))
print('Nombre de Bits 2^2000+1', nbBits((2 ** 2000) + 1))
#3B)
# La longueur maximale est 2000 car il neut pas pas être égal ou plus grand que n et n est 2001
#3C)
# Le code ne fonctione pas pour les grand valeurs
def PuissModulaire(a, b, n):
    i=0
    x=1
    while i<b:
        x = (a * x) % n
        i=i+1
    
    return x

#3D)
# La valeur finale est très très grande: 51498484442168273083600402309958271482469851080423274078443489160649733460852698033867711981585886878239987357046656480050957136128390442941811090841642098476346652480493203173086511721862159507912258434159091672091181875299104459146774830608922908459176451471333659878674162388473253870303769106779907001069931125990811375628009872048597804449256382949876800403696154710488024617923843427372078813060156944891827251832192073742238453199219812536199634610875415976976877724106616037360611930970739655597717336330860329630525504268761391055199256161898723748418506505702119628642888358258130914999583618
print(ExponentielModulaire(((2 ** 1000) - 17), ((2 ** 1000) + 1), ((2 ** 2000) + 1)))
#4)



print("\nTP3 | Exercice 1")
def E(m, k):
    return ExponentielModulaire(m, k[1], k[0])


def D(c, kp):
    return ExponentielModulaire(c, kp[1], kp[0])

print("Question n°1:")
print("Encryptage m=2, k=(253, 13): ", E(2, (253, 13)))
print("Decryptage m=22 k=(253,17): ", D(22, (253, 17)))
print("Decryptage m=18 k=(253,17): ", D(18, (253, 17)))
print("Question n°2:")
#1: La longueur max est
#2:
print("Encryptage m=1111 k=(8633,17): ", E(1111, (8633, 17)))

def q2kprvwithfactdef(k):
    N=k[0]
    fact = g(N)

    e = k[1]
    d = 0
    mod = (fact[0]-1)*(fact[1]-1)

    while(ExponentielModulaire(e*d, 1, mod) != 1):
        d = d+1
    
    return (N, d)


print("Question n°2.A.III: ", E(1111, (8633, 17)))
print("Question n°2.A.III: ", q2kprvwithfactdef((8633, 17)))
print("Question n°3.A.IV: ", D(E(1111, (8633, 17)), q2kprvwithfactdef((8633, 17))))
print("Question n°3: ", D(1234, (6557, 67)))

print("TP3 | Exercice 2")
#1°)
def estPresquePremier(n):
    if (estPremier(n)):
        return 1
    
    for i in range(2, 25):
        if(ExponentielModulaire((i ** (n-1)), 1, n) != 1):
            return 0
    
    return 1

print("Question n°1:")
print(estPresquePremier(937))
print(estPresquePremier(167))

#2°)
def genNbPresquePremierBeetwen2AndN(N):
    p = randint(2, N)

    pfind = False

    while(pfind == False):
        if(pfind == False):
            p = randint(2, N)
            if(estPresquePremier(p) == 1):
                pfind = True

    return p

print("Question n°2", genNbPresquePremierBeetwen2AndN(2**12))

#3°) Il faut en moyenne 10 entiers

#4°) 


