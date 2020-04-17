-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: sql10.freemysqlhosting.net
-- Tempo de geração: 20/07/2017 às 02:46
-- Versão do servidor: 5.5.53-0ubuntu0.14.04.1
-- Versão do PHP: 7.0.18-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sql10185589`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `carrier`
--

CREATE TABLE `carrier` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `cnpj` char(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `carrier`
--

INSERT INTO `carrier` (`id`, `name`, `cnpj`) VALUES
(1, 'E-Sedex', '61.837.381/0001-52'),
(2, 'Fedex', '28.680.977/0001-16'),
(4, 'SeDoze', '12.121.212/1212-12');

-- --------------------------------------------------------

--
-- Estrutura para tabela `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `ref_person` char(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `client`
--

INSERT INTO `client` (`id`, `ref_person`) VALUES
(1, '771.091.350-47');

-- --------------------------------------------------------

--
-- Estrutura para tabela `delivery`
--

CREATE TABLE `delivery` (
  `id` int(11) NOT NULL,
  `ref_sale` int(11) NOT NULL,
  `ref_carrier` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `note` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `delivery`
--

INSERT INTO `delivery` (`id`, `ref_sale`, `ref_carrier`, `status`, `note`) VALUES
(1, 1, 1, 1, '');

-- --------------------------------------------------------

--
-- Estrutura para tabela `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `ref_sale` int(11) NOT NULL,
  `ref_product` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `item`
--

INSERT INTO `item` (`id`, `ref_sale`, `ref_product`, `amount`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 1),
(3, 4, 1, 1),
(4, 5, 1, 1),
(5, 6, 2, 1),
(6, 7, 1, 1),
(7, 7, 2, 1),
(8, 8, 3, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `logcommands`
--

CREATE TABLE `logcommands` (
  `id` int(11) NOT NULL,
  `description_command` varchar(500) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `logcommands`
--

INSERT INTO `logcommands` (`id`, `description_command`, `date`) VALUES
(1, 'Usuário lucas efetuou login.', '2017-07-19 05:42:47'),
(2, 'Usuário lucas efetuou login.', '2017-07-19 06:04:55'),
(3, 'Usuário lucas efetuou login.', '2017-07-19 06:10:29'),
(4, 'Usuário lucas efetuou login.', '2017-07-19 06:11:40'),
(5, 'Usuário lucas efetuou login.', '2017-07-19 06:22:43'),
(6, 'Usuário lucas efetuou login.', '2017-07-19 06:26:44'),
(7, 'Usuário lucas efetuou login.', '2017-07-19 06:35:43'),
(8, 'Usuário lucas efetuou login.', '2017-07-19 06:37:50'),
(9, 'Usuário lucas efetuou login.', '2017-07-19 06:38:59'),
(10, 'Usuário lucas efetuou login.', '2017-07-19 06:39:29'),
(11, 'Usuário lucas efetuou login.', '2017-07-19 06:41:45'),
(12, 'Usuário lucas efetuou login.', '2017-07-19 16:13:35'),
(13, 'Usuário lucas efetuou login.', '2017-07-19 16:27:18'),
(14, 'Usuário lucas efetuou login.', '2017-07-19 16:29:08'),
(15, 'Usuário lucas efetuou login.', '2017-07-19 16:33:33'),
(16, 'Usuário lucas efetuou login.', '2017-07-19 16:41:25'),
(17, 'Usuário lucas efetuou login.', '2017-07-19 16:42:56'),
(18, 'Usuário lucas efetuou login.', '2017-07-19 16:44:46'),
(19, 'Usuário lucas efetuou login.', '2017-07-19 16:49:17'),
(20, 'Usuário lucas efetuou login.', '2017-07-19 18:06:52'),
(21, 'Usuário lucas efetuou login.', '2017-07-19 18:08:21'),
(22, 'Falha ao realizar login com nome de usuário lucas.', '2017-07-19 18:09:09'),
(23, 'Falha ao realizar login com nome de usuário lucas1.', '2017-07-19 18:09:17'),
(24, 'Usuário lucas efetuou login.', '2017-07-19 18:09:24'),
(25, 'Falha ao realizar login com nome de usuário dasda.', '2017-07-19 18:11:06'),
(26, 'Falha ao realizar login com nome de usuário dasda.', '2017-07-19 18:11:17'),
(27, 'Falha ao realizar login com nome de usuário dasda.', '2017-07-19 18:11:46'),
(28, 'Usuário lucas efetuou login.', '2017-07-19 18:11:55'),
(29, 'Usuário lucas efetuou login.', '2017-07-19 18:21:43'),
(30, 'Usuário lucas efetuou login.', '2017-07-19 18:23:09'),
(31, 'Usuário lucas efetuou login.', '2017-07-19 18:24:40'),
(32, 'Usuário lucas efetuou login.', '2017-07-19 18:25:19'),
(33, 'Usuário lucas efetuou login.', '2017-07-19 18:30:33'),
(34, 'Usuário lucas efetuou login.', '2017-07-19 18:32:42'),
(35, 'Usuário lucas efetuou login.', '2017-07-19 18:54:47'),
(36, 'Usuário lucas efetuou login.', '2017-07-19 19:22:35'),
(37, 'Usuário lucas efetuou login.', '2017-07-19 19:23:11'),
(38, 'Usuário lucas efetuou login.', '2017-07-19 19:24:31'),
(39, 'Usuário lucas efetuou login.', '2017-07-19 19:27:01'),
(40, 'Usuário lucas efetuou login.', '2017-07-19 19:29:17'),
(41, 'Usuário lucas efetuou login.', '2017-07-19 19:36:42'),
(42, 'Usuário lucas efetuou login.', '2017-07-19 20:02:59'),
(43, 'Usuário lucas efetuou login.', '2017-07-19 20:05:59'),
(44, 'Usuário lucas efetuou login.', '2017-07-19 20:08:04'),
(45, 'Usuário lucas efetuou login.', '2017-07-19 20:09:44'),
(46, 'Usuário lucas efetuou login.', '2017-07-19 20:13:35'),
(47, 'Usuário lucas efetuou login.', '2017-07-19 20:16:56'),
(48, 'Usuário lucas efetuou login.', '2017-07-19 20:18:23'),
(49, 'Usuário lucas efetuou login.', '2017-07-19 20:19:49'),
(50, 'Usuário lucas efetuou login.', '2017-07-19 20:22:06'),
(51, 'Usuário lucas efetuou login.', '2017-07-19 20:24:06'),
(52, 'Usuário lucas efetuou login.', '2017-07-19 20:25:33'),
(53, 'Usuário lucas efetuou login.', '2017-07-19 20:27:05'),
(54, 'Usuário lucas efetuou login.', '2017-07-19 20:30:43'),
(55, 'Usuário lucas efetuou login.', '2017-07-19 20:33:22'),
(56, 'Usuário lucas efetuou login.', '2017-07-19 20:34:50'),
(57, 'Usuário lucas efetuou login.', '2017-07-19 20:35:37'),
(58, 'Usuário lucas efetuou login.', '2017-07-19 20:37:28'),
(59, 'Usuário lucas efetuou login.', '2017-07-19 20:39:38'),
(60, 'Usuário lucas efetuou login.', '2017-07-19 20:40:06'),
(61, 'Usuário lucas efetuou login.', '2017-07-19 21:44:31'),
(62, 'Pesquisa de usuário com cpf 066.700.663-09 efetuada.', '2017-07-19 21:44:43'),
(63, 'Pesquisa de usuário com cpf    .   .   -   efetuada.', '2017-07-19 21:44:51'),
(64, 'Usuário lucas efetuou login.', '2017-07-19 23:19:19'),
(65, 'Usuário lucas efetuou login.', '2017-07-19 23:26:27'),
(66, 'Usuário lucas efetuou login.', '2017-07-19 23:28:36'),
(67, 'Usuário lucas efetuou login.', '2017-07-19 23:35:02'),
(68, 'Usuário lucas efetuou login.', '2017-07-19 23:40:45'),
(69, 'Usuário lucas efetuou login.', '2017-07-19 23:46:45'),
(70, 'Usuário lucas efetuou login.', '2017-07-19 23:48:14'),
(71, 'Usuário lucas efetuou login.', '2017-07-19 23:55:47'),
(72, 'Usuário lucas efetuou login.', '2017-07-20 00:17:39'),
(73, 'Usuário lucas efetuou login.', '2017-07-20 00:19:44'),
(74, 'Usuário lucas efetuou login.', '2017-07-20 00:21:17'),
(75, 'Usuário lucas efetuou login.', '2017-07-20 00:23:11'),
(76, 'Usuário lucas efetuou login.', '2017-07-20 00:24:44'),
(77, 'Usuário lucas efetuou login.', '2017-07-20 00:27:09'),
(78, 'Usuário lucas efetuou login.', '2017-07-20 00:29:17'),
(79, 'Usuário lucas efetuou login.', '2017-07-20 00:47:46'),
(80, 'Usuário lucas efetuou login.', '2017-07-20 00:51:47'),
(81, 'Usuário lucas efetuou login.', '2017-07-20 00:53:14'),
(82, 'Usuário lucas efetuou login.', '2017-07-20 00:59:35'),
(83, 'Usuário lucas efetuou login.', '2017-07-20 01:04:26'),
(84, 'Pesquisa de usuário com cpf 066.700.663-09 efetuada.', '2017-07-20 01:05:03'),
(85, 'Tentativa de cadastro de usuário: Lucas Barros, 065.427.623-45, (08)59964-2618, , 16/01/1998, , barros.', '2017-07-20 01:05:26'),
(86, 'Tentativa de cadastro de usuário: Lucas Barros, 065.427.623-45, (08)59964-2618, , 16/01/1998, , barros.', '2017-07-20 01:05:47'),
(87, 'Erro de cadastro: o CPF ou nome de usuário já está cadastrado no sistema.', '2017-07-20 01:05:48'),
(88, 'Usuário lucas efetuou login.', '2017-07-20 01:16:45'),
(89, 'Pesquisa de usuário com cpf 065.427.623-45 efetuada.', '2017-07-20 01:17:00'),
(90, 'Tentativa de cadastro de usuário: Lucas, 065.427.623-41, (08)59964-2618, 16/01/1998, admin.', '2017-07-20 01:17:16'),
(91, 'Usuário lucas efetuou login.', '2017-07-20 01:18:09'),
(92, 'Pesquisa de usuário com cpf 065.427.623-41 efetuada.', '2017-07-20 01:18:20'),
(93, 'Pesquisa de usuário com cpf 065.427.623-45 efetuada.', '2017-07-20 01:18:25'),
(94, 'Usuário barros deletado.', '2017-07-20 01:18:31'),
(95, 'Tentativa de cadastro de usuário: Lucas Barros, 065.427.623-45, (08)59964-2618, 16/01/1998, barros.', '2017-07-20 01:19:00'),
(96, 'Usuário lucas efetuou login.', '2017-07-20 01:20:39'),
(97, 'Tentativa de cadastro de usuário: Lucas, 065.427.623-45, (86)12345-4634, 12/12/2000, barros.', '2017-07-20 01:21:14'),
(98, 'Pesquisa de usuário com cpf 065.427.623-45 efetuada.', '2017-07-20 01:21:54'),
(99, 'Tentativa de cadastro de usuário: Lucas, 065.427.623-45, (86)12345-4634, 12/12/2000, barros.', '2017-07-20 01:22:24'),
(100, 'Tentativa de cadastro de usuário: Lucas, 065.427.623-45, (86)12345-4634, 12/12/2000, barros.', '2017-07-20 01:22:57'),
(101, 'Erro de cadastro: o CPF ou nome de usuário já está cadastrado no sistema.', '2017-07-20 01:22:58'),
(102, 'Pesquisa de usuário com cpf 065.427.623-45 efetuada.', '2017-07-20 01:23:37'),
(103, 'Usuário barros deletado.', '2017-07-20 01:23:48'),
(104, 'Tentativa de cadastro de usuário: Lucas, 065.427.623-45, (86)12345-4634, 12/12/2000, barros.', '2017-07-20 01:24:00'),
(105, 'Usuário lucas efetuou login.', '2017-07-20 01:25:15'),
(106, 'Tentativa de cadastro de usuário: Lucas, 123.456.789-00, (11)11111-1111, 11/11/2222, barros.', '2017-07-20 01:25:35'),
(107, 'Novo usuário com nome de usuário barros cadastrado com sucesso.', '2017-07-20 01:25:38'),
(108, 'Usuário lucas efetuou login.', '2017-07-20 01:27:08'),
(109, 'Pesquisa de usuário com cpf 123.456.789-00 efetuada.', '2017-07-20 01:27:18'),
(110, 'Tentativa de cadastro de usuário: Lucas, 123.456.789-00, (11)11111-1111, 11/11/2222, barros.', '2017-07-20 01:27:23'),
(111, 'Erro de cadastro: o CPF ou nome de usuário já está cadastrado no sistema.', '2017-07-20 01:27:24'),
(112, 'Usuário barros deletado.', '2017-07-20 01:28:16'),
(113, 'Tentativa de cadastro de usuário: Lucas, 123.456.789-00, (11)11111-1111, 11/11/2222, barros.', '2017-07-20 01:28:19'),
(114, 'Novo usuário com nome de usuário barros cadastrado com sucesso.', '2017-07-20 01:28:21'),
(115, 'Usuário lucas efetuou login.', '2017-07-20 01:31:27'),
(116, 'Pesquisa de usuário com cpf 065.427.623-45 efetuada.', '2017-07-20 01:31:37'),
(117, 'Pesquisa de usuário com cpf 123.456.789-00 efetuada.', '2017-07-20 01:32:02'),
(118, 'Usuário lucas efetuou login.', '2017-07-20 01:34:29'),
(119, 'Pesquisa de usuário com cpf 123.456.789-00 efetuada.', '2017-07-20 01:34:44'),
(120, 'Dados do usuário com cpf 123.456.789-00 atualizados para:nome: Lucas, phone: (11)11111-2222, birthday: 11/11/2222nome de usuário: barrossenha: 12345.', '2017-07-20 01:34:50'),
(121, 'Tentativa de cadastro de usuário: Lucas, 123.456.789-01, (11)11111-2222, 11/11/2222, barross.', '2017-07-20 01:35:05'),
(122, 'Novo usuário com nome de usuário barross cadastrado com sucesso.', '2017-07-20 01:35:07'),
(123, 'Usuário barross deletado.', '2017-07-20 01:35:32'),
(124, 'Usuário lucas efetuou login.', '2017-07-20 01:37:46'),
(125, 'Usuário lucas efetuou login.', '2017-07-20 01:39:10'),
(126, 'Pesquisa de cliente com cpf 771.091.350-47 efetuada.', '2017-07-20 01:39:31'),
(127, 'Pesquisa de cliente com cpf 771.091.350-47 efetuada.', '2017-07-20 01:39:39'),
(128, 'Tentativa de cadastro de cliente: Kalebe Pereira Torres de Araújo, 771.091.350-48, (85)99000-0000, 04/05/2004.', '2017-07-20 01:39:49'),
(129, 'Novo cliente com CPF 771.091.350-48 cadastrado com sucesso.', '2017-07-20 01:39:52'),
(130, 'Usuário lucas efetuou login.', '2017-07-20 01:47:17'),
(131, 'Pesquisa de cliente com cpf 771.091.350-48 efetuada.', '2017-07-20 01:47:37'),
(132, 'Tentativa de cadastro de cliente: Kalebe Pereira Torres de Araújo, 771.091.350-49, (85)99000-0000, 04/05/2004.', '2017-07-20 01:47:40'),
(133, 'Novo cliente com CPF 771.091.350-49 cadastrado com sucesso.', '2017-07-20 01:47:43'),
(134, 'Dados do cliente com cpf 771.091.350-49 atualizados para:nome: Kalebe Pereira Torres de Araújo, phone: (85)99000-2222, birthday: 04/05/2004.', '2017-07-20 01:47:54'),
(135, 'Cliente com cpf 771.091.350-49 deletado.', '2017-07-20 01:48:13'),
(136, 'Pesquisa de usuário com cpf 123.456.789-00 efetuada.', '2017-07-20 01:50:35'),
(137, 'Usuário barros deletado.', '2017-07-20 01:50:40'),
(138, 'Usuário lucas efetuou login.', '2017-07-20 01:52:39'),
(139, 'Pesquisa de cliente com cpf 771.091.350-48 efetuada.', '2017-07-20 01:52:55'),
(140, 'Tentativa de cadastro de cliente: Kalebe Pereira Torres de Araújo, 771.091.350-49, (85)99000-0000, 04/05/2004.', '2017-07-20 01:53:00'),
(141, 'Novo cliente com CPF 771.091.350-49 cadastrado com sucesso.', '2017-07-20 01:53:03'),
(142, 'Usuário lucas efetuou login.', '2017-07-20 01:54:02'),
(143, 'Pesquisa de cliente com cpf 771.091.350-49 efetuada.', '2017-07-20 01:54:12'),
(144, 'Usuário lucas efetuou login.', '2017-07-20 01:54:35'),
(145, 'Pesquisa de cliente com cpf 771.091.350-49 efetuada.', '2017-07-20 01:54:41'),
(146, 'Cliente com cpf 771.091.350-49 deletado.', '2017-07-20 01:54:44'),
(147, 'Usuário lucas efetuou login.', '2017-07-20 01:56:44'),
(148, 'Pesquisa de cliente com cpf 771.091.350-47 efetuada.', '2017-07-20 01:57:02'),
(149, 'Tentativa de cadastro de cliente: Kalebe Pereira Torres de Araújo, 771.091.350-48, (85)99000-0000, 04/05/2004.', '2017-07-20 01:57:08'),
(150, 'Novo cliente com CPF 771.091.350-48 cadastrado com sucesso.', '2017-07-20 01:57:10'),
(151, 'Dados do cliente com cpf 771.091.350-48 atualizados para:nome: Kalebe Pereira Torres de Araújo, phone: (85)99000-1111, birthday: 04/05/2004.', '2017-07-20 01:57:31'),
(152, 'Cliente com cpf 771.091.350-48 deletado.', '2017-07-20 01:57:47'),
(153, 'Usuário lucas efetuou login.', '2017-07-20 01:58:37'),
(154, 'Usuário lucas efetuou login.', '2017-07-20 01:59:41'),
(155, 'Pesquisa de cliente com cpf 771.091.350-48 efetuada.', '2017-07-20 01:59:50'),
(156, 'Pesquisa de cliente com cpf 771.091.350-47 efetuada.', '2017-07-20 02:00:10'),
(157, 'Tentativa de cadastro de cliente: Kalebe Pereira Torres de Araújo, 771.091.350-48, (85)99000-0000, 04/05/2004.', '2017-07-20 02:00:14'),
(158, 'Novo cliente com CPF 771.091.350-48 cadastrado com sucesso.', '2017-07-20 02:00:17'),
(159, 'Dados do cliente com cpf 771.091.350-48 atualizados para:nome: Kalebe Pereira Torres de Araújo, phone: (85)99000-1111, birthday: 04/05/2004.', '2017-07-20 02:00:23'),
(160, 'Cliente com cpf 771.091.350-48 deletado.', '2017-07-20 02:00:27'),
(161, 'Usuário lucas efetuou login.', '2017-07-20 02:12:20'),
(162, 'Usuário lucas efetuou login.', '2017-07-20 02:17:45'),
(163, 'Pesquisa de usuário com cpf 066.700.663-09 efetuada.', '2017-07-20 02:17:58'),
(164, 'Usuário lucas efetuou login.', '2017-07-20 02:22:02'),
(165, 'Usuário lucas efetuou login.', '2017-07-20 02:24:22'),
(166, 'Pesquisa de usuário com cpf 066.700.663-09 efetuada.', '2017-07-20 02:24:29'),
(167, 'Pesquisa de cliente com cpf 066.700.663-09 efetuada.', '2017-07-20 02:24:41'),
(168, 'Usuário lucas efetuou login.', '2017-07-20 02:26:38'),
(169, 'Usuário lucas efetuou login.', '2017-07-20 02:27:06'),
(170, 'Usuário lucas efetuou login.', '2017-07-20 02:34:16'),
(171, 'Tentativa de cadastro de usuário: José Macedo, 000.111.222-33, (85)40028-9220, 19/07/2017, admin.', '2017-07-20 02:35:21'),
(172, 'Novo usuário com nome de usuário admin cadastrado com sucesso.', '2017-07-20 02:35:24');

-- --------------------------------------------------------

--
-- Estrutura para tabela `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `cpf` char(14) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `birthday` date NOT NULL,
  `date_register` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `person`
--

INSERT INTO `person` (`id`, `name`, `cpf`, `phone`, `birthday`, `date_register`) VALUES
(1, 'Lucas Pereira Torres de Araújo', '066.700.663-09', '(85)99642-6187', '1998-01-16', '2017-07-04 13:43:02'),
(2, 'Kalebe Pereira Torres de Araújo', '771.091.350-47', '(85)99000-0000', '2004-05-04', '2017-07-04 13:46:19'),
(17, 'José Macedo', '000.111.222-33', '(85)40028-9220', '2017-07-19', '2017-07-20 02:35:23');

-- --------------------------------------------------------

--
-- Estrutura para tabela `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `price` double NOT NULL,
  `code_bar` varchar(40) NOT NULL,
  `brand_origin` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `product`
--

INSERT INTO `product` (`id`, `name`, `description`, `price`, `code_bar`, `brand_origin`) VALUES
(1, 'iPhone 6', 'Smartphone', 2000, '000000000001', 'Apple'),
(2, 'Teclado', 'Periférico para computador', 100, '000000000002', 'Microsoft'),
(3, 'Pen Drive 50gb', 'Pen drive.', 50, '003', 'StoneKing');

-- --------------------------------------------------------

--
-- Estrutura para tabela `register_general`
--

CREATE TABLE `register_general` (
  `id` int(11) NOT NULL,
  `sales_today` int(11) NOT NULL,
  `cash_register` double NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `register_store`
--

CREATE TABLE `register_store` (
  `id` int(11) NOT NULL,
  `ref_store` int(11) NOT NULL,
  `sales_today` int(11) NOT NULL,
  `cash_register` double NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `register_store`
--

INSERT INTO `register_store` (`id`, `ref_store`, `sales_today`, `cash_register`, `date`) VALUES
(1, 1, 1, 2100, '2017-07-04');

-- --------------------------------------------------------

--
-- Estrutura para tabela `sale`
--

CREATE TABLE `sale` (
  `id` int(11) NOT NULL,
  `ref_user` int(11) NOT NULL,
  `ref_client` int(11) NOT NULL,
  `need_carrier` tinyint(1) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL,
  `value` double NOT NULL,
  `date_purchase` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `sale`
--

INSERT INTO `sale` (`id`, `ref_user`, `ref_client`, `need_carrier`, `status`, `value`, `date_purchase`) VALUES
(1, 1, 1, 1, 1, 2100, '2017-07-04 14:04:01'),
(4, 1, 1, 1, 1, 2000, '2017-07-19 20:27:18'),
(5, 1, -1, 0, 1, 2000, '2017-07-19 20:31:02'),
(6, 1, -1, 1, 1, 100, '2017-07-19 20:33:42'),
(7, 1, 1, 0, 1, 2100, '2017-07-19 21:53:37'),
(8, 1, -1, 0, 1, 100, '2017-07-20 01:00:07');

-- --------------------------------------------------------

--
-- Estrutura para tabela `storage`
--

CREATE TABLE `storage` (
  `id` int(11) NOT NULL,
  `ref_storage` int(11) NOT NULL,
  `ref_product` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `storage`
--

INSERT INTO `storage` (`id`, `ref_storage`, `ref_product`, `amount`) VALUES
(1, 1, 1, 60),
(2, 1, 2, 100),
(4, 1, 3, 100);

-- --------------------------------------------------------

--
-- Estrutura para tabela `store`
--

CREATE TABLE `store` (
  `id` int(11) NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `store`
--

INSERT INTO `store` (`id`, `address`, `phone`) VALUES
(1, 'Avenida da Universidade, 123, 60000-000', '08534930000');

-- --------------------------------------------------------

--
-- Estrutura para tabela `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `login` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT '0',
  `ref_person` char(14) NOT NULL,
  `ref_store` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `user`
--

INSERT INTO `user` (`id`, `login`, `password`, `is_admin`, `ref_person`, `ref_store`) VALUES
(1, 'lucas', '12345', 1, '066.700.663-09', 1),
(8, 'admin', 'admin', 1, '000.111.222-33', 1);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `carrier`
--
ALTER TABLE `carrier`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ref_person` (`ref_person`);

--
-- Índices de tabela `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`id`),
  ADD KEY `delivery_sale_fk` (`ref_sale`),
  ADD KEY `delivery_carrier_fk` (`ref_carrier`);

--
-- Índices de tabela `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `item_sale_fk` (`ref_sale`),
  ADD KEY `item_product_fk` (`ref_product`);

--
-- Índices de tabela `logcommands`
--
ALTER TABLE `logcommands`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Índices de tabela `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `register_general`
--
ALTER TABLE `register_general`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `register_store`
--
ALTER TABLE `register_store`
  ADD PRIMARY KEY (`id`),
  ADD KEY `register_store_fk` (`ref_store`);

--
-- Índices de tabela `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sale_user_fk` (`ref_user`),
  ADD KEY `sale_client_fk` (`ref_client`);

--
-- Índices de tabela `storage`
--
ALTER TABLE `storage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `storage_store_fk` (`ref_storage`),
  ADD KEY `storage_product_fk` (`ref_product`);

--
-- Índices de tabela `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ref_person` (`ref_person`),
  ADD KEY `user_store_fk` (`ref_store`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `carrier`
--
ALTER TABLE `carrier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de tabela `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de tabela `delivery`
--
ALTER TABLE `delivery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de tabela `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de tabela `logcommands`
--
ALTER TABLE `logcommands`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=173;
--
-- AUTO_INCREMENT de tabela `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de tabela `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de tabela `register_store`
--
ALTER TABLE `register_store`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de tabela `sale`
--
ALTER TABLE `sale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de tabela `storage`
--
ALTER TABLE `storage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de tabela `store`
--
ALTER TABLE `store`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de tabela `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_person_fk` FOREIGN KEY (`ref_person`) REFERENCES `person` (`cpf`);

--
-- Restrições para tabelas `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `delivery_carrier_fk` FOREIGN KEY (`ref_carrier`) REFERENCES `carrier` (`id`),
  ADD CONSTRAINT `delivery_sale_fk` FOREIGN KEY (`ref_sale`) REFERENCES `sale` (`id`);

--
-- Restrições para tabelas `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_sale_fk` FOREIGN KEY (`ref_sale`) REFERENCES `sale` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `item_product_fk` FOREIGN KEY (`ref_product`) REFERENCES `product` (`id`) ON UPDATE CASCADE;

--
-- Restrições para tabelas `register_store`
--
ALTER TABLE `register_store`
  ADD CONSTRAINT `register_store_fk` FOREIGN KEY (`ref_store`) REFERENCES `store` (`id`);

--
-- Restrições para tabelas `storage`
--
ALTER TABLE `storage`
  ADD CONSTRAINT `storage_store_fk` FOREIGN KEY (`ref_storage`) REFERENCES `store` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `storage_product_fk` FOREIGN KEY (`ref_product`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_store_fk` FOREIGN KEY (`ref_store`) REFERENCES `store` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `user_person_fk` FOREIGN KEY (`ref_person`) REFERENCES `person` (`cpf`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
