package back;
/*
 * pude ser la clase conexion!!
 */

public class Cliente 
{
	private String nickname;
	private int puerto;
	private String IP;
	private String contrasena; //peude ser array!
	
	public Cliente(String nickname, int puerto, String iP) {
		super();
		this.nickname = nickname;
		this.puerto = puerto;
		IP = iP;
	}
	
	/*
	 * ahora el cliente le envía mje al servidor y el servidor es quien le manda dicho mje
	 * al otro cliente. Ver como hacer ese traspaso de mjs desde vistChat
	 */
	
	/*
	 * hay que encriptar los mjs cuando se mandan y desencriptarlos cuando se reciben
	 * el servidor no recibe el mje como tal!
	 */
	
	/*
	 * como almacenamos las contraseñas?? 
	 */
}
