#language: pt
  # charset: UTF-8
@itensfinanciaveis


Funcionalidade: Itens financiaveis
  Como um usuário do sistema
  Eu quero validar a inclusão de itens financiáveis
  Para realizar simulações de financiamento

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

  Esquema do Cenario: CT001 - Adicionar item financiável a pré-proposta
    E clico na opção de incluir Itens Financiáveis
    E Seleciono o seguinte "<item>"
    E informo o valor do item
      | VALOR DO ITEM | 1.000,00 |
    E clico em adicionar
    Quando clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    Entao o item financiavel é adicionado no carrinho
    Exemplos:
      |item                 |
      |ACESSORIOS           |
      |BLINDAGEM            |
      |DESPACHANTE          |
      |REVISAO NA MEDIDA    |
      |SERVICOS             |

  Cenario: CT002 - Editar item financiável a pré-proposta
    E clico na opção de incluir Itens Financiáveis
    E Seleciono o seguinte item
      | ITEM  | ACESSORIOS  |
    E informo o valor do item
      | VALOR DO ITEM | 1.000,00 |
    E clico em adicionar
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E resolvo editar o valor do item
      | VALOR DO ITEM | 3.500,00 |
    Quando clico em adicionar
    Então a mensagem " Valor do item financiável ACESSORIOS atualizado. " é exibida
    Quando clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    Então o valor é atualizado no carrinho

  Cenario: CT003 - Adicionar mais de um item financiável a pré-proposta
    E clico na opção de incluir Itens Financiáveis
    E Seleciono o seguinte item
      | ITEM  | ACESSORIOS  |
    E informo o valor do item
      | VALOR DO ITEM | 1.000,00 |
    E clico em adicionar
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    Quando clico em incluir mais um item
    Então verifico que o seguinte item não foi listado novamente
      | ITEM  | ACESSORIOS  |

  Cenario: CT004 - Remover um item financiável a pré-proposta
    E clico na opção de incluir Itens Financiáveis
    E Seleciono o seguinte item
      | ITEM  | ACESSORIOS  |
    E informo o valor do item
      | VALOR DO ITEM | 1.000,00 |
    E clico em adicionar
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    Quando clico em excluir o item
    Então o sistema exclui o item e a mensagem " Valor do item financiável ACESSORIOS removido. " é exibida

  Cenario: CT005 - Enviar proposta com item financiável
    E clico na opção de incluir Itens Financiáveis
    E Seleciono o seguinte item
      | ITEM  | ACESSORIOS  |
    E informo o valor do item
      | VALOR DO ITEM | 1.000,00 |
    E clico em adicionar
    E clico no botao Calcular
    E opto por não incluir o seguro auto integrado
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    E clico em Proximo - Proposta
    E preencho a Ficha Cadastral Proponente PF "Solteiro"
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida
    E ao clicar na opção de consultar propostas
    Quando realizar a busca através do número da proposta
    Então o sistema exibe a proposta com o item financiavel e valor informados
      | ITEM   | ACESSORIOS  |
      | VALOR  | 1.000,00    |