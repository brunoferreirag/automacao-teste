#language: pt
  # charset: UTF-8
  @regressivo
  @ciclotoyota

Funcionalidade: Envio de Pré-Proposta CDC CICLO TOYOTA
  Como um usuário do sistema
  Eu quero enviar uma pré-proposta CDC CICLO TOYOTA para um proponente PF
  Para realizar uma simulação de financiamento

  Contexto: Acessar a tela de simulação com usuario representante
    Dado eu esteja na tela de login
    E que esteja logado com usuario representante
    E eu seleciono a concessionaria
      | CODIGO LOJA | VONICE ALFONZO MAISE - 75 |
    E clico em Proximo
    E clico em Faca Uma Simulacao
    E clico no step de Configuracao

  Cenario: CT001 - CDC Ciclo Toyota Parcela desejada sem subsidio - Mensal - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                          |
      | MARCA                | TOYOTA                                       |
      | ANO FABRICACAO       | 2021                                         |
      | ANO MODELO           | 2021                                         |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.              |
      | TABELA DE NEGOCIACAO | CDC_CICLOTOYOTA_PARCELA_SEM_SUBSIDIO_MENSAL  |
      | UF EMPLACAMENTO      | ES - Todas                                   |
      | CODIGO SIMULACAO     | 0                                            |
      | DIA DE PAGAMENTO     | 1 mês após a formalização                    |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                     |
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

  Cenario: CT002 - CDC Ciclo Toyota Parcela desejada com subsidio Fixo - Mensal - Veiculo 0km
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
      | MODELO VERSAO        | COROLLA CROSS FLEX                               |
      | TABELA DE NEGOCIACAO | CDC_CICLOTOYOTA_PARCELA_COM_SUBSIDIOFIXO_MENSAL  |
      | UF EMPLACAMENTO      | ES - Todas                                       |
      | DIA DE PAGAMENTO     | 1 mês após a formalização                        |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                         |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.000,00  |
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

  Cenario: CT003 - CDC Ciclo Toyota Parcela desejada com subsidio Variavel - Por Taxa - Mensal - Veiculo 0km
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
      | TABELA DE NEGOCIACAO | CDC_CICLOTOYOTA_PARCELA_COM_SUBSIDIOTAXA_MENSAL  |
      | UF EMPLACAMENTO      | ES - Todas                                       |
      | DIA DE PAGAMENTO     | 1 mês após a formalização                        |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                         |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.100,00   |
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

  Cenario: CT004 - CDC Ciclo Toyota Residual sem subsidio - Mensal - Veiculo 0km
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                          |
      | MARCA                | TOYOTA                                       |
      | ANO FABRICACAO       | 2021                                         |
      | ANO MODELO           | 2021                                         |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.              |
      | TABELA DE NEGOCIACAO | CDC_CICLOTOYOTA_RESIDUAL_SEM_SUBSIDIO_MENSAL |
      | UF EMPLACAMENTO      | ES - Todas                                   |
      | CODIGO SIMULACAO     | 0                                            |
      | DIA DE PAGAMENTO     | 1 mês após a formalização                    |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                     |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - residual
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR RESIDUAL| R$20.000,00  |
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

  Cenario: CT005 - CDC Ciclo Toyota Residual com subsidio Fixo - Mensal - 0 KM
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
      | MODELO VERSAO        | COROLLA CROSS FLEX                               |
      | TABELA DE NEGOCIACAO | CDC_CICLOTOYOTA_RESIDUAL_COM_SUBSÍDIOFIXO_MENSAL |
      | UF EMPLACAMENTO      | ES - Todas                                       |
      | DIA DE PAGAMENTO     | 01                                               |
      | VENCIMENTO           | Março/2022                                       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                         |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - residual
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR RESIDUAL| R$21.000,00   |
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

 Cenario: CT006 - CDC Ciclo Toyota Residual com subsidio Variavel - Por Taxa - Mensal - Veiculo 0km
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
      | TABELA DE NEGOCIACAO | CDC_CICLOTOYOTA_RESIDUAL_COM_SUBSIDIOTAXA_MENSAL |
      | UF EMPLACAMENTO      | ES - Todas                                       |
      | DIA DE PAGAMENTO     | 1 mês após a formalização                        |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                         |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - residual
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR RESIDUAL| R$20.000,00  |
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

  Cenario: CT007 - CDC Ciclo Toyota Residual com subsidio Variavel - Por Valor - Mensal - Veiculo 0km
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
      | TABELA DE NEGOCIACAO | CDC_CICLOTOYOTA_RESIDUAL_COM_SUBSIDIOVALOR_MENSAL  |
      | UF EMPLACAMENTO      | ES - Todas                                         |
      | DIA DE PAGAMENTO     | 1 mês após a formalização                          |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica                           |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - residual
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR RESIDUAL| R$20.000,00  |
      | VALOR SUBSIDIO| R$7.000,00  |
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
