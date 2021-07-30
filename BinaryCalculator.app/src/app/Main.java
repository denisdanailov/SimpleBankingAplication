package app;

import static javax.swing.JOptionPane.*;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        String[] options = {
                "calculateBinaryToDecimal",
                "calculateDecimalToBinary",
                "calculateDecimalToHexadecimal"
        };

        long output;
        ImageIcon icon = new ImageIcon("/Users/denisdanailov/IdeaProjects/BinaryCalculator.app/src/app/img/calculator_logo.jpg");

        String calculateOption = selectOption(icon, "Please, select CalculateOption", JOptionPane.QUESTION_MESSAGE, options, options[2]);
        Calculate calculate = new Calculate();
        boolean worked = true;
        while (worked) {

            switch (calculateOption) {
                case "calculateBinaryToDecimal":

                    String calculateOption2 = selectOption(icon, "Please, write a number", INFORMATION_MESSAGE, null, null);

                    output = calculate.calculateBinaryToDecimal(Long.parseLong(calculateOption2));

                    JOptionPane.showMessageDialog(null,output,"Answer", INFORMATION_MESSAGE);

                    worked = replay();
                    break;

                case "calculateDecimalToBinary":
                    String calculateDtoB = selectOption(icon, "Please, write a number", INFORMATION_MESSAGE, null, null);

                    output = calculate.calculateDecimalToBinary(Long.parseLong(calculateDtoB));

                    JOptionPane.showMessageDialog(null,output,"Answer", INFORMATION_MESSAGE);

                    worked = replay();
                    break;

                case "calculateDecimalToHexadecimal":

                    String calculateHex = selectOption(icon, "Please, write a number", INFORMATION_MESSAGE, null, null);

                    String result = calculate.calculateHexadecimalToDecimal(calculateHex);

                    JOptionPane.showMessageDialog(null,result,"Answer", INFORMATION_MESSAGE);

                    worked = replay();
                    break;

            }
        }



    }

    private static boolean replay() {
        int reply = JOptionPane.showConfirmDialog(null, "try again?", "retry", YES_NO_OPTION);
        boolean worked;
        if (reply == YES_OPTION) {
            worked = true;
        } else {
            JOptionPane.showMessageDialog(null, "GoodBye");
            worked = false;
        }
        return worked;
    }

    private static String selectOption(ImageIcon icon, String message, int informationMessage, String[] options, String option) {
        return (String) JOptionPane.showInputDialog(null, message,

                "Calculator", informationMessage, icon, options, option);
    }
}
