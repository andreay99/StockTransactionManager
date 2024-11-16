@SuppressWarnings("serial")
public class QueueUnderflowException extends RuntimeException {
    public QueueUnderflowException() {
        super("Queue is empty.");
    }

    public QueueUnderflowException(String message) {
        super(message);
    }
}