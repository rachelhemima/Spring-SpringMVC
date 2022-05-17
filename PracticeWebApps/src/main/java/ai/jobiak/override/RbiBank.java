package ai.jobiak.override;
//parent class
public class RbiBank 
{
	private int a;
@Override
	public String toString() {
		return "RbiBank [a=" + a + "]";
	}
void rateOfInterest()
{
System.out.println("Rbi bank rate of interest is:18%");
}
}
class Sbi extends RbiBank
{
	//mistake 1,2
	@Override
	public void  rateOfInterest()
	{
		System.out.println("Sbi bank of interest is 12%");
	}
}















