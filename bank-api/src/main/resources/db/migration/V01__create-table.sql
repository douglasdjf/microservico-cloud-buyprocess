CREATE DATABASE IF NOT EXISTS banco ;

CREATE TABLE IF NOT EXISTS tb_cartao (
  id bigint NOT NULL AUTO_INCREMENT,
  codigo_seguranca int DEFAULT NULL,
  num_cartao int DEFAULT NULL,
  valor_credito decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS tb_pagamento (
  id bigint NOT NULL AUTO_INCREMENT,
  valor_compra decimal(19,2) DEFAULT NULL,
  cartao_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  KEY key_cartao (cartao_id),
  CONSTRAINT fk_cartao FOREIGN KEY (cartao_id) REFERENCES tb_cartao (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into tb_cartao(id, codigo_seguranca, num_cartao, valor_credito) values(1,12,123456,5000.00);