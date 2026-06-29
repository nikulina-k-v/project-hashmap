package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class SalesReportTest {

    @Test
    @DisplayName("Отчёт продаж. Создание HashMap и вывод по каждому товару")
    void printSalesReport() {
        SalesReport report = new SalesReport();
        report.addSaleToMap("Хлеб", 120);
        report.addSaleToMap("Молоко", 85);
        report.addSaleToMap("Сыр", 300);
        report.addSaleToMap("Яблоки", 150);
        report.addSaleToMap("Кофе", 250);

        SalesReport.printSalesReport(report.getSalesMap());

        // 3. Добавляем новую позицию по названию
        report.addSaleToMap("Чай", 90);

        System.out.println("--- Добавили новую позицию \"Чай\" ---");
        SalesReport.printSalesReport(report.getSalesMap());

        // 4. Модифицируем существующую позицию по названию (прибавление и вычитание)
        report.addSaleToMap("Хлеб", report.getSalesMap().get("Хлеб") + 60);     // продали ещё хлеба
        report.addSaleToMap("Молоко", report.getSalesMap().get("Молоко") - 25); // часть молока вернули

        System.out.println("--- Продали хлеб на 60, молоко на 25 вернули ---");
        SalesReport.printSalesReport(report.getSalesMap());

        // 5. Удаляем позицию по названию
        report.getSalesMap().remove("Яблоки");

        System.out.println("--- Яблоки сняты с продажи ---");
        SalesReport.printSalesReport(report.getSalesMap());

        // 6. containsKey возвращает true, если такой ключ есть в map, иначе false.
        //    Удобно проверять наличие позиции перед изменением, чтобы не словить NullPointerException на get().
        if (report.getSalesMap().containsKey("Сыр")) {
            report.addSaleToMap("Сыр", report.getSalesMap().get("Сыр") + 100);
        }
        if (!report.getSalesMap().containsKey("Колбаса")) {
            System.out.println("Позиции \"Колбаса\" в отчёте нет, изменять нечего");
        }

        // Итоговый отчёт после изменений
        System.out.println("--- Итоговый отчет ---");
        SalesReport.printSalesReport(report.getSalesMap());
    }
}
