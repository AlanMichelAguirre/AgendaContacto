public class Contacto {
	private int id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private boolean favorito;
	public Contacto() {
		
	}
	public Contacto(String nombre,String apellido,String telenofo) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.telefono=telefono;
	}
	public int getId() {
		return this.id;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public String getTelefono() {
		return this.telefono;
	}
	public String getEmail() {
		return this.email;
	}
	public boolean getFavorito() {
		return this.favorito;
	}
	public String toString() {
		return "ID: "+this.getId()+"\nNombre/Apellido: "+this.getNombre()+" "+this.getApellido()+"\nTelefono: "+this.getTelefono()+"\nEmail: "+this.getEmail();
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	public void setTelefono(String tel) {
		this.telefono=tel;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setFavorito(boolean favorito) {
		this.favorito=favorito;
	}
}
