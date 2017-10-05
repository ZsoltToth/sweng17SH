package hu.uni.miskolc.iit.sweng.core.dao.exceptions;

/**
 * Created by tothzs on 2017.10.05..
 */
public class ActorNotFoundException extends PersistenceException {

    public ActorNotFoundException() {
    }

    public ActorNotFoundException(String message) {
        super(message);
    }

    public ActorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
