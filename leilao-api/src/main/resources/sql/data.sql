-- ====== UNIDADE ======
INSERT INTO tb_unidade
    (id, nome)
VALUES
	(nextval('seq_unidade'), 'unidade 1'),
	(nextval('seq_unidade'), 'unidade 2'),
	(nextval('seq_unidade'), 'unidade 3'),
	(nextval('seq_unidade'), 'unidade 4'),
	(nextval('seq_unidade'), 'unidade 5'),
	(nextval('seq_unidade'), 'unidade 6'),
	(nextval('seq_unidade'), 'unidade 7'),
	(nextval('seq_unidade'), 'unidade 8'),
	(nextval('seq_unidade'), 'unidade 9'),
	(nextval('seq_unidade'), 'unidade 10');

-- ====== EMPRESA ======
INSERT INTO tb_empresa
    (id, bairro, cep, cnpj, complemento, created_at, email, logradouro, municipio, numero, razao_social, senha, site, telefone, updated_at, usuario)
VALUES
    (nextval('seq_empresa'), 'Haas', '8900316818', '1811646530', 'Clyde Gallagher', '2022-10-06 08:03:35', 'rgott0@opensource.org', 'Hill', 'Krasnyy Klyuch', '333', 'Kessler Inc', 'zIi6XI06vkZ', 'http://cam.ac.uk', '777-309-0500', '2022-06-16 04:37:25', 'sschwaiger0'),
    (nextval('seq_empresa'), 'Holy Cross', '1000266583', '2158592486', 'Porter', '2021-11-17 01:12:54', 'aromera1@patch.com', 'Circle', 'Jinka', '41', 'McCullough-Rice', 'l3aE5GueRDuw', 'http://java.com', '677-584-8005', '2021-11-08 13:58:19', 'hhallatt1'),
    (nextval('seq_empresa'), 'Moulton', '0387986502', '3577128461', 'Fisk', '2022-07-15 22:04:01', 'mclench2@nhs.uk', 'Circle', 'Obo', '58', 'Haley Inc', '5hdQCAzYFSnj', 'http://zdnet.com', '692-525-4314', '2022-10-10 11:20:43', 'ngaudon2'),
    (nextval('seq_empresa'), 'Cascade', '9021420112', '2402999330', 'Kedzie', '2021-11-22 17:41:00', 'otomaschke3@buzzfeed.com', 'Circle', 'Sri Jayewardenepura Kotte', '63', 'Schaden and Sons', '7EtSzf0', 'http://businessinsider.com', '960-299-5171', '2021-11-13 12:20:43', 'jseely3'),
    (nextval('seq_empresa'), 'Maple', '3316315624', '8904262038', 'Loftsgordon', '2022-09-14 06:55:43', 'mmunt4@gov.uk', 'Terrace', 'Salcedo', '7763', 'Schuppe and Sons', 'PLmU4P04Pof', 'http://cdbaby.com', '314-309-2540', '2021-12-16 22:33:08', 'ayukhin4'),
    (nextval('seq_empresa'), 'East', '0564370029', '8073349795', 'Judy', '2022-03-31 23:37:53', 'ateresi5@dedecms.com', 'Plaza', 'Guofu', '63', 'Green, Mosciski and Morissette', 'LUw9Tw6w', 'https://meetup.com', '563-448-3223', '2022-08-22 05:26:11', 'sconlon5'),
    (nextval('seq_empresa'), 'Bellgrove', '4975507773', '6953811544', 'Magdeline', '2022-05-20 09:31:35', 'pgreatrex6@webnode.com', 'Drive', 'Gilowice', '7', 'Nienow, Toy and Murazik', 'BD4qWY', 'https://simplemachines.org', '422-381-8464', '2022-09-22 22:34:37', 'egerssam6'),
    (nextval('seq_empresa'), 'Crownhardt', '7910977174', '9725806778', 'Bobwhite', '2022-01-17 06:19:37', 'mwookey7@dropbox.com', 'Junction', 'Cajamarca', '82109', 'Carroll-Beatty', '7iOlrTWe', 'http://delicious.com', '221-550-3287', '2022-03-05 23:47:50', 'mshallow7'),
    (nextval('seq_empresa'), 'Bultman', '9543080933', '2156611777', 'Victoria', '2022-09-01 01:17:18', 'otolfrey8@twitpic.com', 'Avenue', 'Santiago de las Vegas', '773', 'Wuckert, Marquardt and Bechtelar', 'kiqUuw5KzyF', 'https://moonfruit.com', '207-220-2173', '2021-11-05 00:18:26', 'bgrinvalds8'),
    (nextval('seq_empresa'), 'Bowman', '9966358854', '0502900482', '4th', '2022-05-05 19:26:11', 'zboarleyson9@vistaprint.com', 'Hill', 'Katoúna', '7277', 'Howe, Anderson and Fay', 'l9EpmA3j1b', 'https://about.me', '274-951-3315', '2022-06-19 21:42:35', 'abiddell9');

-- ====== LEILÃO ====== --
INSERT INTO tb_leilao
    (id, codigo, created_at, descricao, inicio_previsto, updated_at, vendedor)
VALUES
    (nextval('seq_leilao'), 6, '2022-10-12 10:16:54', 'vivamus metus arcu adipiscing molestie', '2022-10-02 05:29:20', '2022-08-31 04:36:01', 2),
    (nextval('seq_leilao'), 82, '2022-01-25 22:41:23', 'vestibulum sagittis sapien cum sociis', '2022-05-22 21:25:45', '2022-01-22 17:03:46', 3),
    (nextval('seq_leilao'), 36, '2022-05-30 08:57:12', 'non pretium quis lectus suspendisse', '2022-07-02 09:03:06', '2022-06-21 09:55:21', 2),
    (nextval('seq_leilao'), 47, '2022-08-13 05:10:18', 'interdum mauris ullamcorper purus', '2022-07-24 02:32:49', '2022-03-25 00:02:33', 5),
    (nextval('seq_leilao'), 1, '2022-02-05 14:01:29', 'ornare imperdiet sapien', '2022-02-04 09:22:59', '2021-12-18 01:23:00', 7),
    (nextval('seq_leilao'), 89, '2022-07-09 21:04:50', 'luctus et ultrices', '2022-07-07 12:22:11', '2022-05-31 08:00:35', 7),
    (nextval('seq_leilao'), 68, '2022-07-11 17:35:18', 'in leo', '2021-11-18 18:42:16', '2022-08-15 11:23:54', 2),
    (nextval('seq_leilao'), 19, '2022-04-05 04:57:18', 'imperdiet nullam orci pede', '2022-09-24 12:34:45', '2022-09-20 18:34:49', 4),
    (nextval('seq_leilao'), 44, '2022-04-14 09:33:58', 'ridiculus mus vivamus', '2022-06-27 07:39:34', '2022-09-14 04:05:17', 9),
    (nextval('seq_leilao'), 89, '2022-01-02 08:35:23', 'lectus vestibulum quam sapien varius', '2021-12-08 15:48:33', '2022-09-12 20:47:04', 9);

-- ====== LOTE ====== --
INSERT INTO tb_lote
    (id, created_at, descricao, numero_lote, quantidade, updated_at, unidade, valor_inicial, leilao)
VALUES
    (nextval('seq_lote'), '2022-10-14 20:45:03', 'aenean auctor gravida sem praesent id', 60, 26.83, '2022-01-29 07:02:25', 'quis tortor id nulla ultrices aliquet maecenas leo', 25.25, 6),
    (nextval('seq_lote'), '2022-08-23 16:43:59', 'ut dolor morbi vel lectus in quam', 60, 57.36, '2022-05-05 11:39:24', 'hac habitasse platea dictumst morbi vestibulum', 7.47, 10),
    (nextval('seq_lote'), '2022-06-17 03:58:35', 'eros elementum pellentesque quisque', 72, 83.34, '2021-11-29 06:55:29', 'id justo sit amet sapien dignissim', 77.88, 4),
    (nextval('seq_lote'), '2022-10-10 11:28:20', 'tincidunt lacus at velit vivamus', 77, 46.94, '2021-12-03 10:25:30', 'duis consequat dui nec nisi volutpat eleifend donec ut dolor', 65.12, 5),
    (nextval('seq_lote'), '2022-06-10 23:16:33', 'erat id mauris vulputate elementum', 6, 10.58, '2022-05-03 21:43:58', 'odio elementum eu interdum eu', 92.55, 8),
    (nextval('seq_lote'), '2021-12-09 12:35:42', 'libero nullam sit amet turpis elementum', 43, 15.34, '2022-01-07 20:19:46', 'venenatis non sodales sed tincidunt eu felis fusce posuere', 71.01, 1),
    (nextval('seq_lote'), '2022-07-26 14:02:23', 'tempor convallis nulla neque libero', 4, 32.24, '2022-09-30 22:29:02', 'est quam pharetra magna ac consequat metus sapien ut', 36.26, 9),
    (nextval('seq_lote'), '2022-08-29 03:31:59', 'ut mauris eget massa tempor', 31, 73.23, '2022-05-19 19:33:42', 'magna vestibulum aliquet ultrices erat tortor sollicitudin', 52.73, 2),
    (nextval('seq_lote'), '2022-09-27 22:40:54', 'sit amet turpis elementum ligula', 89, 27.47, '2022-07-12 12:44:31', 'volutpat erat quisque erat eros', 33.98, 5),
    (nextval('seq_lote'), '2021-11-26 10:03:06', 'at turpis donec posuere metus', 69, 14.85, '2022-08-25 03:19:28', 'morbi odio odio elementum eu interdum eu tincidunt', 75.27, 9);

-- ====== UNIDADE ======
INSERT INTO tb_comprador
    (id, empresa, leilao)
VALUES
	(nextval('seq_comprador'), 1, 3),
	(nextval('seq_comprador'), 6, 3),
	(nextval('seq_comprador'), 4, 2),
	(nextval('seq_comprador'), 1, 8),
	(nextval('seq_comprador'), 2, 3),
	(nextval('seq_comprador'), 3, 5),
	(nextval('seq_comprador'), 4, 7),
	(nextval('seq_comprador'), 1, 9),
	(nextval('seq_comprador'), 8, 1),
	(nextval('seq_comprador'), 5, 9);
