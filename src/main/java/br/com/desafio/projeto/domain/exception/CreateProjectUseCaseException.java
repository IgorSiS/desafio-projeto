package br.com.desafio.projeto.domain.exception;

public class CreateProjectUseCaseException extends UseCaseException {

    private static final long serialVersionUID = 1L;

    public CreateProjectUseCaseException(String message) {
        super(message);
    }

    public CreateProjectUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
