package serviceFadi;

import javax.ejb.Remote;

@Remote
public interface InterfaceServiceRemote {
	public String sayHello(String name);

}
