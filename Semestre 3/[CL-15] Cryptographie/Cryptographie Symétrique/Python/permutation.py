def ChiffrementPermutation(f,m):
    res=''
    alphabet=['A','B','C','D','E','F', 'G', 'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
    for i in range(len(m)):
        res=res+f[alphabet.index(m[i])]

    return res
def DechiffrementPermutation(f,m):
    res=''
    alphabet=['A','B','C','D','E','F', 'G', 'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
    for i in range(len(m)):
        res=res+alphabet[f.index(m[i])]

    return res
