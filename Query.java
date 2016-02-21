public abstract class Query{
	
	private String normal;
	private String indexes;
	private String materializedView;
	private String hueristics;
	private String storedProcedure;
	
	
	public String getNormal(){
		return normalQuery;
	}

	public String getHueristics(){
		return hueristics;
	}
	
	public String getIndexes(){
		return indexes;
	}
	
	public String getMaterializedView(){
		return materializedView;
	}
	
	public String getStoredProcedure(){
		return storedProcedure;
	}
	
	
}
