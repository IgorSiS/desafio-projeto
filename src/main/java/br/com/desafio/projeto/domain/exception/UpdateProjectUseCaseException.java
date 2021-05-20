package br.com.desafio.projeto.domain.exception;

public class UpdateProjectUseCaseException extends UseCaseException {

    private static final long serialVersionUID = 1L;

    public UpdateProjectUseCaseException(String message) {
        super(message);
    }

    public UpdateProjectUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
