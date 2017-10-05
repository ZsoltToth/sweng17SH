package hu.uni.miskolc.iit.sweng.core.dao.exceptions;

/**
 * Created by tothzs on 2017.10.05..
 */
public class ActorAlreadyExsistsException extends PersistenceException {

    public ActorAlreadyExsistsException() {
    }

    public ActorAlreadyExsistsException(String message) {
        super(message);
    }

    public ActorAlreadyExsistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
