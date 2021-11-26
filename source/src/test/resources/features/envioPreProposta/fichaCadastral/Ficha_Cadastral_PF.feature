#language: pt
  # charset: UTF-8

@fichapf



Funcionalidade: Envio de Pré-Proposta - Variações na Ficha Cadastral PF
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


  Cenario: CT0001 - Ficha PF - Proponente Casado - Sem Avalista
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Casado"
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
        | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
        | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
        | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0002 - Ficha PF - Proponente Solteiro - 1 Avalista Solteiro
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
          | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
          | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
          | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0003 - Ficha PF - Proponente Solteiro - 2 Avalistas Solteiros
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0004 - Ficha PF - Proponente Solteiro - 1 Avalista Casado
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Casado
    E clico em Proximo - Proposta
      Quando seleciono Consultor e Responsavel
        | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
        | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
        | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0005 - Ficha PF - Proponente Solteiro - 2 Avalistas Casados
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Casado
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Casado
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  #PROPONENTE CASADO
  Cenario: CT0006 - Ficha PF - Proponente Casado - 1 Avalista Solteiro
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Casado"
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Nao"
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0007 - Ficha PF - Proponente Casado - 2 Avalistas Solteiros
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Casado"
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Nao"
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Nao"
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0008 - Ficha PF - Proponente Casado - 1 Avalista Casado
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Casado"
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Nao"
    E preencho a Ficha do Avalista PF - 1 Avalista Casado
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0009 - Ficha PF - Proponente Casado - 2 Avalistas Casados
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaa
    E preencho a Ficha Cadastral Proponente PF "Casado"
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Nao"
    E preencho a Ficha do Avalista PF - 1 Avalista Casado
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Nao"
    E preencho a Ficha do Avalista PF - 1 Avalista Casado
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0010 - Ficha PF - Proponente Casado - 1 Avalista Conjuge
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaa
    E preencho a Ficha Cadastral Proponente PF "Casado"
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Sim"
    E preencho a Ficha do Avalista PF - 1 Avalista Conjuge
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0011 - Ficha PF - Proponente Casado - 1 Avalista Solteiro - 1 Avalista Conjuge
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaa
    E preencho a Ficha Cadastral Proponente PF "Casado"
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Nao"
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Sim"
    E preencho a Ficha do Avalista PF - 1 Avalista Conjuge
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0012 - Ficha PF - Proponente Casado - 1 Avalista Conjuge - 1 Avalista Casado
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaa
    E preencho a Ficha Cadastral Proponente PF "Casado"
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Sim"
    E preencho a Ficha do Avalista PF - 1 Avalista Conjuge
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Casado
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  Cenario: CT0013 - Ficha PF - Proponente outra Nacionalidade sem avalista
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaa
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
      | DATA ADMISSAO       | MAIS DE 5 ANOS      |
    E preencho a Ficha Cadastral PF - Endereco Profissional
    E preencho a Ficha Cadastral PF - Renda
      | SALARIO            | R$8.500,00 |
    E preencho a Ficha Cadastral PF - Patrimonio
      | PATRIMONIO         | R$750.000,00 |
    E preencho a Ficha Cadastral PF - Dados Conta
      | BANCO     | 0748 - BCO COOPERATIVO SICREDI S.A.   |
      | AGENCIA   | 1451                                  |
      | CONTA     | 52410                                 |
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

  #FICHA COM ENRIQUECIMENTO
  Cenario: CT0014 - Ficha PF - Proponente Enriquecido Solteiro - 1 Avalista Solteiro
    E preencho os dados do proponente Enriquecido PF "solteiro"
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaa
    E preencho a Ficha Cadastral Proponente Enriquecido PF
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Solteiro
    E clico em Proximo - Propostaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

 Cenario: CT0015 - Ficha PF - Proponente Solteiro - 1 Avalista Enriquecido Solteiro
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaa
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Enriquecido PF "solteiro"
    E clico em Proximo - Propostaaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT0016 - Ficha PF - Proponente Enriquecido Solteiro - 1 Avalista Casado
    E preencho os dados do proponente Enriquecido PF "solteiro"
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaaa
    E preencho a Ficha Cadastral Proponente Enriquecido PF
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Casado
    E clico em Proximo - Propostaaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT0017 - Ficha PF - Proponente Solteiro - 2 Avalistas Enriquecidos Casados
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaaa
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Enriquecido PF "casado1"
    E clico em Inserir Avalista - PF
    E preencho a Ficha do Avalista PF - 1 Avalista Enriquecido PF "casado2"
    E clico em Proximo - Propostaaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT0018 - Ficha PF - Proponente Casado - 2 Avalistas Enriquecidos Casados
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaaa
    E preencho a Ficha Cadastral Proponente PF "Casado"
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Nao"
    E preencho a Ficha do Avalista PF - 1 Avalista Enriquecido PF "casado1"
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Nao"
    E preencho a Ficha do Avalista PF - 1 Avalista Enriquecido PF "casado2"
    E clico em Proximo - Propostaaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida

Cenario: CT0019 - Ficha PF - Proponente Enriquecido Casado - 1 Avalista Conjuge
    E preencho os dados do proponente Enriquecido PF "casado1"
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaaa
    E preencho a Ficha Cadastral Proponente Enriquecido PF
    E clico em Inserir Avalista - PF
    E seleciono Inserir Avalista Conjuge "Sim"
    E preencho a Ficha do Avalista PF - 1 Avalista Conjuge
    E clico em Proximo - Propostaaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida


  Cenario: CT0020 - Ficha PF - Proponente outra Nacionalidade
    E preencho os dados do proponente Enriquecido PF "outraNacionalidade"
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Propostaaa
    E clico em Proximo - Propostaaa
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida