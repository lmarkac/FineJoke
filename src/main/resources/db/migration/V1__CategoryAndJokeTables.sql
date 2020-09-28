CREATE TABLE category (

	id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL

);

CREATE TABLE joke (

	id int NOT NULL,
	content VARCHAR(400) NOT NULL,
	likes int DEFAULT 0,
	dislikes int DEFAULT 0
);

INSERT INTO category (name)
VALUES ('Crni humor'),
       ('Policajci'),
       ('Pijanci'),
       ('Izreke');

-- kategorija: Crni humor
INSERT INTO joke (id, content, likes, dislikes)
VALUES (1, 'Kad umiru šećeraši? Onda kad im je najslađe.', 14, 3),
       (1, 'Koja je razlika između komarca i punice? Komarac nervira samo preko ljeta.', 3, 10),
       (1, 'Što je vrhunac muške vjernosti? Ženiš se tri puta, a još uvijek imaš istu ljubavnicu.', 2, 6),
       (1, 'Majčina komparacija pridjeva: loš, lošiji, najlošiji, isti otac. (P.S. I feel this)', 390, 14);

-- kategorija: Policajci
INSERT INTO joke (id, content, likes, dislikes)
VALUES (2, 'Kako prometni policajac smanjuje gužvu na kružnom toku? Ode na pauzu.', 0, 13),
       (2, 'Što se dobije kada policajca pospeš jogurtom? Batine.', 9, 14),
       (2, 'Koja je razlika između policajca i vlaka? Vlak ima drugi razred.', 3, 7),
       (2, 'Kad policajac lista časopis, poliže lijevu ruku, a list okrene desnom.', 46, 13);

-- kategorija: Pijanci
INSERT INTO joke (id, content, likes, dislikes)
VALUES (3, '"Zašto uvijek piješ pivo zatvorenih očiju?" - "Zato što mi je doktor rekao da ne smijem niti pogledati alkohol."', 13, 37),
       (3, '"Ja ne pijem da te zaboravim, već da te duplo vidim!"', 64, 420),
       (3, '"Vi ste pijani, oči su vam crvene!" - upozorava policajac vozača. - "Ako ćemo se vrijeđati, vama su klempave uši!" - odgovara ovaj.', 34, 12),
       (3, 'Piti i voziti je užasno! Uvijek prolijem piće dok mijenjam brzine.', 14, 19);

-- kategorija: Izreke
INSERT INTO joke (id, content, likes, dislikes)
VALUES (4, 'Žene imaju problem za svako rješenje.', 49, 60),
       (4, 'Samoubojstvo je najiskreniji oblik samokritike.', 60, 39),
       (4, 'Algoritam je situacija u kojoj je alga uhvatila ritam.', 13, 16),
       (4, 'Ljubav je kao šah: uvijek se nađe neki konj koji smeta!', 19, 60);