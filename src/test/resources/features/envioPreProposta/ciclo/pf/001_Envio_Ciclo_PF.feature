# language: pt
# charset: UTF-8
@cicloPf
@regressivo
Funcionalidade: Envio de Pré-Proposta Ciclo PF
  Eu como usuário gostaria de enviar uma proposta Ciclo Toyota para um proponente PF

  Contexto:
    Dado eu estou na pagina de login
    E eu efetuar o login com usuario com o perfil de representante
    E eu estou na pagina de selecao de loja
    E eu seleciono a concessionaria
      | CODIGO LOJA | 75 |
    E eu estou na pagina de home
    E eu clico em 'Faca Uma Simulacao'
    E eu estou na pagina de veiculo
    E eu clico no step de 'Configuracao' no Breadcrumb
    E eu estou na pagina de configuracao


  #Planos Ciclo

  @cicloPfCT001
  Cenario: CT001 - Executar Simulacao CDC Ciclo Parcela Desejada Sem Subsidio
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CICLO PF SEM SUBSIDIO           |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.400,00   |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT002
  Cenario: CT002 - Executar Simulacao CDC Ciclo Parcela Desejada Com Subsidio Por Taxa
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CICLO PF SUBSIDIO VARIAVEL      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.400,00   |
      | TAXA SUBSIDIO | 0,90%        |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT003
  Cenario: CT003 - Executar Simulacao CDC Ciclo Residual Sem Subsidio
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CICLO PF SEM SUBSIDIO           |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.400,00   |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT004
  Cenario: CT004 - Executar Simulacao CDC Ciclo Residual Com Subsidio Por Taxa
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CICLO PF SUBSIDIO VARIAVEL      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Residual
    E eu preencho os valores da simulacao
      | VALOR VEICULO  | R$100.000,00 |
      | VALOR ENTRADA  | R$30.000,00  |
      | VALOR RESIDUAL | R$30.500,00  |
      | TAXA SUBSIDIO  | 0,90%        |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT005
  Cenario: CT005 - Executar Simulacao CDC Ciclo Residual Com Subsidio Por Valor
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CICLO PF SUBSIDIO VARIAVEL      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Residual
    E eu preencho os valores da simulacao
      | VALOR VEICULO  | R$100.000,00 |
      | VALOR ENTRADA  | R$30.000,00  |
      | VALOR RESIDUAL | R$30.000,00  |
      | VALOR SUBSIDIO | R$4.500,00   |
      | PRAZO SUBSIDIO | 36x          |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio


  #Planos Ciclo One

  @cicloPfCT006
  Cenario: CT006 - Executar Simulacao CDC Ciclo One Sem Subsidio
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CICLO ONE PF SEM SUBSIDIO       |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           |                                 |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT007
  Cenario: CT007 - Executar Simulacao CDC Ciclo One Com Subsidio Por Taxa
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CICLO ONE PF SUBSIDIO VARIAVEL  |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           |                                 |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | TAXA SUBSIDIO | 0,35%        |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT008
  Cenario: CT008 - Executar Simulacao CDC Ciclo One Com Subsidio Por Valor
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CICLO ONE PF SUBSIDIO VARIAVEL  |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           |                                 |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO  | R$100.000,00 |
      | VALOR ENTRADA  | R$30.000,00  |
      | VALOR SUBSIDIO | R$15,00      |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT009
  Cenario: CT009 - Executar Simulacao CDC Ciclo One Com Subsidio Fixo
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CICLO ONE PF SUBSIDIO FIXO      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           |                                 |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  #Planos Ciclo Privilege

  @cicloPfCT010
  Cenario: CT010 - Executar Simulacao CDC Ciclo Privilege Parcela Desejada Sem Subsidio
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CICLO PRIVILEGE PF SEM SUBSIDIO |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           |                                 |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.400,00   |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT011
  Cenario: CT011 - Executar Simulacao CDC Ciclo Privilege Parcela Desejada Com Subsidio Por Taxa
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                  |
      | MARCA                | TOYOTA                               |
      | ANO FABRICACAO       | 2021                                 |
      | ANO MODELO           | 2021                                 |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.      |
      | TABELA DE NEGOCIACAO | CICLO PRIVILEGE PF SUBSIDIO VARIAVEL |
      | UF EMPLACAMENTO      | ES - Todas                           |
      | DIA DE PAGAMENTO     | 10                                   |
      | VENCIMENTO           |                                      |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica             |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.400,00   |
      | TAXA SUBSIDIO | 0,35%        |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT012
  Cenario: CT012 - Executar Simulacao CDC Ciclo Privilege Parcela Desejada Com Subsidio Fixo
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                              |
      | MARCA                | TOYOTA                           |
      | ANO FABRICACAO       | 2021                             |
      | ANO MODELO           | 2021                             |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.  |
      | TABELA DE NEGOCIACAO | CICLO PRIVILEGE PF SUBSIDIO FIXO |
      | UF EMPLACAMENTO      | ES - Todas                       |
      | DIA DE PAGAMENTO     | 10                               |
      | VENCIMENTO           |                                  |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica         |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.400,00   |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT013
  Cenario: CT013 - Executar Simulacao CDC Ciclo Privilege Prazo Sem Subsidio
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CICLO PRIVILEGE PF SEM SUBSIDIO |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           |                                 |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 24x          |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT014
  Cenario: CT014 - Executar Simulacao CDC Ciclo Privilege Prazo Com Subsidio Por Taxa
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                  |
      | MARCA                | TOYOTA                               |
      | ANO FABRICACAO       | 2021                                 |
      | ANO MODELO           | 2021                                 |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.      |
      | TABELA DE NEGOCIACAO | CICLO PRIVILEGE PF SUBSIDIO VARIAVEL |
      | UF EMPLACAMENTO      | ES - Todas                           |
      | DIA DE PAGAMENTO     | 10                                   |
      | VENCIMENTO           |                                      |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica             |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 36x          |
      | TAXA SUBSIDIO | 0,35%        |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT015
  Cenario: CT015 - Executar Simulacao CDC Ciclo Privilege Com Subsidio Por Valor
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                                  |
      | MARCA                | TOYOTA                               |
      | ANO FABRICACAO       | 2021                                 |
      | ANO MODELO           | 2021                                 |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.      |
      | TABELA DE NEGOCIACAO | CICLO PRIVILEGE PF SUBSIDIO VARIAVEL |
      | UF EMPLACAMENTO      | ES - Todas                           |
      | DIA DE PAGAMENTO     | 10                                   |
      | VENCIMENTO           |                                      |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica             |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO  | R$100.000,00 |
      | VALOR ENTRADA  | R$30.000,00  |
      | PRAZO          | 30x          |
      | VALOR SUBSIDIO | R$800,00     |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cicloPfCT016
  Cenario: CT016 - Executar Simulacao CDC Ciclo Privilege Prazo Com Subsidio Fixo
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                              |
      | MARCA                | TOYOTA                           |
      | ANO FABRICACAO       | 2021                             |
      | ANO MODELO           | 2021                             |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT.  |
      | TABELA DE NEGOCIACAO | CICLO PRIVILEGE PF SUBSIDIO FIXO |
      | UF EMPLACAMENTO      | ES - Todas                       |
      | DIA DE PAGAMENTO     | 10                               |
      | VENCIMENTO           |                                  |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica         |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 24x          |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
#      | CPF                         | 63455856020 |
#      | NOME                        | Teste Nome  |
      | SEXO                        | M         |
#      | DATA NASCIMENTO             | 01012000    |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio