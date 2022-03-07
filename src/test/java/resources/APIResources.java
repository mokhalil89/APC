package resources;

public enum APIResources {
	Country("dayone/country/"),
	Webhook("webhook");

	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}
