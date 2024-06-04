-- CATEGORÍAS Y TIPOS ---------------------------------------------------------------------------------------------------------------------------------------------------

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

-- LIBROS ---------------------------------------------------------------------------------------------------------------------------------------------------------------

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

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (6, 'El Pozo, Libro I de Arik', 'https://m.media-amazon.com/images/I/71rxw7gLOmL._AC_UF1000,1000_QL80_.jpg', 'Portada El Pozo, Libro I de Arik', 'El Libro de Arik', 19.99, 0, 'Pamela Pons Saez', 'Max Estrella Ediciones', 'Después de veinte muertes, Eva se enfrenta a su última vida; su última oportunidad para morir bien. Está ansiosa por dejar atrás 458 años de absurda y atormentada existencia. Pero si vuelve a morir sola, una vez más, se verá condenada a sufrir.', '2021-11-01 14:30:00', 459, 'TapaBlanda', 'Juvenil', 3);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 6);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (3, 6);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (4, 6);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 6);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (7, 'Mortadelo y Filemón: El sulfato atómico', 'https://www.normacomics.com/media/catalog/product/cache/564c053b4c63190579f642461183ef0b/m/o/mortadelo-y-filemon-el-sulfato-atomico-magos-del-humor.jpg', 'Portada Mortadelo y Filemón: El sulfato atómico', 'Mortadelo y Filemón', 14.90, 5, 'Francisco Ibáñez', 'Bruguera', 'En 1969, debido al éxito creciente de la serie Mortadelo y Filemón, Ibáñez decidió escribir la primera aventura larga de sus famosos agentes. Con más de 50 años desde su publicación, El sulfato atómico es un icono y una de las obras maestras del cómic.', '2022-01-27 12:00:00', 48, 'TapaBlanda', 'Juvenil', 2);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (2, 7);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (6, 7);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (8, 'Spiderman: La última cacería de Kraven', 'https://m.media-amazon.com/images/I/71U7xm0EKXL._AC_UF894,1000_QL80_.jpg', 'Portada Spiderman: La última cacería de Kraven', 'Spiderman', 15.00, 3, 'J. M. DeMatteis, Mike Zeck', 'Marvel Comics', 'Kraven El Cazador ha acechado y acabado con la vida de todos los animales conocidos por el hombre. Pero hay uno que se le resiste: el superhéroe conocido como Spiderman ¿Acabará con la araña y se convertirá en ella? Empieza la Última Cacería de Kraven.', '2021-07-22 21:15:00', 160, 'TapaBlanda', 'Juvenil', 2);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 8);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (2, 8);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (7, 8);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (9, 'Edda Mayor', 'https://www.alianzaeditorial.es/imagenes/libros/grande/9788491043430-edda-mayor.jpg', 'Portada Edda Mayor', 'Eddas Islandesas', 16.10, 10, 'Luis Lerate', 'Alianza Editorial', 'Junto a la "Edda Menor" de Snorri hijo de Sturla, la "Edda Mayor" es la principal fuente de información sobre la mitología y las viejas tradiciones épicas del mundo germánico precristiano.', '2020-04-28 12:00:00', 464, 'TapaBlanda', 'Juvenil', 3);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 9);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (11, 9);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (12, 9);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (10, 'Edda Menor', 'https://www.alianzaeditorial.es/imagenes/libros/grande/9788491043423-edda-menor.jpg', 'Portada Edda Menor', 'Eddas Islandesas', 14.15, 5, 'Luis Lerate', 'Alianza Editorial', 'Concebida originalmente como una preceptiva para los escaldas escandinavos, la "Edda menor" fue escrita por Snorri hijo de Sturla (1179-1241) en 1220, durante el periodo de esplendor de las letras islandesas antiguas.', '2020-04-28 15:00:00', 248, 'TapaBlanda', 'Juvenil', 3);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 10);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (11, 10);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (12, 10);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (11, 'La Historia de Groenlandia: Un Viaje a Través de los Siglos', 'https://m.media-amazon.com/images/I/71RQHOEWDML._AC_UF1000,1000_QL80_.jpg', 'Portada La Historia de Groenlandia: Un Viaje a Través de los Siglos', 'Un Viaje a Través de los Siglos', 6.99, 0, 'Hugo Wilser-Lopez', 'Independently', '¡Embárcate en un viaje fascinante a través de la historia, la naturaleza y la cultura de Groenlandia en este libro único y cautivador! Te sumergirá en el fascinante pasado y el asombroso presente de esta hermosa isla del Ártico.', '2023-07-05 23:30:00', 72, 'TapaBlanda', 'Juvenil', 3);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (11, 11);

ALTER SEQUENCE libro_seq RESTART WITH 61;