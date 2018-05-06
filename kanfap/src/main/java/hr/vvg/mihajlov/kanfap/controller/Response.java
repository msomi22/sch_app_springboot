/**
 * 
 */
package hr.vvg.mihajlov.kanfap.controller;

public class Response {
	
	private String message;
	private String description; 
	
	/**
	 * 
	 */
	
	public Response() {
		message = "";
		description = "";
	}

	/**
	 * 
	 */
	public Response(String message,String description) { 
		this.message = message;
		this.description = description; 
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [message=" + message + ", description=" + description + "]";
	}

}
