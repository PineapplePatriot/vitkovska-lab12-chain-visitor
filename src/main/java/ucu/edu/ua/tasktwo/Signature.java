package ucu.edu.ua.tasktwo;

import java.util.function.Consumer;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Signature<T> extends Task<T> {
    private Consumer<T> consumer;
    private StampingVisitor stampingVisitor = new StampingVisitor();
    public Signature(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    public void apply(T arg) {
        this.freeze();
        stampingVisitor.onSignature(this, this.getHeaders());
        consumer.accept(arg);
    }
}
