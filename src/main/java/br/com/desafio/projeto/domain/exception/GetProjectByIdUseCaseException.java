package br.com.desafio.projeto.domain.exception;

public class GetProjectByIdUseCaseException extends UseCaseException {

    private static final long serialVersionUID = 1L;

    public GetProjectByIdUseCaseException(String message) {
        super(message);
    }

    public GetProjectByIdUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
