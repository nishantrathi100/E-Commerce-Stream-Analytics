/**
 * 
 */
package simulator.model;

/**
 * @author nishantrathi
 *
 */
public class UserSimulator implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run(){
		try {
			long ONE_MINUTE = 1 * 1000;

			User user = new User();
			
			while(!user.getItemToVisit().isEmpty()) {
				LogGenerator.generateViewItemLog(user);
				Thread.sleep((int)Math.random() * ONE_MINUTE);
			}
			
			while (user.getNumberOfItemToAddToCart() != 0) {
				LogGenerator.generateAddItemLog(user);
				Thread.sleep((int)Math.random() * ONE_MINUTE);
			}
			
			if(user.isGoingToOrder()) {
				Thread.sleep((int)Math.random() * ONE_MINUTE);
				LogGenerator.generateOrderPlacedLog(user);
			}
			
			if(user.isGoingToOrder() && user.isOrderSuccess()) {
				Thread.sleep((int)Math.random() * ONE_MINUTE);
				LogGenerator.generateOrderSuccessLog(user);
			}
			
			if(user.isGoingToOrder() && !user.isOrderSuccess()) {
				Thread.sleep((int)Math.random() * ONE_MINUTE);
				LogGenerator.generateOrderFailureLog(user);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
