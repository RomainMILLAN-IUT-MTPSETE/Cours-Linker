DROP TYPE employe_type FORCE;
DROP TYPE voiture_type FORCE;
DROP TYPE ville_type FORCE;
DROP TYPE projet_type FORCE;
DROP TYPE nt_projet_type FORCE;
DROP TYPE client_type FORCE;

--CREATION DES TYPES

CREATE OR REPLACE TYPE ville_type AS OBJECT
(idVille VARCHAR(5), nom VARCHAR(20), nbHabitants NUMBER, departement VARCHAR2(20),
 MEMBER FUNCTION nbClients RETURN NUMBER,
 MEMBER FUNCTION nbEmployes RETURN NUMBER) ;
/
CREATE OR REPLACE TYPE voiture_type AS OBJECT
(immatriculation VARCHAR(20), marque VARCHAR(20));
/
CREATE OR REPLACE TYPE employe_type AS OBJECT
(idEmploye VARCHAR(5), nom VARCHAR(20), prenom VARCHAR(20), salaireFixe NUMBER, ref_ville REF ville_type, voiture voiture_type,
 MEMBER FUNCTION nbProjets RETURN NUMBER,
 MEMBER FUNCTION nbChef RETURN NUMBER,
 MEMBER FUNCTION salaireMensuel RETURN NUMBER,
 MEMBER FUNCTION estRiche RETURN NUMBER,
 STATIC FUNCTION salaireMoyenMensuel RETURN NUMBER) NOT FINAL ;
/
CREATE OR REPLACE TYPE projet_type AS OBJECT
(idProjet VARCHAR(5), nom VARCHAR(20), budget NUMBER, ref_chef REF employe_type,
MEMBER FUNCTION salaireMensuelMoyen RETURN NUMBER,
MEMBER PROCEDURE affecterEmploye(p_idEmploye IN VARCHAR, p_poste IN VARCHAR),
MEMBER FUNCTION nbProjets RETURN NUMBER);
/
CREATE TYPE nt_projet_type AS TABLE OF projet_type;
/
CREATE OR REPLACE TYPE client_type AS OBJECT
(idClient VARCHAR(5), nom VARCHAR(20), ref_ville REF ville_type, projets nt_projet_type,
MEMBER FUNCTION chiffreAffaires RETURN NUMBER,
MEMBER FUNCTION nbProjets RETURN NUMBER);
/
CREATE TABLE 