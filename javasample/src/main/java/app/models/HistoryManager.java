package app.models;

import java.util.ArrayList;

/**
 * Created by StarKRE on 22.04.2018.
 */

public final class HistoryManager {

    private ArrayList<History> historyList;

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

    public final ArrayList<History> getHistoryList() {
        return historyList;
    }
}
