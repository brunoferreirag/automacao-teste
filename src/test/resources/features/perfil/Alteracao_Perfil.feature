#language: pt
  # charset: UTF-8

@perfil

Funcionalidade: Alteração de dados do Perfil
  Como um usuário do sistema
  Eu quero alterar os dados do meu Perfil
  Para realizar a atualização dos dados

  Contexto: Acessar a tela do perfil com usuario representante
    Dado eu esteja na tela de login
    E que esteja logado com usuario representante
    E eu seleciono a concessionaria
      | CODIGO LOJA | VONICE ALFONZO MAISE - 75 |
    E clico em Proximo
    E clico no Avatar
    E clico no menu Perfil


  Cenario: CT001 - Inserir imagem
    E incluo a imagem
    Quando clico em salvar edicao da imagem
    Entao mensagem " Foto salva com sucesso. " é exibida

  Cenario: CT002 - Excluir imagem
    Quando clico em remover imagem
    Entao mensagem " Foto excluida com sucesso. " é exibida

  Cenario: CT003 - Alterar imagem
    E realizo a troca da imagem
    Quando clico em salvar edicao da imagem
    Entao mensagem " Foto salva com sucesso. " é exibida

  Cenario: CT004 - Alterar imagem via modal Edição
    E realizo a troca da imagem
    E confirmo a alteracao
    E realizo a troca da imagem
    Quando clico em salvar edicao da imagem
    Entao mensagem " Foto salva com sucesso. " é exibida

  Cenario: CT005 - Alteração de email - email válido
    E clico em editar
    E insiro um email válido
    Quando clico em salvar
    Entao o email é salvo com sucesso

  Cenario: CT006 - Alteração de telefone - telefone válido
    E clico em editar
    E insiro um celular válido
    Quando clico em salvar
    Entao o celular é salvo com sucesso

