DROP TABLE RessourcesOGE CASCADE CONSTRAINT;
DROP TABLE EtudiantsOGE CASCADE CONSTRAINT;
DROP TABLE NotesOGE CASCADE CONSTRAINT;

DROP SEQUENCE ressources_oge_autoincrement;
DROP SEQUENCE etudiants_oge_autoincrement;
DROP SEQUENCE notes_oge_autoincrement;

CREATE TABLE RessourcesOGE
(idRessource INT primary key, nom VARCHAR(100));

CREATE SEQUENCE ressources_oge_autoincrement;

CREATE OR REPLACE TRIGGER trigger_ressources_oge_id_auto
BEFORE INSERT ON RessourcesOGE
FOR EACH ROW
BEGIN
SELECT ressources_oge_autoincrement.nextval INTO :NEW.idRessource
FROM DUAL;
END;
/

CREATE TABLE EtudiantsOGE
(idEtudiant INT primary key, nom VARCHAR(50), prenom VARCHAR(50), idRessourceFavorite INT,
CONSTRAINT fk_Ressource_Favorite_OGE FOREIGN KEY (idRessourceFavorite) REFERENCES RessourcesOGE(idRessource) ON DELETE CASCADE);

CREATE SEQUENCE etudiants_oge_autoincrement;

CREATE OR REPLACE TRIGGER trigger_etudiants_oge_id_auto
BEFORE INSERT ON EtudiantsOGE
FOR EACH ROW
BEGIN
SELECT etudiants_oge_autoincrement.nextval INTO :NEW.idEtudiant
FROM DUAL;
END;
/

CREATE TABLE NotesOGE
(idNote INT primary key, idEtudiant INT, idRessource INT, note INT,
CONSTRAINT fk_Notes_Etudiant_OGE FOREIGN KEY (idEtudiant) REFERENCES EtudiantsOGE(idEtudiant) ON DELETE CASCADE,
CONSTRAINT fk_Notes_Ressource_OGE FOREIGN KEY (idRessource) REFERENCES RessourcesOGE(idRessource) ON DELETE CASCADE);

CREATE SEQUENCE notes_oge_autoincrement;

CREATE OR REPLACE TRIGGER trigger_notes_oge_id_auto
BEFORE INSERT ON NotesOGE
FOR EACH ROW
BEGIN
SELECT notes_oge_autoincrement.nextval INTO :NEW.idNote
FROM DUAL;
END;
/