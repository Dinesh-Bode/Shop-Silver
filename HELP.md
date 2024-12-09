-- SEQUENCE: public.order_detail_order_detail_id_seq

-- DROP SEQUENCE IF EXISTS public.order_detail_order_detail_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.order_detail_order_detail_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.order_detail_order_detail_id_seq
OWNED BY public.order_detail.order_detail_id;

ALTER SEQUENCE public.order_detail_order_detail_id_seq
OWNER TO postgres;

============================================================================
-- SEQUENCE: public.orders_order_id_seq

-- DROP SEQUENCE IF EXISTS public.orders_order_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.orders_order_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.orders_order_id_seq
OWNED BY public."order".order_id;

ALTER SEQUENCE public.orders_order_id_seq
OWNER TO postgres;

============================================================================

-- SEQUENCE: public.productdetail_product_detail_id_seq

-- DROP SEQUENCE IF EXISTS public.productdetail_product_detail_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.productdetail_product_detail_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 2147483647
CACHE 1;

ALTER SEQUENCE public.productdetail_product_detail_id_seq
OWNED BY public.productdetail.product_detail_id;

ALTER SEQUENCE public.productdetail_product_detail_id_seq
OWNER TO postgres;

============================================================================
-- SEQUENCE: public.review_review_id_seq

-- DROP SEQUENCE IF EXISTS public.review_review_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.review_review_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.review_review_id_seq
OWNED BY public.review.review_id;

ALTER SEQUENCE public.review_review_id_seq
OWNER TO postgres;

============================================================================

-- SEQUENCE: public.user_user_id_seq

-- DROP SEQUENCE IF EXISTS public.user_user_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.user_user_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.user_user_id_seq
OWNED BY public."user".user_id;

ALTER SEQUENCE public.user_user_id_seq
OWNER TO postgres;

============================================================================
============================================================================

-- Table: public.order

-- DROP TABLE IF EXISTS public."order";

CREATE TABLE IF NOT EXISTS public."order"
(
order_id bigint NOT NULL DEFAULT nextval('orders_order_id_seq'::regclass),
user_id bigint NOT NULL,
payment_mode character varying(50) COLLATE pg_catalog."default" NOT NULL,
status character varying(20) COLLATE pg_catalog."default" NOT NULL,
total_amount numeric(10,2) NOT NULL,
discount numeric(10,2),
created_on timestamp without time zone NOT NULL,
CONSTRAINT orders_pkey PRIMARY KEY (order_id),
CONSTRAINT fk_user_order FOREIGN KEY (user_id)
REFERENCES public."user" (user_id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."order"
OWNER to postgres;

============================================================================

-- Table: public.order_detail

-- DROP TABLE IF EXISTS public.order_detail;

CREATE TABLE IF NOT EXISTS public.order_detail
(
order_detail_id bigint NOT NULL DEFAULT nextval('order_detail_order_detail_id_seq'::regclass),
order_id bigint NOT NULL,
product_id bigint NOT NULL,
price numeric(10,2) NOT NULL,
quantity integer NOT NULL,
created_on timestamp without time zone NOT NULL,
CONSTRAINT order_detail_pkey PRIMARY KEY (order_detail_id),
CONSTRAINT fk_order_detail FOREIGN KEY (order_id)
REFERENCES public."order" (order_id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION,
CONSTRAINT fk_product_order_detail FOREIGN KEY (product_id)
REFERENCES public.product (product_id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.order_detail
OWNER to postgres;

============================================================================

-- Table: public.product

-- DROP TABLE IF EXISTS public.product;

CREATE TABLE IF NOT EXISTS public.product
(
product_id integer NOT NULL,
product_name character varying(200) COLLATE pg_catalog."default" NOT NULL,
price double precision NOT NULL,
available_quantity integer,
image_url character varying(1000) COLLATE pg_catalog."default",
category character varying(50) COLLATE pg_catalog."default",
description character varying(10000) COLLATE pg_catalog."default",
CONSTRAINT "ProductId" PRIMARY KEY (product_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product
OWNER to postgres;

============================================================================

-- Table: public.productdetail

-- DROP TABLE IF EXISTS public.productdetail;

CREATE TABLE IF NOT EXISTS public.productdetail
(
product_detail_id integer NOT NULL DEFAULT nextval('productdetail_product_detail_id_seq'::regclass),
product_id integer NOT NULL,
size character varying(50) COLLATE pg_catalog."default",
price numeric(10,2),
available_qty character varying(50) COLLATE pg_catalog."default",
weight numeric(10,2),
length numeric(10,2),
CONSTRAINT productdetail_pkey PRIMARY KEY (product_detail_id),
CONSTRAINT fk_product_detail FOREIGN KEY (product_id)
REFERENCES public.product (product_id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.productdetail
OWNER to postgres;


============================================================================

-- Table: public.review

-- DROP TABLE IF EXISTS public.review;

CREATE TABLE IF NOT EXISTS public.review
(
review_id bigint NOT NULL DEFAULT nextval('review_review_id_seq'::regclass),
user_id bigint NOT NULL,
product_id bigint NOT NULL,
heading character varying(100) COLLATE pg_catalog."default" NOT NULL,
rating integer NOT NULL,
description character varying(1000) COLLATE pg_catalog."default",
created_on timestamp without time zone NOT NULL,
CONSTRAINT review_pkey PRIMARY KEY (review_id),
CONSTRAINT fk_product_review FOREIGN KEY (product_id)
REFERENCES public.product (product_id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION,
CONSTRAINT fk_user_review FOREIGN KEY (user_id)
REFERENCES public."user" (user_id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.review
OWNER to postgres;

============================================================================

-- Table: public.user

-- DROP TABLE IF EXISTS public."user";

CREATE TABLE IF NOT EXISTS public."user"
(
user_id bigint NOT NULL DEFAULT nextval('user_user_id_seq'::regclass),
username character varying(100) COLLATE pg_catalog."default" NOT NULL,
email character varying(100) COLLATE pg_catalog."default" NOT NULL,
login_type character varying(100) COLLATE pg_catalog."default" NOT NULL,
password character varying(255) COLLATE pg_catalog."default" NOT NULL,
CONSTRAINT user_pkey PRIMARY KEY (user_id),
CONSTRAINT user_email_key UNIQUE (email)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."user"
OWNER to postgres;

============================================================================
