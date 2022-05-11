DROP TABLE S24_UU_Caractérise;
DROP TABLE S24_departement_se_caracterise;
DROP TABLE S24_commune_se_caracterise;
DROP TABLE S24_contient_public;
DROP TABLE S24_se_categorise;
DROP TABLE S24_se_partage;
DROP TABLE S24_propose;
DROP TABLE S24_certifie;
DROP TABLE S24_se_repartit;
DROP TABLE S24_Cinema;
DROP TABLE S24_Commune;
DROP TABLE S24_Programmateur;
DROP TABLE S24_Proprietaire;
DROP TABLE S24_Données_Cinéma;
DROP TABLE S24_Donnees_Par_Unite_Urbaine;
DROP TABLE S24_Donnes_Par_departement;
DROP TABLE S24_Donnees_Par_Commune;
DROP TABLE S24_Categories;
DROP TABLE S24_Public;
DROP TABLE S24_Frequentation_Semaine;
DROP TABLE S24_Frequentation_Mois;
DROP TABLE S24_Frequentation_Jours;
DROP TABLE S24_Films;
DROP TABLE S24_Art_Et_essai;
DROP TABLE S24_Marchés;
DROP TABLE S24_Localisation;
DROP TABLE S24_Unite_Urbaine;
DROP TABLE S24_Region;
DROP TABLE S24_Departement;

CREATE TABLE S24_Departement(
   numDepartement NUMBER(10),
   nomDepartement VARCHAR2(50),
   PRIMARY KEY(numDepartement, nomDepartement)
);

CREATE TABLE S24_Region(
   nouvelleRegion VARCHAR2(50),
   ancienneRegion VARCHAR2(50),
   PRIMARY KEY(nouvelleRegion)
);

CREATE TABLE S24_Unite_Urbaine(
   numUniteUrbaine NUMBER(10),
   nomUniteUrbaine VARCHAR2(50),
   populationUniteUrbaine NUMBER(10),
   PRIMARY KEY(numUniteUrbaine, nomUniteUrbaine)
);

CREATE TABLE S24_Localisation(
   geolocalisation VARCHAR(50),
   latitude VARCHAR(50),
   longitude VARCHAR(50),
   PRIMARY KEY(geolocalisation)
);

CREATE TABLE S24_Marchés(
   idMarche VARCHAR2(50),
   PRIMARY KEY(idMarche)
);

CREATE TABLE S24_Art_Et_essai(
   idAE NUMBER(10),
   categorieAE VARCHAR2(50),
   labelAE VARCHAR2(50),
   nbFilmsAE__C_ NUMBER(10),
   PdMentreesFilmsAE__C_ NUMBER(10),
   PRIMARY KEY(idAE)
);

CREATE TABLE S24_Films(
   Catégorie VARCHAR2(50),
   PRIMARY KEY(Catégorie)
);

CREATE TABLE S24_Frequentation_Jours(
   jourSemaine VARCHAR2(50),
   année NUMBER(10),
   pourcentageEntrees__C_ BINARY_DOUBLE,
   pourcentageRecettes__C_ BINARY_DOUBLE,
   pourcentageSeances__C_ BINARY_DOUBLE,
   PRIMARY KEY(jourSemaine, année)
);

CREATE TABLE S24_Frequentation_Mois(
   mois VARCHAR2(50),
   année NUMBER(10),
   nbEntrees__C_ NUMBER(10),
   recettes__C_ BINARY_DOUBLE,
   nbSeances__C_ NUMBER(10),
   PRIMARY KEY(mois, année)
);

CREATE TABLE S24_Frequentation_Semaine(
   semaine VARCHAR2(50),
   année NUMBER(10),
   nbEntrees__C_ NUMBER(10),
   recettes__C_ BINARY_DOUBLE,
   nbSeances__C_ NUMBER(10),
   PRIMARY KEY(semaine, année)
);

CREATE TABLE S24_Public(
   annee NUMBER(10),
   pourcentage__C_ VARCHAR2(50),
   PRIMARY KEY(annee)
);

CREATE TABLE S24_Categories(
   typeCategorie VARCHAR2(50),
   categorie VARCHAR2(50),
   PRIMARY KEY(typeCategorie)
);

CREATE TABLE S24_Donnees_Par_Commune(
   idDonnees NUMBER(10),
   nbEtablissements__C_ NUMBER(10),
   nbEcrans__C_ NUMBER(10),
   nbFauteuils__C_ NUMBER(10),
   nbMultiplexes__C_ NUMBER(10),
   nbSeances__C_ NUMBER(10),
   nbEntrees__C_ NUMBER(10),
   recettes__C_ BINARY_DOUBLE,
   RME BINARY_DOUBLE,
   indiceFrequentation__C_ BINARY_DOUBLE,
   tauxOccupation__C_ BINARY_DOUBLE,
   nbCinemasArtEssai__C_ NUMBER(10),
   PRIMARY KEY(idDonnees)
);

CREATE TABLE S24_Donnes_Par_departement(
   numDepartement NUMBER(10),
   année NUMBER(10),
   nbEcrans__C_ NUMBER(10),
   nbFauteuils__C_ NUMBER(10),
   nbMultiplexes__C_ NUMBER(10),
   nbSeances__C_ NUMBER(10),
   nbEntrees__C_ NUMBER(10),
   recettes__C_ NUMBER(10),
   tauxOccupation__C_ BINARY_DOUBLE,
   nbEtablissementsAE__C_ NUMBER(10),
   nbEcransAE__C_ NUMBER(10),
   nbFauteuilsAE__C_ NUMBER(10),
   nbSeancesAE__C_ NUMBER(10),
   nbEntreesAE__C_ NUMBER(10),
   tauxOccupationAE__C_ BINARY_DOUBLE,
   recettesAE__C_ BINARY_DOUBLE,
   nbHabitantsDepartement__C_ NUMBER(10),
   nbEtablissements__C_ NUMBER(10),
   PRIMARY KEY(numDepartement, année)
);

CREATE TABLE S24_Donnees_Par_Unite_Urbaine(
   idDonnees NUMBER(10),
   nbEtablissements__C_ NUMBER(10),
   nbFauteuils__C_ NUMBER(10),
   nbMultiplexes__C_ NUMBER(10),
   nbSeances__C_ NUMBER(10),
   nbEntrees__C_ NUMBER(10),
   recettes__C_ BINARY_DOUBLE,
   tauxOccupation__C_ BINARY_DOUBLE,
   nbEtablissementsAE__C_ NUMBER(10),
   nbEcransAE__C_ NUMBER(10),
   nbFauteuilsAE__C_ NUMBER(10),
   nbSeancesAE__C_ NUMBER(10),
   nbEntreesAE__C_ NUMBER(10),
   recettesAE__C_ NUMBER(10),
   tauxOccupationAE__C_ BINARY_DOUBLE,
   nbEcrans__C_ NUMBER(10),
   PRIMARY KEY(idDonnees)
);

CREATE TABLE S24_Données_Cinéma(
   numCinéma NUMBER(10),
   nbFilmsProgrammes__C_ NUMBER(10),
   nbFilmsInedits__C_ NUMBER(10),
   nbFilmsSemaine1__C_ NUMBER(10),
   PdMentreesFilmsFR__C_ NUMBER(10),
   PdMentreesFilmsUSA__C_ NUMBER(10),
   PdMentreesFilmsEUR__C_ NUMBER(10),
   PdMentreesFilmsAutres__C_ NUMBER(10),
   PRIMARY KEY(numCinéma)
);

CREATE TABLE S24_Commune(
   numCommune NUMBER(10),
   nomCommune VARCHAR2(50),
   populationCommune NUMBER(10),
   situationGeographique VARCHAR2(100),
   zoneCommune VARCHAR2(1),
   numDepartement NUMBER(10) NOT NULL,
   nomDepartement VARCHAR2(50) NOT NULL,
   nouvelleRegion VARCHAR2(50) NOT NULL,
   numUniteUrbaine NUMBER(10),
   nomUniteUrbaine VARCHAR2(50),
   PRIMARY KEY(numCommune, nomCommune),
   FOREIGN KEY(numDepartement, nomDepartement) REFERENCES S24_Departement(numDepartement, nomDepartement),
   FOREIGN KEY(nouvelleRegion) REFERENCES S24_Region(nouvelleRegion),
   FOREIGN KEY(numUniteUrbaine, nomUniteUrbaine) REFERENCES S24_Unite_Urbaine(numUniteUrbaine, nomUniteUrbaine)
);

CREATE TABLE S24_Cinema(
   numCinema NUMBER(10),
   nomCinema VARCHAR2(50),
   adresseCinema VARCHAR2(50),
   proprietaireCinema VARCHAR2(75),
   programmateurCinema VARCHAR2(75),
   genre VARCHAR2(50),
   multiplexe VARCHAR2(50),
   numCinéma NUMBER(10) NOT NULL,
   geolocalisation VARCHAR(50) NOT NULL,
   nouvelleRegion VARCHAR2(50),
   numDepartement NUMBER(10),
   nomDepartement VARCHAR2(50),
   numCommune NUMBER(10),
   nomCommune VARCHAR2(50),
   PRIMARY KEY(numCinema),
   FOREIGN KEY(numCinéma) REFERENCES S24_Données_Cinéma(numCinéma),
   FOREIGN KEY(geolocalisation) REFERENCES S24_Localisation(geolocalisation),
   FOREIGN KEY(nouvelleRegion) REFERENCES S24_Region(nouvelleRegion),
   FOREIGN KEY(numDepartement, nomDepartement) REFERENCES S24_Departement(numDepartement, nomDepartement),
   FOREIGN KEY(numCommune, nomCommune) REFERENCES S24_Commune(numCommune, nomCommune)
);


CREATE TABLE S24_se_repartit(
   numCinema NUMBER(10),
   idMarche VARCHAR2(50),
   idAE NUMBER(10),
   valeurMarche BINARY_DOUBLE,
   PRIMARY KEY(numCinema, idMarche, idAE),
   FOREIGN KEY(numCinema) REFERENCES S24_Cinema(numCinema),
   FOREIGN KEY(idMarche) REFERENCES S24_Marchés(idMarche),
   FOREIGN KEY(idAE) REFERENCES S24_Art_Et_essai(idAE)
);


CREATE TABLE S24_certifie(
   numCinema NUMBER(10),
   AE NUMBER(1),
   idAE NUMBER(10) NOT NULL,
   PRIMARY KEY(numCinema),
   FOREIGN KEY(numCinema) REFERENCES S24_Cinema(numCinema),
   FOREIGN KEY(idAE) REFERENCES S24_Art_Et_essai(idAE)
);

CREATE TABLE S24_propose(
   numCinema NUMBER(10),
   Catégorie VARCHAR2(50),
   nbFilms NUMBER(10),
   PRIMARY KEY(numCinema, Catégorie),
   FOREIGN KEY(numCinema) REFERENCES S24_Cinema(numCinema),
   FOREIGN KEY(Catégorie) REFERENCES S24_Films(Catégorie)
);

CREATE TABLE S24_se_partage(
   numCinema NUMBER(10),
   jourSemaine VARCHAR2(50),
   année NUMBER(10),
   mois VARCHAR2(50),
   année_1 NUMBER(10),
   semaine VARCHAR2(50),
   année_2 NUMBER(10),
   PRIMARY KEY(numCinema, jourSemaine, année, mois, année_1, semaine, année_2),
   FOREIGN KEY(numCinema) REFERENCES S24_Cinema(numCinema),
   FOREIGN KEY(jourSemaine, année) REFERENCES S24_Frequentation_Jours(jourSemaine, année),
   FOREIGN KEY(mois, année_1) REFERENCES S24_Frequentation_Mois(mois, année),
   FOREIGN KEY(semaine, année_2) REFERENCES S24_Frequentation_Semaine(semaine, année)
);


CREATE TABLE S24_se_categorise(
   annee NUMBER(10),
   typeCategorie VARCHAR2(50),
   PRIMARY KEY(annee, typeCategorie),
   FOREIGN KEY(annee) REFERENCES S24_Public(annee),
   FOREIGN KEY(typeCategorie) REFERENCES S24_Categories(typeCategorie)
);

CREATE TABLE S24_contient_public(
   nouvelleRegion VARCHAR2(50),
   annee NUMBER(10),
   PRIMARY KEY(nouvelleRegion, annee),
   FOREIGN KEY(nouvelleRegion) REFERENCES S24_Region(nouvelleRegion),
   FOREIGN KEY(annee) REFERENCES S24_Public(annee)
);

CREATE TABLE S24_commune_se_caracterise(
   numCommune NUMBER(10),
   nomCommune VARCHAR2(50),
   idDonnees NUMBER(10),
   anee NUMBER(10),
   PRIMARY KEY(numCommune, nomCommune, idDonnees),
   FOREIGN KEY(numCommune, nomCommune) REFERENCES S24_Commune(numCommune, nomCommune),
   FOREIGN KEY(idDonnees) REFERENCES S24_Donnees_Par_Commune(idDonnees)
);

CREATE TABLE S24_departement_se_caracterise(
   numDepartement NUMBER(10),
   nomDepartement VARCHAR2(50),
   numDepartement_1 NUMBER(10),
   année NUMBER(10),
   PRIMARY KEY(numDepartement, nomDepartement, numDepartement_1, année),
   FOREIGN KEY(numDepartement, nomDepartement) REFERENCES S24_Departement(numDepartement, nomDepartement),
   FOREIGN KEY(numDepartement_1, année) REFERENCES S24_Donnes_Par_departement(numDepartement, année)
);



CREATE TABLE S24_UU_Caractérise(
   numUniteUrbaine NUMBER(10),
   nomUniteUrbaine VARCHAR2(50),
   idDonnees NUMBER(10),
   annee NUMBER(10),
   PRIMARY KEY(numUniteUrbaine, nomUniteUrbaine, idDonnees),
   FOREIGN KEY(numUniteUrbaine, nomUniteUrbaine) REFERENCES S24_Unite_Urbaine(numUniteUrbaine, nomUniteUrbaine),
   FOREIGN KEY(idDonnees) REFERENCES S24_Donnees_Par_Unite_Urbaine(idDonnees)
);