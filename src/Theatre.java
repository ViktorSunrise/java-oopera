import java.util.ArrayList;

public class Theatre {
    public static void main(String[] args) {
        // 1. Актёры, режиссёры, автор музыки и хореограф
        Actor actor1 = new Actor("Анна", "Смирнова", Gender.FEMALE, 1.70);
        Actor actor2 = new Actor("Борис", "Петров", Gender.MALE, 1.85);
        Actor actor3 = new Actor("Вера", "Орлова", Gender.FEMALE, 1.65);

        Director director1 = new Director("Иван", "Иванов", Gender.MALE, 5);
        Director director2 = new Director("Мария", "Кузнецова", Gender.FEMALE, 3);

        // Автор музыки и хореограф — это просто имена-строки в полях классов
        String musicAuthor = "Пётр Чайковский";
        String choreographer = "Мариус Петипа";

        // 2. Три спектакля: обычный, оперный и балет
        Show show = new Show("Гамлет", 180, director1, new ArrayList<>());

        Opera opera = new Opera(
                "Евгений Онегин",
                210,
                director1,
                new ArrayList<>(),
                musicAuthor,
                "История любви Татьяны к Онегину и её перерождения",
                7
        );

        Ballet ballet = new Ballet(
                "Щелкунчик",
                150,
                director2,
                new ArrayList<>(),
                musicAuthor,
                "Волшебная история девочки Маши и Щелкунчика",
                choreographer
        );

        // 3. Распределяем актёров (один актёр может играть в нескольких спектаклях)
        show.addActor(actor1);
        show.addActor(actor2);

        opera.addActor(actor2);
        opera.addActor(actor3);

        ballet.addActor(actor1);
        ballet.addActor(actor3);

        // 4. Списки актёров для каждого спектакля
        System.out.println("******** Спектакль «Гамлет» ********");
        show.printListOfActors();

        System.out.println("******** Опера «Евгений Онегин» ********");
        opera.printListOfActors();

        System.out.println("******** Балет «Щелкунчик» ********");
        ballet.printListOfActors();

        // 5. Замена актёра в спектакле на актёра из другого спектакля
        System.out.println("\nЗамена Петрова на Смирнову в опере:");
        opera.replaceActor(actor1, "Петров");   // Петрова заменяем Анной Смирновой
        opera.printListOfActors();

        // 6. Попытка заменить несуществующего актёра в другом спектакле
        System.out.println("\nПопытка заменить несуществующего актёра в балете:");
        ballet.replaceActor(new Actor("Иван", "Иванов", Gender.MALE, 1.80), "Иванов");
        ballet.printListOfActors(); // список не изменился

        // 7. Либретто для оперы и балета
        System.out.println("\nЛибретто оперы:");
        opera.printLibretto();

        System.out.println("\nЛибретто балета:");
        ballet.printLibretto();
    }
}