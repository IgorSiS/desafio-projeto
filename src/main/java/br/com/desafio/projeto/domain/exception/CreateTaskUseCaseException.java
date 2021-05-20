package br.com.desafio.projeto.domain.exception;

public class CreateTaskUseCaseException extends UseCaseException {

    private static final long serialVersionUID = 1L;

    public CreateTaskUseCaseException(String message) {
        super(message);
    }

    public CreateTaskUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
