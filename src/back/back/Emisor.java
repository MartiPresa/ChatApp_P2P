package back.back;

import java.io.IOException;
import java.net.UnknownHostException;

public interface Emisor 
{
	void conectar(String IP, int puerto) throws UnknownHostException, IOException;
}
