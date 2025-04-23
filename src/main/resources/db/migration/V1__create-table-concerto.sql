CREATE TABLE concerto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dt_entrada VARCHAR(50) NOT NULL,
    dt_saida VARCHAR(50) NOT NULL,

    mecanico_nome VARCHAR(100) NOT NULL,
    mecanico_anos_experiencia VARCHAR(100) NOT NULL,

    veiculo_marca VARCHAR(100) NOT NULL,
    veiculo_modelo VARCHAR(100) NOT NULL,
    veiculo_ano VARCHAR(10) NOT NULL
);