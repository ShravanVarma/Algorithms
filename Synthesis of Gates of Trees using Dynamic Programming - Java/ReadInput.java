import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadInput {
	private Float[] pinArrival;
	
	public Float[] readInput(String file){
		
		List<Float> inputValues = new ArrayList<Float>();
		try{
			Scanner scanner = new Scanner(new File("C:\\Test\\Input.txt"));
			scanner.nextInt();
			while(scanner.hasNextFloat())
				inputValues.add(scanner.nextFloat());
			scanner.close();
			this.setPinArrival(inputValues.toArray(new Float[0]));
		}catch(Exception e){
			e.printStackTrace();
		}
		
			return this.getPinArrival();
		
	}

	public Float[] getPinArrival() {
		return pinArrival;
	}

	public void setPinArrival(Float[] pinArrival) {
		this.pinArrival = pinArrival;
	}

}
