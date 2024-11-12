package Entities;

import Exceptions.YearConvertionException;
import com.google.gson.annotations.SerializedName;

public class Title {
    private String nome;
    private int anoDeLancamento;
    private int totalDasAvaliacoes;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;

    public Title(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Title(TitleOmdb titleOmdb) {
        this.nome = titleOmdb.title();

        if(titleOmdb.year().length() > 4){
            throw new YearConvertionException("Not possible to do year convertion because he's have more of 4 characters");
        }

        this.anoDeLancamento = Integer.parseInt(titleOmdb.year());
        this.duracaoEmMinutos = Integer.parseInt(titleOmdb.runtime().substring(0,2));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getTotalDasAvaliacoes() {
        return totalDasAvaliacoes;
    }

    public void setTotalDasAvaliacoes(int totalDasAvaliacoes) {
        this.totalDasAvaliacoes = totalDasAvaliacoes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public double getSomaDasAvaliacoes() {
        return somaDasAvaliacoes;
    }

    public void setSomaDasAvaliacoes(double somaDasAvaliacoes) {
        this.somaDasAvaliacoes = somaDasAvaliacoes;
    }

    @Override
    public String toString() {
        return "name= " + nome + '\'' +
                ", year of release=" + anoDeLancamento + '\'' +
                ", minutes duration=" + duracaoEmMinutos;
    }
}
