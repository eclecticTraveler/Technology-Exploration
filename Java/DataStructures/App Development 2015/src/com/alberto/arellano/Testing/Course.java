package com.alberto.arellano.Testing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by rome on 10/29/2015.
 */
public class Course {
    private int count;
    private String uniqueId = "93663";
    private String sessionId;

    private HashMap<String, StudentBean> students;
    private TreeMap<String, ProfessorBean> professors;

        public Course(){
            students = new HashMap<String, StudentBean>();
            professors = new TreeMap<String, ProfessorBean>();
        }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

        public int getCount() {
            return count;
        }

        public void addStudentProfile(StudentBean aStudent){
            if(aStudent != null && aStudent.getFirstName() != null &&
                    aStudent.getLastName() != null && aStudent.getiNumber() != null) {
                String key = aStudent.getiNumber();
                students.put(key, aStudent);
                count++;

            }

        }

//        public String addProfessorsProfile(ProfessorBean aProfessor){
//            try{
//                String key = aProfessor.getFirstName();
//                professors.put(key, aProfessor);
//                String message = "Added";
//                return  message;
//            }catch (Exception e)
//            {
//                String message = "Can't have nulls";
//                return message;
//            }
//        }

    public void addProfessorsProfile(int index, ProfessorBean aProfessor){
        try{
            ArrayList<ProfessorBean> backUp = new ArrayList<ProfessorBean>();
            backUp.add(index, aProfessor);

        }catch (IndexOutOfBoundsException e)
        {
            throw new IndexOutOfBoundsException();
        }
    }

        public ProfessorBean getProfessorExtention(String professorName){

            return professors.get(professorName);

        }

        public boolean removeStudentProfile(String name){
            if (students.containsKey(name)){
                students.remove(name);
                return true;
            }
            else
                return false;
        }


        public ProfessorBean getProfessorsName(String professorsName){
            return professors.get(professorsName);

        }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
