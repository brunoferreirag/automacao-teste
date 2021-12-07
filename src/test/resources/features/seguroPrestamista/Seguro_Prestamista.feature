#language: pt
  # charset: UTF-8

@seguroPrestamista

Funcionalidade: Seguro Prestamista
  Como um usuário do sistema
  Eu quero validar a inclusão automática do seguro Prestamista na simulação da proposta
  Para validar parametros e regras do seguro

  Cenário: CT001 - Validar oferta de seguro prestamista para PJ
    Dado eu esteja na tela de login
    E que esteja logado com usuario representante
    E eu seleciono a concessionaria
      | CODIGO LOJA | VONICE ALFONZO MAISE - 75 |
    E clico em Proximo
    E clico em Faca Uma Simulacao
    E clico no step de Configuracao
    E seleciono as configuracoes
      | TIPO PESSOA         | PJ    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | LEXUS                           |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | LEXUS ES 300H                   |
      | TABELA DE NEGOCIACAO | CDC_CICLOLEXUSPRIVILEGE_PARCELA_SEM_SUBSIDIO_MENSAL           |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica      |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.500,00   |
    Quando clico no botao Calcular
    Então o sistema não deve incluir seguro ao carrinho

  Cenário: CT002 - Validar trava de remoção do seguro para perfil Vendedor - Remove SPF / Não remove SVP
    Dado eu esteja na tela de login
    E que esteja logado com usuario representante
    E eu seleciono a concessionaria
      | CODIGO LOJA | VONICE ALFONZO MAISE - 75 |
    E clico em Proximo
    E clico em Faca Uma Simulacao
    E clico no step de Configuracao
    E seleciono as configuracoes
      | TIPO PESSOA         | PF    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E seleciono as opcoes de veiculo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | LEXUS                           |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | LEXUS ES 300H                   |
      | TABELA DE NEGOCIACAO | CDC_CICLOLEXUSPRIVILEGE_PARCELA_SEM_SUBSIDIO_MENSAL           |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.500,00   |
    Quando clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E expando a opção de Seguro no carrinho
    Então verifico que o sistema incluiu automaticamente o seguro Prestamista ao carrinho
      | SEGURO  | Seguro Proteção Financeira - SPF |
    E deve permitir que o vendedor remova o seguro do carrinho
    Quando clico na opção de remover
    Então o Sistema exclui o seguro e exibe a mensagem " Seguro Proteção Financeira substituído por Seguro de Vida Prestamista. "
    E verifico que o sistema incluiu automaticamente o seguro Prestamista ao carrinho
      | SEGURO  | Seguro Vida Prestamista - SVP |
    E não deve permitir que o vendedor remova o seguro do carrinho
