class HRMSConfigManager
{
    private static HRMSConfigManager instance;
    private HRMSConfigManager()
    {
        System.out.println("HRMS Configuration Manager Created");
    }
    public static HRMSConfigManager getInstance()
    {
        // System.out.println(instance);
        if (instance == null)
        {
            instance = new HRMSConfigManager();
        }
        return instance;
    }
    public void showCompanyName()
    {
        System.out.println("Agnie Consulting India Private Limited.");
    }
    public void showDatabaseName()
    {
        System.out.println("Employee Database.");
    }
    public void showVersion()
    {
        System.out.println("2.0.");
    }
}
public class HRMSConfigManagerDemo {
    public static void main(String[] args) {
        HRMSConfigManager obj1 = HRMSConfigManager.getInstance();
        HRMSConfigManager obj2 = HRMSConfigManager.getInstance();
        HRMSConfigManager obj3 = HRMSConfigManager.getInstance();
        boolean flag=obj1==obj2 && obj2==obj3;
        if (flag) System.out.println("All three Objects are same.");
        obj1.showCompanyName();
        obj2.showDatabaseName();
        obj3.showVersion();
    }
}