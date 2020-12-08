package com.example.mobileapplication;

public class Phraser {
    public static String PhraserGen(String position) {
        //Создайте три набора слов для выбора. Можете добавлять собственные слова!
        String[] wordListOne = {"круглосуточный", "трех-звенный",
                "30-футовьй", "взаимный", "обоюдный выигрыш", "фронтэнд",
                "на основе веб-технологий", "проникащий", "умный", "динамичный"};

        String[] wordListTwo = {"уполномоченный", "трудный",
                "чистый продукт", "ориентированный", "центральный",
                "распределенный", "кластеризованный", "фирменный",
                "нестандартный ум", "позиционированный", "сетевой",
                "сфокусированный", "использованный с выгодой", "выровненный",
                "целесообразный", "общий", "совместный", "ускоренный"};

        String[] wordListThree = {"процесс", "пункт разгрузки",
                "выход из положения", "тип структуры", "талант", "подход",
                "уровень завоеванного внимания", "портал", "период времени",
                "обзор", "образец", "пункт следования"};

        // Вычисляем, сколько слов в каждом списке
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;
        //Генерируем три случайных числа
        int rl = (int) (Math.random() * oneLength) ;
        int r2 = (int) (Math.random() * twoLength) ;
        int r3 = (int) (Math.random() * threeLength);
        //Теперь строим фразу
        String result = wordListOne[rl] + " " +
                wordListTwo[r2] + " " + wordListThree[r3];

        switch (position) {
            case "before":
                return capitalize(result) + " - это всё, что нам нужно.";
            case "after":
                return "Всё, что нам нужно - это " + result + ".";
            default:
                return capitalize(result) + ".";
        }
    }

    public static String capitalize(String phrase){
        if (phrase.isEmpty()) {
            return "";
        }
        return phrase.substring(0, 1).toUpperCase() + phrase.substring(1);
    }
}
