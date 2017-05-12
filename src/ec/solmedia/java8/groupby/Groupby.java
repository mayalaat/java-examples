package ec.solmedia.java8.groupby;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * https://dzone.com/articles/java-streams-groupingby-examples
 */
public class Groupby {

    class Player {
        private int year;
        private String teamID;
        private String lgID;
        private String playerID;
        private int salary;

        public Player(int year, String teamID, String lgID, String playerID, int salary) {
            this.year = year;
            this.teamID = teamID;
            this.lgID = lgID;
            this.playerID = playerID;
            this.salary = salary;
        }

        public int getYear() {
            return year;
        }

        public String getTeamID() {
            return teamID;
        }

        public String getLgID() {
            return lgID;
        }

        public String getPlayerID() {
            return playerID;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "year=" + year +
                    ", teamID='" + teamID + '\'' +
                    ", lgID='" + lgID + '\'' +
                    ", playerID='" + playerID + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(",");
        File file = new File("/home/alejo/Projects/IdeaProjects/Java8/src/groupby/items.csv");

        Groupby groupby = new Groupby();
//        groupby.loadCVS(file, pattern);
        groupby.singleField(file, pattern);

    }

    private void loadCVS(File file, Pattern pattern) {
        //load data
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<Player> players = br
                    .lines()
                    .skip(1)
                    .map(line -> {
                        String[] arr = pattern.split(line);
                        return new Player(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], Integer.parseInt(arr[4]));
                    })
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Group by a Single Field
    private void singleField(File file, Pattern pattern) {
        //load data
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Map<Integer, List<Player>> mapa = br
                    .lines()
                    .skip(1)
                    .map(line -> {
                        String[] arr = pattern.split(line);
                        return new Player(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], Integer.parseInt(arr[4]));
                    })
                    .collect(Collectors.groupingBy(Player::getYear));

            mapa.entrySet()
                    .stream()
                    .forEach(System.out::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
