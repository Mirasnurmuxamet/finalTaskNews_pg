INSERT INTO t_permissions(role)
VALUES
    ('ROLE_USER'),
    ('ROLE_AUTHOR'),
    ('ROLE_ADMIN');

INSERT INTO t_users(email, full_name, password, bio, birthdate, delete_application)
    VALUES
    ('ali@gmail.com',
     'Alizhan Turarov',
     '$2a$12$9MEEHBrZe0.ur/wmh992Au9zduD82uJjJHf5hNB/phcT4Cim34/9S',
     'I am Alizhan. Turarov Alizhan',
     '1995-03-03',
     false),
    ('alikhan@gmail.com',
     'Alikhan  Boszhanov',
     '$2a$12$T0puPLSH.0RGUPmSnsy8juwpAEXMizeL9rbwv3kQg.uY.CZjZN7h2',
     'My name is Alizhan. I am admin and author.',
     '1998-06-23',
     false),
    ('akhmet@gmail.com',
     'Akhmet Bolatuly',
     '$2a$12$2zBhCKg8BV9cYRsuRr1tH./WekK2BGkJmlxqC0ofCv7YTX1II7An6',
     'My name is Akhmet. I am Bolat''s son.',
     '1997-07-27',
     false);


INSERT INTO t_users_permissions(user_id, permissions_id)
VALUES
    (1,1),
    (2,1),
    (2,2),
    (2,3),
    (3,1),
    (3,2);

INSERT INTO t_news_category(name)
VALUES
    ('Sport'),
    ('Political'),
    ('Business'),
    ('Media'),
    ('Science'),
    ('Finance'),
    ('Technology'),
    ('Art');

INSERT INTO t_posts(title, content, post_time, user_id, news_category_id)
    VALUES
    ('Kazakh Prime Minister Proposes Measures to Develop Aktobe Region',
     'Kazakh Prime Minister Alikhan Smailov instructed to speed up the reconstruction of the
Aktobe-Karabutak-Ulgaisyn highway, a part of the Western Europe – Western China International Road Corridor, during
his working visit to the Aktobe Region on Aug. 10, reported the Prime Minister’s press service.Reconstruction of
the Aktobe-Karabutak-Ulgaisyn highway
According to Smailov, this will significantly improve the quality of the roadway and increase its capacity.
An area of 262 kilometers will be widened from the current two lanes to four, and 202 culverts, 23 cattle roads, 18
bridges, and 12 junctions will be built and reconstructed.
The highway is also part of the transit corridor from southern Kazakhstan to Russia. This section undergoes heavy
raffic intensity of about 16,000 vehicles per day, including 4,000 trucks, and its condition today causes a lot of
complaints.
The Prime Minister assigned the Ministry of Industry and Infrastructure Development to improve the quality of the
roadway, drawing attention to local roads as well.
Construction of a new line of the Bukhara-Ural main gas pipeline
Aktobe and its adjacent territories are supplied with gas through three strings of the Bukhara-Ural and
Zhanazhol-Aktobe trunk pipelines.
As stated by Smailov, the construction of a new string of gas pipeline branches to Aktobe from the
Bukhara-Ural main gas pipeline has begun to resolve the growing volume of gas consumption and the load on the existing
infrastructure.The large-scale project valued at 43.4 billion tenge ($97.1 million) will be launched in 2024.
The 165-kilometers-long main gas pipeline with a capacity of 526,000 cubic meters per hour aims to meet
the city’s growing needs and implement 17 major investment projects worth over three trillion tenge ($6.7 billion).
Improving the environmental well-being of the Aktobe Region
Smailov visited a unique sludge processing plant of the Kazchrome mining company’s Donskoy Mining and Processing Plant,
which opened in the Chromtau District.
The new enterprise will process 1.7 million tons of constantly generated waste from existing production
facilities and previously accumulated sludge per year.
According to Yeraly Tugzhanov, the Akim (governor) of the Aktobe Region, the plant is one of the main projects of a
large-scale waste sludge processing program to increase production efficiency and improve the region’s
environmental well-being.
Smailov stressed the importance of the project, noting that the enterprise will contribute to
improving the local environment.
“The most important thing is that after processing, the tailings should be properly reclaimed following all
environmental standards so that there is minimal impact on the environment and public health,” he said.',
     '2023-08-12 20:41:48', 3,3),
    ('Kazakhstan’s Economy Grows 5% in First Half of 2023',
     'The growth of Kazakhstan’s economy reached 5 % in the first half of this year, with a 4. 8% increase in
the real sector and 4.9 % – in the service sector, Ranking.kz reported on Aug. 9.

All major industries witnessed positive dynamics, with the highest indicators recorded by the construction sector
with a 12.3% growth, trade – 10.4%, and information and communication – 8.8%.

Despite the global geopolitical upheavals, Kazakhstan’s economy grew by 3.2% in 2022, showing resilience
for several years. The largest share in the country’s GDP falls on wholesale and retail trade, and repair of cars and
motorcycles (16.4%), mining and quarrying (14.5%), manufacturing industry (13.4%), transactions
with real estate (6.5%), and construction (5.3%).

According to the International Monetary Fund (IMF) forecast, Kazakhstan’s economy will grow by 4.3% in 2023 and
by 4.9% in 2024, much higher than the world average increase of 1.8% in 2023 and 2% in 2024.

The quasi-public sector plays a special role in economic development and growth. The largest representative of
this sector is the Samruk Kazyna Sovereign Wealth Fund, which aims to improve the national welfare and
ensure long-term sustainability for future generations.

The holding considerably impacts the economy, as its assets account for 32.4% of the country’s GDP.
The fund strives to gradually reduce state participation in Kazakhstan’s economy by privatizing its subsidiaries.

In 2022, the amount of consolidated assets of Samruk Kazyna reached 33.6 trillion tenge ($75.4 billion),
the highest figure in recent years. The Samruk Kazyna group’s companies successfully overcame
the pandemic’s consequences and restored sustainable growth. The revenue totaled 14.8 trillion tenge ($33.2 billion).

The same year, the fund paid 170 billion tenge ($381.8 million) of dividends to the state budget,
allocating 132 billion tenge ($296.4 million) to support social and infrastructure projects.
The tax paid to the budget reached 1.7 trillion tenge ($3.8 billion).',
     '2023-08-12 20:46:17', 3, 6),
    ('President Tokayev Reaffirms Kazakhstan’s Commitment to OSCE',
     ' President Kassym-Jomart Tokayev underscored Kazakhstan’s commitment to the Organization for Security and
Cooperation in Europe (OSCE) as a reliable member state at an Aug. 11 meeting with Bujar Osmani,
Minister of Foreign Affairs of the Republic of North Macedonia and OSCE Chairman-in-Office in Astana,
reported the Akorda press service.
The President stressed that the OSCE is irreplaceable despite the divisions
that unfortunately exist within the organization, emphasizing the need to maintain its potential.

According to Tokayev, it is vital to ensure that the OSCE continues to serve as a unique platform
for dialogue ahead of the 50th anniversary of the Helsinki Final Act in 2025, an agreement signed
by 35 nations that concluded the Conference on Security and Cooperation in Europe held in Helsinki, Finland.

“Our strong partnership with the OSCE is based on the shared vision of building a secure community, enshrined in the
Astana Declaration of the 2010 OSCE Summit,” he said.

Elaborating on the prospects for strengthening relations between the two countries, the President noted
that North Macedonia is a very important partner of Kazakhstan in Europe, with quite significant
results achieved in expanding cooperation.

Tokayev also informed that Kazakhstan decided to open its embassy in the North Macedonian capital, Skopje.

Osmani emphasized that the OSCE attaches great importance to the development of relations with
Kazakhstan and Central Asia, pointing out the country’s key role in both regional and interregional cooperation.

He stated that Kazakhstan’s reform agenda resonates not only with the principles and commitments of
the OSCE, but also with the priorities of North Macedonia, whose slogan “Everything for the people”
reflects a human-centered approach.

According to Osmani, the OSCE summit in Astana in 2010 demonstrated the active role of
Kazakhstan in supporting the main activities of the organization. ',
     '2023-08-12 20:47:58', 2, 2),
    ('Kazakh Chess Players Win Silver and Bronze Medals at World Schools Team Championship',
     ' A Kazakh team from Astana took bronze medals in a category under 12. The chess players
from Almaty claimed silver in a category under 18 at the World Schools Team Championship held from Aug. 4 to 8 in
Aktau, reported Kazakhstan Chess Federation.

The Velammal MHS Mogappair team from India won gold in the under 12 category, whereas the
İstanbul ENKA High School team from Türkiye ranked first in the under 18 category.

The new flagship event organized by the International Chess Federation (FIDE) and
Kazakhstan Chess Federation brought together more than 400 schoolchildren from 53 countries.

“This is a clear example of the incredible popularity of the chess movement throughout the world and
Kazakhstan’s influence on the global chess agenda,” said Timur Turlov, President of the Kazakhstan Chess Federation ',
     '2023-08-12 20:49:26', 3, 1),
    ('Kazakh Folk Ensemble Performs Abai’s Songs at Austria’s Oldest Festival',
     'The Alatau folklore ensemble representing the Kenen Azerbayev Philharmonic of
the Zhambyl Region performed works of Abai on the eve of the famous Kazakh poet’s birthday,
celebrated on Aug. 10, at the largest traditional festival Villacher Kirchtag in Austria,
Kazakh Ministry of Foreign Affairs reported on Aug. 7.

Sophisticated audience members from Austria, Italy, and Slovenia welcomed the music
by Kazakh composers beautifully performed on national instruments such as dombra, kobyz, zhetygen, and sazsyrnay.

“The performance of the Alatau artists was one of the best and most professional I have ever seen.
I enjoyed watching the show from beginning to end.
I would like to thank all the musicians for a magical evening and wish them continued professional success,”
said Christine Muttonen, former president of the Organization of Security and
Cooperation in Europe Parliamentary Assembly.

This year’s festival, which ran from July 30 to Aug. 6, attracted nearly 300,000 guests

.Kazakh ensemble participated in a series of concerts in Villach’s main square and
a parade of traditional costumes with over 70 groups from the Alps-Adriatic region.
Folklore, musical art, and vibrant costumes created a memorable colorful display. ',
     '2023-08-12 20:52:18', 2, 4),
    ('Internet Use Triples in Kazakhstan in Four Years',
     'Internet use has tripled in Kazakhstan from 356 petabytes in 2018 to 1,000 petabytes in 2022,
 reported the Ministry of Digital Development, Innovations and Aerospace Industry on Aug. 3.

 During the recent meeting with the executives of mobile operators, Kazakh Minister of Digital Development,
 Innovation, and Aerospace Industry Bagdat Mussin instructed to improve the quality of
 the internet to address numerous complaints from users about the low speed and quality of the network.

 Mobile operators will hold a briefing on tariffs and internet quality on Aug.
 11 in the Central Communications Service. Representatives of mobile operators and the ministry
 will attend the briefing ',
     '2023-08-12 21:12:40', 3, 7),
    ('Kazakh Scientist Develops Projects Based on Quantum Realm',
     'Kazakh doctor and scientist, Mukhit Kulmaganbetov, who joined the Discrimination of
Quantum States team through the Human Eye research project at the Centre for Eye and
Vision Research (CEVR) in Hong Kong, seeks to investigate the human eye’s capability to differentiate
between various quantum states of light. In an interview with The Astana Times,
he discussed the project’s objectives, the ongoing work process, and the team’s plans for the future.

According to Kulmaganbetov, CEVR is a newly established institution with ambitious goals,
bringing together four distinct groups: leading researchers from the University of Waterloo and
The Hong Kong Polytechnic University, postdoctoral fellows from esteemed universities worldwide,
local specialists with diverse educational backgrounds, and senior and junior fellows.

“For me, having completed thirteen years of continuous medical education, joining CEVR marked a crucial milestone in
my professional career,” he said.

Kulmaganbetov’s family has always been the primary source of his motivation, as both of his parents and even the
majority of his extended family devoted their lives to medicine.

“Growing up, I was surrounded by the medical environment. While other kids my age were playing,
I was fascinated by medical equipment and literature. I remember playing with surgical scalpels and
microscopes and reading medical books at a young age,” he recalled.
“This early exposure greatly influenced my decision to pursue a career in medicine,
driven by my own dream to save lives. ',
     '2023-08-12 21:14:53', 3, 5),
    ('Exhibition in Astana Explores Boundless Creativity of Young Kazakh Artists',
     'The Kazakh capital hosted the Anau Mynau (This and That) exhibition showcasing art,
graphics and sculpture works of young Kazakh artists on June 29 at the Kulanshi Art Center.
The exhibition is unique, as three distinct directions of artists are showcased in one space.
According to Leyla Mahat, curator of the Kulanshi Art Gallery,
their mission is to present a youth art exhibition every two years, where young artists create something new and
contribute to making the world a better place through their works.

“We titled the exhibition Anau Mynau. With this untranslatable Kazakh phrase, we wanted to encompass
the thoughts and ideas of contemporary creators. The title was chosen during a meeting with
the young artists who presented their works. Through the exhibition,
the unique and talented artists aimed to convey their message visually, as we believe
it is difficult to explain in words why three different art forms were combined in one space,” said Mahat.
The Qaz Sculpture team, consisting of Rinat Abenov, Yerbol Sarsenbaiuly and Begzat Orynbekov,
presented a collection of sculpture art. The artwork included busts, monuments, small plastic reliefs,
and innovative interpretations in technique and materials.
Batyrs (heroes) from fairytales and legends were depicted in a new light and vibrant colors,
while oriental beauties added to the intrigue.
In an interview with The Astana Times, Abenov expressed wide excitement for the team’s debut.
According to Leyla Mahat, curator of the Kulanshi Art Gallery,
their mission is to present a youth art exhibition every two years,
where young artists create something new and contribute to making the world a better place through their works.',
     '2023-08-12 21:32:22', 3, 8);

INSERT INTO t_comments(comment,comment_time,user_id,post_id)
VALUES
    ('GOOD', '2023-08-12 21:32:22', 1, 2);

