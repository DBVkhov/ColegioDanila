package Service;

import DTOs.StudentsDTO;
import Repository.Entities.Students;

public class StudentsServiceImplementation implements StudentsService{

    @Override
    public void gradesBySubject() {

    }

    public StudentsDTO changeToStudentsDTO(Students student){
        StudentsDTO studentDTO = new StudentsDTO(student.getId(), student.getDni(), student.getName(), student.getAge(), student.getCourse(), student.getClassrooms());
        return studentDTO;
    }

    public Students changeToStudentEntity(StudentsDTO student){
        Students studentEnt = new Students(student.getId(), student.getDni(), student.getName(), student.getAge(), student.getCourse(), student.getClassrooms());
        return studentEnt;
    }

}
