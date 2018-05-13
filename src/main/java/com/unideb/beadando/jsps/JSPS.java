package com.unideb.beadando.jsps;

/**
 * this enumeration contain any jsp files.
 * @author gagyi.norbert
 *
 */
public enum JSPS {
	/**
	 * ADMIN refer to admin jsp.
	 */
	ADMIN("admin"),
	/**
	 * INDEX refer to index jsp.
	 */
	INDEX("index"),
	/**
	 * LOGIN refer to log-in jsp.
	 */
	LOGIN("log-in");

	/**
	 * this is a jsp attribute.
	 */
	private String jsp;
	 
	/**
	 * construct is set jsp.
	 * @param jsp set this param for jsp
	 */
	JSPS(String jsp){
		 this.jsp = jsp;
	 }
	 
	/**
	 * return current jsp.
	 * @return actual jsp.
	 */
	 public String getJsp() {
		 return this.jsp;
	 }
}
