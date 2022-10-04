#include "morse.h"
#include <string.h>
#include <stdio.h>

const char *code_morse[26] = {
    ".-",   // A
    "-...", // B
    "-.-.", // C
    "-..",  // D
    ".",    // E
    "..-.", // F
    "--.",  // G
    "....", // H
    "..",   // I
    ".---", // J
    "-.-",  // K
    ".-..", // L
    "--",   // M
    "-.",   // N
    "---",  // O
    ".--.", // P
    "--.-", // Q
    ".-.",  // R
    "...",  // S
    "-",    // T
    "..-",  // U
    "...-", // V
    ".--",  // W
    "-..-", // X
    "-.--", // Y
    "--.."  // Z
};

int from_code_to_caracter(const char *code, char *caracter_ptr)
{
    int len = strlen(code);
    if (len > 4)
    {
        printf("code morce incorrect %s\n", code);
        return -1;
    }
    //simple boucle pour rendre le code => on peut optimiser ici avec un hachage
    for (int i = 0; i < 26; i++)
    {
        if (strcmp(code_morse[i], code) == 0)
        {
            *caracter_ptr = ('a' + i);
            return 0;
        }
    }
    //pas de resultat
    return -1;
}