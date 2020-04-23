package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State{
	
	private static DrawerClosedPlaying instance = null;

	public static DrawerClosedPlaying getInstance() {
		if (instance == null)
			instance = new DrawerClosedPlaying();
		return instance;
	}

	@Override
	public void openCloseButtonPushed() {
		// TODO Auto-generated method stub
		dvdPlayer.stop();
		dvdPlayer.open();
		dvdPlayer.changeState(DrawerOpen.getInstance());
		
	}

	@Override
	public void playButtonPushed() {
		// TODO Auto-generated method stub
		//Just displaying playing message and Doing nothing to its State
		dvdPlayer.play();
		
	}

	@Override
	public void stopButtonPushed() {
		// TODO Auto-generated method stub
		dvdPlayer.stop();
		dvdPlayer.changeState(DrawerClosedNotPlaying.getInstance());
	}

}
