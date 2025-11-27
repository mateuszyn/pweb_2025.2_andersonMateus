INSERT INTO cliente (nome, cpf, email, data_nascimento, genero, rua, bairro, numero, cidade, telefone) VALUES ('Maria da Penha', '111.222.333-44', 'maria@email.com', '1950-05-15', 'Feminino', 'Rua das Flores', 'Centro', '123', 'Angicos', '84912345678');

INSERT INTO cliente (nome, cpf, email, data_nascimento, genero, rua, bairro, numero, cidade, telefone) VALUES ('João de Deus', '222.333.444-55', 'joao@email.com', '1980-11-20', 'Masculino', 'Rua Principal', 'Comércio', 'S/N', 'Angicos', '84987654321');


INSERT INTO produto (marca, tipo_de_metal, gemas, peso_em_gramas, quilates, dimensoes, preco_de_compra, preco_de_venda) VALUES ('PurpurinaJoias', 'Ouro', 'Diamante', 5.5, '18k', '1x1x0.5cm', 1200.00, 2500.00);

INSERT INTO produto (marca, tipo_de_metal, gemas, peso_em_gramas, quilates, dimensoes, preco_de_compra, preco_de_venda) VALUES ('Realeza', 'Prata', 'Esmeralda, Rubi', 10.2, 'N/A', '3x2x1cm', 400.00, 850.00);


INSERT INTO dependente (nome, data_nascimento, genero, cliente_id) VALUES ('Zezinho da Silva', '2010-05-10', 'Masculino', 1);

INSERT INTO dependente (nome, data_nascimento, genero, cliente_id) VALUES ('Mariazinha de Deus', '2012-11-30', 'Feminino', 1);


INSERT INTO pedido (cliente_id, forma_pagamento, dados_pagamento) VALUES (1, 'Chave PIX', '44.555.666/0001-99');

INSERT INTO item_pedido (pedido_id, produto_id, quantidade, preco_unitario) VALUES (1, 1, 2, 2500.00); 

INSERT INTO pedido (cliente_id, forma_pagamento, dados_pagamento) VALUES (2, 'Cartão de Crédito', '**** **** **** 1234');

INSERT INTO item_pedido (pedido_id, produto_id, quantidade, preco_unitario) VALUES (2, 2, 1, 850.00);
