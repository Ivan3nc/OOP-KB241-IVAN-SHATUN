public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестування системи планування спринту ===\n");

        System.out.println("--- Створення UserStory ---");
        UserStory us1 = new UserStory(1, "Об'єкт реєстрації користувача", 5, null);
        UserStory us2 = new UserStory(2, "Форма реєстрації", 3, new UserStory[]{us1});
        UserStory us3 = new UserStory(3, "Авторизація", 4, null);

        System.out.println(us1);
        System.out.println(us2);
        System.out.println(us3);

        System.out.println("\n--- Перевірка завершення UserStory із залежностями ---");
        System.out.println("us2 (залежить від us1) завершено до complete? " + us2.isCompleted());
        us2.complete(); 
        System.out.println("us2 після спроби complete (us1 ще не завершено): " + us2.isCompleted());

        us1.complete();
        System.out.println("us1 завершено: " + us1.isCompleted());
        us2.complete(); 
        System.out.println("us2 після complete (us1 завершено): " + us2.isCompleted());

        System.out.println("\n--- Створення Bug ---");
        Bug bug1 = Bug.createBug(10, "Помилка авторизації", 2, us3);
        System.out.println("Створення Bug для незавершеної us3: " + bug1);

        Bug bug2 = Bug.createBug(2, "Додати повторюваний пароль", 2, us2);
        System.out.println("Створення Bug для завершеної us2: " + bug2);

        Bug bug3 = Bug.createBug(3, "Тест", 1, null);
        System.out.println("Створення Bug з null: " + bug3);

        System.out.println("\n--- Тестування Sprint ---");
        Sprint sprint = new Sprint(20, 4); 

        UserStory storyA = new UserStory(101, "Сторінка профілю", 5, null);
        UserStory storyB = new UserStory(102, "Налаштування", 7, null);
        UserStory storyC = new UserStory(103, "Експорт даних", 6, null);
        UserStory storyD = new UserStory(104, "Велика задача", 15, null);

        System.out.println("Додаємо storyA (5): " + sprint.addUserStory(storyA));
        System.out.println("Додаємо storyB (7): " + sprint.addUserStory(storyB));
        System.out.println("Додаємо null: " + sprint.addUserStory(null));

        UserStory completed = new UserStory(105, "Завершена", 2, null);
        completed.complete();
        System.out.println("Додаємо завершений: " + sprint.addUserStory(completed));

        System.out.println("Додаємо storyD (15) - переповнення: " + sprint.addUserStory(storyD));

        System.out.println("Додаємо bug2 (2): " + sprint.addBug(bug2));

        System.out.println("Додаємо storyC (6): " + sprint.addUserStory(storyC));

        System.out.println("\nЗагальна оцінка спринту: " + sprint.getTotalEstimate());

        System.out.println("\nТікети у спринті (у порядку додавання):");
        Ticket[] tickets = sprint.getTickets();
        for (Ticket t : tickets) {
            System.out.println("  " + t);
        }

        System.out.println("\n--- Перевірка ліміту кількості ---");
        Sprint smallSprint = new Sprint(100, 2);
        UserStory s1 = new UserStory(201, "Story 1", 5, null);
        UserStory s2 = new UserStory(202, "Story 2", 5, null);
        UserStory s3 = new UserStory(203, "Story 3", 5, null);

        System.out.println("Додаємо s1: " + smallSprint.addUserStory(s1));
        System.out.println("Додаємо s2: " + smallSprint.addUserStory(s2));
        System.out.println("Додаємо s3 (перевищення ліміту 2): " + smallSprint.addUserStory(s3));

        System.out.println("\n--- Захист копії масиву залежностей ---");
        UserStory[] deps = us2.getDependencies();
        System.out.println("Кількість залежностей us2: " + deps.length);
        deps[0] = null; 
        System.out.println("Після зміни копії, оригінал недоторканий: "
                + us2.getDependencies()[0]);
    }
}
