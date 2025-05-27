package br.com.unicuritiba.ProjetoA3.Models;

public class MensagemRequest {
	private String number;
    private String body;
    private String userId;
    private String queueId;
    private boolean sendSignature;
    private boolean closeTicket;

    public MensagemRequest() {}

    public MensagemRequest(String number, String body, String userId, String queueId, boolean sendSignature, boolean closeTicket) {
        this.number = number;
        this.body = body;
        this.userId = userId;
        this.queueId = queueId;
        this.sendSignature = sendSignature;
        this.closeTicket = closeTicket;
    }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getQueueId() { return queueId; }
    public void setQueueId(String queueId) { this.queueId = queueId; }

    public boolean isSendSignature() { return sendSignature; }
    public void setSendSignature(boolean sendSignature) { this.sendSignature = sendSignature; }

    public boolean isCloseTicket() { return closeTicket; }
    public void setCloseTicket(boolean closeTicket) { this.closeTicket = closeTicket; }
}