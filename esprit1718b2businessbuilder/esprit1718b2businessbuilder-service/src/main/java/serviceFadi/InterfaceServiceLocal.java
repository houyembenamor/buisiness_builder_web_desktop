package serviceFadi;

import javax.ejb.Local;

@Local
public interface InterfaceServiceLocal {
	public String sayHello(String name);

}
