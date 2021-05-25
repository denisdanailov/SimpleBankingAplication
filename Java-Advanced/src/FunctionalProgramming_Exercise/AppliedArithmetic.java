package FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());



        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("end")) {

            if(command.equalsIgnoreCase("print")) {
                numbers.forEach(e -> System.out.println(e + " "));
            } else {
                numbers = mathOperations(command, numbers);
            }

            command = scanner.nextLine();
        }
    }
    public static List<Integer> mathOperations(String command, List<Integer> numbers) {
        Function<List<Integer>, List<Integer>> function = list -> {
            for (int i = 0; i < list.size() ; i++) {
                if (command.equalsIgnoreCase("add")) {
                    list.set(i,list.get(i) + 1);
                } else if (command.equalsIgnoreCase("multiply")) {
                    list.set(i, list.get(i) * 2);
                } else if (command.equalsIgnoreCase("subtract")) {
                    list.set(i, list.get(i) - 1);
                }
             }
            return list;
        };

        return function.apply(numbers);

    }
}
