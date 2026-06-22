public class testContacto {
	public static void main(String[] args) {
		Contacto[] contacto=new Contacto[1];
		Scanner leer=new Scanner(System.in);
		int id,opcion,i;
		String nombre,apellido,telefono,email;
		boolean favorito;
		do {
			System.out.println("1 - Agregar contacto\r\n"
					+ "2 - Listar contactos\r\n"
					+ "3 - Buscar contacto por nombre\r\n"
					+ "4 - Buscar contacto por teléfono\r\n"
					+ "5 - Modificar contacto\r\n"
					+ "6 - Eliminar contacto\r\n"
					+ "7 - Mostrar favoritos\r\n"
					+ "8 - Cantidad de contactos guardados\r\n"
					+ "9 - Ordenar contactos por apellido\r\n"
					+ "0 - Salir");
			opcion=leer.nextInt();
			switch(opcion) {
				case 1: 
					System.out.println("Ingrese nombre: ");
					nombre=leer.nextLine();
					leer.nextLine();
					System.out.println("Ingrese Apellido: ");
					apellido=leer.nextLine();
					System.out.println("Ingrese Telefono: ");
					telefono=leer.nextLine();
					System.out.println("Ingrese Email: ");
					email=leer.nextLine();
					System.out.println("Es favorito?\n1-SI\n2-NO ");
					opcion=leer.nextInt();
					if(opcion==1) {
						favorito=true;
					}else {
						favorito=false;
					}
					id=contacto.length-1;
					Contacto contactoNuevo=new Contacto(nombre,apellido,telefono);
					contactoNuevo.setEmail(email);
					contactoNuevo.setFavorito(favorito);
					contacto=agregarContacto(contacto,contactoNuevo);break;
				case 2:
					mostrarContactos(contacto);break;
				case 3:
					System.out.println("Ingrese el Nombre: ");
					nombre=leer.nextLine();
					i=buscarContacto(contacto,nombre);
					System.out.println(contacto[i].toString());break;
				case 4:
					System.out.println("Ingrese el Numero de Telefono: ");
					telefono=leer.nextLine();
					i=buscarContacto(contacto,telefono);
					System.out.println(contacto[i].toString());break;
				case 5:
				case 6:
					System.out.println("Ingrese el Nombre del Contacto a eliminar: ");
					nombre=leer.nextLine();
					contacto=eliminarContacto(contacto,nombre);break;
				case 7:
					mostrarFavoritos(contacto);
				case 8:
					System.out.println("Contactos Guardados: "+contactosGuardados(contacto));break;
				case 9:
					contacto=ordenarPorApellido(contacto);
					mostrarContactos(contacto);break;
				case 0:
					System.out.println("Finalizo el programa.");break;
					default:
						System.out.println("Opcion incorrecta, vuelva a intentarlo.");
			}
		}while(opcion!=0);
		
	}
	public static int caracterAscii(Contacto contacto,int posicion) {
		char primeraLetra;
		int primeraLetraAscii;
		primeraLetra=(contacto.getApellido()).charAt(posicion);
		primeraLetraAscii=(int)primeraLetra;
		return primeraLetraAscii;
	}
	public static Contacto[] ordenarPorApellido(Contacto[] contacto) {
		int apellidoAscii,apellidoSiguienteAscii;
		boolean ordenado;
		Contacto contactoAux;
		do {
			ordenado=true;
			for(int i=0;i<contacto.length-1;i++){
				apellidoAscii=caracterAscii(contacto[i],0);
				apellidoSiguienteAscii=caracterAscii(contacto[i+1],0);
				if(apellidoAscii>apellidoSiguienteAscii) {
					contactoAux=contacto[i];
					contacto[i]=contacto[i+1];
					contacto[i+1]=contactoAux;
					ordenado=false;
				}
			}
		}while(!ordenado);
		return contacto;
	}
	public static int contactosGuardados(Contacto[] contacto) {
		int cantidad=0;
		for(int i=0;i<contacto.length;i++) {
			if(contacto[i]!=null) {
				cantidad++;
			}
		}
		return cantidad;
	}
	public static void mostrarFavoritos(Contacto[] contacto) {
		for(int i=0;i<contacto.length;i++) {
			if(contacto[i].getFavorito()) {
				System.out.println(contacto[i].toString()+"\n|------------------|");
			}
		}
	}
	public static Contacto[] eliminarContacto(Contacto[] contacto,String dato) {
		Contacto[] contactoEliminado=new Contacto[contacto.length];
		int posicion;
		posicion=buscarContacto(contacto,dato);
		if(posicion!=-1) {
			for(int i=0;i<contacto.length;i++) {
				if(posicion==i) {
					contactoEliminado[i]=contacto[i+1];
					i++;
				}else {
					contactoEliminado[i]=contacto[i];
				}
			}
		}
		return contactoEliminado;
	}
	public static int buscarContacto(Contacto[] contacto,String dato) {
		int i=0,posicionContacto=-1;
		boolean encontrado=false;
		do {
			if((contacto[i].getNombre()).equalsIgnoreCase(dato)) {
				posicionContacto=i;
			}else if((contacto[i].getEmail()).equalsIgnoreCase(dato)) {
				posicionContacto=i;
			}else {
				i++;
			}
		}while(i<contacto.length-1 && !encontrado);
		return posicionContacto;
	}
	public static void mostrarContactos(Contacto[] contacto) {
		int i=0;
		do {
			System.out.println(contacto[i].toString()+"\n|------------------|");
			i++;
		}while(i<contacto.length-1);
	}
	public static Contacto[] agregarContacto(Contacto[] contacto,Contacto contactoNuevo) {
		int i=0;
		boolean agregado=false;
		if(contacto.length==1) {
			if(contacto[0]==null) {
				contactoNuevo.setId(i);
				contacto[0]=contactoNuevo;
				agregado=true;
			}else {
				contacto=agregarNuevoLugar(contacto);
				contactoNuevo.setId(i+1);
				contacto[i+1]=contactoNuevo;
				agregado=true;
			}
		}else {
			do {
				if(contacto[i]!=null) {
					contactoNuevo.setId(i);
					contacto[i]=contactoNuevo;
					agregado=true;
				}else {
					if(contacto.length==i && contacto[i]!=null) {
						contactoNuevo.setId(i+1);
						contacto=agregarNuevoLugar(contacto);
						contacto[i+1]=contactoNuevo;
						agregado=true;
					}else {
						i++;
					}
				}
			}while(i<contacto.length-1 && !agregado);
		}
		return contacto;
	}
	public static Contacto[] agregarNuevoLugar(Contacto[] contacto) {
		Contacto[] contactoNuevo=new Contacto[contacto.length+1];
		for(int i=0;i<contacto.length;i++) {
			contactoNuevo[i]=contacto[i];
		}
		return contactoNuevo;
	}
}
