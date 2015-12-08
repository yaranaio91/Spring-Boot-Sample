CREATE DATABASE spring;
use spring;
CREATE TABLE users
(
    id                          INT UNSIGNED NOT NULL,
    name                        VARCHAR(255) NOT NULL,
    email                       VARCHAR(255) NOT NULL,
    password                    VARCHAR(60) NOT NULL,
    remember_token              VARCHAR(100),
    created_at                  TIMESTAMP(0) NOT NULL,
    updated_at                  TIMESTAMP(0) NOT NULL,
    CONSTRAINT PRIMARY KEY (id)
);

INSERT INTO users ( id, name, email, password, remember_token, created_at, updated_at ) VALUES (1,'user1','user1@spring.spring','password',null,'2015-12-04 18:23:48','2015-12-04 18:23:48');
INSERT INTO users ( id, name, email, password, remember_token, created_at, updated_at ) VALUES (2,'user2','user2@spring.spring','password',null,'2015-12-04 18:23:48','2015-12-04 18:23:48');
