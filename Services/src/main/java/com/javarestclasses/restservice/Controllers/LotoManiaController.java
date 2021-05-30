package com.javarestclasses.restservice.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javarestclasses.restservice.models.LotoManiaSorteio;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;
import kong.unirest.Unirest;

@RestController
public class LotoManiaController {

	@GetMapping("/lotomania/sorteios")
	public List<LotoManiaSorteio> resultadoLotoMania(@RequestParam(value = "qtdConcursos") Integer qtd,
			@RequestParam(value = "numeroConcurso") Integer numero) {

		List<LotoManiaSorteio> sorteios = new ArrayList<>();

		for (int i = 1; i <= qtd; numero--, i++) 
		{
			sorteios.add(fetchSorteio(numero));
		}
		
		return sorteios;
	}

	private LotoManiaSorteio fetchSorteio(Integer numero) {
		String url = "http://loterias.caixa.gov.br/wps/portal/loterias/landing/lotomania/!ut/p/a1/04_Sj9CPykssy0xPLMnMz0vMAfGjzOLNDH0MPAzcDbz8vTxNDRy9_Y2NQ13CDA38jYEKIoEKnN0dPUzMfQwMDEwsjAw8XZw8XMwtfQ0MPM2I02-AAzgaENIfrh-FqsQ9wBmoxN_FydLAGAgNTKEK8DkRrACPGwpyQyMMMj0VAajYsZo!/dl5/d5/L2dBISEvZ0FBIS9nQSEh/pw/Z7_61L0H0G0JGJVA0AKLR5T3K00V0/res/id=buscaResultado/c=cacheLevelPage//p=concurso={concurso}?timestampAjax=1619380647123";
		// url = url.replace("__NUM__CONCURSO__", numero.toString());

		String jsonLotomania = Unirest.get(url).routeParam("concurso", numero.toString()).asJson().getBody().toString();

		JSONObject json = new JSONObject(jsonLotomania);
		int numeroJogo = json.getInt("numero");
		JSONArray listaNumerosSorteados = json.getJSONArray("dezenasSorteadasOrdemSorteio");

		LotoManiaSorteio sorteio = new LotoManiaSorteio(numeroJogo);

		listaNumerosSorteados.forEach(s -> sorteio.getOrdemSorteio().add(Integer.parseInt(s.toString())));

		return sorteio;
	}
	
	@GetMapping("/lotomania/sorteio/ultimo")
	public Integer ultimoNumeroSorteio() { 
		return lastDrawNumber();
	}
	
	private Integer lastDrawNumber() {
		String url = "https://www.sorteonline.com.br/lotomania/resultados";
		String html = Unirest.get(url).asString().getBody().toString();
		
		Pattern p = Pattern.compile("concurso-numero\">\\d{4}");
		Matcher m = p.matcher(html);
		if(m.find()) {
			String result = m.group().replace("concurso-numero\">", "");
			return Integer.parseInt(result);
		}
		
		return 0;
	}
	

}
