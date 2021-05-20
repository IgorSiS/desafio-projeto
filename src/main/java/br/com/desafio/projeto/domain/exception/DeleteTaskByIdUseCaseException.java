package br.com.desafio.projeto.domain.exception;

public class DeleteTaskByIdUseCaseException extends UseCaseException {

    private static final long serialVersionUID = 1L;

    public DeleteTaskByIdUseCaseException(String message) {
        super(message);
    }

    public DeleteTaskByIdUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
