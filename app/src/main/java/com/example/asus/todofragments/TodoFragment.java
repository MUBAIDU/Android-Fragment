package com.example.asus.todofragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class TodoFragment extends Fragment {


    private Todo mTodo;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mTodo = new Todo();
    }

    @Nullable
    @Override
    //// onCreateView - the system calls this when the fragment is ready draw the UI
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        /// Inflater uses R.layout to inflate each widget in the XML resources file
        View view = inflater.inflate(R.layout.fragment_todo, container, false);

        EditText editTextTitle = (EditText) view.findViewById(R.id.todo_title);
        editTextTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This line is intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTodo.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This line is intentionally left blank
            }
        });

        Button buttonDate = (Button) view.findViewById(R.id.todo_date);
        buttonDate.setText(mTodo.getDate().toString());
        buttonDate.setEnabled(true);

        CheckBox checkBoxIsComplete = (CheckBox) view.findViewById(R.id.todo_complete);
        checkBoxIsComplete.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTodo.setIsComplete(isChecked);
            }
        });

        return view;

    }
}