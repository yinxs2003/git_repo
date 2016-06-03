package com.pattern.reflection_abstact_factory;

public class PersonFactory {
    public static Person getPersonWithFullQualifiedClassName(String personType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> personClass = Class.forName(personType);
        return getPersonWithClass(personClass);
    }

    public static Person getPersonWithClass(Class personClass) throws IllegalAccessException, InstantiationException {
        return (Person) personClass.newInstance();
    }

    // no reflection, the ordinary way
    public static Person getPersonWithName(String personType) {
        if (personType.equalsIgnoreCase("STUDENT")) {
            return new Student();
        } else if (personType.equalsIgnoreCase("TEACHER")) {
            return new Teacher();
        }
        return null;
    }
}
