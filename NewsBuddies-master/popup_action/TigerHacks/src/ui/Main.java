package ui;

import db.Dao;
import db.Data;

public class Main {

	public static void main(String[] args) {
	Data bp = new Data();
	Dao db = new Dao();
	
	bp.setUrl("www.wiki.com");
	bp.setUsername("jweck");
	bp.setPassword("abab");
	bp.setEmail("adkfjaskldfjkf@fasf.vfd");
	bp.setBrating(1);
	bp.setQrating(0);
	bp.setRelvrating(1);
	bp.setRelyrating(1);
	
	db.createUrl(bp);
	db.createUser(bp);
	db.createRating(bp);
	
	bp.clearUrl();
	bp.clearRating();
	bp.clearUser();
	
	db.loadRating(bp);
	db.loadUrl(bp);
	db.loadUser(bp);
	
	bp.setUrl("www.wiki.org");
	bp.setUsername("jwek");
	bp.setPassword("ab");
	bp.setEmail("adkfjaskjkf@fasf.vfd");
	bp.setBrating(1);
	bp.setQrating(0);
	bp.setRelvrating(0);
	bp.setRelyrating(1);
	
	db.updateUrl(bp);
	db.updateUser(bp);
	db.updateRating(bp);
	
	bp.setUrlID(5);
	bp.setUserID(6);
	bp.setRatingID(3);
	
	db.deleteUrl(bp);
	db.deleteUser(bp);
	db.deleteRating(bp);
	
	
	
	
	
	}

}
