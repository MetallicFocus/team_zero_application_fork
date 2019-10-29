package server;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * A Singleton class that keeps track and control of  Client objects
 */
public class ClientManager {
	
	/**
	 * A map representing client ID to connected clients
	 */
	private HashMap<String, Client> connectedClients;
	
	/**
	 * The single Client Manager object
	 */
	private ClientManager clientManager;
	
	
	/**
	 * Private constructor
	 */
	private ClientManager() {
		connectedClients = new HashMap<String, Client>();
		
	}
	
	/**
	 * Public instance getter
	 * @return the single client manager
	 */
	public ClientManager getInstance() {
		return clientManager;
	}
	
	/**
	 * Returns the Client that is associated with the given client ID
	 * @param the client ID
	 * @return the Client object associated with the @param id, or null
	 */
	public Client getClientById(String id) {
		return connectedClients.get(id);
	}
	
	/**
	 * Returns the Client that is associated with the given client username
	 * @param the client username
	 * @return the Client object associated with the @param username , or null
	 */
	public Client getClientByUsername(String username) {
		Iterator<Entry<String, Client>> clientIterator = connectedClients.entrySet().iterator();
		Client currentClient;
		while(clientIterator.hasNext()) {
			currentClient = clientIterator.next().getValue();
			if (currentClient.getUsername().equals(username)) {
				return currentClient;
			}
		}
		return null;
		
	}
	
	/**
	 * Adds a client to the client manager
	 * @param Client object to add
	 */
	public void addClient(Client client) {
		connectedClients.put(client.getId(), client);
	}
	
	/**
	 * Removes a client from the client manager
	 * @param ID of client to remove
	 */
	public void removeClient(String id) {
		connectedClients.remove(id);
	}
	
	
	
	
	
	

}