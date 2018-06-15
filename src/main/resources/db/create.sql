SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS instrumentTypes (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
);

CREATE TABLE IF NOT EXISTS guitarTypes (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
);

CREATE TABLE IF NOT EXISTS instruments (
 id int PRIMARY KEY auto_increment,
 manufacturer VARCHAR,
 model VARCHAR,
 country VARCHAR,
 serialNumber VARCHAR,
 imageUrl VARCHAR,
 instrumentTypeId int,
 current VARCHAR,
 wishlist VARCHAR
);

CREATE TABLE IF NOT EXISTS guitars (
 id int,
 weight Decimal,
 bodyWood VARCHAR,
 finish VARCHAR,
 color VARCHAR,
 binding VARCHAR,
 neckWood VARCHAR,
 neckType VARCHAR,
 neckProfile VARCHAR,
 fretboardWood VARCHAR,
 fretboardRadius Decimal,
 frets int,
 fretMaterial VARCHAR,
 inlays VARCHAR,
 nutMaterial VARCHAR,
 nutWidth Decimal,
 scaleLength Decimal,
 neckPickup VARCHAR,
 middlePickup VARCHAR,
 bridgePickup VARCHAR,
 volumePots VARCHAR,
 tonePots VARCHAR,
 capacitor VARCHAR,
 tuners VARCHAR,
 tunerButtons VARCHAR,
 bridge VARCHAR,
 tailpiece VARCHAR,
 guitarSwitch VARCHAR,
 knobs VARCHAR,
 pickguard VARCHAR,
 controls VARCHAR,
 guitarCase VARCHAR,
 FOREIGN KEY (id) REFERENCES instruments (id)
);

CREATE TABLE IF NOT EXISTS notes (
 id int PRIMARY KEY auto_increment,
 createdAt BIGINT,
 content VARCHAR,
 instrumentId int
);