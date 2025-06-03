package br.com.unicuritiba.ProjetoA3.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mensage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMensagem;

    private String mensagemTexto;
    private String mensagemMedia;
    private String tipoConteudo;

    public long getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(long idMensagem) {
        this.idMensagem = idMensagem;
    }

    public String getMensagemTexto() {
        return mensagemTexto;
    }

    public void setMensagemTexto(String mensagemTexto) {
        this.mensagemTexto = mensagemTexto;
    }

    public String getMensagemMedia() {
        return mensagemMedia;
    }

    public void setMensagemMedia(String mensagemMedia) {
        this.mensagemMedia = mensagemMedia;
    }

    public String getTipoConteudo() {
        return tipoConteudo;
    }

    public void setTipoConteudo(String tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }
}
