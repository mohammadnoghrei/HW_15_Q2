package service;

import model.Person;
import repository.PersonRepository;

import java.util.List;
import java.util.Scanner;

public class PersonService  {
    private final PersonRepository personRepository=new PersonRepository();
    public void save(Person person){
        personRepository.save(person);
    }
    public void update(Person person){
        personRepository.update(person);
    }

    public void remove(long id){
        Person person =personRepository.findById(id);
        personRepository.removePerson(person);
    }
//    public void removePerson(Person person){
//        personRepository.removePerson(person);
//    }
    public List<Person> findAll(){
        return personRepository.findAll();
    }
    public Person contains(int id){return personRepository.findById(id);}

    public void singUp(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter first name");
        String firstName= scanner.next();
        scanner.nextLine();
        System.out.println("please enter last name");
        String lastName=scanner.next();
        scanner.nextLine();
        System.out.println("please enter your birth date");
        String birthDate=scanner.next();
        scanner.nextLine();
        java.sql.Date sqldate = java.sql.Date.valueOf(birthDate);
        Person person =new Person(firstName,lastName,sqldate);
        personRepository.save(person);
    }

}
