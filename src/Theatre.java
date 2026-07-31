public class Theatre {
    public static void main(String[] args) {
        System.out.println("*** Тест 1: Создание актёров, режиссёров, автора музыки и хореографа ***\n");

        // 1.1. Создаём трёх актёров
        Actor actor1 = new Actor("Иван", "Петров", Gender.MALE, 182);
        Actor actor2 = new Actor("Мария", "Иванова", Gender.FEMALE, 165);
        Actor actor3 = new Actor("Фёдор", "Сидоров", Gender.MALE, 176);

        System.out.println("Созданы актёры:");
        System.out.println("- " + actor1);
        System.out.println("- " + actor2);
        System.out.println("- " + actor3);
        System.out.println();

        // 1.2. Создаём двух режиссёров
        Director director1 = new Director("Сергей", "Пратусевич", Gender.MALE, 11);
        Director director2 = new Director("Анна", "Ядова", Gender.FEMALE, 15);

        System.out.println("Созданы режиссёры:");
        System.out.println("- " + director1);
        System.out.println("- " + director2);
        System.out.println();

        // 1.3. Создаём автора музыки
        Person musicAuthor = new Person("Пётр", "Павлов", Gender.MALE);

        System.out.println("Создан автор музыки:");
        System.out.println("- " + musicAuthor);
        System.out.println();

        // 1.4. Создаём хореографа
        Person choreographer = new Person("Мариус", "Петипа", Gender.MALE);

        System.out.println("Создан хореограф:");
        System.out.println("- " + choreographer);
        System.out.println();

        System.out.println("*** Тест 2: Создание трёх спектаклей ***\n");

        // 2. Создаём три спектакля: обычный, оперный и балет
        Show play = new Show("Таврический сад", 150, director1);

        Opera opera = new Opera("Подготовка к экзамену по истории", 180, director2,
                new Person("Максим", "Жуков", Gender.MALE),
                "Либретто оперы: история заточения...",
                30);

        Ballet ballet = new Ballet("Осенний слёт", 160, director1,
                musicAuthor,
                "Либретто балета: чудесная история...",
                choreographer);

        System.out.println("Созданы спектакли:");
        System.out.println("- " + play);
        System.out.println("- " + opera);
        System.out.println("- " + ballet);
        System.out.println();

        System.out.println("*** Тест 3: Распределение актёров по спектаклям ***\n");

        // 3. Распределяем актёров по спектаклям
        // 3.1. В обычный спектакль добавляем всех трёх актёров
        play.addActor(actor1);
        play.addActor(actor2);
        play.addActor(actor3);

        // 3.2. В оперу добавляем актёров 1 и 2
        opera.addActor(actor1);
        opera.addActor(actor2);

        // 3.3. В балет добавляем актёров 2 и 3
        ballet.addActor(actor2);
        ballet.addActor(actor3);

        System.out.println("Актёры распределены по спектаклям:");
        System.out.println("- В спектакль '" + play.title + "' добавлены: " + actor1 + ", " + actor2 + ", " + actor3);
        System.out.println("- В оперу '" + opera.title + "' добавлены: " + actor1 + ", " + actor2);
        System.out.println("- В балет '" + ballet.title + "' добавлены: " + actor2 + ", " + actor3);
        System.out.println();

        // Пробуем добавить уже существующего актёра
        System.out.println("Проверка добавления дубликата:");
        play.addActor(actor1);  // получаем предупреждение => актёр не добавляется
        System.out.println();

        System.out.println("*** Тест 4: Вывод списка актёров для каждого спектакля ***\n");

        // 4. Для каждого спектакля выводим список актёров
        play.printActors();
        opera.printActors();
        ballet.printActors();

        System.out.println("*** Тест 5: Замена актёра в одном из спектаклей ***\n");

        // 5. Заменяем актёра в одном из спектаклей
        // 5.1. Создаём дополнительного актёра для замены
        Actor newActor = new Actor("Елена", "Попова", Gender.FEMALE, 168);
        System.out.println("Создан новый актёр для замены: " + newActor);
        System.out.println();

        System.out.println("Заменяем актёра в спектакле '" + play.title + "':");
        System.out.println("- Ищем актёра с фамилией 'Петров' и заменяем на " + newActor);
        play.replaceActor(newActor, "Петров");
        System.out.println();

        System.out.println("Обновлённый список актёров в спектакле '" + play.title + "':");
        play.printActors();

        System.out.println("*** Тест 6: Попытка заменить несуществующего актёра ***\n");

        // 6. Пробуем заменить в другом спектакле несуществующего актёра
        System.out.println("Пробуем заменить несуществующего актёра в опере '" + opera.title + "':");
        System.out.println("- Ищем актёра с фамилией 'Сидоров'");
        opera.replaceActor(newActor, "Сидоров");  // должен вывести предупреждение
        System.out.println();

        System.out.println("*** Тест 7: Вывод либретто для оперного и балетного спектаклей ***\n");

        // 7. Для оперного и балетного спектакля выводим текст либретто
        opera.printLibretto();
        ballet.printLibretto();

        System.out.println("*** Тестирование прошло успешно. Театр готов к новому сезону. ***");
    }
}