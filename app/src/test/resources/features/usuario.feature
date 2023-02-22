#language: pt

Funcionalidade: Testando Api User

  @usuario
  Esquema do Cenario: Criar um usuario e verificar que foi criado
    Dado Que eu consiga criar um usuario com <nome> e <id>
    Quando eu tiver um usuario criado verifico que ele esta na nossa basse de dados pelo <nome> e <id>
    Entao eu atualizo esse usuario para seu <novo>
    E verifico que o nome foi alterado para seu <novo>

    Exemplos: nomes e ids para utilizar
      | nome  |  | id | novo  |
      | pepino |  | 98 | grego |
