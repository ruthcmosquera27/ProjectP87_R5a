package modelo.vo;

public class Requerimiento_1Vo {
    
    private Integer ID_Lider;
    private String Nombre;
    private String Primer_Apellido;
    private Integer Salario;
    
    public Requerimiento_1Vo() {
    }

    public Integer getID_Lider() {
        return ID_Lider;
    }
    public void setID_Lider(Integer iD_Lider) {
        ID_Lider = iD_Lider;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getPrimer_Apellido() {
        return Primer_Apellido;
    }
    public void setPrimer_Apellido(String primer_Apellido) {
        Primer_Apellido = primer_Apellido;
    }
    public Integer getSalario() {
        return Salario;
    }
    public void setSalario(Integer salario) {
        Salario = salario;
    }

    
}
