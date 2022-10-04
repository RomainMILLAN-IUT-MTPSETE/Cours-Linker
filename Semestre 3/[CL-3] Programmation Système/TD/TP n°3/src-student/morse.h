#ifndef __MORSE
#define __MORSE 1
//tableau de codage des lettres de l alphabet en morse
extern const char *code_morse[26];

/*
fonction pour retrouver un caractere de l alphabet a partir de son code Morse.
la fonction envoie -1 en cas d erreur et 0 en cas de succes.
la reference caracter_ptr est utilise pour copier la lettre decodee.
*/
int from_code_to_caracter(const char *code, char *caracter_ptr);

#endif