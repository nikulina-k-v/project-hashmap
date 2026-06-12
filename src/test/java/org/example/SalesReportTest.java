package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SalesReportTest {

    @Test
    @DisplayName("Задание 7. Добавление новой позиции и прибавление к существующей")
    void addSale() {
        SalesReport report = new SalesReport();
        report.addSale("Хлеб", 120);
        report.addSale("Хлеб", 60);
        report.addSale("Молоко", 85);

        String result = report.toString();
        assertTrue(result.contains("Хлеб :: 180"));
        assertTrue(result.contains("Молоко :: 85"));
    }

    @Test
    @DisplayName("Задание 7. Вычитание продажи (возврат товара)")
    void subtractSale() {
        SalesReport report = new SalesReport();
        report.addSale("Молоко", 85);
        report.subtractSale("Молоко", 25);

        assertTrue(report.toString().contains("Молоко :: 60"));
    }

    @Test
    @DisplayName("Задание 7. Удаление позиции")
    void removePosition() {
        SalesReport report = new SalesReport();
        report.addSale("Яблоки", 150);
        report.removePosition("Яблоки");

        assertFalse(report.toString().contains("Яблоки :: 150"));
    }
}
