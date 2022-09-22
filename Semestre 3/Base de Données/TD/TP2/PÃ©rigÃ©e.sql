DROP TABLE Promotions CASCADE CONSTRAINT;
DROP TABLE Groupes CASCADE CONSTRAINT;
DROP TABLE Etudiants CASCADE CONSTRAINT;
DROP TABLE Semestres CASCADE CONSTRAINT;
DROP TABLE Modules CASCADE CONSTRAINT;
DROP TABLE Matieres CASCADE CONSTRAINT;
DROP TABLE Notes CASCADE CONSTRAINT;
DROP TABLE Absences CASCADE CONSTRAINT;
DROP TABLE JustificatifsAbsences CASCADE CONSTRAINT;

-- creation des tables

CREATE TABLE Promotions
(idPromotion VARCHAR(5), nomPromotion VARCHAR(25), nbEtudiantsPromotion NUMBER,
CONSTRAINT pk_Promotions PRIMARY KEY (idPromotion));

CREATE TABLE Groupes
(idGroupe VARCHAR(5), idPromotion VARCHAR(5),
CONSTRAINT pk_Groupes PRIMARY KEY (idGroupe),
CONSTRAINT fk_Groupes_idPromotion FOREIGN KEY (idPromotion) REFERENCES Promotions(idPromotion));

CREATE TABLE Etudiants
(idEtudiant VARCHAR(5), nomEtudiant VARCHAR(25), prenomEtudiant VARCHAR(25), sexeEtudiant VARCHAR(1), dateNaissanceEtudiant DATE, idGroupe VARCHAR(5), 
CONSTRAINT pk_Etudiants PRIMARY KEY (idEtudiant),
CONSTRAINT fk_Etudiants_idGroupe FOREIGN KEY (idGroupe) REFERENCES Groupes(idGroupe));

CREATE TABLE Semestres
(idSemestre VARCHAR(5), dateDebutSemestre DATE, dateFinSemestre DATE, idPromotion VARCHAR(5),
CONSTRAINT pk_Semestres PRIMARY KEY (idSemestre),
CONSTRAINT fk_Semestres_idPromotion FOREIGN KEY (idPromotion) REFERENCES Promotions(idPromotion));

CREATE TABLE Modules
(idModule VARCHAR(5), nomModule VARCHAR(25), idSemestre VARCHAR(5), coefficientModule NUMBER,
CONSTRAINT pk_Modules PRIMARY KEY (idModule),
CONSTRAINT fk_Modules_idSemestre FOREIGN KEY (idSemestre) REFERENCES Semestres(idSemestre));

CREATE TABLE Matieres
(idMatiere VARCHAR(5), nomMatiere VARCHAR(25), idModule VARCHAR(5), coefficientMatiere NUMBER,
CONSTRAINT pk_Matieres PRIMARY KEY (idMatiere),
CONSTRAINT fk_Matieres_idModule FOREIGN KEY (idModule) REFERENCES Modules(idModule));

CREATE TABLE Notes
(idEtudiant VARCHAR(5), idMatiere VARCHAR(5), note NUMBER,
CONSTRAINT pk_Notes PRIMARY KEY (idEtudiant, idMatiere),
CONSTRAINT fk_Notes_idEtudiant FOREIGN KEY (idEtudiant) REFERENCES Etudiants(idEtudiant),
CONSTRAINT fk_Notes_idMatiere FOREIGN KEY (idMatiere) REFERENCES Matieres(idMatiere));

CREATE TABLE Absences
(idAbsence VARCHAR(5), idEtudiant VARCHAR(5), dateHeureDebutAbsence DATE, dateHeureFinAbsence DATE,
CONSTRAINT pk_Absences PRIMARY KEY (idAbsence),
CONSTRAINT fk_Absences_idEtudiant FOREIGN KEY (idEtudiant) REFERENCES Etudiants(idEtudiant));

CREATE TABLE JustificatifsAbsences
(idJustificatifAbsence VARCHAR(5), idEtudiant VARCHAR(5), dateDebutJustificatif DATE, dateFinJustificatif DATE, motifJustificatif VARCHAR(50),
CONSTRAINT pk_Justificatifs PRIMARY KEY (idJustificatifAbsence),
CONSTRAINT fk_Justificatifs_idEtudiant FOREIGN KEY (idEtudiant) REFERENCES Etudiants(idEtudiant));


--insertion de données dans les tables

INSERT INTO Promotions (idPromotion, nomPromotion, nbEtudiantsPromotion) (SELECT * FROM Palleja.PERI3_Promotions);
INSERT INTO Groupes (idGroupe, idPromotion) (SELECT * FROM Palleja.PERI3_Groupes);
INSERT INTO Etudiants (idEtudiant, nomEtudiant, prenomEtudiant, sexeEtudiant, dateNaissanceEtudiant, idGroupe) (SELECT * FROM Palleja.PERI3_Etudiants);
INSERT INTO Semestres (idSemestre, dateDebutSemestre, dateFinSemestre, idPromotion) (SELECT * FROM Palleja.PERI3_Semestres);
INSERT INTO Modules (idModule, nomModule, idSemestre, coefficientModule) (SELECT * FROM Palleja.PERI3_Modules);
INSERT INTO Matieres (idMatiere, nomMatiere, idModule, coefficientMatiere) (SELECT * FROM Palleja.PERI3_Matieres);
INSERT INTO Notes (idEtudiant, idMatiere, note) (SELECT * FROM Palleja.PERI3_Notes);
INSERT INTO Absences (idAbsence, idEtudiant, dateHeureDebutAbsence, dateHeureFinAbsence) (SELECT * FROM Palleja.PERI3_Absences);
INSERT INTO JustificatifsAbsences (idJustificatifAbsence, idEtudiant, dateDebutJustificatif, dateFinJustificatif, motifJustificatif) (SELECT * FROM Palleja.PERI3_JustificatifsAbsences);

COMMIT;
