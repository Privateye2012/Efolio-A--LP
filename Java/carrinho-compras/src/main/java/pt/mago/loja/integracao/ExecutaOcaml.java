package pt.mago.loja.integracao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementação de execução de código Ocaml
 * Permite executar executáveis que foram desenvolvidos em Ocaml
 * passando-lhes argumentos pelo standard input e obtendo o resultado
 * pelo standard output
 */
public class ExecutaOcaml {

    public static String execute(String nomeExecutavel, String ocamlCommand, Object information) {
        try {
            // Command to execute
            String[] command = { nomeExecutavel, ocamlCommand, information.toString()};
            // Create a process builder
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();
            // Read the output of the process
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new
                InputStreamReader(inputStream));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
            result.append(line).append("\n");
            }
            // Wait for the process to complete
            int exitCode = process.waitFor();
            // Print the result
            return result.toString();
            // System.out.println("Exit code: " + exitCode);
            // System.out.println("Output:\n" + result.toString());
        } catch(IOException|InterruptedException e) {
            e.printStackTrace();
            return "";
        }

        /*
    try
    {
        // Create a list of numbers
        List<Integer> numberList = List.of(4, 2, 8, 1, 3);
        // Convert the list to a string
        String numbers = numberList.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        // Command to execute
        String[] command = { "ocaml/_build/default/bin/main.exe", "sort",
                numbers };
        // Create a process builder
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();
        // Read the output of the process
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            result.append(line).append("\n");
        }
        // Wait for the process to complete
        int exitCode = process.waitFor();
        // Print the result
        System.out.println("Exit code: " + exitCode);
        System.out.println("Output:\n" + result.toString());
        // Process the output to get the ordered numbers
        String[] sortedNumbers = result.toString().trim().split(",");
        List<Integer> orderedNumbers = new ArrayList<>();

        for (String number : sortedNumbers) {
            orderedNumbers.add(Integer.parseInt(number));
        }
        // Print the ordered numbers
        System.out.println("Ordered numbers:");
        for (Integer num : orderedNumbers) {
            System.out.println(num);
        }
    }catch(IOException|
    InterruptedException e)
    {
        e.printStackTrace();
    }
    */
    }
}
