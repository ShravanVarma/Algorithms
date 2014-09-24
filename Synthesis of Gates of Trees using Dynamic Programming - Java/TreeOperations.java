import java.util.ArrayList;
import java.util.List;

public class TreeOperations {

	private Float[] arrival;
	private List<Tree> leaves;
	private float delay;
	private int gateMin;
	
	public TreeOperations(){}
	public TreeOperations(String args, String args2){
		ReadLibrary readLibrary = new ReadLibrary();
		readLibrary.readLibrary(args2);
		ReadInput readInput = new ReadInput();
		readInput.readInput(args);
		this.setArrival(readInput.getPinArrival());
		this.setDelay(this.minDelay(readLibrary.getGates()));
		this.setLeaves(this.createLeaves());
		
	}
	
	private float minDelay( GateFile[] gate ){
		float min = gate[0].getDelay();
		for(int i=0; i<gate.length; i++){
		if (min > gate[i].getDelay()){
			min = gate[i].getDelay();
			this.setGateMin(i);
		}
		}
		
		return min;
	}
	
	
	private List<Tree> createLeaves(){
		List<Tree> tempLeaves = new ArrayList<Tree>();
		Tree tree;
		for(Float f: this.getArrival()){
			tree = new Tree();
			tree.setTime(f);
			tree.setLeft(null);
			tree.setRight(null);
			tree.setGate("");
			tempLeaves.add(tree);
			
		}
		return tempLeaves;
	}
	
	
	public Float[] getArrival() {
		return arrival;
	}
	public void setArrival(Float[] arrival) {
		this.arrival = arrival;
	}
	public List<Tree> getLeaves() {
		return leaves;
	}
	public void setLeaves(List<Tree> leaves) {
		this.leaves = leaves;
	}
	public float getDelay() {
		return delay;
	}
	public void setDelay(float delay) {
		this.delay = delay;
	}
	public int getGateMin() {
		return gateMin;
	}
	public void setGateMin(int gateMin) {
		this.gateMin = gateMin;
	}
	
}
