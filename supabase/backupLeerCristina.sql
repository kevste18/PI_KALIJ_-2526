--
-- PostgreSQL database dump
--

\restrict xSIRc4OcUnUwoGOQknGVfA4SgPrg2QfcPU57pBWRV4ek4q1r1EX0KeW3D5dHXvh

-- Dumped from database version 16.11
-- Dumped by pg_dump version 16.11

-- Started on 2026-04-27 19:53:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16730)
-- Name: departamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departamento (
    id_dep integer NOT NULL,
    nombre character varying(50),
    presupuesto numeric(7,2),
    ubicacion integer
);


ALTER TABLE public.departamento OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16733)
-- Name: direccion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.direccion (
    id_dir integer NOT NULL,
    calle character varying(50),
    despacho character varying(20),
    cp character varying(5),
    numero integer
);


ALTER TABLE public.direccion OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16736)
-- Name: dispositivos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dispositivos (
    mac character varying(17) NOT NULL,
    ip character varying(15),
    modelo character varying(50),
    sistema_operativo character varying(50),
    id_dispo character varying(20)
);


ALTER TABLE public.dispositivos OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16739)
-- Name: empleado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empleado (
    dni character varying(9) NOT NULL,
    nombre character varying(30),
    apellidos character varying(50),
    fecha_contrato date,
    salario numeric(10,2),
    teletrabajo boolean,
    tlf character varying(15),
    tlf_trabajo character varying(15),
    id_dep integer,
    id_rol integer,
    dispositivo_asignado character varying(17),
    num_dirige integer,
    num_gestiona integer,
    id_empleado character varying(25) NOT NULL,
    CONSTRAINT empleado_tlf_check CHECK (((tlf)::text ~~ '346%'::text)),
    CONSTRAINT empleado_tlf_trabajo_check CHECK (((tlf_trabajo)::text ~~ '346%'::text))
);


ALTER TABLE public.empleado OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16744)
-- Name: incidencias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.incidencias (
    num_incidencia integer NOT NULL,
    estado character varying(20),
    dni_empleado character varying(9),
    dni_responsable character varying(9),
    fecha_alta date,
    fecha_resolucion date,
    dispositivo_afect character varying(17)
);


ALTER TABLE public.incidencias OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16747)
-- Name: rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rol (
    id_rol integer NOT NULL,
    nombre_rol character varying(30)
);


ALTER TABLE public.rol OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16750)
-- Name: ubicacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ubicacion (
    cod integer NOT NULL,
    edificio character varying(50),
    planta character varying(10),
    departamento character varying(50),
    id_dir integer
);


ALTER TABLE public.ubicacion OWNER TO postgres;

--
-- TOC entry 4927 (class 0 OID 16730)
-- Dependencies: 215
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.departamento (id_dep, nombre, presupuesto, ubicacion) FROM stdin;
\.


--
-- TOC entry 4928 (class 0 OID 16733)
-- Dependencies: 216
-- Data for Name: direccion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.direccion (id_dir, calle, despacho, cp, numero) FROM stdin;
\.


--
-- TOC entry 4929 (class 0 OID 16736)
-- Dependencies: 217
-- Data for Name: dispositivos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.dispositivos (mac, ip, modelo, sistema_operativo, id_dispo) FROM stdin;
\.


--
-- TOC entry 4930 (class 0 OID 16739)
-- Dependencies: 218
-- Data for Name: empleado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.empleado (dni, nombre, apellidos, fecha_contrato, salario, teletrabajo, tlf, tlf_trabajo, id_dep, id_rol, dispositivo_asignado, num_dirige, num_gestiona, id_empleado) FROM stdin;
\.


--
-- TOC entry 4931 (class 0 OID 16744)
-- Dependencies: 219
-- Data for Name: incidencias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.incidencias (num_incidencia, estado, dni_empleado, dni_responsable, fecha_alta, fecha_resolucion, dispositivo_afect) FROM stdin;
\.


--
-- TOC entry 4932 (class 0 OID 16747)
-- Dependencies: 220
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rol (id_rol, nombre_rol) FROM stdin;
\.


--
-- TOC entry 4933 (class 0 OID 16750)
-- Dependencies: 221
-- Data for Name: ubicacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ubicacion (cod, edificio, planta, departamento, id_dir) FROM stdin;
\.


--
-- TOC entry 4761 (class 2606 OID 16754)
-- Name: departamento departamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (id_dep);


--
-- TOC entry 4763 (class 2606 OID 16756)
-- Name: direccion direccion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccion
    ADD CONSTRAINT direccion_pkey PRIMARY KEY (id_dir);


--
-- TOC entry 4765 (class 2606 OID 16758)
-- Name: dispositivos dispositivos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dispositivos
    ADD CONSTRAINT dispositivos_pkey PRIMARY KEY (mac);


--
-- TOC entry 4767 (class 2606 OID 16760)
-- Name: empleado empleado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (dni);


--
-- TOC entry 4769 (class 2606 OID 16762)
-- Name: incidencias incidencias_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.incidencias
    ADD CONSTRAINT incidencias_pkey PRIMARY KEY (num_incidencia);


--
-- TOC entry 4771 (class 2606 OID 16764)
-- Name: rol rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id_rol);


--
-- TOC entry 4773 (class 2606 OID 16766)
-- Name: ubicacion ubicacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ubicacion
    ADD CONSTRAINT ubicacion_pkey PRIMARY KEY (cod);


--
-- TOC entry 4774 (class 2606 OID 16767)
-- Name: departamento fk_departamento_ubicacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT fk_departamento_ubicacion FOREIGN KEY (ubicacion) REFERENCES public.ubicacion(cod);


--
-- TOC entry 4775 (class 2606 OID 16772)
-- Name: empleado fk_empleado_departamento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT fk_empleado_departamento FOREIGN KEY (id_dep) REFERENCES public.departamento(id_dep);


--
-- TOC entry 4776 (class 2606 OID 16777)
-- Name: empleado fk_empleado_dirige; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT fk_empleado_dirige FOREIGN KEY (num_dirige) REFERENCES public.incidencias(num_incidencia);


--
-- TOC entry 4777 (class 2606 OID 16782)
-- Name: empleado fk_empleado_dispositivo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT fk_empleado_dispositivo FOREIGN KEY (dispositivo_asignado) REFERENCES public.dispositivos(mac);


--
-- TOC entry 4778 (class 2606 OID 16787)
-- Name: empleado fk_empleado_gestiona; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT fk_empleado_gestiona FOREIGN KEY (num_gestiona) REFERENCES public.incidencias(num_incidencia);


--
-- TOC entry 4779 (class 2606 OID 16792)
-- Name: empleado fk_empleado_rol; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT fk_empleado_rol FOREIGN KEY (id_rol) REFERENCES public.rol(id_rol);


--
-- TOC entry 4780 (class 2606 OID 16797)
-- Name: incidencias fk_incidencias_dispositivo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.incidencias
    ADD CONSTRAINT fk_incidencias_dispositivo FOREIGN KEY (dispositivo_afect) REFERENCES public.dispositivos(mac);


--
-- TOC entry 4781 (class 2606 OID 16802)
-- Name: incidencias fk_incidencias_empleado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.incidencias
    ADD CONSTRAINT fk_incidencias_empleado FOREIGN KEY (dni_empleado) REFERENCES public.empleado(dni);


--
-- TOC entry 4782 (class 2606 OID 16807)
-- Name: incidencias fk_incidencias_responsable; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.incidencias
    ADD CONSTRAINT fk_incidencias_responsable FOREIGN KEY (dni_responsable) REFERENCES public.empleado(dni);


--
-- TOC entry 4783 (class 2606 OID 16812)
-- Name: ubicacion fk_ubicacion_direccion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ubicacion
    ADD CONSTRAINT fk_ubicacion_direccion FOREIGN KEY (id_dir) REFERENCES public.direccion(id_dir);


-- Completed on 2026-04-27 19:53:52

--
-- PostgreSQL database dump complete
--

\unrestrict xSIRc4OcUnUwoGOQknGVfA4SgPrg2QfcPU57pBWRV4ek4q1r1EX0KeW3D5dHXvh

