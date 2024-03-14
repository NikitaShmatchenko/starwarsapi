INSERT INTO planet (id, diameter, climate, name, terrain) VALUES
(1, 12500, 'Temperate', 'Tatooine', 'Desert'),
(2, 12120, 'Frozen', 'Hoth', 'Ice plains'),
(3, 10465, 'Temperate', 'Naboo', 'Grassy hills, swamps, forests, mountains');

INSERT INTO specie (id, average_height, language, name) VALUES
(1, 170, 'Galactic Basic', 'Human'),
(2, 100, 'Huttese', 'Hutt'),
(3, 200, 'Shyriiwook', 'Wookiee'),
(4, 96, 'Droidspeak', 'Droid');

INSERT INTO character (id, height, mass, planet_id, specie_id, name) VALUES
(1, 172, 77, 1, 1, 'Luke Skywalker'),
(2, 182, 78, 3, 1, 'Anakin Skywalker'),
(3, 150, 49, 3, 1, 'Padmé Amidala'),
(4, 228, 112, 1, 3, 'Chewbacca'),
(5, 175, 80, 1, 1, 'Han Solo'),
(6, 202, 0, 1, 2, 'Jabba the Hutt'),
(7, 188, 84, 3, 1, 'Obi-Wan Kenobi'),
(8, 202, 96, 2, 1, 'Darth Vader'),
(9, 96, 45, 3, 4, 'R2-D2'),
(10, 175, 75, 1, 1, 'Qui-Gon Jinn'),
(11, 196, 110, 1, 1, 'Darth Maul'),
(12, 178, 120, 3, 1, 'Jar Jar Binks');