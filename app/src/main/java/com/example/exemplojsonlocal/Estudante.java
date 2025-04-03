package com.example.exemplojsonlocal;

public class Estudante {

    private String nome, disciplina;
    private double nota;

    public Estudante() {
    }

    public Estudante(String nome, String disciplina, double nota) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", nota=" + nota +
                '}';
    }
}