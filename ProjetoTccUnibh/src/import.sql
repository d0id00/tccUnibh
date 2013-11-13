INSERT INTO `role`
            (`descricao`,
             `nome`,
             `status`)
VALUES ('Administrador de Sistema', 'Admin', 'ATIVO');
        
INSERT INTO `usuario`
            (`dataReg`,
             `login`,
             `nome`,
             `senha`,
             `idStatus`,
             `idRole`)
VALUES ('2013-01-01 00:00:00', 'admin', 'Administrador', 'admin', 3, 1);     


INSERT INTO STATUS(idStatus, nome, tipo) VALUES(1, "Aberto", "Other");

INSERT INTO STATUS(idStatus, nome, tipo) VALUES(2, "Fechado", "Other");

INSERT INTO STATUS(idStatus, nome, tipo) VALUES(3, "Ativo", "User");

INSERT INTO STATUS(idStatus, nome, tipo) VALUES(4, "Inativo", "User");