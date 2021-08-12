--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2021-08-12 21:22:50

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
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--



SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 17672)
-- Name: cities; Type: TABLE; Schema: public; Owner: energy_iot
--

CREATE TABLE public.cities (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    state_id bigint NOT NULL,
    tariff_id bigint
);


ALTER TABLE public.cities OWNER TO energy_iot;

--
-- TOC entry 201 (class 1259 OID 17677)
-- Name: countries; Type: TABLE; Schema: public; Owner: energy_iot
--

CREATE TABLE public.countries (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    tariff_id bigint NOT NULL
);


ALTER TABLE public.countries OWNER TO energy_iot;

--
-- TOC entry 202 (class 1259 OID 17682)
-- Name: districts; Type: TABLE; Schema: public; Owner: energy_iot
--

CREATE TABLE public.districts (
    id bigint NOT NULL,
    name bigint NOT NULL,
    city_id bigint NOT NULL,
    tariff_id bigint
);


ALTER TABLE public.districts OWNER TO energy_iot;

--
-- TOC entry 206 (class 1259 OID 17820)
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: energy_iot
--


--
-- TOC entry 203 (class 1259 OID 17687)
-- Name: neighbourhoods; Type: TABLE; Schema: public; Owner: energy_iot
--

CREATE TABLE public.neighbourhoods (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    district_id bigint NOT NULL,
    tariff_id bigint
);


ALTER TABLE public.neighbourhoods OWNER TO energy_iot;

--
-- TOC entry 204 (class 1259 OID 17692)
-- Name: states; Type: TABLE; Schema: public; Owner: energy_iot
--

CREATE TABLE public.states (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    country_id bigint NOT NULL,
    tariff_id bigint
);


ALTER TABLE public.states OWNER TO energy_iot;

--
-- TOC entry 205 (class 1259 OID 17697)
-- Name: tariff_plans; Type: TABLE; Schema: public; Owner: energy_iot
--

CREATE TABLE public.tariff_plans (
    id bigint NOT NULL,
    cost_perkwh double precision NOT NULL
);


ALTER TABLE public.tariff_plans OWNER TO energy_iot;

--
-- TOC entry 2875 (class 2606 OID 17676)
-- Name: cities cities_pkey; Type: CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (id);


--
-- TOC entry 2877 (class 2606 OID 17681)
-- Name: countries countries_pkey; Type: CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.countries
    ADD CONSTRAINT countries_pkey PRIMARY KEY (id);


--
-- TOC entry 2879 (class 2606 OID 17686)
-- Name: districts districts_pkey; Type: CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.districts
    ADD CONSTRAINT districts_pkey PRIMARY KEY (id);


--
-- TOC entry 2887 (class 2606 OID 17828)
-- Name: flyway_schema_history flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: energy_iot
--




--
-- TOC entry 2881 (class 2606 OID 17691)
-- Name: neighbourhoods neighbourhoods_pkey; Type: CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.neighbourhoods
    ADD CONSTRAINT neighbourhoods_pkey PRIMARY KEY (id);


--
-- TOC entry 2883 (class 2606 OID 17696)
-- Name: states states_pkey; Type: CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.states
    ADD CONSTRAINT states_pkey PRIMARY KEY (id);


--
-- TOC entry 2885 (class 2606 OID 17701)
-- Name: tariff_plans tariff_plans_pkey; Type: CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.tariff_plans
    ADD CONSTRAINT tariff_plans_pkey PRIMARY KEY (id);


--
-- TOC entry 2888 (class 1259 OID 17829)
-- Name: flyway_schema_history_s_idx; Type: INDEX; Schema: public; Owner: energy_iot
--



--
-- TOC entry 2892 (class 2606 OID 17717)
-- Name: districts fk3g7x8w4lc7qxth7ibrr5j73mn; Type: FK CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.districts
    ADD CONSTRAINT fk3g7x8w4lc7qxth7ibrr5j73mn FOREIGN KEY (city_id) REFERENCES public.cities(id);


--
-- TOC entry 2894 (class 2606 OID 17727)
-- Name: neighbourhoods fk77i40nkh3mpoo7d728lr8kt5p; Type: FK CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.neighbourhoods
    ADD CONSTRAINT fk77i40nkh3mpoo7d728lr8kt5p FOREIGN KEY (district_id) REFERENCES public.districts(id);


--
-- TOC entry 2890 (class 2606 OID 17707)
-- Name: cities fk7vmg3637vu9ba5thleed1onea; Type: FK CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT fk7vmg3637vu9ba5thleed1onea FOREIGN KEY (tariff_id) REFERENCES public.tariff_plans(id);


--
-- TOC entry 2895 (class 2606 OID 17732)
-- Name: neighbourhoods fk9os6tfnicwxrcqf3tsx6tmumc; Type: FK CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.neighbourhoods
    ADD CONSTRAINT fk9os6tfnicwxrcqf3tsx6tmumc FOREIGN KEY (tariff_id) REFERENCES public.tariff_plans(id);


--
-- TOC entry 2893 (class 2606 OID 17722)
-- Name: districts fkcpvykf50yqmkwdcrjpuhwnns5; Type: FK CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.districts
    ADD CONSTRAINT fkcpvykf50yqmkwdcrjpuhwnns5 FOREIGN KEY (tariff_id) REFERENCES public.tariff_plans(id);


--
-- TOC entry 2897 (class 2606 OID 17742)
-- Name: states fkib8fxraqm5fcx57jcctptfkg8; Type: FK CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.states
    ADD CONSTRAINT fkib8fxraqm5fcx57jcctptfkg8 FOREIGN KEY (tariff_id) REFERENCES public.tariff_plans(id);


--
-- TOC entry 2891 (class 2606 OID 17712)
-- Name: countries fkkbwwe3kqy0yatl9eqiq7d8es1; Type: FK CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.countries
    ADD CONSTRAINT fkkbwwe3kqy0yatl9eqiq7d8es1 FOREIGN KEY (tariff_id) REFERENCES public.tariff_plans(id);


--
-- TOC entry 2896 (class 2606 OID 17737)
-- Name: states fkskkdphjml9vjlrqn4m5hi251y; Type: FK CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.states
    ADD CONSTRAINT fkskkdphjml9vjlrqn4m5hi251y FOREIGN KEY (country_id) REFERENCES public.countries(id);


--
-- TOC entry 2889 (class 2606 OID 17702)
-- Name: cities fksu54e1tlhaof4oklvv7uphsli; Type: FK CONSTRAINT; Schema: public; Owner: energy_iot
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT fksu54e1tlhaof4oklvv7uphsli FOREIGN KEY (state_id) REFERENCES public.states(id);


-- Completed on 2021-08-12 21:22:50

--
-- PostgreSQL database dump complete
--

