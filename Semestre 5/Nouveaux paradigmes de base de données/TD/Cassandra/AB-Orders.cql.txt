CREATE TABLE commandes_par_id_client (
	id_client varchar,
	nom_client varchar,
	prenom_client varchar,
	categorie_client varchar,
	id_commande varchar,
	date_commande timestamp,
	type_commande varchar,
	PRIMARY KEY (id_client, id_commande)
) WITH CLUSTERING ORDER BY (id_commande DESC);

CREATE TABLE detail_commandes (
	id_commande varchar,
	id_client varchar STATIC,
	nom_client varchar STATIC,
	prenom_client varchar STATIC,
	categorie_client varchar STATIC,
	ville_client varchar STATIC,
	date_commande timestamp STATIC,
	type_commande varchar STATIC,
	id_produit varchar,
	nom_produit varchar,
	montant_produit double,
	PRIMARY KEY (id_commande, id_produit)
);

INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C1','Niscotch','Nicole','Bon client','001', '2015-01-15', 'Magasin');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C2','Diccule','Terry','Bon client','002', '2015-01-17', 'Internet');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C3','Niscotch','Nicole','Client occasionnel','003', '2015-01-31', 'Internet');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C4','Fassolassie','Rémi','Client occasionnel','004', '2015-02-08', 'Magasin');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C5','Afrit','Barack','Bon client','005', '2015-03-11', 'Magasin');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C1','Niscotch','Nicole','Bon client','006', '2015-04-22', 'Magasin');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C6','Delune','Claire','Bon client','007', '2015-04-23', 'Internet');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C1','Niscotch','Nicole','Bon client','008', '2015-05-13', 'Magasin');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C5','Afrit','Barack','Bon client','009', '2015-06-12', 'Magasin');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C6','Delune','Claire','Bon client','010', '2015-07-01', 'Internet');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C1','Niscotch','Nicole','Bon client','011', '2015-08-15', 'Internet');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C6','Delune','Claire','Bon client','012', '2015-08-15', 'Internet');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C7','Tibulaire','Pat','Client patibulaire','013', '2015-10-04', 'Magasin');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C5','Afrit','Barack','Bon client','014', '2015-11-16', 'Magasin');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C2','Diccule','Terry','Bon client','015', '2015-12-31', 'Internet');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C8','Graff','Oto','Client patibulaire','016', '2015-12-31', 'Internet');
INSERT INTO commandes_par_id_client (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande) VALUES ('C9','Menvussa','Gérard','Client occasionnel','017', '2015-12-31', 'Internet');

INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C1','Niscotch','Nicole','Bon client','001', '2015-01-15', 'Magasin', 'Montpellier','P1','Cravate',35);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C1','Niscotch','Nicole','Bon client','001', '2015-01-15', 'Magasin', 'Montpellier','P5','Veston',58);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C1','Niscotch','Nicole','Bon client','001', '2015-01-15', 'Magasin', 'Montpellier','P7','Ceinture',36);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C2','Diccule','Terry','Bon client','002', '2015-01-17', 'Internet', 'Nimes','P2','Costume',135);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C2','Diccule','Terry','Bon client','002', '2015-01-17', 'Internet', 'Nimes','P3','Haut de Forme',65);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C2','Diccule','Terry','Bon client','002', '2015-01-17', 'Internet', 'Nimes','P5','Veston',58);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C2','Diccule','Terry','Bon client','002', '2015-01-17', 'Internet', 'Nimes','P4','Bretelles',28);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C3','Niscotch','Nicole','Client occasionnel','003', '2015-01-31', 'Internet', null,'P2','Costume',135);					  
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C4','Fassolassie','Rémi','Client occasionnel','004', '2015-02-08', 'Magasin', null,'P1','Cravate',35);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C4','Fassolassie','Rémi','Client occasionnel','004', '2015-02-08', 'Magasin', null,'P3','Haut de Forme',65);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C5','Afrit','Barack','Bon client','005', '2015-03-11', 'Magasin', 'Sète','P7','Ceinture',36);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C5','Afrit','Barack','Bon client','005', '2015-03-11', 'Magasin', 'Sète','P5','Veston',58);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C1','Niscotch','Nicole','Bon client','006', '2015-04-22', 'Magasin', 'Montpellier','P4','Bretelles',28);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C6','Delune','Claire','Bon client','007', '2015-04-23', 'Internet', 'Montpellier','P1','Cravate',35);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C6','Delune','Claire','Bon client','007', '2015-04-23', 'Internet', 'Montpellier','P2','Costume',135);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C6','Delune','Claire','Bon client','007', '2015-04-23', 'Internet', 'Montpellier','P6','Noeud Papillon',21);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C1','Niscotch','Nicole','Bon client','008', '2015-05-13', 'Magasin', 'Montpellier','P6','Noeud Papillon',21);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C1','Niscotch','Nicole','Bon client','008', '2015-05-13', 'Magasin', 'Montpellier','P3','Haut de Forme',65);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C5','Afrit','Barack','Bon client','009', '2015-06-12', 'Magasin', 'Sète','P1','Cravate',31);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C5','Afrit','Barack','Bon client','009', '2015-06-12', 'Magasin', 'Sète','P2','Costume',100);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C5','Afrit','Barack','Bon client','009', '2015-06-12', 'Magasin', 'Sète','P3','Haut de Forme',60);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C6','Delune','Claire','Bon client','010', '2015-07-01', 'Internet', 'Montpellier','P5','Veston',50);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C1','Niscotch','Nicole','Bon client','011', '2015-08-15', 'Internet', 'Montpellier','P6','Noeud Papillon',18);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C6','Delune','Claire','Bon client','012', '2015-08-15', 'Internet', 'Montpellier','P1','Cravate',30);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C6','Delune','Claire','Bon client','012', '2015-08-15', 'Internet', 'Montpellier','P3','Haut de Forme',60);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C6','Delune','Claire','Bon client','012', '2015-08-15', 'Internet', 'Montpellier','P4','Bretelles',22);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C6','Delune','Claire','Bon client','012', '2015-08-15', 'Internet', 'Montpellier','P7','Ceinture',30);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C7','Tibulaire','Pat','Client patibulaire','013', '2015-10-04', 'Magasin', null,'P2','Costume',135);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C5','Afrit','Barack','Bon client','014', '2015-11-16', 'Magasin', 'Sète','P4','Bretelles',28);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C2','Diccule','Terry','Bon client','015', '2015-12-31', 'Internet', 'Nimes','P5','Veston',53);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C2','Diccule','Terry','Bon client','015', '2015-12-31', 'Internet', 'Nimes','P6','Noeud Papillon',16);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C2','Diccule','Terry','Bon client','015', '2015-12-31', 'Internet', 'Nimes','P3','Haut de Forme',60);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C8','Graff','Oto','Client patibulaire','016', '2015-12-31', 'Internet', 'Nimes','P7','Ceinture',31);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C8','Graff','Oto','Client patibulaire','016', '2015-12-31', 'Internet', 'Nimes','P1','Cravate',30);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C9','Menvussa','Gérard','Client occasionnel','017', '2015-12-31', 'Internet', 'Montpellier','P1','Cravate',30);
INSERT INTO detail_commandes (id_client, nom_client, prenom_client, categorie_client, id_commande, date_commande, type_commande, ville_client, id_produit, nom_produit, montant_produit) VALUES ('C9','Menvussa','Gérard','Client occasionnel','017', '2015-12-31', 'Internet', 'Montpellier','P6','Noeud Papillon',16);
