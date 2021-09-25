package mvc.models;

public class Model {
	private float x, y;
	
	public Model() {
		x = 0;
		y = 0;
	}
	public Model(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public void incX() {
		x++;
	}
	public void incY() {
		y++;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	
	public void setX(float X) {
		x = X;
	}
	public void setY(float Y) {
		y = Y;
	}
	public void Plus() {
		x = x + y;
	}
	public void Minus() {
		x = x - y;
	}
	public void Time() {
		x = x * y;
	}
	public void Divide() {
		x = x/y;
	}
	public void Dola(float X) {
		x = X*(float)23.310;
	}
	public void Gthua(int X) {
		x = (float) tinhgt(X);
	}
	public int tinhgt(int X) {
		if (X<=1) return 1;
		else return X*(X-1);
	}
	
	public int getIntX(float X) {
		return (int) X;
	}
}
