package FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import People.Person;

public class SaveLoadUtility {
    public static void writePeople() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Files/people.ser"));
        out.writeObject(Person.people);
        out.close();
        System.out.println(Person.people.size() + "people were written onto people.ser");
    }

    @SuppressWarnings("unchecked")
    public static void readPeople() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Files/people.ser"));
        Person.people = (ArrayList<Person>) in.readObject();
        in.close();
        System.out.println(Person.people.size() + "people were read from people.ser");
    }
}
