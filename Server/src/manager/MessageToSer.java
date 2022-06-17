package manager;

import java.io.Serial;
import java.io.Serializable;

public class MessageToSer implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String message;

    public MessageToSer(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageToSer: " + message;
    }
}
