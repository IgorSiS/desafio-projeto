package br.com.desafio.projeto.domain.exception;

public class GetAllProjectUseCaseException extends UseCaseException {

    private static final long serialVersionUID = 1L;

    public GetAllProjectUseCaseException(String message) {
        super(message);
    }

    public GetAllProjectUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
