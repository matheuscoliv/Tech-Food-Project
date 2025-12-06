package br.com.techfood.lembretes;

public class Lembretes {
    private String titulo;
    private String descricaoLembrete;
    private int idUsuario;

    public Lembretes(String titulo, String descricaoLembrete, int idUsuario) {
        this.titulo = titulo;
        this.descricaoLembrete = descricaoLembrete;
        this.idUsuario = idUsuario;
    }

    private Lembretes(Builder builder) {
        this.titulo = builder.titulo;
        this.descricaoLembrete = builder.descricaoLembrete;
        this.idUsuario = builder.idUsuario;
    }
    public Lembretes(String descricaoLembrete, int idUsuario) {
        this.descricaoLembrete = descricaoLembrete;
        this.idUsuario = idUsuario;
    }


    public static class Builder {
        private String titulo;
        private String descricaoLembrete;
        private int idUsuario;

        public Builder(int idUsuario) {
            this.idUsuario = idUsuario;
        }

        public Builder adicionarTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder adicionarDesc(String descricaoLembrete) {
            this.descricaoLembrete = descricaoLembrete;
            return this;
        }

        public Lembretes build() {
            return new Lembretes(this);
        }
    }


    @Override
    public String toString() {
        return "==========================================\n" +
                "Lembrete Gerado!\n" +
                "==========================================\n" +
                "Título do Lembrete: " + titulo + "\n" +
                "Descrição: " + descricaoLembrete + "\n" +
                "------------------------------------------\n" +
                "ID DO USUÁRIO: " + idUsuario + "\n" +
                "==========================================";
    }
}
