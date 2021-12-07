#language: pt
# charset: UTF-8
@massapj

Funcionalidade: Criar massa PJ

  Contexto: Acessar a tela de simulação com usuario representante
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
      | CICLO TOYOTA         | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | PLANO_FICHAPJ                   |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica      |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$100.000,00 |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.100,00   |
    E clico no botao Calcular
    E clico em Proximo - Simulacao

    #PROPONENTE PJ
    Cenario: CT0001 - Massa Proponente Enriquecido PJ
      E preencho a Ficha Cadastral Proponente PJ
      E gero massa PJ "proponente"
      E clico em Inserir Avalista - PJ
      E preencho a Ficha do Avalista PJ - 1 Avalista
      E clico em Proximo - Proposta
      Quando seleciono Consultor e Responsavel
        | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
        | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
        | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
      E clico no botao Enviar Pre-Proposta
      Entao mensagem " Sua proposta foi enviada! " deve ser exibida

    #AVALISTA PJ
    Cenario: CT0002 - Massa Proponente Enriquecido PJ
      E preencho a Ficha Cadastral Proponente PJ
      E gero massa PJ "avalista"
      E clico em Inserir Avalista - PJ
      E preencho a Ficha do Avalista PJ - 1 Avalista
      E clico em Proximo - Proposta
      Quando seleciono Consultor e Responsavel
        | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
        | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
        | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
      E clico no botao Enviar Pre-Proposta
      Entao mensagem " Sua proposta foi enviada! " deve ser exibida
