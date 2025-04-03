package com.example.exemplojsonlocal;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    private String dadosJSON;
    private ListView listView;
    private List<Estudante> lista;
    private ArrayAdapter<Estudante>  adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        dadosJSON = getIntent().getStringExtra("dados");
        listView = findViewById(R.id.listViewDados);
        lista = consumirJSON();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(adapter);
    }//

    private List<Estudante> consumirJSON(){
        List<Estudante> listaEstudantes = null;
        if(dadosJSON!=null){
            Gson gson = new Gson();
            Type type = new TypeToken<List<Estudante>>(){}.getType();
            listaEstudantes = gson.fromJson(dadosJSON,type);
        }
        return listaEstudantes;
    }

    /*private List<Estudante> consumirJSON() {
        List<Estudante> listaEstudantes = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(dadosJSON);
            JSONArray jsonArray = jsonObject.getJSONArray("estudantes");
            for(int i=0;i< jsonArray.length();i++){
                JSONObject object = jsonArray.getJSONObject(i);
                Estudante estudante = new Estudante();
                estudante.setNome(object.getString("nomeEstudante"));
                estudante.setDisciplina(object.getString("disciplinaEstudante"));
                estudante.setNota(object.getDouble("notaEstudante"));
                listaEstudantes.add(estudante);
            }//
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listaEstudantes;
    }*/
}