package Service;

import DTOs.*;
import Repository.Entities.*;
import Repository.StudentsRepository;
import Repository.TeachersRepository;

import java.util.List;

public class ChangeClassService {

    private final TeachersServiceImplementation teachersServiceImplementation = new TeachersServiceImplementation();
    private final StudentsServiceImplementation studentsServiceImplementation = new StudentsServiceImplementation();


    public List<StudentsInClassroom> changeListOfStudentsInClassroomToEntities(List<StudentsInClassroomDTO> list){
        List<StudentsInClassroom> listEntities = null;
        for(StudentsInClassroomDTO student : list){
            listEntities.add(changeToStudentsInClassroomEntity(student));
        }
        return listEntities;
    }

    public List<StudentsInClassroomDTO> changeListOfStudentsInClassroomToDTO(List<StudentsInClassroom> list){
        List<StudentsInClassroomDTO> listDTO = null;
        for(StudentsInClassroom student : list){
            listDTO.add(changeToStudentsInClassroomDTO(student));
        }
        return listDTO;
    }

    public ClassroomsDTO changeToClassroomsDTO(Classrooms classroom){
        return new ClassroomsDTO(
                classroom.getId(),
                classroom.getName(),
                classroom.getCourse(), 
                changeToSubjectDTO(classroom.getSubject()),
                teachersServiceImplementation.changeToTeacherDTO(classroom.getTeacher()),
                changeListOfStudentsInClassroomToDTO(classroom.getStudents()),
                classroom.getQuantityOfStudents()
        );
    }

    public Classrooms changeToClassroomEntity(ClassroomsDTO classroom){
        return new Classrooms(
                classroom.getId(),
                classroom.getName(),
                classroom.getCourse(),
                changeToSubjectEntity(classroom.getSubject()),
                teachersServiceImplementation.changeToTeacherEntity(classroom.getTeacher()),
                changeListOfStudentsInClassroomToEntities(classroom.getStudents()),
                classroom.getQuantityOfStudents()
        );
    }

    public SubjectsDTO changeToSubjectDTO(Subjects subjects){
        return new SubjectsDTO(
                subjects.getId(), 
                subjects.getName(),
                subjects.getCourse(),
                subjects.getDescription()
        );
    }

    public Subjects changeToSubjectEntity(SubjectsDTO subjects){
        return new Subjects(
                subjects.getId(),
                subjects.getName(),
                subjects.getCourse(),
                subjects.getDescription()
        );
    }

    public GradesDTO changeToGradesDTO(Grades grades){
        return new GradesDTO(
                grades.getId(),
                grades.isItsfinal(), 
                studentsServiceImplementation.changeToStudentsDTO(grades.getStudent()),
                changeToSubjectDTO(grades.getSubject()),
                grades.getCourse(),
                grades.getGrade(),
                grades.getDescription()
        );
    }

    public Grades changeToGradesEntity(GradesDTO grades){
        return new Grades(
                grades.getId(),
                grades.isItsfinal(),
                studentsServiceImplementation.changeToStudentEntity(grades.getStudent()),
                changeToSubjectEntity(grades.getSubject()),
                grades.getCourse(),
                grades.getGrade(),
                grades.getDescription()
        );
    }

    public StudentsInClassroomDTO changeToStudentsInClassroomDTO(StudentsInClassroom studentsInClassroom){
        return new StudentsInClassroomDTO(
                studentsInClassroom.getId(),
                studentsServiceImplementation.changeToStudentsDTO(studentsInClassroom.getStudent()),
                changeToClassroomsDTO(studentsInClassroom.getClassroom())
        );
    }

    public StudentsInClassroom changeToStudentsInClassroomEntity(StudentsInClassroomDTO studentsInClassroom){
        return new StudentsInClassroom(
                studentsInClassroom.getId(),
                studentsServiceImplementation.changeToStudentEntity(studentsInClassroom.getStudent()),
                changeToClassroomEntity(studentsInClassroom.getClassroom())
        );
    }
    
}
