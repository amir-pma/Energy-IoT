--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2021-08-12 21:20:29

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

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--


--
-- TOC entry 2995 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 17802)
-- Name: energy_meters; Type: TABLE; Schema: public; Owner: energy_iot
--

CREATE TABLE public.energy_meters (
                                      id bigint NOT NULL,
                                      alerted boolean,
                                      last_data_time_stamp timestamp with time zone,
                                      neighbourhood_id character varying(255) NOT NULL,
                                      stakeholder_email character varying(255) NOT NULL
);


ALTER TABLE public.energy_meters OWNER TO energy_iot;

--
-- TOC entry 202 (class 1259 OID 17810)
-- Name: meter_datas; Type: TABLE; Schema: public; Owner: energy_iot
--

CREATE TABLE public.meter_datas (
                                    id bigint NOT NULL,
                                    consumptionkwh double precision NOT NULL,
                                    "timestamp" timestamp with time zone,
                                    energy_meter_id bigint NOT NULL
);


ALTER TABLE public.meter_datas OWNER TO energy_iot;

--
-- TOC entry 2856 (class 2606 OID 17809)
-- Name: energy_meters energy_meters_pkey; Type: CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.energy_meters
    ADD CONSTRAINT energy_meters_pkey PRIMARY KEY (id);


--
-- TOC entry 2858 (class 2606 OID 17814)
-- Name: meter_datas meter_datas_pkey; Type: CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.meter_datas
    ADD CONSTRAINT meter_datas_pkey PRIMARY KEY (id);


--
-- TOC entry 2859 (class 2606 OID 17815)
-- Name: meter_datas fk93j1mml9olt1rv8ugoh57g5v1; Type: FK CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.meter_datas
    ADD CONSTRAINT fk93j1mml9olt1rv8ugoh57g5v1 FOREIGN KEY (energy_meter_id) REFERENCES public.energy_meters(id);


-- Completed on 2021-08-12 21:20:29

--
-- PostgreSQL database dump complete
--

