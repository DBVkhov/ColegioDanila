package Service;

import DTOs.ClassroomsDTO;
import DTOs.StudentsDTO;
import DTOs.SubjectsDTO;
import DTOs.TeachersDTO;
import Repository.ClassroomsRepository;
import Repository.Entities.Subjects;
import Repository.StudentsRepository;
import Repository.SubjectsRepository;
import Repository.TeachersRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;

public class AdminsServiceImplementation implements AdminsService{

    private final ChangeClassService changeClassService = new ChangeClassService();
    private final ClassroomsRepository classroomsRepository = new ClassroomsRepository();
    private final TeachersRepository teachersRepository = new TeachersRepository();
    private final StudentsRepository studentsRepository = new StudentsRepository();
    private final SubjectsRepository subjectsRepository = new SubjectsRepository();

    @Override
    public void addTeacherDTOToDB(TeachersDTO teacher) {
        teachersRepository.setNewTeacherInDB(changeClassService.changeToTeacherEntity(teacher));
    }

    @Override
    public void addClassroomDTOToDB(ClassroomsDTO classroom) {
        classroomsRepository.setNewClassroomInDB(changeClassService.changeToClassroomEntity(classroom));
    }

    @Override
    public void addStudentDTOToDB(StudentsDTO student) {
        studentsRepository.setNewStudentInDB(changeClassService.changeToStudentEntity(student));
    }

    @Override
    public void changeTeacherDTOToDB(TeachersDTO teacher) throws IOException, SQLException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(teacher.getDni());
        System.out.println("DNI: ");
        String dni = bufferedReader.readLine();
        System.out.println(teacher.getName());
        System.out.println("name: ");
        String name = bufferedReader.readLine();
        System.out.println(teacher.getAge());
        System.out.println("Date birthday(yyyy-mm-dd): ");
        Date date = Date.valueOf(bufferedReader.readLine());
        System.out.println(teacher.getSubject().getName() + ", " + teacher.getSubject().getId());
        System.out.println("Choose a subject by ID:");
        for(Subjects subjects : subjectsRepository.getAllSubjects()){
            System.out.println(subjects.getName() + ", " + subjects.getId() + "\n");
        }
        int idsubject = Integer.parseInt(bufferedReader.readLine());
        SubjectsDTO subjects = changeClassService.changeToSubjectDTO(subjectsRepository.getSubjectByID(idsubject));
        teachersRepository.modifyTeacherInDB(
                teacher.getId(),
                dni,
                name,
                date,
                changeClassService.changeToSubjectEntity(subjects));
    }

    @Override
    public StudentsDTO searchStudentDTOByID(int id) throws SQLException {
        return changeClassService.changeToStudentsDTO(
                studentsRepository.getStudentByIDFromDB(id)
        );
    }
}
