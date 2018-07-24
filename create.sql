CREATE DATABASE equiplist;
\c equiplist;

CREATE TABLE IF NOT EXISTS instruments (
 id SERIAL PRIMARY KEY,
 manufacturer VARCHAR,
 model VARCHAR,
 country VARCHAR,
 serialNumber VARCHAR,
 description VARCHAR,
 year int,
 weight Decimal,
 imageUrl VARCHAR,
 current BOOL,
 wishlist BOOL,
 paid Decimal,
 sold Decimal
);

CREATE TABLE IF NOT EXISTS guitars (
 id SERIAL,
 type VARCHAR,
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
 id SERIAL,
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
 tubes VARCHAR,
 reverb VARCHAR,
 tremolo VARCHAR,
 externalSpeaker VARCHAR,
 handle VARCHAR,
 knobs VARCHAR,
 jewelLight VARCHAR,
 controlPanel VARCHAR,
 logo VARCHAR,
 tiltLegs VARCHAR,
 feet VARCHAR,
 controls VARCHAR,
 cover VARCHAR,
 FOREIGN KEY (id) REFERENCES instruments (id)
);

CREATE TABLE IF NOT EXISTS pedals (
 id SERIAL,
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
 id SERIAL PRIMARY KEY,
 createdAt BIGINT,
 content VARCHAR,
 instrumentId int
);

CREATE TABLE IF NOT EXISTS additionalImages (
 id SERIAL PRIMARY KEY,
 url VARCHAR,
 instrumentId int
);

CREATE DATABASE equiplist_test WITH TEMPLATE equiplist;