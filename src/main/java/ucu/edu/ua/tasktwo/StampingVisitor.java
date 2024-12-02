package ucu.edu.ua.tasktwo;

import java.util.HashMap;
import java.util.Map;

public class StampingVisitor {
    private boolean inGroup;

    public <T> Map<String, Object> onGroupStart(
        Group<T> group, Map<String, String> headers) {
        this.inGroup = true;
        Map<String, Object> result = new HashMap<>();
        result.put("in_group", new boolean[]{this.inGroup});
        result.put("stamped_headers", new String[]{"in_group"});
        return result;
    }

    public <T> void onGroupEnd(Group<T> group, Map<String, String> headers) {
        this.inGroup = false;
    }

    public <T> Map<String, Object> onSignature(
        Signature<T> signature, Map<String, String> headers) {
        Map<String, Object> result = new HashMap<>();
        result.put("in_group", new boolean[]{this.inGroup});
        result.put("stamped_headers", new String[]{"in_group"});
        return result;
    }
}
