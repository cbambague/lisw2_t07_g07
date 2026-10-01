package co.unicauca.iso2.bancopreguntas.domain;
public class Option {
    private String clave;
    private String texto;
    public Option(String clave, String texto) { this.clave = clave; this.texto = texto; }
    public String getClave() { return clave; }
    public String getTexto() { return texto; }
}
