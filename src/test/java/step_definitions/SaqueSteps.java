package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import impl.SaqueImpl;

public class SaqueSteps {

    private SaqueImpl saque;
    
    @Given("^uma conta sem lancamento$")
    public void access_the_google() throws Throwable {
        saque = new SaqueImpl();
    	System.out.println("Passo 1 concluido");
    }
    
    @Given("^uma conta$")
    public void access_the_google2() throws Throwable {
        saque = new SaqueImpl();
    	System.out.println("Passo 1 concluido");
    }

    @When("^enviar um get para buscar lancamentos$")
    public void user_search() throws Throwable {
        saque.setarUrlGet(saque.CONTA_SEM_LANCAMENTOS);
        saque.enviarRequisicaoGet();
        System.out.println("Passo 2 concluido");
    }

    @When("^enviar um post para realizar lancamento$")
    public void user_search2() throws Throwable {
        saque.setarUrlPost(saque.CONTA);
        saque.enviarRequisicaoPost();
        System.out.println("Passo 2 concluido");
    }

    @Then("^deve retornar que nao existem lancamentos de saque desta conta$")
    public void searched() throws Throwable {
        saque.validarStatusRetornoDoServico(saque.NOT_FOUND);
        System.out.println("Passo 3 concluido");
    }

    @Then("^deve realizar o lancamento de saque$")
    public void searched2() throws Throwable {
        saque.validarStatusRetornoDoServico(saque.SUCESSO);
        saque.validarCedulasParaSaque();
        System.out.println("Passo 3 concluido");
    }
    
}