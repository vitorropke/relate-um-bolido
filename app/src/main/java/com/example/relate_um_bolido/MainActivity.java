package com.example.relate_um_bolido;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    BancoDadosHelper bancoDadosHelper;
    ArrayList<Relato> relatos = new ArrayList<>();
    RelatoAdapter relatoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.lista_de_relatos);
        floatingActionButton = findViewById(R.id.botao_acessar_tela_cadastro_relato);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, CadastroActivity.class);
            startActivity(intent);
        });

        bancoDadosHelper = new BancoDadosHelper(this);

        preencherListaRelatos();

        relatoAdapter = new RelatoAdapter(this, this, relatos);
        recyclerView.setAdapter(relatoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            recreate();
        }
    }

    void preencherListaRelatos() {
        Cursor cursor = bancoDadosHelper.listarRelatos();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Sem relatos", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(cursor.getLong(3));

                Relato relato = new Relato();
                relato.setId(cursor.getInt(0));
                relato.setLatitude(cursor.getDouble(1));
                relato.setLongitude(cursor.getDouble(2));
                relato.setDataHora(calendar);
                relato.setAzimuteInicial(cursor.getInt(4));
                relato.setElevacaoInicial(cursor.getInt(5));
                relato.setAzimuteFinal(cursor.getInt(6));
                relato.setElevacaoFinal(cursor.getInt(7));
                relato.setDuracao(cursor.getInt(8));
                relato.setMagnitude(cursor.getInt(9));
                relato.setCor(cursor.getString(10));
                relato.setSom(cursor.getInt(11) > 0);
                relato.setRastro(cursor.getInt(12) > 0);
                relato.setExplosao(cursor.getInt(13) > 0);
                relato.setObservacoes(cursor.getString(14));

                relatos.add(relato);
            }
        }
    }

}
