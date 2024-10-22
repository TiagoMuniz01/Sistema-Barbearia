-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22/10/2024 às 04:30
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

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_pagamento`
--

CREATE TABLE `tb_pagamento` (
  `cod_pagamento` int(11) NOT NULL,
  `forma_pagamento` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  MODIFY `cod_agendamento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `cod_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tb_pagamento`
--
ALTER TABLE `tb_pagamento`
  MODIFY `cod_pagamento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tb_profissional`
--
ALTER TABLE `tb_profissional`
  MODIFY `cod_profissional` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tb_servico`
--
ALTER TABLE `tb_servico`
  MODIFY `cod_servico` int(11) NOT NULL AUTO_INCREMENT;

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
