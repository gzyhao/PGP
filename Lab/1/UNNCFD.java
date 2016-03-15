class UNNCFD
{
    public static void main(String[] args)
    {
        Staff a = new Staff("Paul", 30000, "Computer Science");
        Staff b = new Staff("John", 30000, "Computer Science");
        Staff c = new Staff("Paul", 30000, "Finance");
        Staff d = new Staff("Allen", 30000, "Finance");
        
        Finance f = new Finance();
        f.addStaff(a);
        f.addStaff(c);
        f.addStaff(b);
        f.addStaff(d);
        
        f.removeStaff("Paul");
        System.out.println(f.totalSalary());
        System.out.println(f.perDeptSalary("Finance"));
        System.out.println(f.perDeptSalary("Computer Science"));
    }
}

class Staff
{
    private String name;
    private int salary;
    private String dept;
    
    public Staff(String n, int s, String d)
    {
        name = n;
        salary = s;
        dept = d;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getSalary()
    {
        return salary;
    }
    
    public String getDept()
    {
        return dept;
    }
    
     public void changeDept(String d)
    {
        dept = d;
    }
}

class Finance
{
    private Staff[] staff;
    
    public Finance()
    {
        staff = new Staff[10];
    }
    
    public void addStaff(Staff newStaff)
    {
        int vacant = 0;
        while(staff[vacant] != null)
            vacant++;
        staff[vacant] = newStaff;
    }
    
    public void removeStaff(String name)
    {
        for(int i = 0; i < 10; i++)
        {
            if(staff[i] != null && staff[i].getName() == name)
                staff[i] = null;
        }
    }
    
    public int totalSalary()
    {
        int sum = 0;
        for(int i = 0; i < 10; i++)
        {
            if(staff[i] != null)
                sum += staff[i].getSalary();
        }
        return sum;
    }
    
    public int perDeptSalary(String dept)
    {
        int sum = 0;
        for(int i = 0; i < 10; i++)
        {
            if(staff[i] != null && staff[i].getDept() == dept)
                sum += staff[i].getSalary();
        }
        return sum;
    }
}