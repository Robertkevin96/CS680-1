package edu.umb.cs680.hw06;

public class DrawerOpen implements State{
	
	private static DrawerOpen instance = null;

	public static DrawerOpen getInstance() {
		if (instance == null)
			instance = new DrawerOpen();
		return instance;
	}

	@Override
	public void openCloseButtonPushed() {
		// TODO Auto-generated method stub
		dvdPlayer.close();
		dvdPlayer.changeState(DrawerClosedNotPlaying.getInstance());
	}

	@Override
	public void playButtonPushed() {
		// TODO Auto-generated method stub
		dvdPlayer.close();
		dvdPlayer.play();
		dvdPlayer.changeState(DrawerClosedPlaying.getInstance());
	}

	@Override
	public void stopButtonPushed() {
		// TODO Auto-generated method stub
		//Just displaying stopped message and Doing nothing to its State
		dvdPlayer.stop();
		
		
	}
	

}
