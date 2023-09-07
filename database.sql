CREATE TABLE public.positions (
    id integer NOT NULL,
    name text NOT NULL
);


CREATE SEQUENCE public.positions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.positions_id_seq OWNED BY public.positions.id;



CREATE TABLE public.products (
    id integer NOT NULL,
    name text NOT NULL,
    quantity integer,
    registration_date date,
    user_id integer
);


CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


CREATE TABLE public.users (
    id integer NOT NULL,
    name text NOT NULL,
    age integer NOT NULL,
    position_id integer,
    registration_date date
);


CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


ALTER TABLE ONLY public.positions ALTER COLUMN id SET DEFAULT nextval('public.positions_id_seq'::regclass);


ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);



INSERT INTO positions(id, name)
VALUES (1, 'administrador');

INSERT INTO positions(id, name)
VALUES (2, 'soporte');

INSERT INTO positions(id, name)
VALUES (3, 'asesor de ventas');


INSERT INTO users(id, name, age, position_id, registration_date)
VALUES (1, 'Richard Bravo', 26, 1, '2022-02-28');

INSERT INTO users(id, name, age, position_id, registration_date)
VALUES (2, 'Antonia Lopez', 20, 2, '2023-01-05');

INSERT INTO users(id, name, age, position_id, registration_date)
VALUES (3, 'Diana Padilla', 24, 3, '2020-11-14');

INSERT INTO users(id, name, age, position_id, registration_date)
VALUES (4, 'Rodrigo Lara', 50, 3, '2000-02-14');



INSERT INTO products(id, name, quantity, registration_date, user_id)
VALUES (1, 'Llantas', 26, '2023-01-22', 1);

INSERT INTO products(id, name, quantity, registration_date, user_id)
VALUES (2, 'Espejos', 6, '2022-05-02', 2);

INSERT INTO products(id, name, quantity, registration_date, user_id)
VALUES (3, 'Rin', 8, '2021-12-01', 3);

INSERT INTO products(id, name, quantity, registration_date, user_id)
VALUES (4, 'Motor', 1, '2020-06-15', 4);



SELECT pg_catalog.setval('public.positions_id_seq', 1, false);


SELECT pg_catalog.setval('public.products_id_seq', 1, true);


SELECT pg_catalog.setval('public.users_id_seq', 1, true);


ALTER TABLE ONLY public.positions
    ADD CONSTRAINT positions_name_key UNIQUE (name);



ALTER TABLE ONLY public.positions
    ADD CONSTRAINT positions_pkey PRIMARY KEY (id);



ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_name_key UNIQUE (name);


ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);



ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_position_id_fkey FOREIGN KEY (position_id) REFERENCES public.positions(id) NOT VALID;