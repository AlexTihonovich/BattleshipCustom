package Elements;

public enum Diraction {
	Up,Down,Rigth, Left;

	public int get() {
		// TODO Auto-generated method stub
		switch(this){
		case Up:
		case Left:
			return -1;
		case Down:
		case Rigth:
			return 1;
			
		}
		return 0;
	}
}
