package com.commonsware.empublite;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class NoteFragment extends Fragment implements DatabaseHelper.NoteListener {

    private static final String KEY_POSITION = "position";
    private EditText editor = null;
    private boolean isDeleted = false;

    static NoteFragment newInstance(int position) {
        NoteFragment frag = new NoteFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);
        return (frag);
    }

    @Override
    public void setNote(String note) {
        editor.setText(note);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.editor, container, false);
        int position = getArguments().getInt(KEY_POSITION, -1);
        editor = (EditText) result.findViewById(R.id.editor);
        DatabaseHelper.getInstance(getActivity()).getNoteAsync(position, this);
        setHasOptionsMenu(true);
        return (result);
    }

    @Override
    public void onPause() {
        if (!isDeleted) {
            int position = getArguments().getInt(KEY_POSITION, -1);
            DatabaseHelper.getInstance(getActivity()).saveNoteAsync(position, editor.getText().toString());
        }
        super.onPause();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.notes, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.delete) {
            int position = getArguments().getInt(KEY_POSITION, -1);
            isDeleted = true;
            DatabaseHelper.getInstance(getActivity()).deleteNoteAsync(position);
            ((NoteActivity) getActivity()).closeNotes();
            return (true);
        }
        return (super.onOptionsItemSelected(item));
    }
}