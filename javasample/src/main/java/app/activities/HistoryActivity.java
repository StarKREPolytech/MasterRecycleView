package app.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import app.R;
import app.fragments.gestureRecycler.GestureRecyclerFragment;
import app.fragments.multipleChoiceRecycler.MultipleChoiceRecyclerFragment;
import app.models.HistoryManager;


/**
 * @author Игорь Гулькин on 22.04.2018.
 *
 * Класс HistoryActivity является корнем окна истории приложения.
 */

public final class HistoryActivity extends AppCompatActivity {

    /**
     * Поле HistoryManager хранит в себе список экземпляров
     * историй класса History.
     */

    private HistoryManager historyManager;

    /**
     * При создании окна истории инициализируется historyManager,
     * и мы переходим в режим множественного выбора.
     */

    @Override
    protected final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_activity);
        this.historyManager = new HistoryManager();
        this.displayMultipleChoiceRecyclerFragment();
    }

    /**
     * Создание опций меню.
     */

    @Override
    public final boolean onCreateOptionsMenu(final Menu menu) {
        this.getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Событие выбора элемента меню определяет
     * режим выбора элементов.
     */

    @Override
    public final boolean onOptionsItemSelected(final MenuItem item) {
        final int itemID = item.getItemId();
        switch (itemID) {
            case R.id.multiple_choice_action:
                this.displayMultipleChoiceRecyclerFragment();
                break;
            case R.id.gesture_action:
                this.displayGestureRecyclerFragment();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Режим множественного выбора.
     */

    private void displayMultipleChoiceRecyclerFragment() {
        final Fragment fragment = new MultipleChoiceRecyclerFragment(historyManager);
        this.setTitle(getString(R.string.multiple_choice_recycler_name));
        this.getSupportFragmentManager().beginTransaction().replace(R.id.main_container
                , fragment).commit();
    }

    /**
     * Режим перетаскивания и удаленя элементов.
     */

    private void displayGestureRecyclerFragment() {
        final Fragment fragment = new GestureRecyclerFragment(historyManager);
        this.setTitle(getString(R.string.gesture_recycler_name));
        this.getSupportFragmentManager().beginTransaction().replace(R.id.main_container
                , fragment).commit();
    }
}