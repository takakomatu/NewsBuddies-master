package db;

public class Data {
private String url;
private int urlID;
private int brating;
private int ratingID;
private int userID;
private int qrating;
private int relvrating;
private int relyrating;
private int password;
private String username;
private String email;

public String getUrl() {
	return url;
}
public void setUrl(String pUrl) {
	url = pUrl;
}
public int getUrlID() {
	return urlID;
}
public void setUrlID(int pUrlID) {
	urlID = pUrlID;
}
public int getBrating() {
	return brating;
}
public void setBrating(int pRating) {
	brating = pRating;
}
public int getRatingID() {
	return ratingID;
}
public void setRatingID(int pRatingID) {
	ratingID = pRatingID;
}
public int getUserID() {
	return userID;
}
public void setUserID(int pUser) {
	userID = pUser;
}
public int getQrating() {
	return qrating;
}
public void setQrating(int pQrating) {
	qrating = pQrating;
}
public int getRelvrating() {
	return relvrating;
}
public void setRelvrating(int pRelvrating) {
	relvrating = pRelvrating;
}
public int getRelyrating() {
	return relyrating;
}
public void setRelyrating(int pRelyrating) {
	relyrating = pRelyrating;
}
public int getPassword() {
	return password;
}
public void setPassword(String pPassword) {
	int hash = 0;
	for (int x = 0; x < pPassword.length(); x++) {
		if (x == 0) {
			hash = hash + (pPassword.length() * pPassword.charAt(x));
		} else {
			hash = hash + (31 * (pPassword.length() - x) * pPassword.charAt(x));
		}
	}
	password = hash;
}
public String getUsername() {
	return username;
}
public void setUsername(String pUsername) {
	username = pUsername;
}
public String getEmail() {
	return email;
}
public void setEmail(String pEmail) {
	email = pEmail;
}
public void clearUrl() {
	setUrlID(0);
	setUrl("");
}
public void clearRating() {
	setUrlID(0);
	setUserID(0);
	setBrating(0);
	setQrating(0);
	setRelvrating(0);
	setRelyrating(0);
}
public void clearUser() {
	setUserID(0);
	setUsername("");
	setPassword("");
	setEmail("");
}
}
