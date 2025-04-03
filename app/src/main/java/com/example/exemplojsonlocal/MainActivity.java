package com.example.exemplojsonlocal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome,editTextDisciplina,editTextNota;
    private Button buttonAdicionar,buttonGerar,buttonConsumir;
    private List<Estudante> lista;
    private TextView textViewResultado;
    private String retorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome = findViewById(R.id.editTextNome);
        editTextDisciplina = findViewById(R.id.editTextDisciplina);
        editTextNota = findViewById(R.id.editTextNota);
        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        buttonGerar = findViewById(R.id.buttonGerar);
        buttonConsumir = findViewById(R.id.buttonConsumir);
        textViewResultado = findViewById(R.id.textViewResultado);
        lista = new ArrayList<>();
    }

    public void criarLista(View v){
        lista.add(new Estudante(editTextNome.getText().toString(),
                editTextDisciplina.getText().toString(),
                Integer.parseInt(editTextNota.getText().toString())));
        Toast.makeText(getApplicationContext(), "Item inserido",
                Toast.LENGTH_SHORT).show();
    }

    public String criarJson(List<Estudante> dados){
        Gson gson = new Gson();
        String stringJSON = gson.toJson(dados);
        return stringJSON;
    }

    public void gerarJson(View v){
        retorno = criarJson(lista);
        textViewResultado.setText(retorno);
    }

    public void abrirTela(View v){
        Intent intent = new Intent(getApplicationContext(),Activity2.class);
        intent.putExtra("dados",retorno);
        startActivity(intent);
    }

    /*public  String criarJson(){
        JSONArray jsonArray = new JSONArray();
        for (int i=0;i<lista.size();i++){
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("nomeEstudante",lista.get(i).getNome());
                jsonObject.put("disciplinaEstudante",lista.get(i).getDisciplina());
                jsonObject.put("notaEstudante",lista.get(i).getNota());
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "{estudantes:"+jsonArray.toString()+"}";
    }*/
}
