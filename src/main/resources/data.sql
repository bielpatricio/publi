INSERT INTO USERS(username, email, senha) VALUES('Gabriel Patricio', 'gabriel.teixeira@inatel.br', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO USERS(username, email, senha) VALUES('Robertin', 'robertin.silva@inatel.br', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO USERS(username, email, senha) VALUES('Wilson', 'Wilson@inatel.br', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO USERS(username, email, senha) VALUES('marcao', 'marcao@inatel.br', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO POST(user_id, mensagem, data_pulicacao) VALUES(1, 'Finalizando projeto', '2021-02-13 10:40:12.961');
INSERT INTO POST(user_id, mensagem, data_pulicacao) VALUES(3, 'Sdds ferias', '2021-04-11 10:40:12.961');

INSERT INTO LIKES(user_id, post_id) VALUES(1, 1);
INSERT INTO LIKES(user_id, post_id) VALUES(3, 2);

INSERT INTO COMENTARIO(user_id, post_id, mensagem, data_criacao) VALUES(1, 1, 'Massa', '2021-05-11 10:40:12.961');
INSERT INTO COMENTARIO(user_id, post_id, mensagem, data_criacao) VALUES(1, 1, 'Né!!!!!!!!!', '2021-05-12 10:40:12.961');