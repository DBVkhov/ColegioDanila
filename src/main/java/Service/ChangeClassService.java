package Service;

import DTOs.*;
import Repository.Entities.*;
import java.util.List;

public class ChangeClassService {


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

    public List<Grades> changeListOfGradesDTOToEntities(List<GradesDTO> list){
        List<Grades> listGrades = null;
        for(GradesDTO grade : list){
            listGrades.add(changeToGradesEntity(grade));
        }
        return listGrades;
    }

    public List<GradesDTO> changeListOfGradesToDTO(List<Grades> list){
        List<GradesDTO> listGrades = null;
        for(Grades grade : list){
            listGrades.add(changeToGradesDTO(grade));
        }
        return listGrades;
    }

    public ClassroomsDTO changeToClassroomsDTO(Classrooms classroom){
        return new ClassroomsDTO(
                classroom.getId(),
                classroom.getName(),
                classroom.getCourse(), 
                changeToSubjectDTO(classroom.getSubject()),
                changeToTeacherDTO(classroom.getTeacher()),
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
                changeToTeacherEntity(classroom.getTeacher()),
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
                changeToStudentsDTO(grades.getStudent()),
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
                changeToStudentEntity(grades.getStudent()),
                changeToSubjectEntity(grades.getSubject()),
                grades.getCourse(),
                grades.getGrade(),
                grades.getDescription()
        );
    }

    public StudentsInClassroomDTO changeToStudentsInClassroomDTO(StudentsInClassroom studentsInClassroom){
        return new StudentsInClassroomDTO(
                studentsInClassroom.getId(),
                changeToStudentsDTO(studentsInClassroom.getStudent()),
                changeToClassroomsDTO(studentsInClassroom.getClassroom())
        );
    }

    public StudentsInClassroom changeToStudentsInClassroomEntity(StudentsInClassroomDTO studentsInClassroom){
        return new StudentsInClassroom(
                studentsInClassroom.getId(),
                changeToStudentEntity(studentsInClassroom.getStudent()),
                changeToClassroomEntity(studentsInClassroom.getClassroom())
        );
    }

    public StudentsDTO changeToStudentsDTO(Students student){
        StudentsDTO studentDTO = new StudentsDTO(
                student.getId(),
                student.getDni(),
                student.getName(),
                student.getAge(),
                student.getCourse(),
                changeListOfStudentsInClassroomToDTO(student.getClassrooms())
        );
        return studentDTO;
    }

    public Students changeToStudentEntity(StudentsDTO student){
        Students studentEnt = new Students(
                student.getId(),
                student.getDni(),
                student.getName(),
                student.getAge(),
                student.getCourse(),
                changeListOfStudentsInClassroomToEntities(student.getClassrooms())
        );
        return studentEnt;
    }

    public TeachersDTO changeToTeacherDTO(Teachers teacher){
        TeachersDTO teacherDTO = new TeachersDTO(
                teacher.getId(),
                teacher.getName(),
                teacher.getDni(),
                teacher.getAge(),
                changeToSubjectDTO(teacher.getSubject())
        );
        return teacherDTO;
    }

    public Teachers changeToTeacherEntity(TeachersDTO teacher){
        Teachers teacherEnt = new Teachers(
                teacher.getId(),
                teacher.getName(),
                teacher.getDni(),
                teacher.getAge(),
                changeToSubjectEntity(teacher.getSubject())
        );
        return teacherEnt;
    }

    public UsersDTO changeToUserDTO(Users users){return new UsersDTO(users.getId(), users.getPassword());}

    public Users changeToUserEntity(UsersDTO user){return new Users(user.getId(), user.getPassword());}

}
