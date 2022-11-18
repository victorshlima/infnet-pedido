package br.edu.infnet.pedido.model.entidade;

import java.util.Objects;

public class Funcionario {

    private Long codigo;
    private String nome;
    private String cargo;

    public Funcionario() {
    }

    public Funcionario( String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public Funcionario(Long codigo, String nome, String cargo) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(codigo, that.codigo) && Objects.equals(nome, that.nome) && Objects.equals(cargo, that.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, cargo);
    }
}
