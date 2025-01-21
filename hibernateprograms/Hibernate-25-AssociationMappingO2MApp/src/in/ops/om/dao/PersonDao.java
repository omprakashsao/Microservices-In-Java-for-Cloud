package in.ops.om.dao;

public interface PersonDao {
	public void insertRecordsByParent();
	public void loadRecordByParent();
	public void addChildToExistingParent();

}
