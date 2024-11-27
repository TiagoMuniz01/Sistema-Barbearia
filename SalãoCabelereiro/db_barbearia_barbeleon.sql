-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 27/11/2024 às 03:00
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_barbearia_barbeleon`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_agendamento`
--

CREATE TABLE `tb_agendamento` (
  `cod_agendamento` int(11) NOT NULL,
  `horario_agendamento` time NOT NULL,
  `data_agendamento` date NOT NULL,
  `cod_cliente` int(11) DEFAULT NULL,
  `cod_profissional` int(11) DEFAULT NULL,
  `cod_servico` int(11) DEFAULT NULL,
  `cod_pagamento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_agendamento`
--

INSERT INTO `tb_agendamento` (`cod_agendamento`, `horario_agendamento`, `data_agendamento`, `cod_cliente`, `cod_profissional`, `cod_servico`, `cod_pagamento`) VALUES
(1, '12:30:41', '2024-11-06', 1, 1, 1, 1),
(2, '17:30:41', '2024-11-01', 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_cliente`
--

CREATE TABLE `tb_cliente` (
  `cod_cliente` int(11) NOT NULL,
  `nome_cliente` varchar(100) NOT NULL,
  `cpf_cliente` varchar(11) NOT NULL,
  `email_cliente` varchar(100) NOT NULL,
  `data_nasc` date NOT NULL,
  `senha_cliente` varchar(100) NOT NULL,
  `telefone_cliente` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_cliente`
--

INSERT INTO `tb_cliente` (`cod_cliente`, `nome_cliente`, `cpf_cliente`, `email_cliente`, `data_nasc`, `senha_cliente`, `telefone_cliente`) VALUES
(1, 'Diogo', '123456789', 'teste@gmail.com', '2014-11-04', '1234', '119865425');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_pagamento`
--

CREATE TABLE `tb_pagamento` (
  `cod_pagamento` int(11) NOT NULL,
  `forma_pagamento` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_pagamento`
--

INSERT INTO `tb_pagamento` (`cod_pagamento`, `forma_pagamento`) VALUES
(1, 'Crédito');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_profissional`
--

CREATE TABLE `tb_profissional` (
  `cod_profissional` int(11) NOT NULL,
  `nome_profissional` varchar(100) NOT NULL,
  `cpf_profissional` varchar(11) NOT NULL,
  `rg_profissional` varchar(15) NOT NULL,
  `telefone_profissional` varchar(15) NOT NULL,
  `email_profissional` varchar(100) NOT NULL,
  `desc_profissional` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_profissional`
--

INSERT INTO `tb_profissional` (`cod_profissional`, `nome_profissional`, `cpf_profissional`, `rg_profissional`, `telefone_profissional`, `email_profissional`, `desc_profissional`) VALUES
(1, 'Tiago Pimentel Muniz', '43983050840', '553531141', '11911429039', 'tiagopimentel.tp@gmail.com', 'Teste');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_profissionalservico`
--

CREATE TABLE `tb_profissionalservico` (
  `cod_profissional` int(11) DEFAULT NULL,
  `cod_servico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_servico`
--

CREATE TABLE `tb_servico` (
  `cod_servico` int(11) NOT NULL,
  `nome_servico` varchar(100) NOT NULL,
  `preco_servico` float NOT NULL,
  `tempo_servico` time NOT NULL,
  `desc_servico` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_servico`
--

INSERT INTO `tb_servico` (`cod_servico`, `nome_servico`, `preco_servico`, `tempo_servico`, `desc_servico`) VALUES
(1, 'Corte', 35, '00:30:00', 'Nada a dizer');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tb_agendamento`
--
ALTER TABLE `tb_agendamento`
  ADD PRIMARY KEY (`cod_agendamento`),
  ADD KEY `cod_cliente` (`cod_cliente`),
  ADD KEY `cod_profissional` (`cod_profissional`),
  ADD KEY `cod_servico` (`cod_servico`),
  ADD KEY `cod_pagamento` (`cod_pagamento`);

--
-- Índices de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`cod_cliente`),
  ADD UNIQUE KEY `cpf_cliente` (`cpf_cliente`),
  ADD UNIQUE KEY `email_cliente` (`email_cliente`);

--
-- Índices de tabela `tb_pagamento`
--
ALTER TABLE `tb_pagamento`
  ADD PRIMARY KEY (`cod_pagamento`);

--
-- Índices de tabela `tb_profissional`
--
ALTER TABLE `tb_profissional`
  ADD PRIMARY KEY (`cod_profissional`),
  ADD UNIQUE KEY `cpf_profissional` (`cpf_profissional`),
  ADD UNIQUE KEY `rg_profissional` (`rg_profissional`),
  ADD UNIQUE KEY `telefone_profissional` (`telefone_profissional`),
  ADD UNIQUE KEY `email_profissional` (`email_profissional`);

--
-- Índices de tabela `tb_profissionalservico`
--
ALTER TABLE `tb_profissionalservico`
  ADD KEY `cod_profissional` (`cod_profissional`),
  ADD KEY `cod_servico` (`cod_servico`);

--
-- Índices de tabela `tb_servico`
--
ALTER TABLE `tb_servico`
  ADD PRIMARY KEY (`cod_servico`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_agendamento`
--
ALTER TABLE `tb_agendamento`
  MODIFY `cod_agendamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `cod_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tb_pagamento`
--
ALTER TABLE `tb_pagamento`
  MODIFY `cod_pagamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tb_profissional`
--
ALTER TABLE `tb_profissional`
  MODIFY `cod_profissional` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tb_servico`
--
ALTER TABLE `tb_servico`
  MODIFY `cod_servico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `tb_agendamento`
--
ALTER TABLE `tb_agendamento`
  ADD CONSTRAINT `tb_agendamento_ibfk_1` FOREIGN KEY (`cod_cliente`) REFERENCES `tb_cliente` (`cod_cliente`),
  ADD CONSTRAINT `tb_agendamento_ibfk_2` FOREIGN KEY (`cod_profissional`) REFERENCES `tb_profissional` (`cod_profissional`),
  ADD CONSTRAINT `tb_agendamento_ibfk_3` FOREIGN KEY (`cod_servico`) REFERENCES `tb_servico` (`cod_servico`),
  ADD CONSTRAINT `tb_agendamento_ibfk_4` FOREIGN KEY (`cod_pagamento`) REFERENCES `tb_pagamento` (`cod_pagamento`);

--
-- Restrições para tabelas `tb_profissionalservico`
--
ALTER TABLE `tb_profissionalservico`
  ADD CONSTRAINT `tb_profissionalservico_ibfk_1` FOREIGN KEY (`cod_profissional`) REFERENCES `tb_profissional` (`cod_profissional`),
  ADD CONSTRAINT `tb_profissionalservico_ibfk_2` FOREIGN KEY (`cod_servico`) REFERENCES `tb_servico` (`cod_servico`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
