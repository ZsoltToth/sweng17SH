package hu.uni.miskolc.iit.sweng.core.dao.exceptions;

/**
 * Created by tothzs on 2017.10.05..
 */
public class PersistenceException extends Exception {

    public PersistenceException() {
    }

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
