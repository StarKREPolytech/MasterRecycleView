package app.models;

import java.util.ArrayList;

/**
 * Класс HistoryManager хранит в себе
 * список истории в виде ArrayList.
 */

public final class HistoryManager {

    /**
     * historyList - список историй.
     */

    private ArrayList<History> historyList;

    /**
     * mockItems() - заполняет массив историями.
     * Поскольку в данном проекте не определен
     * принцип создания историй, существует
     * временный метод mockItems().
     * @return лист историй.
     */

    public final ArrayList<History> mockItems() {
        this.historyList = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            final History history = new History();
            history.setId(i);
            history.setRate((int) (Math.random() * 5)); //Пока рейтинг устанавливаем случайно
            history.setName("History name for index " + i);
            this.historyList.add(history);
        }
        return historyList;
    }

    /**
     *Стандартный геттер списка историй.
     */

    public final ArrayList<History> getHistoryList() {
        return historyList;
    }
}