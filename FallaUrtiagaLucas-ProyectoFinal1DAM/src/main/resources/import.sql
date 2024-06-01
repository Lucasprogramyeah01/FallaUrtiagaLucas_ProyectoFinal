-- CATEGORÍAS Y TIPOS

INSERT INTO Categoria(id_categoria, nombre) VALUES (1, 'Aventuras');
INSERT INTO Categoria(id_categoria, nombre) VALUES (2, 'Ciencia ficción');
INSERT INTO Categoria(id_categoria, nombre) VALUES (3, 'Romance');
INSERT INTO Categoria(id_categoria, nombre) VALUES (4, 'Misterio');
INSERT INTO Categoria(id_categoria, nombre) VALUES (5, 'Terror');
INSERT INTO Categoria(id_categoria, nombre) VALUES (6, 'Comedia');
INSERT INTO Categoria(id_categoria, nombre) VALUES (7, 'Acción');
INSERT INTO Categoria(id_categoria, nombre) VALUES (8, 'Policíaco');
INSERT INTO Categoria(id_categoria, nombre) VALUES (9, 'Fantasía');
INSERT INTO Categoria(id_categoria, nombre) VALUES (10, 'Gore');
INSERT INTO Categoria(id_categoria, nombre) VALUES (11, 'Historia');
INSERT INTO Categoria(id_categoria, nombre) VALUES (12, 'Lírica');

INSERT INTO Tipo(id_tipo, nombre) VALUES (1, 'Manga');
INSERT INTO Tipo(id_tipo, nombre) VALUES (2, 'Cómic');
INSERT INTO Tipo(id_tipo, nombre) VALUES (3, 'Libro Europeo');
INSERT INTO Tipo(id_tipo, nombre) VALUES (4, 'Manhwa');

ALTER SEQUENCE categoria_seq RESTART WITH 62;
ALTER SEQUENCE tipo_seq RESTART WITH 54;

-- LIBROS

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (1, 'Kagurabachi vol.1', 'https://i.ebayimg.com/images/g/d4UAAOSwpVVl1Ybj/s-l1600.jpg', 'Portada Kagurabachi 1', 'Kagurabachi', 11.03, 30, 'Takeru Hokazono', 'Shueisha', 'Chihiro, un joven con aspiraciones de convertirse en un forjador, entrena todos los días bajo la tutela de su padre. En un principio, todo parecía ir bien, hasta que un día la tragedia irrumpe en sus vidas, tiñéndolas de sangre.', '2024-02-02 18:30:00', 216, 'Sobrecubierta', 'Juvenil', 1);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 1);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (7, 1);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (10, 1);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (2, 'Kagurabachi vol.2', 'https://i.ebayimg.com/images/g/a40AAOSwDmpmK72q/s-l1600.jpg', 'Portada Kagurabachi 2', 'Kagurabachi', 11.92, 50, 'Takeru Hokazono', 'Shueisha', 'Chihiro, un joven con aspiraciones de convertirse en un forjador, entrena todos los días bajo la tutela de su padre. En un principio, todo parecía ir bien, hasta que un día la tragedia irrumpe en sus vidas, tiñéndolas de sangre.', '2024-05-02 17:00:00', 208, 'Sobrecubierta', 'Juvenil', 1);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 2);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (7, 2);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (10, 2);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (3, 'Bleach vol.1', 'https://m.media-amazon.com/images/I/81vbN16NtXL._AC_UF1000,1000_QL80_.jpg', 'Portada Bleach 1', 'Bleach', 5.70, 5, 'Tite Kubo', 'Panini Comics', 'Ichigo puede ver espíritus y tiene contacto con el más allá, al que sacará provecho tras conocer a un shinigami que le proporciona la espada a juego con sus habilidades.', '2021-08-07 14:00:00', 200, 'TapaBlanda', 'Juvenil', 1);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 3);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (6, 3);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (7, 3);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 3);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (4, 'Bleach vol.7', 'https://m.media-amazon.com/images/I/91M15uEMLXL._AC_UF1000,1000_QL80_.jpg', 'Portada Bleach 7', 'Bleach', 6.00, 10, 'Tite Kubo', 'Panini Comics', 'Ichigo puede ver espíritus y tiene contacto con el más allá, al que sacará provecho tras conocer a un shinigami que le proporciona la espada a juego con sus habilidades.', '2021-12-21 11:45:00', 200, 'TapaBlanda', 'Juvenil', 1);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 4);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (6, 4);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (7, 4);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 4);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (5, 'Bleach vol.18', 'https://m.media-amazon.com/images/I/81qW-oUNSML._AC_UF1000,1000_QL80_.jpg', 'Portada Bleach 18', 'Bleach', 5.90, 10, 'Tite Kubo', 'Panini Comics', '¡La Doble Hoja ha sido liberada! En el patíbulo, Rukia parece dispuesta a asumir su destino con resignación, pero en el momento en que el verdugo se dispone a acabar con su vida, ocurre algo inesperado...', '2023-03-27 15:15:00', 200, 'TapaBlanda', 'Juvenil', 1);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 5);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (6, 5);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (7, 5);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 5);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (6, 'El Pozo, Libro I de Arik', 'https://m.media-amazon.com/images/I/71rxw7gLOmL._AC_UF1000,1000_QL80_.jpg', 'Portada El Pozo, Libro I de Arik', 'El Libro de Arik', 19.99, 25, 'Pamela Pons Saez', 'Max Estrella Ediciones', 'Después de veinte muertes, Eva se enfrenta a su última vida; su última oportunidad para morir bien. Está ansiosa por dejar atrás 458 años de absurda y atormentada existencia. Pero si vuelve a morir sola, una vez más, se verá condenada a sufrir.', '2021-11-01 14:30:00', 459, 'TapaBlanda', 'Juvenil', 3);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 6);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (3, 6);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (4, 6);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 6);