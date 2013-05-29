package com.example.winehipster;

import java.util.Date;


import android.location.Location;

import com.google.android.gms.plus.model.people.Person.Image;

/**
 * @author Kenneth
 *
 */

/*
 * The Entry class will represent "entries" that the user has
 * entered into the Journal. It will contain all the items that the user
 * has entered with components stored in local variables.  
 *
 * Note: In the actual implementation this will have to be a nested class
 * so that Journal can access it's private variables. 
 */
public class Entry {

  /*
   * This is a list of all the local variables for an entry. Each has an
   * accompanied comment explaining if any validation occurs and which
   * have getters and setters. Getter and setters will not be explicitly 
   * written out inside this header file however they are needed. All
   * getters and setters will be the standard getObject() and setObject().
   * Some of the setObject methods will throw exceptions if the input
   * is not valid, these will be noted. Some methods, which are
   * also noted, do not have setters but all should have setters.
   *
   * The values stored here should map _directly_ to the table in the database.
   *
   */

  /*
   * Description
   * This is the vintage of the wine, it should be a year and it can not 
   * take place in the future. After a quick google search, it seems reasonable
   * to limit these values to 1700 to the present day. If the value entered
   * is negative or out of range and exception is thrown. 
   */
  private int vintage;

  /*
   * Description: This is the rating for the wine, it is on a five star system 
   * so it is an int limited to the range 0-5. A 0 is counted as not rated,
   * so there is no such thing as a 0 rating, 0 is just the default value
   * that indicated no rating has been set. If the value supplied is out
   * of range an exception is thrown.
   * 
   */
  private int rating;

  /*
   * Description: This is the price it should be displayed with precision of
   * 2 for the cents, along with a $. Value must be positive.
   */
  private float price;

  /*
   * Description: This is the alcohol, it is also a value that should display
   * with two decimal points. 
   */
  private float alcohol_content;

 

  /*
   * Description: This is the name of the wine.
   */
  private String _name;

  /*
   * Description: This is the type of the wine (red, white, Rose etc..).
   */
  private String type;

  /*
   * Description: This is the place of origination for the wine. No validation
   * is done.
   */
  private String country_region;

  /*
   * Description: Serving temperature there should only be two 
   * options here: chilled or room temp. User must choose one, so no 
   * error checking.
   */
  private String serving_temp;

  /*
   * Description: This is the way that the wine looks, no validation.
   */
  private String appearance;

  /*
   * Description: Way the wine smells, no validation.
   */
  private String aroma;

  /*
   * Description: Way the wine tastes, no validation.
   */
  private String taste;

  /*
   * Description: This is a field where the _user_ can enter food
   * that goes well with the wine. No validation.
   */
  private String paired_with;

  /*
   * Description: This is a place where the user can store how they felt about
   * the wine in their own words.
   */
  private String opinion;

  /*
   * Description: This is a boolean value to indicate if it is a draft. This
   * will be set to move items from the draft view to the main entry view.
   * This will be used in the Journal class where a SQL query where find all
   * the entries for the view based on this bool. So when the entry screen
   * saves or save draft is chosen this needs to be changed accordingly. 
   */
  private Boolean is_draft;

  /*
   * Description: This should be found automatically when the entry is created
   * using the android geo-location API. If no location can be found then 
   * this is set to NULL and no location will be displayed. 
   */
  private String entry_location;

  /*
   * Description: This is the unique key generated in the constructor. It
   * is not shown to the user and should never be changed. This is the 
   * way the database knows which entry is which.
   */
  private int _id;

  /*
   * Description: This is the date that the entry was started. This is to
   * be automatically retrieved from the system and not modified.
   */
  private String entry_date;

  /*
   * Description: This is the photo that the user can optionally take of
   * the wine. It will be down-scaled (probably) and stored in the SQL 
   * database. No validation.
   */
  private byte[] _image;
  

  /*
   * This is the public constructor for the Entry class. Upon instantiation
   * the only thing it has to do is initialize the data fields of the class Entry to
   * a default value.
   */
  public Entry(int keyId, String name, String type, String country_region,String serving_temp, String appearance, String aroma,
			 String taste, String paired_with, String opinion, float alcohol_content, float price,
			 int vintage, int rating, boolean is_draft, String entry_location, String entry_date, byte[] image) {
	  this._id = keyId;
	  this._name = name;
	  this._image = image;
	  this.type = type;
	  this.country_region = country_region;
	  this.serving_temp = serving_temp;
	  this.appearance = appearance;
	  this.aroma = aroma;
	  this.taste = taste;
	  this.paired_with = paired_with;
	  this.opinion = opinion;
	  this.alcohol_content = alcohol_content;
	  this.price = price;
	  this.vintage = vintage;
	  this.rating = rating;
	  this.is_draft = is_draft;
	  this.entry_location = entry_location;
	  this.entry_date = entry_date;
	  

	 }
//Empty constructor
	 public Entry() {

	 }
	 
	 public Entry(int keyId) {
		  this._id = keyId;

		 }

  
  /**
   * @return the vintage
   */
  public int getVintage() {
  	return vintage;
  }


  /**
   * @param vintage the vintage to set
   */
  public void setVintage(int vintage) {
  	this.vintage = vintage;
  }


  /**
   * @return the rating
   */
  public int getRating() {
  	return rating;
  }


  /**
   * @param rating the rating to set
   */
  public void setRating(int rating) {
  	this.rating = rating;
  }


  /**
   * @return the price
   */
  public float getPrice() {
  	return price;
  }


  /**
   * @param price the price to set
   */
  public void setPrice(float price) {
  	this.price = price;
  }


  /**
   * @return the type
   */
  public String getType() {
  	return type;
  }


  /**
   * @param type the type to set
   */
  public void setType(String type) {
  	this.type = type;
  }


  /**
   * @return the country_region
   */
  public String getCountry_region() {
  	return country_region;
  }


  /**
   * @param country_region the country_region to set
   */
  public void setCountry_region(String country_region) {
  	this.country_region = country_region;
  }


  /**
   * @return the serving_temperature
   */
  public String getServing_temperature() {
  	return serving_temp;
  }


  /**
   * @param serving_temperature the serving_temperature to set
   */
  public void setServing_temperature(String serving_temperature) {
  	this.serving_temp = serving_temperature;
  }


  /**
   * @return the appearance
   */
  public String getAppearance() {
  	return appearance;
  }


  /**
   * @param appearance the appearance to set
   */
  public void setAppearance(String appearance) {
  	this.appearance = appearance;
  }


  /**
   * @return the aroma
   */
  public String getAroma() {
  	return aroma;
  }


  /**
   * @param aroma the aroma to set
   */
  public void setAroma(String aroma) {
  	this.aroma = aroma;
  }


  /**
   * @return the taste
   */
  public String getTaste() {
  	return taste;
  }


  /**
   * @param taste the taste to set
   */
  public void setTaste(String taste) {
  	this.taste = taste;
  }


  /**
   * @return the paired_with
   */
  public String getPaired_with() {
  	return paired_with;
  }


  /**
   * @param paired_with the paired_with to set
   */
  public void setPaired_with(String paired_with) {
  	this.paired_with = paired_with;
  }


  /**
   * @return the opinion
   */
  public String getOpinion() {
  	return opinion;
  }


  /**
   * @param opinion the opinion to set
   */
  public void setOpinion(String opinion) {
  	this.opinion = opinion;
  }


  /**
   * @return the is_draft
   */
  public Boolean getIs_draft() {
  	return is_draft;
  }


  /**
   * @param is_draft the is_draft to set
   */
  public void setIs_draft(Boolean is_draft) {
  	this.is_draft = is_draft;
  }


  /**
   * @return the entry_location
   */
  public String getEntry_location() {
  	return entry_location;
  }


  /**
   * @param entry_location the entry_location to set
   */
  public void setEntry_location(String entry_location) {
  	this.entry_location = entry_location;
  }


  /**
   * @return the db_key
   */
  public int getID() {
  	return _id;
  }


  /**
   * @param db_key the db_key to set
   */
  public void setID(int db_key) {
  	this._id = db_key;
  }


  /**
   * @return the entry_date
   */
  public String getEntry_date() {
  	return entry_date;
  }


  /**
   * @param entry_date the entry_date to set
   */
  public void setEntry_date(String entry_date) {
  	this.entry_date = entry_date;
  }


  /**
   * @return the photo
   */
  public byte[] getPhoto() {
  	return _image;
  }


  /**
   * @param photo the photo to set
   */
  public void setPhoto(byte[] photo) {
  	this._image = photo;
  }



/**
 * @return the alcohol_content
 */
public float getAlcohol_content() {
	return alcohol_content;
}


/**
 * @param alcohol_content the alcohol_content to set
 */
public void setAlcohol_content(float alcohol_content) {
	this.alcohol_content = alcohol_content;
}


/**
 * @return the wine
 */
public String getWine() {
	return _name;
}


/**
 * @param wine the wine to set
 */
public void setWine(String wine) {
	this._name = wine;
}

} 
