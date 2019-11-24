package br.com.projetoweb.projetoweb.infrastructure;
// Uma ideia vaga...
public class ResponseBase<T> {
    
    private String statusText;
    private int status;
    private T result;


    public String getStatusText() { return statusText; }
    public void setStatusText(String statusText) { this.statusText = statusText; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public T getResult() { return result; }
    public void setResult(T result) { this.result = result; }
}
