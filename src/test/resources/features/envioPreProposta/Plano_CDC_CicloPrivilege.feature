#language: pt
  # charset: UTF-8
@regressivo
@cicloprivilege

Funcionalidade: Envio de Pré-Proposta CDC CICLO PRIVILEGE
  Como um usuário do sistema
  Eu quero enviar uma pré-proposta CDC CICLO PRIVILEGE para um proponente PF
  Para realizar uma simulação de financiamento

  Contexto: Acessar a tela de simulação com usuario representante
    Dado eu esteja na tela de login
    E que esteja logado com usuario representante
    E eu seleciono a concessionaria
      | CODIGO LOJA | VONICE ALFONZO MAISE - 75 |
    E clico em Proximo
    E clico em Faca Uma Simulacao
    E clico no step de Configuracao

  Cenario: CT001 - CDC Ciclo Privilege Parcela desejada sem subsidio - Mensal - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CDC_CICLOPRIVILEGE_PARCELA_SEM_SUBSIDIO_MENSAL                      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.500,00  |
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

  Cenario: CT002 - CDC Ciclo Privilege Parcela Desejada Com Subsidio Fixo - Mensal - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CDC_CICLOPRIVILEGE_PARCELA_COM_SUBSIDIOFIXO_MENSAL                      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.500,00  |
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

  Cenario: CT003 - CDC Ciclo Privilege Parcela Desejada Com Subsidio Fixo - Flex Semestral - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CDC_CICLOPRIVILEGE_PARCELA_COM_SUBSIDIOFIXO_SEMESTRAL                      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 6 meses após a formalização     |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.500,00  |
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

  Cenario: CT004 - CDC Ciclo Privilege Parcela Desejada Com Subsidio Por Taxa - Mensal - 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CDC_CICLOPRIVILEGE_PARCELA_COM_SUBSIDIOTAXA_MENSAL                      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.500,00   |
      | TAXA SUBSIDIO | 0,65         |
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

  Cenario: CT005 - CDC Ciclo Privilege Prazo Sem Subsidio - Mensal - 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA CROSS FLEX              |
      | TABELA DE NEGOCIACAO | CDC_CICLOPRIVILEGE_PRAZO_SEM_SUBSIDIO_MENSAL|
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - prazo
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$60.000,00  |
      | PRAZO         | 12           |
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

  Cenario: CT006 - CDC Ciclo Privilege Prazo Sem Subsidio - Flex Semestral - 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA CROSS FLEX              |
      | TABELA DE NEGOCIACAO | CDC_CICLOPRIVILEGE_PRAZO_SEM_SUBSIDIO_SEMESTRAL|
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 01                              |
      | VENCIMENTO           | Abril/2022                      |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - prazo
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 12           |
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

  Cenario: CT007 - CDC Ciclo Privilege Prazo Com Subsidio Fixo - Mensal - 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                              |
      | MARCA                | TOYOTA                                           |
      | ANO FABRICACAO       | 2021                                             |
      | ANO MODELO           | 2021                                             |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.                  |
      | TABELA DE NEGOCIACAO | CDC_CICLOPRIVILEGE_PRAZO_COM_SUBSIDIOFIXO_MENSAL |
      | UF EMPLACAMENTO      | ES - Todas                                       |
      | DIA DE PAGAMENTO     | 1 mês após a formalização                        |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                         |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - prazo
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 16           |
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


  Cenario: CT008 - CDC Ciclo Privilege Prazo Com Subsidio Por Taxa - Mensal - 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                              |
      | MARCA                | TOYOTA                                           |
      | ANO FABRICACAO       | 2021                                             |
      | ANO MODELO           | 2021                                             |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.                  |
      | TABELA DE NEGOCIACAO | CDC_CICLOPRIVILEGE_PRAZO_COM_SUBSIDIOTAXA_MENSAL |
      | UF EMPLACAMENTO      | ES - Todas                                       |
      | DIA DE PAGAMENTO     | 1 mês após a formalização                        |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                         |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - prazo
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 16           |
      | TAXA SUBSIDIO | 0,65         |
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

  Cenario: CT009 - CDC Ciclo Privilege Prazo Com Subsidio Por Taxa - Flex Semestral - 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                                  |
      | MARCA                | TOYOTA                                               |
      | ANO FABRICACAO       | 2021                                                 |
      | ANO MODELO           | 2021                                                 |
      | MODELO VERSAO        | COROLLA CROSS FLEX                                   |
      | TABELA DE NEGOCIACAO | CDC_CICLOPRIVILEGE_PRAZO_COM_SUBSIDIOTAXA_SEMESTRAL  |
      | UF EMPLACAMENTO      | ES - Todas                                           |
      | DIA DE PAGAMENTO     | 6 meses após a formalização                          |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                             |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - prazo
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 12           |
      | TAXA SUBSIDIO | 0,50         |
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

  Cenario: CT010 - CDC Ciclo Privilege Prazo Com Subsidio Por Valor - Mensal - 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                                |
      | MARCA                | TOYOTA                                             |
      | ANO FABRICACAO       | 2021                                               |
      | ANO MODELO           | 2021                                               |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.                    |
      | TABELA DE NEGOCIACAO | CDC_CICLOPRIVILEGE_PRAZO_COM_SUBSIDIOVALOR_MENSAL  |
      | UF EMPLACAMENTO      | ES - Todas                                         |
      | DIA DE PAGAMENTO     | 1 mês após a formalização                          |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                           |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - prazo
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 16           |
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
  @Skip #Este cenário dá erro no final da proposta
  Cenario: CT011 - CDC Ciclo Privilege Prazo Com Subsidio Por Valor - Flex Semestral - 0 KM
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                                  |
      | MARCA                | TOYOTA                                               |
      | ANO FABRICACAO       | 2021                                                 |
      | ANO MODELO           | 2021                                                 |
      | MODELO VERSAO        | COROLLA CROSS FLEX                                   |
      | TABELA DE NEGOCIACAO | CDC_CICLOPRIVILEGE_PRAZO_COM_SUBSIDIOVALOR_SEMESTRAL |
      | UF EMPLACAMENTO      | ES - Todas                                           |
      | DIA DE PAGAMENTO     | 6 meses após a formalização                          |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                             |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - prazo
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 12           |
      | VALOR SUBSIDIO| R$100,00     |
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | NAO           |
      | VEICULO USO COMERCIAL       | NAO           |
    E clico em Proximo - Propostaa
    E clico em Proximo - Ofertas
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida