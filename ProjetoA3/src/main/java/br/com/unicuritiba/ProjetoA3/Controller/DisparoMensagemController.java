package br.com.unicuritiba.ProjetoA3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.ProjetoA3.Models.MensagemRequest;
import br.com.unicuritiba.ProjetoA3.Services.ApiClientService;

@RestController
@RequestMapping
public class DisparoMensagemController {
	
	@Autowired
	private ApiClientService apiClientService;
	
	@PostMapping("/enviar")
    public Mono<ResponseEntity<Map<String, String>>> enviarMensagem(@RequestBody MensagemRequest request) {
        return ApiClientService.enviarMensagem(request)
            .map(response -> ResponseEntity.ok(Map.of(
                "status", "sucesso",
                "mensagem", "Mensagem enviada com sucesso! Resposta da API: " + response
            )))
            .onErrorResume(error -> Mono.just(ResponseEntity.status(500).body(Map.of(
                "status", "erro",
                "mensagem", "Erro ao enviar mensagem: " + error.getMessage()
            ))));
    }
}
