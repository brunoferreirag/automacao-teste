# language: pt
# charset: UTF-8
@massaPfAssinaturaPf

Funcionalidade: Criar massa assinatura PF


  @massaPfAssinaturaPfCT001
  Cenario: CT001 - Massa Proponente PF
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
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica         |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 36x          |
    E eu clico no botao 'Calcular'
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

  @massaPfAssinaturaPfCT002
  Cenario: CT002 - Massa Proponente PF + 1 Avalista PF
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
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 36x          |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha
    E eu preencho dados do proponente
      | SEXO                        | F         |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    #FICHA PF
    E eu estou na pagina de ficha cadastral pf
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    E eu clico em inserir avalista pf
    #AVALISTA PF
    E eu preencho a ficha do avalista pf solteiro com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @massaPfAssinaturaPfCT003
  Cenario: CT003 - Massa Proponente PF + 2 Avalistas PF
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
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E eu clico em 'Proximo' na tela de veiculo
    E eu estou na pagina de simulacao
    E eu seleciono a aba Prazo
    E eu preencho os valores da simulacao
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | PRAZO         | 36x          |
    E eu clico no botao 'Calcular'
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
    #FICHA PF
    E eu preencho a ficha do proponente pf solteiro com dados gerados
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu preencho a ficha do avalista pf solteiro com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu preencho a ficha do avalista pf solteiro com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio