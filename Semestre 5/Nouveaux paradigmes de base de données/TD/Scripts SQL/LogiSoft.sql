DROP TABLE Clients cascade constraint;
DROP TABLE Villes cascade constraint;
DROP TABLE Trains cascade constraint;
DROP TABLE Projets cascade constraint;
DROP TABLE Salaries cascade constraint;
DROP TABLE EtreAffecte cascade constraint;
DROP TABLE Diplomes cascade constraint;
DROP TABLE Posseder cascade constraint;
DROP TABLE Technologies cascade constraint;
DROP TABLE Connaitre cascade constraint;



-- creation des tables

CREATE TABLE Villes
(codeVille VARCHAR(3), nomVille VARCHAR(25), departementVille VARCHAR(25), 
CONSTRAINT pk_Villes PRIMARY KEY (codeVille)) ;


CREATE TABLE Trains
(codeVilleDepart VARCHAR(25), codeVilleArrivee VARCHAR(25), temps NUMBER, 
CONSTRAINT pk_Trains PRIMARY KEY (codeVilleDepart, codeVilleArrivee),
CONSTRAINT fk_Trains_depart FOREIGN KEY (codeVilleDepart) REFERENCES Villes(codeVille),
CONSTRAINT fk_Trains_arrivee FOREIGN KEY (codeVilleArrivee) REFERENCES Villes(codeVille)) ;


CREATE TABLE Clients
(numClient VARCHAR(5), nomClient VARCHAR(25), categorieClient VARCHAR(25), codeVille VARCHAR(3),
CONSTRAINT pk_Clients PRIMARY KEY (numClient),
CONSTRAINT fk_Clients_codeVille FOREIGN KEY (codeVille) REFERENCES Villes(codeVille)) ;


CREATE TABLE Projets
(codeProjet VARCHAR(5), nomProjet VARCHAR(25), typeProjet VARCHAR(25), budgetProjet NUMBER, numClient VARCHAR(5),
CONSTRAINT pk_Projets PRIMARY KEY (codeProjet),
CONSTRAINT fk_Projets_client FOREIGN KEY (numClient) REFERENCES Clients(numClient)) ;


CREATE TABLE Salaries
(numSalarie VARCHAR(5), nomSalarie VARCHAR(25), prenomSalarie VARCHAR(25), dateNaissanceSalarie DATE, codeVilleNaissance VARCHAR(3), categorieSalarie VARCHAR(25), salaireSalarie NUMBER, numSalarieChef VARCHAR(5),
CONSTRAINT pk_Salaries PRIMARY KEY (numSalarie),
CONSTRAINT fk_Salaries_chef FOREIGN KEY (numSalarieChef) REFERENCES Salaries(numSalarie),
CONSTRAINT fk_Salaries_ville FOREIGN KEY (codeVilleNaissance) REFERENCES Villes(codeVille)) ;


CREATE TABLE EtreAffecte
(codeProjet VARCHAR(5), numSalarie VARCHAR(5),
CONSTRAINT pk_EtreAffecte PRIMARY KEY (codeProjet, numSalarie),
CONSTRAINT fk_EtreAffecte_projet FOREIGN KEY (codeProjet) REFERENCES Projets(codeProjet),
CONSTRAINT fk_EtreAffecte_salarie FOREIGN KEY (numSalarie) REFERENCES Salaries(numSalarie)) ;


CREATE TABLE Diplomes
(referenceDiplome VARCHAR(5), nomDiplome VARCHAR(25),
CONSTRAINT pk_Diplomes PRIMARY KEY (referenceDiplome)) ;


CREATE TABLE Posseder
(referenceDiplome VARCHAR(5), numSalarie VARCHAR(5),
CONSTRAINT pk_Posseder PRIMARY KEY (referenceDiplome, numSalarie),
CONSTRAINT fk_Posseder_diplome FOREIGN KEY (referenceDiplome) REFERENCES Diplomes(referenceDiplome),
CONSTRAINT fk_Posseder_salarie FOREIGN KEY (numSalarie) REFERENCES Salaries(numSalarie)) ;


CREATE TABLE Technologies
(codeTechnologie VARCHAR(5), nomTechnologie VARCHAR(25), categorieTechnologie VARCHAR(25),
CONSTRAINT pk_Technologies PRIMARY KEY (codeTechnologie)) ;


CREATE TABLE Connaitre
(codeTechnologie VARCHAR(5), numSalarie VARCHAR(5),
CONSTRAINT pk_Connaitre PRIMARY KEY (codeTechnologie, numSalarie),
CONSTRAINT fk_Connaitre_techno FOREIGN KEY (codeTechnologie) REFERENCES Technologies(codeTechnologie),
CONSTRAINT fk_Connaitre_salarie FOREIGN KEY (numSalarie) REFERENCES Salaries(numSalarie)) ;


--insertion de données dans les tables

INSERT INTO Villes (codeVille, nomVille, departementVille) (SELECT * FROM Palleja.LOGI2_Villes);
INSERT INTO Trains (codeVilleDepart, codeVilleArrivee, temps) (SELECT * FROM Palleja.LOGI2_Trains);
INSERT INTO Clients (numClient, nomClient, categorieClient, codeVille) (SELECT * FROM Palleja.LOGI2_Clients);
INSERT INTO Projets (codeProjet, nomProjet, typeProjet, budgetProjet, numClient) (SELECT * FROM Palleja.LOGI2_Projets);
INSERT INTO Salaries (numSalarie, nomSalarie, prenomSalarie, dateNaissanceSalarie, codeVilleNaissance, categorieSalarie, salaireSalarie, numSalarieChef) (SELECT * FROM Palleja.LOGI2_Salaries) ;
INSERT INTO EtreAffecte (codeProjet, numSalarie) (SELECT * FROM Palleja.LOGI2_EtreAffecte) ;
INSERT INTO Diplomes (referenceDiplome,nomDiplome) (SELECT * FROM Palleja.LOGI2_Diplomes) ;
INSERT INTO Posseder (referenceDiplome, numSalarie) (SELECT * FROM Palleja.LOGI2_Posseder) ;
INSERT INTO Technologies (codeTechnologie, nomTechnologie, categorieTechnologie) (SELECT * FROM Palleja.LOGI2_Technologies) ;
INSERT INTO Connaitre (codeTechnologie, numSalarie) (SELECT * FROM Palleja.LOGI2_Connaitre) ;


COMMIT;
