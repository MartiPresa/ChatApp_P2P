package back;

import java.net.Socket;

public interface Receptor 
{
	void Conectar(int puerto, Socket socket);
}
