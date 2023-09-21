DROP TABLE Oraux CASCADE CONSTRAINT;
DROP TABLE UV CASCADE CONSTRAINT;
DROP TABLE Etudiants CASCADE CONSTRAINT;
DROP TABLE Classes CASCADE CONSTRAINT;
DROP TABLE Profs CASCADE CONSTRAINT;


CREATE TABLE Profs (codeProf VARCHAR2(5), nomProf VARCHAR2(20), prenomProf VARCHAR2(20), sexeProf VARCHAR2(1), typeProf VARCHAR2(9), dateProf DATE, salaireProf NUMBER,
CONSTRAINT pk_Profs PRIMARY KEY (codeProf),
CONSTRAINT nn_Profs_nom CHECK (nomProf IS NOT NULL),
CONSTRAINT ck_Profs_type CHECK (typeProf = 'Titulaire' OR typeProf = 'Vacataire')) ;

CREATE TABLE Classes (nomClasse VARCHAR2(5), codeProfPrincipal VARCHAR2(5), 
CONSTRAINT pk_Classes PRIMARY KEY (nomClasse),
CONSTRAINT un_Classes_principal UNIQUE (codeProfPrincipal)) ;

CREATE TABLE Etudiants (numEtudiant VARCHAR2(5), nomEtudiant VARCHAR2(20), prenomEtudiant VARCHAR2(20), dateEtudiant DATE, nomClasse VARCHAR2(5), numEtudiantParrain VARCHAR2(5),
CONSTRAINT pk_Etudiants PRIMARY KEY (numEtudiant),
CONSTRAINT nn_Etudiants_nom CHECK (nomEtudiant IS NOT NULL),
CONSTRAINT fk_Etudiants_parrain FOREIGN KEY (numEtudiantParrain) REFERENCES Etudiants(numEtudiant),
CONSTRAINT fk_Etudiants_classe FOREIGN KEY (nomClasse) REFERENCES Classes(nomClasse)) ;

CREATE TABLE UV
(codeUV VARCHAR2(5), nomUV VARCHAR2(20), nomComposante VARCHAR2(20), codeProfResponsable VARCHAR2(5),
CONSTRAINT pk_UV PRIMARY KEY (codeUV),
CONSTRAINT fk_UV_prof FOREIGN KEY (codeProfResponsable) REFERENCES Profs(codeProf)) ;

CREATE TABLE Oraux
(idOral VARCHAR2(3), numEtudiant VARCHAR2(5), codeUV VARCHAR2(5), note NUMBER(2,0), 
CONSTRAINT pk_Oraux PRIMARY KEY (idOral),
CONSTRAINT fk_Oraux_etudiant FOREIGN KEY (numEtudiant) REFERENCES Etudiants(numEtudiant),
CONSTRAINT fk_Oraux_UV FOREIGN KEY (codeUV) REFERENCES UV(codeUV)) ;


INSERT INTO Profs (codeProf, nomProf, prenomProf, sexeProf, typeProf, dateProf, salaireProf) (SELECT codeProf, nomProf, prenomProf, sexeProf, typeProf, dateProf, salaireProf FROM Palleja.NOTESNULL_Profs);
INSERT INTO Classes (nomClasse, codeProfPrincipal) (SELECT nomClasse, codeProfPrincipal FROM Palleja.NOTESNULL_Classes);
INSERT INTO UV (codeUV, nomUV, nomComposante, codeProfResponsable) (SELECT codeUV, nomUV, nomComposante, codeProfResponsable FROM Palleja.NOTESNULL_UV);
INSERT INTO Etudiants (numEtudiant, nomEtudiant, prenomEtudiant, dateEtudiant, nomClasse, numEtudiantParrain) (SELECT numEtudiant, nomEtudiant, prenomEtudiant, dateEtudiant, nomClasse, numEtudiantParrain FROM Palleja.NOTESNULL_Etudiants);
INSERT INTO Oraux (idOral, numEtudiant, codeUV, note) (SELECT idOral, numEtudiant, codeUV, note FROM Palleja.NOTESNULL_Oraux);

COMMIT;

