-- Create Table --

CREATE TABLE question_category
(
    id SERIAL,
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT question_category_pkey PRIMARY KEY (id)
);

-- Insert Data --

Insert into question_category (id,title) values (1, 'Contratação');
Insert into question_category (id,title) values (2, 'Alojamento e Alimentação');
Insert into question_category (id,title) values (3, 'Condições de Trabalho');
Insert into question_category (id,title) values (4, 'Relação de Trabalho');