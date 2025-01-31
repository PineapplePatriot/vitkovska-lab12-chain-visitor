package ucu.edu.ua.tasktwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Group<T> extends Task<T> {
    private String groupUuid;
    private List<Task<T>> tasks;
    private StampingVisitor stampingVisitor = new StampingVisitor();

    public Group<T> addTask(Task<T> task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        super.freeze();
        groupUuid = UUID.randomUUID().toString();
        for (Task<T> task: tasks) {
            task.freeze();
        }
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        tasks = Collections.unmodifiableList(tasks);
        stampingVisitor.onGroupStart(this, this.getHeaders());
        for (Task<T> task: tasks) {
            task.apply(arg);
        }
        stampingVisitor.onGroupEnd(this, this.getHeaders());
    }
}
