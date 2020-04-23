package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State{
	
	private static DrawerClosedNotPlaying instance = null;
	
	public static DrawerClosedNotPlaying getInstance() {
		if (instance == null)
			instance = new DrawerClosedNotPlaying();
		return instance;
	}

	@Override
	public void openCloseButtonPushed() {
		// TODO Auto-generated method stub
		dvdPlayer.open();
		dvdPlayer.changeState(DrawerOpen.getInstance());
	}

	@Override
	public void playButtonPushed() {
		// TODO Auto-generated method stub
		dvdPlayer.play();
		dvdPlayer.changeState(DrawerClosedPlaying.getInstance());
	}

	@Override
	public void stopButtonPushed() {
		// TODO Auto-generated method stub
		dvdPlayer.stop();
	}
	
	

}
