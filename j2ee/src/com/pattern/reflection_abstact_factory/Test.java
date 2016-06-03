package com.pattern.reflection_abstact_factory;

public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Person student = PersonFactory.getPersonWithFullQualifiedClassName("com.pattern.reflection_abstact_factory.Student");
        student.say();
        Person teacher = PersonFactory.getPersonWithClass(Teacher.class);
        teacher.say();
        Person student2 = PersonFactory.getPersonWithName("student");
        student2.say();
    }
}
