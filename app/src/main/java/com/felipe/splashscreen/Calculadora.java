package com.felipe.splashscreen;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Calculadora#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calculadora extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Calculadora() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Calculadora.
     */
    // TODO: Rename and change types and number of parameters
    public static Calculadora newInstance(String param1, String param2) {
        Calculadora fragment = new Calculadora();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculadora, container, false);

        TextInputEditText nota1 = view.findViewById(R.id.firstNote);
        TextInputEditText nota2 = view.findViewById(R.id.secondNote);
        TextInputEditText nota3 = view.findViewById(R.id.thirdNote);
        TextInputEditText nota4 = view.findViewById(R.id.fourNote);

        Button btn = view.findViewById(R.id.calcularBtn);


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                FrameLayout rootlayout = (FrameLayout) view.findViewById(R.id.frameLayout);
                String message = "";
                int duration = Snackbar.LENGTH_LONG;

                Float n1 = Float.parseFloat(String.valueOf(nota1.getText()));
                Float n2 = Float.parseFloat(String.valueOf(nota2.getText()));
                Float n3 = Float.parseFloat(String.valueOf(nota3.getText()));
                Float n4 = Float.parseFloat(String.valueOf(nota4.getText()));

                Float media = (n1 + n2 + n3 + n4) / 4;

                String mediaString = Float.toString(media);

                if (media < 4) {
                    message = "Aluno Reprovado. Média: " + mediaString;
                } else if (media >= 4 && media < 6){
                    message = "Aluno de Recuperação. Média: " + mediaString;
                } else {
                    message = "Aluno Aprovado. Média: " + mediaString;
                }

                Snackbar snackbar = Snackbar.make(rootlayout, message, duration);
                snackbar.show();
            }
        });

        return view;
    }
}