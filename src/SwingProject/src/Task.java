import java.util.List;

public class Task {
        private String name;
        private String sql;
        private List<Task> dependencies;
        // constructor, getters, and setters
        private Task(String name,String sql){
            this.name=name;
            this.sql=sql;
        }


}
