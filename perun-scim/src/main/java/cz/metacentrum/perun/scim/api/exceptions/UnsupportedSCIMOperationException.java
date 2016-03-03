package cz.metacentrum.perun.scim.api.exceptions;

/**
 * Exception for unsupported operations in SCIM module.
 *
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
public class UnsupportedSCIMOperationException extends SCIMException {

    public UnsupportedSCIMOperationException() {
        super();
    }

    public UnsupportedSCIMOperationException(String message) {
        super(message);
    }

    public UnsupportedSCIMOperationException(Throwable cause) {
        super(cause);
    }

    public UnsupportedSCIMOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
