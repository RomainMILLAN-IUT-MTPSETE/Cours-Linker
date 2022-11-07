import random

def cesarEncryptage(k, m):
    res=''
    length=len(m)
    for i in range(length):
        ltAct=m[i]
        ltAct=ltAct.upper()
        nb=ord(ltAct)
        nb=nb-65

        nb=nb+k
        nb=nb%26

        nb=nb+65

        lt=chr(nb)
        res=res+lt

    return res;
def cesarDecryptage(k, m):
    return cesarEncryptage(-k, m);
def chercherMessageCesar(m):
    for i in range(25):
        print(cesarDecryptage(i, m))
def AttaqueCesar(texte):
    freq=[]
    for i in range(26):
        freq += [0]

    nbLettres=0
    for caractere in texte:
        if(ord(caractere) >= 65 and ord(caractere) <= 90):
            freq[ord(caractere)-65] += 1
            nbLettres += 1
        elif(ord(caractere) >= 97 and ord(caractere) <= 122):
            freq[ord(caractere)-97] += 1
            nbLettres += 1

    freq = [x / nbLettres for x in freq]
    valeur_max = max(freq)
    index_max = freq.index(valeur_max)

    decalage = (index_max - 4) % 26
    print("Frequences:", freq)
    return cesarDecryptage(decalage, texte)