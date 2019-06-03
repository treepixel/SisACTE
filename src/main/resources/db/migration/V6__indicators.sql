-- Create Table --

CREATE TABLE indicator_category
(
    id SERIAL,
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT indicator_category_pkey PRIMARY KEY (id)
);

CREATE TABLE indicator
(
    id SERIAL,
    weight integer,
    category_id bigint,
    text text COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT indicator_pkey PRIMARY KEY (id),
    CONSTRAINT fklpc0ya4n6oaqgu5knvuvbmwdm FOREIGN KEY (category_id)
        REFERENCES public.indicator_category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Insert Data --
Insert into indicator_category (id,title) values (1, 'indicatores de submissão de trabalhador a trabalhos forçados');
Insert into indicator_category (id,title) values (2, 'indicatores de sujeição de trabalhador a condição degradante:');
Insert into indicator_category (id,title) values (3, 'indicatores de submissão de trabalhador a jornada exaustiva');
Insert into indicator_category (id,title) values (4, 'indicatores da restrição, por qualquer meio, da locomoção do trabalhador em razão de dívida contraída com empregador ou preposto, dentre outros');


Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Trabalhador vítima de tráfico de pessoas', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Arregimentação de trabalhador por meio de ameaça, fraude, engano, coação ou outros artifícios que levem a vício de consentimento, tais como falsas promessas no momento do recrutamento ou pagamento a pessoa que possui poder hierárquico ou de mando sobre o trabalhador', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Manutenção de trabalhador na prestação de serviços por meio de ameaça, fraude, engano, coação ou outros artifícios que levem a vício de consentimento quanto a sua liberdade de dispor da força de trabalho e de encerrar a relação de trabalho', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Manutenção de mão de obra de reserva recrutada sem observação das prescrições legais cabíveis, através da divulgação de promessas de emprego em localidade diversa da de prestação dos serviços', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Exploração da situação de vulnerabilidade de trabalhador para inserir no contrato de trabalho, formal ou informalmente, condições ou cláusulas abusivas', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Existência de trabalhador restrito ao local de trabalho ou de alojamento, quando tal local situar-se em área isolada ou de difícil acesso, não atendida regularmente por transporte público ou particular, ou em razão de barreiras como desconhecimento de idioma, ou de usos e costumes, de ausência de documentos pessoais, de situação de vulnerabilidade social ou de não pagamento de remuneração', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Induzimento ou obrigação do trabalhador a assinar documentos em branco, com informações inverídicas ou a respeito das quais o trabalhador não tenha o entendimento devido', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Induzimento do trabalhador a realizar jornada extraordinária acima do limite legal ou incompatível com sua capacidade psicofisiológica', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Estabelecimento de sistemas de remuneração que não propiciem ao trabalhador informações compreensíveis e idôneas sobre valores recebidos e descontados do salário', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Estabelecimento de sistemas remuneratórios que, por adotarem valores irrisórios pelo tempo de trabalho ou por unidade de produção, ou por transferirem ilegalmente os ônus e riscos da atividade econômica para o trabalhador, resultem no pagamento de salário base inferior ao mínimo legal ou remuneração aquém da pactuada', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Exigência do cumprimento de metas de produção que induzam o trabalhador a realizar jornada extraordinária acima do limite legal ou incompatível com sua capacidade psicofisiológica', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Manutenção do trabalhador confinado através de controle dos meios de entrada e saída, de ameaça de sanção ou de exploração de vulnerabilidade', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Pagamento de salários fora do prazo legal de forma não eventual', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Retenção parcial ou total do salário', 1);
Insert into indicator (category_id, status, text, weight) values (1, 'Ativo', 'Pagamento de salário condicionado ao término de execução de serviços específicos com duração superior a 30 dias', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Não disponibilização de água potável, ou disponibilização em condições não higiênicas ou em quantidade insuficiente para consumo do trabalhador no local de trabalho ou de alojamento', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Inexistência, nas áreas de vivência, de água limpa para higiene, preparo de alimentos e demais necessidades', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Ausência de recipiente para armazenamento adequado de água que assegure a manutenção da potabilidade', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Reutilização de recipientes destinados ao armazenamento de produtos tóxicos', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Inexistência de instalações sanitárias ou instalações sanitárias que não assegurem utilização em condições higiênicas ou com preservação da privacidade', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Inexistência de alojamento ou moradia, quando o seu fornecimento for obrigatório, ou alojamento ou moradia sem condições básicas de segurança, vedação, higiene, privacidade ou conforto', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Subdimensionamento de alojamento ou moradia que inviabilize sua utilização em condições de segurança, vedação, higiene, privacidade ou conforto', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Trabalhador alojado ou em moradia no mesmo ambiente utilizado para desenvolvimento da atividade laboral', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Moradia coletiva de famílias ou o alojamento coletivo de homens e mulheres', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Coabitação de família com terceiro estranho ao núcleo familiar', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Armazenamento de substâncias tóxicas ou inflamáveis nas áreas de vivência', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Ausência de camas com colchões ou de redes nos alojamentos, com o trabalhador pernoitando diretamente sobre piso ou superfície rígida ou em estruturas improvisadas', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Ausência de local adequado para armazenagem ou conservação de alimentos e de refeições', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Ausência de local para preparo de refeições, quando obrigatório, ou local para preparo de refeições sem condições de higiene e conforto', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Ausência de local para tomada de refeições, quando obrigatório, ou local para tomada de refeições sem condições de higiene e conforto', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Trabalhador exposto a situação de risco grave e iminente', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Inexistência de medidas para eliminar ou neutralizar riscos quando a atividade, o meio ambiente ou as condições de trabalho apresentarem riscos graves para a saúde e segurança do trabalhador', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Pagamento de salários fora do prazo legal de forma não eventual', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Retenção parcial ou total do salário', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Pagamento de salário condicionado ao término de execução de serviços específicos com duração superior a 30 dias', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Serviços remunerados com substâncias prejudiciais à saúde', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Estabelecimento de sistemas remuneratórios que, por adotarem valores irrisórios pelo tempo de trabalho ou por unidade de produção, ou por transferirem ilegalmente os ônus e riscos da atividade econômica para o trabalhador, resultem no pagamento de salário base inferior ao mínimo legal ou remuneração aquém da pactuada', 1);
Insert into indicator (category_id, status, text, weight) values (2, 'Ativo', 'Agressão física, moral ou sexual no context da relação de trabalho', 1);
Insert into indicator (category_id, status, text, weight) values (3, 'Ativo', 'Extrapolação não eventual do quantitativo total de horas extraordinárias legalmente permitidas por dia, por semana ou por mês dentro do período analisado', 1);
Insert into indicator (category_id, status, text, weight) values (3, 'Ativo', 'Supressão não eventual do descanso semanal remunerado', 1);
Insert into indicator (category_id, status, text, weight) values (3, 'Ativo', 'Supressão não eventual dos intervalos intrajornada e interjornadas', 1);
Insert into indicator (category_id, status, text, weight) values (3, 'Ativo', 'Supressão do gozo de férias', 1);
Insert into indicator (category_id, status, text, weight) values (3, 'Ativo', 'Inobservância não eventual de pausas legalmente previstas', 1);
Insert into indicator (category_id, status, text, weight) values (3, 'Ativo', 'Restrição ao uso de instalações sanitárias para satisfação das necessidades fisiológicas do trabalhador', 1);
Insert into indicator (category_id, status, text, weight) values (3, 'Ativo', 'Trabalhador sujeito a atividades com sobrecarga física ou mental ou com ritmo e cadência de trabalho com potencial de causar comprometimento de sua saúde ou da sua segurança', 1);
Insert into indicator (category_id, status, text, weight) values (3, 'Ativo', 'Trabalho executado em condições não ergonômicas, insalubres, perigosas ou penosas, especialmente se associado a aferição de remuneração por produção', 1);
Insert into indicator (category_id, status, text, weight) values (3, 'Ativo', 'Extrapolação não eventual da jornada em atividades penosas, perigosas e insalubres', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Deslocamento do trabalhador desde sua localidade de origem até o local de prestação de serviços custeado pelo empregador ou preposto e a ser descontado da remuneração devida', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Débitos do trabalhador prévios à contratação saldados pelo empregador diretamente com o credor e a serem descontados da remuneração devida', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Transferência ao trabalhador arregimentado do ônus do custeio do deslocamento desde sua localidade de origem até o local de prestação dos serviços', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Transferência ao trabalhador arregimentado do ônus do custeio da permanência no local de prestação dos serviços até o efetivo início da prestação laboral', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Contratação condicionada a pagamento, pelo trabalhador, pela vaga de trabalho', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Adiantamentos em numerário ou em gêneros concedidos quando da contratação', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Fornecimento de bens ou serviços ao trabalhador com preços acima dos praticados na região', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Remuneração in natura em limites superiores ao legalmente previsto', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Trabalhador induzido ou coagido a adquirir bens ou serviços de estabelecimento determinado pelo empregador ou preposto', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Existência de valores referentes a gastos que devam ser legalmente suportados pelo empregador a serem cobrados ou descontados do trabalhador', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Descontos de moradia ou alimentação acima dos limites legais', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Alteração, com prejuízo para o trabalhador, da forma de remuneração ou dos ônus do trabalhador pactuados quando da contratação', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Restrição de acesso ao controle de débitos e créditos referentes à prestação do serviço ou de sua compreensão pelo trabalhador', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Restrição ao acompanhamento ou entendimento pelo trabalhador da aferição da produção quando for esta a forma de remuneração', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Pagamento de salários fora do prazo legal de forma não eventual', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Retenção parcial ou total do salário', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Estabelecimento de sistemas remuneratórios que, por adotarem valores irrisórios pelo tempo de trabalho ou por unidade de produção, ou por transferirem ilegalmente os ônus e riscos da atividade econômica para o trabalhador, resultem no pagamento de salário base inferior ao mínimo legal ou remuneração aquém da pactuada', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Pagamento de salário condicionado ao término de execução de serviços determinados com duração superior a 30 dias', 1);
Insert into indicator (category_id, status, text, weight) values (4, 'Ativo', 'Retenção do pagamento de verbas rescisórias', 1);




