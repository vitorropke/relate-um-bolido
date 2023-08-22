package com.example.relate_um_bolido;

import java.util.Calendar;

public class Relato {

    private int id;
    private double latitude;
    private double longitude;
    private Calendar dataHora;
    private int azimuteInicial;
    private int elevacaoInicial;
    private int azimuteFinal;
    private int elevacaoFinal;
    private int duracao;
    private int magnitude;
    private String cor;
    private boolean som;
    private boolean rastro;
    private boolean explosao;
    private String observacoes;

    public Relato() {
    }

    public Relato(int id, double latitude, double longitude, Calendar dataHora, int azimuteInicial,
                  int elevacaoInicial, int azimuteFinal, int elevacaoFinal, int duracao,
                  int magnitude, String cor, boolean som, boolean rastro, boolean explosao,
                  String observacoes) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dataHora = dataHora;
        this.azimuteInicial = azimuteInicial;
        this.elevacaoInicial = elevacaoInicial;
        this.azimuteFinal = azimuteFinal;
        this.elevacaoFinal = elevacaoFinal;
        this.duracao = duracao;
        this.magnitude = magnitude;
        this.cor = cor;
        this.som = som;
        this.rastro = rastro;
        this.explosao = explosao;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public int getAzimuteInicial() {
        return azimuteInicial;
    }

    public void setAzimuteInicial(int azimuteInicial) {
        this.azimuteInicial = azimuteInicial;
    }

    public int getElevacaoInicial() {
        return elevacaoInicial;
    }

    public void setElevacaoInicial(int elevacaoInicial) {
        this.elevacaoInicial = elevacaoInicial;
    }

    public int getAzimuteFinal() {
        return azimuteFinal;
    }

    public void setAzimuteFinal(int azimuteFinal) {
        this.azimuteFinal = azimuteFinal;
    }

    public int getElevacaoFinal() {
        return elevacaoFinal;
    }

    public void setElevacaoFinal(int elevacaoFinal) {
        this.elevacaoFinal = elevacaoFinal;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean hasSom() {
        return som;
    }

    public void setSom(boolean som) {
        this.som = som;
    }

    public boolean hasRastro() {
        return rastro;
    }

    public void setRastro(boolean rastro) {
        this.rastro = rastro;
    }

    public boolean hasExplosao() {
        return explosao;
    }

    public void setExplosao(boolean explosao) {
        this.explosao = explosao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}
