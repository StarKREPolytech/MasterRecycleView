package app.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import app.R;
import app.models.History;


/**
 * Класс HistoryItemView является классом разметки
 * для элемента исптории
 */

public final class HistoryItemView extends FrameLayout {

    private TextView mIndexTextView;

    private TextView mNameTextView;

    private TextView mTickIconView;

    //Конструкторы:

    /**
     * @param context - объект, который предоставляет
     * доступ к базовым функциям приложения: доступ к
     * ресурсам, к файловой системе вызов активности и т.д.
     *
     * @param attributeSet - набор атрибутов, найденный в
     * теге в XML-документе.
     */

    public HistoryItemView(final Context context, final AttributeSet attributeSet) {
        super(context, attributeSet);
        this.initViews();
    }

    /**
     * @param context - объект, который предоставляет
     * доступ к базовым функциям приложения: доступ к
     * ресурсам, к файловой системе вызов активности и т.д.
     */

    public HistoryItemView(final Context context) {
        super(context);
        this.initViews();
    }

    /**
     * @param history экземпляр класса истории;
     * @param isToggled
     */

    @SuppressLint("DefaultLocale")
    public final void bind(final History history, final boolean isToggled) {
        if (history != null) {
            this.mIndexTextView.setText(String.format("%d", history.getId()));
            this.mNameTextView.setText(history.getName());
        }
        this.mTickIconView.setVisibility(isToggled ? VISIBLE : GONE);
    }

    private void initViews() {
        final View view = inflate(getContext(), R.layout.sample_item_view, this);
        this.mIndexTextView = view.findViewById(R.id.sample_item_index_text_view);
        this.mNameTextView = view.findViewById(R.id.sample_item_name_text_view);
        this.mTickIconView = view.findViewById(R.id.sample_item_name_tick_view);
    }
}