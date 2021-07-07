# language: pt
# charset: UTF-8
@cdcPfIntermediaria
@regressivo
Funcionalidade: Envio de Pré-Proposta CDC PF Com Intermediárias
  Eu como usuário gostaria de enviar uma proposta CDC para um proponente PF, incluindo parcelas intermediárias

  # CDC PF - VEICULO 0KM - SUGESTAO DE 3 INTERMEDIARIAS

  @cdcPfIntermediariaCT001
  Cenario: CT001 - CDC Parcela Desejada Sem Subsidio - Veículo 0km - Sugestao de 3 Intermediarias
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
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | CDC MENSAL PF SEM SUBSIDIO      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           | SELECIONAR RANDOM               |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$1.750,00   |
    # Sugestao 3 Intermediarias
    E eu clico no botao 'Calcular'
    E eu clico em 'Plano com 3 intermediárias'
    E eu visualizo as intermediárias inseridas na simulacao
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
      | SEXO                        | F         |
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

  @cdcPfIntermediariaCT002
  Cenario: CT002 - CDC Parcela Desejada Com Subsidio Por Taxa - Veículo 0km - Sugestao de 3 Intermediarias
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
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | CDC MENSAL PF SUBSIDIO VARIAVEL |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           | SELECIONAR RANDOM               |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$1.500,00   |
      | TAXA SUBSIDIO | 0,85%        |
    # Sugestao 3 Intermediarias
    E eu clico no botao 'Calcular'
    E eu clico em 'Plano com 3 intermediárias'
    E eu visualizo as intermediárias inseridas na simulacao
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
      | SEXO                        | M         |
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

  # CDC PF - VEICULO 0KM - INTERMEDIARIAS APOS O CALCULO (MODAL DE INTERMEDIARIAS)

  @cdcPfIntermediariaCT003
  Cenario: CT003 - CDC Parcela Desejada Sem Subsidio - Veículo 0km - 1 Intermediária após o Cálculo
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
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | CDC MENSAL PF SEM SUBSIDIO      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           | SELECIONAR RANDOM               |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.100,00   |
    # Inserir Ate 6 Intermediarias
    E eu clico no botao 'Calcular'
    E eu clico em 'Insira até 6 intermediárias'
    E eu visualizo o modal de inclusão de intermediárias
    E eu incluo intermediárias no modal de inclusão de intermediárias
      | INTERMEDIARIA 01 | R$1.000,00 |
    E eu clico em 'Concluir' no modal de inclusão de intermediárias
    E eu visualizo as intermediárias inseridas na simulacao
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
      | SEXO                        | F         |
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

  @cdcPfIntermediariaCT004
  Cenario: CT004 - CDC Parcela Desejada Com Subsidio Por Taxa - Veículo 0km - 2 Intermediária após o Cálculo
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
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | CDC MENSAL PF SUBSIDIO VARIAVEL |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           | SELECIONAR RANDOM               |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$101.000,00 |
      | VALOR ENTRADA | R$32.500,00  |
      | VALOR PARCELA | R$1.930,00   |
      | TAXA SUBSIDIO | 0,85%        |
    # Inserir Ate 6 Intermediarias
    E eu clico no botao 'Calcular'
    E eu clico em 'Insira até 6 intermediárias'
    E eu visualizo o modal de inclusão de intermediárias
    E eu incluo intermediárias no modal de inclusão de intermediárias
      | INTERMEDIARIA 01 | R$1.000,00 |
      | INTERMEDIARIA 02 | R$2.000,00 |
    E eu clico em 'Concluir' no modal de inclusão de intermediárias
    E eu visualizo as intermediárias inseridas na simulacao
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
      | SEXO                        | M         |
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

  @cdcPfIntermediariaCT005
  Cenario: CT005 - CDC Prazo Sem Subsidio - Veículo 0km - 3 Intermediária após o Cálculo
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
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CDC MENSAL PF SEM SUBSIDIO      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           | SELECIONAR RANDOM               |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 48x          |
    # Inserir Ate 6 Intermediarias
    E eu clico no botao 'Calcular'
    E eu clico em 'Insira até 6 intermediárias'
    E eu visualizo o modal de inclusão de intermediárias
    E eu incluo intermediárias no modal de inclusão de intermediárias
      | INTERMEDIARIA 01 | R$1.000,00 |
      | INTERMEDIARIA 02 | R$2.000,00 |
      | INTERMEDIARIA 03 | R$3.000,00 |
    E eu clico em 'Concluir' no modal de inclusão de intermediárias
    E eu visualizo as intermediárias inseridas na simulacao
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
      | SEXO                        | F         |
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

  @cdcPfIntermediariaCT006
  Cenario: CT006 - CDC Prazo Com Subsidio Por Taxa - Veículo 0km - 5 Intermediária após o Cálculo
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
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CDC MENSAL PF SUBSIDIO VARIAVEL |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           | SELECIONAR RANDOM               |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 43x          |
      | TAXA SUBSIDIO | 0,90%        |
    # Inserir Ate 6 Intermediarias
    E eu clico no botao 'Calcular'
    E eu clico em 'Insira até 6 intermediárias'
    E eu visualizo o modal de inclusão de intermediárias
    E eu incluo intermediárias no modal de inclusão de intermediárias
      | INTERMEDIARIA 01 | R$1.000,00 |
      | INTERMEDIARIA 02 | R$2.000,00 |
      | INTERMEDIARIA 03 | R$3.000,00 |
      | INTERMEDIARIA 04 | R$4.000,00 |
      | INTERMEDIARIA 05 | R$5.000,00 |
    E eu clico em 'Concluir' no modal de inclusão de intermediárias
    E eu visualizo as intermediárias inseridas na simulacao
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
      | SEXO                        | M         |
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

  @cdcPfIntermediariaCT007
  Cenario: CT007 - CDC Prazo Com Subsidio Por Valor - Veículo 0km - 6 Intermediária após o Cálculo
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
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CDC MENSAL PF SUBSIDIO VARIAVEL |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 10                              |
      | VENCIMENTO           | SELECIONAR RANDOM               |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO  | R$100.000,00 |
      | VALOR ENTRADA  | R$30.000,00  |
      | PRAZO          | 42x          |
      | VALOR SUBSIDIO | R$3.745,00   |
    # Inserir Ate 6 Intermediarias
    E eu clico no botao 'Calcular'
    E eu clico em 'Insira até 6 intermediárias'
    E eu visualizo o modal de inclusão de intermediárias
    E eu incluo intermediárias no modal de inclusão de intermediárias
      | INTERMEDIARIA 01 | R$1.000,00 |
      | INTERMEDIARIA 02 | R$2.000,00 |
      | INTERMEDIARIA 03 | R$3.000,00 |
      | INTERMEDIARIA 04 | R$4.000,00 |
      | INTERMEDIARIA 05 | R$5.000,00 |
      | INTERMEDIARIA 06 | R$6.000,00 |
    E eu clico em 'Concluir' no modal de inclusão de intermediárias
    E eu visualizo as intermediárias inseridas na simulacao
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
      | SEXO                        | M         |
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

  # CDC PF - VEICULO 0KM - INTERMEDIARIAS APOS O CALCULO - ALTERANDO DATA DE VENCIMENTO (MODAL DE INTERMEDIARIAS)

  @cdcPfIntermediariaCT008
  Cenario: CT008 - CDC Parcela Desejada Sem Subsidio - Veículo 0km - Alterar data de vencimento - 3 Intermediárias após o Cálculo
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
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | CDC MENSAL PF SEM SUBSIDIO      |
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
      | VALOR PARCELA | R$2.100,00   |
    # Inserir Ate 6 Intermediarias
    E eu clico no botao 'Calcular'
    E eu clico em 'Insira até 6 intermediárias'
    E eu seleciono o dia de vencimento da parcela para acessar o modal de inclusão de intermediárias
      | DIA DE PAGAMENTO | 15 |
      | VENCIMENTO       |    |
    E eu visualizo o modal de inclusão de intermediárias
    E eu incluo intermediárias no modal de inclusão de intermediárias
      | INTERMEDIARIA 01 | R$1.000,48 |
      | INTERMEDIARIA 02 | R$4.360,00 |
      | INTERMEDIARIA 03 | R$3.610,50 |
    E eu clico em 'Concluir' no modal de inclusão de intermediárias
    E eu visualizo as intermediárias inseridas na simulacao
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
      | SEXO                        | F         |
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

  @cdcPfIntermediariaCT009
  Cenario: CT009 - CDC Parcela Desejada Com Subsidio - Veículo 0km - Alterar data de vencimento - 3 Intermediárias após o Cálculo
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
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | CDC MENSAL PF SUBSIDIO VARIAVEL |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$1.500,00   |
      | TAXA SUBSIDIO | 0,85%        |
    # Inserir Ate 6 Intermediarias
    E eu clico no botao 'Calcular'
    E eu clico em 'Insira até 6 intermediárias'
    E eu seleciono o dia de vencimento da parcela para acessar o modal de inclusão de intermediárias
      | DIA DE PAGAMENTO | 15 |
      | VENCIMENTO       |    |
    E eu visualizo o modal de inclusão de intermediárias
    E eu incluo intermediárias no modal de inclusão de intermediárias
      | INTERMEDIARIA 01 | R$1.000,48 |
      | INTERMEDIARIA 02 | R$4.360,00 |
      | INTERMEDIARIA 03 | R$3.610,50 |
    E eu clico em 'Concluir' no modal de inclusão de intermediárias
    E eu visualizo as intermediárias inseridas na simulacao
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
      | SEXO                        | F         |
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

  @cdcPfIntermediariaCT010
  Cenario: CT010 - CDC Prazo Sem Subsidio - Veículo 0km - Alterar data de vencimento - 4 Intermediárias após o Cálculo
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
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | CDC MENSAL PF SEM SUBSIDIO      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 24x          |
    # Inserir Ate 6 Intermediarias
    E eu clico no botao 'Calcular'
    E eu clico em 'Insira até 6 intermediárias'
    E eu seleciono o dia de vencimento da parcela para acessar o modal de inclusão de intermediárias
      | DIA DE PAGAMENTO | 15 |
      | VENCIMENTO       |    |
    E eu visualizo o modal de inclusão de intermediárias
    E eu incluo intermediárias no modal de inclusão de intermediárias
      | INTERMEDIARIA 01 | R$1.000,48 |
      | INTERMEDIARIA 02 | R$4.360,00 |
      | INTERMEDIARIA 03 | R$3.610,50 |
      | INTERMEDIARIA 04 | R$2.854,63 |
    E eu clico em 'Concluir' no modal de inclusão de intermediárias
    E eu visualizo as intermediárias inseridas na simulacao
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
      | SEXO                        | F         |
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

  @cdcPfIntermediariaCT011
  Cenario: CT011 - CDC Prazo Com Subsidio - Veículo 0km - Alterar data de vencimento - 6 Intermediárias após o Cálculo
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
    E eu seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | CDC MENSAL PF SUBSIDIO VARIAVEL |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO  | R$100.000,00 |
      | VALOR ENTRADA  | R$30.000,00  |
      | PRAZO          | 38x          |
      | VALOR SUBSIDIO | R$1.250,00   |
    # Inserir Ate 6 Intermediarias
    E eu clico no botao 'Calcular'
    E eu clico em 'Insira até 6 intermediárias'
    E eu seleciono o dia de vencimento da parcela para acessar o modal de inclusão de intermediárias
      | DIA DE PAGAMENTO | 15 |
      | VENCIMENTO       |    |
    E eu visualizo o modal de inclusão de intermediárias
    E eu incluo intermediárias no modal de inclusão de intermediárias
      | INTERMEDIARIA 01 | R$1.000,48 |
      | INTERMEDIARIA 02 | R$4.360,00 |
      | INTERMEDIARIA 03 | R$3.610,50 |
      | INTERMEDIARIA 04 | R$2.000,48 |
      | INTERMEDIARIA 05 | R$860,00   |
      | INTERMEDIARIA 06 | R$2.750,50 |
    E eu clico em 'Concluir' no modal de inclusão de intermediárias
    E eu visualizo as intermediárias inseridas na simulacao
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
      | SEXO                        | F         |
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

  # CDC PF - VEICULO 0KM - INTERMEDIARIAS ANTES DO CALCULO (Pendente)
  # CDC PF - VEICULO 0KM - INTERMEDIARIAS ANTES DO CALCULO - ALTERANDO DATA DE VENCIMENTO (Pendente)


