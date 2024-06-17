import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue<T> {
    private Queue<T> queue;

    public MessageQueue(Class<? extends T> dataType) {
        queue = new LinkedList<>();
    }

    public void addMessage(T message) {
        queue.add(message);
    }

    public T getMessage() {
        return queue.poll();
    }
    public void clear(){
        queue.clear();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
