package com.felipe.splashscreen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaIntegrantes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaIntegrantes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaIntegrantes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaIntegrantes.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaIntegrantes newInstance(String param1, String param2) {
        ListaIntegrantes fragment = new ListaIntegrantes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lista_integrantes, container, false);
        ArrayList<Students> list = new ArrayList<>();
        list.add(new Students("Vinicius Santana", R.drawable.vini, "https://github.com/VinciPy", "00209374"));
        list.add(new Students("Lucas Eduardo", R.drawable.lucas, "https://github.com/Tronaluz", "00209374"));
        list.add(new Students("Felipe Takata", R.drawable.felipe, "https://github.com/slender561", "00209374"));
        list.add(new Students("Gustavo Milani ", R.drawable.gustavo, "https://github.com/GMilaniMota", "00209589"));
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        Adapter adapter = new Adapter(list);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        return rootView;
    }

}