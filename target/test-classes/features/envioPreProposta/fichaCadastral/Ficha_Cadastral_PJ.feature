#language: pt
  # charset: UTF-8

@fichapj

Funcionalidade: Envio de Pré-Proposta - Variações na Ficha Cadastral PJ
  Como um usuário do sistema
  Eu quero enviar uma pré-proposta com variações na ficha cadastral
  Para realizar uma simulação de financiamento

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
      | MARCA                | LEXUS                           |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | ES300H 2.5 16V AUT. (HYBRID)    |
      | TABELA FLEX          | NAO                             |
      | TABELA DE NEGOCIACAO | PLANO_FICHAPJ                   |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica      |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$90.000,00  |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.000,00   |
    E clico no botao Calcular
    E clico em Proximo - Simulacao

  Cenario: CT0001 - Ficha PJ - Proponente PJ - 1 Avalista PF Solteiro
    E preencho a Ficha Cadastral Proponente PJ
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | ARIEDSON CARLINO CHIOMA   |
      | RESPONSAVEL   | ANDRYA KAFEJIAN MOCHIZUKI |
      | ASSISTENTE    | ALMASONIA RUGILO IZEPPI   |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0002 - Ficha PJ - Proponente PJ - 2 Avalistas PF Solteiros
    E preencho a Ficha Cadastral Proponente PJ
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 2 Avalistas Solteiros
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0003 - Ficha PJ - Proponente PJ - 1 Avalista PF Casado
    E preencho a Ficha Cadastral Proponente PJ
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Casado
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0004 - Ficha PJ - Proponente PJ - 1 Avalista  PF Solteiro e 1 Avalista  PF Casado
    E preencho a Ficha Cadastral Proponente PJ
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro - 1 Avalista Casado
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0005 - Ficha PJ - Proponente PJ - 1 Avalista  PJ
    E preencho a Ficha Cadastral Proponente PJ
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0006 - Ficha PJ - Proponente PJ - 1 Avalista PF Solteiro e 1 Avalista PJ
    E preencho a Ficha Cadastral Proponente PJ
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0007 - Ficha PJ - Proponente PJ - 1 Avalista PF Casado e 1 Avalista PJ
    E preencho a Ficha Cadastral Proponente PJ
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Casado
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0008 - Ficha PJ - Proponente PJ - 2 Avalistas PF Casados
    E preencho a Ficha Cadastral Proponente PJ
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 2 Avalistas Casados
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0009 - Ficha PJ - Proponente PJ - Com mais de 1 representante legal e 1 avalista PJ
    E preencho a Ficha Cadastral Proponente PJ com 1 socio e 2 representantes legais
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0010 - Ficha PJ - Proponente PJ - Com 3 representantes legais e 2 Avalistas
    E preencho a Ficha Cadastral Proponente PJ com 1 socio e 3 representantes legais
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 2 Avalista
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0011 - Ficha PJ - Proponente PJ - Editar quadro executivo
    E preencho a Ficha Cadastral Proponente PJ com 1 socio e 0 representantes legais
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista
    Quando resolvo editar os dados do Socio
      |NOME         | SOCIO ALTERADO  |
      |PARTICIPACAO | 0,01%           |
      |CARGO        | CARGO ALTERADO  |
    Então verifico que os dados do Socio foram atualizados

  Cenario: CT0012 - Ficha PJ - Proponente PJ - Excluir quadro executivo
    E preencho a Ficha Cadastral Proponente PJ com 1 socio e 0 representantes legais
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista
    Quando excluir os dados do Socio
    Então verifico que o Socio foi removido da ficha

  Cenario: CT0013 - Ficha PJ - Proponente PJ - Editar avalista
    E preencho a Ficha Cadastral Proponente PJ com 1 socio e 0 representantes legais
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    Quando resolvo editar os dados do avalista
      |NOME              | AVALISTA ALTERADO         |
      |DATA DE NASCIMENTO| 18/08/1987                |
      |UF                | SP                        |
      |MUNICIPIO         | AGUDOS                    |
      |CONTATO           | 11969895261               |
      |EMAIL             | TESTEALTERADO@TESTE.COM   |
    Então verifico que o sistema alterou os dados do avalista

  Cenario: CT0014 - Ficha PJ - Proponente PJ - Exlcuir avalista
    E preencho a Ficha Cadastral Proponente PJ com 1 socio e 0 representantes legais
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    Quando excluir os dados do avalista
    Então verifico que o avalista foi removido da ficha


    #CENARIOS COM ENRIQUECIMENTO

  Cenario: CT0015 - Ficha PJ - Proponente Enriquecido PJ - 1 Avalista PF Solteiro
    E preencho a Ficha Cadastral Proponente PJ "proponente"
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0016 - Ficha PJ - Proponente PJ - 2 Avalistas Enriquecidos PF Solteiro
    E preencho a Ficha Cadastral Proponente PJ
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Enriquecido PF "avalistaSolteiro1"
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Enriquecido PF "avalistaSolteiro2"
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0017 - Ficha PJ - Proponente Enriquecido PJ - 2 Avalistas PF Casados
    E preencho a Ficha Cadastral Proponente PJ "proponente"
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 2 Avalistas Casados
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0018 - Ficha PJ - Proponente PJ - 2 Avalistas Enriquecidos PJ
    E preencho a Ficha Cadastral Proponente PJ
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista "proponente"
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista "avalista"
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0019 - Ficha PJ - Proponente PJ - 2 Avalistas PJ
    E preencho a Ficha Cadastral Proponente PJ com - Socio 1, Rep Legal 2, Procurador 0, Socio Rep 0, Socio Procurador 0, Rep Procurador 0
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista com - Socio 1, Rep Legal 2, Procurador 0, Socio Rep 0, Socio Procurador 0, Rep Procurador 0
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista com - Socio 1, Rep Legal 2, Procurador 0, Socio Rep 0, Socio Procurador 0, Rep Procurador 0
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0020 - Ficha PJ - Proponente PJ - 2 Avalistas PJ
    E preencho a Ficha Cadastral Proponente PJ com - Socio 0, Rep Legal 2, Procurador 0, Socio Rep 1, Socio Procurador 0, Rep Procurador 0
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista com - Rep Avalista 2, Rep Legal 1
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista com - Socio Avalista 1, Rep Legal 2
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0021 - Ficha PJ - Proponente PJ - 1 Avalista Enriquecido PF Solteiro e 1 Avalista PJ
    E preencho a Ficha Cadastral Proponente PJ
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Enriquecido PF "solteiro"
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0022 - Ficha PJ - Proponente PJ - 1 Avalista PF Casado e 1 Avalista PJ
    E preencho a Ficha Cadastral Proponente PJ com - Socio 0, Rep Legal 2, Procurador 0, Socio Rep 1, Socio Procurador 0, Rep Procurador 0
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista Rep PF - 1 Avalista Casado
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista com - Rep Avalista 2, Rep Legal 1
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0023 - Ficha PJ - Proponente Enriquecido PJ - 1 Avalista PF Casado e 1 Avalista PJ
    E preencho a Ficha Cadastral Proponente PJ "proponente"
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Casado
    E clico em Inserir Avalista - PJ
    E preencho a Ficha do Avalista PJ - 1 Avalista
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida