package back.back;

import java.io.IOException;
import java.net.Socket;

public interface Receptor 
{
	void Conectar(int puerto) throws IOException;
	Socket getsocket();
}
