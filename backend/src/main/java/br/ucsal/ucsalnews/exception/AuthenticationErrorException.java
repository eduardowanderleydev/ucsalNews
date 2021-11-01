package br.ucsal.ucsalnews.exception;

public class AuthenticationErrorException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AuthenticationErrorException(String msg) {
        super(msg);
    }
}
