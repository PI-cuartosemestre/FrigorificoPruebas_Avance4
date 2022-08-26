-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:33065
-- Tiempo de generación: 24-08-2022 a las 07:04:06
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `frigorifico_de_la_vega_steak_house`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `CODIGOCAT` int(11) NOT NULL,
  `NOMBRE_CAT` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`CODIGOCAT`, `NOMBRE_CAT`) VALUES
(101, 'ACEITES'),
(102, 'ALIMENTO'),
(103, 'ARROZ'),
(104, 'BEBIDAS'),
(105, 'CARNICOS'),
(106, 'CERVEZA'),
(107, 'CONDIMENTO'),
(108, 'EMBUTIDO'),
(109, 'ENLATADOS'),
(110, 'HUEVOS'),
(111, 'LACTEO'),
(112, 'LIMPIEZA'),
(113, 'PASTAS'),
(114, 'SALSAS'),
(115, 'VINOS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `COD_PERSONA` int(11) NOT NULL,
  `DEUDA` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`COD_PERSONA`, `DEUDA`) VALUES
(3, '0.00'),
(1, '0.00'),
(4, '0.00'),
(5, '0.00'),
(6, '0.00'),
(7, '0.00'),
(8, '0.00'),
(9, '0.00'),
(10, '0.00'),
(11, '0.00'),
(12, '0.00'),
(13, '0.00'),
(14, '0.00'),
(15, '0.00'),
(16, '0.00'),
(17, '0.00'),
(18, '0.00'),
(19, '0.00'),
(20, '0.00'),
(21, '0.00'),
(22, '0.00'),
(23, '0.00'),
(24, '0.00'),
(25, '0.00'),
(26, '0.00'),
(27, '0.00'),
(28, '0.00'),
(29, '0.00'),
(30, '0.00'),
(31, '0.00'),
(32, '0.00'),
(33, '0.00'),
(34, '0.00'),
(35, '0.00'),
(36, '0.00'),
(37, '0.00'),
(38, '0.00'),
(39, '0.00'),
(40, '0.00'),
(41, '0.00'),
(42, '0.00'),
(43, '0.00'),
(44, '0.00'),
(45, '0.00'),
(68, '0.00'),
(69, '0.00'),
(70, '0.00'),
(71, '0.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `CODIGOCOMPRAS` int(11) NOT NULL,
  `CODIGOEMPL` int(11) NOT NULL,
  `FECHA` varchar(50) NOT NULL,
  `TOTAL` decimal(10,5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `compras`
--

INSERT INTO `compras` (`CODIGOCOMPRAS`, `CODIGOEMPL`, `FECHA`, `TOTAL`) VALUES
(1, 5, '05/08/2022', '50.00000'),
(2, 5, '05/08/2022', '20.00000'),
(3, 5, '05/08/2022', '70.00000'),
(4, 5, '05/08/2022', '70.00000'),
(5, 5, '05/08/2022', '20.00000'),
(6, 5, '05/08/2022', '80.00000'),
(7, 5, '05/08/2022', '80.00000'),
(8, 5, '05/08/2022', '40.00000'),
(9, 5, '06/08/2022', '210.00000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprasdetalle`
--

CREATE TABLE `comprasdetalle` (
  `CODIGOCODE` int(11) NOT NULL,
  `CODIGOCOMPRAS` int(11) DEFAULT NULL,
  `ID_INVENTARIO` int(11) NOT NULL,
  `CANTIDAD` decimal(6,2) NOT NULL,
  `VALOR_UNITARIO` decimal(8,2) NOT NULL,
  `TOTAL` decimal(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comprasdetalle`
--

INSERT INTO `comprasdetalle` (`CODIGOCODE`, `CODIGOCOMPRAS`, `ID_INVENTARIO`, `CANTIDAD`, `VALOR_UNITARIO`, `TOTAL`) VALUES
(1, 1, 1, '5.00', '10.00', '50.00'),
(2, 2, 1, '2.00', '10.00', '20.00'),
(3, 3, 1, '7.00', '10.00', '70.00'),
(4, 4, 1, '7.00', '10.00', '70.00'),
(5, 5, 1, '2.00', '10.00', '20.00'),
(6, 6, 1, '8.00', '10.00', '80.00'),
(7, 7, 1, '8.00', '10.00', '80.00'),
(8, 8, 1, '4.00', '10.00', '40.00'),
(9, 9, 1, '5.00', '10.00', '50.00'),
(10, 9, 2, '8.00', '20.00', '160.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `CODIGOEMPL` int(11) NOT NULL,
  `COD_PERSONA` int(11) NOT NULL,
  `SUELDO` decimal(8,2) NOT NULL,
  `ESTADO` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`CODIGOEMPL`, `COD_PERSONA`, `SUELDO`, `ESTADO`) VALUES
(5, 6, '425.00', 1),
(6, 72, '425.00', 1),
(7, 5, '425.00', 1),
(8, 73, '425.00', 1),
(9, 74, '425.00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `ID_INVENTARIO` int(11) NOT NULL,
  `CODIGOINV` varchar(15) NOT NULL,
  `NOMBRE_PRO` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CODIGOCAT` int(11) NOT NULL,
  `DESCRIPCION` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CANTIDAD` decimal(10,3) DEFAULT NULL,
  `PRECIO_COMPRA` decimal(10,5) NOT NULL,
  `PRECIO` decimal(8,3) NOT NULL,
  `ID_PROVEEDOR` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`ID_INVENTARIO`, `CODIGOINV`, `NOMBRE_PRO`, `CODIGOCAT`, `DESCRIPCION`, `CANTIDAD`, `PRECIO_COMPRA`, `PRECIO`, `ID_PROVEEDOR`) VALUES
(0, 'VAR0013', 'Arroz 1 kg ', 103, 'Funda de arroz de 1kg', '4.000', '1.02000', '1.200', 18),
(1, 'BOLMOR001', 'Mortadela bologna tipo I ', 108, 'paquete 100 gramos\r\npor unidades', '8.000', '8.50000', '10.000', 2),
(2, 'FRLEP001', 'Pimienta negra molida', 107, 'frasco de 55gramos\r\nunidades ', '20.000', '2.00000', '3.000', 2),
(3, 'FRLE003', 'Chuuleta ahumada cerdo  ', 105, 'paquete de chuletas (dentro 3 a 4)\r\nunidades', '1.000', '6.00000', '6.200', 1),
(4, 'FRLE004', 'Costilla ahumada cerdo ', 105, 'Paquete de chuleta 1kg aprox\r\n', '6.000', '6.25000', '8.000', 1),
(5, 'FRLE005', 'Tocino ahumado cerdo ', 108, 'Paquete de tocino ahumado de 200gramos c/u\r\nunidades', '6.000', '1.00000', '1.600', 1),
(6, 'ITAL0001', 'Chorizo paisa de cerdo', 108, 'paquete de chorizo x6 unidades c/u\r\nunidades\r\n', '3.000', '3.18000', '3.750', 2),
(7, 'ITAL0002', 'Chorizo cuencano ternera ', 108, 'paquete de chorizo x6 unidades c/u', '3.000', '3.18000', '3.750', 2),
(8, 'ITAL0003', 'Chorizo parrillero ', 108, 'paquete de chorizo de 195gramos\r\nunidades', '3.000', '0.85000', '1.000', 2),
(9, 'ITAL0004', 'Salchicha de pollo tipo I ', 108, 'paquete de 100 gramos\r\nunidades ', '3.000', '0.55000', '0.650', 2),
(10, 'ITAL0005', 'Salchicha Frankfurt tipo I ', 108, 'paquetes de 100 gramos \r\nunidades', '3.000', '0.51000', '0.600', 2),
(11, 'ITAL0006', 'Jamon  Saduchero tipo II ', 108, 'paquete de 85 gramos \r\nunidades', '3.000', '0.72000', '0.850', 2),
(12, 'FRLE001', 'Chorizo ternera ', 108, 'paquete de 300 gramos ', '3.000', '3.18000', '3.750', 1),
(13, 'ITAL0008', 'Chorizo jalapeño con queso che', 108, 'paquete de 200 gramos \r\nunidades', '4.000', '4.18000', '4.750', 2),
(14, 'ITAL0009', 'Longaniza para asado ', 108, 'paquete de 400 gramos \r\nunidades', '3.000', '3.40000', '4.000', 2),
(15, 'ITAL0011', 'Nuggets pollo ', 108, 'paquete de 10 nuggets c/u\r\nunidades', '8.000', '0.85000', '1.000', 2),
(16, 'ITAL0012', 'Jamon  Saduchero tipo II ', 108, 'paquete de jamon de 200 gramos c/u', '2.000', '1.95000', '2.300', 2),
(17, 'PNCA001', 'Chorizo parrilero Plumrose', 108, 'paquete de chorizo de 100 gramos\r\nunidades', '2.000', '2.23000', '2.750', 3),
(18, 'PNCA005', 'Pescuezos pollo granel ', 105, 'venta por kilos\r\nrevisar el # de kilos disponible', '8.000', '0.59000', '0.700', 4),
(19, 'PNCA006', 'Ave de campo pollo entero - ', 105, 'venta únicamente por pollo entero, precio de acuerdo el peso(kilos), revisar # de pollos disponibles', '2.000', '1.21000', '1.430', 4),
(20, 'ILE0001', 'Mega sazon', 107, 'envase de 200gramos \r\nunidades', '3.000', '0.87000', '1.250', 4),
(21, 'ILE0002', 'Chimichurri ', 107, 'envase de 215gramos\r\nunidades', '0.000', '0.55000', '0.650', 4),
(22, 'ILE0003', 'Salsa BBQ ', 114, 'envase de 350gramos', '4.000', '1.95000', '2.300', 4),
(23, 'ILE0004', 'Kasserola Sal con finas hierba', 107, 'envase de 85gramos\r\nunidades', '3.000', '2.97000', '3.500', 4),
(24, 'ILE0005', 'Kasserola Sal parrillera sazon', 107, 'envase de 85 gramos ', '2.000', '2.97000', '3.500', 4),
(25, 'ILE0006', 'Kasserola Sal ahumada con espe', 107, 'envase de 85 gramos', '2.000', '2.97000', '3.500', 4),
(26, 'ILE0007', 'Kasserola Sal con pimienta y l', 107, 'envase de 85 gramos ', '1.000', '2.00000', '3.500', 4),
(27, 'ILE0008', 'Kasserola Sal con especias', 107, 'envase de 65 gramos ', '1.000', '2.97000', '3.500', 4),
(28, 'ILE0009', 'Kasserola Sal con ajo', 107, 'envase de 65 gramos ', '2.000', '2.97000', '3.500', 4),
(29, 'ILE0010', 'Vinagre con especias ', 107, 'botella de 500ml ', '8.000', '1.02000', '1.200', 6),
(30, 'ILE0011', 'Vinagre blaco', 107, 'botella de 200ml', '5.000', '0.51000', '0.600', 5),
(31, 'CMENSA001', 'Laurel ', 107, 'sachet de 30 gramos ', '4.000', '0.85000', '1.000', 5),
(32, 'FRLE002', 'Chorizo paisa  ', 108, 'paquete de 6 chorizos', '10.000', '0.56000', '3.750', 1),
(33, 'CMENSA003', 'Sazonador para pollo ', 107, 'envase de 70 gramos ', '4.000', '0.93000', '1.100', 5),
(34, 'CMENSA004', 'Sazonador para carnes rojas', 107, 'envase de 70 gramos ', '3.000', '0.93000', '1.100', 5),
(35, 'CMENSA005', 'Sazonador para pescado y maris', 107, 'envase de 70 gramos ', '3.000', '0.93000', '1.100', 5),
(36, 'CMENSA006', 'Cebolla en polvo ', 107, 'envase de 70 gramos ', '3.000', '0.93000', '1.100', 5),
(37, 'CMENSA007', 'Perejil  frasco ', 107, 'frasco de 15 gramos ', '3.000', '0.93000', '1.100', 5),
(38, 'CMENSA008', 'Curcuma', 107, 'frasco de 15 gramos ', '3.000', '0.93000', '1.100', 5),
(39, 'CMENSA009', 'Romero ', 107, 'frasco 15 gramos ', '3.000', '0.93000', '1.100', 5),
(40, 'CMENSA010', 'Oregano  ', 107, 'frasco 15 gramos ', '3.000', '0.93000', '1.100', 5),
(41, 'CMENSA011', 'Jengibre ', 107, 'frasco de 40 gramos ', '3.000', '0.93000', '1.100', 5),
(42, 'CMENSA012', 'Ajo granulado ', 107, 'frasco de 35 gramos ', '3.000', '0.93000', '1.100', 5),
(43, 'CMENSA013', 'Ajo en polvo', 107, 'frasco de 70 gramos ', '3.000', '0.93000', '1.100', 5),
(44, 'CMENSA014', 'Canela molida ', 107, 'frasco de 40 gramos ', '4.000', '0.93000', '1.100', 5),
(45, 'CMENSA015', 'Curry', 107, 'frasco 85 gramos', '4.000', '0.93000', '1.100', 5),
(46, 'CMENSA016', 'Sal parrillera', 107, 'frasco 90 gramos ', '0.000', '0.93000', '1.100', 5),
(47, 'CMENSA017', 'Sal parrillera', 107, 'frasco 180 gramos ', '5.000', '1.91000', '2.250', 5),
(48, 'CMENSA018', 'Sal parrillera finas hierbas 7', 107, 'frasco 180 gramos ', '6.000', '0.93000', '1.100', 5),
(49, 'CMENSA019', 'Sal parrillera con finas hierb', 107, 'frasco 180 gramos ', '2.000', '1.91000', '2.250', 5),
(50, 'CMENSA020', 'Sal ahumada ', 107, 'frasco 70 gramos ', '2.000', '0.93000', '1.100', 5),
(51, 'CMENSA021', 'Sazonador a las finas hierbas ', 107, 'frasco 180 gramos ', '2.000', '0.93000', '1.100', 5),
(52, 'CMENSA022', 'Comino molido ', 107, 'frasco 50 gramos ', '2.000', '0.93000', '1.100', 5),
(53, 'CMENSA023', 'Paprika ', 107, 'frasco 50 gramos ', '2.000', '0.93000', '1.100', 5),
(54, 'CMENSA024', 'Cilantro ', 107, 'frasco 15 gramos ', '2.000', '0.93000', '1.100', 5),
(55, 'CMENSA025', 'Tomillo ', 107, 'frasco 20  gramos ', '2.000', '0.93000', '1.100', 5),
(56, 'CMENSA026', 'Albahaca', 107, 'frasco 12 gramos ', '2.000', '0.93000', '1.100', 5),
(57, 'CMENSA027', 'Mix de pimienta', 107, 'frasco 22 gramos ', '20.000', '0.93000', '1.100', 5),
(58, 'CMENSA028', 'Vinagre ', 107, 'botella 220ml', '12.000', '0.93000', '1.100', 5),
(59, 'VAR0001', 'Cubeta de huevos por 30 ', 110, 'venta por cubetas, 30 huevos en c/u', '6.000', '3.06000', '3.600', 7),
(60, 'VAR0002', 'Cubeta de huevos por 15 ', 110, 'venta por cubetas, 15 huevos en c/u', '4.000', '1.26000', '1.800', 7),
(61, 'VAR0003', 'Mani molido', 102, 'tarrina de 250 gramos', '6.000', '0.85000', '1.000', 8),
(62, 'VAR0004', 'Sal prieta', 102, 'tarrina de 250 gramos', '6.000', '0.85000', '1.000', 8),
(63, 'VAR0005', 'Chifles Sal grande ', 102, 'Fundas  de 100 gramos ', '6.000', '0.85000', '1.000', 9),
(64, 'VAR0006', 'Chifles Sal pequeño ', 102, 'fundas de 50 gramos ', '4.000', '0.42000', '0.500', 9),
(65, 'VAR0007', 'Chifles maduro pequeño ', 102, 'fundas de 50 gramos ', '8.000', '0.42000', '0.500', 9),
(66, 'VAR0008', 'Carbon cafe y guayaba ', 102, 'fundas de carbon ', '6.000', '2.55000', '3.000', 8),
(67, 'VAR0009', 'Yuca cruda ', 102, 'funda de 1kg', '0.000', '0.85000', '1.000', 10),
(68, 'VAR0010', 'Yuca pre cocida', 102, 'funda de 500gramos', '0.000', '0.85000', '1.000', 10),
(69, 'VAR0011', 'Arroz de 25 lb ', 103, 'venta por sacos(unidades)', '5.000', '7.00000', '10.000', 18),
(70, 'VAR0012', 'Arroz 2 kg ', 103, 'venta por fundas(unidades)', '6.000', '1.68000', '2.400', 18),
(72, 'EKO001', 'Chorizo Ahumado parrillero', 108, 'paquete chorizo de 6 unidades', '8.000', '2.33000', '2.750', 11),
(73, 'EKO002', 'Longaniza Ahumada ', 108, 'Venta por kilos', '8.000', '3.15000', '4.500', 11),
(74, 'LACT0001', 'Leche rey', 111, 'Carton de 1 litro', '6.000', '0.85000', '1.000', 12),
(75, 'LACT0002', 'Leche Lenutrit', 111, 'Funda de 1 litro', '6.000', '0.72000', '0.850', 13),
(76, 'COBER001', 'AXION CREMA PODER EN PLASTICOS', 112, 'Envase de 255 gramos', '6.000', '0.74000', '0.880', 17),
(77, 'COBER002', 'PROMO AXION CREMA ALOE ', 112, 'Envase de 255 gramos', '6.000', '0.74000', '0.880', 17),
(78, 'COBER003', 'AXION CREMA LIMON', 112, 'Envase de 255 gramos', '12.000', '0.74000', '0.880', 17),
(79, 'COBER004', 'AXION CREMA ALOE ', 112, 'Envase de 255 gramos', '70.000', '0.74000', '0.880', 17),
(80, 'COBER005', 'LA LECHERA ENTERA ', 111, 'Carton de leche de 1 litro', '75.000', '1.08000', '1.276', 17),
(81, 'COBER006', 'RICACAO ', 102, 'sobre de 150 gramos ', '55.000', '0.74000', '0.880', 17),
(82, 'COBER007', 'NESCAFE TRADICIONAL', 102, 'paquete de 25 gramos', '10.000', '0.56000', '0.660', 17),
(83, 'COBER008', 'LA SAZON ', 107, 'paquete de 150 gramos', '24.000', '0.74000', '0.880', 17),
(84, 'COBER009', 'LA SAZON ADOBO ', 107, 'sobre 30 gramos ', '27.000', '0.22000', '0.264', 17),
(85, 'COBER010', 'CALDO DE GALLINA ', 107, 'sobre 20 gramos ', '20.000', '0.37000', '0.440', 17),
(86, 'COBER011', 'DOÑA CRIOLLA ', 107, 'sobre 5 gramos ', '42.000', '0.18000', '0.220', 17),
(87, 'COBER012', 'MAYONESA LAMINA ', 114, 'sachet 30 gramos ', '20.000', '0.26000', '0.308', 17),
(88, 'COBER013', 'MAYONESA', 114, 'empaque de 200 gramos, venta por unidad', '42.000', '1.12000', '1.320', 17),
(89, 'COBER014', 'MOSTAZA LAMINA', 114, 'sachet 30 gramos ', '42.000', '0.26180', '0.308', 17),
(90, 'COBER015', 'MOSTAZA', 114, 'empaque de 200 gramos, venta por unidad', '20.000', '0.78500', '0.924', 17),
(91, 'COBER016', 'SALSA DE TOMATE ', 114, 'sachet de 400 gramos', '24.000', '0.78500', '0.924', 17),
(92, 'COBER017', 'SALSA TOMATE', 114, '', '24.000', '0.00000', '0.308', 17),
(93, 'COBER018', 'FRESCO SOLO MORA ', 104, 'sachet 10 gramos', '12.000', '0.18000', '0.220', 17),
(94, 'COBER019', 'FRESCO SOLO FRUTOS ROJOS', 104, 'Sachet 10 gramos', '12.000', '0.18000', '0.220', 17),
(95, 'COBER020', 'FRESH TEA SABOR A LIMON ', 104, 'sachet 10 gramos', '24.000', '0.18000', '0.220', 17),
(96, 'COBER021', 'FRESH TEA SABOR A FRUTAS', 104, 'sachet 20 gramos', '50.000', '0.18000', '0.220', 17),
(97, 'COBER022', 'RANCHERO GALL ', 107, 'sobre 8 gramos', '50.000', '0.18000', '0.220', 17),
(98, 'COBER023', 'MACARRON   ', 113, 'empaque de 200 gramos', '40.000', '0.48000', '0.572', 17),
(99, 'COBER024', 'LAZO PEQUEÑO', 113, 'empaque de 200 gramos', '20.000', '0.48600', '0.572', 17),
(100, 'COBER025', 'LASAGNA   ', 113, 'empaque de 200 gramos', '0.000', '2.05000', '2.420', 17),
(101, 'COBER026', 'LASAGNA AZ ', 113, 'paquete de 400 gramos ', '0.000', '3.36000', '3.960', 17),
(102, 'COBER027', 'CABELLO DE ANGEL ', 113, 'paquete de 200 gramos', '25.000', '0.48600', '0.572', 17),
(103, 'COBER028', 'TALLARIN', 113, 'paquete de 200 gramos', '20.000', '0.74800', '0.880', 17),
(104, 'COBER029', 'TALLARIN ', 113, 'paquete de 400 gramos', '16.000', '1.38000', '1.628', 17),
(105, 'COBER030', 'ATUN ISABEL TRIPACK ', 109, 'lata de 80 gramos ', '50.000', '2.05700', '2.420', 17),
(106, 'COBER031', 'CAFE ORO ', 102, 'paquete de 23 gramos', '25.000', '0.74800', '0.880', 17),
(107, 'COBER032', 'FIDEO LA DELICIA BROCA ', 113, 'paquete de 200 gramos ', '24.000', '0.37400', '0.440', 17),
(108, 'COBER033', 'VALDEZ AZUCAR BLANCA ', 102, 'paquete de 500 gramos ', '24.000', '1.60000', '1.892', 17),
(109, 'COBER034', 'ACEITE LA FAVORITA ', 101, 'botella de 295 ml', '24.000', '0.93000', '1.100', 17),
(110, 'COBER035', 'ACEITE CRIOLLO', 101, 'botella de 175 ml', '30.000', '0.48620', '0.572', 17),
(111, 'COBER036', 'ACEITE CRIOLLO ', 101, 'botella de 340ml', '30.000', '0.93000', '1.100', 17),
(112, 'COBER037', 'ACHIOTE LA FAVORITA ', 101, 'botella de 200 ml', '30.000', '1.12000', '1.320', 17),
(113, 'COBER038', 'ACHIOTE CRIOLLO', 101, 'botella de 200ml', '30.000', '0.93000', '1.100', 17),
(114, 'COBER039', 'ACHIOTE LA FAVORITA ', 101, 'botella de 370ml', '15.000', '1.59000', '2.288', 17),
(115, 'COBER040', 'ACEITE LA FAVORITA ', 101, 'botella de 1.2 litro', '15.000', '1.68000', '1.980', 17),
(116, 'COBER041', 'ACEITE LA FAVORITA ', 101, 'botella de 1litro', '30.000', '2.61000', '3.740', 17),
(117, 'COBER042', 'ACEITE GIRASOL ', 101, 'botella de 1 litro', '48.000', '4.86000', '5.720', 17),
(118, 'COBER043', 'ACEITE GIRASOL', 101, 'botella de medio litro', '72.000', '2.73000', '3.212', 17),
(119, 'COBER044', 'MARGARINA GIRASOL', 102, 'envase de 240 gramos', '36.000', '0.74000', '0.880', 17),
(120, 'COBER045', 'SERVILLETA ECONOMICA ', 112, 'paquetes individuales', '12.000', '0.26180', '0.308', 17),
(121, 'COBER046', 'SERVILLETA NORMAL ', 112, 'paquetes individuales', '24.000', '0.93000', '1.100', 17),
(122, 'COBER047', 'TC FLIA BASICA MULTICORTES ', 112, 'paquetes individuales', '12.000', '1.49000', '1.760', 17),
(123, 'COBER048', 'TC PRACTI-DIARIA ', 112, 'paquetes individuales', '6.000', '0.74000', '0.880', 17),
(124, 'COBER049', 'MINI BIC J5 STANDARD', 112, 'unidades', '6.000', '0.56100', '0.660', 17),
(125, 'BIELA01', 'HEINEKEN LATA ', 106, 'venta por six pack (paquete de 6 unidades)', '18.000', '1.00003', '1.180', 19),
(126, 'BIELA02', 'BIELA RESERVA', 106, 'Venta por unidades, LATA 355 ML', '6.000', '0.62000', '0.730', 19),
(127, 'BIELA03', 'SOL ', 106, 'Venta por unidades, envase 355 ML', '6.000', '1.29000', '1.520', 19),
(128, 'BIELA04', 'AMSTEL ', 106, 'Venta por unidades, LATA 355 ML', '6.000', '0.69000', '0.820', 19),
(129, 'BIELA05', 'BIELA LIGHT ', 106, 'Venta por unidades, LATA 355 ML', '6.000', '0.62000', '0.730', 19),
(130, 'BIELA06', 'HEINEKEN ', 106, 'Venta por unidades, LATA 473 ML', '6.000', '1.46200', '1.720', 19),
(131, 'BIELA07', 'BIELA RESERVA', 106, 'Venta por unidades, LATA 473 ML', '6.000', '1.00003', '1.180', 19),
(132, 'BIELA08', 'AMSTEL ', 106, 'Venta por unidades, LATA 473 ML', '6.000', '0.92000', '1.090', 19),
(133, 'PILSENERCLUB01', 'CLUB  NR TERM VERDE ', 106, 'Venta por unidades envases 330 cc', '6.000', '0.85000', '1.010', 20),
(134, 'PILSENER02', 'PILSENER  NR ', 106, 'Venta por unidades, envases 330cc', '6.000', '0.76000', '0.900', 20),
(135, 'PILSENER03', 'PILSENER LIGHT ', 106, 'Venta por 6 pack(lata de 355ml)', '18.000', '0.59000', '0.700', 20),
(136, 'PILSENER04', 'CLUB TERMO VER LAT', 106, 'Venta por 6 pack(lata de 355ml)', '6.000', '0.97750', '1.150', 20),
(137, 'PILSENER05', 'PILSENER', 106, 'Venta por 6 pack(lata de 473ml)', '18.000', '0.71400', '0.840', 20),
(138, 'PILSENERBECK06', 'BECKS ', 106, 'Venta por 6 pack(lata de 269ml)', '6.000', '0.62050', '0.730', 20),
(139, 'PILSENERCORON07', 'CORONA EXTRA ', 106, 'Venta por 6 pack(envase de 355ml)', '18.000', '1.23000', '1.450', 20),
(140, 'PILSENERBUD08', 'BUDWEISER BOTELLA', 106, 'Venta por 6 pack(envase de 355ml)', '6.000', '0.95000', '1.120', 20),
(141, 'PILSENERBUD09', 'BUDWEISER LATA ', 106, 'Venta por 6 pack(lata de 355ml)', '6.000', '0.92000', '1.090', 20),
(142, 'CARMEN01', 'CARMEN INSIGNE CABERNET SUAVIG', 115, 'venta por unidades', '6.000', '6.37000', '7.500', 21),
(143, 'CARMEN01', 'CARMEN INSIGNE MERLOT', 115, 'venta por unidades', '6.000', '5.84800', '6.880', 21),
(144, 'CARMEN03', 'CARMEN INSIGNE SUAVIGNON BLANC', 115, 'venta por unidades', '6.000', '6.37000', '7.500', 21),
(145, 'PANULCABER01', 'PANUL VARIETAL CABERNET SAUVIG', 115, 'venta por unidades', '6.000', '5.15000', '6.060', 21),
(146, 'PANULMERLOT02', 'PANUL VARIETAL MERLOT 2017', 115, 'venta por unidades', '6.000', '5.15000', '6.060', 21),
(147, 'PANULBLANCO03', 'PANUL VARIETAL SUAVIGNON BLANC', 115, 'venta por unidades', '6.000', '5.15000', '6.060', 21),
(148, 'TAGUATAGUA01', 'TAGUA TAGUA CABERNET SAUVIGNON', 115, 'venta por unidades', '6.000', '4.99800', '5.880', 21),
(149, 'TAGUATAGUAM02', 'TAGUA TAGUA MERLOT ', 115, 'venta por unidades', '6.000', '4.99800', '5.880', 21),
(150, 'LAMBRUSCO01', 'LAMBRUSCO DELLEMILIA ROSADO GI', 115, 'venta por unidades', '6.000', '5.66000', '6.660', 21),
(151, 'CONDETINTO01', 'CONDE DE LA CRUZ TINTO ', 115, 'venta por unidades, envase de 750ml', '6.000', '4.85350', '5.710', 21),
(152, 'CONDEBLANCO02', 'CONDE DE LA CRUZ BLANCO ', 115, 'venta por unidades, envase de 750ml', '6.000', '4.04600', '4.760', 21),
(153, 'ITAL0010', 'Chulteros de lomo tipo I', 108, 'Venta por kilos', '2.000', '1.96000', '2.800', 2),
(154, 'PNCA002', 'Patas pollo granel - pronaca', 105, 'Venta por kilos', '3.000', '1.30000', '1.870', 3),
(155, 'PNCA003', 'Higados pollo granel - pronaca', 105, 'Venta por kilos', '8.000', '1.58000', '1.870', 3),
(156, 'PNCA004', 'Mollejas pollo granel', 105, 'Venta por kilos', '10.000', '2.55000', '3.000', 3),
(157, 'PNCA005', 'Pescuezos pollo granel ', 105, 'Venta por kilos', '8.000', '1.30000', '1.870', 3),
(158, 'PNCA006', 'Ave de campo pollo entero ', 105, 'Venta por kilos', '12.000', '1.05000', '1.500', 3),
(159, 'LACT0003', 'Queso suave ', 111, 'Venta por kilos', '15.000', '1.00000', '2.000', 4),
(160, 'LACT0004', 'Queso semiduro chicloso  ', 111, 'Venta por kilos', '10.000', '1.75000', '2.500', 4),
(161, 'PLLO00001', 'Pollo I pelado a mano ', 105, 'Venta por kilos', '5.000', '1.10000', '2.200', 5),
(162, 'PLLO00002', 'Pollo II pelado a mano ', 105, 'Venta por kilos', '5.000', '1.15000', '3.300', 5),
(163, 'PLLO00003', 'Pollo III pelado a mano', 105, 'Venta por kilos', '5.000', '1.40000', '2.400', 5),
(164, 'PLLO00004', 'Pollo IV pelado a mano', 105, 'Venta por kilos', '6.000', '1.35000', '2.500', 5),
(165, 'PLLO00005', 'Pavi pollo pelado a mano ', 105, 'Venta por kilos', '5.000', '2.10000', '3.000', 5),
(166, 'PLLO00006', 'Alas de pollo', 105, 'Venta por kilos', '2.000', '1.40000', '2.000', 5),
(167, 'PLLO00007', 'Pechuga pollo presa selecionad', 105, 'Venta por kilos', '3.000', '1.57000', '2.250', 5),
(168, 'PLLO00008', 'Post pierna pollo presa selecc', 105, 'Venta por kilos', '5.000', '1.40000', '2.000', 5),
(169, 'PLLO00009', 'Pierna pollo presa seleccionad', 105, 'Venta por kilos', '4.000', '1.94000', '2.000', 5),
(170, 'PLLO00010', 'Higado pollo ', 105, 'Venta por kilos', '6.000', '0.59000', '0.850', 5),
(171, 'PLLO00011', 'Patas pollo ', 105, 'Venta por kilos', '4.000', '0.59000', '0.850', 5),
(172, 'PLLO00012', 'Cuello pollo ', 105, 'Venta por kilos', '4.000', '0.59000', '0.850', 5),
(173, 'CERD001', 'Hueso carnudo de cerdo ', 105, 'Venta por kilos', '4.000', '1.22000', '1.750', 6),
(174, 'CERD0002', 'Carne Pura de cerdo - Granja R', 105, 'Venta por kilos', '3.000', '1.92000', '2.750', 7),
(175, 'CERD0003', 'Grasa carnuda chicharron ', 105, 'Venta por kilos', '6.000', '1.92000', '1.750', 16),
(176, 'CERD0004', 'Grasa regular de cerdo ', 105, 'Venta por kilos', '3.000', '1.05000', '1.500', 16),
(177, 'CERD0005', 'Cuero de cerdo ', 105, 'Venta por kilos', '3.000', '1.05000', '1.500', 16),
(178, 'CERD0006', 'Careta de cerdo ', 105, 'Venta por kilos', '3.000', '0.75000', '1.000', 16),
(179, 'CERD0007', 'Brazo de cerdo chuleta', 105, 'Venta por kilos', '0.000', '1.57500', '1.750', 16),
(180, 'CERD0008', 'Pierna de cerdo chuleta ', 105, 'Venta por kilos', '3.000', '1.75000', '2.500', 16),
(181, 'CERD0009', 'Costilla de cerdo sin cuero ', 105, 'Venta por kilos', '3.000', '1.92500', '2.750', 16),
(182, 'CERD0010', 'Lomo de cerdo chuletero ', 105, 'Venta por kilos', '3.000', '1.92500', '2.750', 16),
(183, 'CERD0011', 'Nuca de cerdo chuletero', 105, 'Venta por kilos', '2.000', '1.92500', '2.750', 16),
(184, 'CERD0012', 'Riñon de cerdo', 105, 'Venta por kilos', '2.000', '1.05000', '1.500', 16),
(185, 'CERD0013', 'Corazon de cerdo', 105, 'Venta por kilos', '4.000', '1.05000', '1.500', 16),
(186, 'VISC0001', 'Panza res viseras ', 105, 'Venta por kilos', '4.000', '1.75000', '2.500', 8),
(187, 'VISC0002', 'Higado Res viseras ', 105, 'Venta por kilos', '3.000', '1.75000', '2.500', 8),
(188, 'VISC0003', 'Ubre Res viseras ', 105, 'Venta por kilos', '3.000', '1.05000', '1.500', 8),
(189, 'VISC0004', 'Patas Res viseras  ', 105, 'Venta por kilos', '3.000', '0.87000', '1.250', 8),
(190, 'VISC0005', 'Corazon Res viseras ', 105, 'Venta por kilos', '3.000', '1.75000', '2.500', 8),
(191, 'VISC0006', 'Riñon Res viseras ', 105, 'Venta por kilos', '4.000', '1.05000', '1.500', 8),
(192, 'VISC0007', 'Carne Industrial molida', 105, 'Venta por kilos', '3.000', '1.05000', '1.500', 8),
(193, 'VISC0008', 'Lengua Res viseras ', 105, 'Venta por kilos', '3.000', '1.75000', '2.500', 8),
(194, 'VISC0009', 'Bofe Res viseras ', 105, 'Venta por kilos', '3.000', '0.59000', '0.850', 8),
(195, 'RES0001', 'Pulpa de Res ', 105, 'Venta por kilos', '2.000', '2.17000', '3.100', 8),
(196, 'RES0002', 'Comercial Res', 105, 'Venta por kilos', '2.000', '1.75000', '2.500', 8),
(197, 'RES0003', 'Corazon de pulpa', 105, 'Venta por kilos', '2.000', '2.45000', '3.500', 8),
(198, 'RES0004', 'Pulpa Brazo de Res', 105, 'Venta por kilos', '2.000', '2.17000', '3.100', 8),
(199, 'RES0005', 'Atravezado Res ', 105, 'Venta por kilos', '2.000', '1.92000', '2.750', 8),
(200, 'RES0006', 'Salon de Res ', 105, 'Venta por kilos', '2.000', '1.92000', '2.750', 8),
(201, 'RES0007', 'Labios de Brazo Res', 105, 'venta por kilos', '0.000', '1.92000', '2.750', 8),
(202, 'RES0008', 'Nuca Res ', 105, 'venta por kilos', '4.000', '1.75000', '2.500', 8),
(203, 'RES0009', 'Falda Res granel ', 105, 'venta por kilos', '3.000', '1.75000', '2.500', 8),
(204, 'RES0010', 'Chafaldeta Res ', 105, 'venta por kilos', '3.000', '1.75000', '2.500', 8),
(205, 'RES0011', 'Pecho Res con grasa ', 105, 'venta por kilos', '3.000', '1.75000', '2.500', 8),
(206, 'RES0012', 'Pecho Res ', 105, 'venta por kilos', '3.000', '1.75000', '2.500', 8),
(207, 'RES0013', 'Tapa Brazo Res ', 105, 'venta por kilos', '3.000', '1.75000', '2.500', 8),
(208, 'RES0014', 'Zota Lomo Res ', 105, 'venta por kilos', '3.000', '1.75000', '2.500', 8),
(209, 'RES0015', 'Nuca papada Res  ', 105, 'venta por kilos', '0.000', '1.05000', '1.500', 8),
(210, 'RES0016', 'Choclillo Res ', 105, 'venta por kilos', '3.000', '1.05000', '1.500', 8),
(211, 'RES0017', 'Lagartillos Res', 105, 'venta por kilos', '4.000', '1.05000', '1.500', 8),
(212, 'RES0018', 'Caucara Res ', 105, 'venta por kilos', '4.000', '1.75000', '2.500', 8),
(213, 'RES0019', 'Cachetes Res  ', 105, 'venta por kilos', '4.000', '1.05000', '1.500', 8),
(214, 'RES0020', 'Tapa Shungo Res', 105, 'venta por kilos', '2.000', '1.05000', '1.500', 8),
(215, 'RES0021', 'Costilla de Res normal', 105, 'venta por kilos', '2.000', '0.87500', '1.250', 8),
(216, 'RES0022', 'Costilla de Res especial ', 105, 'venta por kilos', '2.000', '1.05000', '1.500', 8),
(217, 'RES0023', 'Hueso carnudo Res ', 105, 'venta por kilos', '2.000', '0.00000', '1.250', 8),
(218, 'RES0024', 'Hueso Blanco carnudo Res', 105, 'venta por kilos', '2.000', '0.87500', '1.250', 8),
(219, 'RES0025', 'Hueso Blanco sin carne Res ', 105, 'venta por kilos', '2.000', '0.85000', '1.000', 8),
(220, 'RES0026', 'Hueso Blanco Res Garron ', 105, 'venta por kilos', '2.000', '0.87500', '1.250', 8),
(221, 'RES0027', 'Filtrafa Res granel ', 105, 'Venta por kilos', '2.000', '0.00000', '0.200', 8),
(222, 'RES0028', 'Carne Industrial Res ', 105, 'Venta por kilos', '2.000', '1.05000', '1.500', 8),
(223, 'CF0001', 'LOMO DE FALDA CON GRASA BIFE', 105, 'Venta por kilos', '2.000', '3.50000', '5.000', 8),
(224, 'CF0002', 'LOMO DE FALDA SIN GRASA  BIFE ', 105, 'Venta por kilos', '2.000', '3.50000', '5.000', 8),
(225, 'CF0003', 'LOMO FINO CON CABEZA Y CORDON ', 105, 'Venta por kilos', '2.000', '3.50000', '5.000', 8),
(226, 'CF0004', 'LOMO FINO SIN CABEZA Y  CORDON', 105, 'Venta por kilos', '2.000', '3.50000', '5.000', 8),
(227, 'CF0005', 'PICAÑA RES (CORTE FINO) ', 105, 'Venta por kilos', '2.000', '3.50000', '5.000', 8),
(228, 'CF0006', 'CUADRIL RES (CORTE FINO) ', 105, 'Venta por kilos', '2.000', '3.50000', '5.000', 8),
(229, 'CF0007', 'COLITA CUADRIL (CORTE FINO) ', 105, 'Venta por kilos', '2.000', '3.50000', '5.000', 8),
(230, 'CF0008', 'PECHO RES  BRISKET (CORTE FINO', 105, 'Venta por kilos', '2.000', '3.50000', '5.000', 8),
(231, 'CF0009', 'TIRA ASADO RES (CORTE FINO) ', 105, 'Venta por kilos', '2.000', '3.50000', '2.000', 8),
(232, 'CF0010', 'T-BONE (CORTE FINO) ', 105, 'Venta por unidades', '3.000', '3.50000', '5.000', 8),
(233, 'CF0011', 'RIB-EYE (CORTE FINO) ', 105, 'Venta por unidades', '1.000', '3.50000', '5.000', 8),
(234, 'CF0012', 'TOMAHAK RES (CORTE FINO)', 105, 'Venta por unidades', '1.000', '3.50000', '5.000', 8),
(235, 'CF0013', 'OJITOS DE BIFE RES ', 105, 'venta por kilos', '1.000', '3.50000', '5.000', 8),
(236, 'CF0014', 'COWBOY RES (CORTE FINO) ', 105, 'Venta por unidades', '1.000', '3.50000', '5.000', 8),
(237, 'CF0015', 'NEW YORK STEAK RES (CORTE FINO', 105, 'Venta por unidades', '1.000', '3.50000', '5.000', 8),
(238, 'CF0016', 'Panceta de cerdo ', 105, 'venta por kilos', '1.000', '2.45000', '3.500', 16),
(239, 'CF0017', 'Matambre de cerdo ', 105, 'venta por kilos', '2.000', '2.45000', '3.500', 16),
(240, 'CF0018', 'Tira de Asado de cerdo ', 105, 'venta por kilos', '8.000', '2.45000', '3.500', 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `iva`
--

CREATE TABLE `iva` (
  `ID_IVA` int(11) NOT NULL,
  `VALORIVA` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `iva`
--

INSERT INTO `iva` (`ID_IVA`, `VALORIVA`) VALUES
(1, '1.12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `CODIGOPAG` int(11) NOT NULL,
  `TIPOPAGO` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pagos`
--

INSERT INTO `pagos` (`CODIGOPAG`, `TIPOPAGO`) VALUES
(1, 'EFECTIVO'),
(2, 'DEBITO'),
(3, 'TRANSFERENCIA'),
(4, 'CREDITO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `COD_PERSONA` int(11) NOT NULL,
  `IDENTIFICACION` varchar(30) NOT NULL,
  `TIPOPERSONA` varchar(35) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `APELLIDO` varchar(30) DEFAULT NULL,
  `TELEFONO` varchar(15) DEFAULT NULL,
  `MAIL` varchar(100) DEFAULT NULL,
  `DIRECCION` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`COD_PERSONA`, `IDENTIFICACION`, `TIPOPERSONA`, `NOMBRE`, `APELLIDO`, `TELEFONO`, `MAIL`, `DIRECCION`) VALUES
(1, '99999999999', 'NATURAL', 'Consumidor Final', 'Consumidor Final', NULL, 'noname@noname.com', NULL),
(3, '1786542678', 'NATURAL', 'LUIS', 'TORRES PALMAS', '0965776456', 'luis@gmail.com', 'Santo Domingo'),
(4, '1720513405', 'NATURAL', 'CRISTIAN', 'RODRIGUEZ', NULL, 'cristianjose_@hotmail.com', NULL),
(5, '1722350830', 'NATURAL', 'IVAN', 'MIRANDA', NULL, 'mirandaivan178@qmail.com', NULL),
(6, '2300534266', 'NATURAL', 'ALEXANDRA', 'NORMANDY', NULL, 'normandymedina@gmail.com', NULL),
(7, '1708129455001', 'NATURAL', 'MILY', 'MUÑOZ', NULL, 'mily@gmail.com', NULL),
(8, '950408229001', 'NATURAL', 'INDIRA', 'VALERO', 'NULL', 'indiiragomez@hotmail.com', 'NULL'),
(9, '1718285636001', 'NATURAL', 'DARIO', 'JARAMILLO ', NULL, 'dario007jara@hotmail.com', NULL),
(10, '1718541658', 'NATURAL', 'BETO', 'SALTOS', '0999234225', 'beto@gmail.com', 'Santo Domingo'),
(11, '1102401344', 'NATURAL', 'SILVIA', 'ARROBO', NULL, 'silviaarrobo@gmail.com', NULL),
(12, '1305926758001', 'NATURAL', 'ABEL', 'CARRASCO', NULL, 'carrascoabel@hotmall.com', NULL),
(13, '1719788877001', 'NATURAL', 'AIDA', 'PORTERO', NULL, 'pintuimport@gmail.com', NULL),
(14, 'PROVVILLA001', 'JURIDICA', 'Distribuidora \"Villegas\"', '', '0983556447', 'distribuidoravillegas23gg5@gmail.com', 'Santo Domingo'),
(15, '1720867058001', 'NATURAL', 'CESAR', 'VILLALBA', NULL, 'damive_36@hotmail.com', NULL),
(16, '1718285636001', 'NATURAL', 'DARIO', 'JARAMILLO ', NULL, 'dario007jara@hotmail.com', NULL),
(17, '1305926758001', 'NATURAL', 'ABEL', 'CARRASCO', NULL, 'carrascoabel@hotmail.com', NULL),
(18, '1708846942', 'NATURAL', 'WILSON', 'CHANALATA', NULL, 'wilsoncunalata@qmai.com', NULL),
(19, '1719175950001', 'NATURAL', 'HENRY', 'IMBA', NULL, 'hennryimba@gmail.com', NULL),
(20, '1704392255', 'NATURAL', 'PEPE', 'SILVA', NULL, 'pegosilver14@hotmail.com', NULL),
(21, '1715013825', 'NATURAL', 'DANIELA', 'DELGAGI', NULL, 'danieladi@hotmail.com', NULL),
(22, '801570946', 'NATURAL', 'VIVIANA', 'BALCAZAR', NULL, 'vivia.nabalcazar@hotmail.com', NULL),
(23, '1716328156', 'NATURAL', 'WALTER', 'CASTELO', NULL, 'castelo_walter@yahoo.es', NULL),
(24, '1707819072001', 'NATURAL', 'JOSE', 'ORTIZ', NULL, 'jostingelen2008@gmail.com', NULL),
(25, '1723804025', 'NATURAL', 'JOHANA', 'ROMO', NULL, 'maberojas_1990@outlook.com', NULL),
(26, '2350230690001', 'NATURAL', 'JIMMY', 'ZAMORA', NULL, 'jimmy.zamora.lm@gmail.com', NULL),
(27, '1716553134001', 'NATURAL', 'MIGUEL', 'HERRERA', NULL, 'vagrodistribuidora@hotmail.com', NULL),
(28, '1717282634001', 'NATURAL', 'VIVIANA', 'RODRIGUEZ', NULL, 'shshs@gmail.com', NULL),
(29, '502253446001', 'NATURAL', 'MILTON', 'BUSTILLOS', NULL, 'miltonb@gmail.com', NULL),
(30, '1725128183', 'NATURAL', 'ADRIAN', 'VELEX', NULL, 'velezjoao1725@gmail.com', NULL),
(31, '1718763806', 'NATURAL', 'DIANA', 'VEGA', NULL, 'vegavdiana@hotmail.com', NULL),
(32, '1720654878001', 'NATURAL', 'ANDREA', 'CEVALLOS', NULL, 'adreitacb_10@hotmail.com', NULL),
(33, '603824', 'NATURAL', 'MARJORIE', 'CUNALATA', NULL, 'lizcunalata14@qmail.com', NULL),
(34, '170724251', 'NATURAL', 'JHONI', 'SANTIN', NULL, 'jsantintorres68@gmail.com', NULL),
(35, '1709555518001', 'NATURAL', 'JOHAN', 'VELASTEGUI', NULL, 'jelastegui@gnoboa.com', NULL),
(36, '1711483923', 'NATURAL', 'ROMI', 'RIERA', NULL, 'romiriera@hotmail.com', NULL),
(37, '1718885310', 'NATURAL', 'MANOLO', 'MEDINA', NULL, 'paty_20_88@hotmail.com', NULL),
(38, '800209975', 'NATURAL', 'JORGE', 'VIÑA', NULL, 'jorgevm54@hotmail.com', NULL),
(39, '1710277557', 'NATURAL', 'AGUSTIN', 'COBOS', NULL, 'bettymarles@hotmail.com', NULL),
(40, '502456502', 'NATURAL', 'DEFAZ', 'CRISTIAN', NULL, 'cdefaz88@hotmail.com', NULL),
(41, '1709329260', 'NATURAL', 'MAURICIO', 'JATIVA', NULL, 'ginsaskya1@yahoo.com', NULL),
(42, '1715805105001', 'NATURAL', 'WIMAN', 'CABEZA', NULL, 'andref-11_30@hotmail.com', NULL),
(43, '1717336935', 'NATURAL', 'EDUARDO', 'PAZAN', NULL, 'wilerpazant@gmail.com', NULL),
(44, '1792886570001', 'NATURAL', 'JAEM', 'EXPORTING', NULL, 'exporting.jaem@gmail.com', NULL),
(45, '1759781162', 'NATURAL', 'LUIS', 'MARCANO', NULL, 'luisjosemarcanog@hotmail.com', NULL),
(47, 'PROVFRAI01', 'JURIDICA', 'Fraile', NULL, NULL, 'fraile@hotmail.com', NULL),
(48, 'PROVITALI02', 'JURIDICA', 'Italiana', NULL, NULL, 'italiana_embutidos@hotmail.com', NULL),
(49, 'PROVPRON03', 'JURIDICA', 'Pronaca', NULL, NULL, 'pronaca@hotmail.com', NULL),
(50, 'PROVILE04', 'JURIDICA', 'Ile', NULL, NULL, 'ile.condimentos@hotmail.com', NULL),
(51, 'PROVCONDI05', 'JURIDICA', 'Condimesa', NULL, NULL, 'condimesa@hotmail.com', NULL),
(52, 'PROVSABOR06', 'JURIDICA', 'El Sabor', NULL, NULL, 'elsabor.especias@hotmail.com', NULL),
(53, 'PROVPOLI07', 'JURIDICA', 'Politos', NULL, NULL, 'politos.proveedor@outlook.com', NULL),
(54, 'PROVDVEGA08', 'JURIDICA', 'De la vega', NULL, NULL, 'delavega_steak@hotmail.com', NULL),
(55, 'PROVTIERRAR09', 'JURIDICA', 'Tierra roja', NULL, NULL, 'tierraroja@hotmail.com', NULL),
(56, 'PROVENTER10', 'JURIDICA', 'Enterpise', NULL, NULL, 'enterpise@gmail.com', NULL),
(57, 'PROVEKO11', 'JURIDICA', 'Eko El Arriero', NULL, NULL, 'eko.arriero@hotmail.com', NULL),
(58, 'PROVREYL12', 'JURIDICA', 'Rey Leche', NULL, NULL, 'reyleche@gmail.com', NULL),
(59, 'PROVLENU13', 'JURIDICA', 'Lenutrit', NULL, NULL, 'lenutrit@hotmail.com', NULL),
(60, 'PROVPROD14', 'JURIDICA', 'Produlac', NULL, NULL, 'productosprodulac@gmail.com', NULL),
(61, 'PROVAVU15', 'JURIDICA', 'Avicola Oña', NULL, NULL, 'avicola.ona@gmail.com', NULL),
(62, 'PROVGRAN16', 'JURIDICA', 'Granja Roveg', NULL, NULL, 'granjaroveg@gmail.com', NULL),
(63, 'PROVCOBER17', 'JURIDICA', 'Cobertosa', NULL, NULL, 'cobertosa@gmail.com', NULL),
(64, 'PROVGLO18', 'JURIDICA', 'Gloria Matilde', NULL, NULL, 'gloria.matilde@hotmail.com', NULL),
(65, 'PROVBIELA00', 'JURIDICA', 'BIELA', NULL, NULL, 'biela@hotmail.com', NULL),
(66, 'PROVPILSE01', 'JURIDICA', 'PILSENER', NULL, NULL, 'pilsener@hotmail.com', NULL),
(67, 'PROVCAMPU01', 'JURIDICA', 'CAMPUESA', NULL, NULL, 'campuesa@licorec.com', NULL),
(68, '1718531678', 'NATURAL', 'ANA', 'ZAMBRANO', '0984554678', 'ana@hotmail.com', 'SANTO DOMINGO'),
(69, '1703360675', 'NATURAL', 'MARIO', 'LOPEZ', NULL, 'mariolop@gmail.com', NULL),
(70, '1715443261', 'NATURAL', 'MÓNICA', 'COLOMA', NULL, 'niaseye79@hotmail.com', NULL),
(71, '1717617235001', 'NATURAL', 'RUBEN', 'BORJA', NULL, 'jr_777@hotmail.com', NULL),
(72, '1718652458', 'NATURAL', 'ANITA', 'GUERRERO', '0985445676', 'anaguef123@hotmail.com', NULL),
(73, '098273649', 'NATURAL', 'JAVIER', 'PILLAJO', NULL, 'javi_stp@gmail.com', NULL),
(74, '1718531658', 'NATURAL', 'ANA', 'GUTIERREZ', '0984554234', 'ana_maria_ggz@hotmail.com', 'Santo Domingo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `ID_PROVEEDOR` int(11) NOT NULL,
  `CODIGOPROV` varchar(15) NOT NULL,
  `COD_PERSONA` int(11) NOT NULL,
  `ESTADO` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`ID_PROVEEDOR`, `CODIGOPROV`, `COD_PERSONA`, `ESTADO`) VALUES
(1, 'PROVFRA01', 47, 1),
(2, 'PROVVILLA001', 14, 1),
(3, 'PROVPRON03', 49, 1),
(4, 'PROVILE04', 50, 1),
(5, 'PROVCONDI05', 51, 1),
(6, 'PROVSABOR06', 52, 1),
(7, 'PROVPOLI07', 53, 1),
(8, 'PROVDVEGA08', 54, 1),
(9, 'PROVTIERRAR09', 55, 1),
(10, 'PROVENTER10', 56, 1),
(11, 'PROVEKO11', 57, 1),
(12, 'PROVREYL12', 58, 1),
(13, 'PROVLENU13', 59, 1),
(14, 'PROVPROD14', 60, 1),
(15, 'PROVAVU15', 61, 1),
(16, 'PROVGRAN16', 62, 1),
(17, 'PROVCOBER17', 63, 1),
(18, 'PROVGLO18', 64, 1),
(19, 'PROVBIELA00', 65, 1),
(20, 'PROVPILSE01', 66, 1),
(21, 'PROVCAMPU01', 67, 1),
(22, 'PROVITALI02', 48, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `CODIGOEMPL` int(11) NOT NULL,
  `TIPOUSUARIO` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NOMBREUSU` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CLAVE` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`CODIGOEMPL`, `TIPOUSUARIO`, `NOMBREUSU`, `CLAVE`) VALUES
(9, 'Administrador', 'Ana', 0xc91d0f919f23f1d56157b94ba87db805);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `CODIGOVENTA` int(11) NOT NULL,
  `COD_PERSONA` int(11) NOT NULL,
  `FECHA` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `SUBTOTAL` decimal(8,0) NOT NULL,
  `IVA` decimal(10,2) NOT NULL,
  `TOTAL` decimal(8,0) NOT NULL,
  `CODIGOPAG` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`CODIGOVENTA`, `COD_PERSONA`, `FECHA`, `SUBTOTAL`, `IVA`, `TOTAL`, `CODIGOPAG`) VALUES
(1, 3, '06/08/2022', '80', '14.40', '94', 1),
(2, 3, '06/08/2022', '20', '3.60', '24', 1),
(3, 3, '06/08/2022', '100', '18.00', '118', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventasdetalle`
--

CREATE TABLE `ventasdetalle` (
  `CODIGOVEDE` int(11) NOT NULL,
  `CODIGOVENTA` int(11) NOT NULL,
  `ID_INVENTARIO` int(11) NOT NULL,
  `CANTIDAD` decimal(8,2) NOT NULL,
  `VALOR_UNITARIO` decimal(8,4) NOT NULL,
  `TOTAL` decimal(8,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ventasdetalle`
--

INSERT INTO `ventasdetalle` (`CODIGOVEDE`, `CODIGOVENTA`, `ID_INVENTARIO`, `CANTIDAD`, `VALOR_UNITARIO`, `TOTAL`) VALUES
(2, 1, 1, '4.00', '20.0000', '80.0000'),
(3, 2, 1, '1.00', '20.0000', '20.0000'),
(4, 3, 1, '1.00', '20.0000', '20.0000'),
(5, 3, 2, '2.00', '40.0000', '80.0000');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`CODIGOCAT`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD KEY `COD_PERSONA` (`COD_PERSONA`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`CODIGOCOMPRAS`),
  ADD KEY `CODIGOEMPL` (`CODIGOEMPL`);

--
-- Indices de la tabla `comprasdetalle`
--
ALTER TABLE `comprasdetalle`
  ADD PRIMARY KEY (`CODIGOCODE`),
  ADD KEY `FK_Reference_10` (`CODIGOCOMPRAS`),
  ADD KEY `FK_Reference_11` (`ID_INVENTARIO`),
  ADD KEY `CODIGOINV` (`ID_INVENTARIO`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`CODIGOEMPL`),
  ADD KEY `COD_PERSONA` (`COD_PERSONA`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`ID_INVENTARIO`),
  ADD KEY `Categoria` (`CODIGOCAT`),
  ADD KEY `ID_PROVEEDOR` (`ID_PROVEEDOR`);

--
-- Indices de la tabla `iva`
--
ALTER TABLE `iva`
  ADD PRIMARY KEY (`ID_IVA`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`CODIGOPAG`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`COD_PERSONA`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`ID_PROVEEDOR`),
  ADD KEY `PROV_PERSO` (`COD_PERSONA`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD KEY `FK_Association_5` (`CODIGOEMPL`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`CODIGOVENTA`),
  ADD KEY `FK_Association_10` (`COD_PERSONA`),
  ADD KEY `CODIGOPAG` (`CODIGOPAG`);

--
-- Indices de la tabla `ventasdetalle`
--
ALTER TABLE `ventasdetalle`
  ADD PRIMARY KEY (`CODIGOVEDE`),
  ADD KEY `FK_Association_4` (`CODIGOVENTA`),
  ADD KEY `FK_Reference_12` (`ID_INVENTARIO`),
  ADD KEY `CODIGOINV` (`ID_INVENTARIO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `CODIGOCAT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `CODIGOCOMPRAS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `comprasdetalle`
--
ALTER TABLE `comprasdetalle`
  MODIFY `CODIGOCODE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `CODIGOEMPL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `iva`
--
ALTER TABLE `iva`
  MODIFY `ID_IVA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pagos`
--
ALTER TABLE `pagos`
  MODIFY `CODIGOPAG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `COD_PERSONA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `ID_PROVEEDOR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `ventasdetalle`
--
ALTER TABLE `ventasdetalle`
  MODIFY `CODIGOVEDE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`COD_PERSONA`) REFERENCES `personas` (`COD_PERSONA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`CODIGOEMPL`) REFERENCES `empleados` (`CODIGOEMPL`);

--
-- Filtros para la tabla `comprasdetalle`
--
ALTER TABLE `comprasdetalle`
  ADD CONSTRAINT `FK_Reference_10` FOREIGN KEY (`CODIGOCOMPRAS`) REFERENCES `compras` (`CODIGOCOMPRAS`),
  ADD CONSTRAINT `FK_Reference_11` FOREIGN KEY (`ID_INVENTARIO`) REFERENCES `inventario` (`ID_INVENTARIO`);

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `PERSONAS-EMPLEADOS` FOREIGN KEY (`COD_PERSONA`) REFERENCES `personas` (`COD_PERSONA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `Categoria` FOREIGN KEY (`CODIGOCAT`) REFERENCES `categorias` (`CODIGOCAT`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `PROVEEDORES` FOREIGN KEY (`ID_PROVEEDOR`) REFERENCES `proveedores` (`ID_PROVEEDOR`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD CONSTRAINT `PROV_PERSO` FOREIGN KEY (`COD_PERSONA`) REFERENCES `personas` (`COD_PERSONA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `EMPLEADOS-USUARIOS` FOREIGN KEY (`CODIGOEMPL`) REFERENCES `empleados` (`CODIGOEMPL`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`COD_PERSONA`) REFERENCES `personas` (`COD_PERSONA`),
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`CODIGOPAG`) REFERENCES `pagos` (`CODIGOPAG`);

--
-- Filtros para la tabla `ventasdetalle`
--
ALTER TABLE `ventasdetalle`
  ADD CONSTRAINT `FK_Association_4` FOREIGN KEY (`CODIGOVENTA`) REFERENCES `venta` (`CODIGOVENTA`),
  ADD CONSTRAINT `FK_Reference_12` FOREIGN KEY (`ID_INVENTARIO`) REFERENCES `inventario` (`ID_INVENTARIO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
