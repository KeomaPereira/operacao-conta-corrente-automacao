package impl;
import com.google.gson.Gson;
import impl.dto.LancamentoInputDto;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

import java.nio.charset.StandardCharsets;

public class SaqueImpl {
	
	private CloseableHttpClient httpClient = HttpClients.createDefault();
	private HttpGet requestGet;
	private HttpPost requestPost;
	private CloseableHttpResponse response;
	private String responseBody;

	public static final String URL = "http://localhost:8080/conta-corrente/lancamentos/saques/";
	public static final int CODIGO_RETORNO_NOT_FOUND = 404;
	public static final int CODIGO_RETORNO_SUCESSO = 200;
	public static final String CONTA_SEM_LANCAMENTOS = "60";
	public static final String CONTA = "80";
	public static final String CEDULAS_ESPERADAS = "[{\"cedula\":10,\"quantidade\":1},{\"cedula\":50,\"quantidade\":1}]";
	public static final Integer VALOR_PARA_SACAR = 60;

	public void setarUrlGet(String conta) throws Exception {
		requestGet = new HttpGet(URL + conta);
	}

	public void setarUrlPost(String conta) throws Exception {
		requestPost = new HttpPost(URL + conta);
	}

	public void enviarRequisicaoPost() throws Exception {
		Gson gson = new Gson();
		LancamentoInputDto dto = new LancamentoInputDto();
		dto.setValor(VALOR_PARA_SACAR.intValue());
		StringEntity entity = new StringEntity(gson.toJson(dto));
		requestPost.setEntity(entity);
		requestPost.setHeader("Content-type", "application/json");
		response = httpClient.execute(requestPost);
		responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
	}

	 public void enviarRequisicaoGet() throws Exception {
		response = httpClient.execute(requestGet);
	}

	public void validarStatusRetornoDoServico(int codigo) {
		Assert.assertEquals(codigo, response.getStatusLine().getStatusCode());
	}

	public void validarCedulasParaSaque() {

		Assert.assertEquals(responseBody, CEDULAS_ESPERADAS);
	}
	
}