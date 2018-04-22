package app.fragments.gestureRecycler;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.github.stephenvinouze.advancedrecyclerview.gesture.extensions.GestureKt;
import app.adapters.HistoryAdapter;
import app.fragments.AbstractRecyclerFragment;
import app.models.HistoryManager;

@SuppressLint("ValidFragment")
public final class GestureRecyclerFragment extends AbstractRecyclerFragment {

    @SuppressLint("ValidFragment")
    public GestureRecyclerFragment(HistoryManager historyManager) {
        super(historyManager);
    }

    @Override
    public final void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.adapter = this.createAdapter();
        this.recyclerView.setAdapter(adapter);
        GestureKt.enableGestures(
                recyclerView,
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT,
                null
        );
    }

    @Override
    protected final HistoryAdapter createAdapter() {
        final HistoryAdapter adapter = new HistoryAdapter(getContext());
        adapter.setItems(historyManager.mockItems());
        return adapter;
    }
}