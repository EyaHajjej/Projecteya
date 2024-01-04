-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : ven. 15 déc. 2023 à 15:47
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `JavaAppSwingGL4`
--

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `firstname` varchar(250) NOT NULL,
  `lastname` varchar(250) NOT NULL,
  `login` varchar(250) NOT NULL,
  `pwd` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE vol (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dateDepart DATE NOT NULL,
    heureDepart TIME NOT NULL,
    dateArrivee DATE NOT NULL,
    heureArrivee TIME NOT NULL,
    reservable BOOLEAN NOT NULL,
    aeroport_depart_id INT,
    aeroport_arrivee_id INT,
    FOREIGN KEY (aeroport_depart_id) REFERENCES aeroport(id),
    FOREIGN KEY (aeroport_arrivee_id) REFERENCES aeroport(id)
);

CREATE TABLE escale (
    id INT PRIMARY KEY AUTO_INCREMENT,
    heureArrivee TIME NOT NULL,
    heureDepart TIME NOT NULL,
    vol_id INT,
    FOREIGN KEY (vol_id) REFERENCES vol(id)
);

CREATE TABLE aeroport (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL
);
--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `firstname`, `lastname`, `login`, `pwd`) VALUES
(1, 'test_firstname', 'test_lastname', 'test_login', 'test_pwd'),
(2, 'test_from_app_firstname', 'test_from_app_lastname', 'test_from_app_login', 'test_from_app_pwd'),
(3, 'ben salem', 'mohamed', 'mohamed445', '20235623ok'),
(4, 'ben salem', 'mohamed', 'mohamed445', '20235623ok');


-- Déchargement des données de la table `vol`


INSERT INTO `vol` (`id`, ` dateDepart`, ` heureDepart`, `dateArrivee`, `heureArrivee`, `reservable`, `aeroport_depart_id`, `aeroport_arrivee_id` ) VALUES
(1, 'test_dateDepart', 'test_heureDepart', 'test_dateArrivee', 'test_heureArrivee', 'test_reservable','test_aeroport_depart_id','aeroport_arrivee_id'),
(2, 'test_from_app_dateDepart', 'test_from_app_heureDepart', 'test_from_app_dateArrivee', 'test_from_app_heureArrivee', 'test_from_app_reservable', 'test_from_app_aeroport_depart_id', 'test_from_app_aeroport_arrivee_id'  ),
(3, '30/12/2023', '23:00', '31/12/2023', '00:00', 'Non', '1', '1'),
(4, '30/12/2023', '23:00', '31/12/2023', '00:00', 'Non', '1', '1');


-- Déchargement des données de la table `escale`
INSERT INTO `escale` (`id`, ` heureDepart`, `heureArrivee`) VALUES
(1,  'test_heureDepart', 'test_heureArrivee'),
(2,  'test_from_app_heureDepart', 'test_from_app_heureArrivee' ),
(3,  '23:00', '00:00' ),
(4,'23:00',  '00:00');



-- Déchargement des données de la table `aeroport`
INSERT INTO `aeroport` (`id`, ` nom`) VALUES
(1,  'test_nom'),
(2,  'test_from_app_nom' ),
(3,  'Tunis Carthage' ),
(4, 'Tunis Carthage');

-- Index pour les tables déchargées
--

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

-- Index pour la table `Vol`
ALTER TABLE `vol`
  ADD PRIMARY KEY (`id`);


-- Index pour la table `escale`

ALTER TABLE `escale`
  ADD PRIMARY KEY (`id`);


-- Index pour la table `aeroport`

ALTER TABLE `aeroport`
  ADD PRIMARY KEY (`id`);
--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

-- AUTO_INCREMENT pour la table `Vol`


ALTER TABLE `vol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;


-- AUTO_INCREMENT pour la table `Vol`


ALTER TABLE `escale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;


ALTER TABLE `aeroport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
