#language: pt
  # charset: UTF-8
@regressivo
@cdcfull

Funcionalidade: Envio de Pré-Proposta CDC FULL PF
  Como um usuário do sistema
  Eu quero enviar uma pré-proposta CDC FULL para um proponente PF
  Para realizar uma simulação de financiamento

  Contexto: Acessar a tela de simulação com usuario representante
    Dado eu esteja na tela de login
    E que esteja logado com usuario representante
    E eu seleciono a concessionaria
      | CODIGO LOJA | VONICE ALFONZO MAISE - 75 |
    E clico em Proximo
    E clico em Faca Uma Simulacao
    E clico no step de Configuracao

  Cenario: CT001 - CDC Parcela desejada sem subsidio - Mensal - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | CDC_PARCELA_SEM_SUBSIDIO_MENSAL |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.100,00   |
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT002 - CDC Parcela Desejada Sem Subsidio - Flex Semestral - Veiculo 0KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                                |
      | MARCA                | TOYOTA                             |
      | ANO FABRICACAO       | 2021                               |
      | ANO MODELO           | 2021                               |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.    |
      | TABELA FLEX          | SIM                                |
      | TABELA DE NEGOCIACAO | CDC_PARCELA_SEM_SUBSIDIO_SEMESTRAL |
      | UF EMPLACAMENTO      | ES - Todas                         |
      | CODIGO SIMULACAO     | 0                                  |
      | DIA DE PAGAMENTO     | 6 meses após a formalização        |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica           |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.100,00   |
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT003 - CDC Parcela Desejada Com Subsidio Fixo - Mensal - Veiculo 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                                  |
      | MARCA                | TOYOTA                               |
      | ANO FABRICACAO       | 2021                                 |
      | ANO MODELO           | 2021                                 |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.      |
      | TABELA FLEX          | NAO                                  |
      | TABELA DE NEGOCIACAO | CDC_PARCELA_COM_SUBSIDIOFIXO_MENSAL  |
      | UF EMPLACAMENTO      | ES - Todas                           |
      | DIA DE PAGAMENTO     | 1 mês após a formalização            |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica             |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$3.000,00   |
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT004 - CDC Parcela Desejada Com Subsidio Fixo - Flex Semestral - Veiculo 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                                    |
      | MARCA                | TOYOTA                                 |
      | ANO FABRICACAO       | 2021                                   |
      | ANO MODELO           | 2021                                   |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.        |
      | TABELA FLEX          | SIM                                    |
      | TABELA DE NEGOCIACAO | CDC_PARCELA_COM_SUBSIDIOFIXO_SEMESTRAL |
      | UF EMPLACAMENTO      | ES - Todas                             |
      | DIA DE PAGAMENTO     | 01                                     |
      | VENCIMENTO           | Agosto/2022                            |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica               |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.100,00   |
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT005 - CDC Parcela Desejada Com Subsidio Variável - Por Taxa - Mensal - Veiculo 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                                  |
      | MARCA                | TOYOTA                               |
      | ANO FABRICACAO       | 2021                                 |
      | ANO MODELO           | 2021                                 |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.      |
      | TABELA FLEX          | NAO                                  |
      | TABELA DE NEGOCIACAO | CDC_PARCELA_COM_SUBSIDIOTAXA_MENSAL  |
      | UF EMPLACAMENTO      | ES - Todas                           |
      | DIA DE PAGAMENTO     | 1 mês após a formalização            |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica             |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.100,00   |
      | TAXA SUBSIDIO | 1,05         |
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT006 - CDC Parcela Desejada Com Subsidio Variável - Por Taxa - Flex Semestral - Veiculo 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                                    |
      | MARCA                | TOYOTA                                 |
      | ANO FABRICACAO       | 2021                                   |
      | ANO MODELO           | 2021                                   |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.        |
      | TABELA FLEX          | SIM                                    |
      | TABELA DE NEGOCIACAO | CDC_PARCELA_COM_SUBSIDIOTAXA_SEMESTRAL |
      | UF EMPLACAMENTO      | ES - Todas                             |
      | DIA DE PAGAMENTO     | 6 meses após a formalização            |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica               |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.100,00   |
      | TAXA SUBSIDIO | 1,05         |
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT007 - CDC Prazo Sem Subsidio - Mensal - Veiculo Usado
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | USADO |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2017                            |
      | ANO MODELO           | 2017                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | CDC_PRAZO_SEM_SUBSIDIO_MENSAL   |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.100,00   |
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | PLACA VEICULO               | IUW2764       |
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT008 - CDC Prazo Com Subsidio Fixo - Mensal - Veiculo 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                                |
      | MARCA                | TOYOTA                             |
      | ANO FABRICACAO       | 2021                               |
      | ANO MODELO           | 2021                               |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.    |
      | TABELA FLEX          | NAO                                |
      | TABELA DE NEGOCIACAO | CDC_PRAZO_COM_SUBSIDIOFIXO_MENSAL  |
      | UF EMPLACAMENTO      | ES - Todas                         |
      | DIA DE PAGAMENTO     | 1 mês após a formalização          |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica           |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - prazo
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 36           |
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT009 - CDC Prazo Com Subsidio Variável - Por Taxa - Mensal - Veiculo 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                                |
      | MARCA                | TOYOTA                             |
      | ANO FABRICACAO       | 2021                               |
      | ANO MODELO           | 2021                               |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.    |
      | TABELA FLEX          | NAO                                |
      | TABELA DE NEGOCIACAO | CDC_PRAZO_COM_SUBSIDIOTAXA_MENSAL  |
      | UF EMPLACAMENTO      | ES - Todas                         |
      | DIA DE PAGAMENTO     | 1 mês após a formalização          |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica           |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - prazo
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 12           |
      | TAXA SUBSIDIO | 0,60         |
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaa
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT010 - CDC Prazo Com Subsidio Variável - Por Valor - Mensal - Veiculo 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                                |
      | MARCA                | TOYOTA                             |
      | ANO FABRICACAO       | 2021                               |
      | ANO MODELO           | 2021                               |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.    |
      | TABELA FLEX          | NAO                                |
      | TABELA DE NEGOCIACAO | CDC_PRAZO_COM_SUBSIDIOVALOR_MENSAL |
      | UF EMPLACAMENTO      | ES - Todas                         |
      | DIA DE PAGAMENTO     | 1 mês após a formalização          |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica           |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - prazo
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 12           |
      | VALOR SUBSIDIO| R$2.500,00   |
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaa
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT011 - CDC Prazo Com Subsidio Variável - Por Valor - Flex Semestral - Veiculo 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                                    |
      | MARCA                | TOYOTA                                 |
      | ANO FABRICACAO       | 2021                                   |
      | ANO MODELO           | 2021                                   |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.        |
      | TABELA FLEX          | SIM                                    |
      | TABELA DE NEGOCIACAO | CDC_PRAZO_COM_SUBSIDIOVALOR_SEMESTRAL  |
      | UF EMPLACAMENTO      | ES - Todas                             |
      | DIA DE PAGAMENTO     | 6 meses após a formalização            |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica               |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - prazo
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 36           |
      | VALOR SUBSIDIO| R$2.500,00   |
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaa
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida