import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        // Check out the Changeling class to learn more about the methods used here

        try {
            BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));

            String[] numberList = new String[2000];
            String word;

            int count = 0;
            for (count = 0; count < numberList.length; count++) {
                if ((numberList[count] = reader.readLine()) == null)  {
                    break;
                }
            }
            
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter("numbers.txt"));

            for (int x = 0; x < count; x++) {
                word = numberList[x];
                writer.write(word);

                String numberString = Changeling.numbersIn(word);

                if (Changeling.countOfChangelings(numberString) == 1) {
                    writer.write("\n");
                    continue;
                } else {
                    writer.write(" , ");
                }

                String[] numberChangelingList = Changeling.changelingList(numberString);

                for (int i = 0; i < Changeling.countOfChangelings(numberString); i++) {

                    writer.write(Changeling.modifiedNumbers(word, numberChangelingList[i]));

                    if (i == Changeling.countOfChangelings(numberString) - 1) {
                        writer.write("\n");
                    } else {
                        writer.write(" , ");
                    }
                }
            }

            writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}