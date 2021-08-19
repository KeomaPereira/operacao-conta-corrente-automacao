Feature: Lancamentos de saque

  Scenario: Buscar lancamento nao efetivado
  	Given uma conta sem lancamento
    When enviar um get para buscar lancamentos
    Then deve retornar que nao existem lancamentos de saque desta conta
    
  Scenario: Realizar lancamento
  	Given uma conta
    When enviar um post para realizar lancamento
    Then deve realizar o lancamento de saque
    And deve retornar o valor em cedulas
    
  Scenario: Buscar lancamento efetivado
  	Given uma conta
    When enviar um get para buscar lancamentos efetivados
    Then deve retornar lancamentos de saque desta conta