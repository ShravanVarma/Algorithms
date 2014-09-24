import java.util.List;



public class TreeOutput {
	private List<Tree> tree;
	private Tree root;
	
	
	
	public TreeOutput(String args, String args2){
		TreeOperations buildTree = new TreeOperations(args,args2);
		this.setTree(buildTree.getLeaves());
		this.setRoot(this.algoGates(this.getTree(),args, args2));
		this.printOutput(this.getRoot());
	}
	
	public float max(float a, float b){
		if (a>b) {
			return a;
		} else {
			return b;
		}
	}
	
	private void printOutput( Tree tree){
		if (tree != null) {
			printOutput(tree.getLeft());
			printOutput(tree.getRight());
			System.out.print(tree.getGate()+ " " +tree.getTime()+ " ");
		}
	}
	
	private Tree algoGates(List<Tree> tree,String args, String args2){
		int i=0, j=1;
		float sum = 0;
		float max = 0;
		TreeOperations buildTree = new TreeOperations(args,args2);
		if(tree.size() == 1){
			return tree.get(0);
		}
		try{
			sum = tree.get(0).getTime() + tree.get(1).getTime();
			for(int k=2; k<tree.size(); k++)
			{
				if(sum > (tree.get(k-1).getTime()+ tree.get(k).getTime()))
				{
					sum = tree.get(k-1).getTime()+tree.get(k).getTime();
					i = k-1;
					j = k;
				}
			}
			max = this.max(tree.get(i).getTime(), tree.get(j).getTime()) + buildTree.getDelay() ;
			Tree tempTree = new Tree();
			tempTree.setTime(max);
			tempTree.setLeft(tree.remove(i));
			tempTree.setRight(tree.remove(i));
			tempTree.setGate("g"+ buildTree.getGateMin());
			tree.add(i,tempTree);
			this.algoGates(tree,args,args2);
		}catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
		return tree.get(0);
	}
	
	public List<Tree> getTree() {
		return tree;
	}
	public void setTree(List<Tree> tree) {
		this.tree = tree;
	}
	public Tree getRoot() {
		return root;
	}
	public void setRoot(Tree root) {
		this.root = root;
	}
	

}
