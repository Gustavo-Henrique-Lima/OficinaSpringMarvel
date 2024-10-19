INSERT INTO tb_filme (nome, duracao, ano, avaliacao) VALUES ('Vingadores: Guerra Infinita', 149, 2018, 8.5);

INSERT INTO tb_filme (nome, duracao, ano, avaliacao) VALUES ('Homem-Aranha: De Volta ao Lar', 133, 2017, 7.5);

INSERT INTO tb_filme (nome, duracao, ano, avaliacao) VALUES ('Homem de Ferro', 126, 2008, 8.0);

INSERT INTO tb_personagem (nome, url_foto, tipo, aparicoes, popularidade) VALUES ('Homem Aranha', 'https://example.com/spider-man.jpg', 0, 3, 9.5);

INSERT INTO tb_personagem (nome, url_foto, tipo, aparicoes, popularidade) VALUES ('Homem de ferro', 'https://example.com/homem-ferro.jpg', 0, 5, 1);

INSERT INTO tb_personagem (nome, url_foto, tipo, aparicoes, popularidade) VALUES ('Thanos', 'https://example.com/thanos.jpg', 1, 3, 7.0);

INSERT INTO tb_personagens_filme (id_filme, id_personagem) VALUES (1,3);

INSERT INTO tb_personagens_filme (id_filme, id_personagem) VALUES (2,1);
INSERT INTO tb_personagens_filme (id_filme, id_personagem) VALUES (2,2);

INSERT INTO tb_personagens_filme (id_filme, id_personagem) VALUES (3,2);