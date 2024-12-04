-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04/12/2024 às 03:28
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
(1, 'Corte', 35, '00:30:00', 'Nada a dizer'),
(2, 'Barba', 20.5, '00:20:00', 'Aparação e hidratação da barba'),
(3, 'Corte e Barba', 50, '01:00:00', 'Pacote completo de cuidados pessoais'),
(4, 'Tintura', 80, '01:30:00', 'Aplicação de tintura profissional'),
(5, 'Relaxamento', 120, '02:00:00', 'Relaxamento químico para cabelo');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tb_servico`
--
ALTER TABLE `tb_servico`
  ADD PRIMARY KEY (`cod_servico`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_servico`
--
ALTER TABLE `tb_servico`
  MODIFY `cod_servico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
