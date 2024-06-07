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

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (10, 'Edda Menor', 'https://www.alianzaeditorial.es/imagenes/libros/grande/9788491043423-edda-menor.jpg', 'Portada Edda Menor', 'Eddas Islandesas', 14.15, 5, 'Luis Lerate', 'Alianza Editorial', 'Concebida originalmente como una preceptiva para los escaldos escandinavos, la "Edda menor" fue escrita por Snorri hijo de Sturla (1179-1241) en 1220, durante el periodo de esplendor de las letras islandesas antiguas.', '2020-04-28 15:00:00', 248, 'TapaBlanda', 'Juvenil', 3);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 10);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (11, 10);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (12, 10);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (11, 'La Historia de Groenlandia: Un Viaje a Través de los Siglos', 'https://m.media-amazon.com/images/I/71RQHOEWDML._AC_UF1000,1000_QL80_.jpg', 'Portada La Historia de Groenlandia: Un Viaje a Través de los Siglos', 'Un Viaje a Través de los Siglos', 6.99, 0, 'Hugo Wilser-Lopez', 'Independently', '¡Embárcate en un viaje fascinante a través de la historia, la naturaleza y la cultura de Groenlandia en este libro único y cautivador! Te sumergirá en el fascinante pasado y el asombroso presente de esta hermosa isla del Ártico.', '2023-07-05 23:30:00', 72, 'TapaBlanda', 'Juvenil', 3);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (11, 11);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (12, 'Maximum Berserk vol.12', 'https://m.media-amazon.com/images/I/71T9G+LzRnS._AC_UF894,1000_QL80_.jpg', 'Portada Maximum Berserk vol.12', 'Maximum Berserk', 16.10, 12, 'Kentaro Miura', 'Panini Comics', 'Una de las más aclamadas series mangas de todos los tiempos. Un viaje épico y salvaje a un reino de fantasía. Guts es un guerrero vestido de negro que porta una gigantesca espada más larga que su propia estatura y un robusto brazo ortopédico de hierro...', '2019-05-23 21:30:00', 408, 'Sobrecubierta', 'Adulto', 1);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 12);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (7, 12);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 12);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (10, 12);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (13, 'Maximum Berserk vol.14', 'https://m.media-amazon.com/images/I/91QGyNgGv5L._AC_UF894,1000_QL80_.jpg', 'Portada Maximum Berserk vol.14', 'Maximum Berserk', 16.95, 0, 'Kentaro Miura', 'Panini Comics', 'Una de las más aclamadas series mangas de todos los tiempos. Un viaje épico y salvaje a un reino de fantasía. Guts es un guerrero vestido de negro que porta una gigantesca espada más larga que su propia estatura y un robusto brazo ortopédico de hierro...', '2022-09-15 22:00:00', 440, 'Sobrecubierta', 'Adulto', 1);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 13);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (7, 13);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 13);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (10, 13);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (14, 'Maximum Berserk vol.18', 'https://m.media-amazon.com/images/I/61Noc1irzYS._AC_UF894,1000_QL80_.jpg', 'Portada Maximum Berserk vol.18', 'Maximum Berserk', 18.90, 18, 'Kentaro Miura', 'Panini Comics', 'Una de las más aclamadas series mangas de todos los tiempos. Un viaje épico y salvaje a un reino de fantasía. Guts es un guerrero vestido de negro que porta una gigantesca espada más larga que su propia estatura y un robusto brazo ortopédico de hierro...', '2022-09-15 22:30:00', 416, 'Sobrecubierta', 'Adulto', 1);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 14);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (7, 14);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 14);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (10, 14);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (15, 'Maximum Berserk vol.21', 'https://udfshop.com/cdn/shop/products/berserk-color.jpg?v=1681422677', 'Portada Maximum Berserk vol.21', 'Maximum Berserk', 24.99, 50, 'Kentaro Miura', 'Panini Comics', 'Una de las más aclamadas series mangas de todos los tiempos. Un viaje épico y salvaje a un reino de fantasía. Guts es un guerrero vestido de negro que porta una gigantesca espada más larga que su propia estatura y un robusto brazo ortopédico de hierro...', '2024-09-21 00:00:00', 452, 'Sobrecubierta', 'Adulto', 1);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 15);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (7, 15);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 15);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (10, 15);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (16, 'Solo Leveling vol.3', 'https://www.normaeditorial.com/upload/media/albumes/0001/19/a62f366fb2a0a4526d1e9eef2983ddc0042a8e3b.jpeg', 'Portada Solo Leveling vol.3', 'Solo Leveling', 14.20, 0, 'Chu-Gong, Dubu (Redice Studio)', 'NORMA Editorial', 'Sung Jinwoo sigue subiendo de nivel yendo de mazmorra en mazmorra. Sin embargo, en una de las incursiones parece que le acompañarán un grupo de presidiarios con tal de prestar servicios a la comunidad. ¿Qué le deparará a Sung y al resto del equipo?', '2024-06-04 15:45:00', 320, 'TapaBlanda', 'Juvenil', 4);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 16);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (2, 16);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (6, 16);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 16);

INSERT INTO Libro(id_libro, titulo, imagen_portada, texto_alt_portada, serie, precio, stock, autor, editorial, descripcion, fecha_publicacion, num_paginas, cubierta, publico, tipo_id_tipo) VALUES (17, 'Solo Leveling vol.9', 'https://m.media-amazon.com/images/I/91-juYmiUrL._AC_UF894,1000_QL80_.jpg', 'Portada Solo Leveling vol.9', 'Solo Leveling', 19.53, 9, 'Chu-Gong, Dubu (Redice Studio)', 'NORMA Editorial', 'Jinwoo responde a la llamada del sistema y regresa a la doble mazmorra. Mientras tanto, el gobierno japonés se encuentra luchando con puertas algo desagradables y busca ayuda externa. ¿Podrá Jinwoo detener a las bestias mágicas antes de que arrasen Japón?', '2024-09-09 09:09:09', 168, 'TapaBlanda', 'Juvenil', 4);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (1, 17);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (2, 17);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (6, 17);
INSERT INTO Tiene(categoria_id, libro_id) VALUES (9, 17);

ALTER SEQUENCE libro_seq RESTART WITH 67;