package cz.metacentrum.perun.scim.api.exceptions;

import cz.metacentrum.perun.core.api.exceptions.PerunException;
import cz.metacentrum.perun.scim.SCIM;

/**
 * Exception for SCIM module.
 * 
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
public class SCIMException extends PerunException {

    public SCIMException() {
        super();
    }

    public SCIMException(String message) {
        super(message);
    }

    public SCIMException(Throwable cause) {
        super(cause);
    }

    public SCIMException(String message, Throwable cause) {
        super(message, cause);
    }
}
