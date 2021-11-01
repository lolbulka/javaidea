package ru.gb;

public class Employee {
    private String fio, post, mail, telNumber;
    private int salary, age;

    public String getFio() {
        return fio;
    }


    public String getPost() {
        return post;
    }

    public String getMail() {
        return mail;
    }

    public String getTelNumber() {
        return telNumber;
    }


    public int getSalary() {
        return salary;
    }


    public int getAge() {
        return age;
    }




    public Employee(String fio, String post, String mail, String telNumber, int salary, int age) {
        this.fio = fio;
        this.post = post;
        this.mail = mail;
        this.telNumber = telNumber;
        this.salary = salary;
        this.age = age;
    }
    public void print(){
        System.out.printf("Сотрудник %s, должность %s, почта %s, номер телефона %s, зарплата %d, возраст %d.\n",
                getFio(),getPost(),getMail(),getTelNumber(),getSalary(),getAge());
    }

    public static void main(String[] args) {
        Employee[] empArray = new Employee[6];
        empArray[0] = new Employee ("ivanov Ivan", "boss", "1mail.ru", "89261111111",
                90000, 30);
        empArray[1] = new Employee("Petrov Jhon", "teacher", "2mail.ru", "89261111111",
                80000, 20);
        empArray[2] = new Employee("Sidorov Alex", "engineer", "3mail.ru", "89261111111",
                30000, 35);
        empArray[3] = new Employee("Brown Ivan", "cooker", "1mail.ru", "89261111111",
                70000, 60);
        empArray[4] = new Employee("White Petr", "doctor", "5mail.ru", "89261111111",
                30000, 50);
        empArray[5] = new Employee("ivanov Ivan", "policeman", "1mail.ru", "89261111111",
                50000, 40);
        for (Employee s : empArray) {
            if (s.getAge() > 40) {
                s.print();
            }
        }
    }
}
