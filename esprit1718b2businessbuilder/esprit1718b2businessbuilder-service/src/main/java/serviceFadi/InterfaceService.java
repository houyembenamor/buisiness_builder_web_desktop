package serviceFadi;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class InterfaceService
 */
@Stateless
public class InterfaceService implements InterfaceServiceRemote, InterfaceServiceLocal {

    /**
     * Default constructor. 
     */
    public InterfaceService() {
        // TODO Auto-generated constructor stub
    	
    }

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return ("hello "+name);
	}

}
