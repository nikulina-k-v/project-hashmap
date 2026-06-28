package org.example;

import java.util.HashMap;
import java.util.Map;

public class SalesReport {

    /**
     * Отчет продаж магазина (вставте данный текст себе IDEA) над методом<p>
     * 1. Создайте HashMap<String, Integer> и добавьте туда список товаров и сумму продаж<p>
     * 2. Вбейте в idea - iter выберите что предложит idea (итерацию по созданному выше HashMap в методе где вы вбили iter). Вывести в консоль результат по каждому товару в терминал<p>
     * 3. Добавье по названию из map новую позицию<p>
     * 4. Модифицируйте по названию из map существующую позицию (прибавление вычитание)<p>
     * 5. Удалите по названию из map позицию<p>
     * 6. Изучите метод Map containsKey("тут ваше значение") почитайте что он возвращает, подумайте где может понадобиться и добавьте<p>
     * *7. Задача на рефакторинг кода. Вынесите всё взаимодействие с этим map в класс SalesReport <p>
     * Создайте методы в классе SalesReport, которые будут модифицировать Map:<p>
     * - добавления продажи (находит название товара и прибавляет к имеющемуся либо создает новую позицию)<p>
     * - вычитание продажи (сделали возврат товара надо вычесть из отчета сумму на которую было продано товаров по данной позиции)<p>
     * - удаление позиции (например её ошибочно внесли и необходиму удалить эту позицию)<p>
     * - отчет по продажам (переопределить метод toString которвый выведет позицию и числовое значение)<p>
     * *- опционально добавье возможность хранения удаленных и вовзратов по позициям товаров в отчет toString <p>
     */

    // 1. Создаём HashMap с товарами и суммой продаж по каждому товару
    private final HashMap<String, Integer> sales = new HashMap<>();

    public HashMap<String, Integer> getSalesMap() {
        return sales;
    }

    public void addSaleToMap(String item, Integer sum) {
        sales.put(item, sum);
    }

    public static void printSalesReport(HashMap<String, Integer> sales) {
        // 2. Итерация по HashMap (шаблон iter из IDEA), вывод по каждому товару
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println("Товар: " + entry.getKey() + " :: Сумма продаж: " + entry.getValue());
        }

        // 3. Добавляем новую позицию по названию
        sales.put("Чай", 90);

        // 4. Модифицируем существующую позицию по названию (прибавление и вычитание)
        sales.put("Хлеб", sales.get("Хлеб") + 60);     // продали ещё хлеба
        sales.put("Молоко", sales.get("Молоко") - 25); // часть молока вернули

        // 5. Удаляем позицию по названию
        sales.remove("Яблоки");

        // 6. containsKey возвращает true, если такой ключ есть в map, иначе false.
        //    Удобно проверять наличие позиции перед изменением, чтобы не словить NullPointerException на get().
        if (sales.containsKey("Сыр")) {
            sales.put("Сыр", sales.get("Сыр") + 100);
        }
        if (!sales.containsKey("Колбаса")) {
            System.out.println("Позиции \"Колбаса\" в отчёте нет, изменять нечего");
        }

        // Итоговый отчёт после изменений
        System.out.println("--- Отчёт после изменений ---");
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println("Товар: " + entry.getKey() + " :: Сумма продаж: " + entry.getValue());
        }
    }
}
