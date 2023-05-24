package com.example.ddoverhaul.objetoList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ddoverhaul.JSONHelper;
import com.example.ddoverhaul.Login;
import com.example.ddoverhaul.Objeto;
import com.example.ddoverhaul.R;
import com.example.ddoverhaul.objetoList.ObjetoAdapter;
import com.example.ddoverhaul.personajeList.SpacingItemDecoration;

public class ListaObjetosFragment extends Fragment {

    private RecyclerView recyclerView;
    private ObjetoAdapter adapter;
    private JSONHelper helper;
    private Objeto[] objects;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_lista_objetos, container, false);

        helper = new JSONHelper(requireContext());

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(new SpacingItemDecoration(35));

        objects = helper.getObjects();
        adapter = new ObjetoAdapter(objects);
        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener(new ObjetoAdapter.OnClickListener() {
            @Override
            public void onClick(int position, String id) {
                Intent intent = new Intent(requireContext(), Login.class);
                intent.putExtra("objeto", id);
                startActivity(intent);
            }
        });

        return view;
    }
}