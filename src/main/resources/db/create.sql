SET MODE PostgreSQL;

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
 year int,
 weight Decimal,
 imageUrl VARCHAR,
 current BOOL,
 wishlist BOOL,
 paid Decimal,
 sold Decimal
);

CREATE TABLE IF NOT EXISTS guitars (
 id int,
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

CREATE TABLE IF NOT EXISTS amps (
 id int,
 instrument VARCHAR,
 type VARCHAR,
 power int,
 cabinetWood VARCHAR,
 finish VARCHAR,
 grillCloth VARCHAR,
 width int,
 depth int,
 height int,
 electronics VARCHAR,
 speakers VARCHAR,
 powerTubes VARCHAR,
 preAmpTubes VARCHAR,
 rectifierTube VARCHAR,
 reverb BOOL,
 tremolo BOOL,
 externalSpeaker VARCHAR,
 handle VARCHAR,
 knobs VARCHAR,
 jewelLight VARCHAR,
 controlPanel VARCHAR,
 logo VARCHAR,
 tiltLegs BOOL,
 feet VARCHAR,
 controls VARCHAR,
 cover VARCHAR,
 FOREIGN KEY (id) REFERENCES instruments (id)
);

CREATE TABLE IF NOT EXISTS pedals (
 id int,
 type VARCHAR,
 power VARCHAR,
 width Decimal,
 depth Decimal,
 height Decimal,
 electronics VARCHAR,
 trueBypass BOOL,
 inputImpedance int,
 outputImpedance int,
 currentDraw VARCHAR,
 controls VARCHAR,
 features VARCHAR,
 FOREIGN KEY (id) REFERENCES instruments (id)
);

CREATE TABLE IF NOT EXISTS notes (
 id int PRIMARY KEY auto_increment,
 createdAt BIGINT,
 content VARCHAR,
 instrumentId int
);