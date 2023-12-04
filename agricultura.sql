-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-11-2023 a las 16:30:50
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `agricultura`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE `admin` (
  `cedula` varchar(20) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `correo` varchar(20) DEFAULT NULL,
  `contrasenia` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `admin`
--

INSERT INTO `admin` (`cedula`, `nombre`, `correo`, `contrasenia`) VALUES
('1224', 'camilo', 'sasa@sasa', '1234'),
('7878', 'carlos', 'mejia@jsas', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agricultores`
--

CREATE TABLE `agricultores` (
  `cedula` varchar(20) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `estado` enum('ACTIVO','INACTIVO') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `agricultores`
--

INSERT INTO `agricultores` (`cedula`, `nombre`, `apellido`, `email`, `pass`, `telefono`, `estado`) VALUES
('098', 'kilo', 'y medio medio', 'dasda@sdasa', '****', '12', 'ACTIVO'),
('10832', 'Juan ', 'David', 'ksja@sas', '123', '3111', 'ACTIVO'),
('123456', 'Alberth', 'Aricapa', 'alberth@gmail.com', '123', '3232', 'ACTIVO'),
('23232', 'Jose', 'Angarita', 'angarita@gmail.com', '123', '3232', 'ACTIVO'),
('3443', 'ramiro', 'peche', 'kila@wasa', '23', '121', 'INACTIVO'),
('5656', 'sebastian', 'lopez', 'jkwq@sa', '123', '3232', 'INACTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agricultor_cultivo`
--

CREATE TABLE `agricultor_cultivo` (
  `id_cultivo` int(20) NOT NULL,
  `id_agricultor` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `agricultor_cultivo`
--

INSERT INTO `agricultor_cultivo` (`id_cultivo`, `id_agricultor`) VALUES
(100, '123456 '),
(104, '10832 '),
(105, '3443 '),
(106, '123456 '),
(107, '10832 '),
(107, '123456'),
(109, '123456 '),
(110, '10832 ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cultivos`
--

CREATE TABLE `cultivos` (
  `id_cultivo` int(20) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `tipo` enum('VERDURAS','FRUTAS','GRANOS') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cultivos`
--

INSERT INTO `cultivos` (`id_cultivo`, `nombre`, `descripcion`, `tipo`) VALUES
(100, 'papa', 'asasas', 'VERDURAS'),
(101, 'yuca', 'pa sancocho', 'VERDURAS'),
(102, 'fresas', 'muy buena ', 'FRUTAS'),
(103, 'PERAS', 'MUY DULCE', 'FRUTAS'),
(104, 'arroz', 'arrozito', 'GRANOS'),
(105, 'cacao', 'para chocolate', 'GRANOS'),
(106, 'frijol', 'para comer', 'GRANOS'),
(107, 'guayaba', 'paa comer', 'FRUTAS'),
(108, 'Cebolla', 'me hace llorar', 'VERDURAS'),
(109, 'papaya', 'papaya verde', 'FRUTAS'),
(110, 'Zanahoria', 'My buena', 'VERDURAS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas`
--

CREATE TABLE `tareas` (
  `id_tarea` int(20) NOT NULL,
  `id_cultivo` int(20) DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `estado` enum('Pendiente','Finalizado') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tareas`
--

INSERT INTO `tareas` (`id_tarea`, `id_cultivo`, `titulo`, `descripcion`, `estado`) VALUES
(2, 101, 'Pelar papa', 'todos los lidas', 'Pendiente'),
(3, 100, 'pelar yuca', 'en la de papa', 'Pendiente'),
(4, 103, 'COSECHAR', 'PARA EL DIA 20 DE JU', 'Pendiente'),
(5, 104, 'recoger el', 'todos los dias', 'Finalizado'),
(6, 100, 'lavar papa', 'hoy', 'Finalizado'),
(7, 104, 'lavar el a', 'lavarlo cada 5 dias', 'Finalizado'),
(8, 104, 'lavar el a', 'lavarlo cada 5 dias', 'Finalizado'),
(9, 105, 'lavar el c', 'todos los dias', 'Finalizado'),
(10, 106, 'sembrar', 'sembrar frijol', 'Finalizado'),
(11, 107, 'recoger la', 'siempre', 'Finalizado'),
(12, 108, 'Lavar cebo', 'Con agua', 'Finalizado'),
(13, 109, 'lavar papa', 'una vez', 'Finalizado'),
(14, 110, 'Recoger za', 'recoger', 'Finalizado'),
(15, 110, 'Lavar zanahoria', 'Con mucha agua y mucho jabon rey', 'Pendiente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea_agricultor`
--

CREATE TABLE `tarea_agricultor` (
  `id_agricultor` varchar(20) NOT NULL,
  `id_tarea` int(20) NOT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tarea_agricultor`
--

INSERT INTO `tarea_agricultor` (`id_agricultor`, `id_tarea`, `fecha_inicio`, `fecha_fin`) VALUES
('098 ', 3, '2023-11-10', '0000-00-00'),
('098 ', 6, '2023-11-10', '0000-00-00'),
('10832 ', 5, '2023-11-21', '2023-11-22'),
('10832 ', 7, '2023-11-21', '2023-11-22'),
('10832 ', 8, '2023-11-21', '2023-11-22'),
('10832 ', 11, '2023-11-14', '2023-11-23'),
('10832 ', 14, '2023-11-24', '2023-11-25'),
('10832 ', 15, '2023-11-24', '2023-11-25'),
('123456 ', 3, '2023-11-21', '2023-11-25'),
('123456 ', 10, '2023-11-14', '2023-11-17'),
('123456', 11, '2023-11-08', '2023-11-29'),
('123456 ', 13, '2023-11-24', '2023-11-29'),
('23232 ', 3, '2023-11-10', '2023-11-30'),
('23232 ', 4, '2023-11-10', '2023-11-20'),
('23232 ', 5, '2023-11-10', '2023-11-24'),
('23232 ', 6, '2023-11-10', '2023-11-30'),
('23232 ', 8, '2023-11-10', '2023-11-24'),
('3443 ', 5, '2023-11-10', '2023-11-30'),
('3443 ', 9, '2023-11-14', '2023-11-25');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `agricultores`
--
ALTER TABLE `agricultores`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `agricultor_cultivo`
--
ALTER TABLE `agricultor_cultivo`
  ADD PRIMARY KEY (`id_cultivo`,`id_agricultor`),
  ADD KEY `id_agricultor` (`id_agricultor`);

--
-- Indices de la tabla `cultivos`
--
ALTER TABLE `cultivos`
  ADD PRIMARY KEY (`id_cultivo`);

--
-- Indices de la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD PRIMARY KEY (`id_tarea`),
  ADD KEY `id_cultivo` (`id_cultivo`);

--
-- Indices de la tabla `tarea_agricultor`
--
ALTER TABLE `tarea_agricultor`
  ADD PRIMARY KEY (`id_agricultor`,`id_tarea`),
  ADD KEY `id_tarea` (`id_tarea`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cultivos`
--
ALTER TABLE `cultivos`
  MODIFY `id_cultivo` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111;

--
-- AUTO_INCREMENT de la tabla `tareas`
--
ALTER TABLE `tareas`
  MODIFY `id_tarea` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `agricultor_cultivo`
--
ALTER TABLE `agricultor_cultivo`
  ADD CONSTRAINT `agricultor_cultivo_ibfk_1` FOREIGN KEY (`id_cultivo`) REFERENCES `cultivos` (`id_cultivo`),
  ADD CONSTRAINT `agricultor_cultivo_ibfk_2` FOREIGN KEY (`id_agricultor`) REFERENCES `agricultores` (`cedula`);

--
-- Filtros para la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD CONSTRAINT `tareas_ibfk_1` FOREIGN KEY (`id_cultivo`) REFERENCES `cultivos` (`id_cultivo`);

--
-- Filtros para la tabla `tarea_agricultor`
--
ALTER TABLE `tarea_agricultor`
  ADD CONSTRAINT `tarea_agricultor_ibfk_1` FOREIGN KEY (`id_agricultor`) REFERENCES `agricultores` (`cedula`),
  ADD CONSTRAINT `tarea_agricultor_ibfk_2` FOREIGN KEY (`id_tarea`) REFERENCES `tareas` (`id_tarea`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
