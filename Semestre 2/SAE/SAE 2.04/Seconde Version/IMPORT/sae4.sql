DROP TABLE S24_UU_Caractérise;
DROP TABLE S24_departement_se_caracterise;
DROP TABLE S24_commune_se_caracterise;
DROP TABLE S24_contient_public;
DROP TABLE S24_se_categorise;
DROP TABLE S24_se_partage;
DROP TABLE S24_certifie;
DROP TABLE S24_se_repartit;
DROP TABLE S24_Cinema;
DROP TABLE S24_Commune;
DROP TABLE S24_Données_Cinema;
DROP TABLE S24_Donnees_Par_Unite_Urbaine;
DROP TABLE S24_Donnees_Par_Commune;
DROP TABLE S24_Donnees_Par_Departement;
DROP TABLE S24_Categories;
DROP TABLE S24_Public;
DROP TABLE S24_Frequentation_Semaine;
DROP TABLE S24_Frequentation_Mois;
DROP TABLE S24_Frequentation_Jours;
DROP TABLE S24_Art_Et_essai;
DROP TABLE S24_Marchés;
DROP TABLE S24_Localisation;
DROP TABLE S24_Unite_Urbaine;
DROP TABLE S24_Region;
DROP TABLE S24_Departement;

CREATE TABLE S24_Departement(
   numDepartement VARCHAR2(50),
   nomDepartement VARCHAR2(50) NOT NULL,
   PRIMARY KEY(numDepartement)
);

CREATE TABLE S24_Region(
   nouvelleRegion VARCHAR2(50),
   ancienneRegion VARCHAR2(50),
   PRIMARY KEY(nouvelleRegion)
);

CREATE TABLE S24_Unite_Urbaine(
   numUniteUrbaine VARCHAR2(50),
   nomUniteUrbaine VARCHAR2(50),
   populationUniteUrbaine NUMBER(10),
   PRIMARY KEY(numUniteUrbaine, nomUniteUrbaine)
);

CREATE TABLE S24_Localisation(
   geolocalisation VARCHAR2(50),
   latitude VARCHAR2(50),
   longitude VARCHAR2(50),
   PRIMARY KEY(geolocalisation)
);

CREATE TABLE S24_Marchés(
   idMarche VARCHAR2(50),
   PRIMARY KEY(idMarche)
);

CREATE TABLE S24_Art_Et_essai(
   numCinema NUMBER(10),
   ArtEtEssai NUMBER(1),
   categorieAE VARCHAR2(50),
   labelAE VARCHAR2(50),
   nbFilmsAE__C_ NUMBER(10),
   PdMentreesFilmsAE__C_ NUMBER(10),
   PRIMARY KEY(numCinema, ArtEtEssai)
);

CREATE TABLE S24_Frequentation_Jours(
   jourSemaine VARCHAR2(50),
   annee NUMBER(10),
   pourcentageEntrees__C_ BINARY_DOUBLE,
   pourcentageRecettes__C_ BINARY_DOUBLE,
   pourcentageSeances__C_ BINARY_DOUBLE,
   PRIMARY KEY(jourSemaine, annee)
);

CREATE TABLE S24_Frequentation_Mois(
   mois VARCHAR2(50),
   annee NUMBER(10),
   nbEntrees__C_ NUMBER(10),
   recettes__C_ BINARY_DOUBLE,
   nbSeances__C_ NUMBER(10),
   PRIMARY KEY(mois, annee)
);

CREATE TABLE S24_Frequentation_Semaine(
   semaine VARCHAR2(50),
   annee NUMBER(10),
   nbEntrees__C_ NUMBER(10),
   recettes__C_ BINARY_DOUBLE,
   nbSeances__C_ NUMBER(10),
   PRIMARY KEY(semaine, annee)
);

CREATE TABLE S24_Public(
   annee NUMBER(10),
   region VARCHAR2(50),
   pourcentage__C_ VARCHAR2(50),
   PRIMARY KEY(annee, region)
);

CREATE TABLE S24_Categories(
   typeCategorie VARCHAR2(50),
   categorie VARCHAR2(50),
   PRIMARY KEY(typeCategorie)
);

CREATE TABLE S24_Donnees_Par_Commune(
   numCommune VARCHAR2(50),
   annee NUMBER(10),
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
   PRIMARY KEY(numCommune, annee)
);

CREATE TABLE S24_Donnees_Par_Departement(
   numDepartement VARCHAR2(50),
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
   numUniteUrbaine VARCHAR2(50),
   année NUMBER(10),
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
   PRIMARY KEY(numUniteUrbaine, année)
);

CREATE TABLE S24_Données_Cinema(
   numCinema NUMBER(10),
   nbEcrans NUMBER(10),
   nbFauteils NUMBER(10),
   nbSemainesActivite__C_ NUMBER(10),
   nbSeances__C_ NUMBER(10),
   nbEntrees2020__C_ NUMBER(10),
   nbEntrees2019__C_ NUMBER(10),
   evolutionEntrees__C_ NUMBER(10),
   trancheEntrees__C_ VARCHAR2(50),
   nbFilmsProgrammes__C_ NUMBER(10),
   nbFilmsInedits__C_ NUMBER(10),
   nbFilmsSemaine1__C_ NUMBER(10),
   PdMentreesFilmsFR__C_ NUMBER(10),
   PdMentreesFilmsUSA__C_ NUMBER(10),
   PdMentreesFilmsEUR__C_ NUMBER(10),
   PdMentreesFilmsAutres__C_ NUMBER(10),
   PRIMARY KEY(numCinema)
);

CREATE TABLE S24_Commune(
   numCommune VARCHAR2(50),
   nomCommune VARCHAR2(50),
   populationCommune NUMBER(10),
   situationGeographique VARCHAR2(100),
   zoneCommune VARCHAR2(1),
   numDepartement VARCHAR2(50) NOT NULL,
   nouvelleRegion VARCHAR2(50) NOT NULL,
   numUniteUrbaine VARCHAR2(50),
   nomUniteUrbaine VARCHAR2(50),
   PRIMARY KEY(numCommune, nomCommune),
   FOREIGN KEY(numDepartement) REFERENCES S24_Departement(numDepartement),
   FOREIGN KEY(nouvelleRegion) REFERENCES S24_Region(nouvelleRegion),
   FOREIGN KEY(numUniteUrbaine, nomUniteUrbaine) REFERENCES S24_Unite_Urbaine(numUniteUrbaine, nomUniteUrbaine)
);

CREATE TABLE S24_Cinema(
   numCinema NUMBER(38),
   nomCinema VARCHAR2(50),
   adresseCinema VARCHAR2(50),
   proprietaireCinema VARCHAR2(75),
   programmateurCinema VARCHAR2(75),
   genre VARCHAR2(50),
   multiplexe VARCHAR2(50),
   geolocalisation VARCHAR2(50) NOT NULL,
   nouvelleRegion VARCHAR2(50) NOT NULL,
   numDepartement VARCHAR2(50),
   numCommune VARCHAR2(50),
   nomCommune VARCHAR2(50),
   PRIMARY KEY(numCinema),
   FOREIGN KEY(numCinema) REFERENCES S24_Données_Cinema(numCinema),
   FOREIGN KEY(geolocalisation) REFERENCES S24_Localisation(geolocalisation),
   FOREIGN KEY(nouvelleRegion) REFERENCES S24_Region(nouvelleRegion),
   FOREIGN KEY(numDepartement) REFERENCES S24_Departement(numDepartement),
   FOREIGN KEY(numCommune, nomCommune) REFERENCES S24_Commune(numCommune, nomCommune)
);

CREATE TABLE S24_se_repartit(
   numCinema NUMBER(10),
   idMarche VARCHAR2(50),
   numCinema_1 NUMBER(10),
   ArtEtEssai NUMBER(1),
   valeurMarche BINARY_DOUBLE,
   PRIMARY KEY(numCinema, idMarche, numCinema_1, ArtEtEssai),
   FOREIGN KEY(numCinema) REFERENCES S24_Cinema(numCinema),
   FOREIGN KEY(idMarche) REFERENCES S24_Marchés(idMarche),
   FOREIGN KEY(numCinema_1, ArtEtEssai) REFERENCES S24_Art_Et_essai(numCinema, ArtEtEssai)
);

CREATE TABLE S24_certifie(
   numCinema NUMBER(10),
   numCinema_1 NUMBER(10) NOT NULL,
   ArtEtEssai NUMBER(1) NOT NULL,
   PRIMARY KEY(numCinema),
   FOREIGN KEY(numCinema) REFERENCES S24_Cinema(numCinema),
   FOREIGN KEY(numCinema_1, ArtEtEssai) REFERENCES S24_Art_Et_essai(numCinema, ArtEtEssai)
);

CREATE TABLE S24_se_categorise(
   annee NUMBER(10),
   region VARCHAR2(50),
   typeCategorie VARCHAR2(50),
   PRIMARY KEY(annee, region, typeCategorie),
   FOREIGN KEY(annee, region) REFERENCES S24_Public(annee, region),
   FOREIGN KEY(typeCategorie) REFERENCES S24_Categories(typeCategorie)
);


CREATE TABLE S24_contient_public(
   nouvelleRegion VARCHAR2(50),
   annee NUMBER(10),
   region VARCHAR2(50),
   PRIMARY KEY(nouvelleRegion, annee, region),
   FOREIGN KEY(nouvelleRegion) REFERENCES S24_Region(nouvelleRegion),
   FOREIGN KEY(annee, region) REFERENCES S24_Public(annee, region)
);


CREATE TABLE S24_commune_se_caracterise(
   numCommune VARCHAR2(50),
   nomCommune VARCHAR2(50),
   numCommune_1 VARCHAR2(50),
   annee NUMBER(10),
   anee NUMBER(10),
   PRIMARY KEY(numCommune, nomCommune, numCommune_1, annee),
   FOREIGN KEY(numCommune, nomCommune) REFERENCES S24_Commune(numCommune, nomCommune),
   FOREIGN KEY(numCommune_1, annee) REFERENCES S24_Donnees_Par_Commune(numCommune, annee)
);

CREATE TABLE S24_departement_se_caracterise(
   numDepartement VARCHAR2(50),
   numDepartement_1 VARCHAR2(50),
   année NUMBER(10),
   PRIMARY KEY(numDepartement, numDepartement_1, année),
   FOREIGN KEY(numDepartement) REFERENCES S24_Departement(numDepartement),
   FOREIGN KEY(numDepartement_1, année) REFERENCES S24_Donnes_Par_departement(numDepartement, année)
);

CREATE TABLE S24_UU_Caractérise(
   numUniteUrbaine VARCHAR2(50),
   nomUniteUrbaine VARCHAR2(50),
   numUniteUrbaine_1 VARCHAR2(50),
   année NUMBER(10),
   PRIMARY KEY(numUniteUrbaine, nomUniteUrbaine, numUniteUrbaine_1, année),
   FOREIGN KEY(numUniteUrbaine, nomUniteUrbaine) REFERENCES S24_Unite_Urbaine(numUniteUrbaine, nomUniteUrbaine),
   FOREIGN KEY(numUniteUrbaine_1, année) REFERENCES S24_Donnees_Par_Unite_Urbaine(numUniteUrbaine, année)
);