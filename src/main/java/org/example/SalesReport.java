package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс отчёта по продажам магазина.
 * Хранит всё взаимодействие с map внутри себя (задание 7).
 */
public class SalesReport {

    private final Map<String, Integer> sales = new HashMap<>();

    // опционально: храним суммы возвратов и удалённые позиции, чтобы показать их в отчёте
    private final Map<String, Integer> returns = new HashMap<>();
    private final List<String> removed = new ArrayList<>();

    /**
     * Добавление продажи. Если товар уже есть — прибавляем к имеющейся сумме,
     * иначе создаём новую позицию.
     */
    public void addSale(String name, int amount) {
        if (sales.containsKey(name)) {
            sales.put(name, sales.get(name) + amount);
        } else {
            sales.put(name, amount);
        }
    }

    /**
     * Вычитание продажи. Сделали возврат товара — надо вычесть сумму
     * из позиции в отчёте.
     */
    public void subtractSale(String name, int amount) {
        if (sales.containsKey(name)) {
            sales.put(name, sales.get(name) - amount);
            returns.put(name, returns.getOrDefault(name, 0) + amount);
        } else {
            System.out.println("Позиции \"" + name + "\" нет в отчёте, возврат сделать нельзя");
        }
    }

    /**
     * Удаление позиции (например, её ошибочно внесли).
     */
    public void removePosition(String name) {
        if (sales.containsKey(name)) {
            sales.remove(name);
            removed.add(name);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Отчёт по продажам:\n");
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            result.append(entry.getKey()).append(" :: ").append(entry.getValue()).append("\n");
        }
        if (!returns.isEmpty()) {
            result.append("Возвраты по позициям:\n");
            for (Map.Entry<String, Integer> entry : returns.entrySet()) {
                result.append(entry.getKey()).append(" :: ").append(entry.getValue()).append("\n");
            }
        }
        if (!removed.isEmpty()) {
            result.append("Удалённые позиции: ").append(removed).append("\n");
        }
        return result.toString();
    }
}
