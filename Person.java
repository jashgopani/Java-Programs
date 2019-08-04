import java.util.*;
import java.io.*;

public class Person{
	String firstname;
	String lastname;

	public Person(String firstname,String lastname){
		this.firstname = firstname.trim();
		this.lastname = lastname.trim();
	}

	public String toString(){
		return this.firstname+" "+this.lastname;
	}

	public static void main(String[] args) {

		ArrayList<Person> p = new ArrayList<>();
		p.add(new Person("Jash","Gopani"));
		p.add(new Person("Hitansh","Shah"));
		p.add(new Person("Hitanshu","Shah"));
		p.add(new Person("Chetan"," Kachaliya"));
		p.add(new Person("Myron","Carvalho"));
		p.add(new Person("Prajwal","Kotian"));
		p.add(new Person("Hima"," George"));
		p.add(new Person("Amol"," Dalwai"));

		for (int i=0;i<p.size() ;i++ ) {
			System.out.print(p.get(i)+", ");
		}
		System.out.println();

		Collections.sort(p,new Comparator<Person>(){
			@Override
			public int compare(Person a,Person b){
				return a.firstname.compareTo(b.firstname);
			}
		});

		for (int i=0;i<p.size() ;i++ ) {
			System.out.print(p.get(i)+"\t");
		}
		System.out.println();
		

	}
}