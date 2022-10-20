DROP TABLE Travailler CASCADE CONSTRAINTS;
DROP TABLE EtreAffecte CASCADE CONSTRAINTS;
DROP TABLE ProjetsExternes CASCADE CONSTRAINTS;
DROP TABLE ProjetsInternes CASCADE CONSTRAINTS;
DROP TABLE Equipes CASCADE CONSTRAINTS;
DROP TABLE Salaries CASCADE CONSTRAINTS;

/* CREATION DES TABLES */

CREATE TABLE Salaries
(codeSalarie VARCHAR(5), nomSalarie VARCHAR(25), prenomSalarie VARCHAR(25), nbTotalJourneesTravail NUMBER,
CONSTRAINT pk_Salaries PRIMARY KEY (codeSalarie));

CREATE TABLE Equipes
(codeEquipe VARCHAR(5), nomEquipe VARCHAR(25), codeSalarieChef VARCHAR(5),
CONSTRAINT pk_Equipes PRIMARY KEY (codeEquipe),
CONSTRAINT fk_Equipes_codeSalarieChef FOREIGN KEY (codeSalarieChef) REFERENCES Salaries(codeSalarie));

CREATE TABLE ProjetsExternes
(codeProjet VARCHAR(5), nomProjet VARCHAR(60), villeProjet VARCHAR(25), clientProjet VARCHAR(25), codeEquipe VARCHAR(25),
CONSTRAINT nn_ProjetsExternes CHECK (codeEquipe IS NOT NULL),
CONSTRAINT pk_ProjetsExternes PRIMARY KEY (codeProjet),
CONSTRAINT fk_ProjetsExternes_codeEquipe FOREIGN KEY (codeEquipe) REFERENCES Equipes(codeEquipe));

CREATE TABLE ProjetsInternes
(codeProjet VARCHAR(5), nomProjet VARCHAR(60), serviceProjet VARCHAR(25), codeSalarieResponsable VARCHAR(5),
CONSTRAINT nn_ProjetsInternes CHECK (codeSalarieResponsable IS NOT NULL),
CONSTRAINT pk_ProjetsInternes PRIMARY KEY (codeProjet),
CONSTRAINT fk_ProjetsInternes_codeEquipe FOREIGN KEY (codeSalarieResponsable) REFERENCES Salaries(codeSalarie));

CREATE TABLE EtreAffecte
(codeSalarie VARCHAR(5), codeEquipe VARCHAR(5),
CONSTRAINT pk_EtreAffecte PRIMARY KEY (codeSalarie, codeEquipe),
CONSTRAINT fk_EtreAffecte_codeSalarie FOREIGN KEY (codeSalarie) REFERENCES Salaries(codeSalarie),
CONSTRAINT fk_EtreAffecte_codeEquipe FOREIGN KEY (codeEquipe) REFERENCES Equipes(codeEquipe));

CREATE TABLE Travailler
(codeSalarie VARCHAR(5), dateTravail DATE, codeProjet VARCHAR(5),
CONSTRAINT pk_Travailler PRIMARY KEY (codeSalarie, dateTravail, codeProjet),
CONSTRAINT fk_Travailler_codeSalarie FOREIGN KEY (codeSalarie) REFERENCES Salaries(codeSalarie),
CONSTRAINT fk_Travailler_codeProjet FOREIGN KEY (codeProjet) REFERENCES ProjetsExternes(codePRojet));



/* INSERTION DE DONNEES */ 

INSERT INTO Salaries (codeSalarie, nomSalarie,prenomSalarie, nbTotalJourneesTravail) (SELECT codeSalarie, nomSalarie,prenomSalarie, nbTotalJourneesTravail FROM Palleja.UNI2_Salaries);
INSERT INTO Equipes (codeEquipe, nomEquipe, codeSalarieChef) (SELECT codeEquipe, nomEquipe, codeSalarieChef FROM Palleja.UNI2_Equipes);
INSERT INTO ProjetsExternes (codeProjet, nomProjet, villeProjet, clientProjet, codeEquipe) (SELECT codeProjet, nomProjet, villeProjet, clientProjet, codeEquipe FROM Palleja.UNI2_ProjetsExternes);
INSERT INTO ProjetsInternes (codeProjet, nomProjet, serviceProjet, codeSalarieResponsable) (SELECT codeProjet, nomProjet, serviceProjet, codeSalarieResponsable FROM Palleja.UNI2_ProjetsInternes);
INSERT INTO EtreAffecte (codeSalarie, codeEquipe) (SELECT codeSalarie, codeEquipe FROM Palleja.UNI2_EtreAffecte);
INSERT INTO Travailler (codeSalarie, dateTravail, codeProjet) (SELECT codeSalarie, dateTravail, codeProjet FROM Palleja.UNI2_Travailler);

COMMIT;