package it.nextworks.nfvmano.libs.common.enums;

public enum VimResourceStatus {
	
	INSTANTIATING("INSTANTIATING"),
	INSTANTIATED("INSTANTIATED"),
	FAILED("FAILED"),
	TERMINATING("TERMINATING"),
	TERMINATED("TERMINATED");
	
	private String text;
	
	VimResourceStatus(String text) {
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	public static VimResourceStatus fromString(String text) {
		for (VimResourceStatus x : VimResourceStatus.values()) {
			if (x.text.equalsIgnoreCase(text)) {
				return x;
			}
		}
		return null;
	}
	
}
