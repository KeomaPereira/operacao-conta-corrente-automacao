Feature: Lancamentos de saque

  Scenario: Buscar lancamentos n�o efetivado
  	Given uma conta sem lancamento
    When enviar um get para buscar lancamentos
    Then deve retornar que nao existem lancamentos de saque desta conta
    
  Scenario: Realizar lancamento
  	Given uma conta
    When enviar um post para realizar lancamento
    Then deve realizar o lancamento de saque