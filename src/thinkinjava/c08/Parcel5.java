package thinkinjava.c08;

/**
 * 在任意作用域内嵌入一个内部类
 * @author chenxx
 *
 */
public class Parcel5 {

	private void internalTracking(boolean b){
		if (b) {
			class TrackingSlip{
				private String id;

				public TrackingSlip(String id) {
					this.id = id;
				}
				String getSlip(){
					return id;
				}
			}
			TrackingSlip ts = new TrackingSlip("slip");
			String s = ts.getSlip();
		}
	}
	
	public void track(){
		internalTracking(true);
	}
	
	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		p.track();
	}

}
