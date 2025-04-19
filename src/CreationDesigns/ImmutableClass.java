package CreationDesigns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClass {

    private final String name;
    private final List<String> nameList;

    public ImmutableClass(String name , List<String> names) {
        this.name = name;
        this.nameList = new ArrayList<>(names);
    }

    public String getName() {
        return name;
    }

    public List<String> getNameList() {
        return Collections.unmodifiableList(nameList);
    }
}

record Student(String name , int rollNo, List<String> courses) {
    public Student {
        if (rollNo <1){
            throw new IllegalArgumentException("roll number should be greater than 0");
        }
        name= name.trim();
    }
}
