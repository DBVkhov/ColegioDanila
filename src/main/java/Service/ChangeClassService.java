package Service;

import DTOs.*;
import Repository.Entities.*;

public class ChangeClassService {

    public ClassroomsDTO changeToClassroomsDTO(Classrooms classroom){
        return new ClassroomsDTO(
                classroom.getId(),
                classroom.getName(),
                classroom.getCourse(), 
                classroom.getSubject(),
                classroom.getTeacher(),
                classroom.getStudents(),
                classroom.getQuantityOfStudents()
        );
    }

    public Classrooms changeToClassroomEntity(ClassroomsDTO classroom){
        return new Classrooms(
                classroom.getId(),
                classroom.getName(),
                classroom.getCourse(),
                classroom.getSubject(),
                classroom.getTeacher(),
                classroom.getStudents(),
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
                grades.getStudent(),
                grades.getSubject(),
                grades.getCourse(),
                grades.getGrade(),
                grades.getDescription()
        );
    }

    public Grades changeToGradesEntity(GradesDTO grades){
        return new Grades(
                grades.getId(),
                grades.isItsfinal(),
                grades.getStudent(),
                grades.getSubject(),
                grades.getCourse(),
                grades.getGrade(),
                grades.getDescription()
        );
    }

    public StudentsInClassroomDTO changeToStudentsInClassroomDTO(StudentsInClassroom studentsInClassroom){
        return new StudentsInClassroomDTO(
                studentsInClassroom.getId(),
                studentsInClassroom.getStudent(),
                studentsInClassroom.getClassroom()
        );
    }

    public StudentsInClassroom changeToStudentsInClassroomEntity(StudentsInClassroomDTO studentsInClassroom){
        return new StudentsInClassroom(
                studentsInClassroom.getId(),
                studentsInClassroom.getStudent(),
                studentsInClassroom.getClassroom()
        );
    }
    
}
