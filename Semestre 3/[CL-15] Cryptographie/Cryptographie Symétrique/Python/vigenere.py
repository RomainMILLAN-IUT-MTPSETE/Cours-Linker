def ChiffrementVigenere(k, m):
    res=''
    lengthcle=len(k)
    lengthmes=len(m)
    j=0

    for i in range(lengthmes):
        nbMessage=ord(m[i])
        nbCle=ord(k[i%lengthcle])

        alMessage=nbMessage-65
        alCle=nbCle-65

        nbFinal=alMessage+alCle
        nbFinal=nbFinal%26

        nbFinal=nbFinal+65

        lt=chr(nbFinal)
        res=res+lt

    return res
def DechiffrmentVigemenre(k, m):
    res=''
    lengthcle=len(k)
    lengthmes=len(m)
    j=0

    for i in range(lengthmes):
        nbMessage=ord(m[i])
        nbCle=ord(k[i%lengthcle])

        alMessage=nbMessage-65
        alCle=nbCle-65

        nbFinal=alMessage-alCle
        nbFinal=nbFinal%26

        nbFinal=nbFinal+65

        lt=chr(nbFinal)
        res=res+lt

    return res
def RechercheVigenere(m, n):
    length=len(m)
    res=''

    for i in range(length):
        mAsc=ord(m[i])
        nAsc=ord(n[i])

        mAl=mAsc-65
        nAl=nAsc-65

        fAl=mAl-nAl
        fAl=fAl%26

        fAsc=fAl+65

        lt=chr(fAsc)
        res=res+lt

    return res
