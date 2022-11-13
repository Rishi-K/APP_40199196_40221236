public interface Controller {
	public boolean insert( Object obj );
	public boolean update( Object obj, String column ,String value );
	public boolean delete( Object obj);
	public boolean read( Object obj);

}
