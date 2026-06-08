package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    @DisplayName("Отчёт продаж. Создание HashMap и вывод по каждому товару")
    void salesReport() {
        Main.salesReport();
    }
}
