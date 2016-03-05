/**
 * 
 */
package com.mycompany.jaxrs.service;

/**
 * @author colin
 *
 */
public class Track {

	String title;
	String singer;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the singer
	 */
	public String getSinger() {
		return singer;
	}
	/**
	 * @param singer the singer to set
	 */
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	@Override
	public String toString(){
		return "Track [title=" + title + ", singer=" + singer + "]";
	}
	
	
}
