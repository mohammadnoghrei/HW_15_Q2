package service;

import model.Person;
import repository.PersonRepository;

import java.util.List;

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

}
