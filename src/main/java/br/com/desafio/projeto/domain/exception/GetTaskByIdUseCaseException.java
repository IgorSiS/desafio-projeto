package br.com.desafio.projeto.domain.exception;

public class GetTaskByIdUseCaseException extends UseCaseException {

    private static final long serialVersionUID = 1L;

    public GetTaskByIdUseCaseException(String message) {
        super(message);
    }

    public GetTaskByIdUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
