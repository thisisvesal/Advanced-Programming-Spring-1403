import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        // Check out the Changeling class to learn more about the methods used here

        try {
            BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            String word;
            int count = 0;
            while ((word = reader.readLine()) != null) {

                String numberString = Changeling.numbersIn(word);

                String[] numberChangelingList = Changeling.changelingList(numberString);

                for (int i = 0; i < Changeling.countOfChangelings(numberString); i++) {

                    writer.write(Changeling.modifiedNumbers(word, numberChangelingList[i]));

                    if (i == Changeling.countOfChangelings(numberString) - 1) {
                        writer.write("\n");
                    } else {
                        writer.write(" , ");
                    }
                }

                count += Changeling.countOfChangelings(word);

                // System.out.println(count + "files of 25417064 written");
            }

            System.out.println(count);

            reader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}