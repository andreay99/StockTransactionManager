@SuppressWarnings("serial")
public class QueueOverflowException extends RuntimeException {
    public QueueOverflowException() {
        super("Queue is full.");
    }

    public QueueOverflowException(String message) {
        super(message);
    }
}