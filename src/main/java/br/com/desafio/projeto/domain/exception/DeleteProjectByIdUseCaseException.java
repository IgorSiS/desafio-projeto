package br.com.desafio.projeto.domain.exception;

public class DeleteProjectByIdUseCaseException extends UseCaseException {

    private static final long serialVersionUID = 1L;

    public DeleteProjectByIdUseCaseException(String message) {
        super(message);
    }

    public DeleteProjectByIdUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
