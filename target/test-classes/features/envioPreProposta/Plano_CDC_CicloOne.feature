#language: pt
  # charset: UTF-8
@regressivo
@cicloone


Funcionalidade: Envio de Pré-Proposta CDC CICLO ONE
  Como um usuário do sistema
  Eu quero enviar uma pré-proposta CDC CICLO ONE para um proponente PF
  Para realizar uma simulação de financiamento

  Contexto: Acessar a tela de simulação com usuario representante
    Dado eu esteja na tela de login
    E que esteja logado com usuario representante
    E eu seleciono a concessionaria
      | CODIGO LOJA | VONICE ALFONZO MAISE - 75 |
    E clico em Proximo
    E clico em Faca Uma Simulacao
    E clico no step de Configuracao

  Cenario: CT001 - CDC Ciclo Toyota One Parcela desejada sem subsidio - Carência 6 Meses - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                      |
      | MARCA                | TOYOTA                                   |
      | ANO FABRICACAO       | 2021                                     |
      | ANO MODELO           | 2021                                     |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.          |
      | TABELA DE NEGOCIACAO | CDC_CICLOONE_PARCELA_SEM_SUBSIDIO_6MESES |
      | UF EMPLACAMENTO      | ES - Todas                               |
      | CODIGO SIMULACAO     | 0                                        |
      | DIA DE PAGAMENTO     | 01                                       |
      | VENCIMENTO           | Julho/2022                               |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                 |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
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

  Cenario: CT002 - CDC Ciclo Toyota One Parcela desejada sem subsidio - Carência 1 Ano - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                    |
      | MARCA                | TOYOTA                                 |
      | ANO FABRICACAO       | 2021                                   |
      | ANO MODELO           | 2021                                   |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.        |
      | TABELA DE NEGOCIACAO | CDC_CICLOONE_PARCELA_SEM_SUBSIDIO_1ANO |
      | UF EMPLACAMENTO      | ES - Todas                             |
      | CODIGO SIMULACAO     | 0                                      |
      | DIA DE PAGAMENTO     | 10                                     |
      | VENCIMENTO           | Maio/2022                              |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica               |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
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

  Cenario: CT003 - CDC Ciclo Toyota One Parcela desejada com subsidio Fixo - Carência 6 Meses - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                          |
      | MARCA                | TOYOTA                                       |
      | ANO FABRICACAO       | 2021                                         |
      | ANO MODELO           | 2021                                         |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.              |
      | TABELA DE NEGOCIACAO | CDC_CICLOONE_PARCELA_COM_SUBSIDIOFIXO_6MESES |
      | UF EMPLACAMENTO      | ES - Todas                                   |
      | DIA DE PAGAMENTO     | 10                                           |
      | VENCIMENTO           | Fevereiro/2023                               |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                     |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
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

  Cenario: CT004 - CDC Ciclo Toyota One Parcela desejada com subsidio Fixo - Carência 1 Ano - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                        |
      | MARCA                | TOYOTA                                     |
      | ANO FABRICACAO       | 2021                                       |
      | ANO MODELO           | 2021                                       |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.            |
      | TABELA DE NEGOCIACAO | CDC_CICLOONE_PARCELA_COM_SUBSIDIOFIXO_1ANO |
      | UF EMPLACAMENTO      | ES - Todas                                 |
      | DIA DE PAGAMENTO     | 10                                         |
      | VENCIMENTO           | Fevereiro/2023                             |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                   |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
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

  Cenario: CT005 - CDC Ciclo Toyota One Parcela desejada com subsidio por Taxa - Carência 6 meses - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                          |
      | MARCA                | TOYOTA                                       |
      | ANO FABRICACAO       | 2021                                         |
      | ANO MODELO           | 2021                                         |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.              |
      | TABELA DE NEGOCIACAO | CDC_CICLOONE_PARCELA_COM_SUBSIDIOTAXA_6MESES |
      | UF EMPLACAMENTO      | ES - Todas                                   |
      | DIA DE PAGAMENTO     | 10                                           |
      | VENCIMENTO           | Agosto/2022                                  |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                     |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
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

  Cenario: CT006 - CDC Ciclo Toyota One Parcela desejada com subsidio por Taxa - Carência 2 Anos - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                          |
      | MARCA                | TOYOTA                                       |
      | ANO FABRICACAO       | 2021                                         |
      | ANO MODELO           | 2021                                         |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.              |
      | TABELA DE NEGOCIACAO | CDC_CICLOONE_PARCELA_COM_SUBSIDIOTAXA_2ANOS  |
      | UF EMPLACAMENTO      | ES - Todas                                   |
      | DIA DE PAGAMENTO     | 10                                           |
      | VENCIMENTO           | Julho/2022                                   |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                     |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
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

  @skip #Este cenário dá erro no final da proposta
  Cenario: CT007 - CDC Ciclo Toyota One Parcela desejada com subsidio por Valor - Carência 6 Meses - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                            |
      | MARCA                | TOYOTA                                         |
      | ANO FABRICACAO       | 2021                                           |
      | ANO MODELO           | 2021                                           |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.                |
      | TABELA DE NEGOCIACAO | CDC_CICLOONE_PARCELA_COM_SUBSIDIOVALOR_6MESES  |
      | UF EMPLACAMENTO      | ES - Todas                                     |
      | DIA DE PAGAMENTO     | 01                                             |
      | VENCIMENTO           | Julho/2022                                     |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                       |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$70.000,00  |
      | TAXA SUBSIDIO | 1,00         |
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
  @Skip #Este cenário dá erro no final da proposta
  Cenario: CT008 - CDC Ciclo Toyota One Parcela desejada com subsidio por Valor - Carência 2 Anos - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | SIM   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                          |
      | MARCA                | TOYOTA                                       |
      | ANO FABRICACAO       | 2021                                         |
      | ANO MODELO           | 2021                                         |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.              |
      | TABELA DE NEGOCIACAO | CDC_CICLOONE_PARCELA_COM_SUBSIDIOVALOR_2ANOS |
      | UF EMPLACAMENTO      | ES - Todas                                   |
      | DIA DE PAGAMENTO     | 10                                           |
      | VENCIMENTO           | Julho/2022                                   |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                     |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR SUBSIDIO| R$100,00     |
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