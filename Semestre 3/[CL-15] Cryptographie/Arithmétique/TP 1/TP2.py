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
import math


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


# Question n°6:
print("Exercice n°1 - Question n°6:")
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


print("\n\nExercice n°3:")
print(g(48))
print(g(900))
print(g(2356))