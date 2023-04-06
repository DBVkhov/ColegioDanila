package Service;

import DTOs.*;
import Repository.Entities.Grades;
import Repository.GradesRepository;

import java.sql.SQLException;
import java.util.List;

public class StudentsServiceImplementation implements StudentsService{

    private final GradesRepository gradesRepository = new GradesRepository();
    private final ChangeClassService changeClassService = new ChangeClassService();

    @Override
    public void gradesBySubject(StudentsDTO student) throws SQLException {

        List<StudentsInClassroomDTO> studentInClassroomsDTO = student.getClassrooms();

        for(StudentsInClassroomDTO studentInClassroomDTO : studentInClassroomsDTO){
            SubjectsDTO subjectDTO = studentInClassroomDTO.getClassroom().getSubject();

            List<GradesDTO> list = changeClassService.changeListOfGradesToDTO(
                    gradesRepository.getGradesByStudentIDAndSubject(
                    changeClassService.changeToStudentEntity(student),
                    changeClassService.changeToSubjectEntity(subjectDTO)));

            System.out.println("Subject: " + subjectDTO.getName());
            System.out.println("Description: " + subjectDTO.getDescription());
            System.out.println("Course: " + subjectDTO.getCourse());
            System.out.println("Grades: ");

            for (GradesDTO grades : list){
                System.out.println(grades.getDescription());
                System.out.println(grades.getGrade() + "\n");
            }
        }

    }

}
