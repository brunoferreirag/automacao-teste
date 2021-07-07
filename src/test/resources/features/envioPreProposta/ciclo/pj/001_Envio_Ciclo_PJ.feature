# language: pt
# charset: UTF-8
@cicloPj
@regressivo
Funcionalidade: Envio de Pré-Proposta Ciclo PJ
  Eu como usuário gostaria de enviar uma proposta Ciclo Toyota para um proponente PJ


  @cicloPjCT001
  Cenario: CT001 - Executar Simulacao CDC Ciclo Parcela Desejada Sem Subsidio
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
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                         |
      | MARCA                | LEXUS                       |
      | ANO FABRICACAO       | 2020                        |
      | ANO MODELO           | 2020                        |
      | MODELO VERSAO        | CT200H  1.8 16V HIBRID AUT. |
      | TABELA DE NEGOCIACAO | CICLO PJ SEM SUBSIDIO       |
      | UF EMPLACAMENTO      | ES - Todas                  |
      | CODIGO SIMULACAO     | 0                           |
      | DIA DE PAGAMENTO     | 1 mês após a formalização   |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica   |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.400,00   |
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

  @cicloPjCT002
  Cenario: CT002 - Executar Simulacao CDC Ciclo Parcela Desejada Com Subsidio Por Taxa
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
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                         |
      | MARCA                | LEXUS                       |
      | ANO FABRICACAO       | 2020                        |
      | ANO MODELO           | 2020                        |
      | MODELO VERSAO        | CT200H  1.8 16V HIBRID AUT. |
      | TABELA DE NEGOCIACAO | CICLO PJ SUBSIDIO VARIAVEL  |
      | UF EMPLACAMENTO      | ES - Todas                  |
      | DIA DE PAGAMENTO     | 1 mês após a formalização   |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica   |
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

  @cicloPjCT003
  Cenario: CT003 - Executar Simulacao CDC Ciclo Residual Sem Subsidio
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
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                         |
      | MARCA                | LEXUS                       |
      | ANO FABRICACAO       | 2020                        |
      | ANO MODELO           | 2020                        |
      | MODELO VERSAO        | CT200H  1.8 16V HIBRID AUT. |
      | TABELA DE NEGOCIACAO | CICLO PJ SEM SUBSIDIO       |
      | UF EMPLACAMENTO      | ES - Todas                  |
      | CODIGO SIMULACAO     | 0                           |
      | DIA DE PAGAMENTO     | 1 mês após a formalização   |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica   |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Parcela
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.400,00   |
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

  @cicloPjCT004
  Cenario: CT004 - Executar Simulacao CDC Ciclo Residual Com Subsidio Por Taxa
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
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                         |
      | MARCA                | LEXUS                       |
      | ANO FABRICACAO       | 2020                        |
      | ANO MODELO           | 2020                        |
      | MODELO VERSAO        | CT200H  1.8 16V HIBRID AUT. |
      | TABELA DE NEGOCIACAO | CICLO PJ SUBSIDIO VARIAVEL  |
      | UF EMPLACAMENTO      | ES - Todas                  |
      | DIA DE PAGAMENTO     | 1 mês após a formalização   |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica   |
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

  @cicloPjCT005
  Cenario: CT005 - Executar Simulacao CDC Ciclo Residual Com Subsidio Por Valor
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
    E eu seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                         |
      | MARCA                | LEXUS                       |
      | ANO FABRICACAO       | 2020                        |
      | ANO MODELO           | 2020                        |
      | MODELO VERSAO        | CT200H  1.8 16V HIBRID AUT. |
      | TABELA DE NEGOCIACAO | CICLO PJ SUBSIDIO VARIAVEL  |
      | UF EMPLACAMENTO      | ES - Todas                  |
      | DIA DE PAGAMENTO     | 1 mês após a formalização   |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica   |
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