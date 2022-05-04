package FinctionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05_FilterByAge_M {
    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

//
        Function<String, Person> parsePerson = str -> {
            String[] split = str.split(",\\s+");
            return new Person(split[0], Integer.parseInt(split[1]));
        };
        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            people.add(parsePerson.apply(scanner.nextLine()));
        }
        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        people = condition.equals("older")
//              ресултата от филтъра, извикан с пийпъл колекцията и предиката
                ? filterPeople(people, p -> p.age >= ageCondition)
                : filterPeople(people, p -> p.age <= ageCondition);

        System.out.println(formatPeople(people, getFormatterFunction(format),System.lineSeparator()));

    }

    private static Function<Person,String> getFormatterFunction(String type) {
        switch (type){
            case "name":
                return p -> p.name;
            case "age":
                return p-> String.valueOf(p.age);
            case "name age":
                return  p-> p.name + " - "+ p.age;
            default:throw new IllegalStateException("Unknown type type "+ type );
        }

    }
//на всеки пърсън да върна формата във вид на Стринг + делимитер
    public static String formatPeople (Collection<Person> people,
                                       Function<Person,String> formatter,
                                       String delimiter){
         return people.stream()
                 .map(formatter::apply)
                 .collect(Collectors.joining(delimiter));
    }
// връша нов лист, приема колекшън Пийпъл, връща листа филтриран по зададения предикат,
//    който е подаден. Полиформисъм на метод!
    public static List<Person> filterPeople(Collection<Person> people,
                                            Predicate<Person> predicate) {
        return people.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
