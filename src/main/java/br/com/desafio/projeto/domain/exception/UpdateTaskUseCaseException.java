package br.com.desafio.projeto.domain.exception;

public class UpdateTaskUseCaseException extends UseCaseException {

    private static final long serialVersionUID = 1L;

    public UpdateTaskUseCaseException(String message) {
        super(message);
    }

    public UpdateTaskUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
