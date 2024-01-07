DROP TABLE IF EXISTS restaurants;

CREATE TABLE restaurants (
  id VARCHAR(250) PRIMARY KEY,
  nom VARCHAR(250) NOT NULL,
  adresse VARCHAR(250) NOT NULL
);

INSERT INTO RESTAURANTS (ID,NOM,ADRESSE) VALUES ('resto1', 'Le Restaurant', '6 Rue Paul Bellamy 44000 Nantes');

