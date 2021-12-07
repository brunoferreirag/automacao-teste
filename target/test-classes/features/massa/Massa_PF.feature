#language: pt
# charset: UTF-8
@massapf

  Funcionalidade: Criar massa PF

    Contexto: Acessar a tela de simulação com usuario representante
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
        | CICLO TOYOTA         | NAO                             |
        | MARCA                | TOYOTA                          |
        | ANO FABRICACAO       | 2021                            |
        | ANO MODELO           | 2021                            |
        | MODELO VERSAO        | COROLLA ALTIS 2.0 FLEX 16V AUT. |
        | TABELA FLEX          | NAO                             |
        | TABELA DE NEGOCIACAO | PLANO_FICHAPF                   |
        | UF EMPLACAMENTO      | ES - Todas                      |
        | CODIGO SIMULACAO     | 0                               |
        | DIA DE PAGAMENTO     | 1 mês após a formalização       |
        | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
      E clico em Proximo - Veiculo
      E preencho os valores da simulacao - parcela
        | VALOR VEICULO | R$100.000,00 |
        | VALOR ENTRADA | R$30.000,00  |
        | VALOR PARCELA | R$2.100,00   |
      E clico no botao Calcular
      E opto por não incluir o seguro auto integrado
      E clico em Proximo - Simulacao

     #Proponente PF Solteiro
    Cenario: CT0001 - Massa Proponente PF Solteiro
      E preencho os dados do proponente PF
        | SEXO                        | M             |
        | CEP RESIDENCIAL             | 29114-360     |
        | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
        | VEICULO USO COMERCIAL       | SIM           |
        | TAXI OU FROTA               | SIM           |
      E clico em Proximo - Proposta
      E preencho a Ficha Cadastral Proponente PF "Solteiro"
      E clico em Proximo - Proposta
      E gero massa PF "solteiro"
      Quando seleciono Consultor e Responsavel
        | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
        | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
        | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
      E clico no botao Enviar Pre-Proposta
      Entao mensagem " Sua proposta foi enviada! " deve ser exibida

      #Avalista PF Casado
    Cenario: CT0002 - Massa Avalista PF Casado 1
      E preencho os dados do proponente PF
        | SEXO                        | M             |
        | CEP RESIDENCIAL             | 29114-360     |
        | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
        | VEICULO USO COMERCIAL       | SIM           |
        | TAXI OU FROTA               | SIM           |
      E clico em Proximo - Proposta
      E preencho a Ficha Cadastral Proponente PF "Casado"
      E clico em Proximo - Proposta
      E gero massa PF "casado1"
      Quando seleciono Consultor e Responsavel
        | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
        | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
        | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
      E clico no botao Enviar Pre-Proposta
      Entao mensagem " Sua proposta foi enviada! " deve ser exibida

      #Avalista PF Casado
    Cenario: CT0003 - Massa Avalista PF Casado 2
      E preencho os dados do proponente PF
        | SEXO                        | M             |
        | CEP RESIDENCIAL             | 29114-360     |
        | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
        | VEICULO USO COMERCIAL       | SIM           |
        | TAXI OU FROTA               | SIM           |
      E clico em Proximo - Proposta
      E preencho a Ficha Cadastral Proponente PF "Casado"
      E clico em Proximo - Proposta
      E gero massa PF "casado2"
      Quando seleciono Consultor e Responsavel
        | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
        | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
        | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
      E clico no botao Enviar Pre-Proposta
      Entao mensagem " Sua proposta foi enviada! " deve ser exibida

    #Avalista PF Solteiro
    Cenario: CT0003 - Massa Avalista PF Solteiro 1
      E preencho os dados do proponente PF
        | SEXO                        | M             |
        | CEP RESIDENCIAL             | 29114-360     |
        | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
        | VEICULO USO COMERCIAL       | SIM           |
        | TAXI OU FROTA               | SIM           |
      E clico em Proximo - Proposta
      E preencho a Ficha Cadastral Proponente PF "Solteiro"
      E clico em Proximo - Proposta
      E gero massa PF "avalistaSolteiro1"
      Quando seleciono Consultor e Responsavel
        | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
        | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
        | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
      E clico no botao Enviar Pre-Proposta
      Entao mensagem " Sua proposta foi enviada! " deve ser exibida

    #Avalista PF Solteiro
    Cenario: CT0003 - Massa Avalista PF Solteiro 2
      E preencho os dados do proponente PF
        | SEXO                        | M             |
        | CEP RESIDENCIAL             | 29114-360     |
        | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
        | VEICULO USO COMERCIAL       | SIM           |
        | TAXI OU FROTA               | SIM           |
      E clico em Proximo - Proposta
      E preencho a Ficha Cadastral Proponente PF "Solteiro"
      E clico em Proximo - Proposta
      E gero massa PF "avalistaSolteiro2"
      Quando seleciono Consultor e Responsavel
        | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
        | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
        | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
      E clico no botao Enviar Pre-Proposta
      Entao mensagem " Sua proposta foi enviada! " deve ser exibida

     Cenario: CT0004 - Massa Proponente outra Nacionalidade
      E preencho os dados do proponente PF
        | SEXO                        | M             |
        | CEP RESIDENCIAL             | 29114-360     |
        | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
        | VEICULO USO COMERCIAL       | SIM           |
        | TAXI OU FROTA               | SIM           |
      E clico em Proximo - Proposta
      E preencho a Ficha Cadastral PF - Dados Gerais
        | NACIONALIDADE | JAPAO         |
        | ESTADO CIVIL  | Solteiro (a)  |
      E preencho a Ficha Cadastral PF - Contato
        | CELULAR       | 11983915851          |
        | TELEFONE FIXO | 1133333333           |
        | EMAIL         | guilhermes@gft.com   |
      E preencho a Ficha Cadastral PF - Endereco Residencial
        | NUMERO  | 123  |
      E preencho a Ficha Cadastral PF - Documentos
        | RG RNE        | 4567891023       |
        | ORGAO EMISSOR | SJS             |
        | UF EMISSAO    | ES              |
        | DATA EMISSAO  | 20/05/2001      |
        | NOME DA MAE   | MARIA DA SILVA  |
      E preencho a Ficha Cadastral PF - Dados Profissionais
        | PROFISSAO           | PROFESSOR INFANTIL  |
        | OCUPACAO            | OUTROS              |
        | NOME DA EMPRESA     | ESCOLA MUNICIPAL    |
        | DATA ADMISSAO       |  2 A 5 ANOS         |
      E preencho a Ficha Cadastral PF - Endereco Profissional
      E preencho a Ficha Cadastral PF - Renda
        | SALARIO            | R$8.500,00 |
      E preencho a Ficha Cadastral PF - Patrimonio
        | PATRIMONIO         | R$750.000,00 |
      E preencho a Ficha Cadastral PF - Dados Conta
        | BANCO     | 0237 - BCO BRADESCO S.A.       |
        | AGENCIA   | 0897                           |
        | CONTA     | 768442                         |
      E gero massa PF "outraNacionalidade"
      E clico em Proximo - Proposta
       Quando seleciono Consultor e Responsavel
         | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
         | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
         | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
      E clico no botao Enviar Pre-Proposta
      Entao mensagem " Sua proposta foi enviada! " deve ser exibida

