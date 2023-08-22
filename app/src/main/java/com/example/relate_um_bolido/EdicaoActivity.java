package com.example.relate_um_bolido;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class EdicaoActivity extends AppCompatActivity {

    EditText entradaLatitude;
    EditText entradaLongitude;
    EditText entradaData;
    EditText entradaHora;
    EditText entradaAzimuteInicial;
    EditText entradaElevacaoInicial;
    EditText entradaAzimuteFinal;
    EditText entradaElevacaoFinal;
    EditText entradaDuracao;
    EditText entradaMagnitude;
    EditText entradaCor;
    CheckBox entradaSom;
    CheckBox entradaRastro;
    CheckBox entradaExplosao;
    EditText entradaObservacoes;
    Button botaoEditarRelato;
    Button botaoApagarRelato;

    Relato relato = new Relato();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao);

        entradaLatitude = findViewById(R.id.entrada_latitude_tela_edicao);
        entradaLongitude = findViewById(R.id.entrada_longitude_tela_edicao);
        entradaData = findViewById(R.id.entrada_data_tela_edicao);
        entradaHora = findViewById(R.id.entrada_hora_tela_edicao);
        entradaAzimuteInicial = findViewById(R.id.entrada_azimute_inicial_tela_edicao);
        entradaElevacaoInicial = findViewById(R.id.entrada_elevacao_inicial_tela_edicao);
        entradaAzimuteFinal = findViewById(R.id.entrada_azimute_final_tela_edicao);
        entradaElevacaoFinal = findViewById(R.id.entrada_elevacao_final_tela_edicao);
        entradaDuracao = findViewById(R.id.entrada_duracao_tela_edicao);
        entradaMagnitude = findViewById(R.id.entrada_magnitude_tela_edicao);
        entradaCor = findViewById(R.id.entrada_cor_tela_edicao);
        entradaSom = findViewById(R.id.entrada_som_tela_edicao);
        entradaRastro = findViewById(R.id.entrada_rastro_tela_edicao);
        entradaExplosao = findViewById(R.id.entrada_explosao_tela_edicao);
        entradaObservacoes = findViewById(R.id.entrada_observacoes_tela_edicao);

        botaoEditarRelato = findViewById(R.id.botao_editar_relato);
        botaoApagarRelato = findViewById(R.id.botao_apagar_relato);

        obterDefinirDados();
        botaoEditarRelato.setOnClickListener(view -> {
            BancoDadosHelper bancoDadosHelper = new BancoDadosHelper(EdicaoActivity.this);
            bancoDadosHelper.editarRelato(relato, String.valueOf(relato.getId()));
        });

        botaoApagarRelato.setOnClickListener(view -> {
            mensagemConfirmacao();
        });
    }

    public void obterDefinirDados() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("latitude") &&
                getIntent().hasExtra("longitude") &&
                getIntent().hasExtra("data_hora") &&
                getIntent().hasExtra("azimute_inicial") &&
                getIntent().hasExtra("elevacao_inicial") &&
                getIntent().hasExtra("azimute_final") &&
                getIntent().hasExtra("elevacao_final") &&
                getIntent().hasExtra("duracao") && getIntent().hasExtra("magnitude") &&
                getIntent().hasExtra("cor") && getIntent().hasExtra("som") &&
                getIntent().hasExtra("rastro") && getIntent().hasExtra("explosao") &&
                getIntent().hasExtra("observacoes")) {
            // obtendo dados
            relato.setId(getIntent().getIntExtra("id", 0));
            relato.setLatitude(getIntent().getDoubleExtra("latitude", 0));
            relato.setLongitude(getIntent().getDoubleExtra("longitude", 0));
            // get calendar
            relato.setAzimuteInicial(getIntent().getIntExtra("azimute_inicial", 0));
            relato.setElevacaoInicial(getIntent().getIntExtra("elevacao_inicial", 0));
            relato.setAzimuteFinal(getIntent().getIntExtra("azimute_final", 0));
            relato.setElevacaoFinal(getIntent().getIntExtra("elevacao_final", 0));
            relato.setDuracao(getIntent().getIntExtra("duracao", 0));
            relato.setMagnitude(getIntent().getIntExtra("magnitude", 0));
            relato.setCor(getIntent().getStringExtra("cor"));
            relato.setSom(getIntent().getBooleanExtra("som", false));
            relato.setRastro(getIntent().getBooleanExtra("rastro", false));
            relato.setExplosao(getIntent().getBooleanExtra("explosao", false));
            relato.setObservacoes(getIntent().getStringExtra("observacoes"));

            // preenchendo dados existentes
            /*
            Calendar calendar = relato.getDataHora();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String data = simpleDateFormat.format(calendar.getTime());
            simpleDateFormat.applyPattern("HH:mm");
            String hora = simpleDateFormat.format(calendar.getTime());
            */

            Toast.makeText(this, String.valueOf(relato.getId()), Toast.LENGTH_SHORT).show();
            entradaLatitude.setText(String.valueOf(relato.getLatitude()));
            entradaLongitude.setText(String.valueOf(relato.getLongitude()));
            //entradaData.setText(data);
            //entradaHora.setText(hora);
            entradaData.setText("2023/10/10");
            entradaHora.setText("17:58");
            entradaAzimuteInicial.setText(String.valueOf(relato.getAzimuteInicial()));
            entradaElevacaoInicial.setText(String.valueOf(relato.getElevacaoInicial()));
            entradaAzimuteFinal.setText(String.valueOf(relato.getAzimuteFinal()));
            entradaElevacaoFinal.setText(String.valueOf(relato.getElevacaoFinal()));
            entradaDuracao.setText(String.valueOf(relato.getDuracao()));
            entradaMagnitude.setText(String.valueOf(relato.getMagnitude()));
            entradaCor.setText(relato.getCor());
            entradaSom.setChecked(relato.hasSom());
            entradaRastro.setChecked(relato.hasRastro());
            entradaExplosao.setChecked(relato.hasExplosao());
            entradaObservacoes.setText(relato.getObservacoes());
        } else {
            Toast.makeText(this, "Sem dados.", Toast.LENGTH_SHORT).show();
        }
    }

    public void mensagemConfirmacao() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Apagar relato " + relato.getId() + "?");
        builder.setMessage("Deseja mesmo apagar este relato?");
        builder.setPositiveButton("Sim", (dialogInterface, i) -> {
            BancoDadosHelper bancoDadosHelper = new BancoDadosHelper(EdicaoActivity.this);
            bancoDadosHelper.apagarRelato(String.valueOf(relato.getId()));
            finish();
        });
        builder.setNegativeButton("Nao", (dialogInterface, i) -> {
        });
        builder.create().show();
    }

}
