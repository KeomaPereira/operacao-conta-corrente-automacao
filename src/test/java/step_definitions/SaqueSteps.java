package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import impl.SaqueImpl;

public class SaqueSteps {

    private SaqueImpl saque;
    
    @Given("^uma conta sem lancamento$")
    public void iniciarCenarioContaSemLancamento() throws Throwable {
        saque = new SaqueImpl();
    }
    
    @Given("^uma conta$")
    public void iniciarCenario() throws Throwable {
        saque = new SaqueImpl();
    }

    @When("^enviar um get para buscar lancamentos$")
    public void enviarGetContaSemLancamento() throws Throwable {
        saque.setarUrlGet(saque.CONTA_SEM_LANCAMENTOS);
        saque.enviarRequisicaoGet();
    }
    
    @When("^enviar um get para buscar lancamentos efetivados$")
    public void enviarGetContaComLancamento() throws Throwable {
        saque.setarUrlGet(saque.CONTA);
        saque.enviarRequisicaoGet();
    }

    @When("^enviar um post para realizar lancamento$")
    public void enviarPost() throws Throwable {
        saque.setarUrlPost(saque.CONTA);
        saque.enviarRequisicaoPost();
    }

    @Then("^deve retornar que nao existem lancamentos de saque desta conta$")
    public void validarGetSemLancamentos() throws Throwable {
        saque.validarStatusRetornoDoServico(saque.CODIGO_RETORNO_NOT_FOUND);
    }

    @Then("^deve realizar o lancamento de saque$")
    public void validarLancamentoSaque() throws Throwable {
        saque.validarStatusRetornoDoServico(saque.CODIGO_RETORNO_SUCESSO);
        saque.validarCedulasParaSaque();
    }
    
    @Then("^deve retornar o valor em cedulas$")
    public void validarCedulas() throws Throwable {
        saque.validarCedulasParaSaque();
    }
    
    @Then("^deve retornar lancamentos de saque desta conta$")
    public void validarRetornoLancamentosConta() throws Throwable {
    	saque.validarStatusRetornoDoServico(saque.CODIGO_RETORNO_SUCESSO);
    }
    
}