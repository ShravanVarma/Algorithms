import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadLibrary {

	private GateFile[] gates;
	public GateFile[] readLibrary(String file){
		
		try (BufferedReader buffer = new BufferedReader(new FileReader("C:\\Test\\Library.txt")))
		{
		  int noGates=0;
		  noGates = Integer.parseInt(buffer.readLine());
		  gates = new GateFile[noGates];
		  for (int i=0; i<noGates; i++) {
			  String[] temp = buffer.readLine().split(" ");
			 
			  for (int j=0; j<temp.length; j++){
				  GateFile tempGate = new GateFile();
				  tempGate.setDelay(Float.parseFloat(temp[j++]));
				  tempGate.setCost(Integer.parseInt(temp[j]));
				  gates[i] = tempGate;
			  
			  }
		  }
		}catch (FileNotFoundException e){
			  GateFile tempGate = new GateFile();
			  gates = new GateFile[1];
			  tempGate.setDelay(1);
			  tempGate.setCost(1);
			  gates[0] = tempGate;			
		}catch (IOException e){
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
		return gates;
	}

	public GateFile[] getGates() {
		return gates;
	}

	public void setGates(GateFile[] gates) {
		this.gates = gates;
	}
	
}
