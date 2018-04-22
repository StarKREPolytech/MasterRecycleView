package app.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.R;
import app.adapters.HistoryAdapter;
import app.models.HistoryManager;

public abstract class AbstractRecyclerFragment extends Fragment {

    protected RecyclerView recyclerView;

    protected final HistoryManager historyManager;

    protected HistoryAdapter adapter;

    @SuppressLint("ValidFragment")
    public AbstractRecyclerFragment(final HistoryManager historyManager){
        this.historyManager = historyManager;
    }

    @Nullable
    @Override
    public final View onCreateView(final @NonNull LayoutInflater inflater
            , final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_layout, container, false);
    }

    @Override
    public void onViewCreated(final @NonNull View view
            , final @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.configureRecyclerView(view.findViewById(R.id.recycler_view));
    }

    protected final void configureRecyclerView(final RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    protected abstract HistoryAdapter createAdapter();
}