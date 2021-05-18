package br.com.desafio.projeto.gateway.exception;

public class GatewayException extends Exception{

    private static final long serialVersionUID = 1L;

    public GatewayException(String message) {
        super(message);
    }

    public GatewayException(String message, Throwable cause) {
        super(message, cause);
    }

}
