DROP TABLE Employes CASCADE CONSTRAINT;
DROP TABLE Proposer CASCADE CONSTRAINT;
DROP TABLE Services CASCADE CONSTRAINT;
DROP TABLE Locations CASCADE CONSTRAINT;
DROP TABLE Bungalows CASCADE CONSTRAINT;
DROP TABLE Campings CASCADE CONSTRAINT;
DROP TABLE Clients CASCADE CONSTRAINT;


-- creation des tables

CREATE TABLE Clients
(idClient VARCHAR(5), nomClient VARCHAR(25), prenomClient VARCHAR(25), dateNaissanceClient DATE, villeClient VARCHAR(25), 
CONSTRAINT pk_Clients PRIMARY KEY (idClient)) ;

CREATE TABLE Campings
(idCamping VARCHAR(5), nomCamping VARCHAR(25), villeCamping VARCHAR(25), nbEtoilesCamping NUMBER, 
CONSTRAINT pk_Campings PRIMARY KEY (idCamping)) ;


CREATE TABLE Bungalows
(idBungalow VARCHAR(5), nomBungalow VARCHAR(25), superficieBungalow NUMBER, idCamping VARCHAR(5),
CONSTRAINT pk_Bungalows PRIMARY KEY (idBungalow),
CONSTRAINT fk_Bungalows_idCamping FOREIGN KEY (idCamping) REFERENCES Campings(idCamping),
CONSTRAINTS un_Bungalows_nomBun_idCamp UNIQUE (nomBungalow , idCamping)) ;

CREATE TABLE Locations
(idLocation VARCHAR(5), idClient VARCHAR(5), idBungalow VARCHAR(5), dateDebut DATE, dateFin DATE, montantLocation NUMBER,
CONSTRAINT pk_Locations PRIMARY KEY (idLocation),
CONSTRAINT fk_Locations_idClient FOREIGN KEY (idClient) REFERENCES Clients(idClient),
CONSTRAINT fk_Locations_idBungalow FOREIGN KEY (idBungalow) REFERENCES Bungalows(idBungalow),
CONSTRAINT nn_Locations_idClient CHECK (idClient IS NOT NULL),
CONSTRAINT nn_Locations_idBungalow CHECK (idBungalow IS NOT NULL)) ;

CREATE TABLE Services
(idService VARCHAR(5), nomService VARCHAR(25), categorieService VARCHAR(25), 
CONSTRAINT pk_Services PRIMARY KEY (idService)) ;

CREATE TABLE Proposer
(idBungalow VARCHAR(5), idService VARCHAR(5),
CONSTRAINT pk_Proposer PRIMARY KEY (idBungalow, idService),
CONSTRAINT fk_Proposer_idBungalow FOREIGN KEY (idBungalow) REFERENCES Bungalows(idBungalow),
CONSTRAINT fk_Proposer_idService FOREIGN KEY (idService) REFERENCES Services(idService));

CREATE TABLE Employes
(idEmploye VARCHAR(5), nomEmploye VARCHAR(25), prenomEmploye VARCHAR(25), salaireEmploye NUMBER, idCamping VARCHAR(5), idEmployeChef VARCHAR(5),
CONSTRAINT pk_Employes PRIMARY KEY (idEmploye),
CONSTRAINT fk_Employes_idCamping FOREIGN KEY (idCamping) REFERENCES Campings(idCamping),
CONSTRAINT fk_Employes_idEmployeChef FOREIGN KEY (idEmployeChef) REFERENCES Employes(idEmploye)) ;


--insertion de données dans les tables

INSERT INTO Clients (idClient, nomClient, prenomClient, dateNaissanceClient, villeClient) (SELECT idClient, nomClient, prenomClient, dateNaissanceClient, villeClient FROM Palleja.CAMP_Clients);
INSERT INTO Campings (idCamping, nomCamping, villeCamping, nbEtoilesCamping)(SELECT idCamping, nomCamping, villeCamping, nbEtoilesCamping FROM Palleja.CAMP_Campings);
INSERT INTO Bungalows (idBungalow, nomBungalow, superficieBungalow, idCamping)(SELECT idBungalow, nomBungalow, superficieBungalow, idCamping FROM Palleja.CAMP_Bungalows);
INSERT INTO Locations (idLocation, idClient, idBungalow, dateDebut, dateFin, montantLocation)(SELECT idLocation, idClient, idBungalow, dateDebut, dateFin, montantLocation FROM Palleja.CAMP_Locations);
INSERT INTO Services (idService, nomService, categorieService)(SELECT idService, nomService, categorieService FROM Palleja.CAMP_Services);
INSERT INTO Proposer (idBungalow, idService)(SELECT idBungalow, idService FROM Palleja.CAMP_Proposer);
INSERT INTO Employes (idEmploye, nomEmploye, prenomEmploye, salaireEmploye, idCamping, idEmployeChef)(SELECT idEmploye, nomEmploye, prenomEmploye, salaireEmploye, idCamping, idEmployeChef FROM Palleja.CAMP_Employes);

COMMIT;
