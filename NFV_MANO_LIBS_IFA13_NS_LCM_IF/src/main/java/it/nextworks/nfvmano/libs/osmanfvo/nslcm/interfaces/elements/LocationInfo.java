package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Location Info in terms of [Latitude, Longitude, Altitude]
 *
 * @author nextworks
 *
 */
public class LocationInfo implements InterfaceInformationElement {

	private double latitude;
	private double longitude;
	private float altitude;  //It could be int (or omitted)

	public LocationInfo() { }

	/**
	 * Constructor
	 *
	 * @param latitude	Latitude of the element.
	 * @param longitude Longitude of the element.
	 * @param altitude  Altitude of the element.
	 */
	public LocationInfo(double latitude, double longitude, float altitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}

	/**
	 * @return the latitude.
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude.
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @return the altitude.
	 */
	public float getAltitude() {
		return altitude;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		// Nothing to do.
	}

}
