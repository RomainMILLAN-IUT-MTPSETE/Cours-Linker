CREATE TABLE Editeurs
(idEditeur VARCHAR(5), nomEditeur VARCHAR(25), paysEditeur VARCHAR(50),
CONSTRAINT pk_Editeurs PRIMARY KEY (idEditeur),
CONSTRAINT un_Editeurs_nom_pays UNIQUE (nomEditeur, paysEditeur));

CREATE TABLE Livres
(idLivre VARCHAR(5), nomLivre VARCHAR(50), anneeLivre NUMBER, prixLivre NUMBER, categorieLivre VARCHAR(50), idEditeur VARCHAR(5), 
CONSTRAINT pk_Livres PRIMARY KEY (idLivre),
CONSTRAINT fk_Livres_idEditeur FOREIGN KEY (idEditeur) REFERENCES Editeurs(idEditeur));


CREATE TABLE Adherents
(idAdherent VARCHAR(5), nomAdherent VARCHAR(25), prenomAdherent VARCHAR(25), typeAdherent VARCHAR(25), idAdherentParrain VARCHAR(5),
CONSTRAINT pk_Adherents PRIMARY KEY (idAdherent),
CONSTRAINT fk_Adherents_parrain FOREIGN KEY (idAdherentParrain) REFERENCES Adherents(idAdherent)) ;


CREATE TABLE Emprunts
(idEmprunt VARCHAR(5), dateEmprunt DATE, dateRetour DATE, idLivre VARCHAR(5), idAdherent VARCHAR(5),
CONSTRAINT pk_Emprunts PRIMARY KEY (idEmprunt),
CONSTRAINT fk_Emprunts_idLivre FOREIGN KEY (idLivre) REFERENCES Livres(idLivre),
CONSTRAINT fk_Emprunts_idAdherent FOREIGN KEY (idAdherent) REFERENCES Adherents(idAdherent));


--insertion de données dans les tables

INSERT INTO Editeurs (idEditeur, nomEditeur, paysEditeur) (SELECT idEditeur, nomEditeur, paysEditeur FROM Palleja.BIBLI_Editeurs);
INSERT INTO Livres (idLivre, nomLivre, anneeLivre, prixLivre, categorieLivre, idEditeur) (SELECT idLivre, nomLivre, anneeLivre, prixLivre, categorieLivre, idEditeur FROM Palleja.BIBLI_Livres);
INSERT INTO Adherents (idAdherent, nomAdherent, prenomAdherent, typeAdherent, idAdherentParrain) (SELECT idAdherent, nomAdherent, prenomAdherent, typeAdherent, idAdherentParrain FROM Palleja.BIBLI_Adherents);
INSERT INTO Emprunts (idEmprunt, dateEmprunt, dateRetour, idLivre, idAdherent) (SELECT idEmprunt, dateEmprunt, dateRetour, idLivre, idAdherent FROM Palleja.BIBLI_Emprunts);

COMMIT;