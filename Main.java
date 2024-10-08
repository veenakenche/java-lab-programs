import java.util.Scanner;

import java.util.ArrayList;

class Subject{

int SubjectMarks;

int credits;

int grade;

public void calculategrade(){

if(SubjectMarks>=90){

grade=10;

}

else if(SubjectMarks>=80){

grade=9;

}

else if(SubjectMarks>=70){

grade=8;

}

else if(SubjectMarks>=60){

grade=7;

}

else if(SubjectMarks>=50){

grade=6;

}

else if(SubjectMarks>=40){

grade=5;

}

else{

grade=0;

}}}

class Student{

String name;

String usn;

double sgpa;

Subject sub[];

Scanner s;

public Student()

{

int i;

sub=new Subject[8];

for(i=0;i<8;i++)

{

sub[i]=new Subject();

}

s=new Scanner(System.in);

}   

public void getStudentdetails()

{

System.out.println("Enter the Student Name:");

name=s.nextLine();

System.out.println("Enter the Student USN:");

usn=s.nextLine();

}

public void getmarks(){

for(int i=0;i<8;i++)

{

System.out.println("Enter the marks for subject"+(i+1));

sub[i].SubjectMarks=s.nextInt();

System.out.println("Enter the credits for subject"+(i+1));

sub[i].credits=s.nextInt();

sub[i].calculategrade();

}

}

public void sgpa()

{

double cre=0;

int totalcredits=0;

for(int i=0;i<8;i++)

{

cre+=sub[i].grade*sub[i].credits;

totalcredits+=sub[i].credits;

}

if(totalcredits!=0)

{

sgpa=cre/totalcredits;

}

else

{

sgpa=0;

}

}

void display()

{

System.out.println("Student Name:"+name);

System.out.println("USN:"+usn);

System.out.println("SGPA:"+sgpa);

}

}

class Main

{

public static void main(String args[])

{

Student student=new Student();

for(int i=0;i<3;i++){

student.getStudentdetails();

student.getmarks();

student.sgpa();

student.display();
}}}

