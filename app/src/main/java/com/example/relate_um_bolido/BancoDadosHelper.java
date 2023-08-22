package com.example.relate_um_bolido;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class BancoDadosHelper extends SQLiteOpenHelper {

    private final Context context;
    private static final String DATABASE_NAME = "relate_um_bolido.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "relatos";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";
    private static final String COLUMN_DATA_HORA = "data_hora";
    private static final String COLUMN_AZIMUTE_INICIAL = "azimute_inicial";
    private static final String COLUMN_ELEVACAO_INICIAL = "elevacao_inicial";
    private static final String COLUMN_AZIMUTE_FINAL = "azimute_final";
    private static final String COLUMN_ELEVACAO_FINAL = "elevacao_final";
    private static final String COLUMN_DURACAO = "duracao";
    private static final String COLUMN_MAGNITUDE = "magnitude";
    private static final String COLUMN_COR = "cor";
    private static final String COLUMN_SOM = "som";
    private static final String COLUMN_RASTRO = "rastro";
    private static final String COLUMN_EXPLOSAO = "explosao";
    private static final String COLUMN_OBSERVACOES = "observacoes";

    public BancoDadosHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_LATITUDE + " REAL NOT NULL, " +
                COLUMN_LONGITUDE + " REAL NOT NULL, " +
                COLUMN_DATA_HORA + " INTEGER NOT NULL, " +
                COLUMN_AZIMUTE_INICIAL + " INTEGER NOT NULL, " +
                COLUMN_ELEVACAO_INICIAL + " INTEGER NOT NULL, " +
                COLUMN_AZIMUTE_FINAL + " INTEGER NOT NULL, " +
                COLUMN_ELEVACAO_FINAL + " INTEGER NOT NULL, " +
                COLUMN_DURACAO + " INTEGER NOT NULL, " +
                COLUMN_MAGNITUDE + " INTEGER NOT NULL, " +
                COLUMN_COR + " TEXT NOT NULL, " +
                COLUMN_SOM + " INTEGER NOT NULL, " +
                COLUMN_RASTRO + " INTEGER NOT NULL, " +
                COLUMN_EXPLOSAO + " INTEGER NOT NULL, " +
                COLUMN_OBSERVACOES + " TEXT" +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void cadastrarRelato(Relato relato) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_LATITUDE, relato.getLatitude());
        contentValues.put(COLUMN_LONGITUDE, relato.getLongitude());
        contentValues.put(COLUMN_DATA_HORA, relato.getDataHora().getTimeInMillis());
        contentValues.put(COLUMN_AZIMUTE_INICIAL, relato.getAzimuteInicial());
        contentValues.put(COLUMN_ELEVACAO_INICIAL, relato.getElevacaoInicial());
        contentValues.put(COLUMN_AZIMUTE_FINAL, relato.getAzimuteFinal());
        contentValues.put(COLUMN_ELEVACAO_FINAL, relato.getElevacaoFinal());
        contentValues.put(COLUMN_DURACAO, relato.getDuracao());
        contentValues.put(COLUMN_MAGNITUDE, relato.getMagnitude());
        contentValues.put(COLUMN_COR, relato.getCor());
        contentValues.put(COLUMN_SOM, relato.hasSom());
        contentValues.put(COLUMN_RASTRO, relato.hasRastro());
        contentValues.put(COLUMN_EXPLOSAO, relato.hasExplosao());
        contentValues.put(COLUMN_OBSERVACOES, relato.getObservacoes());

        long resultado = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        if (resultado == -1) {
            Toast.makeText(context, "Falha no cadastro", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor listarRelatos() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = null;

        if (sqLiteDatabase != null) {
            cursor = sqLiteDatabase.rawQuery(query, null);
        }

        return cursor;
    }

    public void editarRelato(Relato relato, String id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_LATITUDE, relato.getLatitude());
        contentValues.put(COLUMN_LONGITUDE, relato.getLongitude());
        contentValues.put(COLUMN_DATA_HORA, relato.getDataHora().getTimeInMillis());
        contentValues.put(COLUMN_AZIMUTE_INICIAL, relato.getAzimuteInicial());
        contentValues.put(COLUMN_ELEVACAO_INICIAL, relato.getElevacaoInicial());
        contentValues.put(COLUMN_AZIMUTE_FINAL, relato.getAzimuteFinal());
        contentValues.put(COLUMN_ELEVACAO_FINAL, relato.getElevacaoFinal());
        contentValues.put(COLUMN_DURACAO, relato.getDuracao());
        contentValues.put(COLUMN_MAGNITUDE, relato.getMagnitude());
        contentValues.put(COLUMN_COR, relato.getCor());
        contentValues.put(COLUMN_SOM, relato.hasSom());
        contentValues.put(COLUMN_RASTRO, relato.hasRastro());
        contentValues.put(COLUMN_EXPLOSAO, relato.hasExplosao());
        contentValues.put(COLUMN_OBSERVACOES, relato.getObservacoes());

        long resultado = sqLiteDatabase.update(TABLE_NAME, contentValues, "id=?", new String[]{id});

        if (resultado == -1) {
            Toast.makeText(context, "Falha na edicao", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Editado com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

    public void apagarRelato(String id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long resultado = sqLiteDatabase.delete(TABLE_NAME, "id=?", new String[]{id});

        if (resultado == -1) {
            Toast.makeText(context, "Falha na remocao", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Apagado com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

}
