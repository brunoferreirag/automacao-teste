# language: pt
# charset: UTF-8
@fichaPf
@fichaCadastral
@regressivo

Funcionalidade: Envio de Pré-Proposta - Variações na Ficha Cadastral PF
  Eu como usuário gostaria de enviar uma proposta proponente PF, com Variaçoes na Ficha Cadastral

  Contexto: Acessar a tela de ficha cadastral
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
      | PRAZO         | 12x          |
    E eu clico no botao 'Calcular'
    E eu clico em 'Proximo' na tela de simulacao
    E eu estou na pagina de pre ficha

  #PROPONENTE SOLTEIRO + VARIACOES DE AVALISTA

  @fichaPfCT001
  Cenario: CT001 - Ficha PF - Proponente Solteiro - 1 Avalista Solteiro
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

  @fichaPfCT002
  Cenario: CT002 - Ficha PF - Proponente Solteiro - 2 Avalistas Solteiros
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

  @fichaPfCT003
  Cenario: CT003 - Ficha PF - Proponente Solteiro - 1 Avalista Casado
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
    E eu preencho a ficha do avalista pf casado com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @fichaPfCT004
  Cenario: CT004 - Ficha PF - Proponente Solteiro - 2 Avalistas Casados
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
    E eu preencho a ficha do avalista pf casado com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu preencho a ficha do avalista pf casado com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  #PROPONENTE CASADO + VARIACOES DE AVALISTA

  @fichaPfCT005
  Cenario: CT005 - Ficha PF - Proponente Casado - 1 Avalista Solteiro
    E eu preencho dados do proponente
      | SEXO                        | F         |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    #FICHA PF
    E eu preencho a ficha do proponente pf casado com dados gerados
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu nao quero incluir o conjuge como avalista
    E eu preencho a ficha do avalista pf solteiro com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @fichaPfCT006
  Cenario: CT006 - Ficha PF - Proponente Casado - 2 Avalistas Solteiros
    E eu preencho dados do proponente
      | SEXO                        | F         |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    #FICHA PF
    E eu preencho a ficha do proponente pf casado com dados gerados
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu nao quero incluir o conjuge como avalista
    E eu preencho a ficha do avalista pf solteiro com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu nao quero incluir o conjuge como avalista
    E eu preencho a ficha do avalista pf solteiro com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @fichaPfCT007
  Cenario: CT007 - Ficha PF - Proponente Casado - 1 Avalista Casado
    E eu preencho dados do proponente
      | SEXO                        | F         |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    #FICHA PF
    E eu preencho a ficha do proponente pf casado com dados gerados
    #AVALSITA PF
    E eu clico em inserir avalista pf
    E eu nao quero incluir o conjuge como avalista
    E eu preencho a ficha do avalista pf casado com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @fichaPfCT008
  Cenario: CT008 - Ficha PF - Proponente Casado - 2 Avalistas Casados
    E eu preencho dados do proponente
      | SEXO                        | F         |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    #FICHA PF
    E eu preencho a ficha do proponente pf casado com dados gerados
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu nao quero incluir o conjuge como avalista
    E eu preencho a ficha do avalista pf casado com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu nao quero incluir o conjuge como avalista
    E eu preencho a ficha do avalista pf casado com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  #PROPONENTE CASADO + AVALISTA CONJUGE + VARIACOES DE AVALISTA (PENDENTE)
  @fichaPfCT009
  @avalistaConjuge
  Cenario: CT009 - Ficha PF - Proponente Casado - 1 Avalista Conjuge
    E eu preencho dados do proponente
      | SEXO                        | F         |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    #FICHA PF
    E eu preencho a ficha do proponente pf casado com dados gerados
    #AVALISTA CONJUGE
    E eu clico em inserir avalista pf
    E eu incluo o conjuge como avalista
    E eu preencho a ficha do avalista conjuge
    E eu clico em 'Salvar' na ficha do avalista pf
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @fichaPfCT010
  @avalistaConjuge
  Cenario: CT010 - Ficha PF - Proponente Casado - 1 Avalista Solteiro - 1 Avalista Conjuge
    E eu preencho dados do proponente
      | SEXO                        | F         |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    #FICHA PF
    E eu preencho a ficha do proponente pf casado com dados gerados
    #AVALISTA PF
    E eu clico em inserir avalista pf
    E eu nao quero incluir o conjuge como avalista
    E eu preencho a ficha do avalista pf solteiro com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    #AVALISTA CONJUGE
    E eu clico em inserir avalista pf
    E eu incluo o conjuge como avalista
    E eu preencho a ficha do avalista conjuge
    E eu clico em 'Salvar' na ficha do avalista pf
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  @fichaPfCT011 @avalistaConjuge
  Cenario: CT011 - Ficha PF - Proponente Casado - 1 Avalista Conjuge - 1 Avalista Casado
    E eu preencho dados do proponente
      | SEXO                        | F         |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    #FICHA PF
    E eu preencho a ficha do proponente pf casado com dados gerados
    #AVALISTA CONJUGE
    E eu clico em inserir avalista pf
    E eu incluo o conjuge como avalista
    E eu preencho a ficha do avalista conjuge
    E eu clico em 'Salvar' na ficha do avalista pf
    #AVALSITA PF
    E eu clico em inserir avalista pf
    E eu nao quero incluir o conjuge como avalista
    E eu preencho a ficha do avalista pf casado com dados gerados
    E eu clico em 'Salvar' na ficha do avalista pf
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio

  #PROPONENTE DE NACIONALIDADE DIFERENTE DE BRASILEIRA
  @@fichaPfCT012 @nacionalidade
  Cenario: CT012 - Ficha PF - Proponente outra Nacionalidade
    E eu preencho dados do proponente
      | SEXO                        | F         |
      | CEP RESIDENCIAL             | 29114-360 |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM       |
      | VEICULO USO COMERCIAL       | SIM       |
      | TAXI OU FROTA               | SIM       |
    E eu clico em 'Proximo' na tela de pre ficha
    E eu estou na pagina de ficha cadastral pf
    #FICHA PF
    E eu preencho os dados gerais do proponente pf
      | NACIONALIDADE | JAPAO    |
      | ESTADO CIVIL  | SOLTEIRO |
    E eu preencho o contato do proponente pf
      | CELULAR       | 11983915851          |
      | TELEFONE FIXO | 1133333333           |
      | EMAIL         | FABIO.DANTAS@GFT.COM |
    E eu preencho o endereco residencial do proponente pf
      | NUMERO | 123 |
    E eu preencho os documentos do proponente pf
      | RG RNE        | 4567891023    |
      | ORGAO EMISSOR | ES            |
      | UF EMISSAO    | ES            |
      | DATA EMISSAO  | 15/05/2019    |
      | NOME MAE      | ELVIRA TALBOT |
    E eu preencho os dados profissionais do proponente pf
      | PROFISSAO    | ADMINISTRADOR |
      | OCUPACAO     | OUTROS        |
      | NOME EMPRESA | BANCO TOYOTA  |
    E eu copio o endereco profissional do proponente pf
    E eu preencho a renda do proponente pf
      | SALARIO | 7.000,00 |
    E eu preencho o patrimonio do proponente pf
      | PATRIMONIO | 100.000,00 |
    E eu preencho os dados bancarios do proponente pf
      | BANCO   | 0075 - ABN Amro |
      | AGENCIA | 0               |
      | CONTA   | 12345-6         |
    E eu clico em 'Proximo' na tela de ficha cadastral pf
    E eu estou na pagina de envio de proposta
    E eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio
    Quando eu clico no botao 'Enviar Pre-Proposta' na tela de envio
    E eu estou na pagina de confirmacao de envio
    Entao eu visualizo mensagem de sucesso no envio
