package br.com.unicuritiba.ProjetoA3.Services;

import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import br.com.unicuritiba.ProjetoA3.Models.MensagemRequest;
import jakarta.xml.ws.WebServiceClient;
import reactor.core.publisher.Mono;

@Service
public class ApiClientService {
	
	private final WebClientCustomizer webClient;

    public ApiClientService() {
        this.webClient = WebClientCustomizer.builder()
            .baseUrl("https://apisphere.vision.inf.br")
            .defaultHeader("Authorization", "Bearer ZpXO1G0TV9hau4owI1OqTYecBvZXOG")
            .build();
        
        public Mono<String> enviarMensagem(MensagemRequest mensagemRequest) {
            return webClient.post()
                .uri("/api/messages/send")
                .bodyValue(mensagemRequest)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(response -> System.out.println("Resposta da API: " + response))
                .doOnError(error -> System.err.println("Erro ao enviar mensagem: " + error.getMessage()));
        }

}
