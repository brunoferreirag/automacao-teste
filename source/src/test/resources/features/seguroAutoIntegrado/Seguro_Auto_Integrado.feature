#language: pt
#charset: UTF-8

Funcionalidade: Seguro auto integrado
  Como um usuário do sistema
  Eu quero validar cotações de seguro auto integrado
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
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA XEI 2.0 FLEX 16V AUT.   |
      | TABELA DE NEGOCIACAO | CICLO_122_SP                   |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E clico em Proximo - Veiculo
    E preencho os valores da simulacao - parcela
      | VALOR VEICULO | R$60.000,00  |
      | VALOR ENTRADA | R$30.000,00  |
      | VALOR PARCELA | R$2.000,00   |

  Cenario: CT001 - Validar oferta com vigencia de 12 meses (contrato de 11 meses)
    E clico no Step de configurações do veículo
    E altero as configurações do veículo
      | CICLO                | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA XEI 2.0 FLEX 16V AUT.   |
      | TABELA DE NEGOCIACAO | NOVOS_122                       |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E clico em Proximo - Veiculo
    E informo o prazo - Aba prazo
      | PRAZO | 11     |
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto integrado |
    E informo os dados do cliente
      |CONDUTORES ENTRE 18 E 25| não  |
      |USO COMERCIAL           | não  |
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  |11      |
    Então o sistema exibe somente as opções de seguro com vigência de 12 meses

  Cenario: CT002 - Validar oferta com vigencia de 12 meses (contrato de 49 meses)
    E clico no Step de configurações do veículo
    E altero as configurações do veículo
      | CICLO                | NAO                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA XEI 2.0 FLEX 16V AUT.   |
      | TABELA DE NEGOCIACAO | NOVOS_122_SEM_PLUS              |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Fisica        |
    E clico em Proximo - Veiculo
    E informo o prazo - Aba prazo
      | PRAZO | 49     |
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto integrado |
    E informo os dados do cliente
      |CONDUTORES ENTRE 18 E 25| não  |
      |USO COMERCIAL           | não  |
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  |49      |
    Então o sistema exibe somente as opções de seguro com vigência de 12 meses

  Cenario: CT003 - Validar oferta com vigencia de 12 meses e do contrato (contrato de 12 meses)
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto integrado |
    E informo os dados do cliente
      |CONDUTORES ENTRE 18 E 25| não  |
      |USO COMERCIAL           | não  |
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 12  |
    Então o sistema exibe as opções de seguro com vigência de 12 meses e do contrato

  Cenario: CT004 - Validar oferta com vigencia de 12 meses e do contrato (com 48 meses)
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto integrado |
    E informo os dados do cliente
      |CONDUTORES ENTRE 18 E 25| não  |
      |USO COMERCIAL           | não  |
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 48  |
    Então o sistema exibe as opções de seguro com vigência de 12 meses e do contrato
  @seguroautointegrado
  Cenario: CT005 - Validar modal de detalhes do seguro com vigencia de 12 meses
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto integrado |
    E informo os dados do cliente
      |CONDUTORES ENTRE 18 E 25| não  |
      |USO COMERCIAL           | não  |
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 12  |
    Então o sistema exibe as opções de seguro com vigência de 12 meses e do contrato
    Quando clico em Detalhes da cobertura
    Então o sistema exibe modal com o tipo de vigência e detalhes da oferta

  Cenario: CT006 - Validar modal de detalhes do seguro com vigencia do contrato
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    Quando clico em Detalhes da cobertura
    Então o sistema exibe modal com o tipo de vigência e detalhes da oferta

  Cenario: CT007 - Validar inserção do seguro de 12 meses no carrinho
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 12 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    Quando clico em adicionar uma opção de oferta
    Então o sistema exibe a mensagem " Seguro Auto Integrado adicionado na parcela. "
    E as informações da oferta são exibidas no carrinho

  Cenario: CT008 - Validar inserção do seguro com vigencia do contrato no carrinho
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    Quando clico em adicionar uma opção de oferta
    Então o sistema exibe a mensagem " Seguro Auto Integrado adicionado na parcela. "
    E as informações da oferta são exibidas no carrinho

  Cenario: CT009 - Validar modal de detalhes do seguro a partir do carrinho - Oferta com vigencia do contrato
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    Quando clico em adicionar uma opção de oferta
    Então as informações da oferta são exibidas no carrinho
    Quando clico em detalhes da oferta de dentro do carrinho
    Então o sistema exibe modal com o tipo de vigência e detalhes da oferta

  Cenario: CT010 - Validar modal de detalhes do seguro a partir do carrinho - Oferta com vigencia de 12 meses
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 12 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    Quando clico em adicionar uma opção de oferta
    Então as informações da oferta são exibidas no carrinho
    Quando clico em detalhes da oferta de dentro do carrinho
    Então o sistema exibe modal com o tipo de vigência e detalhes da oferta

  Cenario: CT011 - Validar exclusão do seguro do carrinho
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    Quando clico em adicionar uma opção de oferta
    Então as informações da oferta são exibidas no carrinho
    Quando clico em remover a oferta do carrinho
    Então o sistema exclui a oferta e mensagem " Valor do Seguro Auto Integrado foi removido da parcela. " é exibida
    E o sistema exibe opções de seguro com vigência do contrato

  Cenario: CT012 - Validar opção de não inclusão do seguro
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    E o botão Próximo está desabilitado
    Quando seleciono a opção "Não quero inserir um seguro"
    Então o botão Próximo é habilitado
    Quando clico em Proximo - Simulacao
    Então o sistema exibe tela de reforço de seguros

  #TELA DE REFORÇO DO SEGURO AUTO
  Cenario: CT013 - Tela de reforço - Validar oferta com vigencia de 12 meses (contrato de 12 meses)
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 12 X |
    Então o sistema exibe opções de seguro com vigência de 12 meses
    E seleciono a opção "Não quero inserir um seguro"
    Quando clico em Proximo - Simulacao
    Então o sistema exibe opções de seguro com vigência de 12 meses na tela de reforço

  Cenario: CT014 - Tela de reforço - Validar oferta com vigencia do contrato (contrato de 14 meses)
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    E seleciono a opção "Não quero inserir um seguro"
    Quando clico em Proximo - Simulacao
    Então o sistema exibe opções de seguro com vigência do contrato na tela de reforço

  Cenario: CT015 - Tela de reforço - Validar modal de detalhes do seguro com vigencia de 12 meses
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 12 X |
    Então o sistema exibe opções de seguro com vigência de 12 meses
    E seleciono a opção "Não quero inserir um seguro"
    Quando clico em Proximo - Simulacao
    Então o sistema exibe opções de seguro com vigência de 12 meses na tela de reforço
    Quando clico em Detalhes do seguro
    Então o sistema exibe modal com o tipo de vigência e detalhes da oferta

  Cenario: CT016 - Tela de reforço - Validar modal de detalhes do seguro com vigencia do contrato
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    E seleciono a opção "Não quero inserir um seguro"
    Quando clico em Proximo - Simulacao
    Então o sistema exibe opções de seguro com vigência do contrato na tela de reforço
    Quando clico em Detalhes do seguro
    Então o sistema exibe modal com o tipo de vigência e detalhes da oferta

  Cenario: CT017 - Tela de reforço - Validar inserção do seguro de 12 meses no carrinho
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 12 X |
    Então o sistema exibe opções de seguro com vigência de 12 meses
    E seleciono a opção "Não quero inserir um seguro"
    Quando clico em Proximo - Simulacao
    Então o sistema exibe opções de seguro com vigência de 12 meses na tela de reforço
    Quando clico em adicionar uma opção de oferta - Tela de reforço
    Então o sistema exibe a mensagem " Seguro Auto Integrado adicionado na parcela. "
    E as informações da oferta são exibidas no carrinho

  Cenario: CT018 - Tela de reforço - Validar inserção do seguro com vigencia do contrato no carrinho
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    E seleciono a opção "Não quero inserir um seguro"
    Quando clico em Proximo - Simulacao
    Então o sistema exibe opções de seguro com vigência do contrato na tela de reforço
    Quando clico em adicionar uma opção de oferta - Tela de reforço
    Então o sistema exibe a mensagem " Seguro Auto Integrado adicionado na parcela. "
    E as informações da oferta são exibidas no carrinho

  Cenario: CT019 - Tela de reforço - Validar exclusão do seguro do carrinho
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    E seleciono a opção "Não quero inserir um seguro"
    Quando clico em Proximo - Simulacao
    Então o sistema exibe opções de seguro com vigência do contrato na tela de reforço
    Quando clico em adicionar uma opção de oferta - Tela de reforço
    Então as informações da oferta são exibidas no carrinho
    Quando clico em remover a oferta do carrinho
    Então o sistema exclui a oferta e mensagem " Valor do Seguro Auto Integrado foi removido da parcela. " é exibida
    E o sistema exibe opções de seguro com vigência do contrato na tela de reforço

  Cenario: CT020 - Tela de reforço - Validar opção de não inclusão do seguro
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    E seleciono a opção "Não quero inserir um seguro"
    Quando clico em Proximo - Simulacao
    Então o sistema exibe opções de seguro com vigência do contrato na tela de reforço
    E o botão Próximo está desabilitado
    Quando seleciono a opção "Não quero inserir um seguro"
    Então o botão Próximo é habilitado

  Cenario: CT021 - Ficha cadastral - Validar alteração de CEP - Contrato de 12 meses
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 12 X |
    Então o sistema exibe opções de seguro com vigência de 12 meses
    E clico em adicionar uma opção de oferta
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    Quando altero as informações do CEP
    Então o sistema exibe o modal do seguro auto integrado

  Cenario: CT022 - Ficha cadastral - Validar alteração de data de nascimento - Vigencia do contrato
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    E clico em adicionar uma opção de oferta
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    Quando altero a data de nascimento
    Então o sistema exibe o modal do seguro auto integrado

  Cenario: CT023 - Consulta de proposta - Validar tela
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    E clico em adicionar uma opção de oferta
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | NAO           |
      | VEICULO USO COMERCIAL       | NAO           |
    E clico em Proximo - Proposta
    Quando seleciono Consultor e Responsavel
      | CONSULTOR     | WATTSON BOHATCH ROTOLI    |
      | RESPONSAVEL   | EIRIO ZANERATTI CAPARELI  |
      | ASSISTENTE    | EIRIO ZANERATTI CAPARELI  |
    E clico no botao Enviar Pre-Proposta
    Entao mensagem " Sua proposta foi enviada! " deve ser exibida
    E ao clicar na opção de consultar propostas
    Quando realizar a busca através do número da proposta
    Então o sistema exibe a proposta com o seguro auto escolhido

  Cenario: CT024 - Validar informação do seguro auto carregado no combo do modal (arrumar os steps)
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    E clico em adicionar uma opção de oferta
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    Quando altero a data de nascimento
    Então o sistema exibe o modal do seguro auto integrado

  Cenário: CT025 - Validar enriquecimento de dados do CPF informado na ficha
    E clico na opção de incluir Seguro Auto
    E informo o CPF
    Quando Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    Então o modal já carrega os dados do CPF informado

  Cenário: CT026 - Validar enriquecimento de dados do CPF salvo na base
    E clico na opção de incluir Seguro Auto
    Quando Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo o CPF
    Então o sistema já carrega os dados do cliente

  Cenario: CT027 - Validar remoção do Seguro - Acrescentar blindagem
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato
    E clico em adicionar uma opção de oferta
    E clico em Proximo - Simulacao
    E preencho os dados do proponente PF
      | SEXO                        | M             |
      | CEP RESIDENCIAL             | 29114-360     |
      | CONDUTOR ENTRE 18 E 25 ANOS | SIM           |
      | VEICULO USO COMERCIAL       | SIM           |
      | TAXI OU FROTA               | SIM           |
    Quando volto pra calculadora e incluo o item blindagem
    Então o sistema exibe exclui o seguro do carrinho

  Cenario: CT028 - Validar oferta com vigencia de 12 meses (contrato de 12 meses) - Veículos usados
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 12 X |
    Então o sistema exibe opções de seguro com vigência de 12 meses

  Cenario: CT029 - Validar oferta com vigencia do contrato (contrato de 14 meses) - Veículos usados
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 14 X |
    Então o sistema exibe opções de seguro com vigência do contrato

   #Cenários de edição de oferta (altear os steps)
  Cenario: CT030 - Validar edição de oferta com vigencia de 12 meses (contrato de 12 meses)
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 12 X |
    Então o sistema exibe opções de seguro com vigência de 12 meses

  Cenario: CT031 - Validar edição de oferta com vigencia de 12 meses (contrato de 49 meses)
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 48 X |
    Então o sistema exibe opções de seguro com vigência do contrato

  Cenario: CT032 - Validar edição de oferta com vigencia do contrato (com 13 meses)
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 13 X |
    Então o sistema exibe opções de seguro com vigência do contrato

  Cenario: CT033 - Validar edição de oferta com vigencia do contrato (com 48 meses)
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 48 X |
    Então o sistema exibe opções de seguro com vigência do contrato

  Cenario: CT034 - Validar edição de proposta - Alterar CEP
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 48 X |
    Então o sistema exibe opções de seguro com vigência do contrato

  Cenario: CT035 - Validar edição de proposta - Alterar data de nascimento
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 48 X |
    Então o sistema exibe opções de seguro com vigência do contrato

  Cenario: CT036 - Validar edição de proposta - Incluir blindagem
    E clico na opção de incluir Seguro Auto
    E Seleciono o seguinte tipo de seguro
      | ITEM  | Seguro Auto Integrado |
    E informo os dados do cliente
    E clico em continuar
    E clico no botao Calcular
    Quando seleciono o seguinte plano de financiamento
      |PLANO  | 48 X |
    Então o sistema exibe opções de seguro com vigência do contrato



 #VALIDAÇÕES DE NÃO OFERTA

  Cenário: CT037 - Validar a não oferta - PJ
    E clico no Step de configurações
    E seleciono as configuracoes
      | TIPO PESSOA         | PJ    |
      | TIPO VEICULO        | 0KM   |
      | TABELA COM SUBSIDIO | NAO   |
    E clico em Proximo - Configuracoes
    E altero as configurações do veículo
      | CICLO TOYOTA         | SIM                             |
      | MARCA                | TOYOTA                          |
      | ANO FABRICACAO       | 2021                            |
      | ANO MODELO           | 2021                            |
      | MODELO VERSAO        | COROLLA XEI 2.0 FLEX 16V AUT.   |
      | TABELA DE NEGOCIACAO | CICLO_122_1_SP_PJ               |
      | UF EMPLACAMENTO      | ES - Todas                      |
      | CODIGO SIMULACAO     | 0                               |
      | DIA DE PAGAMENTO     | 1 mês após a formalização       |
      | CESTA DE SERVICO     | Cesta 10 - Pessoa Juridica      |
    E clico em Proximo - Veiculo
    Quando clico na opção de incluir Seguro Auto
    Entao Verifico que a opção de "Seguro Auto integrado" não é disponibilizada

  Cenário: CT038 - Validar a não oferta - Veículos com categoria "maquinas pesadas"
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

  Cenário: CT039 - Validar a não oferta - Veículos para veículos de uso comercial
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

  Cenário: CT040 - Validar a não oferta - Veículos com blindagem
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






