/*
Creation de la table contenant les prestations
 */

CREATE TABLE User
(
    id                       VARCHAR(100),
    name           VARCHAR(50),
    PRIMARY KEY (id)
);

INSERT INTO User values (1,'bob'),(2,'max'),(3,'quarkus');