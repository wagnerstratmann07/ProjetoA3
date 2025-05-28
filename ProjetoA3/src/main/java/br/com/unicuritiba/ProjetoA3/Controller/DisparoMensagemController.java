package br.com.unicuritiba.ProjetoA3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.unicuritiba.ProjetoA3.Services.ApiClientService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.ProjetoA3.Models.MensagemDTO;
import br.com.unicuritiba.ProjetoA3.Models.MensagemRequest;



@RestController
public class DisparoMensagemController {
	

	@PostMapping("/disparomsg2")
	  public String enviarMensagem(@ModelAttribute MensagemDTO mensagemDTO, Model model) {

        MensagemRequest request = new MensagemRequest(
            mensagemDTO.getDestinatario(), // number
            mensagemDTO.getMensagem(),     // body
            "10",                          // userId (fixo)
            "15",                          // queueId (fixo)
            false,                        // sendSignature (fixo)
            true                          // closeTicket (fixo)
        );

        apiClientService.enviarMensagem(request).subscribe();

        model.addAttribute("mensagemEnviada", "Mensagem enviada com sucesso!");
        return "formulario";
	}
	
}
