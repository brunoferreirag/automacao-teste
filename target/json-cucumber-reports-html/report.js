$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/itensFinanciaveis/Itens_Financiaveis.feature");
formatter.feature({
  "name": "Itens financiaveis",
  "description": "  Como um usuário do sistema\n  Eu quero validar a inclusão de itens financiáveis\n  Para realizar simulações de financiamento",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "name": "@itensfinanciaveis"
    }
  ]
});
formatter.scenarioOutline({
  "name": "CT001 - Adicionar item financiável a pré-proposta",
  "description": "",
  "keyword": "Esquema do Cenario"
});
formatter.step({
  "name": "clico na opção de incluir Itens Financiáveis",
  "keyword": "E "
});
formatter.step({
  "name": "Seleciono o seguinte \"\u003citem\u003e\"",
  "keyword": "E "
});
formatter.step({
  "name": "informo o valor do item",
  "keyword": "E ",
  "rows": [
    {
      "cells": [
        "VALOR DO ITEM",
        "1.000,00"
      ]
    }
  ]
});
formatter.step({
  "name": "clico em adicionar",
  "keyword": "E "
});
formatter.step({
  "name": "clico no botao Calcular",
  "keyword": "Quando "
});
formatter.step({
  "name": "opto por não incluir o seguro auto integrado",
  "keyword": "E "
});
formatter.step({
  "name": "o item financiavel é adicionado no carrinho",
  "keyword": "Entao "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "item"
      ]
    },
    {
      "cells": [
        "ACESSORIOS"
      ]
    },
    {
      "cells": [
        "BLINDAGEM"
      ]
    },
    {
      "cells": [
        "DESPACHANTE"
      ]
    },
    {
      "cells": [
        "REVISAO NA MEDIDA"
      ]
    },
    {
      "cells": [
        "SERVICOS"
      ]
    }
  ]
});
formatter.background({
  "name": "Acessar a tela de simulação com usuario representante",
  "description": "",
  "keyword": "Contexto"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "eu esteja na tela de login",
  "keyword": "Dado "
});
formatter.match({
  "location": "LoginSteps.eu_esteja_na_tela_de_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "que esteja logado com usuario representante",
  "keyword": "E "
});
formatter.match({
  "location": "LoginSteps.que_esteja_logado_com_usuario_representante()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "eu seleciono a concessionaria",
  "rows": [
    {
      "cells": [
        "CODIGO LOJA",
        "VONICE ALFONZO MAISE - 75"
      ]
    }
  ],
  "keyword": "E "
});
formatter.match({
  "location": "SelecaoLojaSteps.eu_seleciono_a_concessionaria(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em Proximo",
  "keyword": "E "
});
formatter.match({
  "location": "BaseSteps.clico_em()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em Faca Uma Simulacao",
  "keyword": "E "
});
formatter.match({
  "location": "HomeSteps.clico_em()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no step de Configuracao",
  "keyword": "E "
});
formatter.match({
  "location": "BaseSteps.clicoNoStepDeConfiguracao()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "seleciono as configuracoes",
  "rows": [
    {
      "cells": [
        "TIPO PESSOA",
        "PF"
      ]
    },
    {
      "cells": [
        "TIPO VEICULO",
        "0KM"
      ]
    },
    {
      "cells": [
        "TABELA COM SUBSIDIO",
        "NAO"
      ]
    }
  ],
  "keyword": "E "
});
formatter.match({
  "location": "ConfiguracaoSteps.selecionoAsConfiguracoes(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em Proximo - Configuracoes",
  "keyword": "E "
});
formatter.match({
  "location": "ConfiguracaoSteps.clicoEmProximoConfiguracoes()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "seleciono as opcoes de veiculo",
  "rows": [
    {
      "cells": [
        "CICLO TOYOTA",
        "SIM"
      ]
    },
    {
      "cells": [
        "MARCA",
        "LEXUS"
      ]
    },
    {
      "cells": [
        "ANO FABRICACAO",
        "2021"
      ]
    },
    {
      "cells": [
        "ANO MODELO",
        "2021"
      ]
    },
    {
      "cells": [
        "MODELO VERSAO",
        "LEXUS ES 300H"
      ]
    },
    {
      "cells": [
        "TABELA DE NEGOCIACAO",
        "CDC_CICLOLEXUSPRIVILEGE_PARCELA_SEM_SUBSIDIO_MENSAL"
      ]
    },
    {
      "cells": [
        "UF EMPLACAMENTO",
        "ES - Todas"
      ]
    },
    {
      "cells": [
        "CODIGO SIMULACAO",
        "0"
      ]
    },
    {
      "cells": [
        "DIA DE PAGAMENTO",
        "1 mês após a formalização"
      ]
    },
    {
      "cells": [
        "CESTA DE SERVICO",
        "Cesta 10 - Pessoa Fisica"
      ]
    }
  ],
  "keyword": "E "
});
formatter.match({
  "location": "VeiculoSteps.seleciono_as_opcoes_de_veiculo(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em Proximo - Veiculo",
  "keyword": "E "
});
formatter.match({
  "location": "VeiculoSteps.clicoEmProximoVeiculo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencho os valores da simulacao - parcela",
  "rows": [
    {
      "cells": [
        "VALOR VEICULO",
        "R$100.000,00"
      ]
    },
    {
      "cells": [
        "VALOR ENTRADA",
        "R$30.000,00"
      ]
    },
    {
      "cells": [
        "VALOR PARCELA",
        "R$2.500,00"
      ]
    }
  ],
  "keyword": "E "
});
formatter.match({
  "location": "SimulacaoSteps.preencho_os_valores_da_simulacao_parcela(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "CT001 - Adicionar item financiável a pré-proposta",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@itensfinanciaveis"
    }
  ]
});
formatter.step({
  "name": "clico na opção de incluir Itens Financiáveis",
  "keyword": "E "
});
formatter.match({
  "location": "ItensFinanciaveisSteps.adicionarItem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Seleciono o seguinte \"ACESSORIOS\"",
  "keyword": "E "
});
formatter.match({
  "location": "ItensFinanciaveisSteps.selecionoOSeguinte(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "informo o valor do item",
  "rows": [
    {
      "cells": [
        "VALOR DO ITEM",
        "1.000,00"
      ]
    }
  ],
  "keyword": "E "
});
formatter.match({
  "location": "ItensFinanciaveisSteps.informoOValorDoItem(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em adicionar",
  "keyword": "E "
});
formatter.match({
  "location": "ItensFinanciaveisSteps.clicoEmAdicionar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no botao Calcular",
  "keyword": "Quando "
});
formatter.match({
  "location": "BaseSteps.clicoNoBotaoCalcular()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "opto por não incluir o seguro auto integrado",
  "keyword": "E "
});
formatter.match({
  "location": "BaseSteps.optoPorNãoIncluirOSeguroAutoIntegrado()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "o item financiavel é adicionado no carrinho",
  "keyword": "Entao "
});
formatter.match({
  "location": "ItensFinanciaveisSteps.oItemFinanciavelÉAdicionadoNoCarrinho()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Acessar a tela de simulação com usuario representante",
  "description": "",
  "keyword": "Contexto"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "eu esteja na tela de login",
  "keyword": "Dado "
});
formatter.match({
  "location": "LoginSteps.eu_esteja_na_tela_de_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "que esteja logado com usuario representante",
  "keyword": "E "
});
formatter.match({
  "location": "LoginSteps.que_esteja_logado_com_usuario_representante()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "eu seleciono a concessionaria",
  "rows": [
    {
      "cells": [
        "CODIGO LOJA",
        "VONICE ALFONZO MAISE - 75"
      ]
    }
  ],
  "keyword": "E "
});
formatter.match({
  "location": "SelecaoLojaSteps.eu_seleciono_a_concessionaria(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em Proximo",
  "keyword": "E "
});
formatter.match({
  "location": "BaseSteps.clico_em()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em Faca Uma Simulacao",
  "keyword": "E "
});
formatter.match({
  "location": "HomeSteps.clico_em()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no step de Configuracao",
  "keyword": "E "
});
formatter.match({
  "location": "BaseSteps.clicoNoStepDeConfiguracao()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "seleciono as configuracoes",
  "rows": [
    {
      "cells": [
        "TIPO PESSOA",
        "PF"
      ]
    },
    {
      "cells": [
        "TIPO VEICULO",
        "0KM"
      ]
    },
    {
      "cells": [
        "TABELA COM SUBSIDIO",
        "NAO"
      ]
    }
  ],
  "keyword": "E "
});
formatter.match({
  "location": "ConfiguracaoSteps.selecionoAsConfiguracoes(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em Proximo - Configuracoes",
  "keyword": "E "
});
formatter.match({
  "location": "ConfiguracaoSteps.clicoEmProximoConfiguracoes()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "seleciono as opcoes de veiculo",
  "rows": [
    {
      "cells": [
        "CICLO TOYOTA",
        "SIM"
      ]
    },
    {
      "cells": [
        "MARCA",
        "LEXUS"
      ]
    },
    {
      "cells": [
        "ANO FABRICACAO",
        "2021"
      ]
    },
    {
      "cells": [
        "ANO MODELO",
        "2021"
      ]
    },
    {
      "cells": [
        "MODELO VERSAO",
        "LEXUS ES 300H"
      ]
    },
    {
      "cells": [
        "TABELA DE NEGOCIACAO",
        "CDC_CICLOLEXUSPRIVILEGE_PARCELA_SEM_SUBSIDIO_MENSAL"
      ]
    },
    {
      "cells": [
        "UF EMPLACAMENTO",
        "ES - Todas"
      ]
    },
    {
      "cells": [
        "CODIGO SIMULACAO",
        "0"
      ]
    },
    {
      "cells": [
        "DIA DE PAGAMENTO",
        "1 mês após a formalização"
      ]
    },
    {
      "cells": [
        "CESTA DE SERVICO",
        "Cesta 10 - Pessoa Fisica"
      ]
    }
  ],
  "keyword": "E "
});
formatter.match({
  "location": "VeiculoSteps.seleciono_as_opcoes_de_veiculo(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em Proximo - Veiculo",
  "keyword": "E "
});
formatter.match({
  "location": "VeiculoSteps.clicoEmProximoVeiculo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencho os valores da simulacao - parcela",
  "rows": [
    {
      "cells": [
        "VALOR VEICULO",
        "R$100.000,00"
      ]
    },
    {
      "cells": [
        "VALOR ENTRADA",
        "R$30.000,00"
      ]
    },
    {
      "cells": [
        "VALOR PARCELA",
        "R$2.500,00"
      ]
    }
  ],
  "keyword": "E "
});
formatter.match({
  "location": "SimulacaoSteps.preencho_os_valores_da_simulacao_parcela(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "CT001 - Adicionar item financiável a pré-proposta",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@itensfinanciaveis"
    }
  ]
});
formatter.step({
  "name": "clico na opção de incluir Itens Financiáveis",
  "keyword": "E "
});
formatter.match({
  "location": "ItensFinanciaveisSteps.adicionarItem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Seleciono o seguinte \"BLINDAGEM\"",
  "keyword": "E "
});
formatter.match({
  "location": "ItensFinanciaveisSteps.selecionoOSeguinte(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "informo o valor do item",
  "rows": [
    {
      "cells": [
        "VALOR DO ITEM",
        "1.000,00"
      ]
    }
  ],
  "keyword": "E "
});
formatter.match({
  "location": "ItensFinanciaveisSteps.informoOValorDoItem(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em adicionar",
  "keyword": "E "
});
formatter.match({
  "location": "ItensFinanciaveisSteps.clicoEmAdicionar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no botao Calcular",
  "keyword": "Quando "
});
formatter.match({
  "location": "BaseSteps.clicoNoBotaoCalcular()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "opto por não incluir o seguro auto integrado",
  "keyword": "E "
});
formatter.match({
  "location": "BaseSteps.optoPorNãoIncluirOSeguroAutoIntegrado()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "o item financiavel é adicionado no carrinho",
  "keyword": "Entao "
});
formatter.match({
  "location": "ItensFinanciaveisSteps.oItemFinanciavelÉAdicionadoNoCarrinho()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Acessar a tela de simulação com usuario representante",
  "description": "",
  "keyword": "Contexto"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "eu esteja na tela de login",
  "keyword": "Dado "
});
formatter.match({
  "location": "LoginSteps.eu_esteja_na_tela_de_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "que esteja logado com usuario representante",
  "keyword": "E "
});
formatter.match({
  "location": "LoginSteps.que_esteja_logado_com_usuario_representante()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "eu seleciono a concessionaria",
  "rows": [
    {
      "cells": [
        "CODIGO LOJA",
        "VONICE ALFONZO MAISE - 75"
      ]
    }
  ],
  "keyword": "E "
});
formatter.match({
  "location": "SelecaoLojaSteps.eu_seleciono_a_concessionaria(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em Proximo",
  "keyword": "E "
});
formatter.match({
  "location": "BaseSteps.clico_em()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em Faca Uma Simulacao",
  "keyword": "E "
});
formatter.match({
  "location": "HomeSteps.clico_em()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no step de Configuracao",
  "keyword": "E "
});
formatter.match({
  "location": "BaseSteps.clicoNoStepDeConfiguracao()"
});
