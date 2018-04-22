package app.fragments.multipleChoiceRecycler;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.github.stephenvinouze.advancedrecyclerview.core.enums.ChoiceMode;
import app.adapters.HistoryAdapter;
import app.fragments.AbstractRecyclerFragment;
import app.models.History;
import app.models.HistoryManager;

@SuppressLint("ValidFragment")
public final class MultipleChoiceRecyclerFragment extends AbstractRecyclerFragment {

    @SuppressLint("ValidFragment")
    public MultipleChoiceRecyclerFragment(final HistoryManager historyManager) {
        super(historyManager);
    }

    @Override
    public final void onViewCreated(final @NonNull View view
            , final @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.adapter = this.createAdapter();
        this.recyclerView.setAdapter(adapter);
    }

    @Override
    protected final HistoryAdapter createAdapter() {
        final HistoryAdapter adapter = new HistoryAdapter(getContext());
        adapter.setItems(historyManager.mockItems());
        adapter.setChoiceMode(ChoiceMode.MULTIPLE);
        adapter.setOnClick((view1, position) -> {
            final History history = adapter.getItems().get(position);
            Toast.makeText(getActivity(), this.createText(history), Toast.LENGTH_SHORT).show();
            return null;
        });
        return adapter;
    }

    private String createText(final History history){
        return "Выбрана история : " + history.getId() + " (" + adapter.getSelectedItemViewCount()
                + " выбрано)";
    }
}