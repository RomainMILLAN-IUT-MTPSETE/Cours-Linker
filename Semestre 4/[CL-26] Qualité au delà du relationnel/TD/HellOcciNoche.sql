-- Sur DBeaver copier le script suivant dans la fenêtre SQL
-- puis appuyer sur le bouton "Exécuter le script SQL (Alt+X)" - et non pas sur "Exécuter l'instruction SQL (Ctrl+Entrée)" 

DROP TABLE IF EXISTS Jouer;
DROP TABLE IF EXISTS Films;
DROP TABLE IF EXISTS Acteurs;

CREATE TABLE Films (
	idFilm VARCHAR(3),
	titreFilm VARCHAR(50),
	paysFilm VARCHAR(30),
	categoriesFilm VARCHAR(20) ARRAY,
	entreesFilm jsonb,
	critiquesFilm xml,
	CONSTRAINT pk_Films PRIMARY KEY (idFilm));

CREATE TABLE Acteurs (
	idActeur VARCHAR(3),
	nomActeur VARCHAR(30),
	prenomActeur VARCHAR(30),
	infosActeur HSTORE,
	CONSTRAINT pk_Acteurs PRIMARY KEY (idActeur));
	
CREATE TABLE Jouer (
    idFilm VARCHAR(3),
    idActeur VARCHAR(3),
	CONSTRAINT fk_Jouer_idFilm FOREIGN KEY (idFilm) REFERENCES Films(idFilm),
	CONSTRAINT fk_Jouer_idActeur FOREIGN KEY (idActeur) REFERENCES Acteurs(idActeur),
	CONSTRAINT pk_Jouer PRIMARY KEY (idFilm, idActeur));
	
INSERT INTO Films (SELECT * FROM pallejax.CINEMA_2A_films);
INSERT INTO Acteurs (SELECT * FROM pallejax.CINEMA_2A_acteurs);
INSERT INTO jouer (SELECT * FROM pallejax.CINEMA_2A_jouer);
