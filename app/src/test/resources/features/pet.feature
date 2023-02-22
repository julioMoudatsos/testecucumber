#language: pt

Funcionalidade: Testando Api PET

  @deletarPetCriado @pet
  Esquema do Cenario: Criar um pet e ver que ele esta como disponivel na lista no banco
    Dado Que eu consiga criar um pet com o status: <status>
    Entao Eu verifico que eles esta como status <status> na lista de pets

    Exemplos: nomes e ids para utilizar
      | status    |
      | pending   |
      | available |

