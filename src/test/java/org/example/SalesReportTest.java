package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    }
}
