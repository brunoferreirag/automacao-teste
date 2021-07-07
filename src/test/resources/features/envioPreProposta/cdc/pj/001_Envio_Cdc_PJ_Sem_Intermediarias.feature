# language: pt
# charset: UTF-8
@cdcPj
@regressivo
Funcionalidade: Envio de Pré-Proposta CDC PJ Sem Intermediárias
  Eu como usuário gostaria de enviar uma proposta CDC para um proponente PJ, sem incluir intermediárias

  Contexto: Estou logado no sistema e acessei a tela de veículos
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
      | TIPO PESSOA         | PJ    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | TODAS |
    E eu clico em 'Proximo' na tela de configuracao
    E eu estou na pagina de veiculo

  # CDC PJ - VEICULO 0KM

  @cdcPjCT001
  Cenario: CT001 - CDC Parcela Desejada Sem Subsidio - Veículo 0km
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | CDC MENSAL PJ SEM SUBSIDIO      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica      |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.100,00   |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    #FICHA PJ
    E eu estou na pagina de ficha cadastral pj
    E eu preencho a ficha do proponente pj com dados gerados
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu preencho a ficha do avalista pf solteiro com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    #ENVIO
    E eu clico em 'Proximo' na tela de ficha cadastral pj
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cdcPjCT002
  Cenario: CT002 - CDC Parcela Desejada Com Subsidio Por Taxa - Veículo 0km
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | CDC MENSAL PJ SUBSIDIO VARIAVEL |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica      |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$101.000,00 |
      | VALOR ENTRADA | R$32.500,00  |
      | VALOR PARCELA | R$1.930,00   |
      | TAXA SUBSIDIO | 0,85%        |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    #FICHA PJ
    E eu estou na pagina de ficha cadastral pj
    E eu preencho a ficha do proponente pj com dados gerados
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu preencho a ficha do avalista pf solteiro com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    #ENVIO
    E eu clico em 'Proximo' na tela de ficha cadastral pj
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cdcPjCT003
  Cenario: CT003 - CDC Prazo Sem Subsidio - Veículo 0km
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CDC MENSAL PJ SEM SUBSIDIO      |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica      |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 36x          |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    #FICHA PJ
    E eu estou na pagina de ficha cadastral pj
    E eu preencho a ficha do proponente pj com dados gerados
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu preencho a ficha do avalista pf solteiro com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    #ENVIO
    E eu clico em 'Proximo' na tela de ficha cadastral pj
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cdcPjCT004
  Cenario: CT004 - CDC Prazo Com Subsidio Por Taxa - Veículo 0km
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CDC MENSAL PJ SUBSIDIO VARIAVEL |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica      |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 48x          |
      | TAXA SUBSIDIO | 0,90%        |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    #FICHA PJ
    E eu estou na pagina de ficha cadastral pj
    E eu preencho a ficha do proponente pj com dados gerados
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu preencho a ficha do avalista pf solteiro com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    #ENVIO
    E eu clico em 'Proximo' na tela de ficha cadastral pj
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @cdcPjCT005
  Cenario: CT005 - CDC Prazo Com Subsidio Por Valor - Veículo 0km
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2020                            |
      | ANO MODELO           | 2020                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA DE NEGOCIACAO | CDC MENSAL PJ SUBSIDIO VARIAVEL |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica      |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO  | R$100.000,00 |
      | VALOR ENTRADA  | R$30.000,00  |
      | PRAZO          | 42x          |
      | VALOR SUBSIDIO | R$3.745,00   |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    #FICHA PJ
    E eu estou na pagina de ficha cadastral pj
    E eu preencho a ficha do proponente pj com dados gerados
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu preencho a ficha do avalista pf solteiro com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    #ENVIO
    E eu clico em 'Proximo' na tela de ficha cadastral pj
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

    # CDC PJ - VEICULO USADO (Pendente)
