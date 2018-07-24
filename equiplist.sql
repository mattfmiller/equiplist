--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: additionalimages; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE additionalimages (
    id integer NOT NULL,
    url character varying,
    instrumentid integer
);


ALTER TABLE additionalimages OWNER TO "Guest";

--
-- Name: additionalimages_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE additionalimages_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE additionalimages_id_seq OWNER TO "Guest";

--
-- Name: additionalimages_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE additionalimages_id_seq OWNED BY additionalimages.id;


--
-- Name: amps; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE amps (
    id integer NOT NULL,
    instrument character varying,
    type character varying,
    power integer,
    cabinetwood character varying,
    finish character varying,
    grillcloth character varying,
    width integer,
    depth integer,
    height integer,
    electronics character varying,
    speakers character varying,
    tubes character varying,
    reverb character varying,
    tremolo character varying,
    externalspeaker character varying,
    handle character varying,
    knobs character varying,
    jewellight character varying,
    controlpanel character varying,
    logo character varying,
    tiltlegs character varying,
    feet character varying,
    controls character varying,
    cover character varying
);


ALTER TABLE amps OWNER TO "Guest";

--
-- Name: amps_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE amps_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE amps_id_seq OWNER TO "Guest";

--
-- Name: amps_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE amps_id_seq OWNED BY amps.id;


--
-- Name: guitars; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE guitars (
    id integer NOT NULL,
    type character varying,
    bodywood character varying,
    finish character varying,
    color character varying,
    binding character varying,
    neckwood character varying,
    necktype character varying,
    neckprofile character varying,
    fretboardwood character varying,
    fretboardradius numeric,
    frets integer,
    fretmaterial character varying,
    inlays character varying,
    nutmaterial character varying,
    nutwidth numeric,
    scalelength numeric,
    neckpickup character varying,
    middlepickup character varying,
    bridgepickup character varying,
    volumepots character varying,
    tonepots character varying,
    capacitor character varying,
    tuners character varying,
    tunerbuttons character varying,
    bridge character varying,
    tailpiece character varying,
    guitarswitch character varying,
    knobs character varying,
    pickguard character varying,
    controls character varying,
    guitarcase character varying
);


ALTER TABLE guitars OWNER TO "Guest";

--
-- Name: guitars_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE guitars_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE guitars_id_seq OWNER TO "Guest";

--
-- Name: guitars_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE guitars_id_seq OWNED BY guitars.id;


--
-- Name: instruments; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE instruments (
    id integer NOT NULL,
    manufacturer character varying,
    model character varying,
    country character varying,
    serialnumber character varying,
    description character varying,
    year integer,
    weight numeric,
    imageurl character varying,
    current boolean,
    wishlist boolean,
    paid numeric,
    sold numeric
);


ALTER TABLE instruments OWNER TO "Guest";

--
-- Name: instruments_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE instruments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE instruments_id_seq OWNER TO "Guest";

--
-- Name: instruments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE instruments_id_seq OWNED BY instruments.id;


--
-- Name: notes; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE notes (
    id integer NOT NULL,
    createdat bigint,
    content character varying,
    instrumentid integer
);


ALTER TABLE notes OWNER TO "Guest";

--
-- Name: notes_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE notes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE notes_id_seq OWNER TO "Guest";

--
-- Name: notes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE notes_id_seq OWNED BY notes.id;


--
-- Name: pedals; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE pedals (
    id integer NOT NULL,
    type character varying,
    power character varying,
    width numeric,
    depth numeric,
    height numeric,
    electronics character varying,
    truebypass boolean,
    inputimpedance integer,
    outputimpedance integer,
    currentdraw character varying,
    controls character varying,
    features character varying
);


ALTER TABLE pedals OWNER TO "Guest";

--
-- Name: pedals_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE pedals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pedals_id_seq OWNER TO "Guest";

--
-- Name: pedals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE pedals_id_seq OWNED BY pedals.id;


--
-- Name: additionalimages id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY additionalimages ALTER COLUMN id SET DEFAULT nextval('additionalimages_id_seq'::regclass);


--
-- Name: amps id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY amps ALTER COLUMN id SET DEFAULT nextval('amps_id_seq'::regclass);


--
-- Name: guitars id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY guitars ALTER COLUMN id SET DEFAULT nextval('guitars_id_seq'::regclass);


--
-- Name: instruments id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY instruments ALTER COLUMN id SET DEFAULT nextval('instruments_id_seq'::regclass);


--
-- Name: notes id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY notes ALTER COLUMN id SET DEFAULT nextval('notes_id_seq'::regclass);


--
-- Name: pedals id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY pedals ALTER COLUMN id SET DEFAULT nextval('pedals_id_seq'::regclass);


--
-- Data for Name: additionalimages; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY additionalimages (id, url, instrumentid) FROM stdin;
\.


--
-- Name: additionalimages_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('additionalimages_id_seq', 1, false);


--
-- Data for Name: amps; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY amps (id, instrument, type, power, cabinetwood, finish, grillcloth, width, depth, height, electronics, speakers, tubes, reverb, tremolo, externalspeaker, handle, knobs, jewellight, controlpanel, logo, tiltlegs, feet, controls, cover) FROM stdin;
\.


--
-- Name: amps_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('amps_id_seq', 1, false);


--
-- Data for Name: guitars; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY guitars (id, type, bodywood, finish, color, binding, neckwood, necktype, neckprofile, fretboardwood, fretboardradius, frets, fretmaterial, inlays, nutmaterial, nutwidth, scalelength, neckpickup, middlepickup, bridgepickup, volumepots, tonepots, capacitor, tuners, tunerbuttons, bridge, tailpiece, guitarswitch, knobs, pickguard, controls, guitarcase) FROM stdin;
\.


--
-- Name: guitars_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('guitars_id_seq', 1, false);


--
-- Data for Name: instruments; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY instruments (id, manufacturer, model, country, serialnumber, description, year, weight, imageurl, current, wishlist, paid, sold) FROM stdin;
\.


--
-- Name: instruments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('instruments_id_seq', 1, true);


--
-- Data for Name: notes; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY notes (id, createdat, content, instrumentid) FROM stdin;
\.


--
-- Name: notes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('notes_id_seq', 1, false);


--
-- Data for Name: pedals; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY pedals (id, type, power, width, depth, height, electronics, truebypass, inputimpedance, outputimpedance, currentdraw, controls, features) FROM stdin;
\.


--
-- Name: pedals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('pedals_id_seq', 1, false);


--
-- Name: additionalimages additionalimages_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY additionalimages
    ADD CONSTRAINT additionalimages_pkey PRIMARY KEY (id);


--
-- Name: instruments instruments_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY instruments
    ADD CONSTRAINT instruments_pkey PRIMARY KEY (id);


--
-- Name: notes notes_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY notes
    ADD CONSTRAINT notes_pkey PRIMARY KEY (id);


--
-- Name: amps amps_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY amps
    ADD CONSTRAINT amps_id_fkey FOREIGN KEY (id) REFERENCES instruments(id);


--
-- Name: guitars guitars_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY guitars
    ADD CONSTRAINT guitars_id_fkey FOREIGN KEY (id) REFERENCES instruments(id);


--
-- Name: pedals pedals_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY pedals
    ADD CONSTRAINT pedals_id_fkey FOREIGN KEY (id) REFERENCES instruments(id);


--
-- PostgreSQL database dump complete
--

