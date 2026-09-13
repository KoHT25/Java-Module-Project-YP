import java.util.Scanner;

//В некоторых местах регулярки подсказал Практикум ИИ, остальное сам

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car[] cars = new Car[3];
        Race race = new Race();

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите название машины №" + (i + 1) + ":");
            String userName = scanner.nextLine().trim(); // Тут я подумал, что лучше будет удалить пробелы по краям, с чем мне помог ИИ

            while (userName.isEmpty()) {
                // Этого нет в условии задачи, но подумал лучше будет чтобы код не принимал пустое название
                System.out.println("Название машины не может быть пустым");
                System.out.println("Введите название машины №" + (i + 1) + ":");
                userName = scanner.nextLine().trim();
            }

            int userSpeed;

            while (true) {
                System.out.println("Введите скорость машины №" + (i + 1) + ":");
                String input = scanner.nextLine().trim();

                try { // ИИ подсказал мне, как сделать так, чтобы код не принимал невалидные данные
                    userSpeed = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Неправильная скорость");
                    continue;
                }

                if (userSpeed > 0 && userSpeed <= 250) {
                    break;
                }

                System.out.println("Неправильная скорость");
            }

            cars[i] = new Car(userName, userSpeed);
            race.newLeader(userName, userSpeed);
        }
        scanner.close();
        System.out.println("Самая быстрая машина: " + race.getLeader());
    }
}