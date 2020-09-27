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
INSERT INTO joke (id, content)
VALUES (1, 'Kad umiru šećeraši? Onda kad im je najslađe.'),
       (1, 'Koja je razlika između komarca i punice? Komarac nervira samo preko ljeta.'),
       (1, 'Što je vrhunac muške vjernosti? Ženiš se tri puta, a još uvijek imaš istu ljubavnicu.'),
       (1, 'Majčina komparacija pridjeva: loš, lošiji, najlošiji, isti otac. (P.S. I feel this)');

-- kategorija: Policajci
INSERT INTO joke (id, content)
VALUES (2, 'Kako prometni policajac smanjuje gužvu na kružnom toku? Ode na pauzu.'),
       (2, 'Što se dobije kada policajca pospeš jogurtom? Batine.'),
       (2, 'Koja je razlika između policajca i vlaka? Vlak ima drugi razred.'),
       (2, 'Kad policajac lista časopis, poliže lijevu ruku, a list okrene desnom.');

-- kategorija: Pijanci
INSERT INTO joke (id, content)
VALUES (3, '"Zašto uvijek piješ pivo zatvorenih očiju?" - "Zato što mi je doktor rekao da ne smijem niti pogledati alkohol."'),
       (3, '"Ja ne pijem da te zaboravim, već da te duplo vidim!"'),
       (3, '"Vi ste pijani, oči su vam crvene!" - upozorava policajac vozača. - "Ako ćemo se vrijeđati, vama su klempave uši!" - odgovara ovaj.'),
       (3, 'Piti i voziti je užasno! Uvijek prolijem piće dok mijenjam brzine.');

-- kategorija: Izreke
INSERT INTO joke (id, content)
VALUES (4, 'Žene imaju problem za svako rješenje.'),
       (4, 'Samoubojstvo je najiskreniji oblik samokritike.'),
       (4, 'Algoritam je situacija u kojoj je alga uhvatila ritam.'),
       (4, 'Ljubav je kao šah: uvijek se nađe neki konj koji smeta!');