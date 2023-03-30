package DTOs;

public class SubjectsDTO {

    int id;

    String name;

    int course;

    String description;

    public SubjectsDTO(int id, String name, int course, String description) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
