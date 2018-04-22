package app.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.github.stephenvinouze.advancedrecyclerview.core.adapters.RecyclerAdapter;
import app.models.History;
import app.views.HistoryItemView;

public final class HistoryAdapter extends RecyclerAdapter<History> {

    public HistoryAdapter(final Context context) {
        super(context);
    }

    @NonNull
    @Override
    protected final View onCreateItemView(final @NonNull ViewGroup parent, final int viewType) {
        return new HistoryItemView(getContext());
    }

    @Override
    protected final void onBindItemView(final @NonNull View view, final int position) {
        final HistoryItemView historyItemView = (HistoryItemView) view;
        historyItemView.bind(getItems().get(position), isItemViewToggled(position));
    }
}